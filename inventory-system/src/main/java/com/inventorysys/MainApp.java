package com.inventorysys;

import com.inventorysys.dao.ProductDao;
import com.inventorysys.dao.SaleDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Scanner scanner = new Scanner(System.in);
        int choice = -1; 

        try {
            emf = Persistence.createEntityManagerFactory("InventoryPU");
            em = emf.createEntityManager();

            ProductDao productDao = new ProductDao(em);
            SaleDao saleDao = new SaleDao(em);

            do {
                System.out.println("\n=== Inventory Management System ===");
                System.out.println("1. Add Product");
                System.out.println("2. View All Products");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("5. Record Sale");
                System.out.println("6. View Sales Report");
                System.out.println("7. View Stock Report");
                System.out.println("8. Exit");
                System.out.print("Enter choice: ");

                String input = scanner.nextLine();
                try {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }

                switch (choice) {
                    case 1 -> productDao.addProductFromInput(scanner);
                    case 2 -> productDao.viewAllProducts();
                    case 3 -> productDao.updateProductFromInput(scanner);
                    case 4 -> productDao.deleteProductFromInput(scanner);
                    case 5 -> saleDao.recordSaleFromInput(scanner, productDao);
                    case 6 -> saleDao.viewSalesReport();
                    case 7 -> productDao.viewStockReport();
                    case 8 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice.");
                }
            } while (choice != 8);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
            scanner.close();
        }
    }
}