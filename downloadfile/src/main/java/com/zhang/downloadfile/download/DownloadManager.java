package com.zhang.downloadfile.download;

import android.support.annotation.NonNull;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

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

    public static final int MAX_THREAD = 2;
    //最大线程数  核心线程数  当前线程数存活时间
    private static final ThreadPoolExecutor sThreadPool = new ThreadPoolExecutor(
            MAX_THREAD,
            MAX_THREAD,
            60,
            TimeUnit.MILLISECONDS,
            new SynchronousQueue<Runnable>(),
            new ThreadFactory() {
                private AtomicInteger mInteger=new AtomicInteger(1);
                @Override
                public Thread newThread(@NonNull Runnable r) {
                    Thread thread=new Thread(r,"download thread #"+mInteger.getAndIncrement());
                    return thread;
                }
            });


}
