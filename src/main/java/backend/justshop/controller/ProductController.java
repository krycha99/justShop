package backend.justshop.controller;

import backend.justshop.model.Product;
import backend.justshop.service.ProductService;
import backend.justshop.user.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/api/v1/assortment")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final UserService userService;

    @PostMapping(path = "/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product, HttpServletRequest request){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("USER"))) {
            Product newProduct = productService.create(product);
            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
        }else {
            throw new IllegalStateException("user role is not admin");
        }
    }
}
