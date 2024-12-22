package com.testek;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    private static List<GoodStudent> goodStudentList = new ArrayList<>();
    private static List<NormalStudent> normalStudentList = new ArrayList<>();
    private static List<Student> recruitStudentList = new ArrayList<>();

    //1. In danh sach sinh vien kha gioi
    public static void printListGoodStudent() {
        if(goodStudentList.isEmpty()) {
            System.out.println("Danh sach sinh vien kha gioi trong");
        }
        else {
            for(GoodStudent goodStudent : goodStudentList) {
                goodStudent.showMyInfor();
            }
        }
    }

    //2. In danh sach sinh vien trung binh
    public static void printListNormalStudent() {
        if(normalStudentList.isEmpty()) {
            System.out.println("Danh sach sinh vien trung binh trong");
        }
        else {
            for(NormalStudent normalStudent : normalStudentList) {
                normalStudent.showMyInfor();
            }
        }
    }

    //VALIDATE
    //Validate fullName
    private static String getFullName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap fullName : ");
        String fullName = sc.nextLine();
        for(int i=0; i <= 3; i++) {
            if(fullName.length() < 10 || fullName.length() > 50) {
                if(i == 3) return null;
                System.out.println("Vui long nhap lai fullName");
                fullName = sc.nextLine();
            }
            else break;
        }
        return fullName;
    }

    //Validate phoneNumber
    public static boolean validatePhoneNumber(String phoneNumber) {
        int sizePhone = phoneNumber.length();
        String phoneNumHead = phoneNumber.substring(0, 3);
        if(sizePhone == 10) {
            if(phoneNumHead.equals("090") || phoneNumHead.equals("098") || phoneNumHead.equals("091") ||
                    phoneNumHead.equals("031") || phoneNumHead.equals("035") || phoneNumHead.equals("038")) {
                return true;
            }
        }
        throw new RuntimeException("So dien thoai khong hop le");
    }

    //3. Them sinh vien kha gioi vao danh sach
    public static void addGoodStudent(List<GoodStudent> goodStudentList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin SV kha gioi");
        String fullName = getFullName();
        if (fullName == null) return;
        System.out.print("Nhap gioi tinh: ");
        String sex = sc.nextLine();
        System.out.print("Nhap te truong dai hoc: ");
        String universityName = sc.nextLine();
        System.out.print("Nhap xep loai tot nghiep: ");
        String gradeLevel = sc.nextLine();
        System.out.print("Nhap ngay thang nam sinh: ");
        String doB =  sc.nextLine();
        System.out.print("Nhap SDT: ");
        String phoneNumber = sc.nextLine();
        if (!validatePhoneNumber(phoneNumber)) return;
        System.out.print("Nhap thong tin DTB hoc tap: ");
        double gpa = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhap thong tin học bong / giai thuong cao nhat: ");
        String bestRewardName = sc.nextLine();
        GoodStudent goodStudent = new GoodStudent(fullName, sex, universityName, gradeLevel, doB, phoneNumber, gpa, bestRewardName);
        goodStudentList.add(goodStudent);
        System.out.println("Them sinh vien kha gioi thanh cong");
    }


    //4. Them sinh vien trung binh vao danh sach
    public static void addNormalStudent(List<NormalStudent> normalStudents) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin SV trung binh");
        String fullName = getFullName();
        if(fullName == null) return;
        System.out.print("Nhap gioi tinh: ");
        String sex = sc.nextLine();
        System.out.print("Nhap te truong dai hoc: ");
        String universityName = sc.nextLine();
        System.out.print("Nhap xep loai tot nghiep: ");
        String gradeLevel = sc.nextLine();
        System.out.print("Nhap xep ngay thang nam sinh: ");
        String doB =  sc.nextLine();
        System.out.print("Nhap phoneNumber: ");
        String phoneNumber = sc.nextLine();
        if (!validatePhoneNumber(phoneNumber)) return;
        System.out.print("Nhap thong tin diem thi dau vao chuyen mon: ");
        float entryTestScore = sc.nextFloat();
        System.out.print("Nhap thong tin diem TOEIC: ");
        int englishScore = sc.nextInt();
        NormalStudent normalStudent = new NormalStudent(fullName, sex, universityName, gradeLevel, doB, phoneNumber, entryTestScore, englishScore);
        normalStudentList.add(normalStudent);
        System.out.println("Them sinh vien trung binh thanh cong");
    }

    //So sanh GPA cua cac sinh vien kha gioi
    public static void buildRecruitGoodStudent (List<GoodStudent> goodStudentList, List<Student> recruitStudentList, int countStudent) {
        goodStudentList.sort(new Comparator<GoodStudent>() {
            @Override
            public int compare(GoodStudent o1, GoodStudent o2) {
                if (o1.getGPA() == o2.getGPA()) {
                    return o2.getFullName().compareTo(o1.getFullName());
                } else if (o1.getGPA() < o2.getGPA())
                    return 1;
                else
                    return -1;
            }
        });
        for (int i = 0; i < countStudent; i++) {
            recruitStudentList.add(goodStudentList.get(i));
        }
    }

    //5. Tuyen dung sinh vien
    public static void recruitStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong SV can tuyen dung: ");
        int countStudent = sc.nextInt();
        if(countStudent < 11 || countStudent > 15) {
            System.out.println("So luong sinh vien can tuyen dung khong hơp le");
        }
        else{
            if(goodStudentList.size() == countStudent){
                recruitStudentList.addAll(goodStudentList);
                return;
            }
            // can sap xep lai goodStudentList theo thu tu gpa cao xuong thap -> lay ra nhung sinh vien do add vao list recruitStudentList
            goodStudentList.sort(new Comparator<GoodStudent>() {
                @Override
                public int compare(GoodStudent o1, GoodStudent o2) {
                    if(o1.getGPA() < o2.getGPA()) return 1;
                    else if(o1.getGPA() == o2.getGPA()){
                        return o1.getFullName().compareTo(o2.getFullName());
                    }
                    else return -1;
                }
            });
            if(countStudent < goodStudentList.size()) {
                for(int i = 0; i< countStudent; i++){
                    recruitStudentList.add(goodStudentList.get(i));
                }
                return;
            }
            recruitStudentList.addAll(goodStudentList);
            if (recruitStudentList.size() < countStudent) {
                normalStudentList.sort(new Comparator<NormalStudent>() {
                    @Override
                    public int compare(NormalStudent o1, NormalStudent o2) {
                        if (o1.getEntryTestScore() < o2.getEntryTestScore()) return 1;
                        else if (o1.getEntryTestScore() == o2.getEntryTestScore()) {
                            if (o1.getEnglishScore() < o2.getEnglishScore()) return 1;
                            else if (o1.getEnglishScore() == o2.getEnglishScore()) {
                                return o2.getFullName().compareTo(o1.getFullName());
                            } else return -1;
                        } else return -1;
                    }
                });
            }
            System.out.println("So luong sinh vien kha duoc tuyen: " + (countStudent - recruitStudentList.size()));
            for (int i = 0; i <= countStudent - recruitStudentList.size(); i++) {
                recruitStudentList.add(normalStudentList.get(i));
            }
        }
    }

    //6. In danh sach sinh vien trung tuyen
    public static void printRecruitStudentList() {
        if(recruitStudentList.isEmpty()) {
            System.out.println("Danh sach sinh vien trung tuyen trong");
        }
        else {
            for(Student student : recruitStudentList) {
                student.showMyInfor();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. In danh sach sinh vien kha gioi");
            System.out.println("2. In danh sach sinh vien trung binh");
            System.out.println("3. Them sinh vien kha gioi vao danh sach");
            System.out.println("4. Them sinh vien trung binh vao danh sach");
            System.out.println("5. Tuyen dung sinh vien");
            System.out.println("6. In danh sach sinh vien trung tuyen");
            System.out.println("7. Thoát");
            System.out.print("\nNhap lua chon tu 1 den 7: ");
            int option = scanner.nextInt();
            if(option == 7) break;
            switch(option)
            {
                case 1:
                    printListGoodStudent();
                    break;
                case 2:
                    printListNormalStudent();
                    break;
                case 3:
                    addGoodStudent(goodStudentList);
                    break;
                case 4:
                    addNormalStudent(normalStudentList);
                    break;
                case 5:
                    recruitStudent();
                    break;
                case 6:
                    printRecruitStudentList();
                    break;
                default:
                    System.out.println("Khong ton tai lua chon nay");
            }
        }
    }
}