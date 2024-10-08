import java.util.*;

class Student{
    String name;
    String ID;
    String branch;
    int sem;
    String phNo;

    public Student(String name, String ID, String branch, int sem, String phNo){
        this.name = name;
        this.ID = ID;
        this.branch = branch;
        this.sem = sem;
        this.phNo = phNo;
    }

    public void displayStudent(){
        System.out.println("\nName: " + name + "\nID: " + ID + "\nBranch: " + branch + "\nSemester: " + sem + "\nPhone No: " + phNo);
    }
}

class StudentManagementSystem{
    ArrayList<Student> studentList = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public void addStudent(){
        try {
            System.out.print("Enter Name: ");
            String name = in.nextLine();
            System.out.print("Enter ID: ");
            String id = in.nextLine();
            System.out.print("Enter Branch: ");
            String branch = in.nextLine();
            System.out.print("Enter Semester: ");
            int sem = in.nextInt();
            in.nextLine(); 
            System.out.print("Enter Phone No: ");
            String phNo = in.nextLine();

            Student newStudent = new Student(name, id, branch, sem, phNo);
            studentList.add(newStudent);

            System.out.println("Student added successfully!\n");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            in.nextLine();
        }
    }

    public void updateStudent(){
        System.out.print("Enter Student ID whose data you want to update: ");
        String id = in.nextLine();
        for(Student s : studentList){
            if(s.ID.equalsIgnoreCase(id)){
                s.displayStudent();
                System.out.println("Enter what you want to update:");
                System.out.println("1. Name\n2. ID\n3. Branch\n4. Semester\n5. Phone No ");
                System.out.print("Enter your choice: ");
                int choice = in.nextInt();
                in.nextLine();
                switch (choice){
                    case 1:
                        System.out.println("Enter updated Name: ");
                        s.name = in.nextLine();
                        break;
                    case 2:
                        System.out.println("Enter updated ID: ");
                        s.ID = in.nextLine();
                        break;
                    case 3:
                        System.out.println("Enter updated Branch: ");
                        s.branch = in.nextLine();
                        break;
                    case 4:
                        System.out.println("Enter updated Semester: ");
                        s.sem  = in.nextInt();
                        in.nextLine();
                        break;
                    case 5:
                        System.out.println("Enter updated Phone No.: ");
                        s.phNo = in.nextLine();
                        break;
                    default:
                        System.out.println("Invalid choice!\nExiting without any changes...");
                        break;
                }
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("No student with such ID found.");
    }

    public void listAll(){
        if(studentList.isEmpty()){
            System.out.println("No students found.");
        } else {
            for(Student s : studentList){
                s.displayStudent();
                System.out.println();
            }
        }
    }

    public void findStudent(){
        System.out.print("Enter Student ID: ");
        String id = in.nextLine();
        for(Student s : studentList){
            if(s.ID.equals(id)){
                s.displayStudent();
                return;
            }
        }
        System.out.println("No student with such ID found.");
    }
}

public class Main{
    public static void main(String[] args) {
        int choice;
        Scanner in = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        do{
            System.out.println("\n---Student Management System---\n");
            System.out.println("1. Add Student.");
            System.out.println("2. Update Student.");
            System.out.println("3. List All Students.");
            System.out.println("4. Find Student by ID.");
            System.out.println("5. Exit.");
            System.out.print("Enter Your Choice: ");

            while (!in.hasNextInt()) {
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                in.next();
            }

            choice = in.nextInt();
            in.nextLine();

            switch(choice){
                case 1:
                    sms.addStudent();
                    break;
                case 2:
                    sms.updateStudent();
                    break;
                case 3:
                    sms.listAll();
                    break;
                case 4:
                    sms.findStudent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        } while(choice != 5);

        in.close();
    }
}
