package com.sneaker.Sneaker.dao;

import com.sneaker.Sneaker.model.Sneaker;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Override
    public int deleteSneakerById(UUID id) {
        Optional<Sneaker> sneakerMaybe = selectSneakerById(id);
        if(sneakerMaybe.isEmpty()){
            return 0;
        }
        DB.remove(sneakerMaybe.get());
        return 1;
    }

    @Override
    public int updateSneakerById(UUID id, Sneaker update) {
        return selectSneakerById(id)
                .map(sneaker -> {
                    int indexOfSneakerToUpdate = DB.indexOf(sneaker);
                    if(indexOfSneakerToUpdate >= 0){
                        DB.set(indexOfSneakerToUpdate, new Sneaker(id, update.getName(), update.getPrice(), update.getWebsite()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public Optional<Sneaker> selectSneakerById(UUID id) {
        return DB.stream()
                .filter(sneaker -> sneaker.getId().equals(id))
                .findFirst();
    }
}
