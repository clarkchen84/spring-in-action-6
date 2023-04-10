package sizhe.chen.repository.impl;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sizhe.chen.model.Ingredient;
import sizhe.chen.repository.IngredientRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 * @Author: sizhe.chen
 * @Date: Create in 11:46 PM 2023/4/10
 * @Description:
 * @Modified:
 * @Version:
 */
@AllArgsConstructor
@Repository
public class JdbcIngredientRepositoryImpl implements IngredientRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query(" SELECT id, name, type from Ingredient", this::mapRow);
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        return jdbcTemplate.query(" SELECT id, name, type from Ingredient where id = ? ", this::mapRow, id).stream().findFirst();
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update("INSERT INTO Ingredient( id, name, type) values( ?,?,?)", ingredient.getId(), ingredient.getName(), ingredient.getType().toString());
        return ingredient;
    }

    Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Ingredient.builder().id(rs.getString("id")).name(rs.getString("name")).type(
                Ingredient.Type.valueOf(rs.getString("type"))).build();

    }

}
