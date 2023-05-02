package plugin.poem.image.controller;

import javax.validation.*;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.*;
import org.springframework.core.io.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

@Tag(name = "Картинки")
public interface ImageController {

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(
        summary = "Загрузка картинки",
        description = "Загрузить картинку в бинарном виде"
    )
    @RequestBody(
            content = {
                @Content(mediaType = "multipart/form-data")
            },
            required = true,
            description = "Картинка в формате png/jpeg"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "ok"
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Запрашиваемый объект не существует"
        ),
        @ApiResponse(
            responseCode = "403",
            description = "Ошибка авторизации"
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Ошибка на стороне сервера"
        )
    })
    @ResponseStatus(HttpStatus.OK)
    public Long addImage(@Valid @RequestParam("image") MultipartFile image);

    @GetMapping(
        value = "/{id}",
        produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE}
    )
    @Operation(
        summary = "Получение картинки по ID",
        description = "Получение картинки по ID"
    )
    @ResponseStatus(HttpStatus.OK)
    public Resource getImageContentById(@Valid @PathVariable Long id);

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Удалить картинку по id",
        description = "Удалить картинку по id"
    )
    public void deleteImage(@PathVariable Long id);
}
