package com.wyj.coupon.Controller;

import com.wyj.coupon.Snatch.JdSnatch;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){

        return "index";
    }
}
