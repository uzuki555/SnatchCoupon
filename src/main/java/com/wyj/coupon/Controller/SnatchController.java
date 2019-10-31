package com.wyj.coupon.Controller;

import com.wyj.coupon.Snatch.JdSnatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
            @RequestParam("minute") Integer minute ,
            Model model){
        model.addAttribute("couponUrl",couponUrl);
        model.addAttribute("cookie",cookie);
        JdSnatch jdSnatch = new JdSnatch(couponUrl, cookie);
        Timer timer = new Timer();
        long delay=0;
        long period=1;
        System.out.println("开抢");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long timestamp = 0;
        long diff = 0;
        long Dhour = 0;
        long Dmin=0;
        long Dsec = 0;
        long Dday=0;
        long remain=0;
        try {
            Date date = df.parse("2019-10-31 15:59:55");
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            timestamp=cal.getTimeInMillis();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        diff = timestamp-System.currentTimeMillis();
//        System.out.println(System.currentTimeMillis());
//        System.out.println(timestamp);
       remain = diff%86400000;
       Dhour = remain/3600000;
       remain=remain%3600000;
       Dmin = remain/60000;
       if(remain>60000){
           remain=remain%60000;
       }
       Dsec = remain/1000;
        System.out.println(Dhour+"小时"+Dmin+"分"+Dsec+"秒后执行");
        timer.schedule(jdSnatch,diff,1);


        return "ok";
    }
}
