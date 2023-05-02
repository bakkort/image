package plugin.poem.image.exception;

import java.time.*;

import lombok.*;
import org.springframework.http.*;

@Getter
public class ApiException extends RuntimeException {

    private final HttpStatus httpStatus;

    private final ZonedDateTime date;

    public ApiException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.date = ZonedDateTime.now(ZoneId.of("Z"));
    }

    public ApiException(HttpStatus httpStatus, String message, Throwable reason) {
        super(message, reason);
        this.httpStatus = httpStatus;
        this.date = ZonedDateTime.now(ZoneId.of("Z"));
    }

}
