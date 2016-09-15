package spring.repositories;

import spring.entities.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by spring on 25.07.2016.
 */
@Repository
public interface GroupsRepository extends JpaRepository<Groups, Integer>{
    Groups findByName(String name);
}
