package com.sneaker.Sneaker.dao;

import com.sneaker.Sneaker.model.Sneaker;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("postgres")
public class SneakerDataAccessService implements SneakerDao{
    @Override
    public int insertSneaker(UUID id, Sneaker sneaker) {
        return 0;
    }

    @Override
    public List<Sneaker> selectAllSneaker() {
        return List.of(new Sneaker(UUID.randomUUID(), "FROM POSTGRES DB", 0.0,"FROM POSTGRES D" ));
    }

    @Override
    public int deleteSneakerById(UUID id) {
        return 0;
    }

    @Override
    public int updateSneakerById(UUID id, Sneaker sneaker) {
        return 0;
    }

    @Override
    public Optional<Sneaker> selectSneakerById(UUID id) {
        return Optional.empty();
    }
}
