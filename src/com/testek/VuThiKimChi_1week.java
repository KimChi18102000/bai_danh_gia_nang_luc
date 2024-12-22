package com.testek;

import java.util.*;

public class VuThiKimChi_1week {
    public static void main(String[] args) {
        VuThiKimChi_1week vc = new VuThiKimChi_1week();
        vc.odd_evenList();
        vc.primeList();
        vc.fibonacciList();
        vc.maxNumber();
        vc.sumOfArr();
        vc.sumEvenNum();
        vc.sortArr1();
        vc.sortArr2();
        vc.checkISBN();
        vc.duplicateChar1();
        vc.duplicateChar2();
        vc.secondDegreeEquation();

    }

    List<Integer> arr = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    //CAU 1: Nhap vao cac so tu 1 den N va in ra KQ:
    //1 + 2.Danh sach so le, so chan
    public void odd_evenList() {
        System.out.println("-------CAU 1: 1 + 2. IN RA DANH SÁCH SO CHAN, LE-------");
        System.out.print("Nhap vao so phan tu N: ");
        int n = sc.nextInt();
        List<Integer> arrOdd = new ArrayList<>();
        List<Integer> arrEven = new ArrayList<>();

        if (n <= 1) {
            System.out.println("So n = " + n + " khong hop le");
        } else {
            for (int i = 1; i <= n; i++) {
                arr.add(i);
                if (arr.get(i - 1) % 2 != 0) {
                    arrOdd.add(i);
                } else {
                    arrEven.add(i);
                }
            }
            System.out.println("Danh sach so le: " + arrOdd);
            System.out.println("Danh sach so chan: " + arrEven);
        }
    }

    //3. In ra day so nguyen to
    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void primeList() {
        System.out.println("\n-------CAU 1: 3. IN RA DAY SO NGUYEN TO CO TRONG N-------");
        System.out.print("Nhap vao so N: ");
        int n = sc.nextInt();
        List<Integer> arrPrime = new ArrayList<>();

        if (n <= 1) {
            System.out.println("So n = " + n + " khong hop le");
        } else {
            for (int i = 1; i <= n; i++) {
                arr.add(i);
                if (isPrime(arr.get(i - 1))) {
                    arrPrime.add(i);
                }
            }
            System.out.println("Danh sach so nguyen to: " + arrPrime);
        }
    }

    //4. In ra day so fibonacci
    //1 1 2 3 5 8
    public void fibonacciList() {
        System.out.println("\n-------CAU 1: 4. IN RA DAY SO FIBONACCI CO TRONG N-------");
        System.out.print("Nhap vao so N: ");
        int n = sc.nextInt();
        List<Integer> arrFibonacci = new ArrayList<>();
        if (n <= 1) {
            System.out.println("So n = " + n + " khong hop le");
        } else {
            if (n == 2) {
                arrFibonacci.add(1);
                arrFibonacci.add(2);
            } else {
                arrFibonacci.add(1);
                arrFibonacci.add(2);
                int fibNext = 0;
                for (int i = 3; i <= n; i++) {
                    fibNext = arrFibonacci.get(i - 2 - 1) + arrFibonacci.get(i - 1 - 1);
                    arrFibonacci.add(fibNext);
                }
            }
        }
        System.out.println("Danh sach Fibonacci: " + arrFibonacci);
    }

    //CAU 2:
    int[] a = {2, 7, 6, 8, 9, 21, 34, 56, 32, 12, 37};

    //1.Tim phan tu lon nhat trong mang
    public void maxNumber() {
        System.out.println("\n-------CAU 2: 1.TIM PHAN TU LON NHAT TRONG MANG-------");
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        System.out.println("Phan tu lon nhat trong mang: " + max);
    }

    //2. Tinh tong so dau tien va so cuoi cung
    public void sumOfArr() {
        System.out.println("\n-------CAU 2: 2.TONG SO DAU TIEN VA SO CUOI CUNG-------");
        int sum = 0;
        sum += a[0] + a[a.length - 1];
        System.out.println("Tong so dau tien va so cuoi cung: " + sum);
    }

