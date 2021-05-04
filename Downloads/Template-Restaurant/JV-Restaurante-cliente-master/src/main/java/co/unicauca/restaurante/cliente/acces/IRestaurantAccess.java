package co.unicauca.restaurante.cliente.acces;

import co.unicauca.restaurante.comunicacion.domain.Restaurant;
import java.util.List;

/**
 *
 * @author Juan Jose
 */
public interface IRestaurantAccess {
     /**
     * Buscar un restaurante utlizando un socket
     *
     * @param id Id del restaurante
     * @return Objeto restaurant
     * @throws Exception
     */
    public Restaurant findRestaurant(String id) throws Exception;

    /**
     * Crea un Restaurant
     *
     * @param restaurant
     * @return
     * @throws Exception
     */
    public String createRestaurant(Restaurant restaurant) throws Exception;

    /**
     * Retorna una lista con todos los restaurantes registrados previamente.
     *
     * @return List<Restaurant> Lista de restaurantes
     * @throws Exception
     */
    public List<Restaurant> ListRestaurant() throws Exception;
}
