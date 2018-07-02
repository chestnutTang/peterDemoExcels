package demo.third.com.exceldemo.service.entity;

import java.util.List;

/**
 * 首页列表
 */
public class HomePageEntity {

    /**
     * code : MWK6ZYxlwd
     * message : 9DwtvCvFG5
     * result : {"news":[{"id":56457,"gmtCreate":92573,"gmtModified":16881,"title":"iFOH13B015","date":"1530539650207","content":"mJe5atJmO4"},{"id":56859,"gmtCreate":2814,"gmtModified":33657,"title":"GbMTnj8VfV","date":"1530537527979","content":"ECioomz2vG"},{"id":57062,"gmtCreate":2571,"gmtModified":73587,"title":"TxVJCtAd2p","date":"1530538745253","content":"D0ShAgHILT"}],"topBanner":[{"targetUrl":"http://nih.nukcxhjwpavkr.idtpoq","img":["YbjNPfIftv","5y5oSvW2W4","GioiXUCAHN"]},{"targetUrl":"http://mxe.ysmyefqwrsjo.aorv","img":["5WxnxRCUsU","rpgwmiVHbS","yitwojd1K5"]},{"targetUrl":"http://nag.ahzvanyavjux.ztd","img":["kcgjJwHCQD","76ZMXkdo75","lbeKJ6t53d"]}],"staticBanner":{"targetUrl":"http://spz.vgojyhz.fpmg","img":["A9pkod3a3L","tnvaz0Rrwe","wKtK3ZVif9"]}}
     */

    private String code;
    private String message;
    private ResultBean result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
         * news : [{"id":56457,"gmtCreate":92573,"gmtModified":16881,"title":"iFOH13B015","date":"1530539650207","content":"mJe5atJmO4"},{"id":56859,"gmtCreate":2814,"gmtModified":33657,"title":"GbMTnj8VfV","date":"1530537527979","content":"ECioomz2vG"},{"id":57062,"gmtCreate":2571,"gmtModified":73587,"title":"TxVJCtAd2p","date":"1530538745253","content":"D0ShAgHILT"}]
         * topBanner : [{"targetUrl":"http://nih.nukcxhjwpavkr.idtpoq","img":["YbjNPfIftv","5y5oSvW2W4","GioiXUCAHN"]},{"targetUrl":"http://mxe.ysmyefqwrsjo.aorv","img":["5WxnxRCUsU","rpgwmiVHbS","yitwojd1K5"]},{"targetUrl":"http://nag.ahzvanyavjux.ztd","img":["kcgjJwHCQD","76ZMXkdo75","lbeKJ6t53d"]}]
         * staticBanner : {"targetUrl":"http://spz.vgojyhz.fpmg","img":["A9pkod3a3L","tnvaz0Rrwe","wKtK3ZVif9"]}
         */

        private StaticBannerBean staticBanner;
        private List<NewsBean> news;
        private List<TopBannerBean> topBanner;

        public StaticBannerBean getStaticBanner() {
            return staticBanner;
        }

        public void setStaticBanner(StaticBannerBean staticBanner) {
            this.staticBanner = staticBanner;
        }

        public List<NewsBean> getNews() {
            return news;
        }

        public void setNews(List<NewsBean> news) {
            this.news = news;
        }

        public List<TopBannerBean> getTopBanner() {
            return topBanner;
        }

        public void setTopBanner(List<TopBannerBean> topBanner) {
            this.topBanner = topBanner;
        }

        public static class StaticBannerBean {
            /**
             * targetUrl : http://spz.vgojyhz.fpmg
             * img : ["A9pkod3a3L","tnvaz0Rrwe","wKtK3ZVif9"]
             */

            private String targetUrl;
            private List<String> img;

            public String getTargetUrl() {
                return targetUrl;
            }

            public void setTargetUrl(String targetUrl) {
                this.targetUrl = targetUrl;
            }

            public List<String> getImg() {
                return img;
            }

            public void setImg(List<String> img) {
                this.img = img;
            }
        }

        public static class NewsBean {
            /**
             * id : 56457
             * gmtCreate : 92573
             * gmtModified : 16881
             * title : iFOH13B015
             * date : 1530539650207
             * content : mJe5atJmO4
             */

            private int id;
            private int gmtCreate;
            private String gmtModified;
            private String title;
            private String date;
            private String content;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getGmtCreate() {
                return gmtCreate;
            }

            public void setGmtCreate(int gmtCreate) {
                this.gmtCreate = gmtCreate;
            }

            public String getGmtModified() {
                return gmtModified;
            }

            public void setGmtModified(String gmtModified) {
                this.gmtModified = gmtModified;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }

        public static class TopBannerBean {
            /**
             * targetUrl : http://nih.nukcxhjwpavkr.idtpoq
             * img : ["YbjNPfIftv","5y5oSvW2W4","GioiXUCAHN"]
             */

            private String targetUrl;
            private List<String> img;

            public String getTargetUrl() {
                return targetUrl;
            }

            public void setTargetUrl(String targetUrl) {
                this.targetUrl = targetUrl;
            }

            public List<String> getImg() {
                return img;
            }

            public void setImg(List<String> img) {
                this.img = img;
            }
        }
    }
}
