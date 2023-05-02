package plugin.poem.image.dto;

import java.time.*;

import io.swagger.v3.oas.annotations.media.*;
import lombok.*;

@Getter
@AllArgsConstructor
@Schema(description = "Описание ошибки")
public class ApiExceptionDto {

    @Schema(description = "Сообщение об ошибке")
    private String message;

    @Schema(description = "Дата возниковения ошибки")
    private ZonedDateTime date;
}
