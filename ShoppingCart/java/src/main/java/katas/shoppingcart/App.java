package katas.shoppingcart;

import katas.shoppingcart.repositories.ProductRepository;

import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class App {

    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("config")) {
            Properties properties = new Properties();
            properties.load(fileReader);

            String className = properties.getProperty("product-repository");
            String productRepositoryString = "katas.shoppingcart.repositories." + className;
            Class cls = Class.forName(productRepositoryString);
            ProductRepository productRepository = (ProductRepository)cls.newInstance();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }

    }

}
