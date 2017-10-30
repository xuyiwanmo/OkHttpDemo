package com.zhang.downloadfile.download;

import com.zhang.downloadfile.bean.DownloadEntity;
import com.zhang.downloadfile.file.FileStorageManager;
import com.zhang.downloadfile.http.DownloadCallback;
import com.zhang.downloadfile.http.HttpManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import okhttp3.Response;

/**
 * Created by 德医互联 on 2017/10/27.
 * <p>
 * 下载的核心都放在这里处理
 */

public class DownloadRunnable implements Runnable {
    private long mStart;
    private long mEnd;
    private String mUrl;
    private DownloadCallback mCallback;
    private DownloadEntity mDownloadEntity;


    public DownloadRunnable(long start, long end, String url, DownloadCallback callback, DownloadEntity downloadEntity) {
        mStart = start;
        mEnd = end;
        mUrl = url;
        mCallback = callback;
        mDownloadEntity = downloadEntity;
    }

    @Override
    public void run() {
        Response response = HttpManager.getInstance().syncRequest(mUrl, mStart, mEnd);
        if (response == null && mCallback != null) {
            mCallback.fail(HttpManager.NETWORK_ERROR_CODE, "网络出了问题");
            return;
        }
        File file = FileStorageManager.getInstance().getFileByName(mUrl);

        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
            int len;
            byte[] buffer = new byte[1024 * 500];
            InputStream inputStream = response.body().byteStream();
            while ((len = inputStream.read(buffer, 0, buffer.length)) != -1) {
                randomAccessFile.write(buffer, 0, len);
            }

            mCallback.success(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
