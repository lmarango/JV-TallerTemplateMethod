package co.unicauca.microkernel.business;

import co.unicauca.microkernel.common.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    public List<Product> getAll() {

        List<Product> products = new ArrayList<>();

        /*En un escenario normal, los productos vendrían de la capa de acceso a datos.
         * Para este ejemplo, se crearán objetos de prueba directamente aquí.
         * */
        Product productOne = new Product(1, "Play Station 4", 2.1, 26.5, 3.9, 28.8);
        Product productTwo = new Product(2, "Xbox One", 3.2, 27.4, 7.9, 33.3);
        Product productThree = new Product(3, "Wii U", 1.5, 17.2, 4.6, 26.9);
        Product productFour = new Product(4, "Nintendo Swtich", 1.7, 19.5, 5.2, 4.3);
        Product productFive = new Product(4, "Silla Gamer", 17.8, 65.7, 112.2, 58.2);

        products.add(productOne);
        products.add(productTwo);
        products.add(productThree);
        products.add(productFour);
        products.add(productFive);

        return products;
    }

}
