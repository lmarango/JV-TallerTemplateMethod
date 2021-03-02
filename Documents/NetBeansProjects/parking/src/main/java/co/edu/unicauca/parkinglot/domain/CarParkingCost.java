package co.edu.unicauca.parkinglot.domain;

import java.time.LocalDateTime;

/**
 * Clase que implementa la interfaz pública IParkingCost
 * @author Usuario
 */
public class CarParkingCost implements IParkingCost{
    /**
     * Metodo que reescribe el método de la Interfaz para calcular el costo de Parqueo de u vehhiculo de tipo Carro
     * @param veh Objeto de tipo vehículo
     * @param input Tiempo de entrada al parqueadero
     * @param output Teimpo de salida del parqueadero
     * @return 
     */
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        int inH = input.getHour();  //Int del tiempo en horas de la entrada
        int inM = input.getMinute();//int del tiempo en minutos de la entrada
        int outH = output.getHour(); //Int del tiempo en horas de la salida
        int outM = output.getMinute(); //Int del tiempo en minutos de la salida
        int res,aux;
        double cobroPorMinuto= 16.67;//tiempo estipulado por minuto de cobro 1000/60
        if( outH > inH  )//que la hora de entrada sea menor a la de salida
        {
            if (outM >= inM){                //comprobacion de minutos
                res = (outH - inH)*60 + (outM - inM);//calcular coste de minutos adicionales
                if (res <= 60){
                    return 2000; //si esta por debajo de la tarifa estandar
                }else{
                    int recargo =(int) ((res - 60) * cobroPorMinuto); 
                    double decimal = (double)recargo/100;//redondear el numero a 100
                    if (decimal-recargo/100>0) {
                        return ((recargo/100)*100)+100+2000; //pasar los numero a enteros y aumentar ceros
                    }
                    else{
                        aux = (int) decimal;
                        return (aux*100)+2000;     //si no hay que redondear 
                    }
                }
            }else{
                outH = outH - 1;  // si los minutos de salida son menos que lo de entrada
                outM = outM + 60;
                res = (outH - inH)*60 + (outM - inM); 
                if (res <= 60){
                    return 2000;
                }else{
                    int recargo =(int) ((res - 60)*cobroPorMinuto);
                    double decimal = (double)recargo/100;
                    if (decimal-recargo/100>0) {
                        return ((recargo/100)*100)+100+2000; //pasar los numero a enteros y aumentar ceros
                    }
                    else{
                        aux = (int) decimal;
                        return (aux*100)+2000;     //si no hay que redondear 
                    }
                }
            }
            
        }else{
            if(outH == inH ){
                if(outM > inM){
                    return 2000;
                }
            }
        }        
        return 0;
    }
}
