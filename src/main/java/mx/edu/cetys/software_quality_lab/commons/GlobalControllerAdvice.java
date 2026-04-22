package mx.edu.cetys.software_quality_lab.commons;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ApiResponse<Void> handleBadRequest(Exception ex) {

        return switch (ex) {
            case HttpMessageNotReadableException e ->
                new ApiResponse<>("Bad Request", null, null);
            default ->
                new ApiResponse<>("Internal Server Error", null, null);
        };

        //return new ApiResponse<>("Invalid Pet Info", null, ex.getMessage());
    }
}
