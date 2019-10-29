package com.wyj.coupon.Controller;

import com.wyj.coupon.Snatch.JdSnatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

@Controller
public class SnatchController {
    @Autowired
    public JdSnatch jdSnatch;
    @PostMapping("/Snatch")
    @ResponseBody
    public String snatch(
            @RequestParam("couponUrl") String couponUrl,
            @RequestParam("cookie") String cookie,
            @RequestParam("hour") Integer hour ,
            @RequestParam("minute") Integer minute){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        System.out.println(simpleDateFormat.format(new Date()));
        Timer timer = new Timer();
        long delay=0;
        long period=250;
        System.out.println("开抢");
        timer.schedule(new JdSnatch(couponUrl,cookie),delay,period);


        return "ok";
    }
}
