package com.ubb.postuniv.userInterface;

import com.ubb.postuniv.domain.TransactionValidationException;
import com.ubb.postuniv.service.CakeService;
import com.ubb.postuniv.service.TransactionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {
    private CakeService cakeService;
    private TransactionService transactionService;
    private Scanner scanner;

    public Console(CakeService cakeService, TransactionService transactionService) {
        this.cakeService = cakeService;
        this.transactionService = transactionService;

        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. CRUD Cakes");
        System.out.println("2. CRUD Transactions");
        System.out.println("3. Show cakes by number of transactions");
        System.out.println("0. Exit");
    }

    private void showAll(ArrayList objects) {
        for (Object obj : objects) {
            System.out.println(obj);
        }
    }

    public void runConsole() {
        while (true) {
            this.showMenu();

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    this.runSubmenuCRUDCakes();
                    break;
                case 2:
                    this.runSubmenuCRUDTransactions();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void runSubmenuCRUDTransactions() {
        while (true) {
            System.out.println("1. Add transaction");
            System.out.println("2. Update transaction");
            System.out.println("3. Delete transaction");
            System.out.println("4. Show all transaction");
            System.out.println("0. Back");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    this.handleAddTransaction();
                    break;
                case 4:
                    this.showAll((ArrayList) this.transactionService.getAll());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option.");

            }
        }
    }

    private void handleAddTransaction() {
        try {
            System.out.println("ID transaction: ");
            int id = this.scanner.nextInt();

            System.out.println("Cake id: ");
            int idCake = this.scanner.nextInt();

            System.out.println("Client card: ");
            int clientCard = this.scanner.nextInt();

            System.out.println("Date: ");
            String date = this.scanner.next();

            System.out.println("Time: ");
            String time = this.scanner.next();

            System.out.println("Count: ");
            int count = this.scanner.nextInt();

            this.transactionService.add(id, idCake, clientCard, date, time, count);
        } catch (TransactionValidationException tvex) {
            System.out.println("Transaction validation error: " + tvex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private void runSubmenuCRUDCakes() {
        while (true) {
            System.out.println("1. Add cake");
            System.out.println("2. Update cake");
            System.out.println("3. Delete cake");
            System.out.println("4. Show all cakes");
            System.out.println("0. Back");

            int option = scanner.nextInt();

            switch (option) {
                case 4:
                    this.showAll((ArrayList) this.cakeService.getAll());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option.");

            }
        }
    }
}
