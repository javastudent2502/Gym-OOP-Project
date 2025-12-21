package com.meiirdana.gym;

public class Trainer {

    private int trainerId;
    private String name;
    private String specialization;
    private int experienceYears; // убрали static


    public Trainer(int trainerId, String name, String specialization, int experienceYears) {
        this.trainerId = trainerId;
        this.name = name;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
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

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
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
