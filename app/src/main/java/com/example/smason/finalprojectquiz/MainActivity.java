package com.example.smason.finalprojectquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    float score;
    float total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Provide results after the submit button is clicked
     */

    public void submitAnswers(View view) {

        score = 0;

        /**
         * Get the user name
         */
        String nameIs = getName();

        /**
         * Check question 1
         */
        question1Check1();
        question1Check2();
        question1Check3();
        question1Check4();

        /**
         * Make sure question 1 was not left blank
         */
        if (!question1Check1() && !question1Check2() && !question1Check3() && !question1Check4()) {
            Context context = getApplicationContext();
            CharSequence text = nameIs + " " + getString(R.string.forgotAnswer1);
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
            toast.show();
        }

        /**
         * Check if question 1 is correct and update score if needed
         */
        else if (question1Check2()) {
            score = score + 1;
        }


        /**
         * Check question 2
         */
        question2Check1();
        question2Check2();
        question2Check3();
        question2Check4();
        question2Check5();
        question2Check6();

        /**
         * Make sure question 2 was not left blank
         */
        if (!question2Check1() && !question2Check2() && !question2Check3() && !question2Check4() && !question2Check5() && !question2Check6()) {
            Context context = getApplicationContext();
            CharSequence text = nameIs + " " + getString(R.string.forgotAnswer2);
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 0);
            toast.show();
        }

        /**
         * Check if question 2 is correct and update score if needed
         */
        else if (question2Check1() && question2Check2() && question2Check4() && question2Check6() && !question2Check3() && !question2Check5()) {
            score = score + 1;
        }




        /**
         * Check question 3
         */
        question3Check1();
        question3Check2();

        /**
         * Make sure question 3 was not left blank
         */
        if (!question3Check1() && !question3Check2()) {
            Context context = getApplicationContext();
            CharSequence text = nameIs + " " + getString(R.string.forgotAnswer3);
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.TOP | Gravity.RIGHT, 0, 0);
            toast.show();
        }

        /**
         * Check if question 3 is correct and update score if needed
         */
        else if (question3Check2()) {
            score = score + 1;
        }


        /**
         * Get text for question 4 answer
         */
        getAnswer4();

        /**
         * Make sure question 4 was not left blank
         */
        if (getAnswer4().toUpperCase().equals("")) {
            Context context = getApplicationContext();
            CharSequence text = nameIs + " " + getString(R.string.forgotAnswer4);
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.BOTTOM| Gravity.RIGHT, 0, 0);
            toast.show();
        }

        /**
         * Check if question 4 is correct and update score if needed
         */
        else if (getAnswer4().toUpperCase().equals("CPU")){
            score = score + 1;
        }


        /**
         * Check question 5
         */
        question5Check1();
        question5Check2();
        question5Check3();
        question5Check4();

        /**
         * Make sure question 5 was not left blank
         */
        if (!question5Check1() && !question5Check2() && !question5Check3() && !question5Check4()) {
            Context context = getApplicationContext();
            CharSequence text = nameIs + " " + getString(R.string.forgotAnswer5);
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);
            toast.show();
        }

        /**
         * Check if question 5 is correct and update score if needed
         */
        else if (question5Check2()){
            score = score + 1;
        }


        /**
         * Check question 6
         */
        question6Check1();
        question6Check2();
        question6Check3();
        question6Check4();
        question6Check5();

        /**
         * Make sure question 6 was not left blank
         */
        if (!question6Check1() && !question6Check3() && !question6Check4() && !question6Check2() && !question6Check5()) {
            Context context = getApplicationContext();
            CharSequence text = nameIs + " " + getString(R.string.forgotAnswer6);
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.BOTTOM | Gravity.LEFT, 0, 0);
            toast.show();
        }

        /**
         * Check if question 6 is correct and update score if needed
         */
        else if (question6Check1() && question6Check3() && question6Check4() && !question6Check2() && !question6Check5()) {
            score = score + 1;
        }

        /**
         * Get text for question 7 answer
         */
        getAnswer7();

        /**
         * Make sure question 7 was not left blank
         */
        if (getAnswer7().toLowerCase().equals("")) {
            Context context = getApplicationContext();
            CharSequence text = nameIs + " " + getString(R.string.forgotAnswer7);
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.BOTTOM | Gravity.RIGHT, 0, 0);
            toast.show();
        }

        /**
         * Check if question 7 is correct and update score if needed
         */
        else if (getAnswer7().toLowerCase().equals("heat sink")) {
            score = score + 1;
        }


        /**
         * Get total and display for the final score
         */
        total = (score / 7) * 100;


        /**displayScore(total);*/

        /**
         * Toast for final score after clicking the submit button
         */
        Context context = getApplicationContext();
        CharSequence text = nameIs + " " + getString(R.string.score) + total +". You had " + score + " answers correct.";
        int duration = Toast.LENGTH_LONG;


        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * Get the users name
     *
     */
    public String getName (){
        EditText nameIsEditText = findViewById(R.id.nameField);
        String whatIsName = nameIsEditText.getText().toString();
        return (whatIsName);
    }

    /**
     * Get logic for question 1 and pass to submitAnswers method
     */
    public boolean question1Check1() {
        RadioButton question1RadioButton1 = findViewById(R.id.question1radio1);
        boolean question1RadioButton1Checked = question1RadioButton1.isChecked();
        return (question1RadioButton1Checked);
    }

    public boolean question1Check2() {
        RadioButton question1RadioButton2 = findViewById(R.id.question1radio2);
        boolean question1RadioButton2Checked = question1RadioButton2.isChecked();
        return (question1RadioButton2Checked);
    }

    public boolean question1Check3() {
        RadioButton question1RadioButton3 = findViewById(R.id.question1radio3);
        boolean question1RadioButton3Checked = question1RadioButton3.isChecked();
        return (question1RadioButton3Checked);
    }

    public boolean question1Check4() {
        RadioButton question1RadioButton4 = findViewById(R.id.question1radio4);
        boolean question1RadioButton4Checked = question1RadioButton4.isChecked();
        return (question1RadioButton4Checked);
    }


    /**
     * Get Check box logic for question 2 and pass to submitAnswers method
     */
    public boolean question2Check1() {
        CheckBox question2CheckBox1 = findViewById(R.id.question2check1);
        boolean question2CheckBox1Checked = question2CheckBox1.isChecked();
        return (question2CheckBox1Checked);
    }

    public boolean question2Check2() {
        CheckBox question2CheckBox2 = findViewById(R.id.question2check2);
        boolean question2CheckBox2Checked = question2CheckBox2.isChecked();
        return (question2CheckBox2Checked);
    }

    public boolean question2Check3() {
        CheckBox question2CheckBox3 = findViewById(R.id.question2check3);
        boolean question2CheckBox3Checked = question2CheckBox3.isChecked();
        return (question2CheckBox3Checked);
    }

    public boolean question2Check4() {
        CheckBox question2CheckBox4 = findViewById(R.id.question2check4);
        boolean question2CheckBox4Checked = question2CheckBox4.isChecked();
        return (question2CheckBox4Checked);
    }

    public boolean question2Check5() {
        CheckBox question2CheckBox5 = findViewById(R.id.question2check5);
        boolean question2CheckBox5Checked = question2CheckBox5.isChecked();
        return (question2CheckBox5Checked);
    }

    public boolean question2Check6() {
        CheckBox question2CheckBox6 = findViewById(R.id.question2check6);
        boolean question2CheckBox6Checked = question2CheckBox6.isChecked();
        return (question2CheckBox6Checked);
    }



    /**
     * Get logic for question 3 and pass to submitAnswers method
     */
    public boolean question3Check1() {
        RadioButton question3RadioButton1 = findViewById(R.id.question3true);
        boolean question3RadioButton1Checked = question3RadioButton1.isChecked();
        return (question3RadioButton1Checked);
    }

    public boolean question3Check2() {
        RadioButton question3RadioButton2 = findViewById(R.id.question3false);
        boolean question3RadioButton2Checked = question3RadioButton2.isChecked();
        return (question3RadioButton2Checked);
    }

    /**
     * Grab text for answer 4 pass to submitAnswers method
     */
    public String getAnswer4 () {
        EditText answer4EditText = findViewById(R.id.question4answer);
        String whatIsAnswer4 = answer4EditText.getText().toString();
        return (whatIsAnswer4);
    }


    /**
     * Get logic for question 5 and pass to submitAnswers method
     */
    public boolean question5Check1() {
        RadioButton question5RadioButton1 = findViewById(R.id.question5radio1);
        boolean question5RadioButton1Checked = question5RadioButton1.isChecked();
        return (question5RadioButton1Checked);
    }

    public boolean question5Check2() {
        RadioButton question5RadioButton2 = findViewById(R.id.question5radio2);
        boolean question5RadioButton2Checked = question5RadioButton2.isChecked();
        return (question5RadioButton2Checked);
    }

    public boolean question5Check3() {
        RadioButton question5RadioButton3 = findViewById(R.id.question5radio3);
        boolean question5RadioButton3Checked = question5RadioButton3.isChecked();
        return (question5RadioButton3Checked);
    }

    public boolean question5Check4() {
        RadioButton question5RadioButton4 = findViewById(R.id.question5radio4);
        boolean question5RadioButton4Checked = question5RadioButton4.isChecked();
        return (question5RadioButton4Checked);
    }


    /**
     * Get Check box logic for question 6 and pass to submitAnswers method
     */
    public boolean question6Check1() {
        CheckBox question6CheckBox1 = findViewById(R.id.question6check1);
        boolean question6CheckBox1Checked = question6CheckBox1.isChecked();
        return (question6CheckBox1Checked);
    }

    public boolean question6Check2() {
        CheckBox question6CheckBox2 = findViewById(R.id.question6check2);
        boolean question6CheckBox2Checked = question6CheckBox2.isChecked();
        return (question6CheckBox2Checked);
    }

    public boolean question6Check3() {
        CheckBox question6CheckBox3 = findViewById(R.id.question6check3);
        boolean question6CheckBox3Checked = question6CheckBox3.isChecked();
        return (question6CheckBox3Checked);
    }

    public boolean question6Check4() {
        CheckBox question6CheckBox4 = findViewById(R.id.question6check4);
        boolean question6CheckBox4Checked = question6CheckBox4.isChecked();
        return (question6CheckBox4Checked);
    }

    public boolean question6Check5() {
        CheckBox question6CheckBox5 = findViewById(R.id.question6check5);
        boolean question6CheckBox5Checked = question6CheckBox5.isChecked();
        return (question6CheckBox5Checked);
    }


    /**
     * Grab text for answer 7 pass to submitAnswers method
     */
    public String getAnswer7 () {
        EditText answer7EditText = findViewById(R.id.question7answer);
        String whatIsAnswer7 = answer7EditText.getText().toString();
        return (whatIsAnswer7);
    }

    /**
     * Logic to reset answers when reset button is clicked
     */
    public void resetAnswers(View view) {
        score = 0;
        total = 0;

        EditText nameIsEditText = findViewById(R.id.nameField);
        nameIsEditText.setText("");

        RadioButton question1RadioButton1 = findViewById(R.id.question1radio1);
        question1RadioButton1.setChecked(false);

        RadioButton question1RadioButton2 = findViewById(R.id.question1radio2);
        question1RadioButton2.setChecked(false);

        CheckBox question2CheckBox1 = findViewById(R.id.question2check1);
        question2CheckBox1.setChecked(false);

        CheckBox question2CheckBox2 = findViewById(R.id.question2check2);
        question2CheckBox2.setChecked(false);

        CheckBox question2CheckBox3 = findViewById(R.id.question2check3);
        question2CheckBox3.setChecked(false);

        CheckBox question2CheckBox4 = findViewById(R.id.question2check4);
        question2CheckBox4.setChecked(false);

        CheckBox question2CheckBox5 = findViewById(R.id.question2check5);
        question2CheckBox5.setChecked(false);

        CheckBox question2CheckBox6 = findViewById(R.id.question2check6);
        question2CheckBox6.setChecked(false);

        RadioButton question3RadioButton1 = findViewById(R.id.question3true);
        question3RadioButton1.setChecked(false);

        RadioButton question3RadioButton2 = findViewById(R.id.question3false);
        question3RadioButton2.setChecked(false);

        EditText answer4EditText = findViewById(R.id.question4answer);
        answer4EditText.setText("");

        RadioButton question5RadioButton1 = findViewById(R.id.question5radio1);
        question5RadioButton1.setChecked(false);

        RadioButton question5RadioButton2 = findViewById(R.id.question5radio2);
        question5RadioButton2.setChecked(false);

        CheckBox question6CheckBox1 = findViewById(R.id.question6check1);
        question6CheckBox1.setChecked(false);

        CheckBox question6CheckBox2 = findViewById(R.id.question6check2);
        question6CheckBox2.setChecked(false);

        CheckBox question6CheckBox3 = findViewById(R.id.question6check3);
        question6CheckBox3.setChecked(false);

        CheckBox question6CheckBox4 = findViewById(R.id.question6check4);
        question6CheckBox4.setChecked(false);

        CheckBox question6CheckBox5 = findViewById(R.id.question6check5);
        question6CheckBox5.setChecked(false);

        EditText answer7EditText = findViewById(R.id.question7answer);
        answer7EditText.setText("");
    }


    /**
     * Display the test results **Used for testing purposes**
     *

     private void displayScore(float number) {
     TextView finalScoreTextView = findViewById(R.id.scoreTextView);
     finalScoreTextView.setText("" + number);}*/
}
