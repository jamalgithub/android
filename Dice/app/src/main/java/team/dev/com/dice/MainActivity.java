package team.dev.com.dice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button6;
    private Button button20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.button6 = findViewById(R.id.button6);
        this.button6.setTag(6);
        this.button20 = findViewById(R.id.button20);
        this.button20.setTag(20);

        this.button6.setOnClickListener(this);
        this.button20.setOnClickListener(this);
    }

    public Button getButton6() {
        return button6;
    }

    public void setButton6(Button button6) {
        this.button6 = button6;
    }

    public Button getButton20() {
        return this.button20;
    }

    public void setButton20(Button button20) {
        this.button20 = button20;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, DiceActivity.class);
        int buttonTag = (int) v.getTag();

        Log.i("DICE_TAG", String.valueOf(buttonTag));
        intent.putExtra("max", (int) v.getTag());
        startActivity(intent);
    }
}
