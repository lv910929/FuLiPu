package com.lv.fulipu.model;

import java.io.Serializable;

/**
 * Created by Lv on 2016/10/18.
 */
public class LibraryBean implements Serializable {

    private String libraryName;

    private String libraryUrl;

    public LibraryBean(String libraryName, String libraryUrl) {
        this.libraryName = libraryName;
        this.libraryUrl = libraryUrl;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getLibraryUrl() {
        return libraryUrl;
    }

    public void setLibraryUrl(String libraryUrl) {
        this.libraryUrl = libraryUrl;
    }
}
