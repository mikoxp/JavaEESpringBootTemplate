package moles.contorolers;

import moles.manager.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private AccountManager accountManager;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Nieprawidłowy login lub hasło!!!!!!!");
        }
        if (logout != null) {
            model.addObject("ms", "Wylogowano");
        }
        model.setViewName("login");

        return model;

    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public ModelAndView regestration() {
        ModelAndView model = new ModelAndView();
        model.setViewName("reg");
        return model;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createAcount(
            @RequestParam(value = "name", required = false) String userName,
            @RequestParam(value = "email", required = false) String login,
            @RequestParam(value = "password", required = false) String password) {

        ModelAndView model = new ModelAndView();
        boolean result = accountManager.createUser(login, password, userName);
        if (result) {
            model.setViewName("login");
        } else {
            model.addObject("error", "Podany email jest zajety");
            model.setViewName("reg");
        }
        return model;
    }


}
