package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submitButton;

    // variable is used to store the number of correct answers of questions
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(submitButtonOnClickListener);
    }


    /*
     check the answer of the question 1 is correct or not .If the answer is correct ,increase the number of
     correct answers by 1
     */
    private void checkQuestionOneAnswers() {
        RadioButton radioButtonImplements = (RadioButton) findViewById(R.id.radio_implements);
        boolean isQuestionOneImplementsChecked = radioButtonImplements.isChecked();
        if (isQuestionOneImplementsChecked)
            correctAnswers += 1;
    }

    /*
    This method is used to check the answer of the question 2 is correct or not .
    If the answer is correct ,increase the number of correct answers by 1
    */
    private void checkQuestionTwoAnswers() {
        RadioButton radioButtonJavaLang = (RadioButton) findViewById(R.id.radio_java_lang);
        boolean isQuestionTwoJavaLangChecked = radioButtonJavaLang.isChecked();
        if (isQuestionTwoJavaLangChecked)
            correctAnswers += 1;
    }


    /*
      This method is used to get the value of user input
     */

    private String getQuestionThreeUserInput() {
        EditText userInputProgrammingLanguage = (EditText) findViewById(R.id.user_input_programming_language);
        String nameOfProgrammingLanguage = userInputProgrammingLanguage.getText().toString();
        return nameOfProgrammingLanguage;
    }

    /*
     This method is used to check the value of user input is correct or not.
      If the answer is correct ,increase the number of correct answers by
     */
    private void checkQuestionThreeAnswers() {
        String nameOfProgrammingLanguage = getQuestionThreeUserInput();
        if (nameOfProgrammingLanguage.trim().equalsIgnoreCase(getString(R.string.java_programming)))
            correctAnswers += 1;
    }


    /*
     THis method is used to check the answer of question 4 is correct or not .
     If the answer is correct , increase the number of correct answers by 1
     */
    private void checkQuestionFourAnswers() {
        CheckBox answerQuestionFourTrue = (CheckBox) findViewById(R.id.checkboxQuest4AnswerTrue);
        CheckBox answerQuestionFourLong = (CheckBox) findViewById(R.id.checkboxQuest4AnswerLong);
        CheckBox answerQuestionFourStatic = (CheckBox) findViewById(R.id.checkboxQuest4AnswerStatic);
        CheckBox answerQuestionFourEnd = (CheckBox) findViewById(R.id.checkboxQuest4AnswerEnd);

        Boolean answerQuestionFourTrueChecked = answerQuestionFourTrue.isChecked();
        Boolean answerQuestionFourLongChecked = answerQuestionFourLong.isChecked();
        Boolean answerQuestionFourStaticChecked = answerQuestionFourStatic.isChecked();
        Boolean answerQuestionFourEndChecked = answerQuestionFourEnd.isChecked();

        if (!answerQuestionFourTrueChecked && answerQuestionFourLongChecked && answerQuestionFourStaticChecked
                && !answerQuestionFourEndChecked)
            correctAnswers += 1;

    }



    /*
     THis method is used to check the answer of question 5 is correct or not .
     If the answer is correct , increase the number of correct answers by 1
     */
    private void checkQuestionFiveAnswers() {
        CheckBox answerQuestionFiveInt = (CheckBox) findViewById(R.id.checkboxQuest5AnswerInt);
        CheckBox answerQuestionFiveShort = (CheckBox) findViewById(R.id.checkboxQuest5AnswerShort);
        CheckBox answerQuestionFiveByte = (CheckBox) findViewById(R.id.checkboxQuest5AnswerByte);
        CheckBox answerQuestionFiveEnum = (CheckBox) findViewById(R.id.checkboxQuest5AnswerEnum);

        Boolean answerQuestionFiveIntChecked = answerQuestionFiveInt.isChecked();
        Boolean answerQuestionFiveShortChecked = answerQuestionFiveShort.isChecked();
        Boolean answerQuestionFiveByteChecked = answerQuestionFiveByte.isChecked();
        Boolean answerQuestionFiveEnumChecked = answerQuestionFiveEnum.isChecked();

        if (answerQuestionFiveIntChecked && answerQuestionFiveShortChecked && answerQuestionFiveByteChecked
                && !answerQuestionFiveEnumChecked)
            correctAnswers += 1;

    }


    /*
    This method is used to check the answers of all questions
     */
    private void checkAllQuestions() {
        checkQuestionOneAnswers();
        checkQuestionTwoAnswers();
        checkQuestionThreeAnswers();
        checkQuestionFourAnswers();
        checkQuestionFiveAnswers();
    }

    /*
     This method is used to reset the number of correct answers to zero after the toast of the result
      displayed
     */
    public void resetCounterCorrectAnswers() {
        correctAnswers = 0;
    }

     /*
      This method will happen when the button (reset) is clicked and show the toast on the screen
       that display the number of correct answers
     */

    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {

            checkAllQuestions();
            /*
            This method (String.format) is used to show the number of correct answers
             based on the locale language
             */
            Toast.makeText(MainActivity.this, getString(R.string.correct_answers) + " " +
                    String.format("%d", correctAnswers) +
                    " " + getString(R.string.from_5), Toast.LENGTH_LONG).show();
            resetCounterCorrectAnswers();
        }
    };
}

