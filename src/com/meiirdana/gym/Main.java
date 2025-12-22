import com.meiirdana.gym.Members;
import com.meiirdana.gym.Trainer;
import com.meiirdana.gym.WorkoutSession;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Gym Management System ===\n");

        Members m1 = new Members(1, "Amina", 22, "Basic");
        Members m2 = new Members(2, "Maksat", 25, "Expired");

        Trainer t1 = new Trainer(101, "Saltanat", "Strength", 7);

        WorkoutSession s1 = new WorkoutSession(501, "Amina", "Saltanat", 60);
        WorkoutSession s2 = new WorkoutSession(502, "Maksat", "Saltanat", 45);

        System.out.println("--- MEMBERS ---");
        System.out.println(m1);
        System.out.println(m2);

        System.out.println("\n--- TRAINERS ---");
        System.out.println(t1);

        System.out.println("\n--- SESSIONS ---");
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("\n--- TESTING GETTERS ---");
        System.out.println("Member 1 name: " + m1.getName());
        System.out.println("Member 1 age: " + m1.getAge());
        System.out.println("Member 1 membership type: " + m1.getMembershipType());
        System.out.println("Member 2 name: " + m2.getName());
        System.out.println("Trainer name: " + t1.getName());
        System.out.println("Trainer experience years: " + t1.getExperienceYears());
        System.out.println("Session 1 duration: " + s1.getDuration());

        System.out.println("\n--- TESTING SETTERS ---");
        m1.setAge(23);
        m1.setMembershipType("Premium");
        System.out.println("Member 1 after age and membership update: " + m1);

        t1.setSpecialization("Cardio");
        System.out.println("Trainer after specialization update: " + t1);

        s1.setDuration(75);
        System.out.println("Session 1 after duration update: " + s1);

        System.out.println("\n--- TESTING ADDITIONAL METHODS ---");
        System.out.println("Is Amina active? " + m1.isActive());
        m2.upgradeMembership();
        System.out.println("Maksat upgraded: " + m2);

        System.out.println("Trainer experienced? " + t1.isExperienced());
        System.out.println("Trainer can teach Strength? " + t1.canTeach("Strength"));
        System.out.println("Trainer can teach Cardio? " + t1.canTeach("Cardio"));

        s1.extendSession(30);
        System.out.println("Extended session 1: " + s1);
        System.out.println("Is session 1 long? " + s1.isLongSession());

        System.out.println("\n--- FINAL STATE ---");
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(t1);
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("\n=== Program Complete ===");
    }
}