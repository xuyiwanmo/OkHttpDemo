package com.zhang.lib;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 德医互联 on 2017/10/24.
 */

public class AsyncHttp {
    /**
     * 同步请求  会阻塞当前的线程
     *
     * @param url
     */
    public static void sendRequest(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                System.out.println("sendRequest result: " + response.body().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 异步
     * @param url
     *
     * log->
     * current thread Id: 1
     * other thread Id: 15
     */
    public static void sendAysncRequest(String url) {
        System.out.println("current thread Id: " + Thread.currentThread().getId());
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    System.out.println("other thread Id: " + Thread.currentThread().getId());
                }
            }
        });
    }

    public static void main(String[] args) {
        sendRequest("http://www.imooc.com");
        sendAysncRequest("http://www.imooc.com");
    }
}
