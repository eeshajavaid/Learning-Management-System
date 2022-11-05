/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JCheckBox;

/**
 *
 * @author Eesha Javaid
 */
public class MouseEvent implements MouseListener {
    String course, section;
    List<JCheckBox> list;
    List<String> student;
    MouseEvent(String course, String section, List<JCheckBox> list, List<String> student)
    {
        this.course=course;
        this.section= section;
        this.list=list;
        this.student=student;
    }
    
   
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        
        //To change body of generated methods, choose Tools | Templates.
        try
        {
            Controller c = new Controller();
           
            for(int i=0;i < list.size();i++)
            {
               if(list.get(i).isSelected())
                   c.AddAttendance(course, section, student.get(i),"P");
               else
                    c.AddAttendance(course, section, student.get(i),"A");
            }
              java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Attend(course).setVisible(true);
            }
        });
        }
        catch(Exception a)
        {
            a.getMessage();
        }
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
