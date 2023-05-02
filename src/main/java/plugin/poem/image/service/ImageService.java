package plugin.poem.image.service;

import java.time.*;

import lombok.*;
import org.springframework.stereotype.*;
import plugin.poem.image.dto.*;
import plugin.poem.image.exception.*;
import plugin.poem.image.model.*;
import plugin.poem.image.repository.*;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    public Image addImage(ImageCreateDto imageCreateDto) {

        var image = Image.builder()
            .employeeId(imageCreateDto.getEmployeeId())
            .date(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Z")))
            .photo(imageCreateDto.getPhoto())
            .build();

        imageRepository.save(image);
        return image;
    }

    public Image getImageById(Long id) {
        return imageRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Картинка с id " + id + " не найдена"));
    }

    public void deleteImage(Long id) {
        var image = getImageById(id);
        imageRepository.delete(image);
    }

}
