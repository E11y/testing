package test;

//import java.io.*;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Parser arr = new Parser("c:\\temp\\test.txt");//путь к файлу передается в парсер
        Out out = new Out(arr.getArrOp(), arr.getQuestion()); // ывод  вопросов ходные данные массив вопросов и двумерный массив ответов
        Student st = new Student(); //обработка
        for (int i = 1; i <= 5; i++) {
            out.pr();
            In in = new In(out.getCorrect().length);                //прием ответов
            in.stOpt();
            st = new Student(out.getCorrect(), in.getsOp()); //обработка
            st.analysis();
        }
        System.out.println(st.getRezult());
    }
}

