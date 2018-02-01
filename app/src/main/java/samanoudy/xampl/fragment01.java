package samanoudy.xampl;


import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;
import android.content.Context;



/**
 * A simple {@link Fragment} subclass.
 */
public class fragment01 extends Fragment {


    //global variables


    public fragment01() {
        // Required empty public constructor
    }

    //to do get a flag into this fragment and check that this movement can be really dome
    //check with a simple and and for the conditions

    public ImageButton ib26;
    public ImageButton blankTile;
    public ImageButton blankT;

    public ImageButton [] ib_all;

    public Object pos;
    public int blank_pos = 24;
    public int selected_pos;

    public int [] TileList;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_fragment01, container, false);
        ib_all = new ImageButton[25];
        ib_all[0] = (ImageButton) v.findViewById(R.id.button1);
        ib_all[1] = (ImageButton) v.findViewById(R.id.button2);
        ib_all[2] = (ImageButton) v.findViewById(R.id.button3);
        ib_all[3] = (ImageButton) v.findViewById(R.id.button4);
        ib_all[4]= (ImageButton) v.findViewById(R.id.button5);
        ib_all[5] = (ImageButton) v.findViewById(R.id.button6);
        ib_all[6]= (ImageButton) v.findViewById(R.id.button7);
        ib_all[7]= (ImageButton) v.findViewById(R.id.button8);
        ib_all[8]= (ImageButton) v.findViewById(R.id.button9);
        ib_all[9]= (ImageButton) v.findViewById(R.id.button10);
        ib_all[10]= (ImageButton) v.findViewById(R.id.button11);
        ib_all[11]= (ImageButton) v.findViewById(R.id.button12);
        ib_all[12]= (ImageButton) v.findViewById(R.id.button13);
        ib_all[13]= (ImageButton) v.findViewById(R.id.button14);
        ib_all[14]= (ImageButton) v.findViewById(R.id.button15);
        ib_all[15]= (ImageButton) v.findViewById(R.id.button16);
        ib_all[16]= (ImageButton) v.findViewById(R.id.button17);
        ib_all[17]= (ImageButton) v.findViewById(R.id.button18);
        ib_all[18]= (ImageButton) v.findViewById(R.id.button19);
        ib_all[19]= (ImageButton) v.findViewById(R.id.button20);
        ib_all[20]= (ImageButton) v.findViewById(R.id.button21);
        ib_all[21]= (ImageButton) v.findViewById(R.id.button22);
        ib_all[22]= (ImageButton) v.findViewById(R.id.button23);
        ib_all[23]= (ImageButton) v.findViewById(R.id.button24);
        ib_all[24]= (ImageButton) v.findViewById(R.id.button25);
        ib26 = (ImageButton) v.findViewById(R.id.button26);

        blankT = (ImageButton) v.findViewById(R.id.button26);
        blankTile = (ImageButton) v.findViewById(R.id.button25);

        //TileList= ((MainActivity) )
        TileList= new int[25];
        TileList = ((MainActivity) getActivity()).send_array();

        for(int i=0;i<TileList.length;i++) {
            switch (TileList[i]) {
                case 0: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle1);
                    break;
                }
                case 1: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle2);
                    break;
                }
                case 2: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle3);
                    break;
                }
                case 3: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle4);
                    break;
                }
                case 4: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle5);
                    break;
                }
                case 5: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle6);
                    break;
                }
                case 6: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle7);
                    break;
                }
                case 7: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle8);
                    break;
                }
                case 8: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle9);
                    break;
                }
                case 9: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle10);
                    break;
                }
                case 10: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle11);
                    break;
                }
                case 11: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle12);
                    break;
                }
                case 12: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle13);
                    break;
                }
                case 13: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle14);
                    break;
                }
                case 14: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle15);
                    break;
                }
                case 15: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle16);
                    break;
                }
                case 16: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle17);
                    break;
                }
                case 17: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle18);
                    break;
                }
                case 18: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle19);
                    break;
                }
                case 19: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle20);
                    break;
                }
                case 20: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle21);
                    break;
                }
                case 21: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle22);
                    break;
                }
                case 22: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle23);
                    break;
                }
                case 23: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle24);
                    break;
                }
                case 24: {
                    ib_all[i].setBackgroundResource(R.drawable.puzzle25);
                    break;
                }
                default:
            }

            }


        ib_all[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 0;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[0].getBackground());
                    ib_all[0].setBackground(ib26.getBackground());
                }
            }
        });


        ib_all[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 1;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[1].getBackground());
                    ib_all[1].setBackground(ib26.getBackground());
                }
            }
        });


        ib_all[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 2;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[2].getBackground());
                    ib_all[2].setBackground(ib26.getBackground());
                }
            }
        });


        ib_all[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 3;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[3].getBackground());
                    ib_all[3].setBackground(ib26.getBackground());
                }
            }
        });


        ib_all[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 4;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[4].getBackground());
                    ib_all[4].setBackground(ib26.getBackground());
                }
            }
        });


        ib_all[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 5;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[5].getBackground());
                    ib_all[5].setBackground(ib26.getBackground());
                }
            }
        });


        ib_all[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 6;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[6].getBackground());
                    ib_all[6].setBackground(ib26.getBackground());
                }
            }
        });

        ib_all[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 7;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[7].getBackground());
                    ib_all[7].setBackground(ib26.getBackground());
                }
            }
        });

        ib_all[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 8;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[8].getBackground());
                    ib_all[8].setBackground(ib26.getBackground());
                }
            }
        });

        ib_all[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 9;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[9].getBackground());
                    ib_all[9].setBackground(ib26.getBackground());
                }
            }
        });

        ib_all[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 10;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[10].getBackground());
                    ib_all[10].setBackground(ib26.getBackground());
                }
            }
        });

        ib_all[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 11;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[11].getBackground());
                    ib_all[11].setBackground(ib26.getBackground());
                }
            }
        });

        ib_all[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 12;
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                track(v);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[12].getBackground());
                    ib_all[12].setBackground(ib26.getBackground());
                }
            }
        });

        ib_all[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 13;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[13].getBackground());
                    ib_all[13].setBackground(ib26.getBackground());
                }
            }
        });


        ib_all[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 14;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[14].getBackground());
                    ib_all[14].setBackground(ib26.getBackground());
                }
            }
        });

        ib_all[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 15;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[15].getBackground());
                    ib_all[15].setBackground(ib26.getBackground());
                }
            }
        });


        ib_all[16].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 16;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[16].getBackground());
                    ib_all[16].setBackground(ib26.getBackground());
                }
            }
        });


        ib_all[17].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 17;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[17].getBackground());
                    ib_all[17].setBackground(ib26.getBackground());
                }
            }
        });

        ib_all[18].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 18;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[18].getBackground());
                    ib_all[18].setBackground(ib26.getBackground());
                }
            }
        });

        ib_all[19].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 19;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[19].getBackground());
                    ib_all[19].setBackground(ib26.getBackground());
                }
            }
        });

        ib_all[20].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 20;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[20].getBackground());
                    ib_all[20].setBackground(ib26.getBackground());
                }
            }
        });

        ib_all[21].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 21;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[21].getBackground());
                    ib_all[21].setBackground(ib26.getBackground());
                }
            }
        });

        ib_all[22].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 22;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[22].getBackground());
                    ib_all[22].setBackground(ib26.getBackground());
                }
            }
        });

        ib_all[23].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 23;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[23].getBackground());
                    ib_all[23].setBackground(ib26.getBackground());
                }
            }
        });

        ib_all[24].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 24;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib_all[24].getBackground());
                    ib_all[24].setBackground(ib26.getBackground());
                }
            }
        });

        return v;
    }


    public void track(View v) {

        //int pos = ib25.getId();
        if (ib_all[0].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[0];
            blank_pos = 0;
        } else if (ib_all[1].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[1];
            blank_pos = 1;
        } else if (ib_all[2].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[2];
            blank_pos = 2;
        } else if (ib_all[3].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[3];
            blank_pos = 3;
        } else if (ib_all[4].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[4];
            blank_pos = 4;
        } else if (ib_all[5].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[5];
            blank_pos = 5;
        } else if (ib_all[6].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[6];
            blank_pos = 6;
        } else if (ib_all[7].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[7];
            blank_pos = 7;
        } else if (ib_all[8].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[8];
            blank_pos = 8;
        } else if (ib_all[9].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[9];
            blank_pos = 9;
        } else if (ib_all[10].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[10];
            blank_pos = 10;
        } else if (ib_all[11].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[11];
            blank_pos = 11;
        } else if (ib_all[12].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[12];
            blank_pos = 12;
        } else if (ib_all[13].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[13];
            blank_pos = 13;
        } else if (ib_all[14].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[14];
            blank_pos = 14;
        } else if (ib_all[15].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[15];
            blank_pos = 15;
        } else if (ib_all[16].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[16];
            blank_pos = 16;
        } else if (ib_all[17].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[17];
            blank_pos = 17;
        } else if (ib_all[18].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[18];
            blank_pos = 18;
        } else if (ib_all[19].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[19];
            blank_pos = 19;
        } else if (ib_all[20].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[20];
            blank_pos = 20;
        } else if (ib_all[21].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[21];
            blank_pos = 21;
        } else if (ib_all[22].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[22];
            blank_pos = 22;
        } else if (ib_all[23].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[23];
            blank_pos = 23;
        } else if (ib_all[24].getBackground().equals(ib26.getBackground())) {
            blankTile = ib_all[24];
            blank_pos = 24;
        }
    }

}