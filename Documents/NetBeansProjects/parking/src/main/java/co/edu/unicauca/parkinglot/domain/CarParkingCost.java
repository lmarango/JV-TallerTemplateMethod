package co.edu.unicauca.parkinglot.domain;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.Month;

/**
 *
 * @author Usuario
 */
public class CarParkingCost implements IParkingCost{
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        return 12000;
    }
}
