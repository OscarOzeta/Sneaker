package com.sneaker.Sneaker.service;

import com.sneaker.Sneaker.dao.SneakerDao;
import com.sneaker.Sneaker.model.Sneaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SneakerService {

    private final SneakerDao sneakerDao;

    @Autowired
    public SneakerService(@Qualifier("fakeDao") SneakerDao sneakerDao) {
        this.sneakerDao = sneakerDao;
    }

    public int addSneaker(Sneaker sneaker){
        return sneakerDao.insertSneaker(sneaker);
    }
    public List<Sneaker> getAllSneaker() {
        return sneakerDao.selectAllSneaker();
    }

    public Optional<Sneaker> getSneakerById(UUID id){
        return sneakerDao.selectSneakerById(id);
    }

    public int deleteSneaker(UUID id){
        return sneakerDao.deleteSneakerById(id);
    }

    public int updateSneaker(UUID id, Sneaker newSneaker){
        return sneakerDao.updateSneakerById(id, newSneaker);
    }

}
