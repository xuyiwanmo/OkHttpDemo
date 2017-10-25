package com.zhang.lib;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 德医互联 on 2017/10/24.
 */

public class HeadHttp {
    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(Constans.TEST_URL)
                .addHeader(Constans.USER_AGENT, "from zhanghua http")
                .addHeader(Constans.ACCEPT, "text/plain,text/html")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {

                    Headers headers = response.headers();
                    for (int i = 0; i < headers.size(); i++) {
                        System.out.println(headers.name(i) + ":" + headers.value(i));
                    }
                }
            }
        });
    }

}
