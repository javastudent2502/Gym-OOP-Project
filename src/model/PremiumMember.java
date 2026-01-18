package model;

public class PremiumMember extends Members {
    private boolean personalTrainer;

    public PremiumMember(int memberId, String name, int age, String membershipType, boolean personalTrainer) {
        super(memberId, name, age, membershipType);
        setPersonalTrainer(personalTrainer);
    }

    public boolean hasPersonalTrainer() { return personalTrainer; }
    public void setPersonalTrainer(boolean personalTrainer) {
        this.personalTrainer = personalTrainer;
    }

    @Override
    public void workOut() {
        System.out.println(name + " is doing an intensive premium workout.");
    }

    @Override
    public String getRole() {
        return "Premium Member";
    }

    public void bookTrainer() {
        if(personalTrainer)
            System.out.println(name + " has booked a personal trainer.");
        else
            System.out.println(name + " has no personal trainer.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Role: " + getRole());
        System.out.println("Personal Trainer: " + (personalTrainer ? "Yes" : "No"));
    }

    @Override
    public String toString() {
        return super.toString() + " | Personal Trainer: " + (personalTrainer ? "Yes" : "No");
    }
}
