package com.sneaker.Sneaker.dao;

import com.sneaker.Sneaker.model.Sneaker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakeSneakerDataAccessService implements SneakerDao {

    private static List<Sneaker> DB = new ArrayList<>();

    @Override
    public int insertSneaker(UUID id, Sneaker sneaker) {
        DB.add(new Sneaker(id, sneaker.getName(), sneaker.getPrice(), sneaker.getWebsite()));
        return 1;
    }

    @Override
    public List<Sneaker> selectAllSneaker() {
        return DB;
    }
}
