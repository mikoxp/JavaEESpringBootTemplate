package spring.manager;

import spring.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by spring on 28.07.2016.
 */
@Service
public class RoleManager {
    @Autowired
    RoleRepository roleRepository;
}
