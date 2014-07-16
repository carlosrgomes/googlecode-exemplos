package br.com.exemplo.validator.bean.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.exemplo.validator.bean.annotations.CaseMode;
import br.com.exemplo.validator.bean.annotations.CheckCase;

public class CheckCaseValidator implements ConstraintValidator<CheckCase, String>{

	private CaseMode caseMode;

    public void initialize(CheckCase constraintAnnotation) {
        this.caseMode = constraintAnnotation.value();
    }

    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {

        if (object == null)
            return true;
        
        boolean isValid;
        if (caseMode == CaseMode.UPPER) {
            isValid = object.equals(object.toUpperCase());
        }
        else {
            isValid = object.equals(object.toLowerCase());
        }
        
        return isValid;
    }
}
