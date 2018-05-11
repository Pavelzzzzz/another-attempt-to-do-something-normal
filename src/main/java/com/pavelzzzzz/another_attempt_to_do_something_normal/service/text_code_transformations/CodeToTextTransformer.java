package com.pavelzzzzz.another_attempt_to_do_something_normal.service.text_code_transformations;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao.TblDESTextTranslationEntityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId;
import org.jsoup.nodes.TextNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "singleton")
@Component
public class CodeToTextTransformer implements Transformer {

    @Autowired
    private TblDESTextTranslationEntityDao tblDESTextTranslationEntityDao;

    @Override
    public String transform(String code, int languageId) {
        if (code.startsWith("/~") &&
            code.endsWith("~/")) {
            int textElementId =
                Integer.parseInt(
                    code.replaceAll("\\D", ""));
            return tblDESTextTranslationEntityDao.getByPrimaryKeyTextIdLanguageId(
                new TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId(
                    textElementId, languageId))
                .getTextTranslation();
        }
        return code;
    }
}
