package backend.justshop.model;

import backend.justshop.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;
    private Integer quantity;
    @ManyToMany
    @JoinColumn(nullable = false, name = "product_id")
    private List<Product> product;

    public Cart(User user, Integer quantity, Product product) {
        this.user = user;
        this.quantity = quantity;
        this.product = (List<Product>) product;
    }

}
