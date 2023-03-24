package com.ubb.postuniv.repository;

import com.ubb.postuniv.domain.Entity;

import java.util.List;

public class UpsertRepositoryToRepositoryAdapter<T extends Entity> implements IUpsertRepository<T> {

    private IRepository<T> repository;

    public UpsertRepositoryToRepositoryAdapter(IRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public void upsert(T entity) {

        try {
            if (this.repository.read(entity.getId()) != null) {
                this.repository.update(entity);
            } else {
                this.repository.create(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<T> readAll() {
        return repository.readAll();
    }

    @Override
    public T read(int id) {
        return repository.read(id);
    }

    @Override
    public void delete(int id) throws Exception {
        repository.delete(id);
    }
}
