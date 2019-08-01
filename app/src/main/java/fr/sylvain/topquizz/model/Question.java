package fr.sylvain.topquizz.model;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private String mAsk;
    private List<String> mChoiceList = new ArrayList<>();
    private int mAnswerIndex;

    public Question(String question, List<String> choiceList, int answerIndex) {
        mAsk = question;
        mChoiceList = choiceList;
        mAnswerIndex = answerIndex;
    }

    public String getQuestion() {
        return mAsk;
    }

    public List<String> getChoiceList() {
        return mChoiceList;
    }

    public int getAnswerIndex() {
        return mAnswerIndex;
    }
}
