package com.pavelzzzzz.another_attempt_to_do_something_normal.service.text_code_transformations;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao.TblDESTextTranslationEntityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblDESTextTranslationEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId;
import org.jsoup.nodes.TextNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Scope(value = "singleton")
@Component
public class TextToCodeTransformer implements Transformer {

    @Autowired
    private TblDESTextTranslationEntityDao tblDESTextTranslationEntityDao;

    @Override
    public String transform(String text, int languageId) {
        if (text != ""){
            return String.format("/~%d~/",
                    tblDESTextTranslationEntityDao
                        .create_tblDESTextTranslationEntity(
                            -1, languageId, text));
        }
        return text;
    }
}
