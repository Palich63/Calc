import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();

        System.out.println("Введите в одну строку математическую операцию для вычисления");
        System.out.println("Возможные значения от 1 до 10 или I до Х");
        calculate.peremennye();
        System.out.println(calculate.result);
    }
}
    class Calculate {
        int result;
        int romTrue = 0;
        String[] sim = {"+", "-", "/", "*"};
        int x = 0, y = 0;
        int simInd;
        String rom;

        void peremennye() {
            Scanner vvod = new Scanner(System.in);
            String perem1;
            String[] perem2;
            perem1 = vvod.nextLine(); //Ввод
            perem1 = perem1.trim();  //Убрать пробел и создать исключение если ни одного из символов нет
            obrabotca(perem1);

            String[] sim1 = {"\\+", "-", "/", "\\*"};
            for (int i = 0; i < sim.length; i++) {
                if (perem1.contains(sim[i])) {
                    simInd = i;
                }
            }
            perem2 = perem1.split(sim1[simInd]);
            for (int i = 0; i <= 1; i++) {
                perem2[i] = perem2[i].trim();
            }
            //
            if (romTrue == 1) {
                x = romToInt(perem2[0]);
                y = romToInt(perem2[1]);
                result = calc(x, y);
                rom = intToRom(result);
                if (result < 1) {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        System.out.println("в римской системе нет отрицательных чисел");
                        System.exit(0);
                    }
                }else{
                    System.out.println(rom);
                    System.exit(0);

                }

            } else {
                if (Integer.parseInt(perem2[0]) > 10 && Integer.parseInt(perem2[1]) > 10 && Integer.parseInt(perem2[1]) < 1 && Integer.parseInt(perem2[1]) < 1) {
                    System.out.println("Значение не входит в требуемый диапазон");

                } else {
                    x = Integer.parseInt(perem2[0]);
                    y = Integer.parseInt(perem2[1]);
                    result = calc(x, y);

                }
            }
        }

        int obrabotca(String s) {
            String arab = "1_2_3_4_5_6_7_8_9_0";
            String rom = "I_II_III_IV_V_VI_VII_VIII_IX_X";
            String per = "+_-_*_/";
            int k = 0, a = 0, p = 0;
            for (int i = 0; i < s.length(); i++) {
                if (arab.contains(s.substring(i, i + 1))) {
                    k = k + 1;
                }
                if (rom.contains(s.substring(i, i + 1))) {
                    a = a + 1;
                    romTrue = 1;
                }
                if (per.contains(s.substring(i, i + 1))) {
                    p = p + 1;
                }
            }
            if (k != 0 && a != 0) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("используются одновременно разные системы счисления");
                    System.exit(0);
                }
            }
            if (p > 1) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("формат математической операции не удовлетворяет заданию");
                    System.exit(0);
                }
            }
            if (p == 0) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("строка не является математической операцией");
                    System.exit(0);
                }
            }
            return romTrue;
        }

        public String intToRom (int res) {
            int[] num = {100,90,50,40,10,9,5,4,1};
            String[] str = {"C","XC","L","XL","X","IX","V","IV","I"};
            if (res < 1 || res > 100) return "";

            StringBuilder sb = new StringBuilder();
            for (int i=0; i<num.length && res>0; i++){
                while (res>=num[i]){
                    res -= num[i];
                    sb.append(str[i]);
                }
            }


            return sb.toString();
        }
        int getArabian(char rom) {
            if ('I' == rom) return 1;
            else if ('V' == rom) return 5;
            else if ('X' == rom) return 10;
            return 0;
        }

        int romToInt(String s) {

            int end = s.length() - 1;
            char[] arr = s.toCharArray();
            int arabian;
            int result = getArabian(arr[end]);
            for (int i = end - 1; i >= 0; i--) {
                arabian = getArabian(arr[i]);

                if (arabian < getArabian(arr[i + 1])) {
                    result -= arabian;
                } else {
                    result += arabian;
                }


            }
            return result;

        }

        int calc (int x, int y){
        switch(sim[simInd])
        {
            case "+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "/":
                result = x / y;
                break;
            case "*":
                result = x * y;
                break;
        }
            return result;
    }
    }

