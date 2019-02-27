package dj.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DJLLXH on 2018/8/5.
 */
@Controller
public class UserController {
    @RequestMapping(value = "/index")
    public String index(Model model){
        System.out.println("###################");
        return "index";
    }
}
