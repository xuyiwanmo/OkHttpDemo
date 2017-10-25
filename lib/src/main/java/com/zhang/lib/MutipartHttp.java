package com.zhang.lib;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 德医互联 on 2017/10/24.
 */

public class MutipartHttp {
    public static void main(String ags[]){
        RequestBody imageBody=RequestBody.create(MediaType.parse("image/jpeg"),new File(""));

        MultipartBody body=new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("参数","值")
                .addFormDataPart("filename","girl.jpg",imageBody)
                .build();
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder()
                .url("")
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
