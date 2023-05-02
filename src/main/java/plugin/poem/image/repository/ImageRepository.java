package plugin.poem.image.repository;

import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;
import plugin.poem.image.model.*;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {

}
