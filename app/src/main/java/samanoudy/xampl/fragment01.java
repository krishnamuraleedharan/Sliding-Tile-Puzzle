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

    public ImageButton ib1;
    public ImageButton ib2;
    public ImageButton ib3;
    public ImageButton ib4;
    public ImageButton ib5;
    public ImageButton ib6;
    public ImageButton ib7;
    public ImageButton ib8;
    public ImageButton ib9;
    public ImageButton ib10;
    public ImageButton ib11;
    public ImageButton ib12;
    public ImageButton ib13;
    public ImageButton ib14;
    public ImageButton ib15;
    public ImageButton ib16;
    public ImageButton ib17;
    public ImageButton ib18;
    public ImageButton ib19;
    public ImageButton ib20;
    public ImageButton ib21;
    public ImageButton ib22;
    public ImageButton ib23;
    public ImageButton ib24;
    public ImageButton ib25;
    public ImageButton ib26;
    public ImageButton blankTile;
    public ImageButton blankT;
    public Object pos;
    public int blank_pos = 24;
    public int selected_pos;

    public int k;
    public int r;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_fragment01, container, false);

        ib1 = (ImageButton) v.findViewById(R.id.button1);
        ib2 = (ImageButton) v.findViewById(R.id.button2);
        ib3 = (ImageButton) v.findViewById(R.id.button3);
        ib4 = (ImageButton) v.findViewById(R.id.button4);
        ib5 = (ImageButton) v.findViewById(R.id.button5);
        ib6 = (ImageButton) v.findViewById(R.id.button6);
        ib7 = (ImageButton) v.findViewById(R.id.button7);
        ib8 = (ImageButton) v.findViewById(R.id.button8);
        ib9 = (ImageButton) v.findViewById(R.id.button9);
        ib10 = (ImageButton) v.findViewById(R.id.button10);
        ib11 = (ImageButton) v.findViewById(R.id.button11);
        ib12 = (ImageButton) v.findViewById(R.id.button12);
        ib13 = (ImageButton) v.findViewById(R.id.button13);
        ib14 = (ImageButton) v.findViewById(R.id.button14);
        ib15 = (ImageButton) v.findViewById(R.id.button15);
        ib16 = (ImageButton) v.findViewById(R.id.button16);
        ib17 = (ImageButton) v.findViewById(R.id.button17);
        ib18 = (ImageButton) v.findViewById(R.id.button18);
        ib19 = (ImageButton) v.findViewById(R.id.button19);
        ib20 = (ImageButton) v.findViewById(R.id.button20);
        ib21 = (ImageButton) v.findViewById(R.id.button21);
        ib22 = (ImageButton) v.findViewById(R.id.button22);
        ib23 = (ImageButton) v.findViewById(R.id.button23);
        ib24 = (ImageButton) v.findViewById(R.id.button24);
        ib25 = (ImageButton) v.findViewById(R.id.button25);
        ib26 = (ImageButton) v.findViewById(R.id.button26);
        blankT = (ImageButton) v.findViewById(R.id.button26);
        blankTile = (ImageButton) v.findViewById(R.id.button25);


        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 0;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib1.getBackground());
                    ib1.setBackground(ib26.getBackground());
                }
            }
        });


        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 1;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib2.getBackground());
                    ib2.setBackground(ib26.getBackground());
                }
            }
        });


        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 2;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib3.getBackground());
                    ib3.setBackground(ib26.getBackground());
                }
            }
        });


        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 3;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib4.getBackground());
                    ib4.setBackground(ib26.getBackground());
                }
            }
        });


        ib5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 4;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib5.getBackground());
                    ib5.setBackground(ib26.getBackground());
                }
            }
        });


        ib6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 5;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib6.getBackground());
                    ib6.setBackground(ib26.getBackground());
                }
            }
        });


        ib7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 6;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib7.getBackground());
                    ib7.setBackground(ib26.getBackground());
                }
            }
        });

        ib8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 7;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib8.getBackground());
                    ib8.setBackground(ib26.getBackground());
                }
            }
        });

        ib9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 8;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib9.getBackground());
                    ib9.setBackground(ib26.getBackground());
                }
            }
        });

        ib10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 9;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib10.getBackground());
                    ib10.setBackground(ib26.getBackground());
                }
            }
        });

        ib11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 10;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib11.getBackground());
                    ib11.setBackground(ib26.getBackground());
                }
            }
        });

        ib12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 11;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib12.getBackground());
                    ib12.setBackground(ib26.getBackground());
                }
            }
        });

        ib13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 12;
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                track(v);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib13.getBackground());
                    ib13.setBackground(ib26.getBackground());
                }
            }
        });

        ib14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 13;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib14.getBackground());
                    ib14.setBackground(ib26.getBackground());
                }
            }
        });


        ib15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 14;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib15.getBackground());
                    ib15.setBackground(ib26.getBackground());
                }
            }
        });

        ib16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 15;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib16.getBackground());
                    ib16.setBackground(ib26.getBackground());
                }
            }
        });


        ib17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 16;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib17.getBackground());
                    ib17.setBackground(ib26.getBackground());
                }
            }
        });


        ib18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 17;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib18.getBackground());
                    ib18.setBackground(ib26.getBackground());
                }
            }
        });

        ib19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 18;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib19.getBackground());
                    ib19.setBackground(ib26.getBackground());
                }
            }
        });

        ib20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 19;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib20.getBackground());
                    ib20.setBackground(ib26.getBackground());
                }
            }
        });

        ib21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 20;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib21.getBackground());
                    ib21.setBackground(ib26.getBackground());
                }
            }
        });

        ib22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 21;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib22.getBackground());
                    ib22.setBackground(ib26.getBackground());
                }
            }
        });

        ib23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 22;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib23.getBackground());
                    ib23.setBackground(ib26.getBackground());
                }
            }
        });

        ib24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 23;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib24.getBackground());
                    ib24.setBackground(ib26.getBackground());
                }
            }
        });

        ib25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_pos = 24;
                track(v);
                ((MainActivity) getActivity()).get_positions(blank_pos, selected_pos);
                if (((MainActivity) getActivity()).check()) {
                    blankTile.setBackground(ib25.getBackground());
                    ib25.setBackground(ib26.getBackground());
                }
            }
        });

        return v;
    }


    public void track(View v) {

        //int pos = ib25.getId();
        if (ib1.getBackground().equals(ib26.getBackground())) {
            blankTile = ib1;
            blank_pos = 0;
        } else if (ib2.getBackground().equals(ib26.getBackground())) {
            blankTile = ib2;
            blank_pos = 1;
        } else if (ib3.getBackground().equals(ib26.getBackground())) {
            blankTile = ib3;
            blank_pos = 2;
        } else if (ib4.getBackground().equals(ib26.getBackground())) {
            blankTile = ib4;
            blank_pos = 3;
        } else if (ib5.getBackground().equals(ib26.getBackground())) {
            blankTile = ib5;
            blank_pos = 4;
        } else if (ib6.getBackground().equals(ib26.getBackground())) {
            blankTile = ib6;
            blank_pos = 5;
        } else if (ib7.getBackground().equals(ib26.getBackground())) {
            blankTile = ib7;
            blank_pos = 6;
        } else if (ib8.getBackground().equals(ib26.getBackground())) {
            blankTile = ib8;
            blank_pos = 7;
        } else if (ib9.getBackground().equals(ib26.getBackground())) {
            blankTile = ib9;
            blank_pos = 8;
        } else if (ib10.getBackground().equals(ib26.getBackground())) {
            blankTile = ib10;
            blank_pos = 9;
        } else if (ib11.getBackground().equals(ib26.getBackground())) {
            blankTile = ib11;
            blank_pos = 10;
        } else if (ib12.getBackground().equals(ib26.getBackground())) {
            blankTile = ib12;
            blank_pos = 11;
        } else if (ib13.getBackground().equals(ib26.getBackground())) {
            blankTile = ib13;
            blank_pos = 12;
        } else if (ib14.getBackground().equals(ib26.getBackground())) {
            blankTile = ib14;
            blank_pos = 13;
        } else if (ib15.getBackground().equals(ib26.getBackground())) {
            blankTile = ib15;
            blank_pos = 14;
        } else if (ib16.getBackground().equals(ib26.getBackground())) {
            blankTile = ib16;
            blank_pos = 15;
        } else if (ib17.getBackground().equals(ib26.getBackground())) {
            blankTile = ib17;
            blank_pos = 16;
        } else if (ib18.getBackground().equals(ib26.getBackground())) {
            blankTile = ib18;
            blank_pos = 17;
        } else if (ib19.getBackground().equals(ib26.getBackground())) {
            blankTile = ib19;
            blank_pos = 18;
        } else if (ib20.getBackground().equals(ib26.getBackground())) {
            blankTile = ib20;
            blank_pos = 19;
        } else if (ib21.getBackground().equals(ib26.getBackground())) {
            blankTile = ib21;
            blank_pos = 20;
        } else if (ib22.getBackground().equals(ib26.getBackground())) {
            blankTile = ib22;
            blank_pos = 21;
        } else if (ib23.getBackground().equals(ib26.getBackground())) {
            blankTile = ib23;
            blank_pos = 22;
        } else if (ib24.getBackground().equals(ib26.getBackground())) {
            blankTile = ib24;
            blank_pos = 23;
        } else if (ib25.getBackground().equals(ib26.getBackground())) {
            blankTile = ib25;
            blank_pos = 24;
        }
    }


    public int track_blank() {
        // System.out.print(blank_pos);
        Log.d(String.valueOf(blank_pos), "This is my message");
        return blank_pos;
    }

    public int track_selected() {
        Log.d(String.valueOf(selected_pos), "as message");
        return selected_pos;
    }

}
