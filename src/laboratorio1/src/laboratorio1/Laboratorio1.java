/*
Clase que muestra el menu principal para interactuar con la aplicación
Autor 1: Samuel Sanabria Castañeda - 2357862
Autor 2: Camilo Diaz - 2357577
Fecha: 25/02/2024
Version 1.1
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
            opc = Utilities.leerInt("""
                                    Menu Principal
                                    
                                    1. Gestion de Entidad 
                                    2. Listados 
                                    3. Estadisticas 
                                    4. Acerca de...
                                    0. Salir""");
            switch (opc) {
                case 1 -> menuEntidades();
                case 2 -> menuListados();
                case 3 -> menuEstadisticas(); 
                case 4 -> JOptionPane.showMessageDialog(null, """
                                                            Autor 1: Samuel Sanabria - 202357682
                                                            Autor 2: Camilo Diaz - 202357577 
                                                                                       :)
                                                            """);
                case 0 -> {
                }
                default -> Utilities.MensajeError("Opcion invalida");
            }
        } while (opc != 0);
    }  
    
    public void menuEntidades(){
        int opc;
        do{
            opc = Utilities.leerInt("""
                                    Menu Entidades
                                    
                                    1. Nueva entidad 
                                    2. Consultar entidad 
                                    3. Modificar entidad 
                                    4. Eliminar entidad
                                    0. Volver al menu principal""");
            
            switch (opc) {
                case 1 -> nuevaEntidad();
                case 2 -> consultarEntidad();
                case 3 -> modificarEntidad();
                case 4 -> eliminarEntidad();
                case 0 -> {
                }    
                default -> Utilities.MensajeError("Opcion invalida");
            }
            
        }while(opc != 0);
    }
   
    public void nuevaEntidad(){
        MedicoGeneral medico = new MedicoGeneral();
        medico.setDocumento(listaMedicos);
        medico.setNombre();
        medico.setApellido();
        medico.setJornada();
        medico.setConsultas();

        listaMedicos.add(medico);
        JOptionPane.showMessageDialog(null, "Se ha creado correctamente una nueva entidad", "Nueva entidad", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void consultarEntidad(){
        
        int index = Utilities.buscarPorId(listaMedicos);
        if(index < 0) return;
        MedicoGeneral medico = listaMedicos.get(index);
        JOptionPane.showMessageDialog(null, "Medico general: "+medico);
    }
    
    public void modificarEntidad(){
        
        String[] opciones = {"Nombre", "Jornada", "Modificar motivo de consulta"};
        int index = Utilities.buscarPorId(listaMedicos);
        if(index < 0) return;
        MedicoGeneral medico = listaMedicos.get(index);
        
        String opc = Utilities.showInputDialog("Modificar informacion", "Seleccione el atributo que desea modificar", opciones);
        
        if(opciones[0].equals(opc)) medico.setNombre();
        if(opciones[1].equals(opc)) medico.setJornada();
        if(opciones[2].equals(opc)) medico.setConsulta();

    }
    
    public void eliminarEntidad(){
        
        String mensaje = "";
        int index = Utilities.buscarPorId(listaMedicos);
        if(index < 0) return;
        MedicoGeneral medico = listaMedicos.get(index);
        int opc = JOptionPane.showConfirmDialog(null, "¿Esta seguro de que desea eliminar la entidad?\n" + medico
                , "Eliminar entidad", 0);
        if(opc == 0){
            mensaje ="Se ha eliminado correctamente la entidad";
            listaMedicos.remove(index);
        }else mensaje = "Se ha cancelado la eliminacion de la entidad";
        JOptionPane.showMessageDialog(null, mensaje, "Eliminar entidad", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void menuListados(){

        int opc;
        do{
            opc = Utilities.leerInt("""
                                    Menu Listados
                                    
                                    1. Listado general de entidades 
                                    2. Listar medicos por numero de pacientes 
                                    0. Salir""");
            
            switch (opc) {
                case 1 -> listadoGeneral();
                case 2 -> consultarListado();
                case 0 -> {
                }
                default -> Utilities.MensajeError("Opcion invalida");
            }
            
        }while(opc != 0);
        
    }
    
    public void listadoGeneral(){
        int cont = 0;
        for(MedicoGeneral medico : listaMedicos){
            cont++;
            System.out.println("Medico "+cont+": "+medico);
        }
    }
    
    public void consultarListado(){
        int cont = 0;
        int cantidad = Utilities.leerInt("Ingrese el número de pacientes:");
        System.out.println("Medicos con "+ cantidad+ " pacientes");
        for(MedicoGeneral medico : listaMedicos){
            if(cantidad == medico.getConsultas().size()){
                cont++;
                System.out.println("Medico "+cont+": "+medico);
            }
        }
    }
    
    public void menuEstadisticas(){
        
        int opc = JOptionPane.showOptionDialog(null, "Seleccione la estadistica que desea consultar:\n     1. Cantidad de pacientes por consulta     \n     2. Promedio pacientes por medico     \n     3. Porcentaje pacientes por jornada", "Menu de Estadisticas", 0, 1, null, new String[] {"Estadistica 1", "Estadistica 2", "Estadistica 3"}, null);
        
        if(opc == 0) Estadisticas.estadistica1(listaMedicos);
        if(opc == 1) Estadisticas.estadistica2(listaMedicos);
        if(opc == 2) Estadisticas.estadistica3(listaMedicos);
    }
}
