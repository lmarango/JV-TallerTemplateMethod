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
        int varEntradaH = input.getHour();  //int del tiempo en horas de la entrada
        int varEntradaM = input.getMinute();//int del tiempo en minutos de la entrada
        int varSalidaH = output.getHour();//Int del tiempo en horas de la salida
        int varSalidaM = output.getMinute();//Int del tiempo en minutos de la salida
        int result, aux;
        double cobroPorMinuto = 8.32;//tiempo estipulado por minuto de cobro 500/60
        
        if (varSalidaH > varEntradaH){
            if (varSalidaM >= varEntradaM) {
                result = (varSalidaH - varEntradaH) * 60 + (varSalidaM - varEntradaM);//calcular coste de minutos adicionales
                if (result <= 60) {
                    return 1000; //si esta por debajo de la tarifa estandar
                } else {
                    int recargo = (int) ((result - 60) * cobroPorMinuto);
                    //double decimal = (double) recargo / 100; //redondear el numero a 100
                    //if (decimal - recargo / 100 > 0.50) {
                        return ((recargo / 100) * 100) + 100 + 1000; //pasar los numero a enteros y aumentar ceros
                    //} else {
                      //  aux = (int) decimal;
                    //}
                    //return (aux * 100) + 1000;     //si no hay que redondear                        
                }
            } else {
                varSalidaH = varSalidaH - 1; // si los minutos de salida son menos que lo de entrada
                varSalidaM = varSalidaM + 60;
                result = (varSalidaH - varEntradaH) * 60 + (varSalidaM - varEntradaM);
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
            if (varSalidaH == varEntradaH) {
                if (varSalidaM > varEntradaM) {
                    return 1000;
                }
            }
        }
        return 0;
    }
    
}
