package test;

/**
 * Created by user on 18.11.2016.
 */
//анализ ответов студента, формирование оценки
public class Student {
    private boolean [] correct;
    private String sOpt;
    private static int rezult;

    public Student(boolean[] correct, String sOpt) {
        this.correct = correct;
        this.sOpt = sOpt;

    }

    public Student() {
        rezult=0;
    }

    public int getRezult() {
        return rezult;
    }

    public void analysis(){
        int t=0,f=0,st=0,sf=0;
        for(int i=0;i<this.correct.length;i++){
            if(this.correct[i]){
                t++;
            }
            else f++;

        }
        //проверка верности ответа студента
        for(int i=0;i<this.sOpt.length();i++){

                if(correct[(Character.getNumericValue(this.sOpt.charAt(i)))-1]){
                    st++;
                }
                else sf++;

        }
    if(sf==0 && st>0) rezult++;
    }
}
