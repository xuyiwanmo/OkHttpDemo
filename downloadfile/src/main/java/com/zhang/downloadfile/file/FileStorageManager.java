package com.zhang.downloadfile.file;

import android.content.Context;
import android.os.Environment;

import com.zhang.downloadfile.utils.Logger;
import com.zhang.downloadfile.utils.MD5;

import java.io.File;
import java.io.IOException;

/**
 * Created by 德医互联 on 2017/10/26.
 */

public class FileStorageManager {
    private Context mContext;

    //单例模式 start
    private FileStorageManager() {

    }

    private static class Holder {
        private static final FileStorageManager FILE_STORAGE_MANAGER = new FileStorageManager();
    }

    public static FileStorageManager getInstance() {
        return Holder.FILE_STORAGE_MANAGER;
    }
    //单例模式 end

    public void init(Context context) {
        this.mContext = context;
    }

    public File getFileByName(String url) {
        File parent;
        //如果是挂载的sd卡
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            parent = mContext.getExternalCacheDir();
        } else {
            parent = mContext.getCacheDir();
        }
        Logger.debug("parent path: "+parent.getAbsolutePath());

        String fileName = MD5.generateCode(url);
        File file = new File(parent, fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
