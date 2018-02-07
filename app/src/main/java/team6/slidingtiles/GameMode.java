package team6.slidingtiles;

import android.content.DialogInterface;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import java.util.ArrayList;
import java.util.Arrays;


public abstract class GameMode extends AppCompatActivity implements BoardFragment.SelectionHandler {
    ArrayList<String> boardLayout;
    BoardFragment   boardFragment;
    Chronometer     timer;
    int     difficulty;
    int     blankTile;
    long    timePaused;
    Board gameBoard;


    /**
     * is called when the activity is created, sets variables and onClickListeners
     * gets the activity ready to generate the board
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        timer = findViewById(R.id.timer);
        timePaused = 0;

        ImageButton menuIcon = findViewById(R.id.menu_button);
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                pauseTimer();
                pause().show();
            }
        });

        boardFragment = BoardFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentFrame, boardFragment).commit();;

        newGame();
    }

    /**
     * onResume is called when the activity becomes visible again
     * if a Board exists then it will resume the timer
     */
    @Override
    protected void onResume(){
        super.onResume();
        if(gameBoard!=null)
            resumeTimer();
    }

    /**
     * onPause is called when the activity loses focus,
     * in which case it pauses the timer.
     */
    @Override
    protected void onPause(){
        super.onPause();
        pauseTimer();
    }

    /**
     * pauses the timer
     */
    void pauseTimer(){
        timePaused = timer.getBase() - SystemClock.elapsedRealtime();
        timer.stop();
    }

    /**
     * resumes the timer
     */
    void resumeTimer(){
        timer.setBase(SystemClock.elapsedRealtime() + timePaused);
        timer.start();
    }

    /**
     * creates a newGameDialog to be displayed, lets user select difficulty
     * @return the Builder which the actionDialog is contained in
     */
    AlertDialog.Builder newGameDialog() {
        CharSequence options[]      = new CharSequence[]{"Easy", "Normal", "Hard"};
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

    /**
     * convert from 2d array to ArrayList
     * @param oldArray the 2d array representing the board
     * @return an ArrayList representing the board
     */
    ArrayList<String> convertDimm(String[][] oldArray){
        ArrayList<String> tmp = new ArrayList<>();
        for (String[] array : oldArray) {
            tmp.addAll(Arrays.asList(array));
        }
        return tmp;
    }

    /**
     * displays the new game menu
     */
    void newGame(){
        AlertDialog.Builder builder = newGameDialog();
        pauseTimer();
        builder.show();
    }

    /**
     * updates the board currently being displayed
     * @param board the new board
     */
    void SetBoard(Board board) {
        boardLayout = convertDimm(board.getBoard());
        for(int i = 0; i < boardLayout.size(); i++)
            if (boardLayout.get(i).compareTo(" ")==0)
                blankTile = i;
        boardFragment.setBoardLayout(boardLayout);
    }

    /**
     * starts the timer. this must be called from child classes
     */
    void createGame(){
        timePaused = 0;
        timer.setBase(SystemClock.elapsedRealtime());
        timer.start();
    }

    /**
     * creates and returns an AlterDialog with the pausemenu inside of it
     * @return Builder containing the pause menu
     */
    AlertDialog.Builder pause(){
        CharSequence options[] = new CharSequence[]{"Resume", "New game", "Quit"};
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
                resumeTimer();
            }
        });
        return builder;
    }

    /**
     * tries to swap the blank tile with the selected tile
     * @param pos the selected tile
     * @return if the operation was successful
     */
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

    /**
     * method for the handler in BoardFragment
     * @param pos the position of the selected tile
     * @return if the tile was successfully swapped
     */
    public boolean handleSelection(int pos){
        return moveTile(pos);
    }
}