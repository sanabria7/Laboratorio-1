/*
Clase que implementa metodos para las estadisticas
Autor 1: Samuel Sanabria Castañeda - 2357862
Autor 2: Camilo Diaz - 2357577
Fecha: 25/02/2024
Version 1.1
 */
package laboratorio1;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Estadisticas {
    
    public static void estadistica1(ArrayList<MedicoGeneral> lista){
        int consulta1, consulta2, consulta3;
        consulta1 = consulta2 = consulta3 = 0;
        String[] motivosConsulta = lista.get(0).getMotivosConsulta();
        for(MedicoGeneral medico : lista){
            for(String consulta : medico.getConsultas()){
                if(consulta.equals(medico.getMotivosConsulta()[0])) consulta1++;
                if(consulta.equals(medico.getMotivosConsulta()[1])) consulta2++;
                if(consulta.equals(medico.getMotivosConsulta()[2])) consulta3++;
            }
        }
        String mensaje = "Cantidad de pacientes por consulta: \n     " + motivosConsulta[0] + "= " + consulta1 + "\n     " + motivosConsulta[1] + "= " + consulta2 + "\n     " + motivosConsulta[2] + "= " + consulta3;
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public static void estadistica2(ArrayList<MedicoGeneral> lista){
        
        int cont = 0;
        double promedio;
        for(MedicoGeneral medico : lista){
            cont += medico.getConsultas().size();
        }
        promedio = (cont / lista.size());
        String mensaje = "Promedio de pacientes por medico: \n     Total medicos = " + lista.size() +  "\n     Total pacientes = " + cont + "\n     Promedio pacientes por medico = " + promedio;
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public static void estadistica3(ArrayList<MedicoGeneral> lista){
        
        int contdia, contnoche, contTotal;
        contdia = contnoche = 0;
        double porcentajeDia, porcentajeNoche;
        for(MedicoGeneral medico : lista){
            if("Diurna".equals(medico.getJornada())){
                contdia += medico.getConsultas().size();
                
            }else{
                contnoche += medico.getConsultas().size();
                
            }
            
        }
        contTotal = contdia + contnoche;
        porcentajeDia = contdia * 100.0 / contTotal ;
        porcentajeNoche = (contnoche * 100.0 / contTotal) ;
        System.out.println(porcentajeDia);
        String mensaje = "Porcentaje de pacientes por jornada: \n     Total pacientes = " + contTotal +  "\n     Total pacientes [Diurno] = " + contdia + "\n     Total pacientes [Nocturno] = " + contnoche +
                "\n     Porcentaje pacientes [Diurno]: " + porcentajeDia + "%" + "\n     Porcentaje pacientes [Nocturno]: " + porcentajeNoche +"%";
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
