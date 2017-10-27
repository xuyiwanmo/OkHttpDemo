package com.zhang.downloadfile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zhang.downloadfile.file.FileStorageManager;
import com.zhang.downloadfile.utils.Logger;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File file= FileStorageManager.getInstance().getFileByName("http://www.imooc.com");
        //file path:   /storage/emulated/0/Android/data/com.zhang.downloadfile/cache/ c57cccddb665d07a8f940fc69c4c41c3
        Logger.debug("file path:   "+file.getAbsolutePath());
    }
}
