package edu.lewisu.cs.sangeetha.ratingsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";
    private RadioGroup radioGroup1, radioGroup2, radioGroup3;
    private RadioButton freshAgree, freshDisagree, freshNeutral;
    private RadioButton cookAgree, cookDisagree, cookNeutral;
    private RadioButton diverseAgree, diverseDisagree, diverseNeutral;
    private Button submitButton;

    String toastString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String value = intent.getStringExtra("key");
        radioGroup1 = (RadioGroup) findViewById(R.id.radiogroup_fresh);
        radioGroup2 = (RadioGroup) findViewById(R.id.radiogroup_diverse);
        radioGroup3 = (RadioGroup) findViewById(R.id.radiogroup_cooklevel);

        freshAgree = (RadioButton) findViewById(R.id.radio_fresh_agree);
        freshNeutral = (RadioButton) findViewById(R.id.radio_fresh_neutral);
        freshDisagree = (RadioButton) findViewById(R.id.radio_fresh_disagree);

        cookAgree = (RadioButton) findViewById(R.id.radio_cook_agree);
        cookDisagree = (RadioButton) findViewById(R.id.radio_cook_disagree);
        cookNeutral = (RadioButton) findViewById(R.id.radio_cook_neutral);

        diverseAgree = (RadioButton) findViewById(R.id.radio_diverse_agree);
        diverseDisagree = (RadioButton) findViewById(R.id.radio_diverse_disagree);
        diverseNeutral = (RadioButton) findViewById(R.id.radio_diverse_neutral);

        submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int selectedId1 = radioGroup1.getCheckedRadioButtonId();
                int selectedId2 = radioGroup2.getCheckedRadioButtonId();
                int selectedId3 = radioGroup3.getCheckedRadioButtonId();


                freshAgree.setText("Freshness : Agree");
                cookAgree.setText("Cook Level : Agree");
                diverseAgree.setText("Diversity : Agree");

                freshNeutral.setText("Freshness : Neutral");
                cookNeutral.setText("Cook Level : Neutral");
                diverseNeutral.setText("Diversity : Neutral");

                freshDisagree.setText("Freshness : Disagree");
                cookDisagree.setText("Cook Level : Disagree");
                diverseDisagree.setText("Diversity : Disagree");


                int freshID = freshAgree.getId();
                // find which radioButton is checked by id

                toastString += "Your opinion:\n ";

                if (selectedId1 == freshAgree.getId()) {
                    toastString += freshAgree.getText() + "\n";
                    toastString = toastMethod(selectedId2, selectedId3);

                } else if (selectedId1 == freshDisagree.getId()) {
                    toastString += freshDisagree.getText() + "\n";

                    toastString = toastMethod(selectedId2, selectedId3);

                } else if (selectedId1 == freshNeutral.getId()) {
                    toastString += freshNeutral.getText() + "\n";
                    toastString = toastMethod(selectedId2, selectedId3);
                }
                Toast.makeText(getApplicationContext(), toastString,
                        Toast.LENGTH_LONG).show();

                //clear all the strings
                toastString = "";
                freshAgree.setText("");
                cookAgree.setText("");
                diverseAgree.setText("");

                freshNeutral.setText("");
                cookNeutral.setText("");
                diverseNeutral.setText("");

                freshDisagree.setText("");
                cookDisagree.setText("");
                diverseDisagree.setText("");

            }
        });
    }

    //Method to compare strings and display the toast string

    public String toastMethod(int selectedId2, int selectedId3) {


        if ((selectedId2 == diverseAgree.getId()) && (selectedId3 == cookAgree.getId())) {
            toastString += diverseAgree.getText() + "\n";
            toastString += cookAgree.getText();
        } else if ((selectedId2 == diverseAgree.getId()) && (selectedId3 == cookDisagree.getId())) {
            toastString += diverseAgree.getText() + "\n";
            toastString += cookDisagree.getText();
        } else if ((selectedId2 == diverseAgree.getId()) && (selectedId3 == cookNeutral.getId())) {
            toastString += diverseAgree.getText() + "\n";
            toastString += cookNeutral.getText();
        } else if ((selectedId2 == diverseDisagree.getId()) && (selectedId3 == cookDisagree.getId())) {
            toastString += diverseDisagree.getText() + "\n";
            toastString += cookDisagree.getText();
        } else if ((selectedId2 == diverseDisagree.getId()) && (selectedId3 == cookNeutral.getId())) {
            toastString += diverseDisagree.getText() + "\n";
            toastString += cookNeutral.getText();
        } else if ((selectedId2 == diverseDisagree.getId()) && (selectedId3 == cookAgree.getId())) {
            toastString += diverseDisagree.getText() + "\n";
            toastString += cookAgree.getText();
        } else if ((selectedId2 == diverseNeutral.getId()) && (selectedId3 == cookNeutral.getId())) {
            toastString += diverseNeutral.getText() + "\n";
            toastString += cookNeutral.getText();
        } else if ((selectedId2 == diverseNeutral.getId()) && (selectedId3 == cookDisagree.getId())) {
            toastString += diverseNeutral.getText() + "\n";
            toastString += cookDisagree.getText();
        } else if ((selectedId2 == diverseNeutral.getId()) && (selectedId3 == cookAgree.getId())) {
            toastString += diverseNeutral.getText() + "\n";
            toastString += cookAgree.getText();
        }
        return toastString;

    }

}






