package vn.edu.itplus_academy.myapplication.fragements;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import vn.edu.itplus_academy.myapplication.R;
import vn.edu.itplus_academy.myapplication.adapters.NoteItemAdapter;
import vn.edu.itplus_academy.myapplication.daos.NoteItemDAO;
import vn.edu.itplus_academy.myapplication.models.NoteItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoteListFragment extends Fragment {

    ListView listViewNote;
    ArrayAdapter<NoteItem> adapter;
    ArrayList<NoteItem> myNoteItems;

    public NoteListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_note_list, container, false);

        listViewNote = view.findViewById(R.id.listviewNote);

        NoteItemDAO dao = new NoteItemDAO(getActivity());
        myNoteItems = dao.getAll();
        adapter = new NoteItemAdapter(getActivity(), R.layout.item_note, myNoteItems);
        listViewNote.setAdapter(adapter);


        return view;
    }

}
