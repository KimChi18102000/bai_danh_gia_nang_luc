package com.testek;

public class NormalStudent extends Student {
    private int englishScore;
    private float entryTestScore;

    //GETTER + SETTER
    public float getEntryTestScore() {
        return entryTestScore;
    }
    public void setEntryTestScore(float entryTestScore) {
        this.entryTestScore = entryTestScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }
    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    //CONSTRUCTOR
    public NormalStudent(String fullName, String sex, String universityName, String gradeLevel, String doB, String phoneNumber, float entryTestScore, int englishScore) {
        super(fullName, sex, universityName, gradeLevel, doB, phoneNumber);
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
    }

    //DISPLAY INFORMATION
    public void showMyInfor() {
        super.showMyInfor();
        System.out.println("Diem TOEIC: " + getEnglishScore());
        System.out.println("Diem thi dau vao chuyen mon: " + getEntryTestScore());
    }
}
