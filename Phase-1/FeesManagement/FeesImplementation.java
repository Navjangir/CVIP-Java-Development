package Phase1.Fee_Management.implementation;

import Phase1.Fee_Management.bean.Student;
import Phase1.Fee_Management.controller.FeeManageCont;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FeeImpl {
    public static void main(String[] args) {
        FeeManageCont feeManageCont = new FeeManageCont();
        Student stu;
        List<Student>list = new ArrayList<>();
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.format("\t%-20s\n","===============> Fee Management App <===============");
        System.out.println();

        do {
            System.out.println("1. Add Student\n2. See The Student List\n3. Get Student Details By Id\n4. Make Payment");

            System.out.println();
            System.out.print("Choose one option : ");
            int num = sc.nextInt();

            switch (num) {
                case 1:
                    System.out.print("Enter Student id :");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name : ");
                    String stuName = sc.nextLine();

                    System.out.print("Enter Student Grade : ");
                    String grade = sc.nextLine();

                    System.out.print("Enter Total Fee : ");
                    int totalFee = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter the Amount Paid : ");
                    int amtPaid = sc.nextInt();

                    int remainingFee = totalFee - amtPaid;
                    stu = new Student(id, stuName, grade, totalFee, amtPaid, remainingFee);

                    list = feeManageCont.addStudent(stu);
                    feeManageCont.displayListOfStudents(list);
                    flag=true;
                    break;

                case 2:
                    feeManageCont.displayListOfStudents(feeManageCont.studentList);
                    flag=true;
                    break;

                case 3:
                    System.out.print("Enter the student Id : ");
                    int stuId = sc.nextInt();
                    list = feeManageCont.studentById(stuId);
                    feeManageCont.displayListOfStudents(list);
                    flag=true;
                    break;

                case 4:
                    boolean flag2 = true;
                    System.out.print("Enter the student id : ");
                    int studentId = sc.nextInt();
                    list=feeManageCont.studentById(studentId);
                    System.out.println();
                    do {
                        System.out.println("Choose one of the Option.\n1. Pay\n2. Leave");
                        int choose = sc.nextInt();
                        switch (choose) {
                            case 1:
                                feeManageCont.displayListOfStudents(list);
                                feeManageCont.payRemainingFee(studentId);
                                break;

                            case 2:
                                flag2 = false;
                                break;
                            default:
                                System.out.println("Choose a correct option..");
                        }
                    }while (flag2);

                    flag = true;
                    break;

                default:
                    System.out.println("Choose a correct option");
            }

        }while (flag);
    }
}
