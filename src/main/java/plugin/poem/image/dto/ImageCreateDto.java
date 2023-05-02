package plugin.poem.image.dto;

import io.swagger.v3.oas.annotations.media.*;
import lombok.*;

@Getter
@AllArgsConstructor
@Schema(description = "Создание картинки")
public class ImageCreateDto {

    private Long employeeId;

    private byte[] photo;

}
