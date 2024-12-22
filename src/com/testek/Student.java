package com.testek;

public abstract class Student {
    private String fullName, sex, universityName, gradeLevel, phoneNumber;
    private String doB;

    //GETTER + SETTER
    public String getFullName() {
        return fullName;
    }
    public void getFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSex() {
        return sex;
    }
    public void getSex(String sex) {
        this.sex = sex;
    }

    public String getUniversityName() {
        return universityName;
    }
    public void getUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }
    public void getGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public String getDob() {
        return doB;
    }
    public void getDob(String doB) {
        this.doB = doB;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void getPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //CONSTRUCTOR
    public Student(String fullName, String sex, String universityName, String gradeLevel, String doB, String phoneNumber) {
        this.fullName = fullName;
        this.sex = sex;
        this.universityName = universityName;
        this.gradeLevel = gradeLevel;
        this.doB = doB;
        this.phoneNumber = phoneNumber;
    }

    //DISPLAY INFORMATION
    public void showMyInfor() {
        System.out.println("\nTHONG TIN CUA SINH VIEN");
        System.out.println("Ho ten sinh vien: " + getFullName());
        System.out.println("Gioi tinh cua sinh vien: " + getSex());
        System.out.println("Ten truong dai hoc cua sinh vien: " + getUniversityName());
        System.out.println("Xep loai tot nghiep: " + getGradeLevel());
        System.out.println("Ngay sinh: " + getDob());
        System.out.println("So dien thoai: " + getPhoneNumber());
    }
}
