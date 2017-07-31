package test;

import java.util.Scanner;

/**
 * Created by user on 15.11.2016.
 */
//Принимает с консоли ответы студента, преобразует в строку из цифр попадающих в диапазон ответов
public class In {
    private int cor;
    private String sOp = ""; //ответы студента

    public String getsOp() {
        return sOp;
    }

    public In(int cor) {
        this.cor = cor;

    }

    public void stOpt() {
        System.out.println("ВВедите варианты оветов через запятую");
        String sOpt = new Scanner(System.in).nextLine();
        for (int i = 0; i < sOpt.length(); i++)

            if (Character.isDigit(sOpt.charAt(i)) && (Character.getNumericValue(sOpt.charAt(i)) <= this.cor)) {
                sOp = sOp + sOpt.charAt(i);
            }
        //           else {
//                System.out.println("Ведите варианты оветов еще раз");
        //               i--;
        //           }
    }
}
