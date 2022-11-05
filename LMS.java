/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

/**
 *
 * @author Eesha Javaid
 */
public class LMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // dbConnectivity db = new dbConnectivity();
//       LMS_UI UI = new LMS_UI();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LMS_UI().setVisible(true);
            }
        });
       
    
      
    }
    
}
