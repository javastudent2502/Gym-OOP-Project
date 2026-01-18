package model;

public class BasicMember extends Members {

    public BasicMember(int memberId, String name, int age, String membershipType) {
        super(memberId, name, age, membershipType);
    }

    @Override
    public void workOut() {
        System.out.println(getName() + " is doing a basic workout.");
    }

    @Override
    public String getRole() {
        return "Basic Member";
    }
}
