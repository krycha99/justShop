package backend.justshop.repository;

import backend.justshop.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    Optional<Cart> findById(Long id);
    @Modifying
    @Query("DELETE Cart a " + "WHERE a.id =?1")
    int deleteProductFromCart(Long id);

    @Modifying
    @Query("DELETE Cart a " + "WHERE a.user.id =?1")
    int clearCart(Long id);
}
