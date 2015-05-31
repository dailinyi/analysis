package com.daily.analysis.model;

/**
 * Created by Daily on 2015/5/23.
 */
public class FileInfo {
    private String fileName;
    private String fileSize;
    private String mergeDate;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getMergeDate() {
        return mergeDate;
    }

    public void setMergeDate(String mergeDate) {
        this.mergeDate = mergeDate;
    }

    public FileInfo(String fileName) {
        this.fileName = fileName;
    }

    public FileInfo() {
    }

    public static FileInfo covertToFile(String dirString){
        FileInfo file = new FileInfo();
        String[] dirElements = dirString.split("\\s+");

        if (dirElements .length == 2){//总计
            //total 16M
            file.setFileName("["+dirElements[0]+"]");
            file.setFileSize(dirElements[1]);
            file.setMergeDate("-");
        } else if (dirElements.length == 9 ){
            //drwxr-xr-x 26 1044 1044  12K May 22 23:54 ruby-2.2.2
            file.setFileName(dirElements[8]);
            file.setFileSize(dirElements[4]);
            file.setMergeDate(dirElements[5] + " " + dirElements[6] + " " + dirElements[7]);

        } else if (dirElements.length == 8){
            //-rw-r--r-- 1 root root 5.8K 05-16 21:23 attack-responses.rules
            file.setFileName(dirElements[7]);
            file.setFileSize(dirElements[4]);
            file.setMergeDate(dirElements[5] + " " + dirElements[6]);
        }
        return file;
    }
}
