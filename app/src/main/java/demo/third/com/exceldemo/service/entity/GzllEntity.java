package demo.third.com.exceldemo.service.entity;

import java.util.List;

public class GzllEntity {

    private List<GoodBean> good;

    public List<GoodBean> getGood() {
        return good;
    }

    public void setGood(List<GoodBean> good) {
        this.good = good;
    }

    public static class GoodBean {
        /**
         * 时间 : 2014.04 - 2017.06
         * 任职单位 : 歌斐资产管理有限公司
         * 职务 : CEO
         */

        private String 时间;
        private String 任职单位;
        private String 职务;

        public String get时间() {
            return 时间;
        }

        public void set时间(String 时间) {
            this.时间 = 时间;
        }

        public String get任职单位() {
            return 任职单位;
        }

        public void set任职单位(String 任职单位) {
            this.任职单位 = 任职单位;
        }

        public String get职务() {
            return 职务;
        }

        public void set职务(String 职务) {
            this.职务 = 职务;
        }
    }
}
