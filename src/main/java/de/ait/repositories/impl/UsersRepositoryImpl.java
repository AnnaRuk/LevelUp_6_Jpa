package de.ait.repositories.impl;

import de.ait.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RequiredArgsConstructor
public class UsersRepositoryImpl  {


    @PersistenceContext
    @Autowired
    private final EntityManager entityManager;


    @Transactional
    public void save(User user){
        entityManager.persist(user);
    }



    //language=SQL
//    private static final String SQL_SELECT_ALL = "select * from account order by id";
//
//    //language=SQL
//    private static final String SQL_SELECT_ONE_BY_EMAIL = "select * from account where email = ? limit 1";
//
//    private static final RowMapper<User> USER_ROW_MAPPER = (row, rowNum) -> User.builder()
//            .id(row.getLong("id"))
//            .email(row.getString("email"))
//            .password(row.getString("password"))
//            .build();
//
//    @Override
//    public User findById(Long id) {
//        return null;
//    }
//
//    @Override
//    public List<User> findAll() {
//        return jdbcTemplate.query(SQL_SELECT_ALL, USER_ROW_MAPPER);
//    }
//
////    @Override
////    public void save(User model) {
////        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
////                .withTableName("account")
////                .usingGeneratedKeyColumns("id");
////
////        Map<String, Object> row = new HashMap<>();
////        row.put("email", model.getEmail());
////        row.put("password", model.getPassword());
////
////        Long generatedId = insert.executeAndReturnKey(row).longValue();
////
////        model.setId(generatedId);
////    }
//
//    @Override
//    public void deleteById(Long id) {
//
//    }
//
//    @Override
//    public void update(User model) {
//
//    }
//
//    @Override
//    public User findOneByEmail(String email) {
//        try {
//            return jdbcTemplate.queryForObject(SQL_SELECT_ONE_BY_EMAIL, USER_ROW_MAPPER, email);
//        } catch (EmptyResultDataAccessException e) {
//            return null;
//        }
//    }
}
