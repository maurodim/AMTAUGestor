/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauro
 */
public class MiModeloTablaArticulos extends DefaultTableModel {
    @Override
    public Class getColumnClass(int colum){
        if(colum==2)return Double.class;
        if(colum==3)return Double.class;
        if(colum==4)return Double.class;
          
        return String.class;
      }    
}
