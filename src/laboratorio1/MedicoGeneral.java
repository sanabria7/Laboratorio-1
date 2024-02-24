/*
Clase que representa la entidad dentro del sistema
Autor 1: Samuel Sanabria Castañeda - 2357862
Autor 2: Camilo Diaz - 2357577
Fecha: 21/02/2024
Version 1.0
 */
package laboratorio1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MedicoGeneral {
    
    int documento;
    String nombre, apellido, jornada;
    
    ArrayList<String> pacientes;

    public MedicoGeneral() {
        documento = 0;
        nombre = apellido = jornada = " ";
        pacientes = new ArrayList<>();
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }
    
    public void setDocumento(){
        documento = Utilities.LeerInt("Ingrese el número de documento: ");
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
        jornada = JOptionPane.showInputDialog("Ingrese la jornada del medico:");
    }

    public ArrayList<String> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<String> pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public String toString() {
        return "MedicoGeneral{" + "documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido + ", jornada=" + jornada + ", pacientes=" + pacientes + '}';
    }   
}
