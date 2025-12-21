import com.meiirdana.gym.Members;
import com.meiirdana.gym.Trainer;
import com.meiirdana.gym.WorkoutSession;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Gym Management System ===\n");

        Members m1 = new Members(1, "Alex", 22, "Basic");
        Members m2 = new Members(2, "Mila", 25, "Expired");

        Trainer t1 = new Trainer(101, "John", "Strength", 7);

        WorkoutSession s1 = new WorkoutSession(501, "Alex", "John", 60);
        WorkoutSession s2 = new WorkoutSession(502, "Mila", "John", 45);

        System.out.println("--- MEMBERS ---");
        System.out.println(m1);
        System.out.println(m2);

        System.out.println("\n--- TRAINERS ---");
        System.out.println(t1);

        System.out.println("\n--- SESSIONS ---");
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("\n--- TESTING METHODS ---");
        System.out.println("Is Alex active? " + m1.isActive());
        m2.upgradeMembership();
        System.out.println("Mila upgraded: " + m2);

        System.out.println("Trainer experienced: " + t1.isExperienced()); // через объект

        s1.extendSession(30);
        System.out.println("Extended session: " + s1);

        System.out.println("\n=== Program Complete ===");
    }
}
