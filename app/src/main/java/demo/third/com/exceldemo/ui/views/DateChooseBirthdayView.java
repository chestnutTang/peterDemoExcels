package demo.third.com.exceldemo.ui.views;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;


import java.util.Calendar;

import demo.third.com.exceldemo.R;
import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.ArrayWheelAdapter;
import kankan.wheel.widget.adapters.NumericWheelAdapter;

/**
 * Created by wangfengchen on 16/7/12.
 * 时间选择view
 */
public class DateChooseBirthdayView extends FrameLayout implements View.OnClickListener {

    LayoutInflater mLayoutInflater;

    WheelView mMonthView;
    WheelView mYearView;
    WheelView mDayView;
    static int mDefaultTime;
    Context mContext;

    View cancelBtn, determineBtn;

    private TimeChooseCallback timeChooseCallback;

    private static int yearLeft = 20, yearRight = 20;

    private int yearStart = 0;
    private String[] months;

    public static DateChooseBirthdayView create(Context context, int yl, int yr, int defaultTime) {
        yearLeft = yl;
        yearRight = yr;
        mDefaultTime = defaultTime;
        return new DateChooseBirthdayView(context);
    }

    private DateChooseBirthdayView(Context context) {
        super(context);
        mContext = context;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        initView();
        init();
    }

    void initView() {
        View view = mLayoutInflater.inflate(R.layout.birthday_layout_date_choose, this, false);
        mMonthView = (WheelView) view.findViewById(R.id.month);
        mYearView = (WheelView) view.findViewById(R.id.year);
        mDayView = (WheelView) view.findViewById(R.id.day);
        cancelBtn = view.findViewById(R.id.ltc_cancel_btn);
        cancelBtn.setOnClickListener(this);
        determineBtn = view.findViewById(R.id.ltc_datermine_btn);
        determineBtn.setOnClickListener(this);
        addView(view);
    }

    void init() {
        Calendar calendar = Calendar.getInstance();
        OnWheelChangedListener listener = new OnWheelChangedListener() {
            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                updateDays(mYearView, mMonthView, mDayView);
            }
        };

        // month
        int curMonth = calendar.get(Calendar.MONTH);
        months = new String[]{"01", "02", "03", "04", "05",
                "06", "07", "08", "09", "10", "11", "12"};
        mMonthView.setViewAdapter(new DateArrayAdapter(mContext, months, curMonth));
        mMonthView.setCurrentItem(curMonth);
        mMonthView.addChangingListener(listener);

        // year
        int curYear = calendar.get(Calendar.YEAR);
        yearStart = curYear - yearLeft;
        mYearView.setViewAdapter(new DateNumericAdapter(mContext, yearStart,
                curYear + yearRight, yearLeft));
        mYearView.setCurrentItem(mDefaultTime);
        mYearView.addChangingListener(listener);

        // day
        updateDays(mYearView, mMonthView, mDayView);
        mDayView.setCurrentItem(calendar.get(Calendar.DAY_OF_MONTH) - 1);
    }

    /**
     * Updates mDayView wheel. Sets max days according to selected month and year
     */
    void updateDays(WheelView year, WheelView month, WheelView day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.YEAR, yearStart + year.getCurrentItem());
        calendar.set(Calendar.MONTH, month.getCurrentItem());
//        Log.e("huhuhu", "updateDays: " + month.getCurrentItem() + "  " + calendar.get(Calendar.MONTH) + "  " + calendar.getTime() );
        int maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        day.setViewAdapter(new DateNumericAdapter(mContext, 1, maxDays, calendar
                .get(Calendar.DAY_OF_MONTH) - 1));
        int curDay = Math.min(maxDays, day.getCurrentItem() + 1);
        day.setCurrentItem(curDay - 1, true);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ltc_cancel_btn:
                if (timeChooseCallback != null)
                    timeChooseCallback.onDismiss();
                break;
            case R.id.ltc_datermine_btn:
                if (timeChooseCallback != null) {
                    String y = String.valueOf(mYearView.getCurrentItem() + yearStart);
                    String m = months[mMonthView.getCurrentItem()];
                    String d = String.valueOf(mDayView.getCurrentItem() + 1);
                    timeChooseCallback.onDetermine(y, m, d);
                }
                break;
        }
    }

    public void setTimeChooseCallback(TimeChooseCallback timeChooseCallback) {
        this.timeChooseCallback = timeChooseCallback;
    }

    public interface TimeChooseCallback {

        void onDismiss();

        void onDetermine(String y, String m, String d);

    }

    /**
     * Adapter for numeric wheels. Highlights the current value.
     */
    private class DateNumericAdapter extends NumericWheelAdapter {
        // Index of current item
        int currentItem;
        // Index of item to be highlighted
        int currentValue;

        /**
         * Constructor
         */
        public DateNumericAdapter(Context context, int minValue, int maxValue,
                                  int current) {
            super(context, minValue, maxValue);
            this.currentValue = current;
            setTextSize(16);
            // setTextColor(Color.parseColor("#666666"));
        }

        @Override
        protected void configureTextView(TextView view) {
            super.configureTextView(view);
            if (currentItem == currentValue) {
                // view.setTextColor(Color.parseColor("#fb6749"));
            }
            view.setTypeface(Typeface.SANS_SERIF);
        }

        @Override
        public View getItem(int index, View cachedView, ViewGroup parent) {
            currentItem = index;
            return super.getItem(index, cachedView, parent);
        }
    }

    /**
     * Adapter for string based wheel. Highlights the current value.
     */
    private class DateArrayAdapter extends ArrayWheelAdapter<String> {
        // Index of current item
        int currentItem;
        // Index of item to be highlighted
        int currentValue;

        /**
         * Constructor
         */
        public DateArrayAdapter(Context context, String[] items, int current) {
            super(context, items);
            this.currentValue = current;
            setTextSize(16);
            // setTextColor(Color.parseColor("#666666"));
        }

        @Override
        protected void configureTextView(TextView view) {
            super.configureTextView(view);
            if (currentItem == currentValue) {
                // view.setTextColor(Color.parseColor("#fb6749"));
            }
            view.setTypeface(Typeface.SANS_SERIF);
        }

        @Override
        public View getItem(int index, View cachedView, ViewGroup parent) {
            currentItem = index;
            return super.getItem(index, cachedView, parent);
        }
    }


}
