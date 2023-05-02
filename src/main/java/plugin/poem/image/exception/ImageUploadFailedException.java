package plugin.poem.image.exception;

import org.springframework.http.*;

public class ImageUploadFailedException extends ApiException{

    public ImageUploadFailedException(String message) {
        super(HttpStatus.EXPECTATION_FAILED, message);
    }
    public ImageUploadFailedException(String message, Throwable cause) {
        super(HttpStatus.EXPECTATION_FAILED, message, cause);
    }

}
