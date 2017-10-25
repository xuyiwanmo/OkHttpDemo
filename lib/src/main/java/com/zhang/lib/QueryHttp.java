package com.zhang.lib;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 德医互联 on 2017/10/24.
 */

public class QueryHttp {
    public static void main(String[] args) {

        //https://api.heweather.com/x3/weather?city=beijing&key=d17ce22ec5404ed883e1cfcaca0ecaa7
        OkHttpClient client = new OkHttpClient();
        HttpUrl httpUrl = HttpUrl.parse(Constans.TEST_URL2)
                .newBuilder()
                .addQueryParameter("city", "beijing")
                .addQueryParameter("key","d17ce22ec5404ed883e1cfcaca0ecaa7")
                .build();
        System.out.println(httpUrl.toString());
        Request request=new Request.Builder().url(httpUrl).build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                System.out.println("sendRequest result: " + response.body().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
