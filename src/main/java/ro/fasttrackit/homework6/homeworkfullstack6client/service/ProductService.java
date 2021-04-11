package ro.fasttrackit.homework6.homeworkfullstack6client.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ro.fasttrackit.homework6.homeworkfullstack6client.entity.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    public Product getById(int productId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8081/products/" + productId, Product.class);
    }

    public List<Product> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange("http://localhost:8081/products",
                HttpMethod.GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {//deoarece nu stie ce tip de date vin
                }
        ).getBody();
    }

    public Product addProduct(Product newProduct) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://localhost:808q/products", newProduct, Product.class);
    }

    public void deleteProduct(int productId) {
        RestTemplate restTemplate = new RestTemplate();
        Map<Integer, Integer> params = new HashMap<>();
        params.put(productId, productId);
        restTemplate.delete("http://localhost:8081/products/" + productId, Product.class);
    }
}
