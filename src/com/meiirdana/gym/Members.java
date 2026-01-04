package com.meiirdana.gym;

public class Members {

    private int memberId;
    private String name;
    private int age;
    private String membershipType;

    public Members(int memberId, String name, int age, String membershipType) {
        this.memberId = memberId;
        setName(name);
        setAge(age);
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

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            this.name = "Unknown";
        }
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            this.age = 0;
        }
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public boolean isAdult() {
        return age >= 18;
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

