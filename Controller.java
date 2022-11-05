/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eesha Javaid
 */
public class Controller {
    dbConnectivity d;
   Controller()
   {
       d= new dbConnectivity();
   }
    
    String viewCourseList()
    {
      String s= d.Courselist();
      return s;
    }
    
    List getCourseList()
    {
       return d.GetCourseList();
    }
    
    String viewTranscript(String name, int semester)
    {
      String s= d.ViewTranscript(name, semester);
      return s;
    }
    
    boolean CheckLogin(String name, String password, boolean IsTeacher)
    {
        boolean flag= d.Checklogin(name, password, IsTeacher);
        return flag; 
    }
    String viewAttendance(String roll, String course)
    { 
        String s= d.ViewAttendance(roll,course);
        return s;
    }
    List GetSectionList(String coursename)
    {
        List<String> Sections = new ArrayList <String>();
        Sections = d.GetSectionList(coursename);
        return Sections;
    }
    void Session(String name, String pass)
    {
        d.Session(name, pass);
    }
    List GetCourse()
    {
        List<String> Courses = d.GetCourse();
        return Courses;
    }
    List GetStudent(String course, String Section)
    {
        List<String> Student=d.GetStudent(course, Section);
        return Student;
    }
    void EndSession()
    {
         d.deleteSession();
         d.close();
    }
    void AddAttendance(String course, String section, String roll, String present)
    {
        d.AddAttendance(course, section, roll,present);
    }
     void SetEvaluation(String course, String Section, int quiz,int mid1,int mid2, int finals)
     {
         d.SetEvaluation(course, Section, quiz, mid1, mid2, finals);
     }
      List GetStudentCourse(String s)
      {
          return d.GetStudentCourse(s);
      }
      
     void UpdateQuizMarks(String Roll, int marks,int mid1,int mid2, int finals)
     {
         d.UpdateMarks(Roll, marks,mid1,mid2,finals);
     }
     
     List GetEvaluationCriteria(String course, String section)
     {
         return d.GetEvaluationCriteria(course, section);
     }
     
     List CalculateMarks(String course, String section)
     {
         return d.CalculateMarksTotal(course, section);
     }
     
       void AddGrade(String roll, String grade)
       {
           d.AddGrade(roll, grade);
       }
       boolean Withdraw(String name, String course)
       {
           return d.WithdrawCourse(name, course);
       }
       
       boolean DropCourse(String name, String Course)
       {
           return d.Drop_Course(name, Course);
       }
       
       List GetSection(String course)
       {
           return d.GetSection(course);
       }
       int AddSubject(String name, String course, String section)
       {
           return d.AddSubject(name, course, section);
       }
       void UpdateNotify(String name)
       {
           d.UpdateNotify(name);
       }
       boolean getnotify(String name)
       {
           return d.getNotification(name);
       }
       boolean checkseats(String course, String Section)
       {
           return d.CheckSeats(course, Section);
       }
       void notification(String course, String section, String name)
       {
           d.Notification(course, section, name);
       }
       List Notify(String name)
       {
           return d.GetSeat(name);
       }
}
