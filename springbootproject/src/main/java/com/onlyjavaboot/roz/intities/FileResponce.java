package com.onlyjavaboot.roz.intities;

public class FileResponce {

    private String fileName;
    private String message;

    public FileResponce(String fileName, String message) {
        this.fileName = fileName;
        this.message = message;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "FileResponce{" +
                "fileName='" + fileName + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}