/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ControllMaster;

/**
 *
 * @author Duvan Felipe
 */
public interface ActiosUsers {
    
    
    //---------------Acciones de ficha ------------
    
    final String AÑADIRFICHA= "Añadir Ficha";
    final String MODIFICARFICHA="Modificar Ficha";
    final String ELIMINARFICHA="Eliminar Ficha";
    final String MOSTRARFICHA="Mostrar Fichas";
    
    //---------------Acciones de autor ------------
    
    final String AÑADIRAUTOR= "Añadir Autor";
    final String MODIFICARAUTOR="Modificar Autor";
    final String ELIMINARAUTOR="Eliminar Autor";
    final String MOSTRARAUTOR="Mostrar Autor";
    
    
    String [] readInput(String option);
    void writeOutput(String option, String[] output, boolean state);
    void setControll(ControllMaster controll);
    void begin();
    void exit();
    
}
