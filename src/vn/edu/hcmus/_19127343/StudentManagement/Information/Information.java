package vn.edu.hcmus._19127343.StudentManagement.Information;

import java.util.List;
import java.util.Scanner;

/**
 * vn.edu.hcmus._19127343.StudentManagement.Information
 * Created by Bleu
 * Date 11/7/2021 - 2:31 PM
 * Description: ...
 */
public class Information {
    private String id; //just contain numbers
    private String name;
    private float gpa;
    private String addr;
    private String notes;

    /**
     * Default constructor
     */
    public Information(){
        this.id = "";
        this.name = "";
        this.gpa = 0;
        this.addr = "";
        this.notes = "";
    }

    /**
     * Constructor with 5 params
     * @param i : string id
     * @param n : string name
     * @param g : float gpa
     * @param a : string address
     * @param no : string notes
     */
    public Information(String i, String n, float g, String a, String no){
        this.set_ID(i);
        this.set_Name(n);
        this.set_GPA(g);
        this.set_Addr(a);
        this.set_Notes(no);
    }

    /**
     * Constructor with Array List
     * @param temp
     */
    public Information(List<String> temp){
        this.set_ID(temp.get(0));
        this.set_Name(temp.get(1));
        this.set_GPA(Float.parseFloat(temp.get(2)));
        this.set_Addr(temp.get(3));
        this.set_Notes(temp.get(4));
    }

    /**
     * Copy constructor
     * @param temp
     */
    public Information(Information temp){
        this.set_ID(temp.get_ID());
        this.set_Name(temp.get_Name());
        this.set_GPA(temp.get_GPA());
        this.set_Addr(temp.get_Addr());
        this.set_Notes(temp.get_Notes());
    }

    /**
     * set value for ID
     * @param i : string id input
     */
    public void set_ID(String i) {
        if (i == "") System.out.println("Empty String");
        else if (i.matches("[0-9]+")) {
            this.id = i;
        }
        else {
            System.out.println("Incorrect ID format");
            return;
            }
    }

    /**
     * set value for ID
     * @param n : string name input
     */
    public void set_Name(String n){
        if (n == "") System.out.println("Empty String");
        else if (n.matches("[ a-zA-Z]*")) {
            this.name = n;

        }
        else {
            System.out.println("Incorrect ID format");
            return;
        }
    }

    /**
     * set value for gpa
     * @param gpa: float
     */
    public void set_GPA(float gpa){
        if (gpa < 0 || gpa > 10) System.out.println("0 <= GPA <= 10");
        else {
            this.gpa = gpa;
        }
    }

    /**z
     * set value for address
     * @param addr: String
     */
    public void set_Addr(String addr){
        if (addr == "") System.out.println("Empty Address");
        else {
            this.addr = addr;
        }
    }

    /**
     * set value for notes
     * @param notes: String
     */
    public void set_Notes(String notes){
        this.notes = notes;
    }

    /**
     * get ID
     * @return id: String
     */
    public String get_ID(){
        return this.id;
    }

    /**
     * get name
     * @return name
     */
    public String get_Name(){
        return this.name;
    }

    /**
     * get gpa
     * @return gpa
     */
    public float get_GPA(){
        return this.gpa;
    }

    /**
     * get address
     * @return address
     */
    public String get_Addr(){
        return this.addr;
    }

    /**
     * get notes
     * @return notes
     */
    public String get_Notes(){
        return this.notes;
    }

    /**
     * update id of student
     */
    public void update_ID(){
        String id;
        Scanner s = new Scanner(System.in);
        do {
            System.out.print("Input Student's ID: ");
            id = s.nextLine();
            this.set_ID(id);
        } while (this.id == "");
        System.out.println("Successfully");
    }

    /**
     * update name of student
     */
    public void update_Name(){
        String n;
        Scanner s = new Scanner(System.in);
        do {
            System.out.print("Input Student's Name: ");
            n = s.nextLine();
            this.set_Name(n);
        } while (this.name == "");
        System.out.println("Successfully");
    }

    /**
     * update gpa of student

     */
    public void update_GPA(){
        float gpa;
        Scanner s = new Scanner(System.in);
        do {
            System.out.print("Input GPA: ");
            gpa = s.nextFloat();
            this.set_GPA(gpa);
        } while (this.gpa < 0 || this.gpa > 10);
        System.out.println("Successfully");
    }

    /**
     * update address of student
     */
    public void update_Addr(){
        Scanner s = new Scanner(System.in);
        String addr;
        do {
            System.out.print("Input Student's Address: ");
            addr = s.nextLine();
            this.set_Addr(addr);
        } while (this.addr == "");
        System.out.println("Successfully");
    }

    /**
     * update notes of student
     */
    public void update_Notes(){
        String notes;
        Scanner s = new Scanner(System.in);
        do {
            System.out.print("Input Students' Notes: ");
            notes = s.nextLine();
            this.set_Notes(notes);
        } while (this.notes == "");
        System.out.println("Successfully");
    }

    public void update_Info(){
        Scanner s = new Scanner(System.in);
        int ok = 0;
        System.out.println("0: NO");
        System.out.println("Other int: YES");
        System.out.print("Want to change ID: ");
        ok = s.nextInt();
        if (ok != 0) this.update_ID();
        System.out.print("Want to change NAME: ");
        ok = s.nextInt();
        if (ok != 0) this.update_Name();
        System.out.print("Want to change GPA: ");
        ok = s.nextInt();
        if (ok != 0) this.update_GPA();
        System.out.print("Want to change ADDRESS: ");
        ok = s.nextInt();
        if (ok != 0) this.update_Addr();
        System.out.print("Want to change NOTES: ");
        ok = s.nextInt();
        if (ok != 0) this.update_Notes();
    }
    /**
     * create new student info
     * @param gpa
     */
    public void create_Info(float gpa) {
        String id, name, addr, notes;
        Scanner s = new Scanner(System.in);
        do {
            System.out.print("Input Student's ID: ");
            id = s.nextLine();
            this.set_ID(id);
        } while (this.id == "");

        do {
            System.out.print("Input Student's Name: ");
            name = s.nextLine();
            this.set_Name(name);
        } while (this.name == "");

        do {
            System.out.print("Input Student's Address: ");
            addr = s.nextLine();
            this.set_Addr(addr);
        } while (this.addr == "");


        System.out.print("Input Students' Notes: ");
        notes = s.nextLine();
        this.set_Notes(notes);

        if (gpa < 0 || gpa > 10) {
            do {
                System.out.print("Input GPA: ");
                gpa = s.nextFloat();
                this.set_GPA(gpa);
            } while (this.gpa < 0 || this.gpa > 10);
        }
        else this.gpa = gpa;
    }

    public void print_Info(){
        if (id == null) {
            System.out.println("Empty Info");
            return;
        }
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("GPA: " + this.gpa);
        System.out.println("Address: " + this.addr);
        System.out.println("Notes: " + this.notes);
        System.out.println();
    }
}
