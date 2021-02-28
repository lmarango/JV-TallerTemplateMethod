package co.edu.unicauca.parkinglot.access;

/**
 *
 * @author Usuario
 */
public class RepositoryFactory {
    private static RepositoryFactory instance;
    
    private RepositoryFactory(){
        
    }
    
    public static RepositoryFactory getInstance(){
        if(instance == null){
            instance = new RepositoryFactory();
        }
        return instance;
    }
    
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
