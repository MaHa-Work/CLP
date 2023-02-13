package net.revature.casestudymjh.Services;

import lombok.RequiredArgsConstructor;
import net.revature.casestudymjh.Models.Product;
import net.revature.casestudymjh.Repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }
}
