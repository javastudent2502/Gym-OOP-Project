package menu;

import database.*;
import exception.InvalidInputException;
import model.*;
import java.util.List;
import java.util.Scanner;

public class GymMenu implements MenuInterface {
    private final MemberDAO memberDAO;
    private final Scanner scanner ;

    public GymMenu() {
        this.memberDAO = new MemberDAO();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         MAIN MENU                     ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("┌─ MEMBERS MANAGEMENT ─────────────────────┐");
        System.out.println("|1. Add Member                             |");
        System.out.println("|2. Add Student Member                     |");
        System.out.println("|3. Add Premium Member                     |");
        System.out.println("|4. View All Members                       |");
        System.out.println("|5. View Student Members Only              |");
        System.out.println("|6. Update Member                          |");
        System.out.println("|7. Delete Member                          |");
        System.out.println("├─ SEARCH & FILTER   ──────────────────────┤");
        System.out.println("|8. Search by Min Age                      |");
        System.out.println("|9. Search Member by Name                  |");
        System.out.println("|10. Search by Age Range                   |");
        System.out.println("├─ DEMO & OTHER   ─────────────────────────┤");
        System.out.println("|11. Demonstrate Workout (Polymorphism)    |");
        System.out.println("|0. Exit                                   |");
        System.out.println("└────────────────────────────────────────--┘");
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
                        addBasicMember();
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
                        viewStudentMembers();
                        break;
                    case 6:
                        updateMember();
                        break;
                    case 7:
                        deleteMember();
                        break;
                    case 8:
                        searchByMinAge();
                        break;
                    case 9:
                        searchByName();
                        break;
                    case 10:
                        searchByAgeRange();
                        break;
                    case 11:
                        demonstratePolymorphism();
                        break;
                    case 0:
                        running = false;
                        System.out.println("\nThank you for using the Gym Management System!");
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please select 0-11.");
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


    private void addBasicMember() {
        try{
            System.out.println("Enter member name:");
            String name= scanner.nextLine();

            System.out.println("Enter members age:");
            int age= scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter membership type:");
            String type = scanner.nextLine();

            Members member = new BasicMember(0,name,age,type);
            memberDAO.insertBasicMember((BasicMember) member);
        }catch(java.util.InputMismatchException e){
            System.out.println("Invalid input type");
            scanner.nextLine();
        }catch(IllegalArgumentException e){
            System.out.println("Error:" + e.getMessage());
        }
    }

    private void addStudentMember() {
        try {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Membership Type: ");
            String type = scanner.nextLine();

            System.out.print("Enter School Name: ");
            String school = scanner.nextLine();

            StudentMember sm = new StudentMember(0,name, age, type, school);
            memberDAO.insertStudentMember(sm);
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
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Membership Type: ");
            String type = scanner.nextLine();

            System.out.print("Has Personal Trainer? (true/false): ");
            boolean hasTrainer = scanner.nextBoolean(); scanner.nextLine();

            PremiumMember pm = new PremiumMember(0, name, age, type, hasTrainer);
            memberDAO.insertPremiumMember(pm);
            System.out.println("Premium Member added successfully!");
        } catch (java.util.InputMismatchException e) {
            System.out.println(" Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println(" Validation Error: " + e.getMessage());
        }
    }


    private void viewAllMembers() {
        memberDAO.displayAllMembers();
    }


    private void viewStudentMembers() {
        System.out.println("\n=== STUDENT MEMBERS ONLY ===");

        List<Members>  members = memberDAO.getAllMembers();

        int count = 0;
        for (Members m : members) {
            if (m instanceof StudentMember sm) {
                count++;
                System.out.println(count + ". " + sm.getName() + " | School: " + sm.getSchoolName());
            }
        }
        if (count == 0)
            System.out.println("No student members found.");
    }


    private void updateMember() {
        System.out.print("Enter Member ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Members m = memberDAO.getMemberById(id);
        if (m == null) {
            System.out.println(" Member not found");
            return;
        }

        System.out.println("Current info:");
        System.out.println(m);

        System.out.print("New name [" + m.getName() + "]: ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) m.setName(name);

        System.out.print("New age [" + m.getAge() + "]: ");
        String ageStr = scanner.nextLine();
        if (!ageStr.isEmpty()) m.setAge(Integer.parseInt(ageStr));

        System.out.print("New membership type [" + m.getMembershipType() + "]: ");
        String type = scanner.nextLine();
        if (!type.isEmpty()) m.setMembershipType(type);


        if (m instanceof StudentMember sm) {
            System.out.print("New school [" + sm.getSchoolName() + "]: ");
            String school = scanner.nextLine();
            if (!school.isEmpty()) sm.setSchoolName(school);
            memberDAO.updateStudentMember(sm);

        } else if (m instanceof PremiumMember pm) {
            System.out.print("Has personal trainer (" + pm.hasPersonalTrainer() + "): ");
            String trainerInput = scanner.nextLine();
            if (!trainerInput.isEmpty())
                pm.setPersonalTrainer(Boolean.parseBoolean(trainerInput));

            memberDAO.updatePremiumMember(pm);

        } else if (m instanceof BasicMember bm) {
            memberDAO.updateBasicMember(bm);
        }
    }


    private void deleteMember() {
        System.out.print("Enter Member ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Members m = memberDAO.getMemberById(id);
        if (m == null) {
            System.out.println("Member not found");
            return;
        }

        System.out.println("Delete: " + m);
        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            memberDAO.deleteMember(id);
            System.out.println(" Deleted");
        } else {
            System.out.println("Cancelled");
        }
    }
    private void searchByName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();

        List<Members> results  = memberDAO.searchByName(name);

        if (results.isEmpty()) {
            System.out.println("No members found.");
        } else {
            results.forEach(System.out::println);
        }
    }

    private void searchByAgeRange() {
        System.out.print("Enter min age: ");
        int min = scanner.nextInt();
        System.out.print("Enter max age: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        List<Members> results = memberDAO.searchByAgeRange(min, max);
        results.forEach(System.out::println);
    }

    private void searchByMinAge() {
        System.out.print("Enter minimum age: ");
        int min = scanner.nextInt();
        scanner.nextLine();

        List<Members> results = memberDAO.searchByMinAge(min);
        results.forEach(System.out::println);
    }

    private void demonstratePolymorphism() {
        memberDAO.demonstratePolymorphism();
    }
}


