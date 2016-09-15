package moles.repositories;

import moles.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by moles on 25.07.2016.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
