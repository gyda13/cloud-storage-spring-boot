package com.udacity.jwdnd.course1.cloudstorage.model;

import java.sql.Blob;

public class File {

    private Integer fileId;
    private String filename;
    private String contenttype;
    private String filesize;
    private byte[] filedata;
    private Integer userId;

    public File(Integer fileId, String filename, String contenttype, String filesize, byte[] filedata, Integer userId) {
        this.fileId = fileId;
        this.filename = filename;
        this.contenttype = contenttype;
        this.filesize = filesize;
        this.filedata = filedata;
        this.userId = userId;
    }

    public byte[] getFiledata() {
        return filedata;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getFileId() {
        return fileId;
    }

    public String getFilename() {
        return filename;
    }

    public String getContenttype() {
        return contenttype;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public void setFiledata(byte[] filedata) {
        this.filedata = filedata;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
