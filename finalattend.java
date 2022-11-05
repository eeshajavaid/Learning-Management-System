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
public class finalattend {
 
    JFrame myFrame;
    JLabel label;
    JButton b1;
    String course,Section;
    public void initGUI()
    {
        myFrame= new JFrame();
        Container c = myFrame.getContentPane();
        List <JCheckBox> checkbox = new ArrayList();
        JCheckBox check;
        Controller C= new Controller();
        List<String> list = C.GetStudent(course,Section);
        c.setLayout( new GridLayout((list.size()+1),1 ));
        JLabel studentname;
        for(int i=0; i <list.size();i++)
        {
            check = new JCheckBox();
            
            c.add(check);
            checkbox.add(check);
            studentname=new JLabel(list.get(i));
            c.add(studentname);
        }
        b1= new JButton("SUBMIT");
        
        MouseListener l = new MouseEvent(course,Section,checkbox,list);
        c.add(b1);
        b1.addMouseListener(l);
       
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(500,500);
        myFrame.setVisible(true);
      
       
        
        
    }
    
finalattend(String course, String Section)
{
    this.course=course;
    this.Section=Section;
    initGUI();
}

}
