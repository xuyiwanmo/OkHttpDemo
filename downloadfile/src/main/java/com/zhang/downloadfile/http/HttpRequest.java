package com.zhang.downloadfile.http;

import java.io.OutputStream;
import java.net.URI;

/**
 * Created by 德医互联 on 2017/10/30.
 */

public interface HttpRequest {
    HttpMethod getMethod();
    URI getUri();
    OutputStream getBody();

}
