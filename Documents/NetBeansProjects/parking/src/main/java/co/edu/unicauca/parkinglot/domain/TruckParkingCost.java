/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.parkinglot.domain;

import java.time.LocalDateTime;

/**
 *
 * @author Usuario
 */
public class TruckParkingCost implements IParkingCost{

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        return 25000;
    }
    
}
