package plugin.poem.image.model;

import java.time.*;

import javax.persistence.*;
import javax.persistence.Entity;

import lombok.*;
import org.hibernate.annotations.*;

@Data
@Builder
@Entity(name = "image")
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] photo;

    private ZonedDateTime date;

}
