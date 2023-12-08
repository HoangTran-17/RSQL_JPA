package service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProductDTO {
    @Id
    private String id;

    private String name;

    private Double price;

    private LocalDateTime manufacturingDate;

     private Double weight;

    @Embedded
    private Dimension dimension;

    @Embeddable
    @Getter
    @Setter
    public static class Dimension {
        private Double height;
        private Double width;
    }
}
