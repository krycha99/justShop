package backend.justshop.service;

import backend.justshop.model.Product;
import backend.justshop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public Product findProductById(Long id){
        return productRepository.findProductById(id)
                .orElseThrow(() -> new IllegalStateException("Product by id " + id + "was not found"));
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

     public Product create(Product product) {
        log.info("Saving new product: {}", product.getProductName());
        product.setImageUrl(setProductImageUrl());
        return productRepository.save(product);
    }

    public Product update(Product product){
         return productRepository.save(product);
    }

    public void delete(Long id){
         productRepository.deleteById(id);
    }

    private String setProductImageUrl() {
        return null;
    }

    public Collection<Product> list(int limit){
        log.info("List of products: ");
        return productRepository.findAll(PageRequest.of(0, limit)).toList();
    }


}
