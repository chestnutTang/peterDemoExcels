package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import okhttp3.Call;

import static demo.third.com.exceldemo.utils.Link.BYDJJG;

/**
 * @author peter
 * 不予登记机构
 */
public class BydjjgActivity extends BaseActivity {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_telephone)
    TextView tvTelephone;
    @BindView(R.id.tv_email)
    TextView tvEmail;
    @BindView(R.id.tv_address)
    TextView tvAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvTitle.setText(getResources().getString(R.string.txt_no_registration));
        getBydjjg();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bydjjg;
    }

    @OnClick(R.id.iv_backup)
    public void onViewClicked() {
        finish();
    }


    private void getBydjjg() {
        Map<String, String> map = new HashMap();
        map.put("pageIndex", "1");
        map.put("pageSize", "10");
        OkHttpUtils.post().url(BYDJJG).params(map)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                Log.e("erer",response);
            }
        });
    }
}
