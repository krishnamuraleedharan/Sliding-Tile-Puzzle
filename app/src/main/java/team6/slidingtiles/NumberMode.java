package team6.slidingtiles;

import android.content.DialogInterface;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;


public class NumberMode extends AppCompatActivity implements View.OnClickListener {
    Chronometer timer;
    Button      finishBttn, pauseBttn;
    long        timePaused;
    NumberBoard gameBoard;
    int         difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_mode);

        gameBoard = null;
        timer = findViewById(R.id.timer);
        timePaused = 0;
        finishBttn = findViewById(R.id.finish_button);
        pauseBttn = findViewById(R.id.pause_button);
        finishBttn.setOnClickListener(this);
        pauseBttn.setOnClickListener(this);
        difficulty = 0;
    }

    //Once activity is visible, start the timer
    @Override
    protected void onResume(){
        super.onResume();
        if(difficulty != 0)
            resumeTimer();
        else
            NewGame();
    }

    //timer needs to be stopped when activity is not in the foreground
    @Override
    protected void onPause(){
        super.onPause();
        pauseTimer();
    }

    //onClick for finish and pause.
    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.finish_button:
                if (gameBoard.isComplete())
                    Toast.makeText(this, "finished", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "not finished", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pause_button:
                Pause();
                break;
        }
    }

    void pauseTimer(){
        timePaused = timer.getBase() - SystemClock.elapsedRealtime();
        timer.stop();
    }

    void resumeTimer(){
        timer.setBase(SystemClock.elapsedRealtime() + timePaused);
        timer.start();
    }

    void NewGame() {
        pauseTimer();
        CharSequence options[] = new CharSequence[]{"easy", "normal", "hard"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Difficulty");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i){
                    case 0:
                        difficulty = 1;
                        break;
                    case 1:
                        difficulty = 2;
                        break;
                    case 3:
                        difficulty = 3;
                        break;
                }
                CreateGame();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    void CreateGame(){
        gameBoard = new NumberBoard(true, difficulty);
        timer.setBase(SystemClock.elapsedRealtime());
        timePaused = 0;
        timer.start();
    }

    //displays the pause menu and pauses the timer
    void Pause(){
        CharSequence options[] = new CharSequence[]{"Resume", "New game", "quit"};
        pauseTimer();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.pause_menu);
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i){
                    case 0:
                        resumeTimer();
                        break;
                    case 1:
                        difficulty = 0;
                        NewGame();
                        break;
                    case 2:
                        finish();
                        break;
                }
            }
        });
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if (difficulty != 0)
                    resumeTimer();
            }
        });
        builder.show();
    }

}
