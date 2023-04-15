import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        System.out.println("������, ���������!");
        Scanner scan = new Scanner(System.in); // �������� ������ ��� ����� ������
        System.out.println("����� �������� � ������� �� 1 �� 10 ��� �� I �� X � ������� a + b, a - b, a * b, a / b: ");
        String vvod = scan.nextLine(); // �������� �� ������������ ������
        System.out.println(calc(vvod));
    }

    public static String calc(String input) {
        String value = input.replaceAll("[-+/*^]"," $0 ").replace("  ", " ").trim(); //������� �������, ���� ����� �� ������ ������������
        String[] massive = value.split(" "); //���� ������ �� ������ �� �������
       try{ String a = massive[0];
        String symbol = massive[1];
        String b = massive[2];
        if (massive.length>3) {
            System.out.println("������ �������������� �������� �� ������������� ������� - ��� �������� � ���� �������� (+, -, /, *)");
            return "";
            } else {
               try {
                   if(calculating(a, b, symbol)<-10000){return "";}
                   else{
                   String result = Integer.toString(calculating(a, b, symbol));
                   return result;}
               } catch (NumberFormatException nfe) {
                   if(romanToNumber(a.toUpperCase()) > 0 && romanToNumber(b.toUpperCase()) > 0) {
                       int x = romanToNumber(a.toUpperCase());
                       int y = romanToNumber(b.toUpperCase());
                       String c = Integer.toString(x);
                       String d = Integer.toString(y);
                       if (calculating(c, d, symbol) < -10000) {
                           return "";
                       } else if (calculating(c, d, symbol) < 0){return "� ������� ������� ��� ������������� �����";}
                       else {
                           String resultRoman = convertNumToRoman(calculating(c, d, symbol));
                           return resultRoman;
                       }
                   }
                   else if ((romanToNumber(a.toUpperCase()) < 0 && romanToNumber(b.toUpperCase()) > 0) || (romanToNumber(a.toUpperCase()) > 0 && romanToNumber(b.toUpperCase()) < 0)){
                       System.out.println("������������ ������������ ������ ������� ���������");
                       return "";
                   }
                   else {
                           System.out.println("������� ������� �����");
                           return "";
                   }
               }
           }
       }
       catch (ArrayIndexOutOfBoundsException e){
           System.out.println("������ �� �������� �������������� ���������");
           return "";
       }
    }

    private static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }

    private static int romanToNumber (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("�������� ������ ������");
        }
        return -1;
    }

    private static int calculating (String a, String b, String symbol){
        int x = Integer.parseInt(a.trim());
        int y = Integer.parseInt(b.trim());
        if (x < 1 || x > 10 || y < 0 || y > 10) {
            System.out.println("����� ��� ���������");
            return -11000;
        }
        if (symbol.equals("*")) {
            int s = x * y;
            return s;
        } else if (symbol.equals("/")) {
            try {
                int s = x / y;
                return s;
            } catch (ArithmeticException | InputMismatchException e) {
                System.out.println("������ �� 0 ������");
                return -11000;
            }
        } else if (symbol.equals("+")) {
            int s = x + y;
            return s;
        } else if (symbol.equals("-")) {
            int s = x - y;
            return s;
        } else {
            System.out.println("�������� ��������");
            return -11000;}
    }
}