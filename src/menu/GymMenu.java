package menu;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class GymMenu implements MenuInterface {

    private ArrayList<Members> allMembers;
    private ArrayList<Trainer> trainersList;
    private ArrayList<WorkoutSession> sessionsList;
    private Scanner scanner;

    public GymMenu() {
        this.allMembers = new ArrayList<>();
        this.trainersList = new ArrayList<>();
        this.sessionsList = new ArrayList<>();
        this.scanner = new Scanner(System.in);

        try {
            allMembers.add(new BasicMember(1, "Amina", 22, "Basic"));
            allMembers.add(new StudentMember(2, "Maksat", 18, "Premium", "High School"));
            allMembers.add(new PremiumMember(3, "Dana", 30, "Premium", true));

            trainersList.add(new Trainer(101, "Saltanat", "Strength", 7));

            sessionsList.add(new WorkoutSession(501, "Amina", "Saltanat", 60));
            sessionsList.add(new WorkoutSession(502, "Maksat", "Saltanat", 45));
        } catch (IllegalArgumentException e) {
            System.out.println("Error initializing test data: " + e.getMessage());
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=== GYM MANAGEMENT SYSTEM ===");
        System.out.println("1. Add Member");
        System.out.println("2. Add Student Member");
        System.out.println("3. Add Premium Member");
        System.out.println("4. View All Members");
        System.out.println("5. Demonstrate Workout (Polymorphism)");
        System.out.println("6. View Student Members Only");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addMember();
                        break;
                    case 2:
                        addStudentMember();
                        break;
                    case 3:
                        addPremiumMember();
                        break;
                    case 4:
                        viewAllMembers();
                        break;
                    case 5:
                        demonstratePolymorphism();
                        break;
                    case 6:
                        viewStudentMembers();
                        break;
                    case 0:
                        running = false;
                        System.out.println("\nThank you for using the Gym Management System!");
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please select 0-6.");
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Please enter a valid number!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }


    private void addMember() {
        try {
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

            Members member = new BasicMember(id, name, age, type);
            allMembers.add(member);
            System.out.println("Member added successfully!");
        } catch (java.util.InputMismatchException e) {
            System.out.println(" Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private void addStudentMember() {
        try {
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

            StudentMember sm = new StudentMember(id, name, age, type, school);
            allMembers.add(sm);
            System.out.println("Student Member added successfully!");
        }  catch (java.util.InputMismatchException e) {
            System.out.println(" Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private void addPremiumMember() {
        try {
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
            boolean hasTrainer = scanner.nextBoolean(); scanner.nextLine();

            PremiumMember pm = new PremiumMember(id, name, age, type, hasTrainer);
            allMembers.add(pm);
            System.out.println("Premium Member added successfully!");
        } catch (java.util.InputMismatchException e) {
            System.out.println(" Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println(" Validation Error: " + e.getMessage());
        }
    }


    private void viewAllMembers() {
        System.out.println("\n=== ALL MEMBERS ===");
        if (allMembers.isEmpty()) {
            System.out.println("No members found.");
            return;
        }
        int count = 1;
        for (Members m : allMembers) {
            System.out.println(count + ". " + m);
            count++;
        }
    }

    private void viewStudentMembers() {
        System.out.println("\n=== STUDENT MEMBERS ONLY ===");
        int count = 0;
        for (Members m : allMembers) {
            if (m instanceof StudentMember sm) {
                count++;
                System.out.println(count + ". " + sm.getName() + " | School: " + sm.getSchoolName());
            }
        }
        if (count == 0)
            System.out.println("No student members found.");
    }

    private void demonstratePolymorphism() {
        System.out.println("\n=== POLYMORPHISM DEMO ===");
        for (Members m : allMembers) {
            m.workOut();
        }
    }
}
