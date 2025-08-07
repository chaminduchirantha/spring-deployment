package lk.ijse.gdse.springdeployment.exception;

import lk.ijse.gdse.springdeployment.utill.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handelGenericException(Exception e) {
        return new ResponseEntity (new ApiResponse(500 ,e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handelResourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity (new ApiResponse(404 ,e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ExistNotFoundException.class)
    public ResponseEntity<ApiResponse> handelExistNotFoundException(ExistNotFoundException e) {
        return new ResponseEntity (new ApiResponse(404 ,e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UpdateExistNotFoundException.class)
    public ResponseEntity<ApiResponse> handelpdateExistNotFoundException(UpdateExistNotFoundException e) {
        return new ResponseEntity (new ApiResponse(200 ,e.getMessage(),null),HttpStatus.OK);
    }

    @ExceptionHandler(DeleteExistNotFoundException.class)
    public ResponseEntity<ApiResponse> handelDeleteExistNotFoundException(DeleteExistNotFoundException e) {
        return new ResponseEntity (new ApiResponse(200 ,e.getMessage(),null),HttpStatus.OK);
    }

    @ExceptionHandler(HandelMethodArgumentNotValidationException.class)
    public ResponseEntity<ApiResponse> handelMethodArgumentNotValidationException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((fieldError) -> {
            errors.put(fieldError.getDefaultMessage(), fieldError.getDefaultMessage());
        });

        return new ResponseEntity (new ApiResponse(400 ,errors.get("fieldError"),null),HttpStatus.BAD_REQUEST);
    }
}
