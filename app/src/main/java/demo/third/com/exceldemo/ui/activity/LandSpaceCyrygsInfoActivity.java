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

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.CyrygsEntity;
import demo.third.com.exceldemo.ui.adapter.LandSpaceCyrygsAdapter;
import demo.third.com.exceldemo.ui.views.MyListView;
import demo.third.com.exceldemo.ui.views.RadioGroupEx;
import demo.third.com.exceldemo.utils.CustomGson;
import demo.third.com.exceldemo.utils.Tools;
import okhttp3.Call;

import static demo.third.com.exceldemo.utils.Constant.INTENT_FLAG;
import static demo.third.com.exceldemo.utils.Link.SEARCHPERSON;
import static demo.third.com.exceldemo.utils.Link.SEARCHPERSONRPI;

/**
 * @author peter
 * 从业人员公示人员信息
 */
public class LandSpaceCyrygsInfoActivity extends BaseActivity implements RadioGroupEx
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
    MyListView lvPrivateFund;
    @BindView(R.id.sp_jglb)
    Spinner sp_jglb;
    @BindView(R.id.sp_jglb2)
    Spinner sp_jglb2;
    @BindView(R.id.et_pro_name)
    EditText et_pro_name;

    private LandSpaceCyrygsAdapter infoAdapter;
    private String flag;
    private ProgressDialog progressDialog;
    private CyrygsEntity cyrygsEntity;
    private CyrygsEntity.ResultBean resultBean;
    private String aoiName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        progressDialog = initDialog(progressDialog, LandSpaceCyrygsInfoActivity.this, "查询中...");
    }

    @Override
    protected void initView() {
        super.initView();
        aoiName = getIntent().getStringExtra(INTENT_FLAG);
        flag = getIntent().getStringExtra(INTENT_FLAG);
        if (!TextUtils.isEmpty(flag)) {
            tvTitle.setText(flag);
        }
//        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
//                R.array.jglb, R.layout.spinner_item);
//        adapter.setDropDownViewResource(R.layout.spinner_item);
//
//        // 设置Spinner数据来源适配器
//        sp_jglb.setAdapter(adapter);
//        // 使用内部类形式来实现事件监听
//        sp_jglb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view,
//                                       int position, long id) {
//                /*
//                 * 第一个参数parent是你当前所操作的Spinner，可根据parent.getId()与R.id.
//                 * currentSpinner是否相等，来判断是否你当前操作的Spinner,一般在onItemSelected
//                 * 方法中用switch语句来解决多个Spinner问题。
//                 * 第二个参数view一般不用到；
//                 * 第三个参数position表示下拉中选中的选项位置，自上而下从0开始；
//                 * 第四个参数id表示的意义与第三个参数相同。
//                 */
//
//                //对选中项进行显示
//                //Toast用于临时信息的显示
//                //第一个参数是上下文环境，可用this；
//                //第二个参数是要显示的字符串；
//                //第三个参数是显示的时间长短；
////                jglb = parent.getItemAtPosition(position).toString();
//                jglb = jglbArray[position];
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                // TODO Auto-generated method stub
//
//            }
//        });
//
//        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,
//                R.array.sp_condition, R.layout.spinner_item);
//        adapter2.setDropDownViewResource(R.layout.spinner_item);
//
//        // 设置Spinner数据来源适配器
//        sp_jglb2.setAdapter(adapter2);
//        sp_jglb2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view,
//                                       int position, long id) {
//                cxtj = parent.getItemAtPosition(position).toString();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                // TODO Auto-generated method stub
//
//            }
//        });
//

        lvPrivateFund.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getCyryInfo(resultBean.getData().getList().get(position).getAoiName());
            }
        });
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_cyrygs_info;
    }

    @OnClick({R.id.iv_backup, R.id.tv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
            case R.id.tv_search:
//                searchZqgszgcp(et_pro_name.getText().toString(), jglb);
                break;
            default:
                break;
        }
    }

    private void getCyryInfo(String aoiName) {
        OkHttpUtils.post().url(SEARCHPERSONRPI).addParams("aoiName", aoiName)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {

            }
        });
    }


    private void searchZqgszgcp(String name, String type) {
        if (progressDialog != null) {
            progressDialog.show();
        }
        Map<String, String> params = new HashMap<>();
        params.put("pageIndex", "1");
        params.put("pageSize", "20");
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
                cyrygsEntity = CustomGson.fromJson(response, CyrygsEntity.class);
                if (cyrygsEntity != null) {
                    resultBean = cyrygsEntity.getResult();
                    infoAdapter = new LandSpaceCyrygsAdapter(LandSpaceCyrygsInfoActivity.this,
                            resultBean, flag);
                    lvPrivateFund.setAdapter(infoAdapter);
                    try {
                        if (resultBean == null || resultBean.getData() == null
                                || resultBean.getData().getList() == null
                                || resultBean.getData().getList().size() == 0) {
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
