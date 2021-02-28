package co.edu.unicauca.parkinglot.access;

import co.edu.unicauca.parkinglot.domain.Vehicle;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IVehicleRepository {
    boolean save(Vehicle newVehicle);
    List<Vehicle> list();
}
