package com.sneaker.Sneaker.dao;

import com.sneaker.Sneaker.model.Sneaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.JDBCType;
import java.sql.Types;
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
        final String sql = "INSERT INTO sneaker(name, price, website) values(:name,:price,:website)";

        final String insertSql = "INSERT INTO sneaker (id, name, price, website) VALUES (uuid_generate_v4(),?, ?, ?)";

        Object[] params = new Object[] {sneaker.getName(), sneaker.getPrice(), sneaker.getWebsite()};

        int[] types = new int[] {Types.VARCHAR, Types.DOUBLE,Types.VARCHAR};

        int row = jdbcTemplate.update(insertSql, params, types);

        return 1;

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
        String sql = "DELETE FROM sneaker WHERE id = ?";
        Object[] params = {id};
        int sneaker = jdbcTemplate.update(sql,params,id);
        return 1;
    }

    @Override
    public int updateSneakerById(UUID id, Sneaker sneaker) {
        return 0;
    }

    @Override
    public Optional<Sneaker> selectSneakerById(UUID id) {
        final String sql = "SELECT id, name, price, website FROM sneaker WHERE id = ?";
        Sneaker sneaker = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            UUID sneakerId = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            String website = resultSet.getString("website");
            return new Sneaker(sneakerId, name, price, website);
        });
        return Optional.ofNullable(sneaker);
    }
}
