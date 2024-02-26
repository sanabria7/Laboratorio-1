/*
Clase que implementa metodos comunes o rutinas especializadas
Autor 1: Samuel Sanabria Castañeda - 2357862
Autor 2: Camilo Diaz - 2357577
Fecha: 25/02/2024
Version 1.1
 */
package laboratorio1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Utilities {
    
    public static int leerInt(String mensaje){
        String entrada = JOptionPane.showInputDialog(mensaje);
        return Integer.parseInt(entrada); //conversion cadena (entrada) a valor númerico entero (id)
    }
    
    public static int buscarPorId(ArrayList<MedicoGeneral> medicos){

        int documento = leerInt("Ingrese el numero de documento del medico que desea consultar");
        int index = validarDocumento(medicos, documento);

        if(index == -1) JOptionPane.showMessageDialog(null, "Usuario no encontrado");
        return index;
    }

    public static int validarDocumento(ArrayList<MedicoGeneral> medicos, int documento){
        for(int i = 0; i < medicos.size(); i++) {
            if(medicos.get(i).getDocumento() == documento) {

                return i;
            }
        }
        return -1;
    }
    
    public static String showInputDialog(String titulo, String mensaje, String[] opciones){
        return JOptionPane.showInputDialog(null, mensaje, titulo,
                JOptionPane.QUESTION_MESSAGE, null, opciones, null)
                .toString();

    }
    
    public static void MensajeError(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
