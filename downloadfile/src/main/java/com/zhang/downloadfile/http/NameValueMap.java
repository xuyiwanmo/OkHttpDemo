package com.zhang.downloadfile.http;

import java.util.Map;

/**
 * Created by 德医互联 on 2017/10/30.
 */

public interface NameValueMap<K, V> extends Map<K, V> {
    String get(String name);

    void set(String name, String value);

    void setAll(Map<String, String> map);
}
