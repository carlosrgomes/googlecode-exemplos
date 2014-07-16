package br.com.exemplo.validator;

import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

import br.com.exemplo.validator.bean.Pessoa;

public class TestValidation {
	
	@Test
	public void teste(){
		Locale.setDefault(new Locale("pt","BR"));
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Carlos");
		pessoa.setAno(1000);
		pessoa.setMes(13);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Pessoa>> constraintViolations = validator
                .validate(pessoa);

        // printing the results
        for (ConstraintViolation<Pessoa> constraintViolation : constraintViolations) {
            System.out.println(constraintViolation.getPropertyPath() + " -> "
                    + constraintViolation.getMessage());
        }

	}

}
