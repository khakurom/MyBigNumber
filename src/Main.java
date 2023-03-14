import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String stn1 = "";
        String stn2 = "";
        while (stn1.isEmpty()) {
            System.out.println("Nhap vao chuoi 1:");
            stn1 = sc.nextLine();
        }
        while (stn2.isEmpty()) {
            System.out.println("Nhap vao chuoi 2:");
            stn2 = sc.nextLine();
        }
        sum(stn1, stn2);



    }

    public static void sum(String stn1, String stn2) {
        int[] index1 = null;
        int[] index2 = null;
        int n1 = 0;
        int n2 = 0;
        String chuoi1 = stn1;
        String chuoi2 = stn2;
        if (stn1.length() >= stn2.length()) {
            index1 = new int[stn1.length()];
            index2 = new int[stn2.length()];
            n1 = stn1.length();
            n2 = stn2.length();
        } else {
            index1 = new int[stn2.length()];
            index2 = new int[stn1.length()];
            n1 = stn2.length();
            n2 = stn1.length();
            chuoi1 = stn2;
            chuoi2 = stn1;
        }

        Stack<String> resultArray = new Stack<>();

        for (int i = n1 - 1; i >= 0; i--) {
            int letter = Integer.parseInt(String.valueOf(chuoi1.charAt(i)));
            index1[i] = letter;
        }
        for (int i = n2 - 1; i >= 0; i--) {
            int letter = Integer.parseInt(String.valueOf(chuoi2.charAt(i)));
            index2[i] = letter;
        }
        int duration = index1.length - index2.length;
        int soNho = 0;
        for (int i = index1.length - 1; i >= 0; i--) {
            int sum = 0;
            int length2 = i - duration;
            if (length2 >= 0) {
                sum = index1[i] + index2[length2] + soNho;
            } else {
                sum = index1[i] + soNho;
            }
            if (sum >= 10) {
                int soDu = sum % 10;
                soNho = sum / 10;
                resultArray.push(String.valueOf(soDu));
            } else {
                resultArray.push(String.valueOf(sum));
            }


        }

        int n = resultArray.size();
        System.out.println("ket qua la:");
        for (int i = 0; i < n; i++) {
            System.out.print(resultArray.pop());
        }

    }
}
