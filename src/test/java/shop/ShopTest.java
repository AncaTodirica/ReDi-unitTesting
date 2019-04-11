package shop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopTest {


    Shop shop = new Shop("MyShop");


    @Test
    void addingNewProduct_updatesTheListOfProducts() {
        Product biscuits = new Product("biscuits", 2);

        shop.addNewProduct(biscuits);

        assertEquals(1, shop.getProducts().size());
        assertEquals(biscuits, shop.getProducts().get(0));
    }

    @Test
    void addingMultipleProducts_updatesTheListOfProducts() {
        Shop shop = new Shop("MyShop");
        Product biscuits = new Product("biscuits", 2);
        Product coffee = new Product("coffee", 4);

        shop.addNewProduct(biscuits);
        shop.addNewProduct(coffee);

        assertEquals(2, shop.getProducts().size());
        assertEquals(Arrays.asList(biscuits, coffee), shop.getProducts());
    }

    @Test
    void removingProductFromShelf_removesItemFromList() {
        Shop shop = new Shop("MyShop");
        Product biscuits = new Product("biscuits", 2);
        Product coffee = new Product("coffee", 4);
        shop.addNewProduct(biscuits);
        shop.addNewProduct(coffee);

        shop.removeProductFromShelf(biscuits.getName());

        assertEquals(1, shop.getProducts().size());
        assertEquals(coffee, shop.getProducts().get(0));
    }

    @Test
    void removingProductFromShelf_removesJustOneItem_WhenMultipleItemsWithTheSameNameAreInTheShop() {
        Shop shop = new Shop("MyShop");
        Product biscuits = new Product("biscuits", 2);
        Product moreBiscuits = new Product("biscuits", 2);
        Product coffee = new Product("coffee", 4);
        shop.addNewProduct(biscuits);
        shop.addNewProduct(moreBiscuits);
        shop.addNewProduct(coffee);

        shop.removeProductFromShelf(biscuits.getName());

        assertEquals(2, shop.getProducts().size());
        assertEquals(Arrays.asList(moreBiscuits, coffee), shop.getProducts());
    }

    @Test
    void doingTheInventory_returnsAllItemsFromTheShop() {
        Shop shop = new Shop("MyShop");
        Product biscuits = new Product("biscuits", 2);
        Product milk = new Product("milk", 1);
        Product coffee = new Product("coffee", 4);
        shop.addNewProduct(biscuits);
        shop.addNewProduct(milk);
        shop.addNewProduct(coffee);

        List<Product> inventory = shop.inventory();

        assertEquals(3, inventory.size());
        assertEquals(Arrays.asList(biscuits, milk, coffee), shop.getProducts());
    }

    @Test
    void gettingCheapProducts_returnsAllItemsWithPriceLowerOrEqualTo2Eur() {
        Shop shop = new Shop("MyShop");
        Product biscuits = new Product("biscuits", 2);
        Product milk = new Product("milk", 1);
        Product coffee = new Product("coffee", 4);
        shop.addNewProduct(biscuits);
        shop.addNewProduct(milk);
        shop.addNewProduct(coffee);

        List<Product> cheapProducts = shop.getCheapProducts();

        assertEquals(2, cheapProducts.size());
    }
}
