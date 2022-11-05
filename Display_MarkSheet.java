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

public class Display_MarkSheet {
     JFrame myFrame;
     JButton submit;
     String course,Section;
     public void initGUI()
     {
        
         myFrame= new JFrame();
         Container c = myFrame.getContentPane();
         Controller obj= new Controller();
         submit = new JButton("Submit");
         List<Marksheet> Marks = obj.CalculateMarks(this.course, this.Section);
         c.setLayout( new GridLayout((Marks.size()+2),3));
         JLabel Roll, total;
         JTextField grade;
         List <JTextField> list = new ArrayList();
         int temp;
         for(int i=0; i < Marks.size(); i++)
         {
             Roll = new JLabel(Marks.get(i).rollnumber);
             c.add(Roll);
             temp=Marks.get(i).totalmarks;
             total = new JLabel(String.valueOf(temp));
             c.add(total);
             grade = new JTextField();
        
             c.add(grade);
             list.add(grade);
         }
        JButton back1 = new JButton("Back");
        
        c.add(submit);
        c.add(back1);
        back b = new back(course);
        back1.addMouseListener(b);
        marksheet_listener l = new marksheet_listener(Marks,list);
        submit.addMouseListener(l);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(500,500);
        myFrame.setVisible(true);
     }
     Display_MarkSheet(String course, String Section)
     {
          this.course=course;
         this.Section=Section;
     
        initGUI();
     }
}
