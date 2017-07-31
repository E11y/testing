package test;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 15.11.2016.
 */
//Класс для вывода вопросов и вариантов ответов, формирует и хранит массив правильных ответов
public class Out {
    private ArrayList<ArrayList<String>> ArrOp;
    private ArrayList<String> Question;
    private int i,j;
    private boolean [] correct;
    public Out(ArrayList<ArrayList<String>> ArrOp, ArrayList<String> Question) {
        this.ArrOp=ArrOp;
        this.Question=Question;
//       pr();
    }

    public boolean[] getCorrect() {
        return correct;
    }

    public void pr(){
        i=rnd();
        correct = new boolean [this.ArrOp.get(i).size()];
        System.out.println((i+1)+")"+this.Question.get(i)+"\n");
        for(j=0;j<this.ArrOp.get(i).size();j++){
            if (this.ArrOp.get(i).get(j).charAt(0)=='+'){
                System.out.println(toString());
                correct[j]=true;
            }

            else {
                correct[j] = false;
                System.out.println(toString());
            }
        }

    }

    @Override
    public String toString() {
        return String.format("%d)%s", (j+1),this.ArrOp.get(i).get(j).substring(1)) ;

    }
    private int rnd(){
        Random rnd = new Random();
        return rnd.nextInt(this.Question.size());
    }
}
