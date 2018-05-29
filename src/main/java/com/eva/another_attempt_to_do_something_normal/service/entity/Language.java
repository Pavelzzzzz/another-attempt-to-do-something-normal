package com.eva.another_attempt_to_do_something_normal.service.entity;

public class Language {

    private int languageId;
    private String isoCode;

    public Language(int languageId, String isoCode) {
        this.languageId = languageId;
        this.isoCode = isoCode;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }
}
