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
    /**
     * Atributo privado que hará la función de repositorio
     */
    private IVehicleRepository repository;
    /**
     * Constructor parametrizado
     * @param repository repositorio del servicio
     */
    public Service(IVehicleRepository repository){
        this.repository = repository;
    }
    
    /**
     * Calcula el costo del parqueo
     * @param veh objeto de tipo vehículo 
     * @param input hora de entrada del objeto al parqueadero
     * @param output hora de salida del objeto del parqueadero
     * @return valor a pagar por parking, -1 si el vehículo es nulo
     */
    public long calculateParkingCost(Vehicle veh, LocalDateTime input, LocalDateTime output){
        if (veh == null) {
            return -1;
        }
        IParkingCost delivery = ParkingCostFactory.getInstance().getParkingCost(veh.getType());
        long total = delivery.calculateCost(veh, input, output);
        return total;
    }
    
    /**
     * Método que guarda un vehículo en la base de datos 
     * @param newVehicle nuevo objeto de tipo Vehiculo que va a serr guardado
     * @return True si es exitoso el proceso de guardado, false de lo contrario
     */
    public boolean saveVehicle(Vehicle newVehicle){
        if(newVehicle == null || newVehicle.getPlate().isBlank()){
            return false;
        }
        repository.save(newVehicle);
        return true;
    }
    
    /**
     * Método que obtiene la lista de los vehículos de la base de datos
     * @return Lista de vehículos
     */
    public List<Vehicle> listVehicles(){
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles = repository.list();
    
        return vehicles;
    }
    
}
