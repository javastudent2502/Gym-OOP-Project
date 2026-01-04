import com.meiirdana.gym.Members;
import com.meiirdana.gym.StudentMember;
import com.meiirdana.gym.PremiumMember;
import com.meiirdana.gym.Trainer;
import com.meiirdana.gym.WorkoutSession;

import java.util.ArrayList;
import java.util.Scanner;

public class Mainn {

    private static ArrayList<Members> allMembers = new ArrayList<>();
    private static ArrayList<Trainer> trainersList = new ArrayList<>();
    private static ArrayList<WorkoutSession> sessionsList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        allMembers.add(new Members(1, "Amina", 22, "Basic"));
        allMembers.add(new StudentMember(2, "Maksat", 18, "Premium", "High School"));
        allMembers.add(new PremiumMember(3, "Dana", 30, "Premium", true));

        trainersList.add(new Trainer(101, "Saltanat", "Strength", 7));

        sessionsList.add(new WorkoutSession(501, "Amina", "Saltanat", 60));
        sessionsList.add(new WorkoutSession(502, "Maksat", "Saltanat", 45));

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: addMember();
                    break;
                case 2: addStudentMember();
                    break;
                case 3: addPremiumMember();
                    break;
                case 4: viewAllMembers();
                    break;
                case 5: demonstratePolymorphism();
                    break;
                case 6: viewStudentMembers();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== GYM SYSTEM ===");
        System.out.println("1. Add Member ");
        System.out.println("2. Add Student Member");
        System.out.println("3. Add Premium Member");
        System.out.println("4. View All Members ");
        System.out.println("5. Demonstrate Workout");
        System.out.println("6. View Student Members Only");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }



    private static void addMember() {
        System.out.println("\n--- ADD MEMBER ---");
        System.out.print("Enter Member ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Membership Type: ");
        String type = scanner.nextLine();

        Members member = new Members(id, name, age, type);
        allMembers.add(member);
        System.out.println("Member added successfully!");
    }

    private static void addStudentMember() {
        System.out.println("\n--- ADD STUDENT MEMBER ---");
        System.out.print("Enter Member ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Membership Type: ");
        String type = scanner.nextLine();
        System.out.print("Enter School Name: ");
        String school = scanner.nextLine();

        Members member = new StudentMember(id, name, age, type, school);
        allMembers.add(member);
        System.out.println("Student Member added successfully!");
    }

    private static void addPremiumMember() {
        System.out.println("\n--- ADD PREMIUM MEMBER ---");
        System.out.print("Enter Member ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Membership Type: ");
        String type = scanner.nextLine();
        System.out.print("Has Personal Trainer? (true/false): ");
        boolean hasTrainer = scanner.nextBoolean();
        scanner.nextLine();

        Members member = new PremiumMember(id, name, age, type, hasTrainer);
        allMembers.add(member);
        System.out.println("Premium Member added successfully!");
    }


    private static void viewAllMembers() {
        System.out.println("\n=== ALL MEMBERS (POLYMORPHIC LIST) ===");
        if (allMembers.isEmpty()) {
            System.out.println("No members found.");
            return;
        }
        int count = 1;
        for (Members m : allMembers) {
            System.out.println(count + ". " + m);
            if (m instanceof StudentMember) {
                StudentMember sm = (StudentMember) m;
                System.out.println(" School: " + sm.getSchoolName());
            } else if (m instanceof PremiumMember) {
                PremiumMember pm = (PremiumMember) m;
                System.out.println(" Personal Trainer: " + pm.hasPersonalTrainer());
            }
            count++;
            System.out.println();
        }
    }

    private static void demonstratePolymorphism() {
        System.out.println("\n=== POLYMORPHISM DEMONSTRATION ===");
        System.out.println("Calling workOut() on all members:");
        System.out.println();
        for (Members m : allMembers) {
            m.workOut();
        }
    }
    private static void viewStudentMembers() {
        System.out.println("\n=== STUDENT MEMBERS ONLY ===");
        int count = 0;
        for (Members m : allMembers) {
            if (m instanceof StudentMember) {
                count++;
                StudentMember sm = (StudentMember) m;
                System.out.println(count + ". " + sm.getName() + " | School: " + sm.getSchoolName());
            }
        }
        if (count == 0) {
            System.out.println("No student members found.");
        }
    }

}