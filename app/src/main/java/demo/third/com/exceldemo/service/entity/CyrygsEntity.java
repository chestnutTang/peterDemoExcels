package demo.third.com.exceldemo.service.entity;

import java.util.List;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.08.09
 * 从业人员公示
 */
public class CyrygsEntity {

    /**
     * code : 0
     * message : success
     * result : {"data":{"list":[{"id":599002,"aoiName":"鹏扬基金管理有限公司","aoiId":599002,
     * "otc_ID_20":null,"otc_ID_201":null,"otc_ID_22":null,"otc_ID_221":null,"otc_ID_241":null,
     * "otc_ID_99":null,"pti1PERSON":0,"pti2PERSON":0,"pti3PERSON":0,"pti4PERSON":0,
     * "pti6PERSON":0,"pti7PERSON":0,"pti8PERSON":6,"pti9PERSON":6,"pti10PERSON":0,"rnum":46,
     * "otc_ID_01":1,"otc_ID_02":null,"otc_ID_03":null,"otc_ID_04":null,"otc_ID_05":null,
     * "otc_ID_06":null,"otc_ID_07":null,"otc_ID_08":null,"otc_ID_101":null,"otc_ID_121":null,
     * "otc_ID_141":null,"otc_ID_15":null,"otc_ID_16":null,"otc_ID_161":null,"otc_ID_17":null,
     * "otc_ID_181":null,"otc_ID_182":null,"otc_ID_183":null,"otc_ID_19":null,
     * "pr_COUNT_PERSON":88,"pti0PERSON":76},{"id":699014,"aoiName":"鹏华基金管理有限公司","aoiId":699014,
     * "otc_ID_20":null,"otc_ID_201":null,"otc_ID_22":null,"otc_ID_221":null,"otc_ID_241":null,
     * "otc_ID_99":null,"pti1PERSON":0,"pti2PERSON":0,"pti3PERSON":0,"pti4PERSON":0,
     * "pti6PERSON":0,"pti7PERSON":0,"pti8PERSON":42,"pti9PERSON":12,"pti10PERSON":0,"rnum":47,
     * "otc_ID_01":1,"otc_ID_02":null,"otc_ID_03":null,"otc_ID_04":null,"otc_ID_05":null,
     * "otc_ID_06":null,"otc_ID_07":null,"otc_ID_08":null,"otc_ID_101":null,"otc_ID_121":null,
     * "otc_ID_141":null,"otc_ID_15":null,"otc_ID_16":null,"otc_ID_161":null,"otc_ID_17":null,
     * "otc_ID_181":null,"otc_ID_182":null,"otc_ID_183":null,"otc_ID_19":null,
     * "pr_COUNT_PERSON":357,"pti0PERSON":303},{"id":699003,"aoiName":"长盛基金管理有限公司",
     * "aoiId":699003,"otc_ID_20":null,"otc_ID_201":null,"otc_ID_22":null,"otc_ID_221":null,
     * "otc_ID_241":null,"otc_ID_99":null,"pti1PERSON":0,"pti2PERSON":0,"pti3PERSON":0,
     * "pti4PERSON":0,"pti6PERSON":0,"pti7PERSON":0,"pti8PERSON":18,"pti9PERSON":0,
     * "pti10PERSON":0,"rnum":110,"otc_ID_01":1,"otc_ID_02":null,"otc_ID_03":null,
     * "otc_ID_04":null,"otc_ID_05":null,"otc_ID_06":null,"otc_ID_07":null,"otc_ID_08":null,
     * "otc_ID_101":null,"otc_ID_121":null,"otc_ID_141":null,"otc_ID_15":null,"otc_ID_16":null,
     * "otc_ID_161":null,"otc_ID_17":null,"otc_ID_181":null,"otc_ID_182":null,"otc_ID_183":null,
     * "otc_ID_19":null,"pr_COUNT_PERSON":174,"pti0PERSON":156},{"id":699068,
     * "aoiName":"长安基金管理有限公司","aoiId":699068,"otc_ID_20":null,"otc_ID_201":null,"otc_ID_22":null,
     * "otc_ID_221":null,"otc_ID_241":null,"otc_ID_99":null,"pti1PERSON":0,"pti2PERSON":0,
     * "pti3PERSON":0,"pti4PERSON":0,"pti6PERSON":0,"pti7PERSON":0,"pti8PERSON":8,"pti9PERSON":7,
     * "pti10PERSON":0,"rnum":112,"otc_ID_01":1,"otc_ID_02":null,"otc_ID_03":null,
     * "otc_ID_04":null,"otc_ID_05":null,"otc_ID_06":null,"otc_ID_07":null,"otc_ID_08":null,
     * "otc_ID_101":null,"otc_ID_121":null,"otc_ID_141":null,"otc_ID_15":null,"otc_ID_16":null,
     * "otc_ID_161":null,"otc_ID_17":null,"otc_ID_181":null,"otc_ID_182":null,"otc_ID_183":null,
     * "otc_ID_19":null,"pr_COUNT_PERSON":86,"pti0PERSON":71},{"id":699011,
     * "aoiName":"长城基金管理有限公司","aoiId":699011,"otc_ID_20":null,"otc_ID_201":null,"otc_ID_22":null,
     * "otc_ID_221":null,"otc_ID_241":null,"otc_ID_99":null,"pti1PERSON":0,"pti2PERSON":0,
     * "pti3PERSON":0,"pti4PERSON":0,"pti6PERSON":0,"pti7PERSON":0,"pti8PERSON":17,
     * "pti9PERSON":4,"pti10PERSON":0,"rnum":111,"otc_ID_01":1,"otc_ID_02":null,"otc_ID_03":null,
     * "otc_ID_04":null,"otc_ID_05":null,"otc_ID_06":null,"otc_ID_07":null,"otc_ID_08":null,
     * "otc_ID_101":null,"otc_ID_121":null,"otc_ID_141":null,"otc_ID_15":null,"otc_ID_16":null,
     * "otc_ID_161":null,"otc_ID_17":null,"otc_ID_181":null,"otc_ID_182":null,"otc_ID_183":null,
     * "otc_ID_19":null,"pr_COUNT_PERSON":161,"pti0PERSON":140},{"id":699021,
     * "aoiName":"长信基金管理有限责任公司","aoiId":699021,"otc_ID_20":null,"otc_ID_201":null,
     * "otc_ID_22":null,"otc_ID_221":null,"otc_ID_241":null,"otc_ID_99":null,"pti1PERSON":0,
     * "pti2PERSON":0,"pti3PERSON":0,"pti4PERSON":0,"pti6PERSON":0,"pti7PERSON":0,
     * "pti8PERSON":20,"pti9PERSON":8,"pti10PERSON":0,"rnum":109,"otc_ID_01":1,"otc_ID_02":null,
     * "otc_ID_03":null,"otc_ID_04":null,"otc_ID_05":null,"otc_ID_06":null,"otc_ID_07":null,
     * "otc_ID_08":null,"otc_ID_101":null,"otc_ID_121":null,"otc_ID_141":null,"otc_ID_15":null,
     * "otc_ID_16":null,"otc_ID_161":null,"otc_ID_17":null,"otc_ID_181":null,"otc_ID_182":null,
     * "otc_ID_183":null,"otc_ID_19":null,"pr_COUNT_PERSON":211,"pti0PERSON":183},{"id":699007,
     * "aoiName":"银河基金管理有限公司","aoiId":699007,"otc_ID_20":null,"otc_ID_201":null,"otc_ID_22":null,
     * "otc_ID_221":null,"otc_ID_241":null,"otc_ID_99":null,"pti1PERSON":0,"pti2PERSON":0,
     * "pti3PERSON":0,"pti4PERSON":0,"pti6PERSON":0,"pti7PERSON":0,"pti8PERSON":17,
     * "pti9PERSON":2,"pti10PERSON":0,"rnum":21,"otc_ID_01":1,"otc_ID_02":null,"otc_ID_03":null,
     * "otc_ID_04":null,"otc_ID_05":null,"otc_ID_06":null,"otc_ID_07":null,"otc_ID_08":null,
     * "otc_ID_101":null,"otc_ID_121":null,"otc_ID_141":null,"otc_ID_15":null,"otc_ID_16":null,
     * "otc_ID_161":null,"otc_ID_17":null,"otc_ID_181":null,"otc_ID_182":null,"otc_ID_183":null,
     * "otc_ID_19":null,"pr_COUNT_PERSON":147,"pti0PERSON":128},{"id":699016,
     * "aoiName":"银华基金管理股份有限公司","aoiId":699016,"otc_ID_20":null,"otc_ID_201":null,
     * "otc_ID_22":null,"otc_ID_221":null,"otc_ID_241":null,"otc_ID_99":null,"pti1PERSON":0,
     * "pti2PERSON":0,"pti3PERSON":0,"pti4PERSON":0,"pti6PERSON":0,"pti7PERSON":0,
     * "pti8PERSON":45,"pti9PERSON":22,"pti10PERSON":0,"rnum":20,"otc_ID_01":1,"otc_ID_02":null,
     * "otc_ID_03":null,"otc_ID_04":null,"otc_ID_05":null,"otc_ID_06":null,"otc_ID_07":null,
     * "otc_ID_08":null,"otc_ID_101":null,"otc_ID_121":null,"otc_ID_141":null,"otc_ID_15":null,
     * "otc_ID_16":null,"otc_ID_161":null,"otc_ID_17":null,"otc_ID_181":null,"otc_ID_182":null,
     * "otc_ID_183":null,"otc_ID_19":null,"pr_COUNT_PERSON":411,"pti0PERSON":344},{"id":699085,
     * "aoiName":"鑫元基金管理有限公司","aoiId":699085,"otc_ID_20":null,"otc_ID_201":null,"otc_ID_22":null,
     * "otc_ID_221":null,"otc_ID_241":null,"otc_ID_99":null,"pti1PERSON":1,"pti2PERSON":0,
     * "pti3PERSON":0,"pti4PERSON":0,"pti6PERSON":0,"pti7PERSON":0,"pti8PERSON":6,"pti9PERSON":2,
     * "pti10PERSON":0,"rnum":1,"otc_ID_01":1,"otc_ID_02":null,"otc_ID_03":null,"otc_ID_04":null,
     * "otc_ID_05":null,"otc_ID_06":null,"otc_ID_07":null,"otc_ID_08":null,"otc_ID_101":null,
     * "otc_ID_121":null,"otc_ID_141":null,"otc_ID_15":null,"otc_ID_16":null,"otc_ID_161":null,
     * "otc_ID_17":null,"otc_ID_181":null,"otc_ID_182":null,"otc_ID_183":null,"otc_ID_19":null,
     * "pr_COUNT_PERSON":105,"pti0PERSON":96},{"id":699023,"aoiName":"金鹰基金管理有限公司","aoiId":699023,
     * "otc_ID_20":null,"otc_ID_201":null,"otc_ID_22":null,"otc_ID_221":null,"otc_ID_241":null,
     * "otc_ID_99":null,"pti1PERSON":0,"pti2PERSON":0,"pti3PERSON":0,"pti4PERSON":0,
     * "pti6PERSON":0,"pti7PERSON":0,"pti8PERSON":16,"pti9PERSON":6,"pti10PERSON":0,"rnum":59,
     * "otc_ID_01":1,"otc_ID_02":null,"otc_ID_03":null,"otc_ID_04":null,"otc_ID_05":null,
     * "otc_ID_06":null,"otc_ID_07":null,"otc_ID_08":null,"otc_ID_101":null,"otc_ID_121":null,
     * "otc_ID_141":null,"otc_ID_15":null,"otc_ID_16":null,"otc_ID_161":null,"otc_ID_17":null,
     * "otc_ID_181":null,"otc_ID_182":null,"otc_ID_183":null,"otc_ID_19":null,
     * "pr_COUNT_PERSON":154,"pti0PERSON":132}],"page":{"pageSize":10,"pageIndex":1,
     * "totalPageCount":12,"totalCount":118}}}
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
        /**
         * data : {"list":[{"id":599002,"aoiName":"鹏扬基金管理有限公司","aoiId":599002,"otc_ID_20":null,
         * "otc_ID_201":null,"otc_ID_22":null,"otc_ID_221":null,"otc_ID_241":null,
         * "otc_ID_99":null,"pti1PERSON":0,"pti2PERSON":0,"pti3PERSON":0,"pti4PERSON":0,
         * "pti6PERSON":0,"pti7PERSON":0,"pti8PERSON":6,"pti9PERSON":6,"pti10PERSON":0,"rnum":46,
         * "otc_ID_01":1,"otc_ID_02":null,"otc_ID_03":null,"otc_ID_04":null,"otc_ID_05":null,
         * "otc_ID_06":null,"otc_ID_07":null,"otc_ID_08":null,"otc_ID_101":null,
         * "otc_ID_121":null,"otc_ID_141":null,"otc_ID_15":null,"otc_ID_16":null,
         * "otc_ID_161":null,"otc_ID_17":null,"otc_ID_181":null,"otc_ID_182":null,
         * "otc_ID_183":null,"otc_ID_19":null,"pr_COUNT_PERSON":88,"pti0PERSON":76},{"id":699014,
         * "aoiName":"鹏华基金管理有限公司","aoiId":699014,"otc_ID_20":null,"otc_ID_201":null,
         * "otc_ID_22":null,"otc_ID_221":null,"otc_ID_241":null,"otc_ID_99":null,"pti1PERSON":0,
         * "pti2PERSON":0,"pti3PERSON":0,"pti4PERSON":0,"pti6PERSON":0,"pti7PERSON":0,
         * "pti8PERSON":42,"pti9PERSON":12,"pti10PERSON":0,"rnum":47,"otc_ID_01":1,
         * "otc_ID_02":null,"otc_ID_03":null,"otc_ID_04":null,"otc_ID_05":null,"otc_ID_06":null,
         * "otc_ID_07":null,"otc_ID_08":null,"otc_ID_101":null,"otc_ID_121":null,
         * "otc_ID_141":null,"otc_ID_15":null,"otc_ID_16":null,"otc_ID_161":null,
         * "otc_ID_17":null,"otc_ID_181":null,"otc_ID_182":null,"otc_ID_183":null,
         * "otc_ID_19":null,"pr_COUNT_PERSON":357,"pti0PERSON":303},{"id":699003,
         * "aoiName":"长盛基金管理有限公司","aoiId":699003,"otc_ID_20":null,"otc_ID_201":null,
         * "otc_ID_22":null,"otc_ID_221":null,"otc_ID_241":null,"otc_ID_99":null,"pti1PERSON":0,
         * "pti2PERSON":0,"pti3PERSON":0,"pti4PERSON":0,"pti6PERSON":0,"pti7PERSON":0,
         * "pti8PERSON":18,"pti9PERSON":0,"pti10PERSON":0,"rnum":110,"otc_ID_01":1,
         * "otc_ID_02":null,"otc_ID_03":null,"otc_ID_04":null,"otc_ID_05":null,"otc_ID_06":null,
         * "otc_ID_07":null,"otc_ID_08":null,"otc_ID_101":null,"otc_ID_121":null,
         * "otc_ID_141":null,"otc_ID_15":null,"otc_ID_16":null,"otc_ID_161":null,
         * "otc_ID_17":null,"otc_ID_181":null,"otc_ID_182":null,"otc_ID_183":null,
         * "otc_ID_19":null,"pr_COUNT_PERSON":174,"pti0PERSON":156},{"id":699068,
         * "aoiName":"长安基金管理有限公司","aoiId":699068,"otc_ID_20":null,"otc_ID_201":null,
         * "otc_ID_22":null,"otc_ID_221":null,"otc_ID_241":null,"otc_ID_99":null,"pti1PERSON":0,
         * "pti2PERSON":0,"pti3PERSON":0,"pti4PERSON":0,"pti6PERSON":0,"pti7PERSON":0,
         * "pti8PERSON":8,"pti9PERSON":7,"pti10PERSON":0,"rnum":112,"otc_ID_01":1,
         * "otc_ID_02":null,"otc_ID_03":null,"otc_ID_04":null,"otc_ID_05":null,"otc_ID_06":null,
         * "otc_ID_07":null,"otc_ID_08":null,"otc_ID_101":null,"otc_ID_121":null,
         * "otc_ID_141":null,"otc_ID_15":null,"otc_ID_16":null,"otc_ID_161":null,
         * "otc_ID_17":null,"otc_ID_181":null,"otc_ID_182":null,"otc_ID_183":null,
         * "otc_ID_19":null,"pr_COUNT_PERSON":86,"pti0PERSON":71},{"id":699011,
         * "aoiName":"长城基金管理有限公司","aoiId":699011,"otc_ID_20":null,"otc_ID_201":null,
         * "otc_ID_22":null,"otc_ID_221":null,"otc_ID_241":null,"otc_ID_99":null,"pti1PERSON":0,
         * "pti2PERSON":0,"pti3PERSON":0,"pti4PERSON":0,"pti6PERSON":0,"pti7PERSON":0,
         * "pti8PERSON":17,"pti9PERSON":4,"pti10PERSON":0,"rnum":111,"otc_ID_01":1,
         * "otc_ID_02":null,"otc_ID_03":null,"otc_ID_04":null,"otc_ID_05":null,"otc_ID_06":null,
         * "otc_ID_07":null,"otc_ID_08":null,"otc_ID_101":null,"otc_ID_121":null,
         * "otc_ID_141":null,"otc_ID_15":null,"otc_ID_16":null,"otc_ID_161":null,
         * "otc_ID_17":null,"otc_ID_181":null,"otc_ID_182":null,"otc_ID_183":null,
         * "otc_ID_19":null,"pr_COUNT_PERSON":161,"pti0PERSON":140},{"id":699021,
         * "aoiName":"长信基金管理有限责任公司","aoiId":699021,"otc_ID_20":null,"otc_ID_201":null,
         * "otc_ID_22":null,"otc_ID_221":null,"otc_ID_241":null,"otc_ID_99":null,"pti1PERSON":0,
         * "pti2PERSON":0,"pti3PERSON":0,"pti4PERSON":0,"pti6PERSON":0,"pti7PERSON":0,
         * "pti8PERSON":20,"pti9PERSON":8,"pti10PERSON":0,"rnum":109,"otc_ID_01":1,
         * "otc_ID_02":null,"otc_ID_03":null,"otc_ID_04":null,"otc_ID_05":null,"otc_ID_06":null,
         * "otc_ID_07":null,"otc_ID_08":null,"otc_ID_101":null,"otc_ID_121":null,
         * "otc_ID_141":null,"otc_ID_15":null,"otc_ID_16":null,"otc_ID_161":null,
         * "otc_ID_17":null,"otc_ID_181":null,"otc_ID_182":null,"otc_ID_183":null,
         * "otc_ID_19":null,"pr_COUNT_PERSON":211,"pti0PERSON":183},{"id":699007,
         * "aoiName":"银河基金管理有限公司","aoiId":699007,"otc_ID_20":null,"otc_ID_201":null,
         * "otc_ID_22":null,"otc_ID_221":null,"otc_ID_241":null,"otc_ID_99":null,"pti1PERSON":0,
         * "pti2PERSON":0,"pti3PERSON":0,"pti4PERSON":0,"pti6PERSON":0,"pti7PERSON":0,
         * "pti8PERSON":17,"pti9PERSON":2,"pti10PERSON":0,"rnum":21,"otc_ID_01":1,
         * "otc_ID_02":null,"otc_ID_03":null,"otc_ID_04":null,"otc_ID_05":null,"otc_ID_06":null,
         * "otc_ID_07":null,"otc_ID_08":null,"otc_ID_101":null,"otc_ID_121":null,
         * "otc_ID_141":null,"otc_ID_15":null,"otc_ID_16":null,"otc_ID_161":null,
         * "otc_ID_17":null,"otc_ID_181":null,"otc_ID_182":null,"otc_ID_183":null,
         * "otc_ID_19":null,"pr_COUNT_PERSON":147,"pti0PERSON":128},{"id":699016,
         * "aoiName":"银华基金管理股份有限公司","aoiId":699016,"otc_ID_20":null,"otc_ID_201":null,
         * "otc_ID_22":null,"otc_ID_221":null,"otc_ID_241":null,"otc_ID_99":null,"pti1PERSON":0,
         * "pti2PERSON":0,"pti3PERSON":0,"pti4PERSON":0,"pti6PERSON":0,"pti7PERSON":0,
         * "pti8PERSON":45,"pti9PERSON":22,"pti10PERSON":0,"rnum":20,"otc_ID_01":1,
         * "otc_ID_02":null,"otc_ID_03":null,"otc_ID_04":null,"otc_ID_05":null,"otc_ID_06":null,
         * "otc_ID_07":null,"otc_ID_08":null,"otc_ID_101":null,"otc_ID_121":null,
         * "otc_ID_141":null,"otc_ID_15":null,"otc_ID_16":null,"otc_ID_161":null,
         * "otc_ID_17":null,"otc_ID_181":null,"otc_ID_182":null,"otc_ID_183":null,
         * "otc_ID_19":null,"pr_COUNT_PERSON":411,"pti0PERSON":344},{"id":699085,
         * "aoiName":"鑫元基金管理有限公司","aoiId":699085,"otc_ID_20":null,"otc_ID_201":null,
         * "otc_ID_22":null,"otc_ID_221":null,"otc_ID_241":null,"otc_ID_99":null,"pti1PERSON":1,
         * "pti2PERSON":0,"pti3PERSON":0,"pti4PERSON":0,"pti6PERSON":0,"pti7PERSON":0,
         * "pti8PERSON":6,"pti9PERSON":2,"pti10PERSON":0,"rnum":1,"otc_ID_01":1,"otc_ID_02":null,
         * "otc_ID_03":null,"otc_ID_04":null,"otc_ID_05":null,"otc_ID_06":null,"otc_ID_07":null,
         * "otc_ID_08":null,"otc_ID_101":null,"otc_ID_121":null,"otc_ID_141":null,
         * "otc_ID_15":null,"otc_ID_16":null,"otc_ID_161":null,"otc_ID_17":null,
         * "otc_ID_181":null,"otc_ID_182":null,"otc_ID_183":null,"otc_ID_19":null,
         * "pr_COUNT_PERSON":105,"pti0PERSON":96},{"id":699023,"aoiName":"金鹰基金管理有限公司",
         * "aoiId":699023,"otc_ID_20":null,"otc_ID_201":null,"otc_ID_22":null,"otc_ID_221":null,
         * "otc_ID_241":null,"otc_ID_99":null,"pti1PERSON":0,"pti2PERSON":0,"pti3PERSON":0,
         * "pti4PERSON":0,"pti6PERSON":0,"pti7PERSON":0,"pti8PERSON":16,"pti9PERSON":6,
         * "pti10PERSON":0,"rnum":59,"otc_ID_01":1,"otc_ID_02":null,"otc_ID_03":null,
         * "otc_ID_04":null,"otc_ID_05":null,"otc_ID_06":null,"otc_ID_07":null,"otc_ID_08":null,
         * "otc_ID_101":null,"otc_ID_121":null,"otc_ID_141":null,"otc_ID_15":null,
         * "otc_ID_16":null,"otc_ID_161":null,"otc_ID_17":null,"otc_ID_181":null,
         * "otc_ID_182":null,"otc_ID_183":null,"otc_ID_19":null,"pr_COUNT_PERSON":154,
         * "pti0PERSON":132}],"page":{"pageSize":10,"pageIndex":1,"totalPageCount":12,
         * "totalCount":118}}
         */

