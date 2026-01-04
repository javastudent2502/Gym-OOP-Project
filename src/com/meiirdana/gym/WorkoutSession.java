package com.meiirdana.gym;

public class WorkoutSession {

    private int sessionId;
    private String memberName;
    private String trainerName;
    private int duration;

    public WorkoutSession(int sessionId, String memberName, String trainerName, int duration) {
        this.sessionId = sessionId;
        setMemberName(memberName);
        setTrainerName(trainerName);
        setDuration(duration);
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

    public String getMemberName() {
        return memberName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public int getDuration() {
        return duration;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public void setMemberName(String memberName) {
        if (memberName != null && !memberName.trim().isEmpty()) {
            this.memberName = memberName;
        } else {
            this.memberName = "Unknown";
        }
    }

    public void setTrainerName(String trainerName) {
        if (trainerName != null && !trainerName.trim().isEmpty()) {
            this.trainerName = trainerName;
        } else {
            this.trainerName = "Unknown";
        }
    }

    public void setDuration(int duration) {
        if (duration > 0) {
            this.duration = duration;
        } else {
            this.duration = 0;
        }
    }

    public void extendSession(int extraMinutes) {
        if (extraMinutes > 0) {
            duration += extraMinutes;
        }
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

