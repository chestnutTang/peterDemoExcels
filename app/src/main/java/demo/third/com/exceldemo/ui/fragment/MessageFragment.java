package demo.third.com.exceldemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.adapter.MessageAdapter;
import okhttp3.Call;

import static demo.third.com.exceldemo.utils.Link.MESSAGE_LIST;

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
        tvTitle.setText("消息盒子");
        ivBackup.setVisibility(View.GONE);
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
        getMessageList();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.iv_backup)
    public void onViewClicked() {
    }

    private void getMessageList() {
        Map<String, String> map = new HashMap();
        map.put("pageIndex", "1");
        map.put("pageSize", "10");
        OkHttpUtils.post().url(MESSAGE_LIST).params(map)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                Log.e("消息",response);
            }
        });
    }
}
