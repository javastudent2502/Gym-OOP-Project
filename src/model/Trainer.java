package model;

public class Trainer implements Trainable {

    private int trainerId;
    private String name;
    private String specialization;
    private int experienceYears;


    public Trainer(int trainerId, String name, String specialization, int experienceYears) {
        setTrainerId(trainerId);
        setName(name);
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
    }

    public int getTrainerId() {
        return trainerId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setTrainerId(int trainerId) {
        if (trainerId <= 0) {
            throw new IllegalArgumentException("Trainer ID must be positive");
        }
        this.trainerId = trainerId;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new IllegalArgumentException("Specialization cannot be empty");
        }
        this.specialization = specialization;
    }


    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0) {
            throw new IllegalArgumentException("Experience years cannot be negative");
        }
        this.experienceYears = experienceYears;
    }


    public boolean isExperienced() {
        return experienceYears >= 5;
    }

    public boolean canTeach(String type) {
        return specialization.equals(type);
    }

    @Override
    public void train() {
        System.out.println(name + " is training clients");
        System.out.println("Specialization: " + specialization);
        System.out.println("Experience years: " + experienceYears);
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "trainerId=" + trainerId +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experienceYears=" + experienceYears +
                '}';
    }
}
