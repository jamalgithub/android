package team.dev.com.topquiz.model;

import java.util.List;

public class Question {
    private String mQuestion;
    private List<String> mChoiceList;
    private int mAnswerIndex;

    public Question() {
    }

    public Question(String mQuestion, List<String> mChoiceList, int mAnswerIndex) {
        this.setmQuestion(mQuestion);
        this.setmChoiceList(mChoiceList);
        this.setmAnswerIndex(mAnswerIndex);
    }

    public String getmQuestion() {
        return mQuestion;
    }

    public void setmQuestion(String mQuestion) {
        this.mQuestion = mQuestion;
    }

    public List<String> getmChoiceList() {
        return mChoiceList;
    }

    public void setmChoiceList(List<String> mChoiceList) {
        if(mChoiceList == null)
            throw new IllegalArgumentException("Question Choice List can't be null");

        this.mChoiceList = mChoiceList;
    }

    public int getmAnswerIndex() {
        return mAnswerIndex;
    }

    public void setmAnswerIndex(int mAnswerIndex) {
        if(mAnswerIndex < 0 || mAnswerIndex >= mChoiceList.size())
            throw new IllegalArgumentException("Answer index is out of bound");

        this.mAnswerIndex = mAnswerIndex;
    }

    @Override
    public String toString() {
        return "Question{" +
                "mQuestion='" + mQuestion + '\'' +
                ", mChoiceList=" + mChoiceList +
                ", mAnswerIndex=" + mAnswerIndex +
                '}';
    }
}
