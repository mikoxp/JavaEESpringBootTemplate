package moles.manager;

import moles.repositories.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by moles on 28.07.2016.
 */
@Service
public class GroupsManager {

    @Autowired
    GroupsRepository groupsRepository;
}
