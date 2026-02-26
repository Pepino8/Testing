package mx.edu.cetys.software_quality_lab.validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

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
    void shouldReturnFalseWhenEmailIsEmpty() {

        //Arrange
        EmailValidatorService emailValidator = new EmailValidatorService();

        //Act Email is Empty
        var isValid = emailValidator.isValid("");

        //Assert
        assertFalse(isValid);
    }

    // Regla 1
    @Test
    void shouldReturnFalseIfInvalidCharacters() {
        EmailValidatorService emailValidator = new EmailValidatorService();

        var isValid = emailValidator.isValid("!!!!!!!!#!!!!!!!!.!!!");

        assertFalse(isValid);
    }

    //Regla 2
    @Test
    void shouldReturnFalseIfUserHasInvalidCharacters() {
        EmailValidatorService emailValidator = new EmailValidatorService();

        var isValid = emailValidator.isValid("!!!!!!#gmail.com");

        assertFalse(isValid);
    }


    //Regla 2.1
    @Test
    void shouldReturnFalseIfProviderAndDomainHasInvalidCharacters() {
        EmailValidatorService emailValidator = new EmailValidatorService();

        var isValid = emailValidator.isValid("coco#!#!!!!!mail.com");

        assertFalse(isValid);
    }

    //Regla 3
    @Test
    void shouldReturnFalseIfUserAndProviderSeparatorIsNotValid() {
        EmailValidatorService emailValidator = new EmailValidatorService();

        var isValid = emailValidator.isValid("huevo@gmail.com");

        assertFalse(isValid);
    }


    //Regla 4
    @Test
    void shouldReturnFalseIfDiptongo() {
        EmailValidatorService emailValidator = new EmailValidatorService();

        var isValid = emailValidator.isValid("mepicanloscocosaaaaaa#gmail.com");

        assertFalse(isValid);
    }

    //Regla 5
    @Test
    void shouldReturnFalseIfDomainLengthIsInvalid() {
        EmailValidatorService emailValidator = new EmailValidatorService();

        var isValid = emailValidator.isValid("mepican#gmail.cococococom");

        assertFalse(isValid);
    }


    //Regla 6
    @Test
    void shouldReturnFalseIfLengthIsMoreThan47() {
        EmailValidatorService emailValidator = new EmailValidatorService();

        var isValid = emailValidator.isValid("asdkjnasdkbjghnsdakbjghasdbkjhasdjhkag#gmail.com");

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
