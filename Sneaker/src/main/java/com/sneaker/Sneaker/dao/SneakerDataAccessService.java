package com.sneaker.Sneaker.dao;

import com.sneaker.Sneaker.model.Sneaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class SneakerDataAccessService implements SneakerDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SneakerDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertSneaker(UUID id, Sneaker sneaker) {
        return 0;
    }

    @Override
    public List<Sneaker> selectAllSneaker() {
        final String sql = "SELECT id, name, price, website FROM sneaker";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            String website = resultSet.getString("website");
            return new Sneaker(id, name, price, website);
        });

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
