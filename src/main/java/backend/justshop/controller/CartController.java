package backend.justshop.controller;

import backend.justshop.model.Cart;
import backend.justshop.service.CartService;
import backend.justshop.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cart")
@AllArgsConstructor
public class CartController {

    private CartService cartService;
    private UserService userService;

    @PostMapping(path = "/addToCart/{id}")
    public ResponseEntity<Cart> addProduct(@PathVariable("id") Long id, @RequestBody Cart cart) {
        Cart newCart = cartService.create(id, cart);

    return new ResponseEntity<>(newCart, HttpStatus.CREATED);
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteFromCart(@PathVariable("id") Long id){
            cartService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping(path = "/clear/{id}")
    public ResponseEntity<?> clearCart(@PathVariable("id") Long id){
        cartService.clearCart(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
