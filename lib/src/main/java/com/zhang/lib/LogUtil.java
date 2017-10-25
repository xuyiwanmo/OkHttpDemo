package com.zhang.lib;

import okhttp3.Headers;
import okhttp3.Response;

/**
 * Created by 德医互联 on 2017/10/25.
 */

public class LogUtil {
    public static void i(String msg) {
        System.out.println(msg);
    }

    public static void logHeads(Response response) {
        Headers headers = response.headers();
        i("*****************  head   *****************");
        for (int i = 0; i < headers.size(); i++) {
            i(headers.name(i) + ":" + headers.value(i));
        }
    }

    public static void logBody(Response response) {
        i("*****************  body   *****************");
        i(response.body().toString());
    }

    public static void logBodyHeads(Response response) {
        logHeads(response);
        logBody(response);

    }

    public static void logLength(Response response) {
        i("*****************  contentLength   *****************");
        i(""+response.body().contentLength());
    }
}
