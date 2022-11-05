/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Eesha Javaid
 */
public class marksheet_listener implements MouseListener{

    List <Marksheet> list;
    List <JTextField> grades;
    marksheet_listener(List <Marksheet> list,List <JTextField> grades)
    {
        this.list =list;
        this.grades=grades;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        Controller c= new Controller();
        int count =0;
        for(int i=0; i < list.size(); i++)
        {
            c.AddGrade(list.get(i).rollnumber, grades.get(i).getText());
            if(grades.get(i).getText()!=null ||grades.get(i).getText()!="")
                count++;
        }
       
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Teacher_UI().setVisible(true);
                }
            });
       
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
