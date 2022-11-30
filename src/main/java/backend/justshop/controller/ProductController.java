package backend.justshop.controller;

import backend.justshop.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/assortment")
public class ProductController {

    private ProductService productService;
}
