package co.edu.unicauca.parkinglot.domain;

import java.time.LocalDateTime;

/**
 *
 * @author Usuario
 */
public class CarParkingCost implements IParkingCost{
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
                        return ((recargo/100)*100)+100+2000; //pasar los numero a enteros y aumentar ceros
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
                    if(decimal-recargo/100>0.50)
                        return ((recargo/100)*100)+100+2000;
                    else
                        aux = (int) decimal;
                        return (aux*100)+2000;                  
                }
            }
            
        }else{
            if(outH == inH ){
                if(outM > outM){
                    return 2000;
                }
            }
        }        
        return 0;
    }
}
