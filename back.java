/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Eesha Javaid
 */
public class back implements MouseListener{
    
    String course;
    back(String course)
    {
        this.course=course;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
           java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grade_sec(course).setVisible(true);
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
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
