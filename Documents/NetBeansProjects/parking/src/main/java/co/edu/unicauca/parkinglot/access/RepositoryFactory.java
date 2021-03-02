package co.edu.unicauca.parkinglot.access;

/**
 * Fabrica de Repositorio
 * @author lmarango
 */
public class RepositoryFactory {
    /**
     * Atributo privado que crea una instancia de la clase
     */ 
    private static RepositoryFactory instance;
    /**
     * COnstructor privado por defecto
     */
    private RepositoryFactory(){
        
    }
    /**
     * metodo público estatico que obtiene la instancia o la crea de no exitir.
     * @return instancia de la clase
     */
    public static RepositoryFactory getInstance(){
        if(instance == null){
            instance = new RepositoryFactory();
        }
        return instance;
    }
    /**
     * Método público que pbtiene el repositorio de la interfaz IvehicleRepository
     * @param type Tipo del vehículo
     * @return repositorio dl vehículo.
     */
    public IVehicleRepository getRepository(String type){
       IVehicleRepository result = null;
       
       switch (type) {
           case "default": 
               result = new VehicleRepository();
               break;
       }
       return result;
    }
}
