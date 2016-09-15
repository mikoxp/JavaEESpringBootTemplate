package moles.repositories;

import moles.entities.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by moles on 25.07.2016.
 */
@Repository
public interface GroupsRepository extends JpaRepository<Groups, Integer>{
    Groups findByName(String name);
}
