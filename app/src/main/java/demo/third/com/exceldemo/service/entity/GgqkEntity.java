package demo.third.com.exceldemo.service.entity;

import java.util.List;

/**
 * 高管情况
 */
public class GgqkEntity {

    private List<GgqkBean> ggqk;

    public List<GgqkBean> getGgqk() {
        return ggqk;
    }

    public void setGgqk(List<GgqkBean> ggqk) {
        this.ggqk = ggqk;
    }

    public static class GgqkBean {
        /**
         * 是否具有基金从业资格 : 是(资格认定)
         * 职务 : 法定代表人 总经理 执行董事
         * 高管姓名 : 杨晓华
         */

        private String 是否具有基金从业资格;
        private String 职务;
        private String 高管姓名;

        public String get是否具有基金从业资格() {
            return 是否具有基金从业资格;
        }

        public void set是否具有基金从业资格(String 是否具有基金从业资格) {
            this.是否具有基金从业资格 = 是否具有基金从业资格;
        }

        public String get职务() {
            return 职务;
        }

        public void set职务(String 职务) {
            this.职务 = 职务;
        }

        public String get高管姓名() {
            return 高管姓名;
        }

        public void set高管姓名(String 高管姓名) {
            this.高管姓名 = 高管姓名;
        }
    }
}
