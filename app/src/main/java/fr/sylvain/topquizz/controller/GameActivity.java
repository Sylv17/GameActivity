package fr.sylvain.topquizz.controller;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.sylvain.topquizz.R;
import fr.sylvain.topquizz.model.Question;
import fr.sylvain.topquizz.model.QuestionBank;

public class GameActivity extends AppCompatActivity {

    private TextView mQuestion;
    private Button mAnswer1;
    private Button mAnswer2;
    private Button mAnswer3;
    private Button mAnswer4;

    private QuestionBank mQuestionBank;
    private Question mAsk;

    private QuestionBank generateQuestions() {
        QuestionBank qb = new QuestionBank(new ArrayList<Question>());

        Question q = new Question("De quelle couleur est le ciel ?", new ArrayList<String>(), 0);
        q.getChoiceList().add("bleu");
        q.getChoiceList().add("rouge");
        q.getChoiceList().add("vert");
        q.getChoiceList().add("violet");

        qb.getQuestionList().add(q);

        Question q1 = new Question("De quelle couleur est la terre ?", new ArrayList<String>(), 2);
        q1.getChoiceList().add("rouge");
        q1.getChoiceList().add("bleu");
        q1.getChoiceList().add("marron");
        q1.getChoiceList().add("noir");

        qb.getQuestionList().add(q1);

        Question q2 = new Question("De quelle couleur est l'herbe ?", new ArrayList<String>(), 1);
        q2.getChoiceList().add("jaune");
        q2.getChoiceList().add("vert");
        q2.getChoiceList().add("noir");
        q2.getChoiceList().add("orange");

        qb.getQuestionList().add(q2);

        return qb;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionBank = this.generateQuestions();

        mQuestion = findViewById(R.id.text_view_txt);
        mAnswer1 = findViewById(R.id.game_button1);
        mAnswer2 = findViewById(R.id.game_button2);
        mAnswer3 = findViewById(R.id.game_button3);
        mAnswer4 = findViewById(R.id.game_button4);

        mAnswer1.setTag(0);
        mAnswer2.setTag(1);
        mAnswer3.setTag(2);
        mAnswer4.setTag(3);

        mAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });
        mAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });
        mAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });
        mAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });

        mAsk = mQuestionBank.getQuestion();
        this.displayQuestion(mAsk);
        Toast.makeText(GameActivity.this, "Correct", Toast.LENGTH_SHORT);
    }


    private void displayQuestion(final Question question) {
        mQuestion.setText(question.getQuestion());
        mAnswer1.setText(question.getChoiceList().get(0));
        mAnswer2.setText(question.getChoiceList().get(1));
        mAnswer3.setText(question.getChoiceList().get(2));
        mAnswer4.setText(question.getChoiceList().get(3));
    }

    private void onButtonClick(View v) {
        int responseIndex = (int) v.getTag();

        Log.i("SYLVAIN", (responseIndex == mAsk.getAnswerIndex())+ "");

        if (responseIndex == mAsk.getAnswerIndex()) {
            Toast.makeText(GameActivity.this, "Correct", Toast.LENGTH_SHORT);
        } else {
            Toast.makeText(GameActivity.this, "Wrong answer!", Toast.LENGTH_SHORT);
        }
    }
}