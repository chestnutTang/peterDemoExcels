package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.BlackListEntity;
import demo.third.com.exceldemo.ui.adapter.PrivateProductsAdapter;
import demo.third.com.exceldemo.utils.CustomGson;
import demo.third.com.exceldemo.utils.JumpTools;
import okhttp3.Call;

import static demo.third.com.exceldemo.utils.Link.SEARCHZQGS;

/**
 * 证券公司私募产品备案确认函
 */
public class PrivateProductsActivity extends BaseActivity {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.lv_private_products)
    ListView lvPrivateProducts;

    private PrivateProductsAdapter productsAdapter;
    private BlackListEntity blackListEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        search("");
    }

    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText(getResources().getString(R.string.txt_private_products_enter));
        lvPrivateProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (blackListEntity != null) {
                    JumpTools.jumpWithUrl(PrivateProductsActivity.this, MyWebActivity.class
                            , blackListEntity.getResult().getData().getList().get(position).getContent()
                            , blackListEntity.getResult().getData().getList().get(position).getTitle());
                }
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_private_products;
    }

    @OnClick(R.id.iv_backup)
    public void onViewClicked() {
        finish();
    }

    @Override
    protected void search(String workingState) {
        Map<String, String> params = new HashMap<>();
        params.put("pageIndex", "1");
        params.put("pageSize", "50");
        OkHttpUtils.get().url(SEARCHZQGS).params(params)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                blackListEntity = CustomGson.fromJson(response, BlackListEntity.class);
                if (blackListEntity != null) {
                    productsAdapter = new PrivateProductsAdapter(PrivateProductsActivity.this, blackListEntity);
                    lvPrivateProducts.setAdapter(productsAdapter);
                }
            }
        });
    }
}
