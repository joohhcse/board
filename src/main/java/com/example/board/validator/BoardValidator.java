package com.example.board.validator;

import com.example.board.model.entity.Boards;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

@Component
public class BoardValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Boards.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Boards b = (Boards) obj;
        if(StringUtils.isEmpty(b.getContent())) {
            errors.rejectValue("content", "key", "내용을 입력하세요");
        }
    }
}
