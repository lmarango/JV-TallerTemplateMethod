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
public class MotoParkingCost implements IParkingCost {

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        var inH = input.getHour();  //int del tiempo en horas de la entrada
        int inM = input.getMinute();//int del tiempo en minutos de la entrada
        int outH = output.getHour();//Int del tiempo en horas de la salida
        int outM = output.getMinute();//Int del tiempo en minutos de la salida
        int result, aux;
        double cobroPorMinuto = 8.32;//tiempo estipulado por minuto de cobro 500/60
        
        if (outH > inH){
            if (outM >= inM) {
                result = (outH - inH) * 60 + (outM - inM);//calcular coste de minutos adicionales
                if (result <= 60) {
                    return 1000; //si esta por debajo de la tarifa estandar
                } else {
                    int recargo = (int) ((result - 60) * cobroPorMinuto);
                        return ((recargo / 100) * 100) + 100 + 1000; //pasar los numero a enteros y aumentar ceros
                }
            } else {
                outH = outH - 1; // si los minutos de salida son menos que lo de entrada
                outM = outM + 60;
                result = (outH - inH) * 60 + (outM - inM);
                if (result <= 60) {
                    return 1000;
                } else {
                    int recargo = (int) ((result - 60) * cobroPorMinuto);
                    double decimal = (double) recargo / 100;
                    if (decimal - recargo / 100 > 0.50) {
                        return ((recargo / 100) * 100) + 100 + 1000;
                    } else {
                        aux = (int) decimal;
                    }
                    return (aux * 100) + 1000;
                }
            }
        }
        else{
            if (outH == inH) {
                if (outM > inM) {
                    return 1000;
                }
            }
        }
        return 0;
    }
    
}
