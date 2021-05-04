package co.unicauca.restaurante.cliente.acces;

import co.unicauca.restaurante.comunicacion.domain.Componente;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IComponenteAccess {
    /**
     * Guarda un nuevo Plato(Dish) 
     * @param newComponente objeto de tipo Dish 
     * @return  booleano confirmando si la actualización fue exitosa o no.
     * @throws java.lang.Exception
     */
    public String save(Componente newComponente) throws Exception;;
    /**
     * Actualiza un Plato(Dish) 
     * @param newComponente objeto de tipo Dish 
     * @return  booleano confirmando si la actualización fue exitosa o no.
     * @throws java.lang.Exception
     */
    public boolean update(Componente newComponente) throws Exception;
    /**
     * Busca un Plato(Dish) por su codigo
     * @param id identificador del plato
     * @return  objeto de tipo Dish 
     * @throws java.lang.Exception 
     */
    public Componente find(int id) throws Exception;
    /**
     * Lista los Platos(Dish)
     * @return lista de Dish(platos) 
     * @throws java.lang.Exception 
     */
    public List<Componente> list()throws Exception;
}
