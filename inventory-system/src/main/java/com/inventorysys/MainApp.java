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
        Scanner sc = new Scanner(System.in);
        int ch = -1; 

        try {
            emf = Persistence.createEntityManagerFactory("InventoryPU");
            em = emf.createEntityManager();

            ProductDao proDao = new ProductDao(em);
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

                String input = sc.nextLine();
                try {
                    ch = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }

                switch (ch) {
                    case 1 -> proDao.addProductFromInput(sc);
                    case 2 -> proDao.viewAllProducts();
                    case 3 -> proDao.updateProductFromInput(sc);
                    case 4 -> proDao.deleteProductFromInput(sc);
                    case 5 -> saleDao.recordSaleFromInput(sc, proDao);
                    case 6 -> saleDao.viewSalesReport();
                    case 7 -> proDao.viewStockReport();
                    case 8 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice.");
                }
            } while (ch != 8);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
            sc.close();
        }
    }
}
