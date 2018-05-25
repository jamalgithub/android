package team.dev.com.topquiz.model;

import java.util.Collections;
import java.util.List;

public class QuestionBank {

    private List<Question> mQuestionList;
    private int mNextQuestionIndex;

    public QuestionBank(List<Question> questionList) {
        this.mQuestionList = questionList;

        // Shuffle the question list before storing it
        Collections.shuffle(mQuestionList);

        mNextQuestionIndex = 0;
    }

    public Question getQuestion() {
        // Ensure we loop over the questions
        if(mNextQuestionIndex == mQuestionList.size())
            mNextQuestionIndex = 0;

        return mQuestionList.get(mNextQuestionIndex++);
    }
}
