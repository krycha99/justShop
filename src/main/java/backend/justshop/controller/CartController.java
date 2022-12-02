package backend.justshop.controller;

import backend.justshop.model.Cart;
import backend.justshop.model.Product;
import backend.justshop.service.CartService;
import backend.justshop.user.User;
import backend.justshop.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

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
}
