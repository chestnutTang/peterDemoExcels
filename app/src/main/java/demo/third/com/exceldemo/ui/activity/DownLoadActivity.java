package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.adapter.DownloadAdapter;

/**
 * @author songzhengpeng
 * 下载
 */
public class DownLoadActivity extends BaseActivity {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.lv_download)
    ListView lvDownload;
    private List<String> listResult = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText(getResources().getString(R.string.action_download));
        if (listResult != null) {
            listResult.add("黑名单：刘全志、李书亭、赵杰、曹海兵兵#2016-04-15");
            listResult.add("黑名单：郑小龙、赵亚光#2016-04-15");
            listResult.add("黑名单：吕锋、陈建中#2016-04-15");
            listResult.add("黑名单：高培峰#2015-01-20");
            listResult.add("黑名单：中财鼎盛（北京）投资基金管理有限公司#2015-01-20");
            listResult.add("黑名单：唐群雁、隋欣#2015-01-20");
            listResult.add("黑名单：北京中益汇金投资基金管理有限公司、北京中农德金汇金投资基金管理有限公司、北京中农德金汇金投资基金管理有限公司、北京中农德金投资基金管理有限责任公司、北京中#2015-01-20");
            listResult.add("黑名单：李志刚、周建国#2014-12-05");
        }
        DownloadAdapter blackListAdapter = new DownloadAdapter(DownLoadActivity.this, listResult);
        lvDownload.setAdapter(blackListAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_down_load;
    }

    @OnClick(R.id.iv_backup)
    public void onViewClicked() {
        finish();
    }
}