package samanoudy.xampl;

import android.service.quicksettings.Tile;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int [] TileList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();

      //  TileList = new int[25];
        //TileList[0]=0;
      //  randomization();

        //if you added fragment via layout xml
       // fragment01 fragment = (fragment01) fm.findFragmentById(R.id.fragment);
        boolean flag =false;
       // int s= fragment.track_blank();


    }

    //TODO
    //Implement the real check function here to tell the fragment when it is supposed to perform the swap
    public boolean check(){
        boolean flag = true;
        return flag;
    }

    //TODO
    //here the selected_pos is an integer value which indicates the position of the selected tile
    //To be used for the rest of the algorithm
    //gets updated per every click on a tile
    //The printing is just for checking
    public void get_positions(int blank_pos, int selected_pos){
        Log.d(String.valueOf(blank_pos), "This is my message");
        Log.d(String.valueOf(selected_pos), "Hi there");
    }

    //TODO
    //This function should only be called to pass a new configuration of the tile or at the beginning
    //numbering of tiles go fro 0 to 24 (24 is the blank tile)
    public int [] send_array()
    {
        //int TileList [];
        TileList= new  int[25];
        for(int i =0;i<25;i++)
        {
            Random rand = new Random();
            TileList[i] = (int)rand.nextInt(24) + 0;
        }
        return TileList;
    }

}
