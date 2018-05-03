package demo.third.com.exceldemo.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.05.03
 *
 * @author songzhengpeng
 * 首页banner的适配器
 */
public class BannerAdapter extends PagerAdapter {

    private List<ImageView> mData;
    private int mChildCount = 0;


    public BannerAdapter(List<ImageView> mData) {
        if (mData == null) {
            this.mData = new ArrayList<>();
        } else {
            this.mData = mData;
        }
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        mChildCount = getCount();
    }

    @Override
    public int getCount() {
        return mData.size() <= 1 ? mData.size() : 1000;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        if (mChildCount > 0) {
            mChildCount--;
            return POSITION_NONE;
        }
        return super.getItemPosition(object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        int pos = position % mData.size();
        ImageView view = mData.get(pos);
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        container.addView(view);
        return view;
    }
}
