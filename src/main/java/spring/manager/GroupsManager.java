package spring.manager;

import spring.repositories.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by spring on 28.07.2016.
 */
@Service
public class GroupsManager {

    @Autowired
    GroupsRepository groupsRepository;
}
