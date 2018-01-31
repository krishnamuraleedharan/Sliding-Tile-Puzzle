package samanoudy.xampl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();

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
}
