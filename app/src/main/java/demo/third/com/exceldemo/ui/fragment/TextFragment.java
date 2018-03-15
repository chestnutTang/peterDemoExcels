package demo.third.com.exceldemo.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.views.CircleImageViewGlide;

/**
 * Created by peter on 2017/11/25.
 */

public class TextFragment extends BaseFragment {
    @BindView(R.id.text_show)
    TextView textShow;
    @BindView(R.id.head_iv)
    ImageView headIv;
    Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(getLayoutId(), container, false);
            unbinder = ButterKnife.bind(this, view);
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        RequestOptions options = new RequestOptions().transform(new CircleImageViewGlide());
//        options.diskCacheStrategy(DiskCacheStrategy.NONE);//不设置缓存
        Glide.with(view).load(R.mipmap.ic_future).apply(options).into(headIv);
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void setTextShow(Context context, final String str) {
        ((Activity) context).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textShow.setText(str);
            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_plus_one;
    }

    @Override
    protected void bindListener() {

    }

}
