package com.example.samanoudy.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import android.content.Context;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //the board is a 5x5 board
    private static final int COLUMNS = 5;
    private static final int DIMENSIONS = COLUMNS*COLUMNS;

    //we need to iterate through the tiles to randomize them right :)
    private static String[] tileList;

    private static GeastureDetectGridView mGridView;

    private static int mColumnHeight, mColumnWidth;

    public static final String up="up";
    public static final String down="down";
    public static final String left="left";
    public static final String right="right";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this is for the tiles values in order this time
        init();

        //scramble the values of the tile accross the entire board
        scramble();

        // display();

        //to make the tiles all over the screen then,
        setDimensions();

    }

    private void setDimensions() {
        ViewTreeObserver vto=mGridView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                //determine the size of the entire board
                mGridView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int displayWidth= mGridView.getMeasuredWidth();
                int displayHeight= mGridView.getMeasuredHeight();

                int statusbarHeight= getStatusBarHeight(getApplicationContext());
                int requiredHeight=displayHeight-statusbarHeight;

                mColumnWidth=displayWidth/COLUMNS;
                mColumnHeight=displayHeight/COLUMNS;
                display(getApplicationContext());
            }
        });

    }

    private int getStatusBarHeight(Context context){
        int result = 0;
        int resourceId= context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");
        if(resourceId>0){
            result= context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private static void display(Context context) {
        ArrayList<Button> buttons = new ArrayList<>();
        Button button;

        for (int i=0;i<tileList.length;i++) {
            button = new Button(context);

            if (tileList[i].equals("0")){
                button.setBackgroundResource(R.drawable.puzzle1);
            }
            else if(tileList[i].equals("1")) {
                button.setBackgroundResource(R.drawable.puzzle2);
            }
            else if(tileList[i].equals("2")) {
                button.setBackgroundResource(R.drawable.puzzle3);
            }
            else if(tileList[i].equals("3")) {
                button.setBackgroundResource(R.drawable.puzzle4);
            }
            else if(tileList[i].equals("4")) {
                button.setBackgroundResource(R.drawable.puzzle5);
            }
            else if(tileList[i].equals("5")) {
                button.setBackgroundResource(R.drawable.puzzle6);
            }
            else if(tileList[i].equals("6")) {
                button.setBackgroundResource(R.drawable.puzzle7);
            }
            else if(tileList[i].equals("7")) {
                button.setBackgroundResource(R.drawable.puzzle8);
            }
            else if(tileList[i].equals("8")) {
                button.setBackgroundResource(R.drawable.puzzle9);
            }
            else if(tileList[i].equals("9")) {
                button.setBackgroundResource(R.drawable.puzzle10);
            }
            else if(tileList[i].equals("10")) {
                button.setBackgroundResource(R.drawable.puzzle11);
            }
            else if(tileList[i].equals("11")) {
                button.setBackgroundResource(R.drawable.puzzle12);
            }
            else if(tileList[i].equals("12")) {
                button.setBackgroundResource(R.drawable.puzzle13);
            }
            else if(tileList[i].equals("13")) {
                button.setBackgroundResource(R.drawable.puzzle14);
            }
            else if(tileList[i].equals("14")) {
                button.setBackgroundResource(R.drawable.puzzle15);
            }
            else if(tileList[i].equals("15")) {
                button.setBackgroundResource(R.drawable.puzzle16);
            }
            else if(tileList[i].equals("16")) {
                button.setBackgroundResource(R.drawable.puzzle17);
            }
            else if(tileList[i].equals("17")) {
                button.setBackgroundResource(R.drawable.puzzle18);
            }
            else if(tileList[i].equals("18")) {
                button.setBackgroundResource(R.drawable.puzzle19);
            }
            else if(tileList[i].equals("19")) {
                button.setBackgroundResource(R.drawable.puzzle20);
            }
            else if(tileList[i].equals("20")) {
                button.setBackgroundResource(R.drawable.puzzle21);
            }
            else if(tileList[i].equals("21")) {
                button.setBackgroundResource(R.drawable.puzzle22);
            }
            else if(tileList[i].equals("22")) {
                button.setBackgroundResource(R.drawable.puzzle23);
            }
            else if(tileList[i].equals("23")) {
                button.setBackgroundResource(R.drawable.puzzle24);
            }
            else if(tileList[i].equals("24")) {
                button.setBackgroundResource(R.drawable.puzzle25);
            }

            buttons.add(button);
        }

        mGridView.setAdapter(new CustomAdapter(buttons,mColumnWidth,mColumnHeight));


    }


    private void scramble() {
        int index;
        String temp;
        Random random = new Random();

        for(int i=tileList.length-1;i>0;i--) {
            index = random.nextInt(i + 1);
            temp = tileList[index];
            tileList[index]=tileList[i];
            tileList[i]=temp;
        }
    }

    private void init() {

        //initialize the grid view :)
        mGridView= (GeastureDetectGridView) findViewById(R.id.grid);
        mGridView.setNumColumns(COLUMNS);

        tileList = new String[DIMENSIONS];
        for (int i = 0; i < DIMENSIONS; i++)
        {
            tileList[i]=String.valueOf(i);
        }
    }

    private static void swap(Context context, int position, int swap){
        String newPosition = tileList[position+swap];
        tileList[position+swap]=tileList[position];
        tileList[position]=newPosition;
        display(context);


        if(isSolved()){
            Toast.makeText(context,"You Win!", Toast.LENGTH_SHORT).show();
        }
    }


    private static boolean isSolved(){
        boolean solved=false;

        for(int i =0;i<tileList.length;i++) {
            if (tileList[i].equals(String.valueOf(i))) {
                solved = true;
            } else {
                solved = false;
                break;
            }
        }
        return solved;
    }
    public static void moveTiles(Context context, String direction, int position){

        //upper left corner tile
        if(position==0){
            if(direction.equals(right)){
                swap(context, position,1);
            }
            else if(direction.equals(down)){
                swap(context, position, COLUMNS);
            }
            else{
                Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();
            }
        }

        //upper middle tiles
        else if(position>0 && position< COLUMNS-1){
            if(direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(down)) swap(context,position,COLUMNS);
            else if(direction.equals(right)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();
        }

        //upper right corner tile
        else if(position==COLUMNS-1){
            if(direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(down)) swap(context,position,COLUMNS);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();
        }

        // Left-side tiles
        else if (position > COLUMNS - 1 && position < DIMENSIONS - COLUMNS &&
                position % COLUMNS == 0) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(right)) swap(context, position, 1);
            else if (direction.equals(down)) swap(context, position, COLUMNS);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Right-side AND bottom-right-corner tiles
        } else if (position == COLUMNS * 2 - 1 || position == COLUMNS * 3 - 1) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(down)) {

                // Tolerates only the right-side tiles to swap downwards as opposed to the bottom-
                // right-corner tile.
                if (position <= DIMENSIONS - COLUMNS - 1) swap(context, position,
                        COLUMNS);
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();
            } else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Bottom-left corner tile
        } else if (position == DIMENSIONS - COLUMNS) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(right)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Bottom-center tiles
        } else if (position < DIMENSIONS - 1 && position > DIMENSIONS - COLUMNS) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(right)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Center tiles
        } else {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(right)) swap(context, position, 1);
            else swap(context, position, COLUMNS);
        }



    }
}
