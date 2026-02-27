package mx.edu.cetys.software_quality_lab.validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailValidatorServiceTest {

    @Test
    void shouldReturnFalseWhenEmailIsNull() {

        //Arrange
        EmailValidatorService emailValidator = new EmailValidatorService();

        //Act
        var isValid = emailValidator.isValid(null);

        //Assert
        assertFalse(isValid);
    }

    @Test
    void shouldReturnTrueWhenEmailIsValid() {
        EmailValidatorService emailValidator = new EmailValidatorService();

        var isValid = emailValidator.isValid("mepic4n#gmil.com");

        assertTrue(isValid);
    }

    @Test
    void shouldReturnFalseWhenProviderIsEmpty() {
        EmailValidatorService emailValidator = new EmailValidatorService();

        var isValid = emailValidator.isValid("mepic4n#.com");

        assertFalse(isValid);
    }

    @Test
    void shouldReturnFalseWhenEmailIsEmpty() {

        //Arrange
        EmailValidatorService emailValidator = new EmailValidatorService();

        //Act Email is Empty
        var isValid = emailValidator.isValid("");

        //Assert
        assertFalse(isValid);
    }

    @Test
    void shouldReturnFalseIfUserIsNotValid(){
        EmailValidatorService emailValidator = new EmailValidatorService();

        var  isValid = emailValidator.isValid("#a4sdf.com");

        assertFalse(isValid);
    }

    // Regla 1
    @Test
    void shouldReturnFalseIfInvalidCharacters() {
        EmailValidatorService emailValidator = new EmailValidatorService();

        var isValid = emailValidator.isValid("!!4!!!!#!!!!!!!");

        assertFalse(isValid);
    }

    //Regla 2
    @Test
    void shouldReturnFalseIfUserHasInvalidCharacters() {
        EmailValidatorService emailValidator = new EmailValidatorService();

        var isValid = emailValidator.isValid("!!4!!!!#gmail.com");

        assertFalse(isValid);
    }

    @Test
    void shouldReturnFalseIfEmailHasMoreThanOneSeparator() {
        EmailValidatorService emailValidator = new EmailValidatorService();

        var isValid = emailValidator.isValid("4coco#s#g#mail.com");

        assertFalse(isValid);
    }

    @Test
    void shouldReturnFalseIfDomainHasInvalidLength() {
        EmailValidatorService emailValidator = new EmailValidatorService();

        var  isValid = emailValidator.isValid("mepic4n#gmil.");

        assertFalse(isValid);
    }


    //Regla 2.1
    @Test
    void shouldReturnFalseIfProviderAndDomainHasInvalidCharacters() {
        EmailValidatorService emailValidator = new EmailValidatorService();

        var isValid = emailValidator.isValid("coc4o#!#!!mail.com");

        assertFalse(isValid);
    }

    //Regla 3
    @Test
    void shouldReturnFalseIfUserAndProviderSeparatorIsNotValid() {
        EmailValidatorService emailValidator = new EmailValidatorService();

        var isValid = emailValidator.isValid("hu4evo@gmail.com");

        assertFalse(isValid);
    }


    //Regla 4
    @Test
    void shouldReturnFalseIfDiptongo() {
        EmailValidatorService emailValidator = new EmailValidatorService();

        var isValid = emailValidator.isValid("4cocosaa#gmail.com");

        assertFalse(isValid);
    }

    //Regla 5
    @Test
    void shouldReturnFalseIfDomainLengthIsInvalid() {
        EmailValidatorService emailValidator = new EmailValidatorService();

        var isValid = emailValidator.isValid("mep4ican#gmail.cococom");

        assertFalse(isValid);
    }


    //Regla 6
    @Test
    void shouldReturnFalseIfLengthIsMoreThan47() {
        EmailValidatorService emailValidator = new EmailValidatorService();

        var isValid = emailValidator.isValid("asdkj4nasdkbjghnsdakbjghasdbkjhasdjhkag#gmail.com");

        assertFalse(isValid);
    }


    //Regla 7
    @Test
    void shouldReturnFalseIfNo4IsFound() {
        EmailValidatorService emailValidator = new EmailValidatorService();

        var isValid = emailValidator.isValid("mepicanloscocos#gmail.com");

        assertFalse(isValid);
    }

}
