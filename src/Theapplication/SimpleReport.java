package Theapplication;

import javax.swing.*;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.util.*;
import java.io.*;
//import java.util.logging.Logger;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.*;
import net.sf.jasperreports.view.*;
public class SimpleReport {    
    DefaultTableModel tableModel;
   //tableModel=new configreports().jtblstudentsdata.getModel();
  
    public SimpleReport(DefaultTableModel tableModel) {
        JasperPrint jasperPrint = null;
       // TableModelData();// how is this called....
        try {
            JasperCompileManager.compileReportToFile("C:\\Users\\Stephen Matara\\Documents\\NetBeansProjects\\MASHUJAAEXPRESS_1\\src\\Theapplication\\repos\\customers.jrxml");
            jasperPrint = JasperFillManager.fillReport("C:\\Users\\Stephen Matara\\Documents\\NetBeansProjects\\MASHUJAAEXPRESS_1\\src\\Theapplication\\repos\\customers.jasper", new HashMap(),
                    new JRTableModelDataSource(tableModel));
            JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
            jasperViewer.setVisible(true);
            
        
        } catch (JRException ex) {
            ex.printStackTrace();
        }
        
    }
       
}