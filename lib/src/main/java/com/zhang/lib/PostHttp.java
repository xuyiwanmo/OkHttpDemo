package com.zhang.lib;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 德医互联 on 2017/10/24.
 */

public class PostHttp {
    public static void main(String args[]) {
        OkHttpClient client = new OkHttpClient();

        FormBody body = new FormBody.Builder()
                .add("url", "test URl")
                .add("desc", "我是描述")
                .add("who", "提交者是我")
                .add("type","Android")
                .add("debug", "false")
                .build();
        Request request = new Request.Builder()
                .url("https://gank.io/api/add2gank")
                .post(body)
                .build();
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
