package CustomValidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class addressConstraintValidator implements ConstraintValidator<CheckAddress, String> {

	
	private String prefix;
	@Override
	public void initialize(CheckAddress constraintAnnotation) {
		// TODO Auto-generated method stub
		prefix=constraintAnnotation.val();
	}
	
	@Override
	public boolean isValid(String fromuser, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		if(fromuser !=null)
		{
			return fromuser.startsWith(prefix);			
		}
		return false;
	}

}
