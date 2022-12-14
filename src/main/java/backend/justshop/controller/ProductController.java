package backend.justshop.controller;

import backend.justshop.model.Cart;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/assortment")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final UserService userService;

    //TODO: zmienis poniezj USER na ADMIN pod koniec
    @PostMapping(path = "/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("USER"))) {
            Product newProduct = productService.create(product);
            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
        }else {
            throw new IllegalStateException("user role is not admin");
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Product product = productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("USER"))){
            Product updateProduct = productService.update(product);
            return new ResponseEntity<>(updateProduct, HttpStatus.OK);
        }
        else {
            throw new IllegalStateException("user role is not admin");
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("USER"))){
            productService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            throw new IllegalStateException("user role is not admin");
        }
    }
}
