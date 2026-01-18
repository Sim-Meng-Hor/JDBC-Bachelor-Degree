package JDBC;

import JDBC.Config.DbConfig;
import JDBC.dao.ProductDao;
import JDBC.model.Product;
import JDBC.service.ProductService;
import JDBC.service.ProductServiceImpl;
import JDBC.util.InputUtil;
import JDBC.util.ViewUtil;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Init connection
        DbConfig.init();

        ProductService productService =new ProductServiceImpl();
        do {
            ViewUtil.printMenu();

            int option = InputUtil.getInteger("Enter Menu :");
            switch (option){
                case 0 -> System.exit(0);
                case 1 -> {
                    try {
                        List<Product> productList = productService.findAll();

                        ViewUtil.printProductList(productList);
                    }catch (RuntimeException e){
                        ViewUtil.printHeader(e.getMessage());
                    }
                }
                case 2 -> System.out.println("Search");
                case 3 -> {
                    String code = InputUtil.getText("Enter Code :");
                    String name = InputUtil.getText("Enter Name :");
                    BigDecimal price = InputUtil.getMoney("Enter Price :");
                    Integer qty = InputUtil.getInteger("Enter QTY :");


                    Product product = new Product(code, name, price, qty,true);

                    try {
                        productService.save(product);
                        ViewUtil.printHeader("Product Save Successfully");
                    }catch (RuntimeException e){
                        ViewUtil.printHeader(e.getMessage());
                    }
                }
                default -> System.out.println("Invalid Menu...!");
            }
        }while (true);
    }
}