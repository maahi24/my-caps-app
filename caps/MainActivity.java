package com.example.caps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    private game g;
    private String question;
    private String answer;
    private int score;
    private int qNum;
    private String resultS = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        g = new game();
        question = "";
        answer = "";
        score = 0;
        qNum = 1;
        ask();
    }
    private void ask(){
        TextView ques = (TextView) findViewById(R.id.question);
        String qu = g.qa();
        String lines[] = qu.split("\\n");
        question = lines[0];
        answer = lines[1];
        ques.setText(question);
    }

    public void onDone(View v){
        TextView ques = (TextView) findViewById(R.id.question);
        TextView qN = (TextView) findViewById(R.id.qNUM);
        TextView result = (TextView) findViewById(R.id.log);
        TextView score0 = (TextView) findViewById(R.id.score);
        String ansS;

        if(qNum == 9){
            qN.setText("Game Over!");
            Button button1 = (Button) findViewById(R.id.button2);
            button1.setEnabled(false);
            button1.setClickable(false);
            finish();
        }
        else{
            ansS = ((EditText) findViewById(R.id.answer)).getText().toString();
            resultS = "\nQ# " + qNum + ":" + question + "\n Your Answer:" + ansS + "\nCorrect Answer: " + answer + "\n" + resultS;
            qNum++;
            qN.setText("Q# " + qNum);
            result.setText(resultS);
            if(ansS.equalsIgnoreCase(answer)){
                score++;
                score0.setText("SCORE = "+ score);
            }
       ask();


        }
        ((EditText) findViewById(R.id.answer)).setText("");

    }


}