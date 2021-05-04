
package co.unicauca.restaurante.cliente.domain.services;

import co.unicauca.restaurante.cliente.acces.IComponenteAccess;
import co.unicauca.restaurante.comunicacion.domain.Componente;
import java.util.List;

/**
 *
 * @author Luis , Juan Jose
 */
public class ComponenteService {
    private final IComponenteAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     * @param service implementacion de tipo IDishService
     */
    public ComponenteService(IComponenteAccess service) {
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
    public Componente find(int id) throws Exception {
        return service.find(id);

    }
    
    public String save(Componente comp) throws Exception {
        return service.save(comp);

    }    
    public boolean update(Componente newComp) throws Exception{
        return service.update(newComp);
    }
    public List<Componente> list() throws Exception{
        return service.list();
    }
}
