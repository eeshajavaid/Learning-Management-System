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
public class Marksheet {
    String rollnumber;
    int totalmarks;
    String grade;
    
    Marksheet(String rollnumber, int total)
    {
        this.rollnumber=rollnumber;
        totalmarks=total;
    }
}
