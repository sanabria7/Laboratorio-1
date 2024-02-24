/*
Clase que implementa metodos comunes o rutinas especializadas
Autor 1: Samuel Sanabria Castañeda - 2357862
Autor 2: Camilo Diaz - 2357577
Fecha: 21/02/2024
Version 1.0
 */
package laboratorio1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Utilities {
    
    public static int LeerInt(String mensaje){
        String entrada = JOptionPane.showInputDialog(mensaje);
        return Integer.parseInt(entrada); //conversion cadena (entrada) a valor númerico entero (id)
    }
    
    public static int buscarPorId(ArrayList<MedicoGeneral> medicos){
        
        int documento = LeerInt("Ingrese el numero de documento del medico que desea consultar");
        
        for(int i = 0; i < medicos.size(); i++) {
            if(medicos.get(i).getDocumento() == documento) {
                
                return i;
            }    
        }
        
        JOptionPane.showMessageDialog(null, "Usuario no encontrado");
        return -1;
    }
}
