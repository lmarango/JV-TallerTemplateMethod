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

    // <editor-fold desc="Getters">>
    public String getPlate() {
        return plate;
    }

    public TypeEnum getType() {
        return type;
    }
    //</editor-fold>
    // <editor-fold desc="Setters">>
    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }
    //</editor-fold>
}
