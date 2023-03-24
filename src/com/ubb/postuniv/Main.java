package com.ubb.postuniv;

import com.ubb.postuniv.domain.Cake;
import com.ubb.postuniv.domain.Entity;
import com.ubb.postuniv.domain.Transaction;
import com.ubb.postuniv.domain.TransactionValidator;
import com.ubb.postuniv.repository.IRepository;
import com.ubb.postuniv.repository.IUpsertRepository;
import com.ubb.postuniv.repository.InMemoryRepository;
import com.ubb.postuniv.repository.UpsertRepositoryToRepositoryAdapter;
import com.ubb.postuniv.service.CakeService;
import com.ubb.postuniv.service.TransactionService;
import com.ubb.postuniv.userInterface.Console;

public class Main {

    public static void main(String[] args) throws Exception {
        IRepository<Cake> cakeRepository = new InMemoryRepository<>();
        IRepository<Transaction> transactionIRepository = new InMemoryRepository<>();
        TransactionValidator transactionValidator = new TransactionValidator();

        cakeRepository.create(new Cake(1, "Cake 1", "Ingred 1", 150, 120, true));
        cakeRepository.create(new Cake(2, "Cake 2", "Ingred 2", 120, 323, true));
        cakeRepository.create(new Cake(3, "Cake 3", "Ingred 1", 150, 6545, false));
        cakeRepository.create(new Cake(4, "Cake 4", "Ingred 4", 540, 344, true));
        cakeRepository.create(new Cake(5, "Cake 5", "Ingred 5, Ingred 8", 330, 120, true));
        cakeRepository.create(new Cake(6, "Cake 6", "Ingred 8", 330, 5345, false));
        cakeRepository.create(new Cake(7, "Cake 7", "Ingred 13", 430, 434, true));


        IUpsertRepository<Cake> adapter = new UpsertRepositoryToRepositoryAdapter<>(cakeRepository);
        CakeService cakeService = new CakeService(adapter);
        TransactionService transactionService = new TransactionService(
                transactionIRepository,
                cakeRepository,
                transactionValidator);

        Console console = new Console(cakeService, transactionService);
        console.runConsole();
    }
}
