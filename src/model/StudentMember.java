package model;

public class StudentMember extends Members {
    private String schoolName;

    public StudentMember(int memberId, String name, int age, String membershipType, String schoolName) {
        super(memberId, name, age, membershipType);
        setSchoolName(schoolName);
    }

    public String getSchoolName() { return schoolName; }
    public void setSchoolName(String schoolName) {
        if (schoolName == null || schoolName.trim().isEmpty()) {
            throw new IllegalArgumentException("School Name cannot be empty");
        }
        this.schoolName = schoolName;
    }

    @Override
    public void workOut() {
        System.out.println(name + " is doing a student-friendly workout.");
    }

    @Override
    public String getRole() {
        return "Student Member";
    }

    public void study() {
        System.out.println(name + " is studying while staying fit!");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Role: " + getRole());
        System.out.println("School: " + schoolName);
    }

    @Override
    public String toString() {
        return super.toString() + " | School: " + schoolName;
    }
}
