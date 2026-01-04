package com.meiirdana.gym;

public class Members {
    protected int memberId;
    protected String name;
    protected int age;
    protected String membershipType;

    public Members(int memberId, String name, int age, String membershipType) {
        this.memberId = memberId;
        this.name = name;
        this.age = age;
        this.membershipType = membershipType;
    }


    public int getMemberId() { return memberId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getMembershipType() { return membershipType; }


    public void setMemberId(int memberId) { this.memberId = memberId; }
    public void setName(String name) {
        if(name != null && !name.trim().isEmpty()) this.name = name;
    }
    public void setAge(int age) {
        if(age >= 0) this.age = age;
    }
    public void setMembershipType(String membershipType) {this.membershipType = membershipType;}


    public void workOut() {
        System.out.println(name + " is working out.");
    }

    public String getRole() {
        return "Member";
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

