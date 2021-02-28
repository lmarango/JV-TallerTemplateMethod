package co.edu.unicauca.parkinglot.domain.service;

import co.edu.unicauca.parkinglot.access.IVehicleRepository;
import co.edu.unicauca.parkinglot.domain.IParkingCost;
import co.edu.unicauca.parkinglot.domain.ParkingCostFactory;
import co.edu.unicauca.parkinglot.domain.Vehicle;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Service {
    private IVehicleRepository repository;
    
    public Service(IVehicleRepository repository){
        this.repository = repository;
    }
    
    public long calculateParkingCost(Vehicle veh, LocalDateTime input, LocalDateTime output){
        if (veh == null) {
            return -1;
        }
        IParkingCost delivery = ParkingCostFactory.getInstance().getParkingCost(veh.getType());
        long total = delivery.calculateCost(veh, input, output);
        return total;
    }
    
    public boolean saveVehicle(Vehicle newVehicle){
        if(newVehicle == null || newVehicle.getPlate().isBlank()){
            return false;
        }
        repository.save(newVehicle);
        return true;
    }
    
    public List<Vehicle> listVehicles(){
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles = repository.list();
    
        return vehicles;
    }
    
}
