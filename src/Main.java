import menu.MenuInterface;
import menu.GymMenu;

public class Main {
    public static void main(String[] args) {
        MenuInterface menu = new GymMenu();
        menu.run();
    }
}
