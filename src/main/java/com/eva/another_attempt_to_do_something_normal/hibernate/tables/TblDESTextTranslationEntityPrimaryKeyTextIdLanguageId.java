package com.eva.another_attempt_to_do_something_normal.hibernate.tables;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;

@Embeddable
public class TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer textId;
    @NotBlank
    private int languageId;

    public TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId() {
    }

    public TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId(int languageId) {
        this.languageId = languageId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId)) {
            return false;
        }
        TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId that = (TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId) o;
        return textId == that.textId &&
            languageId == that.languageId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(textId, languageId);
    }
}
