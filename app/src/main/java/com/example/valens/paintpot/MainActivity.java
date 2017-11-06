package com.example.valens.paintpot;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button b_red, b_blue, b_green; //color buttons
    private Button b_dotPlus, b_dotMinus, b_reset; // control buttons
    private TextView tv_dotSize;
    private static final int DOT_SIZE_INCREMENT = 5;
    private PaintPotView v_drawingpad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initialize();
    }

    private void initialize() {


        b_red = (Button) findViewById(R.id.red_b);
        b_blue = (Button) findViewById(R.id.blue_b);
        b_green = (Button) findViewById(R.id.green_b);
        b_dotPlus = (Button) findViewById(R.id.dotPlus_b);
        b_dotMinus = (Button) findViewById(R.id.dotMinus_b);
        b_reset = (Button) findViewById(R.id.reset_b);
        tv_dotSize = (TextView)findViewById(R.id.dotSize_tv);
        v_drawingpad = (PaintPotView)findViewById(R.id.drawingpad_v);

        tv_dotSize.setText("DOT SIZE : " + v_drawingpad.getDotSize());


        b_red.setOnClickListener(this);
        b_blue.setOnClickListener(this);
        b_green.setOnClickListener(this);
        b_dotPlus.setOnClickListener(this);
        b_dotMinus.setOnClickListener(this);
        b_reset.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        Button _b = findViewById(view.getId());

        switch (view.getId()) {
            case R.id.red_b : v_drawingpad.setPenColor(Color.RED);
                Log.d("Button pressed", _b.getText() +""); // debug

                break;
            case R.id.blue_b: v_drawingpad.setPenColor(Color.BLUE);
                Log.d("Button pressed", _b.getText() +""); // debug

                break;

            case R.id.green_b: v_drawingpad.setPenColor(Color.GREEN);
                Log.d("Button pressed", _b.getText() +""); // debug

                break;

            case R.id.dotPlus_b: v_drawingpad.setDotsize(+DOT_SIZE_INCREMENT);
                tv_dotSize.setText("DOT SIZE : " + v_drawingpad.getDotSize());

                Log.d("Button pressed", _b.getText() +""); // debug

                break;

            case R.id.dotMinus_b: v_drawingpad.setDotsize(-DOT_SIZE_INCREMENT);
                tv_dotSize.setText("DOT SIZE : " + v_drawingpad.getDotSize());

                Log.d("Button pressed", _b.getText() +""); // debug

                break;

            case R.id.reset_b:
                Log.d("Button pressed", _b.getText() +""); // debug

                break;


        }
    }

}
