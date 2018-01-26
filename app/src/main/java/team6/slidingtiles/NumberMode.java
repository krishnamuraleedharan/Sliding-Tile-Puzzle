package team6.slidingtiles;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;



public class NumberMode extends AppCompatActivity implements View.OnClickListener {
    Chronometer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_mode);

        timer = findViewById(R.id.timer);

    }

    //Once activity is visible, start the timer
    @Override
    protected void onResume(){
        super.onResume();
        timer.start();
    }

    //timer needs to be stopped when activity is not in the foreground
    @Override
    protected void onPause(){
        super.onPause();
        timer.stop();
    }

    //onClick for finish and pause.
    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.finish_button:

                break;
            case R.id.pause_button:
                Pause();
                break;
        }
    }

    //displays the pause menu and pauses the timer
    void Pause(){
        CharSequence options[] = new CharSequence[]{"Resume", "New game", "quit"};
        timer.stop();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.pause_menu);
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i){
                    case 0:
                        timer.start();
                        break;
                    case 1:
                        break;
                    case 2:
                        finish();
                        break;

                }
            }
        });
        builder.show();
    }
}
