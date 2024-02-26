/*
Clase que representa la entidad dentro del sistema
Autor 1: Samuel Sanabria Castañeda - 2357862
Autor 2: Camilo Diaz - 2357577
Fecha: 25/02/2024
Version 1.1
 */
package laboratorio1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MedicoGeneral {
    
    int documento;
    String nombre, apellido, jornada;
    
    private String[] motivosConsulta ={"Consulta medica general", "Urgencia medica", "Cita de control"};
    ArrayList<String> consultas;

    public MedicoGeneral() {
        documento = 0;
        nombre = apellido = jornada = " ";
        consultas = new ArrayList<>();
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }
    
    public void setDocumento(ArrayList<MedicoGeneral> lista){
        int opc, id;
        do{
            id = Utilities.leerInt("Ingrese el número de documento: ");
            opc = Utilities.validarDocumento(lista, id);
            if(opc != -1) JOptionPane.showMessageDialog(null, "El documento ingresado ya existe en el sistema");
        }while (opc != -1);
        documento = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setNombre() {
        nombre = JOptionPane.showInputDialog("Ingrese el nombre del medico:");
    }


    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public void setApellido() {
        apellido = JOptionPane.showInputDialog("Ingrese el apellido del medico:");
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }
    
    public void setJornada() {
        
        jornada = Utilities.showInputDialog("Jornada laboral", "Ingrese la jornada laboral del medico"
                , new String[]{"Diurna", "Nocturna"});
    }

    public ArrayList<String> getConsultas() {
        return consultas;
    }
    
    public void setConsultas() {

        int cantidad = Utilities.leerInt("Digite el numero de pacientes de consulta que desea ingresar");
        for (int i = 0; i < cantidad; i++){
            String consulta = Utilities.showInputDialog("Consultas", "Elija el motivo de consulta del paciente " + (i + 1), motivosConsulta);
            consultas.add(consulta);
        }
    }
    
    public void setConsulta(){
        int consultaIndex = 1;
        if(consultas.size() > 1) {
            consultaIndex = Utilities.leerInt("Digite de 1 a " + consultas.size() + " el paciente que desea modificar");
        }
        String consulta = Utilities.showInputDialog("Consultas", "Elija el motivo de consulta del paciente "
                + consultaIndex, motivosConsulta);
        consultaIndex--;
        consultas.set(consultaIndex, consulta);
    }

    public String[] getMotivosConsulta() {
        return motivosConsulta;
    }

    @Override
    public String toString() {
        String consultasString = "";
        if(consultas.size() > 0){

            for (int i = 0; i < consultas.size(); i++){
                consultasString += "\n    Paciente " + (i + 1) + ": " + consultas.get(i);
            }
            consultasString += "\n   }";

        }
        return  "\n   Documento: " + documento + "\n   Nombre: " + nombre + "\n   Apellido: " + apellido
                + "\n   Jornada: " + jornada + "\n   Consultas: {" + consultasString;
    }
}
