package test;

/**
 * Created by user on 09.11.2016.
 */
/*
Парсер файла с вопросами и ответами. Возвращает двумерный массив типа ArrayList.
В каждом элементе верхнего уровня находится одномерный массив с вопросом на 0й позиции, на 1й позиции должна быть ссылка на
 Картинку (пока не реализована в должной мере), на остальных позициях строки с ответами. + вначале строки соответствует верному
  ответу, - неверному
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Parser {
    private String st;

    public ArrayList<ArrayList<String>> getArrOp() {
        return arrOp;
    }

    public ArrayList<String> getQuestion() {
        return question;
    }

    private ArrayList<ArrayList<String>> arrOp;
    private ArrayList<String> question;

    public Parser(String st) {  //Конструктор, на входе строка, путь к файлу
        this.st = st;
        inArr();
    }


    private void /*ArrayList<ArrayList<String>>*/ inArr() {       //метод собственно парсер возвращает массив
        arrOp = new ArrayList<ArrayList<String>>();      //объявление двумерного массива переменной длинны c ответами
        question = new ArrayList<String>();             //объявление массива переменной длинны c вопросами
        //       ArrayList<Object> pars = new ArrayList<Object>();
//        pars. = {arrOp,question};
        try (                                                                                 //обработка исключений
                                                                                              FileInputStream fis = new FileInputStream(this.st);                         //работа с файлом
                                                                                              InputStreamReader isr = new InputStreamReader(fis, "Cp1251");               //и с кодировкой
                                                                                              BufferedReader br = new BufferedReader(isr);                                //
        ) {
            //чтение построчно
            String s = br.readLine();            //читаем первую строку
            int q = 0;
            while (s != null) {                            //цикл верхнего уровня, проверка на конец файла
                int f = 1;//флаг для второго цикла который будет заполнять нутренние массивы с вопросами
                int j = 0;

                ArrayList<String> row = new ArrayList<String>(); // инициализация второго измерения массива(строки)
                while (f == 1) {

                    if (s.charAt(0) == '?') { //проверяем первый символ в строке на наличия идентификатора вопроса(если верн то в следующей строке вопрос)
                        s = br.readLine();//читаем следующую строку
//                           j=0;                 //для вопроса определяет его место в массиве
                        question.add(q, s);
//                           row.add(0,Integer.toString(q));
//                           row.add(j,s);        //помещаем вопрос в массив на 0ю позицию
//                           row.add(1,"Вопрос без картинки");
                        f = 1;
                    } else if (s.charAt(0) == '+' || s.charAt(0) == '-') {//если в начале строк + или - то помещаем ответ на позицию старше 1


                        row.add(j, s);
                        j++;
                    }
//                       else if(s.charAt(0)=='@'){//если картинка то помещам ссылку на картинку на позицию 1
//                           j=1;
//                          row.add(j,s);
                    //                          j++;

//                       }
                    s = br.readLine();       //читаем следущюю строку
                    if (s != null/*br.ready()*/) {            //проверяем на конец файла(без проверки вылетало по исключению)
                        if (s.charAt(0) == '?') f = 0;   //проверяем на наличие вопроса, выставляем флаг для продолжения
                    } else break;          //вываливаемся если конец файла
                }
                arrOp.add(row);           //добавляем созданный массив с вопросом и ответами в элемент верхнего массива
                q++;
            }
            fis.close();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());                //вываливаемся в случае исключения
        }
//        return arrOp;
    }

}
