package plugin.poem.image.controller.imple;

import java.io.*;
import java.util.*;

import io.swagger.v3.oas.annotations.tags.*;
import lombok.*;
import org.springframework.core.io.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;
import plugin.poem.image.controller.*;
import plugin.poem.image.dto.*;
import plugin.poem.image.exception.*;
import plugin.poem.image.service.*;

@RestController
@RequestMapping("/api/image-service/v1/images")
@AllArgsConstructor
public class ImageControllerImplements implements ImageController {

    private final ImageService imageService;

    @Override
    public Long addImage(MultipartFile image) {


        byte[] imageBytes;
        try {
            imageBytes = image.getBytes();
        } catch (IOException e) {
            throw new ImageUploadFailedException("Ошибка при загрузке изображения", e);
        }

        var newImage = new ImageCreateDto(1L, imageBytes);
        var imageId = imageService.addImage(newImage).getId();

        return imageId;
    }

    @Override
    public Resource getImageContentById(Long id) {

        var imageEntity = imageService.getImageById(id);

        var bytes = new ByteArrayResource(imageEntity.getPhoto());
        return bytes;
    }

    @Override
    public void deleteImage(Long id) {
        imageService.deleteImage(id);
    }

}
