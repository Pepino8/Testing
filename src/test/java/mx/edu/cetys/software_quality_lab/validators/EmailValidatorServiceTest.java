package mx.edu.cetys.software_quality_lab.validators;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailValidatorServiceTest {

    private EmailValidatorService emailValidator;
    
    @BeforeAll
    static void beforeAll() {
        // Log Start Time
    }
    
    @BeforeEach
    void beforeEach() {
        emailValidator = new EmailValidatorService();
    }

    @Test
    void shouldReturnFalseWhenEmailIsNull() {
        //Act
        var isValid = emailValidator.isValid(null);

        //Assert
        assertFalse(isValid);
    }

    @Test
    void shouldReturnTrueWhenEmailIsValid() {

        var isValid = emailValidator.isValid("mepic4n#gmil.com");

        assertTrue(isValid);
    }

    @Test
    void shouldReturnFalseWhenProviderIsEmpty() {

        var isValid = emailValidator.isValid("mepic4n#.com");

        assertFalse(isValid);
    }

    @Test
    void shouldReturnFalseWhenEmailIsEmpty() {

        //Arrange

        //Act Email is Empty
        var isValid = emailValidator.isValid("");

        //Assert
        assertFalse(isValid);
    }

    @Test
    void shouldReturnFalseIfUserIsNotValid(){

        var  isValid = emailValidator.isValid("#a4sdf.com");

        assertFalse(isValid);
    }

    // Regla 1
    @Test
    void shouldReturnFalseIfInvalidCharacters() {

        var isValid = emailValidator.isValid("!!4!!!!#!!!!!!!");

        assertFalse(isValid);
    }

    //Regla 2
    @Test
    void shouldReturnFalseIfUserHasInvalidCharacters() {

        var isValid = emailValidator.isValid("!!4!!!!#gmail.com");

        assertFalse(isValid);
    }

    @Test
    void shouldReturnFalseIfEmailHasMoreThanOneSeparator() {

        var isValid = emailValidator.isValid("4coco#s#g#mail.com");

        assertFalse(isValid);
    }

    @Test
    void shouldReturnFalseIfDomainHasInvalidLength() {

        var  isValid = emailValidator.isValid("mepic4n#gmil.");

        assertFalse(isValid);
    }


    //Regla 2.1
    @Test
    void shouldReturnFalseIfProviderAndDomainHasInvalidCharacters() {

        var isValid = emailValidator.isValid("coc4o#!#!!mail.com");

        assertFalse(isValid);
    }

    //Regla 3
    @Test
    void shouldReturnFalseIfUserAndProviderSeparatorIsNotValid() {

        var isValid = emailValidator.isValid("hu4evo@gmail.com");

        assertFalse(isValid);
    }


    //Regla 4
    @Test
    void shouldReturnFalseIfDiptongo() {

        var isValid = emailValidator.isValid("4cocosaa#gmail.com");

        assertFalse(isValid);
    }

    //Regla 5
    @Test
    void shouldReturnFalseIfDomainLengthIsInvalid() {

        var isValid = emailValidator.isValid("mep4ican#gmail.cococom");

        assertFalse(isValid);
    }


    //Regla 6
    @Test
    void shouldReturnFalseIfLengthIsMoreThan47() {

        var isValid = emailValidator.isValid("asdkj4nasdkbjghnsdakbjghasdbkjhasdjhkag#gmail.com");

        assertFalse(isValid);
    }


    //Regla 7
    @Test
    void shouldReturnFalseIfNo4IsFound() {

        var isValid = emailValidator.isValid("mepicanloscocos#gmail.com");

        assertFalse(isValid);
    }

}
