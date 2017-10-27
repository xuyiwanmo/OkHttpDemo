package com.zhang.downloadfile.http;

import java.io.File;

/**
 * Created by 德医互联 on 2017/10/26.
 */

public interface DownloadCallback {
    void success(File file);
    void fail(int errorCode,String errorMessage);
    void progress(int progress);
}
