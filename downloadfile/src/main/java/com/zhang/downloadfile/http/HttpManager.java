package com.zhang.downloadfile.http;

import android.content.Context;

import com.zhang.downloadfile.file.FileStorageManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 德医互联 on 2017/10/27.
 */

public class HttpManager {
    public static final int NETWORK_ERROR_CODE = 0;
    private OkHttpClient mHttpClient;
    private Context mContext;

    private void init(Context context) {
        this.mContext = context;
    }

    //单例模式  start
    private HttpManager() {
        mHttpClient = new OkHttpClient();
    }

    private static class Holder {
        private static final HttpManager HTTP_MANAGER = new HttpManager();
    }

    public static HttpManager getInstance() {
        return Holder.HTTP_MANAGER;
    }
    //单例模式  end

    /**
     * 同步请求
     */
    public Response syncRequest(String url) {
        Request request = new Request.Builder().url(url)
                .build();
        try {
            return mHttpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 同步请求
     */
    public Response syncRequest(String url, long start, long end) {
        Request request = new Request.Builder().url(url)
                .addHeader("Range", "bytes=" + start + "-" + end)
                .build();
        try {
            return mHttpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 异步下载
     */
    public Response asyncRequest(String url, Callback callback) {
        Request request = new Request.Builder().url(url).build();
        mHttpClient.newCall(request).enqueue(callback);
        return null;
    }

    /**
     * 异步调用
     */
    public void asyncRequest(final String url, final DownloadCallback callback) {

        Request request = new Request.Builder().url(url).build();
        mHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                //非主线程
                if (!response.isSuccessful() && call != null) {
                    callback.fail(NETWORK_ERROR_CODE, "网络请求失败");
                }
                File file = FileStorageManager.getInstance().getFileByName(url);
                byte[] buffer = new byte[1024 * 500];
                int len;
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                InputStream inputStream = response.body().byteStream();
                while ((len = inputStream.read(buffer, 0, buffer.length)) != -1) {
                    fileOutputStream.write(buffer, 0, len);
                    fileOutputStream.flush();
                }
                callback.success(file);
            }
        });
    }
    /**
     * 异步调用 下载指定路径
     */
    public void asyncRequestRange(final String url, final DownloadCallback callback, long start , long end) {

        Request request = new Request.Builder().url(url)
                .addHeader("Range","bytes="+start+"-"+end)
                .build();
        mHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                //非主线程
                if (!response.isSuccessful() && call != null) {
                    callback.fail(NETWORK_ERROR_CODE, "网络请求失败");
                }
                File file = FileStorageManager.getInstance().getFileByName(url);
                byte[] buffer = new byte[1024 * 500];
                int len;
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                InputStream inputStream = response.body().byteStream();
                while ((len = inputStream.read(buffer, 0, buffer.length)) != -1) {
                    fileOutputStream.write(buffer, 0, len);
                    fileOutputStream.flush();
                }
                callback.success(file);
            }
        });
    }

}