import com.meiirdana.gym.Members;
import com.meiirdana.gym.Trainer;
import com.meiirdana.gym.WorkoutSession;

import java.util.ArrayList;
import java.util.Scanner;

public class Mainn {

    private static ArrayList<Members> membersList = new ArrayList<>();
    private static ArrayList<Trainer> trainersList = new ArrayList<>();
    private static ArrayList<WorkoutSession> sessionsList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        membersList.add(new Members(1, "Amina", 22, "Basic"));
        membersList.add(new Members(2, "Maksat", 25, "Expired"));

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
                case 2: viewAllMembers();
                        break;
                case 3: addTrainer();
                        break;
                case 4: viewAllTrainers();
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
        System.out.println("1. Add Member");
        System.out.println("2. View All Members");
        System.out.println("3. Add Trainer");
        System.out.println("4. View All Trainers");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }


    private static void addMember() {
        System.out.print("Enter Member ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Member Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Member Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Membership Type: ");
        String type = scanner.nextLine();

        membersList.add(new Members(id, name, age, type));
        System.out.println("Member added successfully!");
    }

    private static void viewAllMembers() {
        System.out.println("\n--- ALL MEMBERS ---");
        if (membersList.isEmpty()) {
            System.out.println("No members found.");
            return;
        }
        for (Members m : membersList) {
            System.out.println(m);
        }
    }


    private static void addTrainer() {
        System.out.print("Enter Trainer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Trainer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String spec = scanner.nextLine();
        System.out.print("Enter Experience Years: ");
        int exp = scanner.nextInt();
        scanner.nextLine();

        trainersList.add(new Trainer(id, name, spec, exp));
        System.out.println("Trainer added successfully!");
    }

    private static void viewAllTrainers() {
        System.out.println("\n--- ALL TRAINERS ---");
        if (trainersList.isEmpty()) {
            System.out.println("No trainers found.");
            return;
        }
        for (Trainer t : trainersList) {
            System.out.println(t);
        }
    }


    }
