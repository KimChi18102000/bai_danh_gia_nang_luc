package com.testek;

public class GoodStudent extends Student {
    private double gpa;
    private String bestRewardName;

    //GETTER + SETTER
    public double getGPA() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getBestRewardName() {
        return bestRewardName;
    }
    public void setBestRewardName(String bestRewardName) {
        this.bestRewardName = bestRewardName;
    }

    //CONSTRUCTOR
    public GoodStudent(String fullName, String sex, String universityName, String gradeLevel, String doB, String phoneNumber, double gpa, String bestRewardName) {
        super(fullName, sex, universityName, gradeLevel, doB, phoneNumber);
        this.gpa = gpa;
        this.bestRewardName = bestRewardName;
    }

    //DISPLAY INFORMATION
    public void showMyInfor() {
        super.showMyInfor();
        System.out.println("Diem trung binh hoc tap: " + getGPA());
        System.out.println("Ten loai hoc bong cao nhat: " + getBestRewardName());
    }
}
