/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

//import java.util.Date;


import java.util.ArrayList;
import java.util.Date;
import model.Record;
import view.*;


/**
 *
 * @author Илья
 */
public class MainTest {
    public static void main(String[] args){
        //new MainWindow();
        ArrayList<String> l = new ArrayList<>();
        l.add("hjgjkj");
        l.add("hdsgduegcnb");
        
        
        Record r = new Record("bhjkhg", l, new Date(), 1,2);
        System.out.println(r.toString());
    }
}
