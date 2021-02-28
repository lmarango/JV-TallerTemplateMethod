package co.edu.unicauca.parkinglot.domain;

import java.time.LocalDateTime;
import java.time.Month;

/**
 *
 * @author Usuario
 */
public interface IParkingCost {
    long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output);
}
