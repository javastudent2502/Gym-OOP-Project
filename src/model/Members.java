package model;

public abstract class Members {
    protected int memberId;
    protected String name;
    protected int age;
    protected String membershipType;

    public Members(int memberId, String name, int age, String membershipType) {
        setMemberId(memberId);
        setName(name);
        setAge(age);
        setMembershipType(membershipType);
    }


    public int getMemberId() { return memberId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getMembershipType() { return membershipType; }


    public void setMemberId(int memberId) {
        if (memberId <= 0) {
            throw new IllegalArgumentException("Member ID must be positive");
        }
        this.memberId = memberId;
    }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;

    }
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;

    }
    public void setMembershipType(String membershipType) {
        if (membershipType == null || membershipType.trim().isEmpty()) {
            throw new IllegalArgumentException("Membership type cannot be empty");
        }
        this.membershipType = membershipType;
    }


    public abstract void workOut();

    public abstract String getRole();

    public void displayInfo() {
        System.out.println("ID: " + memberId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Membership type: " +  membershipType);
    }

    public boolean isActive() {
        return !membershipType.equalsIgnoreCase("Expired");
    }

    @Override
    public String toString() {
        return "[" + getRole() + "] " + name +
                " (ID: " + memberId + ", Age: " + age +
                ", Type: " + membershipType + ")";
    }
}

