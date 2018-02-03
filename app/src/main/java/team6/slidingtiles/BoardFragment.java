package team6.slidingtiles;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BoardFragment extends Fragment {
    public BoardFragment() {
        // Required empty public constructor
    }

    private SelectionHandler selectionHandler;
    private GridView boardGrid;

    /**
     *
     * @param inflater the layout inflater to be used
     * @param container the layout containing the fragment
     * @param savedInstanceState the saved instance state if there is one
     * @return returns the new fragment
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_board, container, false);
        selectionHandler = (SelectionHandler) getActivity();
        return v;
    }


    /**
     * @param savedInstanceState the saved instance state to be restored
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    /**
     * @return a new instance of this fragment
     */
    public static BoardFragment newInstance() {
        return new BoardFragment();
    }

    /**
     * changes the boardLayout displayed in the gridview
     * @param boardLayout the boardLayout ArrayList to be displayed in the gridview
     */
    public void setBoardLayout(ArrayList<String> boardLayout) {
        final BoardArrayAdapter adapter = new BoardArrayAdapter
                (getView().getContext(), boardLayout, getView().getHeight());
        boardGrid = getView().findViewById(R.id.board_grid);
        boardGrid.invalidateViews();
        boardGrid.setAdapter(adapter);
        boardGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectionHandler.handleSelection(i);
            }
        });
    }

    /**
     * interface to handle communication from the fragment to activity
     */
    public interface SelectionHandler{
        boolean handleSelection(int position);
    }
}