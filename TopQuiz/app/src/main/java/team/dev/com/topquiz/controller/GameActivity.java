package team.dev.com.topquiz.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import team.dev.com.topquiz.R;
import team.dev.com.topquiz.model.Question;
import team.dev.com.topquiz.model.QuestionBank;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView questionText;
    private Button answer1Btn;
    private Button answer2Btn;
    private Button answer3Btn;
    private Button answer4Btn;

    private QuestionBank questionBank;
    private Question mCurrentQuestion;

    private int mScore;
    private int mNumberOfQuestions;

    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";

    public TextView getQuestionText() {
        return questionText;
    }

    public void setQuestionText(TextView questionText) {
        this.questionText = questionText;
    }

    public Button getAnswer1Btn() {
        return answer1Btn;
    }

    public void setAnswer1Btn(Button answer1Btn) {
        this.answer1Btn = answer1Btn;
    }

    public Button getAnswer2Btn() {
        return answer2Btn;
    }

    public void setAnswer2Btn(Button answer2Btn) {
        this.answer2Btn = answer2Btn;
    }

    public Button getAnswer3Btn() {
        return answer3Btn;
    }

    public void setAnswer3Btn(Button answer3Btn) {
        this.answer3Btn = answer3Btn;
    }

    public Button getAnswer4Btn() {
        return answer4Btn;
    }

    public void setAnswer4Btn(Button answer4Btn) {
        this.answer4Btn = answer4Btn;
    }

    public QuestionBank getQuestionBank() {
        return questionBank;
    }

    public void setQuestionBank(QuestionBank questionBank) {
        this.questionBank = questionBank;
    }

    public Question getmCurrentQuestion() {
        return mCurrentQuestion;
    }

    public void setmCurrentQuestion(Question mCurrentQuestion) {
        this.mCurrentQuestion = mCurrentQuestion;
    }

    public int getmNumberOfQuestions() {
        return mNumberOfQuestions;
    }

    public void setmNumberOfQuestions(int mNumberOfQuestions) {
        this.mNumberOfQuestions = mNumberOfQuestions;
    }

    public int getmScore() {
        return mScore;
    }

    public void setmScore(int mScore) {
        this.mScore = mScore;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        this.questionBank = generateQuestions();
        this.mScore = 0;
        this.mNumberOfQuestions = 4;

        this.questionText = (TextView) findViewById(R.id.activity_game_question_text); //R.id.identifiant_de_vue
        this.answer1Btn = (Button) findViewById(R.id.activity_game_answer1_btn);
        this.answer2Btn = (Button) findViewById(R.id.activity_game_answer2_btn);
        this.answer3Btn = (Button) findViewById(R.id.activity_game_answer3_btn);
        this.answer4Btn = (Button) findViewById(R.id.activity_game_answer4_btn);

        // Use the tag property to 'name' the buttons
        this.answer1Btn.setTag(0);
        this.answer2Btn.setTag(1);
        this.answer3Btn.setTag(2);
        this.answer4Btn.setTag(3);

        this.answer1Btn.setOnClickListener(this);
        this.answer2Btn.setOnClickListener(this);
        this.answer3Btn.setOnClickListener(this);
        this.answer4Btn.setOnClickListener(this);

        this.mCurrentQuestion = this.questionBank.getQuestion();
        displayQuestion(this.mCurrentQuestion);
    }

    private QuestionBank generateQuestions() {
        Question question1 = new Question("What is the name of the current french president?",
                Arrays.asList("François Hollande", "Emmanuel Macron", "Jacques Chirac", "François Mitterand"),
                1);

        Question question2 = new Question("How many countries are there in the European Union?",
                Arrays.asList("15", "24", "28", "32"),
                2);

        Question question3 = new Question("Who is the creator of the Android operating system?",
                Arrays.asList("Andy Rubin", "Steve Wozniak", "Jake Wharton", "Paul Smith"),
                0);

        Question question4 = new Question("When did the first man land on the moon?",
                Arrays.asList("1958", "1962", "1967", "1969"),
                3);

        Question question5 = new Question("What is the capital of Romania?",
                Arrays.asList("Bucarest", "Warsaw", "Budapest", "Berlin"),
                0);

        Question question6 = new Question("Who did the Mona Lisa paint?",
                Arrays.asList("Michelangelo", "Leonardo Da Vinci", "Raphael", "Carravagio"),
                1);

        Question question7 = new Question("In which city is the composer Frédéric Chopin buried?",
                Arrays.asList("Strasbourg", "Warsaw", "Paris", "Moscow"),
                2);

        Question question8 = new Question("What is the country top-level domain of Belgium?",
                Arrays.asList(".bg", ".bm", ".bl", ".be"),
                3);

        Question question9 = new Question("What is the house number of The Simpsons?",
                Arrays.asList("42", "101", "666", "742"),
                3);

        return new QuestionBank(Arrays.asList(question1, question2, question3, question4, question5, question6, question7, question8, question9));
    }

    private void displayQuestion(final Question question) {
        questionText.setText(question.getmQuestion());
        answer1Btn.setText(question.getmChoiceList().get(0));
        answer2Btn.setText(question.getmChoiceList().get(1));
        answer3Btn.setText(question.getmChoiceList().get(2));
        answer4Btn.setText(question.getmChoiceList().get(3));
    }

    @Override
    public void onClick(View v) {
        int responseIndex = (int) v.getTag();

        if (responseIndex == this.mCurrentQuestion.getmAnswerIndex()) {
            this.mScore++;
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
        }

        if (--mNumberOfQuestions == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Well done!")
                    .setMessage("Your score is " + this.mScore)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // End the activity
                            Intent intent = new Intent();
                            intent.putExtra(BUNDLE_EXTRA_SCORE, mScore);
                            setResult(RESULT_OK, intent);
                            finish();
                        }
                    })
                    .create()
                    .show();
        } else {
            this.mCurrentQuestion = this.questionBank.getQuestion();
            displayQuestion(this.mCurrentQuestion);
        }
    }
}
