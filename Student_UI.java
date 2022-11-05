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
public class Student_UI extends javax.swing.JFrame {

    /**
     * Creates new form Student_UI
     */
    String s;
    public Student_UI(String s) {
        initComponents();
        this.s=s;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        TranscriptB = new javax.swing.JButton();
        AttendanceB = new javax.swing.JButton();
        CourselistB = new javax.swing.JButton();
        logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TranscriptB.setText("View Transcript");
        TranscriptB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TranscriptBMouseClicked(evt);
            }
        });
        TranscriptB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TranscriptBActionPerformed(evt);
            }
        });

        AttendanceB.setText("View Attendance");
        AttendanceB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AttendanceBMouseClicked(evt);
            }
        });

        CourselistB.setText("View Course List");
        CourselistB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CourselistBMouseClicked(evt);
            }
        });
        CourselistB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourselistBActionPerformed(evt);
            }
        });

        logout.setText("LOGOUT");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CourselistB, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AttendanceB, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TranscriptB, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(132, 132, 132))
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(logout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(CourselistB, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TranscriptB, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AttendanceB, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(logout)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TranscriptBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TranscriptBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TranscriptBActionPerformed

    private void CourselistBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CourselistBActionPerformed
      
    }//GEN-LAST:event_CourselistBActionPerformed

    private void CourselistBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CourselistBMouseClicked
      
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseList(s).setVisible(true);
            }
        });
    }//GEN-LAST:event_CourselistBMouseClicked

    private void TranscriptBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TranscriptBMouseClicked
        // TODO add your handling code here:
      
           java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transcript(s).setVisible(true);
            }
        });
    }//GEN-LAST:event_TranscriptBMouseClicked

    private void AttendanceBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AttendanceBMouseClicked
        // TODO add your handling code here:
          java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_viewAttend(s).setVisible(true);
            }
        });
      
    }//GEN-LAST:event_AttendanceBMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
          java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LMS_UI().setVisible(true);
            }
        });
 
    }//GEN-LAST:event_logoutMouseClicked

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AttendanceB;
    private javax.swing.JButton CourselistB;
    private javax.swing.JButton TranscriptB;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton logout;
    // End of variables declaration//GEN-END:variables
}