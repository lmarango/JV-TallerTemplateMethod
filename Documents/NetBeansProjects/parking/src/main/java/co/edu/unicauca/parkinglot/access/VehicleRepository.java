package co.edu.unicauca.parkinglot.access;

import co.edu.unicauca.parkinglot.domain.TypeEnum;
import co.edu.unicauca.parkinglot.domain.Vehicle;
import co.edu.unicauca.parkinglot.domain.service.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class VehicleRepository implements IVehicleRepository {

    /**
     * Objeto de tipo Connection para la base de datos
     */
    private Connection conn;
    
    public VehicleRepository(){
        initDatabase();
    }
    
    /**
     * Método publico que retorna el exito o fracaso al guardar un vehículo en la base de datos.
     * @param newVehicle Nuevo objeto de tipo vehículo que se almacenará.
     * @return True si guardó correctamente el nuevo vehículo, False de lo contrario.
     */
    @Override
    public boolean save(Vehicle newVehicle) {
        try {
            if (newVehicle == null || newVehicle.getPlate().isBlank()) {
                return false;
            }
            String sql = "INSERT INTO Vehicle(Plate, Type) "
                    + "VALUES ( ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newVehicle.getPlate());
            pstmt.setString(2, newVehicle.getType().name());
            pstmt.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Vehicle> list() {
        List<Vehicle> vehicles = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Vehicle";
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Vehicle newVehicle = new Vehicle();
                
                newVehicle.setPlate(rs.getString("Plate"));
                newVehicle.setType(TypeEnum.valueOf(rs.getString("Type")));
                
                vehicles.add(newVehicle);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicles;
    }
    
    private void initDatabase() {

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Vehicle (\n"
                + "	Plate text PRIMARY KEY,\n"
                + "	Type text NOT NULL\n"
                + ");";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que se encarga de realizar la conexión a la base de datos
     */
    public void connect() {
        //SQLite connection string
        //String url = "jdbc:sqlite:./mydatabase.db";
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que se encarga de cerrar la conexión a la base de datos
     */
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
