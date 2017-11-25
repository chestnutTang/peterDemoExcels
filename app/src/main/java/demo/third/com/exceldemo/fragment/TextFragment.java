package demo.third.com.exceldemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.plus.PlusOneButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.third.com.exceldemo.R;

/**
 * Created by peter on 2017/11/25.
 */

public class TextFragment extends BaseFragment {
    @BindView(R.id.text_show)
    TextView textShow;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setTextShow(String str) {
        textShow.setText(str);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_plus_one;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
