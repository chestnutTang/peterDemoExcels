package demo.third.com.exceldemo.service.entity;

import java.util.List;

/**
 * 从业人员公示信息详情
 */
public class CyrygsInfoEntity {

    /**
     * code : 0
     * message : success
     * result : {"list":[{"id":12699431,"rpi_ID":12699431,"aoi_NAME":"龙芯中科基金管理（广州）有限公司","eco_NAME":"本科","pti_NAME":"基金从业资格","cti_NAME":"一般从业资格","cer_NUM":"P1066124100003","ppp_GET_DATE":"2018-06-24","ppp_END_DATE":"2020-12-31","countcer":1,"countcx":null,"rpi_NAME":"常颖杰","sco_NAME":"男"},{"id":12733532,"rpi_ID":12733532,"aoi_NAME":"龙芯中科基金管理（广州）有限公司","eco_NAME":"硕士研究生","pti_NAME":"基金从业资格","cti_NAME":"一般从业资格","cer_NUM":"P1068738100001","ppp_GET_DATE":"2018-08-06","ppp_END_DATE":"2020-12-31","countcer":1,"countcx":null,"rpi_NAME":"马锦豪","sco_NAME":"男"}]}
     */

    private int code;
    private String message;
    private ResultBean result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 12699431
             * rpi_ID : 12699431
             * aoi_NAME : 龙芯中科基金管理（广州）有限公司
             * eco_NAME : 本科
             * pti_NAME : 基金从业资格
             * cti_NAME : 一般从业资格
             * cer_NUM : P1066124100003
             * ppp_GET_DATE : 2018-06-24
             * ppp_END_DATE : 2020-12-31
             * countcer : 1
             * countcx : null
             * rpi_NAME : 常颖杰
             * sco_NAME : 男
             */

            private int id;
            private int rpi_ID;
            private String aoi_NAME;
            private String eco_NAME;
            private String pti_NAME;
            private String cti_NAME;
            private String cer_NUM;
            private String ppp_GET_DATE;
            private String ppp_END_DATE;
            private int countcer;
            private Object countcx;
            private String rpi_NAME;
            private String sco_NAME;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getRpi_ID() {
                return rpi_ID;
            }

            public void setRpi_ID(int rpi_ID) {
                this.rpi_ID = rpi_ID;
            }

            public String getAoi_NAME() {
                return aoi_NAME;
            }

            public void setAoi_NAME(String aoi_NAME) {
                this.aoi_NAME = aoi_NAME;
            }

            public String getEco_NAME() {
                return eco_NAME;
            }

            public void setEco_NAME(String eco_NAME) {
                this.eco_NAME = eco_NAME;
            }

            public String getPti_NAME() {
                return pti_NAME;
            }

            public void setPti_NAME(String pti_NAME) {
                this.pti_NAME = pti_NAME;
            }

            public String getCti_NAME() {
                return cti_NAME;
            }

            public void setCti_NAME(String cti_NAME) {
                this.cti_NAME = cti_NAME;
            }

            public String getCer_NUM() {
                return cer_NUM;
            }

            public void setCer_NUM(String cer_NUM) {
                this.cer_NUM = cer_NUM;
            }

            public String getPpp_GET_DATE() {
                return ppp_GET_DATE;
            }

            public void setPpp_GET_DATE(String ppp_GET_DATE) {
                this.ppp_GET_DATE = ppp_GET_DATE;
            }

            public String getPpp_END_DATE() {
                return ppp_END_DATE;
            }

            public void setPpp_END_DATE(String ppp_END_DATE) {
                this.ppp_END_DATE = ppp_END_DATE;
            }

            public int getCountcer() {
                return countcer;
            }

            public void setCountcer(int countcer) {
                this.countcer = countcer;
            }

            public Object getCountcx() {
                return countcx;
            }

            public void setCountcx(Object countcx) {
                this.countcx = countcx;
            }

            public String getRpi_NAME() {
                return rpi_NAME;
            }

            public void setRpi_NAME(String rpi_NAME) {
                this.rpi_NAME = rpi_NAME;
            }

            public String getSco_NAME() {
                return sco_NAME;
            }

            public void setSco_NAME(String sco_NAME) {
                this.sco_NAME = sco_NAME;
            }
        }
    }
}
