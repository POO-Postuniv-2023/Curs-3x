package com.ubb.postuniv.domain;

import com.ubb.postuniv.repository.IRepository;

public class TransactionValidator {

    public void validate(Transaction transaction, IRepository<Cake> cakeRepository) throws Exception {
        if (cakeRepository.read(transaction.getIdCake()) == null) {
            throw new Exception("The cake with the id: " + transaction.getIdCake() + " does not exist!");
        }
    }
}
