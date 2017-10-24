package com.example.edianzu.nweproject;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private ConstraintSet constraintSet1, constraintSet2;
    private ConstraintLayout firstLayout;
    private Button start;
    private Button reset;

    boolean isFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintSet1 = new ConstraintSet();
        constraintSet2 = new ConstraintSet();
        firstLayout = (ConstraintLayout) findViewById(R.id.contentPanel);
        start = (Button) findViewById(R.id.start);
        reset = (Button) findViewById(R.id.reset);

        constraintSet1.clone(firstLayout);
        constraintSet2.clone(this, R.layout.activity2);

        start.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(firstLayout);

                constraintSet2.applyTo(firstLayout);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                TransitionManager.beginDelayedTransition(firstLayout);

                constraintSet1.applyTo(firstLayout);

            }
        });
    }
}
