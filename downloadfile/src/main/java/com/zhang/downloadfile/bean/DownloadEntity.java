package com.zhang.downloadfile.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 德医互联 on 2017/10/30.
 */

@Entity
public class DownloadEntity {
    @Id(autoincrement = true)
    private Long id;
    private long startPosition;
    private long endPosition;
    private String downloadUrl;
    @Generated(hash = 1283523781)
    public DownloadEntity(Long id, long startPosition, long endPosition,
            String downloadUrl) {
        this.id = id;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.downloadUrl = downloadUrl;
    }
    @Generated(hash = 1671715506)
    public DownloadEntity() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public long getStartPosition() {
        return this.startPosition;
    }
    public void setStartPosition(long startPosition) {
        this.startPosition = startPosition;
    }
    public long getEndPosition() {
        return this.endPosition;
    }
    public void setEndPosition(long endPosition) {
        this.endPosition = endPosition;
    }
    public String getDownloadUrl() {
        return this.downloadUrl;
    }
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

}
