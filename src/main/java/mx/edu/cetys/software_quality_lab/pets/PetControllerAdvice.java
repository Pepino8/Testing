package mx.edu.cetys.software_quality_lab.pets;

import jakarta.persistence.EntityNotFoundException;
import mx.edu.cetys.software_quality_lab.commons.ApiResponse;
import mx.edu.cetys.software_quality_lab.pets.exceptions.InvalidPetDataException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PetControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ApiResponse<Void> handleInvalidPet(InvalidPetDataException exception) {
        return new ApiResponse<>("Invalid Pet Info", null, exception.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ApiResponse<Void> handlePetNotFound(EntityNotFoundException ex) {
        return new ApiResponse<>("Pet Not Found", null, ex.getMessage());
    }
}
