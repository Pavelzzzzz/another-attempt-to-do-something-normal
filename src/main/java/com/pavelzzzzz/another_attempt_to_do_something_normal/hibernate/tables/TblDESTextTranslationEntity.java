package com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
        name = "do_create_tblDESTextTranslationEntity",
        procedureName = "create_tblDESTextTranslationEntity",
        parameters = {
            @StoredProcedureParameter( name = "textId",  type = int.class,  mode = ParameterMode.IN),
            @StoredProcedureParameter( name = "languageId",  type = int.class,  mode = ParameterMode.IN),
            @StoredProcedureParameter( name = "textTranslation",  type = String.class,  mode = ParameterMode.IN),
            @StoredProcedureParameter( name = "appointedTextId",  type = int.class,  mode = ParameterMode.OUT)
        }),

})

@Entity
@Table(name = "tblDESTextTranslation", schema = "news_blog")
//@IdClass(TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId.class)
public class TblDESTextTranslationEntity {

    @EmbeddedId
    private TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId
        primaryKeyTextIdLanguageId;
    @NotBlank
    private String textTranslation;

    public TblDESTextTranslationEntity() {
    }

    public TblDESTextTranslationEntity(
        TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId primaryKeyTextIdLanguageId,
        @NotBlank String textTranslation) {
        this.primaryKeyTextIdLanguageId = primaryKeyTextIdLanguageId;
        this.textTranslation = textTranslation;
    }

    public TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId getPrimaryKeyTextIdLanguageId() {
        return primaryKeyTextIdLanguageId;
    }

    public void setPrimaryKeyTextIdLanguageId(
        TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId primaryKeyTextIdLanguageId) {
        this.primaryKeyTextIdLanguageId = primaryKeyTextIdLanguageId;
    }

    public String getTextTranslation() {
        return textTranslation;
    }

    public void setTextTranslation(String textTranslation) {
        this.textTranslation = textTranslation;
    }

}

