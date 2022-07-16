package com.example.question;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.net.Uri;
import java.util.ArrayList;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
   int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        EditText question =findViewById(R.id.question_et);
        Button btn_true=findViewById(R.id.question_btn_true);
        Button btn_false=findViewById(R.id.question_btn_false);
        Button btn_see_more= findViewById(R.id.question_btn_seemore);

        ArrayList<String>Question=new ArrayList<String>();
        Question.add("Spaces and commas are allowed in a variable name ?"); //false
        Question.add("continue keyword skip one iteration of loop ?"); //true
        Question.add("sizeof() is a function that returns the size of a variable ?"); //false

        int res[]={0,1,0};
        btn_false.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i<3){
                    if(res[i]==0){
                        i++;
                        Toast.makeText(getBaseContext(),"correct answer",Toast.LENGTH_LONG).show();
                    question.setText(Question.get(i));
                }

                else
                    Toast.makeText(getBaseContext(),"wrong answer.. Try agin",Toast.LENGTH_LONG).show();
            }
            }
        });
        btn_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i<3){
                    if(res[i]==1){
                        i++;
                        Toast.makeText(getBaseContext(),"correct answer",Toast.LENGTH_LONG).show();
                        question.setText(Question.get(i));
                    }
                    else
                        Toast.makeText(getBaseContext(),"wrong answer.. Try agin",Toast.LENGTH_LONG).show();
                }
            }
        });

        btn_see_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToURL("https://www.w3schools.com/java/java_variables.asp");
            }
            private void goToURL(String s) {
                Uri uri= Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });
}

}
