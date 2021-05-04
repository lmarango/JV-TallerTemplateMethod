package co.unicauca.restaurante.cliente.acces;

import co.unicauca.restaurante.comunicacion.domain.User;

/**
 *
 * @author Juan Jose
 */
public interface IUserAccess {
     /**
     * Buscar un Usuario utlizando un socket
     *
     * @param id Id del restaurante
     * @return Objeto restaurant
     * @throws Exception
     */
    public User findUser(String id) throws Exception;

    /**
     * Crea un Usario
     *
     * @param user
     * @return
     * @throws Exception
     */
    public String createUser(User user) throws Exception;
}
