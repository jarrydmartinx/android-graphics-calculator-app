package comp6442.comp6442_assignment_2_2016.layoutClasses;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import comp6442.comp6442_assignment_2_2016.R;

/**
 * Created by jarryd on 30/04/16.
 */

public class ButtonAdapter extends BaseAdapter {
    private Context context;
    private Integer modeID;
    private List<Object> stdButtonSyms;
    private List<Object> sciButtonSyms;
    private List<Object> octButtonSyms;
    private List<Object> hexButtonSyms;
    private List<Object> symList;

    public void setModeID(Integer modeID) {
        this.modeID = modeID;
    }

    public ButtonAdapter(Context mContext) {
        this.context = mContext;
        modeID = R.integer.STD_MODE;

        stdButtonSyms = new ArrayList<Object>(
                Arrays.asList(
                       "(",")","del", "/", "7","8","9","*","4","5","6","-","1","2","3","+","+/-","0",".","=")
        );
        sciButtonSyms = new ArrayList<Object>(
                Arrays.asList(
                        "(",")","C", "del","pi","e","%","|x|","e^x","x^2","x^n","x!","ln","log",
                        "log2","sqrt","sin","cos","tan", "1/x")
        );
        octButtonSyms = new ArrayList<Object>(
                Arrays.asList(
                        "(",")","del", "/","7","hex","dec"
                        ,"*","4","5","6","-","1","2","3","+","+/-","0",".","=")
        );
        hexButtonSyms = new ArrayList<Object>(
                Arrays.asList("(",")","del", "/", "E","F", "oct","dec", "A","B","C","D","7",
                        "8","9","*","4","5","6","-","+/-","0",".","=")
        );
        symList = stdButtonSyms;
    }

    @Override
    public int getCount() {
        return symList.size();
    }

    @Override
    public Object getItem(int position) {
        return symList.get(position);
    }

    @Override
    public long getItemId(int position) {
        if (symList.get(position) instanceof Integer)
            return (long) symList.get(position);
        else return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        List<Object> symList;
        if (this.modeID == R.integer.STD_MODE) {
            symList = stdButtonSyms;
        } else if (modeID == R.integer.SCI_MODE) {
            symList = sciButtonSyms;
        } else if (modeID == R.integer.OCT_MODE){
            symList = octButtonSyms;
        } else if (modeID == R.integer.HEX_MODE) {
            symList = hexButtonSyms;
        } else symList = stdButtonSyms;

        if (symList.get(position) instanceof Integer) {
            ImageButton imButton;
            if (convertView == null) {
                imButton = new ImageButton(context);
                //button.setLayoutParams(new GridView.LayoutParams(85, 85));
                imButton.setPadding(1, 1, 1, 1);
            } else {
                imButton = (ImageButton) convertView;
            }

            imButton.setImageResource((Integer)symList.get(position));
            return imButton;
        } else {
            Button textButton;
            if (convertView == null) {
                textButton = new Button(context);
                //button.setLayoutParams(new GridView.LayoutParams(85, 85));
                textButton.setPadding(1, 1, 1, 1);
            } else {
                textButton = (Button) convertView;
            }
            textButton.setText((String)symList.get(position));
        return textButton;
        }
    }

}
