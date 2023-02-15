package net.revature.casestudymjh.Controllers;

import lombok.RequiredArgsConstructor;
import net.revature.casestudymjh.Models.Product;
import net.revature.casestudymjh.Services.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
public class ProductController {
    private final ProductService productService;
    @GetMapping
    List<Product> getAllProducts(){
        return productService.findAllProducts();
    }

}
