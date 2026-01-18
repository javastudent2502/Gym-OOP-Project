package model;

public class WorkoutSession {

    private int sessionId;
    private String memberName;
    private String trainerName;
    private int duration;

    public WorkoutSession(int sessionId, String memberName, String trainerName, int duration) {
        setSessionId(sessionId);
        setMemberName(memberName);
        setTrainerName(trainerName);
        setDuration(duration);
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
        if (sessionId <= 0) {
            throw new IllegalArgumentException("Session ID must be positive");
        }
        this.sessionId = sessionId;
    }

    public void setMemberName(String memberName) {
        if (memberName == null || memberName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.memberName = memberName;
    }

    public void setTrainerName(String trainerName) {
        if (trainerName == null || trainerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.trainerName = trainerName;
    }

    public void setDuration(int duration) {
        if (duration < 0) {
            throw new IllegalArgumentException("Duration cannot be negative");
        }
        this.duration = duration;
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