        private DataBean data;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * list : [{"id":599002,"aoiName":"鹏扬基金管理有限公司","aoiId":599002,"otc_ID_20":null,
             * "otc_ID_201":null,"otc_ID_22":null,"otc_ID_221":null,"otc_ID_241":null,
             * "otc_ID_99":null,"pti1PERSON":0,"pti2PERSON":0,"pti3PERSON":0,"pti4PERSON":0,
             * "pti6PERSON":0,"pti7PERSON":0,"pti8PERSON":6,"pti9PERSON":6,"pti10PERSON":0,
             * "rnum":46,"otc_ID_01":1,"otc_ID_02":null,"otc_ID_03":null,"otc_ID_04":null,
             * "otc_ID_05":null,"otc_ID_06":null,"otc_ID_07":null,"otc_ID_08":null,
             * "otc_ID_101":null,"otc_ID_121":null,"otc_ID_141":null,"otc_ID_15":null,
             * "otc_ID_16":null,"otc_ID_161":null,"otc_ID_17":null,"otc_ID_181":null,
             * "otc_ID_182":null,"otc_ID_183":null,"otc_ID_19":null,"pr_COUNT_PERSON":88,
             * "pti0PERSON":76},{"id":699014,"aoiName":"鹏华基金管理有限公司","aoiId":699014,
             * "otc_ID_20":null,"otc_ID_201":null,"otc_ID_22":null,"otc_ID_221":null,
             * "otc_ID_241":null,"otc_ID_99":null,"pti1PERSON":0,"pti2PERSON":0,"pti3PERSON":0,
             * "pti4PERSON":0,"pti6PERSON":0,"pti7PERSON":0,"pti8PERSON":42,"pti9PERSON":12,
             * "pti10PERSON":0,"rnum":47,"otc_ID_01":1,"otc_ID_02":null,"otc_ID_03":null,
             * "otc_ID_04":null,"otc_ID_05":null,"otc_ID_06":null,"otc_ID_07":null,
             * "otc_ID_08":null,"otc_ID_101":null,"otc_ID_121":null,"otc_ID_141":null,
             * "otc_ID_15":null,"otc_ID_16":null,"otc_ID_161":null,"otc_ID_17":null,
             * "otc_ID_181":null,"otc_ID_182":null,"otc_ID_183":null,"otc_ID_19":null,
             * "pr_COUNT_PERSON":357,"pti0PERSON":303},{"id":699003,"aoiName":"长盛基金管理有限公司",
             * "aoiId":699003,"otc_ID_20":null,"otc_ID_201":null,"otc_ID_22":null,
             * "otc_ID_221":null,"otc_ID_241":null,"otc_ID_99":null,"pti1PERSON":0,
             * "pti2PERSON":0,"pti3PERSON":0,"pti4PERSON":0,"pti6PERSON":0,"pti7PERSON":0,
             * "pti8PERSON":18,"pti9PERSON":0,"pti10PERSON":0,"rnum":110,"otc_ID_01":1,
             * "otc_ID_02":null,"otc_ID_03":null,"otc_ID_04":null,"otc_ID_05":null,
             * "otc_ID_06":null,"otc_ID_07":null,"otc_ID_08":null,"otc_ID_101":null,
             * "otc_ID_121":null,"otc_ID_141":null,"otc_ID_15":null,"otc_ID_16":null,
             * "otc_ID_161":null,"otc_ID_17":null,"otc_ID_181":null,"otc_ID_182":null,
             * "otc_ID_183":null,"otc_ID_19":null,"pr_COUNT_PERSON":174,"pti0PERSON":156},
             * {"id":699068,"aoiName":"长安基金管理有限公司","aoiId":699068,"otc_ID_20":null,
             * "otc_ID_201":null,"otc_ID_22":null,"otc_ID_221":null,"otc_ID_241":null,
             * "otc_ID_99":null,"pti1PERSON":0,"pti2PERSON":0,"pti3PERSON":0,"pti4PERSON":0,
             * "pti6PERSON":0,"pti7PERSON":0,"pti8PERSON":8,"pti9PERSON":7,"pti10PERSON":0,
             * "rnum":112,"otc_ID_01":1,"otc_ID_02":null,"otc_ID_03":null,"otc_ID_04":null,
             * "otc_ID_05":null,"otc_ID_06":null,"otc_ID_07":null,"otc_ID_08":null,
             * "otc_ID_101":null,"otc_ID_121":null,"otc_ID_141":null,"otc_ID_15":null,
             * "otc_ID_16":null,"otc_ID_161":null,"otc_ID_17":null,"otc_ID_181":null,
             * "otc_ID_182":null,"otc_ID_183":null,"otc_ID_19":null,"pr_COUNT_PERSON":86,
             * "pti0PERSON":71},{"id":699011,"aoiName":"长城基金管理有限公司","aoiId":699011,
             * "otc_ID_20":null,"otc_ID_201":null,"otc_ID_22":null,"otc_ID_221":null,
             * "otc_ID_241":null,"otc_ID_99":null,"pti1PERSON":0,"pti2PERSON":0,"pti3PERSON":0,
             * "pti4PERSON":0,"pti6PERSON":0,"pti7PERSON":0,"pti8PERSON":17,"pti9PERSON":4,
             * "pti10PERSON":0,"rnum":111,"otc_ID_01":1,"otc_ID_02":null,"otc_ID_03":null,
             * "otc_ID_04":null,"otc_ID_05":null,"otc_ID_06":null,"otc_ID_07":null,
             * "otc_ID_08":null,"otc_ID_101":null,"otc_ID_121":null,"otc_ID_141":null,
             * "otc_ID_15":null,"otc_ID_16":null,"otc_ID_161":null,"otc_ID_17":null,
             * "otc_ID_181":null,"otc_ID_182":null,"otc_ID_183":null,"otc_ID_19":null,
             * "pr_COUNT_PERSON":161,"pti0PERSON":140},{"id":699021,"aoiName":"长信基金管理有限责任公司",
             * "aoiId":699021,"otc_ID_20":null,"otc_ID_201":null,"otc_ID_22":null,
             * "otc_ID_221":null,"otc_ID_241":null,"otc_ID_99":null,"pti1PERSON":0,
             * "pti2PERSON":0,"pti3PERSON":0,"pti4PERSON":0,"pti6PERSON":0,"pti7PERSON":0,
             * "pti8PERSON":20,"pti9PERSON":8,"pti10PERSON":0,"rnum":109,"otc_ID_01":1,
             * "otc_ID_02":null,"otc_ID_03":null,"otc_ID_04":null,"otc_ID_05":null,
             * "otc_ID_06":null,"otc_ID_07":null,"otc_ID_08":null,"otc_ID_101":null,
             * "otc_ID_121":null,"otc_ID_141":null,"otc_ID_15":null,"otc_ID_16":null,
             * "otc_ID_161":null,"otc_ID_17":null,"otc_ID_181":null,"otc_ID_182":null,
             * "otc_ID_183":null,"otc_ID_19":null,"pr_COUNT_PERSON":211,"pti0PERSON":183},
             * {"id":699007,"aoiName":"银河基金管理有限公司","aoiId":699007,"otc_ID_20":null,
             * "otc_ID_201":null,"otc_ID_22":null,"otc_ID_221":null,"otc_ID_241":null,
             * "otc_ID_99":null,"pti1PERSON":0,"pti2PERSON":0,"pti3PERSON":0,"pti4PERSON":0,
             * "pti6PERSON":0,"pti7PERSON":0,"pti8PERSON":17,"pti9PERSON":2,"pti10PERSON":0,
             * "rnum":21,"otc_ID_01":1,"otc_ID_02":null,"otc_ID_03":null,"otc_ID_04":null,
             * "otc_ID_05":null,"otc_ID_06":null,"otc_ID_07":null,"otc_ID_08":null,
             * "otc_ID_101":null,"otc_ID_121":null,"otc_ID_141":null,"otc_ID_15":null,
             * "otc_ID_16":null,"otc_ID_161":null,"otc_ID_17":null,"otc_ID_181":null,
             * "otc_ID_182":null,"otc_ID_183":null,"otc_ID_19":null,"pr_COUNT_PERSON":147,
             * "pti0PERSON":128},{"id":699016,"aoiName":"银华基金管理股份有限公司","aoiId":699016,
             * "otc_ID_20":null,"otc_ID_201":null,"otc_ID_22":null,"otc_ID_221":null,
             * "otc_ID_241":null,"otc_ID_99":null,"pti1PERSON":0,"pti2PERSON":0,"pti3PERSON":0,
             * "pti4PERSON":0,"pti6PERSON":0,"pti7PERSON":0,"pti8PERSON":45,"pti9PERSON":22,
             * "pti10PERSON":0,"rnum":20,"otc_ID_01":1,"otc_ID_02":null,"otc_ID_03":null,
             * "otc_ID_04":null,"otc_ID_05":null,"otc_ID_06":null,"otc_ID_07":null,
             * "otc_ID_08":null,"otc_ID_101":null,"otc_ID_121":null,"otc_ID_141":null,
             * "otc_ID_15":null,"otc_ID_16":null,"otc_ID_161":null,"otc_ID_17":null,
             * "otc_ID_181":null,"otc_ID_182":null,"otc_ID_183":null,"otc_ID_19":null,
             * "pr_COUNT_PERSON":411,"pti0PERSON":344},{"id":699085,"aoiName":"鑫元基金管理有限公司",
             * "aoiId":699085,"otc_ID_20":null,"otc_ID_201":null,"otc_ID_22":null,
             * "otc_ID_221":null,"otc_ID_241":null,"otc_ID_99":null,"pti1PERSON":1,
             * "pti2PERSON":0,"pti3PERSON":0,"pti4PERSON":0,"pti6PERSON":0,"pti7PERSON":0,
             * "pti8PERSON":6,"pti9PERSON":2,"pti10PERSON":0,"rnum":1,"otc_ID_01":1,
             * "otc_ID_02":null,"otc_ID_03":null,"otc_ID_04":null,"otc_ID_05":null,
             * "otc_ID_06":null,"otc_ID_07":null,"otc_ID_08":null,"otc_ID_101":null,
             * "otc_ID_121":null,"otc_ID_141":null,"otc_ID_15":null,"otc_ID_16":null,
             * "otc_ID_161":null,"otc_ID_17":null,"otc_ID_181":null,"otc_ID_182":null,
             * "otc_ID_183":null,"otc_ID_19":null,"pr_COUNT_PERSON":105,"pti0PERSON":96},
             * {"id":699023,"aoiName":"金鹰基金管理有限公司","aoiId":699023,"otc_ID_20":null,
             * "otc_ID_201":null,"otc_ID_22":null,"otc_ID_221":null,"otc_ID_241":null,
             * "otc_ID_99":null,"pti1PERSON":0,"pti2PERSON":0,"pti3PERSON":0,"pti4PERSON":0,
             * "pti6PERSON":0,"pti7PERSON":0,"pti8PERSON":16,"pti9PERSON":6,"pti10PERSON":0,
             * "rnum":59,"otc_ID_01":1,"otc_ID_02":null,"otc_ID_03":null,"otc_ID_04":null,
             * "otc_ID_05":null,"otc_ID_06":null,"otc_ID_07":null,"otc_ID_08":null,
             * "otc_ID_101":null,"otc_ID_121":null,"otc_ID_141":null,"otc_ID_15":null,
             * "otc_ID_16":null,"otc_ID_161":null,"otc_ID_17":null,"otc_ID_181":null,
             * "otc_ID_182":null,"otc_ID_183":null,"otc_ID_19":null,"pr_COUNT_PERSON":154,
             * "pti0PERSON":132}]
             * page : {"pageSize":10,"pageIndex":1,"totalPageCount":12,"totalCount":118}
             */

