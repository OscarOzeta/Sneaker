package com.sneaker.Sneaker.dao;

import java.util.List;
import java.util.UUID;

import com.sneaker.Sneaker.model.Sneaker;

public interface SneakerDao {

    int insertSneaker(UUID id, Sneaker sneaker);

    default int insertSneaker(Sneaker sneaker){
        UUID id = UUID.randomUUID();
        return insertSneaker(id, sneaker);
    }

    List<Sneaker> selectAllSneaker();

}
