package spring.contorolers;

import spring.servise.MailsServise;
import spring.servise.RandomServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("test")
public class TestRestController {
    @Autowired
    MailsServise mailsServise;
    @Autowired
    RandomServise randomServise;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String test() {
        return "Test";
    }

    @RequestMapping(value = "/mail", method = RequestMethod.GET)
    public String testowa() {
        Map model = new HashMap();
        model.put("login", "test@test.pl");
        model.put("password", "12345");
        mailsServise.sendMailToRestartPassword("olesmichalxp@gmail.com", model);
        return "Wyslano";
    }

    @RequestMapping(value = "/random/{n}", method = RequestMethod.GET)
    public String randomNumber(@PathVariable("n") int n) {
        return randomServise.randomAlfaNumString(n);
    }

    @RequestMapping(value = "/p/{id}", method = RequestMethod.GET)
    public String testpath(@PathVariable("id") String itemId) {
        return itemId;
    }

}

