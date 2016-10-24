package comb.hcomb02;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;


/**
 * Created by Asus on 24.10.2016.
 */

public class CombTabAdapter extends BaseAdapter {
    private Context mContext;

    public CombTabAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return mThumbs.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    // Create new CombAdapterView for each item referenced by the adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
//        ImageView imageView;
        Button button;
        if (view == null) {
            // if it's not recycled, initialize some attributes
            button = new Button (mContext);
            button.setBackgroundResource(mThumbs[i]);
            button.setLayoutParams(new GridView.LayoutParams(85, 85));
            button.setPadding(8, 8, 8, 8 );

        } else {
            button = (Button) view;
        }
        button.setBackgroundResource(mThumbs[i]);
        return button;
    }

    //Reference to our tabs
    private Integer[] mThumbs = {R.mipmap.plus};
}
