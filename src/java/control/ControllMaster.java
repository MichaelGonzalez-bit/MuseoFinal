/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.FichaEjemplar;
import modelo.MagnamentAutor;
import modelo.MagnamentFicha;
import vista.ActiosUsers;


/**
 *
 * @author Duvan Felipe
 */
public class ControllMaster implements ActionListener, WindowListener{
    
    private MagnamentFicha magFicha;
    private ActiosUsers view;

    public ControllMaster(ActiosUsers view) {
        
        this.magFicha = new MagnamentFicha();
        this.view = view;
    }
  
    @Override
    public void actionPerformed(ActionEvent arg) {
        
     
        switch(arg.getActionCommand()){
            case ActiosUsers.AÑADIRFICHA:
                
            {
                try {
                    this.añadirFicha();
                } catch (ParseException ex) {
                    Logger.getLogger(ControllMaster.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             
            break;

            case ActiosUsers.MODIFICARFICHA:
                
            {
                try {
                    this.modificarFicha();
                } catch (ParseException ex) {
                    Logger.getLogger(ControllMaster.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
      
            break;

            case ActiosUsers.ELIMINARFICHA: 
                
                this.eliminarFicha();
          
            break;
            case ActiosUsers.MOSTRARFICHA:
                
                this.mostrarFicha();
              
            break;   
        }        
    }
    
    private void añadirFicha() throws ParseException {
        
        String[] input=view.readInput(ActiosUsers.AÑADIRFICHA);
        
        if(input!=null){
            
            
            int id = (int) (Math.random() * 9999999) + 1000000;
            String nombre = input[0];
            String filum=input[1];
            String tamaño=input[2];
            double peso= Double.parseDouble(input[3]);
            int idYacimiento=(int) (Math.random() * 9999999) + 1000000;;
            String nombreYacimi=input[4];
            double latitud=Double.parseDouble(input[5]);
            double longitud=Double.parseDouble(input[6]);
            //datos fecha
            String[] date= input[7].split("/");
            int day=Integer.parseInt(date[0]);
            int mes=Integer.parseInt(date[1])-1;
            int año=Integer.parseInt(date[2]);
            DateFormat format=new SimpleDateFormat("DD/MM/YYYY");
            Date fecha=format.parse(day+"/"+mes+"/"+año);
            int edadEjmeplar=Integer.parseInt(input[8]);
            int idAutor= Integer.parseInt(input[9]);
            
            boolean state=magFicha.añadirFicha(id, nombre, filum, tamaño, peso, idYacimiento, nombreYacimi, latitud, longitud, fecha, edadEjmeplar, idAutor);
            input[0]= id+"";
            view.writeOutput(ActiosUsers.AÑADIRFICHA, input, state);
        }
        
    }
    

    private void modificarFicha() throws ParseException {
        
        String[] input = view.readInput(ActiosUsers.MODIFICARFICHA);
        int id=Integer.parseInt(input[0]);
        String option=input[1];
        String valor=input[2];
  
        boolean state= magFicha.modificarFicha(id, option, valor); 
        view.writeOutput(ActiosUsers.MODIFICARFICHA, input, state);
        
    }

    private void eliminarFicha() {
        String[] input = view.readInput(ActiosUsers.ELIMINARFICHA);
        
        boolean state= magFicha.eliminarFicha(Integer.parseInt(input[0]));
        view.writeOutput(ActiosUsers.ELIMINARFICHA, input, state);

    }

    private void mostrarFicha() {
        String[] input = view.readInput(ActiosUsers.MOSTRARFICHA);
        ArrayList<FichaEjemplar> aux= magFicha.mostrarFicha(input[0]);
        String[] output = new String[aux.size()] ;
        if(aux.size()>0){
            
            int i=0;
            for(FichaEjemplar auxFicha:aux){
                output[i]= auxFicha.toString();
                i++;
            }  
        }
        
        view.writeOutput(ActiosUsers.MOSTRARFICHA, output, true);
    }
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

    


    

