package team.dev.com.dice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class DiceActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textTitle;
    private TextView textResult;
    private Button buttonRoll;
    private int max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        textTitle = findViewById(R.id.textTitle);
        textResult = findViewById(R.id.textResult);
        buttonRoll = findViewById(R.id.buttonRoll);

        max = getIntent().getIntExtra("max", 0);

        textTitle.setText(getString(R.string.sided_dice_txt, this.max));
        textResult.setText("");
        buttonRoll.setOnClickListener(this);
    }

    public TextView getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(TextView textTitle) {
        this.textTitle = textTitle;
    }

    public TextView getTextResult() {
        return textResult;
    }

    public void setTextResult(TextView textResult) {
        this.textResult = textResult;
    }

    public Button getButtonRoll() {
        return buttonRoll;
    }

    public void setButtonRoll(Button buttonRoll) {
        this.buttonRoll = buttonRoll;
    }

    @Override
    public void onClick(View v) {
        Random random = new Random();
        int result = random.nextInt(this.max)+1;
        textResult.setText(String.valueOf(result));
    }
}
