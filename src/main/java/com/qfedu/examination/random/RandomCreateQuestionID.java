package com.qfedu.examination.random;

import com.qfedu.examination.dao.QuestionDao;
import com.qfedu.examination.entity.ChoiceQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

public class RandomCreateQuestionID {


    public static int[] Randoms(int number,int count) {

        Random rand = new Random();
        int nu[] = new int[count];
        boolean[] bool = new boolean[number + 1+1];
        int randint = 0;
        for (int i = 0; i < count; i++) {
            do {
                randint = rand.nextInt(number);
            } while (bool[randint]);
            bool[randint] = true;
            nu[i] = randint;
        }
        return nu;
    }





/*
    @Autowired
    QuestionDao questionDao;
    @Autowired
    RandomCreateQuestionID createQuestionID;


    public int[] randomChoiceId(int choiceCount){
        int[] result = new int[choiceCount];
       int count = questionDao.queryChoiceCount();

      for (int i = 0;i<choiceCount;i++){
          int a = (int) (Math.random()*(count+1) +1);
          result[i] = a;
      }
      return result;
    }


    public int[] randomJudge(int judgeCount){
        int[] result = new int[judgeCount];
        int count = questionDao.queryJudgeCount();

        for (int i = 0;i<judgeCount;i++){
            int a = (int) (Math.random()*(count+1) +1);
            result[i] = a;
        }
        return result;
    }


    public int[] randomShort(int shortCount){
        int[] result = new int[shortCount];
        int count = questionDao.queryShortCount();

        for (int i = 0;i<shortCount;i++){
            int a = (int) (Math.random()*(count+1) +1);
            result[i] = a;
        }
        return result;
    }

    public ChoiceQuestion forChoice(int choiceID){
        ChoiceQuestion choiceQuestion = questionDao.choiceListByID(choiceID);
        if (choiceQuestion==null){
            int ran = (int) (Math.random()*8+1);
            choiceQuestion  = createQuestionID.forChoice(choiceID + ran);
            if (choiceQuestion!=null){
                return choiceQuestion;
            }
        }
        return choiceQuestion;
    }

*/



}
