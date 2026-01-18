package JDBC.service;

import JDBC.dao.ProductDao;
import JDBC.dao.ProductDaoImpl;
import JDBC.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    public ProductServiceImpl(){
        productDao = new ProductDaoImpl();
    }


    @Override
    public void save(Product product) {
        try {
            int affectedRow = productDao.save(product);
            if (affectedRow < 1)
                throw new RuntimeException("Save Operation Failed");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findAll() {
        try {
            return productDao.findAll();
        }catch (SQLException e){
            throw  new RuntimeException();
        }
    }
}
