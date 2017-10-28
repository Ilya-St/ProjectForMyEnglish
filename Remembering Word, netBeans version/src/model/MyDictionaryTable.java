/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Илья
 */
public class MyDictionaryTable extends AbstractTableModel{
    
    private Vector<String> columnNames;
    private Vector<Vector<String>> data;
    
    public MyDictionaryTable(ArrayList<MainEntity> me){
        this.columnNames = new Vector<>();
        columnNames.add("Слово");
        columnNames.add("Перевод");
        data = new Vector<>();
        for(MainEntity m : me){
            data.add(m.toVector());
        }
        
    }

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
