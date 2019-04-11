package shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shop {

    private String name;

    private List<Product> products;

    Shop(String name) {
        this.name = name;
        products = new ArrayList<Product>();
    }

    String getName() {
        return name;
    }

    List<Product> getProducts() {
        return products;
    }

    public void addNewProduct(Product product) {
        products.add(product);
    }

    public void removeProductFromShelf(String name) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                products.remove(i);
                break;
            }
        }
    }

    public List<Product> inventory() {
        return products;
    }

    public List<Product> getCheapProducts() {
        List<Product> cheapProducts = new ArrayList<Product>();
        for (int i = 0; i < products.size(); i++) {
            Product currentProduct = products.get(i);
            if (currentProduct.getPrice() <= 2) {
                cheapProducts.add(currentProduct);
            }
        }
        return cheapProducts;
    }
}
