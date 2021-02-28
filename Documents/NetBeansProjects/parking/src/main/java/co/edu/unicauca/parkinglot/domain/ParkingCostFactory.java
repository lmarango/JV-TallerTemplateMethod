package co.edu.unicauca.parkinglot.domain;

import java.util.EnumMap;
import java.util.Map;
/**
 *
 * @author Usuario
 */
public class ParkingCostFactory {
    private Map<TypeEnum, IParkingCost> dictionary;
    
    // Singleton
    private static ParkingCostFactory instance;

    private ParkingCostFactory() {
        dictionary = new EnumMap<>(TypeEnum.class);
        dictionary.put(TypeEnum.CAR, new CarParkingCost());
        dictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        dictionary.put(TypeEnum.TRUCK, new TruckParkingCost());
    }
    
    public static ParkingCostFactory getInstance(){
        if (instance == null) {
            instance = new ParkingCostFactory();
        }
        return instance;
    }
    
    public IParkingCost getParkingCost(TypeEnum type){
        IParkingCost result = null;
        
        if (dictionary.containsKey(type)) {
            result = dictionary.get(type);
        }
        
        return result;
    }
}
