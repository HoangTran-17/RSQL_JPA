package repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "product")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String format;
    private Double price;
    private boolean bounded;
    private LocalDate shipDate;
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
