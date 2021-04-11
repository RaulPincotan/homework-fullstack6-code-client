package ro.fasttrackit.homework6.homeworkfullstack6client.client;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ro.fasttrackit.homework6.homeworkfullstack6client.entity.Category;
import ro.fasttrackit.homework6.homeworkfullstack6client.entity.Product;
import ro.fasttrackit.homework6.homeworkfullstack6client.service.ProductService;

import java.util.Scanner;

@ShellComponent
@RequiredArgsConstructor
public class ProductCommands {
    private final ProductService productService;

    @ShellMethod("Print all products")
    void printAllProducts() {
        productService.getAll()
                .forEach(System.out::println);
    }

    @ShellMethod("Get product by id")
    void getProduct() {
        System.out.print("id: ");
        Scanner scanner = new Scanner(System.in);
        int lookupId = scanner.nextInt();
        System.out.println(productService.getById(lookupId));
    }


    @ShellMethod("Add new product")
    void addProduct() {
        System.out.println(productService.addProduct(new Product(432, "TV", 2000, "QLED TV", Category.ELECTRONICS)));
    }

    @ShellMethod("Delete product")
    void deleteProduct() {
        productService.deleteProduct(3);
    }
}
