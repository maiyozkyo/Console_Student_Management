package vn.edu.hcmus._19127343.StudentManagement.Student_List;

import vn.edu.hcmus._19127343.StudentManagement.Information.Information;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * vn.edu.hcmus._19127343.StudentManagement.Student_List
 * Created by Bleu
 * Date 11/7/2021 - 10:41 PM
 * Description: ...
 */
public class Student_List {
    private ArrayList<Information> list;

    /**
     * Default constructor
     */
    public Student_List(){
        list = null;
    }

    /**
     * Constructor with array
     * @param temp: array information
     */
    public Student_List(ArrayList<Information> temp){
        if (temp != null){
            list = temp;
        }
    }

    /**
     * Copy constructor
     * @param temp
     */
    public Student_List(Student_List temp){
        if (temp.list != null)
            list = temp.list;
    }

    /**
     * get Students Information List
     * @return list
     */
    public ArrayList<Information> get_StudentsList(){
        return this.list;
    }

    /**
     * set values for list with temp array
     * @param temp
     */
    public void set_StudentsList(ArrayList<Information> temp){
        if (temp != null)
            this.list = temp;
    }

    /**
     * set values for list with temp students list
     * @param temp
     */
    public void set_StudentsList(Student_List temp){
        if (temp.list != null)
            this.list = temp.list;
    }

    /**
     * add student in to list
     * @param temp: student information
     */
    public void add_Student(Information temp){
        if (this.list == null)
            this.list = new ArrayList<Information>();

        else {
            for (int i = 0; i < list.size(); i++)
                if (list.get(i).get_ID().equals(temp.get_ID())){
                    System.out.println("Duplicate ID at " + i);
                    return;
                }
        }
        list.add(temp);
    }

    /**
     * Update information of student has ID
     */
    public void update_StudentInfo(){
        if (list == null) {
            System.out.println("Empty List");
            return;
        }
        String id;
        Scanner s = new Scanner(System.in);
        do {
            System.out.print("ID of student want to update: ");
            id = s.nextLine();
            if (!id.matches("[0-9]+")) System.out.println("Incorrect ID format");
        } while (!id.matches("[0-9]+"));

        for (int i = 0; i < list.size(); i++){
            if (list.get(i).get_ID().equals(id)){
                Information temp = new Information(list.get(i));
                temp.update_Info();
                list.set(i, temp);
                System.out.println("Successfully");
                return;
            }
        }
        System.out.println("Can not found your input ID");
    }

    /**
     * Delete a student information by id
     */
    public void delete_Student(){
        if (list == null) {
            System.out.println("Empty List");
            return;
        }
        String id;
        Scanner s = new Scanner(System.in);
        do {
            System.out.print("ID of student want to DELETE: ");
            id = s.nextLine();
            if (!id.matches("[0-9]+")) System.out.println("Incorrect ID format");
        } while (!id.matches("[0-9]+"));

        for (int i = 0; i < list.size(); i++){
            if (list.get(i).get_ID().equals(id)){
                list.remove(i);
                System.out.println("Successfully");
                return;
            }
        }
        System.out.println("Can not found your input ID");
    }

    /**
     * Ascending information of students by id
     */
    public void sort_AscendingID(){
        if (list == null) {
            System.out.println("Empty List");
            return;
        }
        for (int i = 0; i < list.size()-1; i++){
            for (int j = i+1; j < list.size(); j++){
                if (Integer.parseInt(list.get(i).get_ID()) > Integer.parseInt(list.get(j).get_ID())){
                    Information temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

    /**
     * Ascending information of students by gpa
     */
    public void sort_AscendingGPA(){
        if (list == null) {
            System.out.println("Empty List");
            return;
        }
        for (int i = 0; i < list.size()-1; i++){
            for (int j = i+1; j < list.size(); j++){
                if (list.get(i).get_GPA() > list.get(j).get_GPA()){
                    Information temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

    /**
     * View information of students by asc id
     */
    public void view_AscID(){
        if (this.list == null) {
            System.out.println("Empty List");
            return;
        }
        this.sort_AscendingID();
        for (int i = 0; i < list.size(); i++){
            list.get(i).print_Info();
        }
    }

    /**
     * View information of students by asc gpa
     */
    public void view_AscGPA(){
        if (this.list == null) {
            System.out.println("Empty List");
            return;
        }
        this.sort_AscendingGPA();
        for (int i = 0; i < list.size(); i++){
            list.get(i).print_Info();
        }
    }

    /**
     * Save data to file
     */
    public void save_ToFile(){
        DataOutputStream out_file;
        try{
            out_file = new DataOutputStream(new FileOutputStream("Students_Info.bin"));
        }
        catch (IOException ioe){
            System.out.println("Error open file");
            return;
        }

        try{
            for (int i = 0; i < list.size(); i++){
                out_file.writeUTF(list.get(i).get_ID());
                out_file.writeUTF(list.get(i).get_Name());
                out_file.writeFloat(list.get(i).get_GPA());
                out_file.writeUTF(list.get(i).get_Addr());
                out_file.writeUTF(list.get(i).get_Notes() + "\n");
            }
            System.out.println("Successfully");
        }
        catch (IOException exc){
            System.out.println("Error write file.");
        }
    }

    /**
     * Export To CSV
     */
    public void export_InfoToCSV(){
        if (this.list == null){
            System.out.println("Empty List");
            return;
        }
        PrintWriter pw;
        try {
            pw = new PrintWriter(new File("Students_Info.csv"));

            StringBuffer csvHeader = new StringBuffer("");
            csvHeader.append("ID,Name,GPA,Address,Notes\n");
            pw.write(csvHeader.toString());

            StringBuffer lines = new StringBuffer("");
            for (int i = 0; i < list.size(); i++) {
                lines.append(list.get(i).get_ID());
                lines.append(',');
                lines.append(list.get(i).get_Name());
                lines.append(',');
                lines.append(list.get(i).get_GPA());
                lines.append(',');
                lines.append(list.get(i).get_Addr());
                lines.append(',');
                lines.append(list.get(i).get_Notes());
                lines.append('\n');
            }
            pw.write(lines.toString());
            System.out.println("Successfully");
            pw.close();
        }
        catch (FileNotFoundException fnfe){
            System.out.println("Error Write File");
        }

    }

    public static Student_List import_InfoFromCSV(String filename) throws FileNotFoundException {
        Student_List students = new Student_List();
        Scanner sc;
        try {
            sc = new Scanner(new File(filename));
            sc.useDelimiter(",");
            sc.nextLine();

            String[] t1;
            while (sc.hasNextLine()) {
                List<String> t = new ArrayList<>();
                t1 = sc.nextLine().split(",");
                for (int i = 0; i < t1.length; i++)
                    t.add(t1[i]);
                if (t.size() == 4) t.add("");
                Information student = new Information(t);
                students.add_Student(student);
            }

            sc.close();
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("File not found");
        }
        return students;
    }
}
