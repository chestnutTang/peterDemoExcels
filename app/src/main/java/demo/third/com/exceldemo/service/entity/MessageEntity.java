package demo.third.com.exceldemo.service.entity;

import java.util.List;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.09.04
 * 消息
 */
public class MessageEntity {

    /**
     * code : 0
     * message : success
     * result : {"data":{"list":[{"id":173,"userId":42,"gmtCreate":1536025665083,
     * "gmtModified":1536025665083,"publishTime":1536025665083,"content":"123123123123123123"},
     * {"id":127,"userId":42,"gmtCreate":1534958028181,"gmtModified":1534958028181,
     * "publishTime":1534958028181,"content":"这是群发消息\n第一行\n第二行\n第三行\n第四行"},{"id":82,"userId":42,
     * "gmtCreate":1534956655953,"gmtModified":1534956655953,"publishTime":1534956655953,
     * "content":"群发消息第二次\n第一行"},{"id":37,"userId":42,"gmtCreate":1534701156093,
     * "gmtModified":1534701156093,"publishTime":1534701156093,"content":"这是一条群发的消息"}],
     * "page":{"pageSize":10,"pageIndex":1,"totalPageCount":1,"totalCount":4}}}
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
         * data : {"list":[{"id":173,"userId":42,"gmtCreate":1536025665083,
         * "gmtModified":1536025665083,"publishTime":1536025665083,
         * "content":"123123123123123123"},{"id":127,"userId":42,"gmtCreate":1534958028181,
         * "gmtModified":1534958028181,"publishTime":1534958028181,
         * "content":"这是群发消息\n第一行\n第二行\n第三行\n第四行"},{"id":82,"userId":42,
         * "gmtCreate":1534956655953,"gmtModified":1534956655953,"publishTime":1534956655953,
         * "content":"群发消息第二次\n第一行"},{"id":37,"userId":42,"gmtCreate":1534701156093,
         * "gmtModified":1534701156093,"publishTime":1534701156093,"content":"这是一条群发的消息"}],
         * "page":{"pageSize":10,"pageIndex":1,"totalPageCount":1,"totalCount":4}}
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
             * list : [{"id":173,"userId":42,"gmtCreate":1536025665083,
             * "gmtModified":1536025665083,"publishTime":1536025665083,
             * "content":"123123123123123123"},{"id":127,"userId":42,"gmtCreate":1534958028181,
             * "gmtModified":1534958028181,"publishTime":1534958028181,
             * "content":"这是群发消息\n第一行\n第二行\n第三行\n第四行"},{"id":82,"userId":42,
             * "gmtCreate":1534956655953,"gmtModified":1534956655953,"publishTime":1534956655953,
             * "content":"群发消息第二次\n第一行"},{"id":37,"userId":42,"gmtCreate":1534701156093,
             * "gmtModified":1534701156093,"publishTime":1534701156093,"content":"这是一条群发的消息"}]
             * page : {"pageSize":10,"pageIndex":1,"totalPageCount":1,"totalCount":4}
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
                 * totalPageCount : 1
                 * totalCount : 4
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
                 * id : 173
                 * userId : 42
                 * gmtCreate : 1536025665083
                 * gmtModified : 1536025665083
                 * publishTime : 1536025665083
                 * content : 123123123123123123
                 */

                private int id;
                private int userId;
                private String gmtCreate;
                private String gmtModified;
                private String publishTime;
                private String content;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public String getGmtCreate() {
                    return gmtCreate;
                }

                public void setGmtCreate(String gmtCreate) {
                    this.gmtCreate = gmtCreate;
                }

                public String getGmtModified() {
                    return gmtModified;
                }

                public void setGmtModified(String gmtModified) {
                    this.gmtModified = gmtModified;
                }

                public String getPublishTime() {
                    return publishTime;
                }

                public void setPublishTime(String publishTime) {
                    this.publishTime = publishTime;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }
            }
        }
    }
}
