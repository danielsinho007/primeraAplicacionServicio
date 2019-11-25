
import entidades.Persona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import negocio.PersonasNegocio;
import org.primefaces.component.commandbutton.CommandButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willy
 */
public class PrimerManagedBean implements Serializable {
    private CommandButton cb1 = new CommandButton();
    PersonasNegocio pn = new PersonasNegocio();
    private List<Persona> listarPersonas = new ArrayList<Persona>();

    /**
     * Creates a new instance of PrimerManagedBean
     */
    public PrimerManagedBean() {
    }
    
    public String responder(){
        System.out.println("respondo a la acción");
       return null;
    }
    
   

    /**
     * @return the cb1
     */
    public CommandButton getCb1() {
        return cb1;
    }

    /**
     * @param cb1 the cb1 to set
     */
    public void setCb1(CommandButton cb1) {
        this.cb1 = cb1;
    }

    /**
     * @return the listarPersonas
     */
    public List<Persona> getListarPersonas() {
        listarPersonas = pn.listarPersonas();
        return listarPersonas;
    }

    /**
     * @param listarPersonas the listarPersonas to set
     */
    public void setListarPersonas(List<Persona> listarPersonas) {
        this.listarPersonas = listarPersonas;
    }
    
}
