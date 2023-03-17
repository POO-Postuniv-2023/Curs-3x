package com.ubb.postuniv.service;

import com.ubb.postuniv.domain.Cake;
import com.ubb.postuniv.repository.IRepository;

import java.util.List;

public class CakeService {
    private IRepository<Cake> cakeRepository;

    public CakeService(IRepository<Cake> cakeRepository) {
        this.cakeRepository = cakeRepository;
    }

    public List<Cake> getAll() {
        return this.cakeRepository.readAll();
    }
}
