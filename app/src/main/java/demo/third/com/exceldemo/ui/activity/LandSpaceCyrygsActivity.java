package demo.third.com.exceldemo.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.SearchResultEntity;
import demo.third.com.exceldemo.ui.adapter.LandSpaceAdapter;
import demo.third.com.exceldemo.ui.views.HorizontalListView;
import demo.third.com.exceldemo.ui.views.MyListView;
import demo.third.com.exceldemo.ui.views.RadioGroupEx;
import demo.third.com.exceldemo.utils.CustomGson;
import demo.third.com.exceldemo.utils.Tools;
import okhttp3.Call;

import static demo.third.com.exceldemo.utils.Constant.INTENT_FLAG;
import static demo.third.com.exceldemo.utils.Link.CYJGGS;
import static demo.third.com.exceldemo.utils.Link.SEARCH;
import static demo.third.com.exceldemo.utils.Link.SEARCHPERSON;

/**
 * @author peter
 * 从业人员公示
 */
public class LandSpaceCyrygsActivity extends BaseActivity implements RadioGroupEx
        .OnCheckedChangeListener {


    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_2)
    TextView tv2;
    @BindView(R.id.tv_3)
    TextView tv3;
    @BindView(R.id.tv_4)
    TextView tv4;
    @BindView(R.id.tv_5)
    TextView tv5;
    @BindView(R.id.tv_6)
    TextView tv6;
    @BindView(R.id.tv_7)
    TextView tv7;
    @BindView(R.id.ll_red2)
    LinearLayout llRed2;
    @BindView(R.id.lv_private_fund)
    HorizontalListView lvPrivateFund;
    @BindView(R.id.sp_jglb)
    Spinner sp_jglb;
    @BindView(R.id.sp_jglb2)
    Spinner sp_jglb2;
    @BindView(R.id.et_pro_name)
    EditText et_pro_name;
    private SearchResultEntity searchResultEntity;
    private SearchResultEntity.ResultBean resultBean;
    private LandSpaceAdapter infoAdapter;
    private String flag;
    private ProgressDialog progressDialog;
    private String jglb, cxtj;
    private String[] jglbArray = {"OTC_ID_01", "OTC_ID_02", "OTC_ID_03", "OTC_ID_04",
            "OTC_ID_05", "OTC_ID_06", "OTC_ID_07", "OTC_ID_08"
            , "OTC_ID_101", "OTC_ID_121", "OTC_ID_141", "OTC_ID_15", "OTC_ID_16", "OTC_ID_161",
            "OTC_ID_17", "OTC_ID_181", "OTC_ID_182", "OTC_ID_183"
            , "OTC_ID_19", "OTC_ID_20", "OTC_ID_201", "OTC_ID_22", "OTC_ID_221", "OTC_ID_241",
            "OTC_ID_99"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        progressDialog = initDialog(progressDialog, LandSpaceCyrygsActivity.this, "查询中...");
    }

    @Override
    protected void initView() {
        super.initView();
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.jglb, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_item);

        // 设置Spinner数据来源适配器
        sp_jglb.setAdapter(adapter);
        // 使用内部类形式来实现事件监听
        sp_jglb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                /*
                 * 第一个参数parent是你当前所操作的Spinner，可根据parent.getId()与R.id.
                 * currentSpinner是否相等，来判断是否你当前操作的Spinner,一般在onItemSelected
                 * 方法中用switch语句来解决多个Spinner问题。
                 * 第二个参数view一般不用到；
                 * 第三个参数position表示下拉中选中的选项位置，自上而下从0开始；
                 * 第四个参数id表示的意义与第三个参数相同。
                 */

                //对选中项进行显示
                //Toast用于临时信息的显示
                //第一个参数是上下文环境，可用this；
                //第二个参数是要显示的字符串；
                //第三个参数是显示的时间长短；
//                jglb = parent.getItemAtPosition(position).toString();
                jglb = jglbArray[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });

        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,
                R.array.sp_condition, R.layout.spinner_item);
        adapter2.setDropDownViewResource(R.layout.spinner_item);

        // 设置Spinner数据来源适配器
        sp_jglb2.setAdapter(adapter2);
        sp_jglb2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                cxtj = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });

        flag = getIntent().getStringExtra(INTENT_FLAG);
        if (!TextUtils.isEmpty(flag)) {
            tvTitle.setText(flag);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_landspace_cyrygs;
    }

    @OnClick({R.id.iv_backup, R.id.tv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
            case R.id.tv_search:
                searchZqgszgcp(et_pro_name.getText().toString(), jglb);
                break;
            default:
                break;
        }
    }


    private void searchZqgszgcp(String name, String type) {
        if (progressDialog != null) {
            progressDialog.show();
        }
        Map<String, String> params = new HashMap<>();
        params.put("pageIndex", "1");
        params.put("pageSize", "10");
        if (!TextUtils.isEmpty(name)) {
            params.put("name", name);
        }
        if (!TextUtils.isEmpty(type)) {
            params.put("type", type);
        }
        OkHttpUtils.post().url(SEARCHPERSON).params(params)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                if (progressDialog != null) {
                    progressDialog.cancel();
                }
            }

            @Override
            public void onResponse(String response, int id) {
                searchResultEntity = CustomGson.fromJson(response, SearchResultEntity.class);
                if (searchResultEntity != null) {
                    resultBean = searchResultEntity.getResult();
                    infoAdapter = new LandSpaceAdapter(LandSpaceCyrygsActivity.this, resultBean,
                            flag);
                    lvPrivateFund.setAdapter(infoAdapter);
                    try {
                        if (resultBean.getPofSubfunds() == null || resultBean.getPofSubfunds()
                                .getList() == null
                                || resultBean.getPofSubfunds().getList().size() == 0) {
                            Tools.toast("暂无符合当前筛选条件的结果");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Tools.toast("暂无符合当前筛选条件的结果");
                    }
                    if (progressDialog != null) {
                        progressDialog.cancel();
                    }
                }
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroupEx group, int checkedId) {
        RadioButton radioButton = findViewById(group.getCheckedRadioButtonId());
        switch (checkedId) {
            // 基金规模
            case R.id.rg_jjgm:
                break;
            // 提示事项
            case R.id.rg_tssx:
                break;
            // 诚信信息
            case R.id.rg_cxxx:
                break;
            default:
                break;
        }
    }
}
