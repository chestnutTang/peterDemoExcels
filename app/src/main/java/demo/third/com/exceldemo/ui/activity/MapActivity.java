package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.MarkerOptions;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;

/**
 * @author peter
 * 联系我们
 */
public class MapActivity extends BaseActivity {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.map)
    MapView mapView;
    private AMap aMap;
    private MarkerOptions markerOption;
    private LatLng latlng = new LatLng(116.638973,39.905458);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mapView.onCreate(savedInstanceState);// 此方法必须重写
        initView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_map;
    }

    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText(getResources().getString(R.string.title_lxdz));
        if (aMap == null) {
            aMap = mapView.getMap();
            addMarkersToMap();// 往地图上添加marker
            aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng,18));
//            aMap.moveCamera(CameraUpdateFactory.changeLatLng(latlng));
        }
    }

    /**
     * 在地图上添加marker
     */
    private void addMarkersToMap() {
        markerOption = new MarkerOptions().icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .position(latlng)
                .draggable(true);
        aMap.addMarker(markerOption);
    }

    @OnClick(R.id.iv_backup)
    public void onViewClicked() {
        finish();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}
