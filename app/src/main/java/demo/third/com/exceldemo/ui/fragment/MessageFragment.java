package demo.third.com.exceldemo.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.adapter.MessageAdapter;

/**
 * @author peter
 * 消息页面
 */
public class MessageFragment extends BaseFragment {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.lv_message)
    ListView lvMessage;
    Unbinder unbinder;
    @BindView(R.id.rg_sort)
    RadioGroup rgSort;
    @BindView(R.id.ll_message)
    LinearLayout llMessage;

    private MessageAdapter messageAdapter;
    private List<Integer> listData = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_message;
    }

    @Override
    protected void bindListener() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        llMessage.setBackgroundColor(Color.parseColor("#f2f2f2"));
        tvTitle.setText("消息盒子");
        ivBackup.setVisibility(View.GONE);
        rgSort.setVisibility(View.GONE);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (listData != null) {
            listData.add(1);
//            listData.add(1);
//            listData.add(1);
//            listData.add(1);
//            listData.add(1);
//            listData.add(1);
        }

        messageAdapter = new MessageAdapter(getActivity(), listData);
        lvMessage.setAdapter(messageAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.iv_backup)
    public void onViewClicked() {
    }
}
