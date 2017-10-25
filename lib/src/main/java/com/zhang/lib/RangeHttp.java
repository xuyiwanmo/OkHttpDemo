package com.zhang.lib;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 德医互联 on 2017/10/25.
 */

public class RangeHttp {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder().build();

        Request request = new Request.Builder()
                .url(Constans.TEST_IMG)
                .addHeader("Accept-Encoding","identity")  //只有非chunke的时候 才有效果
                .addHeader("Range","bytes=0-10")//设置长度   从0开始
                .build();

        Response response = client.newCall(request).execute();

        LogUtil.logHeads(response);
        LogUtil.logBody(response);
        LogUtil.logLength(response);
    }
}
