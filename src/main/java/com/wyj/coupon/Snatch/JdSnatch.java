package com.wyj.coupon.Snatch;

import com.alibaba.fastjson.JSON;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.TimerTask;

@Component
public class JdSnatch extends TimerTask {
    private String couponUrl;
    private String cookie;

    public JdSnatch(String couponUrl, String cookie) {
        this.couponUrl = couponUrl;
        this.cookie = cookie;
    }

    public JdSnatch() {
    }

    @Override
    public void run() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(couponUrl)
                .header("cookie",cookie)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            System.out.println(string);
        } catch (IOException e) {

        }
    }
}
