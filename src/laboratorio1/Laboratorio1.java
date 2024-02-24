/*
Clase que muestra el menu principal para interactuar con la aplicación
Autor 1: Samuel Sanabria Castañeda - 2357862
Autor 2: Camilo Diaz - 2357577
Fecha: 21/02/2024
Version 1.0
 */
package laboratorio1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Laboratorio1 {
    
    private ArrayList<MedicoGeneral> listaMedicos = new ArrayList<>();
    
    public static void main(String[] args) {
        Laboratorio1 lab = new Laboratorio1();
        lab.menu();
        
    }
    
    public void menu(){
        int opc;
        do {            
            opc = Utilities.LeerInt("Menu Principal\n\n" + "1. Gestion de Entidad \n" + "2. Listados \n" + "3. Estadisticas \n" + "4. Acerca de...\n" + "0. Salir");
            switch (opc) {
                case 1: menuEntidaddes(); break;
//                case 2: listadoGeneral(); break;
//                case 3: consultar_ID(); break;
//                case 4: eliminar(); break;
//                case 5: modificar(); break;
//                case 6: JOptionPane.showMessageDialog(null, "Autor: Samuel Sanabria - 202357682\n" + "                           :)\n"); break;
                case 0: break;
//                default: Utilerias.MensajeError("Opcion invalida");
            }
        } while (opc != 0);
    }  
    
    public void menuEntidaddes(){
        int opc;
        do{
            opc = Utilities.LeerInt("Menu Principal\n\n" + "1. Nueva entidad \n" + "2. Consultar entidad \n" + "3. Modificar entidad \n" + "4. Eliminar entidad\n" + "0. Volver al menu principal");
            
            switch (opc) {
                case 1: nuevaEntidad(); break;
                case 2: consultarEntidad(); break;
                case 3: modificarEntidad();
                case 4: eliminarEntidad(); break;
                default:
                    
            }
            
        }while(opc != 0);
    }
   
    public void nuevaEntidad(){
        MedicoGeneral medico = new MedicoGeneral();
        medico.setDocumento();
//        medico.setNombre();
//        medico.setApellido();
//        medico.setJornada();
//        medico.setPacientes();

        listaMedicos.add(medico);
        JOptionPane.showMessageDialog(null, "Se ha creado correctamente una nueva entidad", "Nueva entidad", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void consultarEntidad(){
        
        int index = Utilities.buscarPorId(listaMedicos);
        if(index < 0) return;
        MedicoGeneral medico = listaMedicos.get(index);
        JOptionPane.showMessageDialog(null, medico);
    }
    
    public void modificarEntidad(){
        
        int index = Utilities.buscarPorId(listaMedicos);
        if(index < 0) return;
        MedicoGeneral medico = listaMedicos.get(index);
        String showInputDialog = JOptionPane.showInputDialog(null, "Seleccione el atributo que desea modificar", "Modificar informacion",
            JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Nombre", "Jornada", "Agregar motivo de consulta"}, null).toString();
        
        System.out.println(showInputDialog);
    }
    
    public void eliminarEntidad(){
        
        int index = Utilities.buscarPorId(listaMedicos);
        if(index < 0) return;
      
        listaMedicos.remove(index);
        JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente la entidad", "Eliminar entidad", JOptionPane.INFORMATION_MESSAGE);
    }
}
