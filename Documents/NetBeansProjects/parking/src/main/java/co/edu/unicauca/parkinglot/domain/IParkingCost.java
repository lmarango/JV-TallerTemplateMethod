package co.edu.unicauca.parkinglot.domain;

import java.time.LocalDateTime;

/**
 * Interfaz pública que necesita implementar sus métodos en otras clases especializadas
 * @author lmarango
 */
public interface IParkingCost {
    long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output);
}
