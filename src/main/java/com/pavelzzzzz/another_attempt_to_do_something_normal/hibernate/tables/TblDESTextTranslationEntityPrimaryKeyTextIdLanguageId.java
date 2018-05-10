package com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId implements Serializable {

    private int textId;
    private int languageId;

    public TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId() {
    }

    public TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId(int textId, int languageId) {
        this.textId = textId;
        this.languageId = languageId;
    }

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
}
