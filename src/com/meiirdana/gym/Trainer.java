package com.meiirdana.gym;

public class Trainer {

    private int trainerId;
    private String name;
    private String specialization;
    private int experienceYears;


    public Trainer(int trainerId, String name, String specialization, int experienceYears) {
        this.trainerId = trainerId;
        setName(name);
        this.specialization = specialization;
        setExperienceYears(experienceYears);
    }


    public Trainer() {
        this.trainerId = 0;
        this.name = "Unknown";
        this.specialization = "General";
        this.experienceYears = 0;
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
        this.trainerId = trainerId;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            this.name = "Unknown";
        }
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


    public void setExperienceYears(int experienceYears) {
        if  (experienceYears >= 0) {
            this.experienceYears = experienceYears;
        } else {
            this.experienceYears = 0;
        }
    }


    public boolean isExperienced() {
        return experienceYears >= 5;
    }

    public boolean canTeach(String type) {
        return specialization.equals(type);
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
