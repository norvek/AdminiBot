package io.dojogeek.adminibot.validators;


import io.dojogeek.adminibot.R;

public class CompoundValidatorsFactory {

    static RequiredValueValidator requiredValueValidator = new RequiredValueValidator();

    public static CompoundValidator emailValidator() {

        CompoundValidator compoundValidator = new CompoundValidator();
        compoundValidator.addValidator(LenghtValidator.withMaxLenght(ValidatorsValues.EMAIL_MAX_LENGTH).withErroMessage(R.string.error_wrong_length_email));
        compoundValidator.addValidator(RegexValidator.withRegexp(ValidatorsValues.EMAIL_REGEXP).withErroMessage(R.string.error_wrong_format_email));
        compoundValidator.addValidator(requiredValueValidator);

        return compoundValidator;
    }

    public static CompoundValidator nameValidator() {

        CompoundValidator compoundValidator = commonValidators();
        compoundValidator.addValidator(LenghtValidator.withMaxLenght(ValidatorsValues.NAME_MAX_LENGHT).withErroMessage(R.string.error_wrong_lenght_name));

        return compoundValidator;
    }

    public static CompoundValidator lastNameValidator() {

        CompoundValidator compoundValidator = commonValidators();
        compoundValidator.addValidator(LenghtValidator.withMaxLenght(ValidatorsValues.LAST_NAME_MAX_LENGHT).withErroMessage(R.string.error_wrong_lenght_last_name));

        return  compoundValidator;
    }

    private static CompoundValidator commonsValidators() {

        CompoundValidator compoundValidator = new CompoundValidator();
        compoundValidator.addValidator(RegexValidator.withRegexp(ValidatorsValues.ONLY_LETTERS_AND_SPACES).withErroMessage(R.string.error_wrong_format_name));
        compoundValidator.addValidator(requiredValueValidator);

        return compoundValidator;
    }

}
