package co.unicauca.restaurante.cliente.acces;

import co.unicauca.restaurante.comunicacion.domain.Componente;
import co.unicauca.restaurante.comunicacion.infra.JsonError;
import co.unicauca.restaurante.comunicacion.infra.Protocol;
import co.unicauca.restaurante.cliente.infra.RestaurantSocket;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ComponenteAccessImplSockets implements IComponenteAccess{
    /**
     * El servicio utiliza un socket para comunicarse con la aplicación server
     */
    private RestaurantSocket mySocket;

    public ComponenteAccessImplSockets() {
        mySocket = new RestaurantSocket();
    }

    /**
     * Busca un plato. Utiliza socket para pedir el servicio al servidor
     *
     * @param id identificador del Componente
     * @return Objeto Componente
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    @Override
    public Componente find(int id) throws Exception {
        String jsonResponse = null;
        String requestJson = findComponentRequestJson(id); //solicitud
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);// envia solicitud
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(DishAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(ComponenteAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el plato
                Componente comp = jsonToComponent(jsonResponse); //convierte jsonToComponente a java(plate)
                return comp;
            }
        }

    }

    /**
     * Crea un  Componente. Utiliza socket para pedir el servicio al servidor
     *
     * @param comp Componente 
     * @return devuelve el identificador del componente creado
     * @throws Exception error crear el componente
     */
    @Override
    public String save(Componente comp) throws Exception {
        String jsonResponse = null;
        String requestJson = createComponentRequestJson(comp);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(ComponenteAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(DishAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente, devuelve el identificador del plato 
                return String.valueOf(comp.getCompId());
            }

        }

    }
    /**
     * Extra los mensajes de la lista de errores
     * @param jsonResponse lista de mensajes json
     * @return Mensajes de error
     */
    private String extractMessages(String jsonResponse) {
        JsonError[] errors = jsonToErrors(jsonResponse);
        String msjs = "";
        for (JsonError error : errors) {
            msjs += error.getMessage();
        }
        return msjs;
    }

    /**
     * Convierte el jsonError a un array de objetos jsonError
     *
     * @param jsonError
     * @return objeto MyError
     */
    private JsonError[] jsonToErrors(String jsonError) {
        Gson gson = new Gson();
        JsonError[] error = gson.fromJson(jsonError, JsonError[].class);
        return error;
    }

    /**
     * Crea una solicitud json para ser enviada por el socket
     *
     *
     * @param idDish identificador del plato
     * @return solicitud de consulta del plato en formato Json, algo como:
     * {"resource":"plate","action":"get","parameters":[{"name":"id","value":"98000001"}]}
     */
    private String findComponentRequestJson(int compID) {

        Protocol protocol = new Protocol();
        protocol.setResource("Component");
        protocol.setAction("get");
        protocol.addParameter("compID", String.valueOf(compID));

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    /**
     * Crea la solicitud json de creación del plato para ser enviado por el
     * socket
     *
     * @param plate objeto Dish
     * @return devuelve algo como:
     * {"resource":"plate","action":"post","parameters":[{"name":"id","value":"980000012"},{"name":"Name","value":"Camarones"},...}]}
     */
    private String createComponentRequestJson(Componente comp) {

        Protocol protocol = new Protocol();
        protocol.setResource("Component");
        protocol.setAction("post");
        protocol.addParameter("compID", String.valueOf(comp.getCompId()));
        protocol.addParameter("compName", comp.getCompNombre());
        protocol.addParameter("compType", comp.getTipo());
        protocol.addParameter("compPrice", String.valueOf(comp.getPrecio()));
        //protocol.addParameterIcon("compImage", comp.getCompImage());
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: " + requestJson);

        return requestJson;
    }

    /**
     * Convierte jsonDish, proveniente del server socket, de json a un
     * objeto Dish
     *
     * @param jsonComponente objeto plato en formato json
     */
    private Componente jsonToComponent(String jsonComponente) {

        Gson gson = new Gson();
        Componente comp = gson.fromJson(jsonComponente, Componente.class);

        return comp;

    }

    @Override
    public boolean update(Componente newComponente) throws Exception {
        Boolean encontrado=false;
        String jsonResponse = null;
        String requestJson = createComponentRequestJson(newComponente); //solicitud
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);// envia solicitud
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(ComponenteAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(ComponenteAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el plato
                Componente comp = jsonToComponent(jsonResponse); //convierte jsonToDish a java(plate)
                encontrado=true;
                return encontrado;
            }
        }
    }

    @Override
    public List<Componente> list() throws Exception {
        //falta implementar
        List<Componente> comps = new ArrayList<>();
        return comps;
    }
}
