package comb.hcomb02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    DrawCombView drawCombView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        drawCombView = new DrawCombView(this);
        drawCombView.onSizeChanged(400, 400, 600, 600);
        setContentView(drawCombView);
        drawCombView.initPaint();
    }

}
