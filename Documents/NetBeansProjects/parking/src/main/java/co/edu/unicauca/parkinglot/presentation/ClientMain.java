package co.edu.unicauca.parkinglot.presentation;

import co.edu.unicauca.parkinglot.access.IVehicleRepository;
import co.edu.unicauca.parkinglot.access.RepositoryFactory;
import co.edu.unicauca.parkinglot.domain.Vehicle;
import co.edu.unicauca.parkinglot.domain.TypeEnum;
import co.edu.unicauca.parkinglot.domain.service.Service;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ClientMain {
    public static void main(String[] args) {
        Vehicle veh = new Vehicle("JNK-838", TypeEnum.TRUCK);
        LocalDateTime input = LocalDateTime.of(2021, Month.FEBRUARY, 22, 8, 0);
        LocalDateTime output = LocalDateTime.of(2021, Month.FEBRUARY, 25, 9, 0);
        IVehicleRepository repo = RepositoryFactory.getInstance().getRepository("default");
        Service service = new Service(repo); //Inyección de dependencias
        long result = service.calculateParkingCost(veh, input, output);
        System.out.println("Valor a pagar por la moto: " + result);
        service.saveVehicle(veh);
        veh = new Vehicle("JNK-124", TypeEnum.CAR);
        service.saveVehicle(veh);
        List<Vehicle> list = service.listVehicles();
        list.forEach(vehicle -> {
        System.out.println(vehicle.toString());
        });
    }
}
