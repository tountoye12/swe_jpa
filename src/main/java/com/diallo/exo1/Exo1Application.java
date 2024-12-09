package com.diallo.exo1;

import com.diallo.exo1.entity.Customer;
import com.diallo.exo1.entity.Order;
import com.diallo.exo1.entity.OrderDetails;
import com.diallo.exo1.entity.Product;
import com.diallo.exo1.repository.CustomerRepository;
import com.diallo.exo1.repository.OrderRepository;
import com.diallo.exo1.repository.ProductRepository;
import com.diallo.exo1.service.CustomerService;
import com.diallo.exo1.service.OrderService;
import com.diallo.exo1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class Exo1Application implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(Exo1Application.class, args);
        System.out.println("Test");

    }

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;

    @Override
    public void run(String... args) throws Exception {
//        customerLoader();
//        productLoader();
        //orderLoader();
        //orderDetailsLoader();
    }
    public  void customerLoader() {
        var customer_list = Arrays.asList(
                new Customer("John Doe", "john.doe@example.com"),
                new Customer("Jane Smith", "jane.smith@example.com"),
                new Customer("Alice Brown", "alice.brown@example.com")
        );

        for(var customer : customer_list) {
            customerService.save(customer);
        }
    }
    public void productLoader() {
        var product_list = Arrays.asList(
                new Product("laptop", 1000,50),
                new Product("Smartphone", 700,100),
                new Product("Headphones", 100,200),
                new Product("Monitor", 200,75)
        );

        for (var product : product_list) {
            productService.saveProduct(product);
        }
    }

    public void orderLoader() {
        var order_list = Arrays.asList(
                new Order(LocalDate.now(), customerRepository.findById(1).get()),
                new Order(LocalDate.now(), customerRepository.findById(2).get()),
                new Order(LocalDate.now(), customerRepository.findById(3).get())
        );
        for(var order : order_list) {
            orderService.save(order);
        }

    }

    public void orderDetailsLoader() {
        var order_details = Arrays.asList(
                new OrderDetails(orderService.getOrderById(1), productService.getProductById(1), 1, 1000),
                new OrderDetails(orderService.getOrderById(1), productService.getProductById(3), 2, 200),
                new OrderDetails(orderService.getOrderById(2), productService.getProductById(2), 1, 700),
                new OrderDetails(orderService.getOrderById(3), productService.getProductById(4), 3, 600),
                new OrderDetails(orderService.getOrderById(3), productService.getProductById(3), 1, 100)
        );
    }

}
