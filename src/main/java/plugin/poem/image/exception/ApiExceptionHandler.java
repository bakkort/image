package plugin.poem.image.exception;


import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import plugin.poem.image.dto.*;

@ControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiExceptionDto> handleApiRequestException(NotFoundException exception) {
        return ResponseEntity.status(exception.getHttpStatus()).body(new ApiExceptionDto(
            exception.getMessage(),
            exception.getDate()
        ));
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ImageUploadFailedException.class)
    public ResponseEntity<ApiExceptionDto> handleApiRequestException(ImageUploadFailedException exception) {
        return ResponseEntity.status(exception.getHttpStatus()).body(new ApiExceptionDto(
            exception.getMessage(),
            exception.getDate()
        ));
    }


}
