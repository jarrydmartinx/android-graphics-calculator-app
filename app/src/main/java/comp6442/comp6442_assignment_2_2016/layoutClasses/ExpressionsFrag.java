package comp6442.comp6442_assignment_2_2016.layoutClasses;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import comp6442.comp6442_assignment_2_2016.R;


public class ExpressionsFrag extends Fragment {
    private Context context;
    private OnExpSelectedListener mListener;
    private ListView expListView;
    private ArrayList<String> expHistArray;
    private TextView equalsTextView;
    private EditText inputEditText;

    public ExpressionsFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExpressionsFrag.
     */
    // TODO: Rename and change types and number of parameters
//    public static ExpressionsFrag newInstance(String param1, String param2) {
//        ExpressionsFrag fragment = new ExpressionsFrag();
////        Bundle args = new Bundle();
////        args.putString(ARG_PARAM1, param1);
////        args.putString(ARG_PARAM2, param2);
////        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getContext();
        expHistArray = new ArrayList<>(Arrays.asList("first fake exp", "second fake exp", "3rd 5% + 23423*log(6)" ));
        // Inflate the layout for this fragment
        View aView = inflater.inflate(R.layout.fragment_expressions, container, false);
        inputEditText = (EditText) aView.findViewById(R.id.inputEditText);
        equalsTextView = (TextView) aView.findViewById(R.id.equalsTextView);
        expListView = (ListView) aView.findViewById(R.id.expListView);
        ExpHistAdapter expHistAdapter = new ExpHistAdapter(context, R.id.expListView, expHistArray);
        equalsTextView.setText("");
        expListView.setAdapter(expHistAdapter);
        expListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                inputEditText.setText(expHistArray.get(position));
            }
        });
        return aView;
    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnExpSelectedListener) {
            mListener = (OnExpSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnButtonSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnExpSelectedListener {
        // TODO: Update argument type and name
        void onExpSelected(int position);
    }
}
