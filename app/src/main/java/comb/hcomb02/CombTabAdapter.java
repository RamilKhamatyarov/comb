package comb.hcomb02;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
        ImageView imageView;
        if (view == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8 );
        } else {
            imageView = (ImageView) view;
        }
        imageView.setImageResource(mThumbs[i]);
        return imageView;
    }

    //Reference to our tabs
    private Integer[] mThumbs = {R.mipmap.plus};
}
