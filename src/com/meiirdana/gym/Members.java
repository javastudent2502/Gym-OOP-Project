package com.meiirdana.gym;

public class Members {

    private int memberId;
    private String name;
    private int age;
    private String membershipType;

    public Members(int memberId, String name, int age, String membershipType) {
        this.memberId = memberId;
        this.name = name;
        this.age = age;
        this.membershipType = membershipType;
    }

    public Members() {
        this.memberId = 0;
        this.name = "Unknown";
        this.age = 0;
        this.membershipType = "Basic";
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public boolean isActive() {
        return !membershipType.equals("Expired");
    }

    public void upgradeMembership() {
        this.membershipType = "Premium";
    }

    @Override
    public String toString() {
        return "Members{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", membershipType='" + membershipType + '\'' +
                '}';
    }
}

