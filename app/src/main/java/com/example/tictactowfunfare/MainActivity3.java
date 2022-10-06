package com.example.tictactowfunfare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    // 0 : zero 1:cross 2:empty

    int[] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    //
    int[][] winningPosition = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    int activeplayer = 0;
    boolean gameActive = true;
    public void dropin(View view){
        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if(gamestate[tappedCounter] == 2  && gameActive) {


            gamestate[tappedCounter] = activeplayer;

            counter.setTranslationY(-1500);
            if (activeplayer == 0) {

                counter.setImageResource(R.drawable.ze);

                activeplayer = 1;
            } else {
                counter.setImageResource(R.drawable.cr);

                activeplayer = 0;
            }
            counter.animate().translationYBy(1500).rotation(3600).setDuration(500);

            for (int[] winningPosition : winningPosition) {
                if (gamestate[winningPosition[0]] == gamestate[winningPosition[1]] && gamestate[winningPosition[1]] == gamestate[winningPosition[2]] && gamestate[winningPosition[0]] != 2) {
                    //some has won
                    gameActive = false;
                    String winner = "";
                    if (activeplayer == 1) {
                        winner = "player 1";
                    } else {
                        winner = "player 2";
                    }
                    Button PlayAgainButton = (Button) findViewById(R.id.PlayAgainButton);
                    TextView WinnerTextView = (TextView) findViewById(R.id.WinnerTextView);
                    WinnerTextView.setText(winner + " has won");
                    PlayAgainButton.setVisibility(View.VISIBLE);
                    WinnerTextView.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void PlayAgain(View view){

        Button PlayAgainButton = (Button) findViewById(R.id.PlayAgainButton);
        TextView WinnerTextView = (TextView) findViewById(R.id.WinnerTextView);

        PlayAgainButton.setVisibility(View.INVISIBLE);
        WinnerTextView.setVisibility(View.INVISIBLE);

        GridLayout gridLayout23 =(GridLayout) findViewById(R.id.gridLayout);

        for(int k=0; k<gridLayout23.getChildCount();k++){
            ImageView counter = (ImageView) gridLayout23.getChildAt(k);
            counter.setImageDrawable(null);
        }

        for(int i = 0;i<gamestate.length;i++){

            gamestate[i] = 2;

        }
        activeplayer = 0;
        gameActive = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}