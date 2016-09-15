package spring.manager;

import spring.entities.Account;
import spring.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by spring on 13.07.2016.
 */
@Service
public class AccountManager {
    @Autowired
    AccountRepository accountRepository;

    public boolean createUser(String login, String password, String userName) {
        Account account = new Account();
        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
        account.setLogin(login);
        account.setPassword(md5PasswordEncoder.encodePassword(password, null));
        account.setName(userName);
        try {
            Account a = accountRepository.save(account);
        } catch (Exception e) {
            return false;
        }


        return true;

    }
}
