package io.dojogeek.adminibot.utils.validators;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;

import io.dojogeek.adminibot.R;
import io.dojogeek.adminibot.exceptions.ValidatorNullValueException;
import io.dojogeek.adminibot.validators.CompoundValidator;
import io.dojogeek.adminibot.validators.CompoundValidatorsFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CompoundValidatorsFactoryTest {

    private static final String EMTPY_VALUE = "";
    private static final String SPACE_VALUE = "  ";
    private static final int NO_ERRORS = 0;

    @Test
    public void compoundValidators_correctEmail_noErrors() {

        final String email = "jgacosta@dojogeek.io";

        CompoundValidator compoundValidator = CompoundValidatorsFactory.emailValidator();
        compoundValidator.isValid(email);

        assertEquals(compoundValidator.getErrorMsg(), NO_ERRORS);
    }

    @Test
    public void compoundValidators_exceededLengthEmail_isError() {

        final String email = "jgacostadg880224n62guaj272016hck@dojogeek.io";

        CompoundValidator compoundValidator = CompoundValidatorsFactory.emailValidator();
        compoundValidator.isValid(email);

        assertEquals(compoundValidator.getErrorMsg(), R.string.error_wrong_length_email);
    }

    @Test
    public void compoundValidators_emptyEmail_isError() {

        final String [] emptyEmail = {EMTPY_VALUE, SPACE_VALUE};

        for (String value : emptyEmail) {
            CompoundValidator compoundValidator = CompoundValidatorsFactory.emailValidator();
            compoundValidator.isValid(value);

            assertEquals(compoundValidator.getErrorMsg(), R.string.error_empty_value);
        }

    }

    @Test(expected= ValidatorNullValueException.class)
    public void compoundValidators_nullEmail_isException() {

        CompoundValidator compoundValidator = CompoundValidatorsFactory.emailValidator();
        compoundValidator.isValid(null);

    }

    @Test
    public void compoundValidators_malformedEmail_isError() {

        final String [] invalidEmails = {"jgacosta", "jgacosta@", "jgacosta@dojogeek", "jgacosta@dojogeek.",
        "jgacosta@dojogeek.oi.", "jgacosta@dojogeek#io", "@dojogeek.com", "jgacosta.io", "jgacosta$dojogeek.io",
        "jgacosta@@.io", "jgacosta@&.io"};

        for (String values : invalidEmails) {

            CompoundValidator compoundValidator = CompoundValidatorsFactory.emailValidator();
            compoundValidator.isValid(values);

            assertEquals(compoundValidator.getErrorMsg(), R.string.error_wrong_format_email);
        }

    }

    @Test
    public void compoundValidators_correctName_noErrors() {

        final String name = "Jacob";

        CompoundValidator compoundValidator = CompoundValidatorsFactory.nameValidator();
        compoundValidator.isValid(name);

        assertEquals(compoundValidator.getErrorMsg(), NO_ERRORS);
    }

    @Test
    public void compoundValidators_nameWithNoLetters_isError() {

        final String [] invalidNames = {"J4c0b", "Jaco&", "J_a_c_o_b", "J.a.c.o.b", "J>cob", "74508"};

        for (String values : invalidNames) {
            CompoundValidator compoundValidator = CompoundValidatorsFactory.nameValidator();
            compoundValidator.isValid(values);

            assertEquals(compoundValidator.getErrorMsg(), R.string.error_wrong_format_name);
        }
    }

    @Test
    public void compoundValidators_withEmptyName_isError() {

        final String [] emptyValues = {SPACE_VALUE, EMTPY_VALUE};

        for (String values : emptyValues) {
            CompoundValidator compoundValidator = CompoundValidatorsFactory.nameValidator();
            compoundValidator.isValid(values);

            assertEquals(compoundValidator.getErrorMsg(), R.string.error_empty_value);
        }
    }

    @Test(expected= ValidatorNullValueException.class)
    public void compoundValidators_withNullName_isException() {

        final String name = null;

        CompoundValidator compoundValidator = CompoundValidatorsFactory.nameValidator();
        compoundValidator.isValid(name);

    }

    @Test
    public void compoundValidators_exceededLengthName_isError() {

        final String name = "Jacob Dojogek Knowledge";
        CompoundValidator compoundValidator = CompoundValidatorsFactory.nameValidator();
        compoundValidator.isValid(name);

        assertEquals(compoundValidator.getErrorMsg(), R.string.error_wrong_lenght_name);

    }

    @Test
    public void compoundValidators_correctLastName_noErrors() {

        final String lastName = "Guzman A";

        CompoundValidator compoundValidator = CompoundValidatorsFactory.lastNameValidator();
        compoundValidator.isValid(lastName);

        assertEquals(compoundValidator.getErrorMsg(), NO_ERRORS);
    }

    @Test
    public void compoundValidators_exceededLengthLastName_isError() {

        final String lastName = "Guzman Knowledge Android Code Dojogeek";
        CompoundValidator compoundValidator = CompoundValidatorsFactory.lastNameValidator();
        compoundValidator.isValid(lastName);

        assertEquals(compoundValidator.getErrorMsg(), R.string.error_wrong_lenght_last_name);
    }

    @Test
    public void compoundValidators_lastNameWithNoLetters_isError() {

        final String lastName = "Guzm4an";

        CompoundValidator compoundValidator = CompoundValidatorsFactory.lastNameValidator();
        compoundValidator.isValid(lastName);

        assertEquals(compoundValidator.getErrorMsg(), R.string.error_wrong_format_last_name);
    }
}
