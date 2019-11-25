/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Persona;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import negocio.PersonasNegocio;

/**
 *
 * @author danimocr
 */
@WebService(serviceName = "WebServicePersona")
public class WebServicePersona {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "listarPersonas")
    public List<Persona> listarPersonas() {
        PersonasNegocio pn = new PersonasNegocio();
        return pn.listarPersonas();
    }
}
