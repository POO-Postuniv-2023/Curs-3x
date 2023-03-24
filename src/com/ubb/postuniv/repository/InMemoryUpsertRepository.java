package com.ubb.postuniv.repository;

import com.ubb.postuniv.domain.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryUpsertRepository<T extends Entity> implements IUpsertRepository<T> {

    private Map<Integer, T> storage;

    public InMemoryUpsertRepository() {
        this.storage = new HashMap<>();
    }

    @Override
    public void upsert(T entity) {
        this.storage.put(entity.getId(), entity);
    }

    @Override
    public List<T> readAll() {
        return new ArrayList<>(this.storage.values());
    }

    @Override
    public T read(int id) {
        return this.storage.get(id);
    }

    @Override
    public void delete(int id) throws Exception {
        if (!this.storage.containsKey(id)) {
            throw new Exception("There is no entity with the id: " + id + " to delete.");
        }
        this.storage.remove(id);

    }
}