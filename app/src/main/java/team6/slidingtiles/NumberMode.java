package team6.slidingtiles;

import android.icu.text.MeasureFormat;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import org.w3c.dom.Text;


public class NumberMode extends GameMode {
    Chronometer timer;
    long        timePaused;
    NumberBoard gameBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        gameBoard = null;
        timePaused = 0;
        toolbarLayout = new LinearLayout(this);
        timer = new Chronometer(this);
        timer.setGravity(Gravity.CENTER);
        timer.setTextSize(40);

        toolbarLayout.addView(timer);

        super.onCreate(savedInstanceState);
    }

    //Once activity is visible, start the timer
    @Override
    protected void onResume(){
        super.onResume();
        if(gameBoard!=null)
            resumeTimer();
    }

    //timer needs to be stopped when activity is not in the foreground
    @Override
    protected void onPause(){
        super.onPause();
        pauseTimer();
    }

    //onClick for finish and pause.
//    @Override
/*    public void onClick(View view){
        if (view == pauseBttn)
            pauseTimer();
        super.onClick(view);
    }
*/
    void pauseTimer(){
        timePaused = timer.getBase() - SystemClock.elapsedRealtime();
        timer.stop();
    }

    void resumeTimer(){
        timer.setBase(SystemClock.elapsedRealtime() + timePaused);
        timer.start();
    }

    void newGame() {
        pauseTimer();
        super.newGame();
    }

    void createGame(){
        gameBoard = new NumberBoard(true, difficulty);
        SetBoard(gameBoard);
        timer.setBase(SystemClock.elapsedRealtime());
        timePaused = 0;
        timer.start();
    }

    //displays the pause menu and pauses the timer
    AlertDialog.Builder pause(){
        pauseTimer();
        return super.pause();
    }



}
