package com.zhang.downloadfile.download;

import android.support.annotation.NonNull;

import com.zhang.downloadfile.bean.DownloadEntity;
import com.zhang.downloadfile.http.DownloadCallback;
import com.zhang.downloadfile.http.HttpManager;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by 德医互联 on 2017/10/27.
 */

public class DownloadManager {
    //单例模式  start
    private DownloadManager() {

    }

    private static class Holder {
        private static final DownloadManager DOWNLOAD_MANAGER = new DownloadManager();
    }

    public static DownloadManager getInstance() {
        return Holder.DOWNLOAD_MANAGER;
    }

    //单例模式  end
    public static final int CORE_THREAD = 3;
    public static final int MAX_THREAD = 4;
    //队列中放置10长度  也就是一共可以完成10+4个任务  建议指定一个长度

    private static ArrayBlockingQueue threadPoolExecutor = new ArrayBlockingQueue<Runnable>(10);
    //最大线程数  核心线程数  当前线程数存活时间
    private static final ThreadPoolExecutor sThreadPool = new ThreadPoolExecutor(
            CORE_THREAD,  //创建2两个核心线程  任务都是放到核心线程中去执行
            MAX_THREAD, //如果
            60,
            TimeUnit.MILLISECONDS,
            threadPoolExecutor, //按顺序执行  如果队列阻塞  则不执行
            new ThreadFactory() {
                private AtomicInteger mInteger = new AtomicInteger(1);

                @Override
                public Thread newThread(@NonNull Runnable r) {
                    Thread thread = new Thread(r, "download thread #" + mInteger.getAndIncrement());
                    return thread;
                }
            });

    public void download(String url, DownloadCallback downloadCallback) {
        HttpManager.getInstance().asyncRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

    //拆分下载  多下载
    public void divideDownload(long length, String url, DownloadCallback callback) {
        long eachSize = length / CORE_THREAD;
        for (int i = 0; i <= CORE_THREAD; i++) {
            DownloadEntity downloadEntity=new DownloadEntity();
            downloadEntity.setDownloadUrl(url);
            downloadEntity.setStartPosition(i*eachSize);
            if (i == CORE_THREAD-1){//如果是最后一段

                downloadEntity.setEndPosition(length-1);
                sThreadPool.execute(new DownloadRunnable(i*eachSize, length-1, url, callback,downloadEntity));
            }else{
                downloadEntity.setEndPosition((i+1)*eachSize-1);
                sThreadPool.execute(new DownloadRunnable(i*eachSize, (i+1)*eachSize-1, url, callback,downloadEntity));
            }

        }

    }

}
