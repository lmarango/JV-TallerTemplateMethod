/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.parkinglot.domain;

import java.time.LocalDateTime;

/**
 * Clase que implementa la interfaz pública IparkingCost
 * @author javierda
 */
public class TruckParkingCost implements IParkingCost{
    /**
     * Método que reescribe el método de la interfaz para calcular el costo de parqueo de un vehículo tipo camión
     * @param veh objeto vehículo de tipo camión
     * @param input Tiempo de entrada al paqueadero
     * @param output Tiempo de salida del parqueadero
     * @return 
     */
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        int inD = input.getDayOfYear(); //int variable que guarda el día del parámetro input
        int inH = input.getHour();  //int variable que guarda la hora del parámetro input
        int inM = input.getMinute();//int variable que guarda los minutos del parámetro input
        int outH = output.getHour();//int variable que guarda la hora de parámetro output
        int outM = output.getMinute();//int variable que guarda los minutos del parámetro output
        int outD = output.getDayOfYear(); //int variable que guarda el día del parámetro output
        int varDaysSave = outD - inD; // Dias que estuvo guardado el vehiculo
        int varHoursSave = outH - inH; //horas que estuvo guardado el vehiculo
        int varMinutesSave = outM - outM; // minutos que estuvo guardado el vehiculo
        int costXHora = 625; // valor del parqueadero por hora
        int costXMinute = costXHora / 60; //valor del parqueadero por minuto
        long result = 0;

        if (varDaysSave == 0) {
            if (varHoursSave <= 12) {
                result = 10000;
            } else {
                result = 15000;
            }
        } else {
            result = (varDaysSave * 15000) + (varHoursSave * costXHora) + (varMinutesSave * costXMinute);
        }
        //En el siguiente condicional se redondea la tarifa
        if (result % 100 != 0) {
            result = (result + 100) - (result % 100);
        }
        
        /* Sortear
        if(Sortear(result)){
            return 0;
        }*/
        return result;
    }

    /**
     * Método que sortea por un aleatorio el derecho al parking gratis por el perido de tiempo que esté el vehículo
     * @param result costo del parqueo al retirar el vehículo
     * @return True si el módulo del parametro result modulo el numero aletorio es igual a cero, False de lo contrario
     */
    private boolean Sortear(long result) {
        int numeroAleatorio = (int) (Math.random() * (1000 - 1)) + 1;
        long sorteo = result % numeroAleatorio;
        
        if (sorteo == 0) {
            return true;
        }
        return false;
    }
}
