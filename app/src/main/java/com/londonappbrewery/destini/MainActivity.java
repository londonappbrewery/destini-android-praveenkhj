package com.londonappbrewery.destini;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.os.Build.VERSION_CODES.N;

public class MainActivity extends AppCompatActivity {


    TextView storyTextView;
    Button topButton;
    Button bottomButton;
    int mIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null){
            mIndex = savedInstanceState.getInt("storyIndex");
        }
        else {
            mIndex = 1;
        }

        storyTextView = (TextView) findViewById(R.id.storyTextView);
        topButton = (Button) findViewById(R.id.buttonTop);
        bottomButton = (Button) findViewById(R.id.buttonBottom);
        updateStoryBoard(mIndex);

        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mIndex == 1) {
                    mIndex = 3;
                }
                else if(mIndex == 3) {
                    mIndex = 6;
                }
                else if(mIndex == 2) {
                    mIndex = 3;
                }
                updateStoryBoard(mIndex);
            }
        });

        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mIndex == 1) {
                    mIndex = 2;
                }
                else if(mIndex == 2) {
                    mIndex = 4;
                }
                else if(mIndex == 3) {
                    mIndex = 5;
                }
                updateStoryBoard(mIndex);
            }
        });

    }

    private void updateStoryBoard(int storyID) {
        switch(storyID)
        {
            case 1:
                storyTextView.setText(R.string.T1_Story);
                topButton.setText(R.string.T1_Ans1);
                bottomButton.setText(R.string.T1_Ans2);
                break;

            case 2:
                storyTextView.setText(R.string.T2_Story);
                topButton.setText(R.string.T2_Ans1);
                bottomButton.setText(R.string.T2_Ans2);
                break;

            case 3:
                storyTextView.setText(R.string.T3_Story);
                topButton.setText(R.string.T3_Ans1);
                bottomButton.setText(R.string.T3_Ans2);
                break;
            case 4:
                storyTextView.setText(R.string.T4_End);
                topButton.setVisibility(View.GONE);
                bottomButton.setVisibility(View.GONE);
                break;
            case 5:
                storyTextView.setText(R.string.T5_End);
                topButton.setVisibility(View.GONE);
                bottomButton.setVisibility(View.GONE);
                break;
            case 6:
                storyTextView.setText(R.string.T6_End);
                topButton.setVisibility(View.GONE);
                bottomButton.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState)  {
        super.onSaveInstanceState(outState);
        outState.putInt("storyIndex",mIndex);
    }
}