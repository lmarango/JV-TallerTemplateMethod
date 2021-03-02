package co.edu.unicauca.parkinglot.domain;

/**
 *
 * @author Usuario
 */
public class Vehicle {
    // <editor-fold desc="Atributos">>
    /**
     * Placa del vehículo
     */
    private String  plate;
    /**
     *Tipo: Automovil, motocicleta, camion
     */
    private TypeEnum  type;
    //</editor-fold>
    // <editor-fold desc="Constructores">>
    /**
     * Constructor Parametrizado
     * @param plate placa del vehículo
     * @param tipo Tipo Vehículo
     */
    public Vehicle(String plate, TypeEnum tipo){
        this.plate = plate;
        this.type = tipo;
    }
    /**
     * Constructor por defecto
     */
    public Vehicle(){
    }
    // </editor-fold>
    // <editor-fold desc="Getters">>
    /**
     * Método que obtiene la placa del vehículo
     * @return String placa del cehículo
     */
    public String getPlate() {
        return plate;
    }
    /**
     * Método que obtiene el tipo del vehículo
     * @return TypeEnum tipo del vehiculo
     */
    public TypeEnum getType() {
        return type;
    }
    //</editor-fold>
    // <editor-fold desc="Setters">>
    /**
     * Método que modifica la placa de un vehículo
     * @param plate String nueva placa del vehículo
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }
    /**
     * Método que modifica el tipo del vehículo
     * @param type TypeEnum nuevo tipo del vehículo
     */
    public void setType(TypeEnum type) {
        this.type = type;
    }
    //</editor-fold>
    // <editor-fold desc="Métodos">>
    /**
     * Sobrecarga del método toString.
     * @return String retorna placa y tipo del vehículo
     */
    @Override
    public String toString(){
        return "Vehicle{plate="+plate+", type: "+type.toString();
    }
    // </editor-fold>
}
