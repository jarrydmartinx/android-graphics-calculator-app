package comp6442.comp6442_assignment_2_2016.layout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;

/**
 * Created by jarryd on 30/04/16.
 */
public class ButtonAdapter extends BaseAdapter {
    private Context context;

    public ButtonAdapter(Context context, String buttonMode) {
    }

    public ButtonAdapter() {
        super();
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageButton button;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            button = new ImageButton(context);
            //button.setLayoutParams(new GridView.LayoutParams(85, 85));
            button.setPadding(1, 1, 1, 1);
        } else {
            button = (ImageButton) convertView;
        }

        button.setImageResource(buttonIds[position]);
        return button;
    }


    private Integer[] buttonIds = {
        R.drawable.sample_2, R.drawable.sample_3,
        R.drawable.sample_4, R.drawable.sample_5,
        R.drawable.sample_6, R.drawable.sample_7,
        R.drawable.sample_0, R.drawable.sample_1,
        R.drawable.sample_2, R.drawable.sample_3,
        R.drawable.sample_4, R.drawable.sample_5,
        R.drawable.sample_6, R.drawable.sample_7,
        R.drawable.sample_0, R.drawable.sample_1,
        R.drawable.sample_2, R.drawable.sample_3,
        R.drawable.sample_4, R.drawable.sample_5,
        R.drawable.sample_6, R.drawable.sample_7
    };

}
