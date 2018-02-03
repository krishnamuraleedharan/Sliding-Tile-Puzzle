package team6.slidingtiles;

import android.app.Fragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.SystemClock;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;


public abstract class GameMode extends AppCompatActivity implements fragment01.SelectionHandler {
    public final String ARG_BOARD = "boardArray";
    int         difficulty;
    Toolbar     toolbar;
    ImageView menuIcon;
    fragment01 boardFragment;
    ArrayList<String> boardLayout;
    int blankTile;
    Chronometer timer;
    long        timePaused;
    Board gameBoard;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        boardFragment = fragment01.newInstance();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentFrame, boardFragment).commit();


        timer = findViewById(R.id.timer);
        timePaused = 0;

        menuIcon = findViewById(R.id.menu_button);
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                pause().show();
            }
        });

        newGame();


    }

    void pauseTimer(){
        timePaused = timer.getBase() - SystemClock.elapsedRealtime();
        timer.stop();
    }

    void resumeTimer(){
        timer.setBase(SystemClock.elapsedRealtime() + timePaused);
        timer.start();
    }

    AlertDialog.Builder newGameDialog() {
        CharSequence options[] = new CharSequence[]{"Easy", "Normal", "Hard"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Difficulty");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i){
                    case 0:
                        difficulty = 8;
                        break;
                    case 1:
                        difficulty = 16;
                        break;
                    case 2:
                        difficulty = 32;
                        break;
                }
                createGame();
            }
        });
        builder.setCancelable(false);

        return builder;
    }

    ArrayList<String> convertDimm(String[][] oldArray){
        ArrayList<String> tmp = new ArrayList<>();
        for (String[] array : oldArray) {
            tmp.addAll(Arrays.asList(array));
        }
        return tmp;
    }

    void newGame(){
        AlertDialog.Builder builder = newGameDialog();
        builder.show();
    }

    void SetBoard(Board board) {
        boardLayout = convertDimm(board.getBoard());
        for(int i = 0; i < boardLayout.size(); i++)
            if (boardLayout.get(i).compareTo(" ")==0)
                blankTile = i;
        boardFragment.setBoardLayout(boardLayout);
    }

    void createGame(){
        timer.setBase(SystemClock.elapsedRealtime());
        timePaused = 0;
        timer.start();
    }

    //displays the pause menu and pauses the timer
    AlertDialog.Builder pause(){
        CharSequence options[] = new CharSequence[]{"Resume", "New game", "quit"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.pause_menu);

        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i){
                    case 0:
                        onResume();
                        break;
                    case 1:
                        newGame();
                        break;
                    case 2:
                        finish();
                        break;
                }
            }
        });

        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                onResume();
            }
        });
        return builder;
    }

    boolean moveTile(int pos){
        int x = pos % 5;
        int y = pos / 5;
        if(gameBoard.swapTiles(x,y)) {
            boardLayout = convertDimm(gameBoard.getBoard());
            boardFragment.setBoardLayout(boardLayout);
            blankTile = pos;
            return true;
        }
        return false;
    }

    public boolean handleSelection(int pos){
        return moveTile(pos);
    }

}

