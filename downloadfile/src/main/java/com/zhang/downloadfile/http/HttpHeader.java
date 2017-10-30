package com.zhang.downloadfile.http;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by 德医互联 on 2017/10/30.
 */

public class HttpHeader implements NameValueMap<String,String> {
    public final static String ACCEPT = "Accept";
    public final static String PRAGMA = "Pragma";
    public final static String PROXY_CONNECTION = "Proxy-Connection";
    public final static String USER_AGENT = "User-Agent";
    public final static String ACCEPT_ENCODING = "accept-encoding";
    public final static String CACHE_CONTROL = "Cache-Control";
    public final static String CONTENT_ENCODING = "Content-Encoding";
    public final static String CONNECTION = "Connection";
    public final static String CONTENT_LENGTH = "Content-length";

    public static final String CONTENT_TYPE = "Content-Type";

    @Override
    public String get(String name) {
        return null;
    }

    @Override
    public void set(String name, String value) {

    }

    @Override
    public void setAll(Map<String, String> map) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public String get(Object key) {
        return null;
    }

    @Override
    public String put(String key, String value) {
        return null;
    }

    @Override
    public String remove(Object key) {
        return null;
    }

    @Override
    public void putAll(@NonNull Map<? extends String, ? extends String> m) {

    }

    @Override
    public void clear() {

    }

    @NonNull
    @Override
    public Set<String> keySet() {
        return null;
    }

    @NonNull
    @Override
    public Collection<String> values() {
        return null;
    }

    @NonNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    //*****************************************

    public static String getACCEPT() {
        return ACCEPT;
    }

    public static String getPRAGMA() {
        return PRAGMA;
    }

    public static String getProxyConnection() {
        return PROXY_CONNECTION;
    }

    public static String getUserAgent() {
        return USER_AGENT;
    }

    public static String getAcceptEncoding() {
        return ACCEPT_ENCODING;
    }

    public static String getCacheControl() {
        return CACHE_CONTROL;
    }

    public static String getContentEncoding() {
        return CONTENT_ENCODING;
    }

    public static String getCONNECTION() {
        return CONNECTION;
    }

    public static String getContentLength() {
        return CONTENT_LENGTH;
    }

    public static String getContentType() {
        return CONTENT_TYPE;
    }


}
