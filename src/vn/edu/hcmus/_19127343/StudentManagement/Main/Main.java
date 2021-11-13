package vn.edu.hcmus._19127343.StudentManagement.Main;

import vn.edu.hcmus._19127343.StudentManagement.Information.Information;
import vn.edu.hcmus._19127343.StudentManagement.Student_List.Student_List;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int choice;
        String file;
        Scanner s = new Scanner(System.in);
        Student_List students = new Student_List();

	    while(true){
            //Runtime runtime = Runtime.getRuntime();
            //runtime.exec("cls");
            System.out.println("\t\t\tStudent Management");

            System.out.println("1. Add Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. Delete Student");
            System.out.println("4. View Student List With Ascending ID");
            System.out.println("5. View Student List With Ascending GPA");
            System.out.println("6. Save Student Information");
            System.out.println("7. Import Student List From Text File(csv)");
            System.out.println("8. Export Student List To Text File(csv)");
            System.out.println("0. Exit");

            System.out.print("Your choice: ");
            choice = s.nextInt();

            switch (choice){
                case 0:
                    System.out.println("Good Bye");
                    return;

                case 1:
                    Information temp = new Information();
                    temp.create_Info(-1);
                    students.add_Student(temp);
                    break;

                case 2:
                    students.update_StudentInfo();
                    break;

                case 3:
                    students.delete_Student();
                    break;

                case 4:
                    students.view_AscID();
                    break;

                case 5:
                    students.view_AscGPA();
                    break;

                case 6:
                    students.save_ToFile();
                    break;

                case 7:
                    System.out.print("Input csv file name:");
                    s.nextLine();
                    file = s.nextLine();
                    if (!file.matches(".csv"))
                        file = file + ".csv";
                    students = Student_List.import_InfoFromCSV(file);
                    //System.out.println("Successfully");
                    break;

                case 8:
                    students.export_InfoToCSV();
                    System.out.println("Successfully");
                    break;
            }
        }
    }
}
