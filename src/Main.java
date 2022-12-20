import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();

        System.out.println("Введите в одну строку математическую операцию для вычисления");
        System.out.println("Возможные значения от 1 до 10 или I до Х");
        calculate.vvodOper();
        calculate.obrabotca(calculate.perem1);
        calculate.peremennye(calculate.perem1);
        for (int elem: calculate.peremenn){
            System.out.println(elem);
        }
    }
}
    class Calculate{
    int[] peremenn = new int[2];
    String perem1;

    int result;
    String stroka;
        Scanner vvod = new Scanner(System.in);
        String vvodOper() {
            perem1 = vvod.nextLine(); //Ввод
            perem1 = perem1.trim();
            return perem1;
        }
    int[] peremennye(String perem1){
            char sim = ' '; //Убрать пробел и создать исключение если ни одного из сиволов нет
            String[] perem2 = new String[2];
            if (perem1.contains("+")) {           // сложить
                sim = '+';
                perem2 = perem1.split("\\+");
                for (int i = 0; i <= 1; i++) {
                    perem2[i] = perem2[i].trim();
                }
            }
            if (perem1.contains("-")) {               // отнять
                sim = '-';
                perem2 = perem1.split("-");
                for (int i = 0; i <= 1; i++) {
                    perem2[i] = perem2[i].trim();
                }
            }
            if (perem1.contains("/")) {               // разделить
                sim = '/';
                perem2 = perem1.split("/");
                for (int i = 0; i <= 1; i++) {
                    perem2[i] = perem2[i].trim();
                }
            }
            if (perem1.contains("*")) {               // умножить
                sim = '*';
                perem2 = perem1.split("\\*");
                for (int i = 0; i <= 1; i++) {
                    perem2[i] = perem2[i].trim();
                }
            }
            int x = Integer.parseInt(perem2[0]);
            int y = Integer.parseInt(perem2[1]);
            if (x>=1 && x<=10 && y>=1 && y<=10) {
                peremenn[0] = x;
                peremenn[1] = y;
            }
            return peremenn;
        }
    void obrabotca(String s){
         // String kiril[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        String kiril = "1_2_3_4_5_6_7_8_9_0";
            //String arab[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String arab = "I_II_III_IV_V_VI_VII_VIII_IX_X";
        String per = "+_-_*_/";
        int k = 0, a = 0, p = 0;
            for (int i=0; i<s.length(); i++) {
                if(kiril.contains(s.substring(i,i+1))){
                    k=k+1;
                }
                if(arab.contains(s.substring(i,i+1))){
                    a=a+1;
                }
                if(per.contains(s.substring(i,i+1))){
                    p=p+1;
                }
            }
        if (k!=0 && a!=0){
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("используются одновременно разные системы счисления");
                System.exit(0);
            }
        }
        if (p>1) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                System.exit(0);
            }
        }
        if (p==0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("строка не является математической операцией");
                System.exit(0);
            }
        }
    }
    }

