/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
/**
 *
 * @author Eesha Javaid
 */
public class Drop_Listener implements MouseListener{
    String name;
    List <JCheckBox> selected;
    List <String> courses;
    Drop_Listener(String name, List <JCheckBox> selected,  List <String> courses)
    {
        this.name=name;
        this.selected=selected;
        this.courses=courses;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
       Controller c = new Controller();
       boolean flag = false;
       int count=0;
       for(int i= 0 ; i < courses.size(); i++)
       {
           if(selected.get(i).isSelected())
           {
               flag=c.DropCourse(name, courses.get(i));
               count++;
           }
       }
       if(flag)
           JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Your Courses have been dropped");
       else if(count >0 && !flag)
           JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Registration Deadline ended");
       else
           JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Please select a course that you wish to drop");
       
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration(name).setVisible(true);
            }
        });
    }

    @Override
    public void mousePressed(MouseEvent e) {
  //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
