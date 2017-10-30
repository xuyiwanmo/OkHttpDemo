package com.zhang.downloadfile.http;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 德医互联 on 2017/10/30.
 */

public interface HttpResponse extends Header {
    HttpStatus getStatus();

    String getStatusMsg();

    InputStream getBody() throws IOException;

    void colse();

    long getContentLength();
}
