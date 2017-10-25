package com.zhang.lib;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 德医互联 on 2017/10/25.
 */

public class CacheHttp {
    public static void main (String ags[]) throws IOException{
        int maxCacheSize=10*1024*1024;

        File file=new File("lib/cache");//需要文件夹
        if (!file.exists()) {
            file.createNewFile();
        }
        Cache cache=new Cache(file,maxCacheSize);
        OkHttpClient client=new OkHttpClient.Builder().cache(cache).build();
        Request request=new Request.Builder().url("http://www.qq.com")  //必须要支持缓存的网站
                //.cacheControl(new CacheControl.Builder().noCache().build()) //设置始终不要缓存
                .cacheControl(new CacheControl.Builder().maxStale(365, TimeUnit.DAYS).build()) // 设置一年365年内  只要是这个请求  都不会重复发送  这样都会采用缓存中的内容
                .build();//支持缓存的网站
        Response response=client.newCall(request).execute();

        String body1=response.body().string();//必须执行之后
        System.out.println("network response: " + response.networkResponse());
        System.out.println("cache  response: " + response.cacheResponse());
        System.out.println("----------------------------");

        Response response1=client.newCall(request).execute();
        String body2=response1.body().string();//必须执行之后
        System.out.println("network response: " + response1.networkResponse());
        System.out.println("cache  response: " + response1.cacheResponse());

    }
}
