package team.dev.com.topquiz.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import team.dev.com.topquiz.R;
import team.dev.com.topquiz.model.User;

public class MainActivity extends AppCompatActivity {

    private TextView mGreetingText;
    private EditText mNameInput;
    private Button mPlayButton;
    private User mUser;

    public TextView getmGreetingText() {
        return mGreetingText;
    }

    public void setmGreetingText(TextView mGreetingText) {
        this.mGreetingText = mGreetingText;
    }

    public EditText getmNameInput() {
        return mNameInput;
    }

    public void setmNameInput(EditText mNameInput) {
        this.mNameInput = mNameInput;
    }

    public Button getmPlayButton() {
        return mPlayButton;
    }

    public void setmPlayButton(Button mPlayButton) {
        this.mPlayButton = mPlayButton;
    }

    public User getmUser() {
        return mUser;
    }

    public void setmUser(User mUser) {
        this.mUser = mUser;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUser = new User();

        mGreetingText = (TextView) findViewById(R.id.activity_main_greeting_txt);
        mNameInput = (EditText) findViewById(R.id.activity_main_name_input);
        mPlayButton = (Button) findViewById(R.id.activity_main_play_btn);

        mPlayButton.setEnabled(false);

        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayButton.setEnabled(s.toString().length() > 2);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameActivity  = new Intent(MainActivity.this, GameActivity.class);

                mUser.setmFirstName(mNameInput.getText().toString());

                startActivity(gameActivity );
            }
        });
    }
}
