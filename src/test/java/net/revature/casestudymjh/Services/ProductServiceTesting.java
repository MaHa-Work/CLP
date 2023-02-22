package net.revature.casestudymjh.Services;

import net.revature.casestudymjh.Models.Product;
import net.revature.casestudymjh.Repositories.ProductRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ProductServiceTesting {
    @InjectMocks
    private ProductService productService;
    @Mock
    private ProductRepo productRepo;

    private Product product = new Product(1,"test", 0.55);
    List<Product> products = new ArrayList<>();


    @BeforeEach
    private void populateObjects(){
        products = Arrays.asList(new Product[]{product, product});
    }

    @Test
    public void givenNothing_findAllProducts_returnsListOfProducts(){
        Mockito.when(productRepo.findAll()).thenReturn(products);

        List<Product> resp = productService.findAllProducts();

        Assertions.assertEquals(resp.size(), products.size());
    }
}
