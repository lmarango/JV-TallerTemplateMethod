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
        int inH = input.getHour();//Hora de entrada
        int inM = input.getMinute();//Minutos de entrada
        int inD = input.getDayOfYear();//Dias de entrada
        int outH = output.getHour();//Hora de entrada
        int outM = output.getMinute();//Minutos de entrada
        int outD = output.getDayOfYear();//Dias de entrada
        int result;
        double cobroPorMinuto = 16.67;

        if (outH > inH) {
            if (outM >= inM) {
                result = (outH - outH) * 60 + (outM - inM);
                if (result <= 60) {
                    return 2000;
                } else {
                    int recargo = (int) ((result - 60) * 8.32);
                    int aux = (int) (recargo / 100);
                    if (aux - recargo / 100 > 50) {
                        return recargo + 100 + 2000;
                    } else {
                        return aux * 100 + 2000;
                    }
                }
            } else {
                outH = outH - 1;
                outM = outM + 60;
                result = (outH - inH) * 60 + (outM - inM);
                if (result <= 60) {
                    return 2000;
                } else {
                    int recargo = (int) ((result - 60) * 8.32);
                    int aux = (int) (recargo / 100);
                    if (aux - recargo / 100 > 50) {
                        return recargo + 100 + 1000;
                    } else {
                        return aux * 100 + 2000;
                    }
                }
            }

        } else {
            if (outH == inH) {
                if (outM > inM) {
                    return 2000;
                }
            }
        }
        return 0;
    }
}
