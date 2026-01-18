package JDBC.dao;

import JDBC.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    // 1. Operation: Insert a new record into database
    // 2. Expected return value -> affected row number
    // 3. paramters
    int save(Product product) throws SQLException;



    // 1. Operation; Read all records from database
    // 2. Expected return value
    // 3. parameters
     List<Product> findAll() throws SQLException;
}
