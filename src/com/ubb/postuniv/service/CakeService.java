package com.ubb.postuniv.service;

import com.ubb.postuniv.domain.Cake;
import com.ubb.postuniv.repository.IRepository;
import com.ubb.postuniv.repository.IUpsertRepository;

import java.util.List;

public class CakeService {
    private IUpsertRepository<Cake> cakeRepository;

    public CakeService(IUpsertRepository<Cake> cakeRepository) {
        this.cakeRepository = cakeRepository;
    }

    public List<Cake> getAll() {
        return this.cakeRepository.readAll();
    }
}
