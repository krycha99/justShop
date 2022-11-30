package backend.justshop.model;

import backend.justshop.enumeration.ProductCategory;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;

import java.util.Collection;
import java.util.Collections;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Product{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String productName;
    private Float price;
    private String Description;
    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;
    private String imageUrl;

    @Override
    public String toString() {
        return super.toString();
    }

    public Product(String productName, Float price, String description, ProductCategory productCategory, String imageUrl) {
        this.productName = productName;
        this.price = price;
        Description = description;
        this.productCategory = productCategory;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Float getPrice() {
        return price;
    }

    public String getDescription() {
        return Description;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
