package com.inventorysys.dao;

import com.inventorysys.entity.Product;
import jakarta.persistence.EntityManager;
import java.util.*;

public class ProductDao {
    private final EntityManager em;

    public ProductDao(EntityManager em) {
        this.em = em;
    }

    public void addProductFromInput(Scanner sc) {
        System.out.print("Enter product name: ");
        String name = sc.nextLine();
        System.out.print("Enter price: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Enter stock: ");
        int stock = Integer.parseInt(sc.nextLine());

        Product pro = new Product(name, price, stock);

        em.getTransaction().begin();
        em.persist(pro);
        em.getTransaction().commit();

        System.out.println("Product added successfully.");
    }

    public void viewAllProducts() {
        List<Product> pros = em.createQuery("FROM Product", Product.class).getResultList();
        for (Product p : pros) {
            System.out.println(p);
        }
    }

    public void updateProductFromInput(Scanner sc) {
        System.out.print("Enter product ID to update: ");
        Long id = Long.parseLong(sc.nextLine());
        Product pr = em.find(Product.class, id);
        if (pr == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("New name: ");
        pr.setName(sc.nextLine());
        System.out.print("New price: ");
        pr.setPrice(Double.parseDouble(sc.nextLine()));
        System.out.print("New stock: ");
        pr.setStock(Integer.parseInt(sc.nextLine()));

        em.getTransaction().begin();
        em.merge(pr);
        em.getTransaction().commit();
        System.out.println("Product updated.");
    }

    public void deleteProductFromInput(Scanner sc) {
        System.out.print("Enter product ID to delete: ");
        Long id = Long.parseLong(sc.nextLine());
        Product product = em.find(Product.class, id);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        em.getTransaction().begin();
        em.remove(product);
        em.getTransaction().commit();
        System.out.println("Product deleted.");
    }

    public Product findProduct(Long id) {
        return em.find(Product.class, id);
    }

    public void viewStockReport() {
        List<Product> products = em.createQuery("FROM Product", Product.class).getResultList();
        for (Product p : products) {
            System.out.printf("Product: %s | Stock: %d | Price: %.2f%n", p.getName(), p.getStock(), p.getPrice());
        }
    }
}
