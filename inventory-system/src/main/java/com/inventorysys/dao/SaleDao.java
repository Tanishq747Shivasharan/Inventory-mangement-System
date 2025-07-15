package com.inventorysys.dao;

import com.inventorysys.entity.Product;
import com.inventorysys.entity.Sale;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.util.*;


public class SaleDao {
    private final EntityManager em;

    public SaleDao(EntityManager em) {
        this.em = em;
    }

    public void recordSaleFromInput(Scanner scanner, ProductDao proDao) {
        System.out.print("Enter product ID: ");
        Long proId = Long.parseLong(scanner.nextLine());
        Product pro = proDao.findProduct(proId);
        if (pro == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter quantity sold: ");
        int qty = Integer.parseInt(scanner.nextLine());
        if (qty > pro.getStock()) {
            System.out.println("Not enough stock.");
            return;
        }

        em.getTransaction().begin();
        pro.setStock(pro.getStock() - qty);
        Sale sale = new Sale(pro, qty, LocalDate.now());
        em.persist(sale);
        em.getTransaction().commit();
        System.out.println("Sale recorded.");
    }

    public void viewSalesReport() {
        List<Sale> sales = em.createQuery("FROM Sale", Sale.class).getResultList();
        for (Sale sale : sales) {
            System.out.printf("Product: %s | Qty: %d | Date: %s%n",
                    sale.getProduct().getName(), sale.getQuantity(), sale.getDate());
        }
    }
}