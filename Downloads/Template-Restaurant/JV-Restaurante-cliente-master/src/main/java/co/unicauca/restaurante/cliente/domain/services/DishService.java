
package co.unicauca.restaurante.cliente.domain.services;

import co.unicauca.restaurante.cliente.acces.IDishAccess;
import co.unicauca.restaurante.comunicacion.domain.Dish;
import java.util.List;

/**
 * Es una fachada para comunicar la presentación con el
 * dominio
 *
 * @author 
 */
public class DishService {
     private final IDishAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     * @param service implementacion de tipo IDishService
     */
    public DishService(IDishAccess service) {
        this.service = service;
    }

    /**
     * Busca un plato en el servidor remoto
     *
     * @param id identificador del plato especial
     * @return Objeto tipo plato, null si no lo encuentra
     * @throws java.lang.Exception la excepcion se lanza cuando no logra conexión
     * con el servidor
     */
    public Dish find(int id) throws Exception {
        return service.find(id);

    }
    
    public String save(Dish plate) throws Exception {
        return service.save(plate);

    }    
    public boolean update(Dish newDish) throws Exception{
        return service.update(newDish);
    }
    public List<Dish> list() throws Exception{
        return service.list();
    }
}
