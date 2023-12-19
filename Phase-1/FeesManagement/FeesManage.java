package Phase1.Fee_Management.controller;

import Phase1.Fee_Management.bean.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FeeManageCont {

     Scanner sc = new Scanner(System.in);
     public List<Student> studentList = new ArrayList<>();

     public List<Student> addStudent(Student student){
          boolean studentExist = false;

          for(Student stu : studentList){
             if(stu.getStudentId()==student.getStudentId()){
                 System.out.println("Student with this Id is already present!");
                  studentExist = true;
                  break;
             }
          }
          if(!studentExist){
               studentList.add(student);
          }
          return studentList;
     }

     public List<Student> studentById(int id){
          List<Student> studentExist = new ArrayList<>();
          boolean stuExist = false;
          for(Student stu : studentList){
              if(stu.getStudentId()==id) {
                  studentExist.add(stu);
                  stuExist = true;
                  break;
              }
          }
          if(!stuExist){
              System.out.println("Student with " + id + " is not present");
         }
         return studentExist;
     }

     public void payRemainingFee(int id){
         boolean stuExist = false;

         for(Student stu : studentList){

             if(stu.getStudentId()==id){

                 System.out.println("Remaining Amount to pay : "+stu.getFeeDue());

                 System.out.print("Enter the amount you want to submit : ");
                 int money = sc.nextInt();

                 if(money>stu.getFeeDue() || money==0){
                     System.out.print("Entered amount is greater then the due fee.\nPlease try again...!");
                     System.out.println();
                     System.out.print("Enter the new amount : ");
                     int newAmt = sc.nextInt();
                     money = newAmt;
                 }
                 stu.setFeeDue(stu.getFeeDue()-money);
                 stu.setFeeSubmitted(stu.getFeeSubmitted()+money);
                 if(stu.getFeeDue()==0){
                     System.out.println("Fee Paid Successfully. No Due Remaining");
                 }
                 else {
                     System.out.println("Fee Submitted Successfully..");
                     System.out.println("Remaining Fee to Pay : "+stu.getFeeDue());
                 }
                 stuExist = true;
                 break;
             }
         }
         if(!stuExist){
             System.out.println("Please Recheck the Students Id..!");
         }
     }
     public void displayListOfStudents(List<Student> list){
         System.out.println("+-------------------------------------------------------------------------------------------+");
         System.out.format("|\t%-5s|\t%-15s|\t%-10s|\t%-12s|\t%-16s|\t%-12s|\n","id","Stu-Name","Grade","Total Fee","Fee-Submitted","FeesDue");
         System.out.println("+-------------------------------------------------------------------------------------------+");
         for(Student stuInfo : list){
               System.out.format("|\t%-5d|\t%-15s|\t%-10s|\t%-12d|\t%-16d|\t%-12d|\n",stuInfo.getStudentId(),stuInfo.getStuName(),stuInfo.getGrade(),stuInfo.getTotalFee(),stuInfo.getFeeSubmitted(),stuInfo.getFeeDue());
               System.out.println("+-------------------------------------------------------------------------------------------+");
         }
         System.out.println("+-------------------------------------------------------------------------------------------+");
    }

}
