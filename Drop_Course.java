/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.List;
import javax.swing.*;
/**
 *
 * @author Eesha Javaid
 */
public class Drop_Course {
     
    JFrame myFrame;
    JLabel label;
    JButton b1,back;
    String name;
    Drop_Course(String name)
    {
        this.name=name;
        initGUI();
    }
    
    public void initGUI()
    {
        myFrame= new JFrame();
        Container c = myFrame.getContentPane();
        List <JCheckBox> checkbox = new ArrayList();
        JCheckBox check;
        Controller C= new Controller();
        
        List <String> registeredCourses = C.GetStudentCourse(name);
         c.setLayout( new GridLayout((registeredCourses.size()+2),2 ));
        for(int i=0; i < registeredCourses.size(); i++)
        {
            label = new JLabel(registeredCourses.get(i));
            c.add(label);
            check = new JCheckBox();
            c.add(check);
            checkbox.add(check);
        }
        
         b1 = new JButton("DROP");
         c.add(b1);
         
        back = new JButton("Back");
        c.add(back);
        back_mouselistener b = new back_mouselistener(name);
        back.addMouseListener(b);
        Drop_Listener w = new Drop_Listener(name, checkbox, registeredCourses);
        b1.addMouseListener(w);
        
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(250,250);
        myFrame.setVisible(true);
      
    }
}
