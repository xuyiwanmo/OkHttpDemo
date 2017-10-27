package com.zhang.downloadfile.download;

import com.zhang.downloadfile.http.DownloadCallback;

/**
 * Created by 德医互联 on 2017/10/27.
 *
 * 下载的核心都放在这里处理
 */

public class DownloadRunnable implements Runnable {
    private long mStart;
    private long mEnd;
    private String mUrl;
    private DownloadCallback mCallback;

    public DownloadRunnable(long start, long end, String url, DownloadCallback callback) {
        mStart = start;
        mEnd = end;
        mUrl = url;
        mCallback = callback;
    }

    @Override
    public void run() {
      Httpm
    }
}
