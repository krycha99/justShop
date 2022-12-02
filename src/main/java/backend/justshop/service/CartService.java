package backend.justshop.service;

import backend.justshop.model.Cart;
import backend.justshop.model.Product;
import backend.justshop.repository.CartRepository;
import backend.justshop.user.User;
import backend.justshop.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class CartService {

    private final UserService userService;
    private final ProductService productService;

    private final CartRepository cartRepository;


    public Cart create(Long id, Cart cart){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User loggedUser = (User) userService.loadUserByUsername(username);
        cart.setUser(loggedUser);
        Product product = productService.findProductById(id);
        cart.setProduct(product);
        return cartRepository.save(cart);
    }
    //public int enableUser(String email){
    //        return userRepository.enableUser(email);
    //    }
    public void delete(Long id){
        cartRepository.deleteProductFromCart(id);

    }


}
