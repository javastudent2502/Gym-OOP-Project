package com.meiirdana.gym;

public class WorkoutSession {

    private int sessionId;
    private String memberName;
    private String trainerName;
    private int duration;

    public WorkoutSession(int sessionId, String memberName, String trainerName, int duration) {
        this.sessionId = sessionId;
        this.memberName = memberName;
        this.trainerName = trainerName;
        this.duration = duration;
    }

    public WorkoutSession() {
        this.sessionId = 0;
        this.memberName = "Unknown";
        this.trainerName = "Unknown";
        this.duration = 0;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void extendSession(int extraMinutes) {
        duration += extraMinutes;
    }

    public boolean isLongSession() {
        return duration > 60;
    }

    @Override
    public String toString() {
        return "WorkoutSession{" +
                "sessionId=" + sessionId +
                ", memberName='" + memberName + '\'' +
                ", trainerName='" + trainerName + '\'' +
                ", duration=" + duration +
                '}';
    }
}

