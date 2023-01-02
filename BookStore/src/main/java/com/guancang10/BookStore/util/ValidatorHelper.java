package com.guancang10.BookStore.util;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ValidatorHelper {
    public static Validator validator;
    public static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    public static Validator getValidator(){
        if(validator == null){
            validator = validatorFactory.getValidator();
        }
        return validator;
    }

    private ValidatorHelper(){

    }
}
