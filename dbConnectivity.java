/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 /**
 * @author Eesha Javaid
 */
public class dbConnectivity {
   
    Connection con;
    Statement stmt;
    dbConnectivity()
    {
      
        try
        {
            String conn = "jdbc:sqlserver://localhost:1433;databaseName=LMS";
            con= DriverManager.getConnection(conn,"eesha","123");
            stmt =  con.createStatement();
        }
        catch(SQLException e)
        {
               System.out.println(e);
        }
    }
  
        String Courselist()
    {
        String s = "";
        try {
            ResultSet rs = stmt.executeQuery("select * from Courses");

            while (rs.next()) {
                s += (rs.getInt(1) + "                       " + rs.getString(2) + "\n\n");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return s;
    }
        
          List GetCourseList()
        {
            List <String > Courses = new ArrayList();
            try
            {
                 ResultSet rs = stmt.executeQuery("select [Course Name] from Courses");
                 while(rs.next())
                     Courses.add(rs.getString(1));
            }
          
            catch(SQLException e)
            {
                 System.out.println(e);
            }
            return Courses;
        }
        void close()
        {
            try{
                con.close();
            }
            catch(SQLException e)
            {
                System.out.println(e);
            }
        }
        
        String GetRollNumber(String name)
        {
            String s= "";
            try
            {
                ResultSet rs = stmt.executeQuery("Select rollnumber from Student where Sname = '" + name+ "'");
                while(rs.next())
                {
                    s= rs.getString(1);
                }
            }
            catch(SQLException e)
            {
               System.out.println( e.getMessage());
            }
            return s;
        }
        
        boolean Checklogin(String name, String pass,boolean isTeacher)
        {
            try
            {
                if(isTeacher==true)
                 {
                    ResultSet rs=stmt.executeQuery("select * from Teacher where Tname = '" +name + "' and password= '" +pass+ "'");
                    return rs.next();
                }
                else
                {
                    ResultSet rs=stmt.executeQuery("select * from Student where Sname = '" +name + "' and password= '" +pass+ "'");
                    
                    return rs.next();
                }
             }
          catch (SQLException e) {
                System.out.println(e);
            }
            return false;
        }
        
        String ViewTranscript(String name, int semester)
        {
           String s= "";
            try {
            ResultSet rs = stmt.executeQuery("select Course,Grade from Transcript where [Student name]= '"+name+ "' and Semester = '" + semester+ "'");
           
            while (rs.next()) {
                s += (rs.getString(1) + "  " + rs.getString(2) + "\n\n");
            }
           
        }
        catch (SQLException e) {
            System.out.println(e);
        }
            return s;
        }
                
        String ViewAttendance(String name,String Course) {
        String s = "";
        try {
           
            ResultSet rs = stmt.executeQuery("select date_,present from Attend join Student on Attend.RollNumber= Student.rollnumber where Sname='" + name+ "' and  Course= '"+Course+ "'" );

            while (rs.next()) {
                s += (rs.getDate(1) + "    " + rs.getString(2) + "\n\n");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return s;
    }
         
         List GetSectionList(String coursename)
         {
             List<String> sections = new ArrayList();
             try{
                 String name="";
                 ResultSet rs= stmt.executeQuery("Select name from CurrentLogin");
                 if(rs.next())
                     name=rs.getString(1);
                 rs= stmt.executeQuery("Select Section from Teaches where [Teacher Name]= '" +name+"' and Course= '" +coursename+"'" );
                 while(rs.next())
                 {
                     sections.add(rs.getString(1));
                 }
                 
             }
             catch(SQLException e)
             {
                System.out.println(e);
             }
             return sections;
         }
         List GetCourse()
         {
             List<String> courses = new ArrayList();
                 try{
                 String name="";
                 ResultSet rs= stmt.executeQuery("Select name from CurrentLogin");
                 if(rs.next())
                     name=rs.getString(1);
                  rs= stmt.executeQuery("Select distinct Course from Teaches where [Teacher Name]= '"+name+"'");
                 while(rs.next())
                 {
                     courses.add(rs.getString(1));
                 }
              
             }
             catch(Exception e)
             {
                System.out.println(e);
             }
             return courses;
         }
         
         List GetStudent(String course, String Section)
         {
             
             List<String> Student = new ArrayList<String>();
             try{
              
                 ResultSet rs= stmt.executeQuery("select RollNumber from Registered where Course= '"+ course+"' and Section='" +Section+"'");
                 
                 while(rs.next())
                 {
                     Student.add(rs.getString(1));
                     
                 }
                 
             }
             catch(Exception e)
             {
                System.out.println(e);
             }
             return Student;
         }
         
         void Session(String name, String pass)
         {
             try
             {
                 stmt.executeUpdate("insert into CurrentLogin (Name,Password) VALUES('"+name+"', '"+pass+"')");
             }
             catch(Exception e)
             {
                  System.out.println(e);
             }
         }
         void deleteSession()
         {
             try
             {
                 stmt.executeUpdate("Delete top(1) from CurrentLogin");
             }
             catch(Exception e)
             {
                  System.out.println(e);
             }
         }
         
         void AddAttendance(String course, String section, String roll, String present)
         {
             try
             {
                 stmt.executeQuery("insert into attend(Section,Course,RollNumber,date_,present) values ('" +section+"','" +course+"','" +roll+ "',GETDATE(),'"+present+ "')");
             }
             catch(SQLException e)
             {
                 System.out.println(e.getMessage());
             }
         }
         
          void SetEvaluation(String course, String Section, int quiz,int mid1,int mid2, int finals)
          {
              try
              {
                  ResultSet rs = stmt.executeQuery("Select * from Evaluation where Course = '"+ course+ "' and Section = '"+Section+"'");
                  if(!rs.next())
                    stmt.executeUpdate("insert into Evaluation(Course,Section, Quizzes,Mid1,Mid2,Final) values('"+course+"','"+Section+"','"+quiz+"','"+mid1+"','"+mid2+"','"+finals+"')");
                  
                  else
                  {
                       stmt.executeUpdate("delete from Evaluation where Course= '"+course+"' and Section = '"+Section+"'");
                       stmt.executeUpdate("insert into Evaluation(Course,Section, Quizzes,Mid1,Mid2,Final) values('"+course+"','"+Section+"','"+quiz+"','"+mid1+"','"+mid2+"','"+finals+"')");
                  }
              }
              catch(Exception e)
              {
                  System.out.println(e.getMessage());
              }
          }
          
          List GetStudentCourse(String s)
          {
              List<String> courses = new ArrayList<String>();
                 try{
                 System.out.println(s);
                  ResultSet rs= stmt.executeQuery("Select Course from Registered join Student on Registered.RollNumber = Student.rollnumber where Student.Sname = '"+ s+"'");
                 while(rs.next())
                 {
                     courses.add(rs.getString(1));
                     
                 }
              
             }
             catch(SQLException e)
             {
                System.out.println(e );
             }
             return courses;

          }
        
          void UpdateMarks(String Roll, int marks, int mid1, int mid2, int finals)
          {
              try
              {
                  stmt.executeQuery("insert into Marksheet(Rollnumber,Quiz,Mid1,Mid2,final) values ('"+Roll+"','"+marks+"','"+mid1+"','"+mid2+"','"+finals+"')");
              }
              catch(SQLException e)
              {
                  System.out.println(e.getMessage());
              }
          }
          
          List GetEvaluationCriteria(String course, String section)
          {
             List <Integer> list = new ArrayList();
             try
             {
                 ResultSet rs = stmt.executeQuery("select Quizzes,Mid1,Mid2,Final from Evaluation where Course='"+course+"' and Section = '"+ section+"'");
                 while(rs.next())
                 {
                     list.add(rs.getInt(1));
                     list.add(rs.getInt(2));
                     list.add(rs.getInt(3));
                     list.add(rs.getInt(4));
                 }
             }
             catch(SQLException e)
             {
                 System.out.println(e.getMessage());
             }
             return list;  
          }
          
          List CalculateMarksTotal(String course, String section)
          {
              List <Marksheet> marks = new ArrayList();
              try
              {
                  Marksheet object;
                    stmt.executeUpdate("UPDATE Marksheet SET Total = Quiz + Mid1 + Mid2 + final");
                    ResultSet rs = stmt.executeQuery("Select Marksheet.Rollnumber, Total from Marksheet join Registered on Marksheet.Rollnumber = Registered.RollNumber where Course='"+course+"' and Section = '"+ section+"'");
                  while(rs.next())
                  {
                      object = new Marksheet(rs.getString(1),rs.getInt(2));
                      marks.add(object);
                   
                  }
                  
              }
              catch (SQLException e)
              {
                  System.out.println(e.getMessage());
              }
              return marks;
          }   
          
          void AddGrade(String roll, String grade)
          {
           try
           {
               stmt.executeUpdate("Update Marksheet set grade = '"+grade+"' where Rollnumber='"+roll+"'");
           }
           catch(SQLException e)
           {
               System.out.println(e.getMessage());
           }
          }
          
          int AddSubject(String name, String course, String Section)
          {
              int flag = 0; // registration close
              try{
                  String roll = this.GetRollNumber(name);
                   ResultSet rs = stmt.executeQuery("Select isRegisterationopen from Table1");
                   boolean check = false;
                   while (rs.next()) {
                      check = rs.getBoolean(1);
                  }
                  if (check) {
                      flag = 1; //registration open
                      rs = stmt.executeQuery("select [Seats Available] from Seats where Course = '" + course + "' and Section = '" + Section + "'");
                      int seats = 0;
                      while (rs.next()) {
                          seats = rs.getInt(1);
                      }
                      if (seats > 0) {
                          flag = 2; // seats available
                          rs= stmt.executeQuery("select * from Registered where Course = '" + course + "'  and RollNumber = '" +roll+"'");
                          if(rs.next())
                              flag=3; //already exists
                          else
                          {
                          stmt.executeUpdate("insert into Registered(Course,Section,RollNumber) values('" + course + "','" + Section + "','" + roll + "')");
                          stmt.executeUpdate("Update Seats set [Seats Available]= ( [Seats Available] -1) where Course = '" + course + "' and Section = '" + Section + "'");
                          }
                      }
                  }
                }
              catch(SQLException e)
              {
                  System.out.println(e.getMessage());
              }
              
              return flag;
          }
          
          boolean WithdrawCourse(String name, String course)
          {
              boolean flag = false;
              try {
                  String roll = this.GetRollNumber(name);
                  ResultSet set = stmt.executeQuery("Select CanWithdraw from Table1");
                  
                  while (set.next()) {
                      flag = set.getBoolean(1);
                  }
                  if (flag) {
                      ResultSet rs = stmt.executeQuery("select Section from Registered where RollNumber = '" + roll + "' and Course = '" + course + "'");
                      String s = "";
                      while (rs.next()) {
                          s = rs.getString(1);
                      }
                      stmt.executeUpdate("delete from Registered where RollNumber = '" + roll + "' and Course = '" + course + "'");
                      stmt.executeUpdate("Update Seats set [Seats Available]= ( [Seats Available] +1) where Course = '" + course + "' and Section = '" + s + "'");
                  }
              }
              catch(SQLException e)
              {
                  System.out.println(e.getMessage());
              }
              return flag;
          }
          
          boolean Drop_Course(String name, String course)
          {
              String roll = "";  
              boolean flag = false;
              try
              {
                  roll = this.GetRollNumber(name);
                  ResultSet set = stmt.executeQuery("Select isRegisterationopen from Table1");
  
                  
                  while (set.next()) {
                      flag = set.getBoolean(1);
                  }
                  if(flag)
                  {
                      ResultSet rs = stmt.executeQuery("select Section from Registered where RollNumber = '" + roll + "' and Course = '" + course + "'");
                      String s = "";
                      while (rs.next()) {
                          s = rs.getString(1);
                      }
                      stmt.executeUpdate("delete from Registered where RollNumber = '" + roll + "' and Course = '" + course + "'");
                      stmt.executeUpdate("Update Seats set [Seats Available]= ( [Seats Available] +1) where Course = '" + course + "' and Section = '" + s + "'");
                  }
              }
              catch(SQLException e)
              {
                  System.out.println(e.getMessage());
              }
              return flag;
          }
          
          List GetSection(String course)
          {
              List <String> Sections = new ArrayList();
              try
              {
                  ResultSet rs = stmt.executeQuery("select Section from Courses join sections on Courses.Cid = sections.cid where [Course Name] ='"+ course+"'");
                  while(rs.next())
                      Sections.add(rs.getString(1));
              }
              catch(SQLException e)
              {
                  System.out.println(e.getMessage());
              }
              return Sections;
          }
          
          void UpdateNotify(String name)
          {
              try
              {
                  String roll = this.GetRollNumber(name);
                  stmt.executeUpdate("insert into Notification(RollNumber,Notify) values('"+roll+"','true')");
              }
              catch(SQLException e)
              {
                  System.out.println(e.getMessage());
              }
          }
          
       boolean getNotification(String name) {
           boolean flag = false;
        try {
            String roll=this.GetRollNumber(name);
            ResultSet rs =stmt.executeQuery("select Notify from Notification where RollNumber = '"+roll+"'");
            while(rs.next())
                flag = rs.getBoolean(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }
       
       boolean CheckSeats(String course, String section)
       {
           boolean flag= false;
           try
              {
                 ResultSet rs=  stmt.executeQuery("select [Seats Available] from Seats where Course = '"+course+"' and Section = '"+ section+"'");
                 int seats=0;
                 while(rs.next())
                     seats = rs.getInt(1);
                 if(seats>0)
                         flag=true;
              }
              catch(SQLException e)
              {
                  System.out.println(e.getMessage());
              }
           return flag;
       }
       
       void Notification(String course, String section, String name)
       {
           try
           {
               String roll = this.GetRollNumber(name);
               stmt.executeUpdate("insert into Notify(Course, Section, RollNumber) values('"+course+"','"+ section +"','"+roll+"')");
           }
           catch(SQLException e)
           {
               System.out.println(e.getMessage());
           }
       }
       
       List GetSeat(String name)
       {
           List <String> list = new ArrayList();
           try
           {
               String roll = this.GetRollNumber(name);
               ResultSet rs = stmt.executeQuery("select Course, Section from Notify where RollNumber='"+roll+"'");
               while(rs.next())
               {
                   list.add(rs.getString(1));
                   list.add(rs.getString(2));
               }
           }
           catch(SQLException e)
           {
               System.out.println(e.getMessage());
           }
           return list;
       }
}

    

