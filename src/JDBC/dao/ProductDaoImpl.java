package JDBC.dao;

import JDBC.Config.DbConfig;
import JDBC.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
    //Dependency
    private final Connection conn;

    public ProductDaoImpl(){
        conn = DbConfig.getInstance();
    }

    @Override
    public int save(Product product) throws SQLException {
        // TODO
        // SQL
        final String SQL = """
                INSERT INTO products(code, name, price, qty, is_deleted)
                VALUES (?, ?, ?, ?, ?);
                """;
        // Create Statement Object
        PreparedStatement pstmt = conn.prepareStatement(SQL);

        //Set value to PSTMT
        pstmt.setString(1, product.getCode());
        pstmt.setString(2, product.getName());
        pstmt.setBigDecimal(3, product.getPrice());
        pstmt.setInt(4, product.getQty());
        pstmt.setBoolean(5, product.getDeleted());

        // Execute Update
        return pstmt.executeUpdate();
    }

    @Override
    public List<Product> findAll() throws SQLException {

        // Step 4: Create statement object
        Statement stmt = conn.createStatement();

        // Step 5: Execute SQL or Query
        final String SQL = """
                SELECT *
                FROM products
                """;
        ResultSet rs = stmt.executeQuery(SQL);

        // Step 6: Process ResultSet
        List<Product> productList = new ArrayList<>();
        while(rs.next()) {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setCode(rs.getString("code"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getBigDecimal("price"));
            product.setQty(rs.getInt("qty"));
            product.setDeleted(rs.getBoolean("is_deleted"));
            productList.add(product);
        }
        return productList;
    }
}
