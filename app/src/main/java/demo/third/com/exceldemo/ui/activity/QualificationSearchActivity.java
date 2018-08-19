package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.adapter.QualificationSearchAdapter;
import demo.third.com.exceldemo.ui.views.MyListView;
import okhttp3.Call;

import static demo.third.com.exceldemo.utils.Link.EXAMQUERY;

/**
 * @author peter
 * 从业资格考试成绩查询
 */
public class QualificationSearchActivity extends BaseActivity {
    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.rl_btn_search)
    RelativeLayout rlBtnSearch;
    @BindView(R.id.lv_qualification_search)
    MyListView lvQualificationSearch;


    private QualificationSearchAdapter searchAdapter;
    private List<String> listResult = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText(getResources().getString(R.string.txt_qualification_search));
        if (listResult != null) {
            listResult.add(getResources().getString(R.string.txt_test_time));
            listResult.add(getResources().getString(R.string.txt_test_subject));
            listResult.add(getResources().getString(R.string.txt_test_result));
            listResult.add(getResources().getString(R.string.txt_is_adopt));
            listResult.add(getResources().getString(R.string.txt_test_print));
        }
        searchAdapter = new QualificationSearchAdapter(QualificationSearchActivity.this, listResult);
        lvQualificationSearch.setAdapter(searchAdapter);
    }

    @Override
    protected void search(String searchCondition) {
        super.search(searchCondition);
        OkHttpUtils.post().url(EXAMQUERY)
                .addParams("code", searchCondition)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {

            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_qualification_search;
    }

    @OnClick({R.id.iv_backup, R.id.rl_btn_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
            case R.id.rl_btn_search:
                search(etSearch.getText().toString());
                break;
            default:
                break;
        }
    }
}