    //3. Tong cac so chan trong mang
    public void sumEvenNum() {
        System.out.println("\n-------CAU 2: 3.TONG CAC SO CHAN TRONG MANG-------");
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                sum += a[i];
            }
        }
        System.out.println("Tong cac so chan trong mang: " + sum);
    }

    //4. Sap xep mang va in ra danh sach sau khi sap xep
    //CACH 1:
    public void sortArr1() {
        System.out.println("\n-------CAU 2: 4.SAP XEP MANG VA IN RA DANH SACH (CACH 1)-------");
        Arrays.sort(a);
        System.out.println("Mang sap xep tang dan: " + Arrays.toString(a));
    }

    //CACH 2:
    public void sortArr2() {
        System.out.println("\n-------CAU 2: 4.SAP XEP MANG VA IN RA DANH SACH (CACH 2)-------");
        for(int i = 0; i < a.length; i++) {
            for(int j = i + 1; j < a.length; j++) {
                if(a[i] > a[j]) {
                    int tempt = a[i];
                    a[i] = a[j];
                    a[j] = tempt;
                }
            }
//            System.out.println(a[i] + " ");
        }
        System.out.println("Mang sap xep tang dan: " + Arrays.toString(a));
    }

    //CAU 3: KIEM TRA 1 SO CO PHAI LA SO ISBN
    public void checkISBN() {
        System.out.println("\n-------CAU 3: KIEM TRA 1 SO CO PHAI LA SO ISBN-------");
        sc.nextLine();
        System.out.print("Nhap vao so ISBN: ");
        String ISBN = sc.nextLine();
        int n = ISBN.length();
        int sum = 0;
        if (n == 10){
            for (int i = n - 1; i >= 0; i--) {
                int multiplication = Character.getNumericValue(ISBN.charAt(i)) * (n - i);
                sum += multiplication;
            }
            if(sum % 11 == 0) {
                System.out.println(ISBN + " la so ISBN");
            }
            else {
                System.out.println(ISBN + " khong phai la so ISBN");
            }
        }
        else {
            System.out.println(ISBN + " khong phai so ISBN do khong chua 10 chu so");
        }
    }

    //CAU 4:
    //    Cach 1:
    public void duplicateChar1() {
        System.out.println("\n-------CAU 4: CACH 1. IN RA KY TU VÀ VI TRI CUA KY TU TRUNG LAP TRONG CHUOI-------");
        System.out.print("Nhap vao chuoi co tu 100 den 1000 ky tu: ");
        String str = sc.nextLine();
        int n = str.length();
        Map<Character, List<Integer>> map = new HashMap<>();
        if(n < 100 || n > 1000) {
            System.out.println("Ban can nhap chuoi co do dai trong khoang 100 den 1000 ky tu");
        }
        else {
            for(int i = 0; i < n; i++) {
                if(map.containsKey(str.charAt(i))){
                    continue;
                }
                List<Integer> indexes = new ArrayList<>();
//                map.put(str.charAt(i), indexes); //in ra ca ky tu khong bi trung lap
                indexes.add(i);
                for(int j = i + 1; j < n; j++) {
                    if(str.charAt(i) == str.charAt(j)) {
                        map.put(str.charAt(i), indexes);
                        indexes.add(j);
                    }
                }
            }
            System.out.println(map);
        }
    }

//    //    Cach 2:
//    public void duplicateChar2() {
//        String str = sc.nextLine();
//        int n = str.length();
//        Map<Character, List<Integer>> outPut = new HashMap<>();
////        if (n < 100 || n > 1000) {
////            System.out.println("Ban can nhap chuoi co do dai trong khoang 100 den 1000 ky tu");
////        } else {
//        for (int i = 0; i < n; i++) {
//            if (outPut.containsKey(str.charAt(i))) continue;
//            List<Integer> indexes = new ArrayList<>();
//            for (int j = i + 1; j < n; j++) {
//                if (str.charAt(i) == str.charAt(j)) {
//                    //if (!indexes.contains(i))
//                    indexes.add(i);
//                    indexes.add(j);
//                }
//            }
////            if (!indexes.isEmpty())
//                outPut.put(str.charAt(i), indexes);
//        }
//        System.out.println(outPut);
//    }

    //    Cach 2:
    public void duplicateChar2() {
        System.out.println("\n-------CAU 4: CACH 2. IN RA KY TU VÀ VI TRI CUA KY TU TRUNG LAP TRONG CHUOI-------");
        System.out.print("Nhap vao chuoi co tu 100 den 1000 ky tu: ");
        String str = sc.nextLine();
        int n = str.length();
        Map<Character, List<Integer>> map = new HashMap<>();
        if(n < 100 || n > 1000) {
            System.out.println("Ban can nhap chuoi co do dai trong khoang 100 den 1000 ky tu");
        }
        else {
            for(int i = 0; i < n; i++) {
                char character =  str.charAt(i);
                if (!map.containsKey(character)) { //nếu k có điều kiện này thì vị trí của ký tự sẽ bị ghi đè => Kết quả chỉ giữ lại vị trí cuối cùng của mỗi ký tự.
                    map.put(character, new ArrayList<>());
                    map.get(character).add(i);
                }
                else {
                    map.get(character).add(i);
                }
            }
            for(Map.Entry<Character, List<Integer>> entry : map.entrySet()){
                if(entry.getValue().size() > 1) {
                    System.out.println(entry.getKey() + ": " +entry.getValue());
                }
            }
        }
    }

    //CAU 5: Giai phuong trinh bac 2:
    public void secondDegreeEquation() {
        System.out.println("\n-------CAU 5: GIAI PHUONG TRINH BAC 2-------");
        //ax^2 + bx + c = 0;
        System.out.print("Nhap he so a: ");
        double a = sc.nextDouble();
        System.out.print("Nhap he so b: ");
        double b = sc.nextDouble();
        System.out.print("Nhap so c: ");
        double c = sc.nextDouble();
        double delta = Math.pow(b, 2) - (4 * a * c);

        if(a == 0) {
            System.out.println("Day khong phai la phuong trinh bac 2 (a phai khac 0)");
        }
        else {
            if(delta < 0) {
                System.out.println("Phuong trinh vo nghiem");
            }
            else if(delta == 0 && b == 0 && c == 0) {
                System.out.println("Phuong trinh co nghiem kep: x1 = x2 = " + Math.abs((-b) / (2 * a)));
            }
            else if(delta == 0) {
                System.out.println("Phuong trinh co nghiem kep: x1 = x2 = " + (-b) / (2 * a));
            }
            else {
                System.out.println("Phuong trinh co 2 nghiem phan biet: x1 = " + (-b + Math.sqrt(delta)) / (2 * a) + " va x2 = " + (-b - Math.sqrt(delta)) / (2 * a));
            }
        }
    }
}