            private PageBean page;
            private List<ListBean> list;

            public PageBean getPage() {
                return page;
            }

            public void setPage(PageBean page) {
                this.page = page;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class PageBean {
                /**
                 * pageSize : 10
                 * pageIndex : 1
                 * totalPageCount : 12
                 * totalCount : 118
                 */

                private int pageSize;
                private int pageIndex;
                private int totalPageCount;
                private int totalCount;

                public int getPageSize() {
                    return pageSize;
                }

                public void setPageSize(int pageSize) {
                    this.pageSize = pageSize;
                }

                public int getPageIndex() {
                    return pageIndex;
                }

                public void setPageIndex(int pageIndex) {
                    this.pageIndex = pageIndex;
                }

                public int getTotalPageCount() {
                    return totalPageCount;
                }

                public void setTotalPageCount(int totalPageCount) {
                    this.totalPageCount = totalPageCount;
                }

                public int getTotalCount() {
                    return totalCount;
                }

                public void setTotalCount(int totalCount) {
                    this.totalCount = totalCount;
                }
            }

            public static class ListBean {
                /**
                 * id : 599002
                 * aoiName : 鹏扬基金管理有限公司
                 * aoiId : 599002
                 * otc_ID_20 : null
                 * otc_ID_201 : null
                 * otc_ID_22 : null
                 * otc_ID_221 : null
                 * otc_ID_241 : null
                 * otc_ID_99 : null
                 * pti1PERSON : 0
                 * pti2PERSON : 0
                 * pti3PERSON : 0
                 * pti4PERSON : 0
                 * pti6PERSON : 0
                 * pti7PERSON : 0
                 * pti8PERSON : 6
                 * pti9PERSON : 6
                 * pti10PERSON : 0
                 * rnum : 46
                 * otc_ID_01 : 1
                 * otc_ID_02 : null
                 * otc_ID_03 : null
                 * otc_ID_04 : null
                 * otc_ID_05 : null
                 * otc_ID_06 : null
                 * otc_ID_07 : null
                 * otc_ID_08 : null
                 * otc_ID_101 : null
                 * otc_ID_121 : null
                 * otc_ID_141 : null
                 * otc_ID_15 : null
                 * otc_ID_16 : null
                 * otc_ID_161 : null
                 * otc_ID_17 : null
                 * otc_ID_181 : null
                 * otc_ID_182 : null
                 * otc_ID_183 : null
                 * otc_ID_19 : null
                 * pr_COUNT_PERSON : 88
                 * pti0PERSON : 76
                 */

                private int id;
                private String aoiName;
                private int aoiId;
                private Object otc_ID_20;
                private Object otc_ID_201;
                private Object otc_ID_22;
                private Object otc_ID_221;
                private Object otc_ID_241;
                private Object otc_ID_99;
                private int pti1PERSON;
                private int pti2PERSON;
                private int pti3PERSON;
                private int pti4PERSON;
                private int pti6PERSON;
                private int pti7PERSON;
                private int pti8PERSON;
                private int pti9PERSON;
                private int pti10PERSON;
                private int rnum;
                private int otc_ID_01;
                private Object otc_ID_02;
                private Object otc_ID_03;
                private Object otc_ID_04;
                private Object otc_ID_05;
                private Object otc_ID_06;
                private Object otc_ID_07;
                private Object otc_ID_08;
                private Object otc_ID_101;
                private Object otc_ID_121;
                private Object otc_ID_141;
                private Object otc_ID_15;
                private Object otc_ID_16;
                private Object otc_ID_161;
                private Object otc_ID_17;
                private Object otc_ID_181;
                private Object otc_ID_182;
                private Object otc_ID_183;
                private Object otc_ID_19;
                private int pr_COUNT_PERSON;
                private int pti0PERSON;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getAoiName() {
                    return aoiName;
                }

                public void setAoiName(String aoiName) {
                    this.aoiName = aoiName;
                }

                public int getAoiId() {
                    return aoiId;
                }

                public void setAoiId(int aoiId) {
                    this.aoiId = aoiId;
                }

                public Object getOtc_ID_20() {
                    return otc_ID_20;
                }

                public void setOtc_ID_20(Object otc_ID_20) {
                    this.otc_ID_20 = otc_ID_20;
                }

                public Object getOtc_ID_201() {
                    return otc_ID_201;
                }

                public void setOtc_ID_201(Object otc_ID_201) {
                    this.otc_ID_201 = otc_ID_201;
                }

                public Object getOtc_ID_22() {
                    return otc_ID_22;
                }

                public void setOtc_ID_22(Object otc_ID_22) {
                    this.otc_ID_22 = otc_ID_22;
                }

                public Object getOtc_ID_221() {
                    return otc_ID_221;
                }

                public void setOtc_ID_221(Object otc_ID_221) {
                    this.otc_ID_221 = otc_ID_221;
                }

                public Object getOtc_ID_241() {
                    return otc_ID_241;
                }

                public void setOtc_ID_241(Object otc_ID_241) {
                    this.otc_ID_241 = otc_ID_241;
                }

                public Object getOtc_ID_99() {
                    return otc_ID_99;
                }

                public void setOtc_ID_99(Object otc_ID_99) {
                    this.otc_ID_99 = otc_ID_99;
                }

                public int getPti1PERSON() {
                    return pti1PERSON;
                }

                public void setPti1PERSON(int pti1PERSON) {
                    this.pti1PERSON = pti1PERSON;
                }

                public int getPti2PERSON() {
                    return pti2PERSON;
                }

                public void setPti2PERSON(int pti2PERSON) {
                    this.pti2PERSON = pti2PERSON;
                }

                public int getPti3PERSON() {
                    return pti3PERSON;
                }

                public void setPti3PERSON(int pti3PERSON) {
                    this.pti3PERSON = pti3PERSON;
                }

                public int getPti4PERSON() {
                    return pti4PERSON;
                }

                public void setPti4PERSON(int pti4PERSON) {
                    this.pti4PERSON = pti4PERSON;
                }

                public int getPti6PERSON() {
                    return pti6PERSON;
                }

                public void setPti6PERSON(int pti6PERSON) {
                    this.pti6PERSON = pti6PERSON;
                }

                public int getPti7PERSON() {
                    return pti7PERSON;
                }

                public void setPti7PERSON(int pti7PERSON) {
                    this.pti7PERSON = pti7PERSON;
                }

                public int getPti8PERSON() {
                    return pti8PERSON;
                }

                public void setPti8PERSON(int pti8PERSON) {
                    this.pti8PERSON = pti8PERSON;
                }

                public int getPti9PERSON() {
                    return pti9PERSON;
                }

                public void setPti9PERSON(int pti9PERSON) {
                    this.pti9PERSON = pti9PERSON;
                }

                public int getPti10PERSON() {
                    return pti10PERSON;
                }

                public void setPti10PERSON(int pti10PERSON) {
                    this.pti10PERSON = pti10PERSON;
                }

                public int getRnum() {
                    return rnum;
                }

                public void setRnum(int rnum) {
                    this.rnum = rnum;
                }

                public int getOtc_ID_01() {
                    return otc_ID_01;
                }

                public void setOtc_ID_01(int otc_ID_01) {
                    this.otc_ID_01 = otc_ID_01;
                }

                public Object getOtc_ID_02() {
                    return otc_ID_02;
                }

                public void setOtc_ID_02(Object otc_ID_02) {
                    this.otc_ID_02 = otc_ID_02;
                }

                public Object getOtc_ID_03() {
                    return otc_ID_03;
                }

                public void setOtc_ID_03(Object otc_ID_03) {
                    this.otc_ID_03 = otc_ID_03;
                }

                public Object getOtc_ID_04() {
                    return otc_ID_04;
                }

                public void setOtc_ID_04(Object otc_ID_04) {
                    this.otc_ID_04 = otc_ID_04;
                }

                public Object getOtc_ID_05() {
                    return otc_ID_05;
                }

                public void setOtc_ID_05(Object otc_ID_05) {
                    this.otc_ID_05 = otc_ID_05;
                }

                public Object getOtc_ID_06() {
                    return otc_ID_06;
                }

                public void setOtc_ID_06(Object otc_ID_06) {
                    this.otc_ID_06 = otc_ID_06;
                }

                public Object getOtc_ID_07() {
                    return otc_ID_07;
                }

                public void setOtc_ID_07(Object otc_ID_07) {
                    this.otc_ID_07 = otc_ID_07;
                }

                public Object getOtc_ID_08() {
                    return otc_ID_08;
                }

                public void setOtc_ID_08(Object otc_ID_08) {
                    this.otc_ID_08 = otc_ID_08;
                }

                public Object getOtc_ID_101() {
                    return otc_ID_101;
                }

                public void setOtc_ID_101(Object otc_ID_101) {
                    this.otc_ID_101 = otc_ID_101;
                }

                public Object getOtc_ID_121() {
                    return otc_ID_121;
                }

                public void setOtc_ID_121(Object otc_ID_121) {
                    this.otc_ID_121 = otc_ID_121;
                }

                public Object getOtc_ID_141() {
                    return otc_ID_141;
                }

                public void setOtc_ID_141(Object otc_ID_141) {
                    this.otc_ID_141 = otc_ID_141;
                }

                public Object getOtc_ID_15() {
                    return otc_ID_15;
                }

                public void setOtc_ID_15(Object otc_ID_15) {
                    this.otc_ID_15 = otc_ID_15;
                }

                public Object getOtc_ID_16() {
                    return otc_ID_16;
                }

                public void setOtc_ID_16(Object otc_ID_16) {
                    this.otc_ID_16 = otc_ID_16;
                }

                public Object getOtc_ID_161() {
                    return otc_ID_161;
                }

                public void setOtc_ID_161(Object otc_ID_161) {
                    this.otc_ID_161 = otc_ID_161;
                }

                public Object getOtc_ID_17() {
                    return otc_ID_17;
                }

                public void setOtc_ID_17(Object otc_ID_17) {
                    this.otc_ID_17 = otc_ID_17;
                }

                public Object getOtc_ID_181() {
                    return otc_ID_181;
                }

                public void setOtc_ID_181(Object otc_ID_181) {
                    this.otc_ID_181 = otc_ID_181;
                }

                public Object getOtc_ID_182() {
                    return otc_ID_182;
                }

                public void setOtc_ID_182(Object otc_ID_182) {
                    this.otc_ID_182 = otc_ID_182;
                }

                public Object getOtc_ID_183() {
                    return otc_ID_183;
                }

                public void setOtc_ID_183(Object otc_ID_183) {
                    this.otc_ID_183 = otc_ID_183;
                }

                public Object getOtc_ID_19() {
                    return otc_ID_19;
                }

                public void setOtc_ID_19(Object otc_ID_19) {
                    this.otc_ID_19 = otc_ID_19;
                }

                public int getPr_COUNT_PERSON() {
                    return pr_COUNT_PERSON;
                }

                public void setPr_COUNT_PERSON(int pr_COUNT_PERSON) {
                    this.pr_COUNT_PERSON = pr_COUNT_PERSON;
                }

                public int getPti0PERSON() {
                    return pti0PERSON;
                }

                public void setPti0PERSON(int pti0PERSON) {
                    this.pti0PERSON = pti0PERSON;
                }
            }
        }
    }
}
