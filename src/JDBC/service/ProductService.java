package JDBC.service;

import JDBC.dao.ProductDao;
import JDBC.dao.ProductDaoImpl;
import JDBC.model.Product;

import java.util.List;

public interface ProductService {

    void save(Product product);
    List<Product> findAll();


}
