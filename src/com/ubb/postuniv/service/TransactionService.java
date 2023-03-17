package com.ubb.postuniv.service;

import com.ubb.postuniv.domain.Cake;
import com.ubb.postuniv.domain.Transaction;
import com.ubb.postuniv.domain.TransactionValidator;
import com.ubb.postuniv.repository.IRepository;

import java.util.List;

public class TransactionService {

    private IRepository<Transaction> transactionRepository;
    private IRepository<Cake> cakeRepository;
    private TransactionValidator transactionValidator;

    public TransactionService(IRepository<Transaction> transactionRepository,
                              IRepository<Cake> cakeRepository,
                              TransactionValidator transactionValidator) {
        this.transactionRepository = transactionRepository;
        this.cakeRepository = cakeRepository;
        this.transactionValidator = transactionValidator;
    }

    public void add(int id, int idCake, int clientCard, String date, String time, int count) throws Exception {
        Transaction transaction = new Transaction(id, idCake, clientCard, date, time, count);
        this.transactionValidator.validate(transaction, this.cakeRepository);
        this.transactionRepository.create(transaction);
    }

    public List<Transaction> getAll() {
        return this.transactionRepository.readAll();
    }
}
