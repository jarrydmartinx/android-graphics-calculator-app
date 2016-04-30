package comp6442.comp6442_assignment_2_2016.layoutClasses;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by jarryd on 29/04/16.
 */
public class ExpHistAdapter extends ArrayAdapter<String> {


/**
 * Created by jarryd on 29/04/16.
 * <p/>
 * A custom Adapter that extends the ArrayAdapter class. The Adapter is backed by the data model,
 * an ArrayList of Strings, and feeds TextViews
 * to the ListView UI element in ExpHistFrag.
 */


    /**
     * The context of the instantiated Adapter
     */
    private final Context context;
    /**
     * The data model, all the existing notes loaded from storage
     */
    private ArrayList<String> expHistArray;
    private Resources res;
    /**
     * The id of the parent layout
     */
    private int layout_id;
    /**
     * The device display
     */
    private Display display;
    /**
     * Holds info about the device display
     */
    private DisplayMetrics metrics;

    /**
     * Constructor for the Adapter
     *
     * @param context
     * @param layout_id
     * @param expHistArray
     */
    public ExpHistAdapter(Context context, int layout_id, ArrayList<String> expHistArray) {
        super(context, layout_id, expHistArray);
        this.context = context;
        this.layout_id = layout_id;
        this.expHistArray = expHistArray;
        res = context.getResources();
    }

    /**
     * Called when the Adapter refreshes a view element in the GridView object
     *
     * @param position          the position of the item in the Adapter
     * @param convertView       a previously used View object for possible recycling
     * @param parent            the parent ViewGroup
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView mTextView;
        if (convertView == null) {
            mTextView = new TextView(context);
        } else {
            mTextView = (TextView) convertView;
        }
        mTextView.setText(expHistArray.get(position));
        mTextView.setGravity(Gravity.END);
        mTextView.setTextSize(16);
        return mTextView;
    }

}
