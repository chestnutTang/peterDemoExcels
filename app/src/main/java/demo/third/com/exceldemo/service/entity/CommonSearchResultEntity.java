package demo.third.com.exceldemo.service.entity;

import java.util.List;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.07.25
 */
public class CommonSearchResultEntity {


    /**
     * code : 0
     * message : success
     * result : {"pofFutures":{"list":[{"id":831000088201,"url":"http://gs.amac.org.cn/amac-infodisc/res/pof/futures/detail.html?id=831000088201","mpiName":"和合资管-臻选5号资产管理计划","mpiProductCode":"SW2928","aoiName":"和合资产管理（上海）有限公司","mpiTrustee":"招商银行股份有限公司","mgrName":null,"mpiCreateDate":"2017-07-25","mpiCreateDateTimestamp":1500912000000,"tzlx":"混合类产品","castProduct":null,"mpiTotalMoney":15500,"sfjgh":"否","mpiParticipationUser":83},{"id":831000085652,"url":"http://gs.amac.org.cn/amac-infodisc/res/pof/futures/detail.html?id=831000085652","mpiName":"银河期货钢铁1号资产管理计划","mpiProductCode":"SW3299","aoiName":"银河期货有限公司","mpiTrustee":"招商证券股份有限公司","mgrName":null,"mpiCreateDate":"2017-07-25","mpiCreateDateTimestamp":1500912000000,"tzlx":"期货及其他衍生品类产品","castProduct":null,"mpiTotalMoney":200,"sfjgh":"否","mpiParticipationUser":2},{"id":831000085642,"url":"http://gs.amac.org.cn/amac-infodisc/res/pof/futures/detail.html?id=831000085642","mpiName":"和合资管-瀚亚安心保17号集合资产管理计划","mpiProductCode":"SW2929",
     * "aoiName":"和合资产管理（上海）有限公司","mpiTrustee":"招商银行股份有限公司","mgrName":null,"mpiCreateDate":"2017-07-25","mpiCreateDateTimestamp":1500912000000,"tzlx":"混合类产品","castProduct":null,"mpiTotalMoney":9010,"sfjgh":"否","mpiParticipationUser":64},{"id":831000085638,"url":"http://gs.amac.org.cn/amac-infodisc/res/pof/futures/detail.html?id=831000085638","mpiName":"国富期货天长29号资产管理计划","mpiProductCode":"SW5785","aoiName":"国富期货有限公司","mpiTrustee":"平安银行股份有限公司","mgrName":null,"mpiCreateDate":"2017-07-25","mpiCreateDateTimestamp":1500912000000,"tzlx":"混合类产品","castProduct":null,"mpiTotalMoney":200,"sfjgh":"否","mpiParticipationUser":2},{"id":831000085636,"url":"http://gs.amac.org.cn/amac-infodisc/res/pof/futures/detail.html?id=831000085636","mpiName":"中州星升聚融1号资产管理计划","mpiProductCode":"SW5282","aoiName":"中州星升资产管理有限责任公司","mpiTrustee":"中信建投证券股份有限公司","mgrName":null,"mpiCreateDate":"2017-07-25","mpiCreateDateTimestamp":1500912000000,"tzlx":"混合类产品","castProduct":null,"mpiTotalMoney":210,"sfjgh":"否",
     * "mpiParticipationUser":2},{"id":831000085633,"url":"http://gs.amac.org.cn/amac-infodisc/res/pof/futures/detail.html?id=831000085633","mpiName":"招金期货-融承量化劲龙1号资产管理计划","mpiProductCode":"SW5715","aoiName":"招金期货有限公司","mpiTrustee":"广发证券股份有限公司","mgrName":null,"mpiCreateDate":"2017-07-25","mpiCreateDateTimestamp":1500912000000,"tzlx":"期货及其他衍生品类产品","castProduct":null,"mpiTotalMoney":600,"sfjgh":"否","mpiParticipationUser":2},{"id":831000085627,"url":"http://gs.amac.org.cn/amac-infodisc/res/pof/futures/detail.html?id=831000085627","mpiName":"国投安信期货-鑫泰1号资产管理计划","mpiProductCode":"SW5496","aoiName":"国投安信期货有限公司","mpiTrustee":"恒泰证券股份有限公司","mgrName":null,"mpiCreateDate":"2017-07-25","mpiCreateDateTimestamp":1500912000000,"tzlx":"混合类产品","castProduct":null,"mpiTotalMoney":200,"sfjgh":"否","mpiParticipationUser":2}],"page":{"pageSize":50,"pageIndex":1,"totalPageCount":1,"totalCount":7}},"pofSecurities":{"list":[{"id":1807091718109844,"cpmc":"兴证资管年年鑫17号集合资产管理计划","cpbm":"SEE136",
     * "gljg":"兴证证券资产管理有限公司","slrq":"2018-07-04","slrqTimestamp":1530633600000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":63096,"clscyhs":"199","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718109844","fedjjg":null},{"id":1807091718109816,"cpmc":"太平洋证券红珊瑚春城1号集合资产管理计划","cpbm":"SEE239","gljg":"太平洋证券股份有限公司","slrq":"2018-07-04","slrqTimestamp":1530633600000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":45100,"clscyhs":"2","tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718109816","fedjjg":null},{"id":1807091718100219,"cpmc":"中金聚鑫二号集合资产管理计划","cpbm":"SEB574","gljg":"中国国际金融股份有限公司","slrq":"2018-06-29","slrqTimestamp":1530201600000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":19750.24,"clscyhs":"43","tgjg":"中信建投证券股份有限公司",
     * "url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718100219","fedjjg":null},{"id":1807091718100122,"cpmc":"首创证券致胜7号集合资产管理计划","cpbm":"SEC230","gljg":"首创证券有限责任公司","slrq":"2018-06-29","slrqTimestamp":1530201600000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":7912.11,"clscyhs":"55","tgjg":"上海浦东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718100122","fedjjg":null},{"id":1807091718104858,"cpmc":"中信建投稳健添益7号集合资产管理计划","cpbm":"SED021","gljg":"中信建投证券股份有限公司","slrq":"2018-06-27","slrqTimestamp":1530028800000,"dqr":"2028-06-27","dqrTimestamp":1845648000000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":5145.94,"clscyhs":"11","tgjg":"上海浦东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718104858","fedjjg":null},{"id":1807091718104674,"cpmc":"太平洋证券金元宝8号集合资产管理计划","cpbm":"SED644","gljg":"太平洋证券股份有限公司",
     * "slrq":"2018-06-27","slrqTimestamp":1530028800000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":9945,"clscyhs":"20","tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718104674","fedjjg":null},{"id":1807090927109635,"cpmc":"兴证资管年年鑫106号集合资产管理计划","cpbm":"SED181","gljg":"兴证证券资产管理有限公司","slrq":"2018-06-27","slrqTimestamp":1530028800000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":26499,"clscyhs":"199","tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807090927109635","fedjjg":null},{"id":1807090927109269,"cpmc":"首创证券创享2号集合资产管理计划","cpbm":"SEC223","gljg":"首创证券有限责任公司","slrq":"2018-06-27","slrqTimestamp":1530028800000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":20961.29,"clscyhs":"142","tgjg":"中国光大银行股份有限公司","url":"http://gs.amac.org
     * .cn/amac-infodisc/res/pof/securities/detail.html?id=1807090927109269","fedjjg":null},{"id":1807091718105017,"cpmc":"申万宏源鑫丰臻选1号FOF集合资产管理计划","cpbm":"SED001","gljg":"申万宏源证券有限公司","slrq":"2018-06-26","slrqTimestamp":1529942400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"混合类产品","sffj":"否","glfs":null,"clgm":3291,"clscyhs":"27","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718105017","fedjjg":null},{"id":1807091718104900,"cpmc":"申万宏源鑫丰臻选2号FOF集合资产管理计划","cpbm":"SED002","gljg":"申万宏源证券有限公司","slrq":"2018-06-26","slrqTimestamp":1529942400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"混合类产品","sffj":"否","glfs":null,"clgm":10013,"clscyhs":"88","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718104900","fedjjg":null},{"id":1807091718104718,"cpmc":"华泰紫金投融共赢6号集合资产管理计划","cpbm":"SED245","gljg":"华泰证券（上海）资产管理有限公司","slrq":"2018-06-26",
     * "slrqTimestamp":1529942400000,"dqr":"2019-07-01","dqrTimestamp":1561910400000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":15344,"clscyhs":"45","tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718104718","fedjjg":null},{"id":1807091718100342,"cpmc":"广发资管尊享利21号集合资产管理计划","cpbm":"SED353","gljg":"广发证券资产管理（广东）有限公司","slrq":"2018-06-26","slrqTimestamp":1529942400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":10100,"clscyhs":"61","tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718100342","fedjjg":null},{"id":1807021619101459,"cpmc":"财通证券资管年年赢108号集合资产管理计划","cpbm":"SED061","gljg":"财通证券资产管理有限公司","slrq":"2018-06-26","slrqTimestamp":1529942400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":23253.8,"clscyhs":"171","tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org
     * .cn/amac-infodisc/res/pof/securities/detail.html?id=1807021619101459","fedjjg":null},{"id":1807021619101093,"cpmc":"申万宏源证券稳赢30号集合资产管理计划","cpbm":"SED005","gljg":"申万宏源证券有限公司","slrq":"2018-06-22","slrqTimestamp":1529596800000,"dqr":"2023-06-22","dqrTimestamp":1687363200000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":35815.31,"clscyhs":"200","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807021619101093","fedjjg":null},{"id":1807021619100996,"cpmc":"申万宏源证券稳赢23集合资产管理计划","cpbm":"SED077","gljg":"申万宏源证券有限公司","slrq":"2018-06-22","slrqTimestamp":1529596800000,"dqr":"2021-06-21","dqrTimestamp":1624204800000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":10835.3,"clscyhs":"66","tgjg":"上海银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807021619100996","fedjjg":null},{"id":1807021619101324,"cpmc":"山西证券启明1号集合资产管理计划","cpbm":"SEA960","gljg":"山西证券股份有限公司","slrq":"2018-06-21",
     * "slrqTimestamp":1529510400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":14635.56,"clscyhs":"108","tgjg":"中国光大银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807021619101324","fedjjg":null},{"id":1807021619100805,"cpmc":"五矿证券五丰稳利1号集合资产管理计划","cpbm":"SEB983","gljg":"五矿证券有限公司","slrq":"2018-06-21","slrqTimestamp":1529510400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":22133,"clscyhs":"163","tgjg":"中国光大银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807021619100805","fedjjg":null},{"id":1807091718100435,"cpmc":"中投证券宁福364天5号集合资产管理计划","cpbm":"SEC382","gljg":"中国中投证券有限责任公司","slrq":"2018-06-20","slrqTimestamp":1529424000000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":3790.04,"clscyhs":"3","tgjg":"宁波银行股份有限公司","url":"http://gs.amac.org
     * .cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718100435","fedjjg":null},{"id":1806251446107384,"cpmc":"中银证券中国红-黄山8号第22期固定收益类集合资产管理计划","cpbm":"SEC508","gljg":"中银国际证券股份有限公司","slrq":"2018-06-20","slrqTimestamp":1529424000000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":38470,"clscyhs":"160","tgjg":"中国银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446107384","fedjjg":null},{"id":1806251446107700,"cpmc":"东证融汇汇享26号集合资产管理计划","cpbm":"SEA161","gljg":"东证融汇证券资产管理有限公司","slrq":"2018-06-19","slrqTimestamp":1529337600000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":7706,"clscyhs":"9","tgjg":"广东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446107700","fedjjg":null},{"id":1806251446107194,"cpmc":"中银证券中国红-黄山8号第21期固定收益类集合资产管理计划","cpbm":"SEC459","gljg":"中银国际证券股份有限公司","slrq":"2018-06-19",
     * "slrqTimestamp":1529337600000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":29960,"clscyhs":"159","tgjg":"中国银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446107194","fedjjg":null},{"id":1806261720103897,"cpmc":"申万宏源证券稳赢49号集合资产管理计划","cpbm":"SEC574","gljg":"申万宏源证券有限公司","slrq":"2018-06-15","slrqTimestamp":1528992000000,"dqr":"2023-06-14","dqrTimestamp":1686672000000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":39772.9,"clscyhs":"197","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806261720103897","fedjjg":null},{"id":1806251446107009,"cpmc":"申万宏源证券稳赢35号集合资产管理计划","cpbm":"SEC125","gljg":"申万宏源证券有限公司","slrq":"2018-06-15","slrqTimestamp":1528992000000,"dqr":"2023-06-15","dqrTimestamp":1686758400000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":19657,"clscyhs":"127","tgjg":"中国邮政储蓄银行股份有限公司","url":"http://gs.amac.org
     * .cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446107009","fedjjg":null},{"id":1806211654104790,"cpmc":"华泰紫金信用1号集合资产管理计划","cpbm":"SEC157","gljg":"华泰证券（上海）资产管理有限公司","slrq":"2018-06-15","slrqTimestamp":1528992000000,"dqr":"2023-06-15","dqrTimestamp":1686758400000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":10472.09,"clscyhs":"75","tgjg":"平安银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654104790","fedjjg":null},{"id":1806211654104601,"cpmc":"兴证资管年年鑫105号集合资产管理计划","cpbm":"SEC129","gljg":"兴证证券资产管理有限公司","slrq":"2018-06-15","slrqTimestamp":1528992000000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":20597.31,"clscyhs":"159","tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654104601","fedjjg":null},{"id":1806211654104306,"cpmc":"首创证券创享1号集合资产管理计划","cpbm":"SEB330","gljg":"首创证券有限责任公司","slrq":"2018-06-15",
     * "slrqTimestamp":1528992000000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":15649.15,"clscyhs":"116","tgjg":"中国光大银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654104306","fedjjg":null},{"id":1806211654103985,"cpmc":"广发资管尊享利19号集合资产管理计划","cpbm":"SEC259","gljg":"广发证券资产管理（广东）有限公司","slrq":"2018-06-14","slrqTimestamp":1528905600000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":12364,"clscyhs":"52","tgjg":"广东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654103985","fedjjg":null},{"id":1807091718100295,"cpmc":"国泰君安君越优享多策略1号集合资产管理计划","cpbm":"SEC027","gljg":"上海国泰君安证券资产管理有限公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":3100,"clscyhs":"13","tgjg":"招商银行股份有限公司","url":"http://gs.amac.org
     * .cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718100295","fedjjg":null},{"id":1807090927109477,"cpmc":"国金慧多利债券2号集合资产管理计划","cpbm":"SEB333","gljg":"国金证券股份有限公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":4160.04,"clscyhs":"17","tgjg":"招商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807090927109477","fedjjg":null},{"id":1806261720104125,"cpmc":"申万宏源证券稳赢31号集合资产管理计划","cpbm":"SEC517","gljg":"申万宏源证券有限公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"2023-06-13","dqrTimestamp":1686585600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":13545,"clscyhs":"83","tgjg":"中国邮政储蓄银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806261720104125","fedjjg":null},{"id":1806251446107669,"cpmc":"东证融汇汇享27号集合资产管理计划","cpbm":"SEB322","gljg":"东证融汇证券资产管理有限公司","slrq":"2018-06-13",
     * "slrqTimestamp":1528819200000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":20100,"clscyhs":"2","tgjg":"广东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446107669","fedjjg":null},{"id":1806251446106903,"cpmc":"申万宏源证券稳赢37号集合资产管理计划","cpbm":"SEB852","gljg":"申万宏源证券有限公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"2021-06-13","dqrTimestamp":1623513600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":16300,"clscyhs":"65","tgjg":"上海银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446106903","fedjjg":null},{"id":1806211654104518,"cpmc":"首创证券泽鑫3号集合资产管理计划","cpbm":"SEB296","gljg":"首创证券有限责任公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":7144,"clscyhs":"44","tgjg":"华夏银行股份有限公司","url":"http://gs.amac.org
     * .cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654104518","fedjjg":null},{"id":1806211654104158,"cpmc":"海通海蓝增益2号集合资产管理计划","cpbm":"SCX377","gljg":"上海海通证券资产管理有限公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"2020-06-12","dqrTimestamp":1591891200000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":21506,"clscyhs":"124","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654104158","fedjjg":null},{"id":1806211654103707,"cpmc":"招商智远全景多策略集合资产管理计划","cpbm":"SEB616","gljg":"招商证券资产管理有限公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"2028-06-12","dqrTimestamp":1844352000000,"tzlx":"混合类产品","sffj":"否","glfs":null,"clgm":5252.68,"clscyhs":"30","tgjg":"上海浦东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654103707","fedjjg":null},{"id":1806211654103672,"cpmc":"长城证券金徽酒增持1号集合资产管理计划","cpbm":"SEB516","gljg":"长城证券股份有限公司","slrq":"2018-06-13",
     * "slrqTimestamp":1528819200000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"权益类产品","sffj":"否","glfs":null,"clgm":8500,"clscyhs":"13","tgjg":"平安银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654103672","fedjjg":null},{"id":1806251446107752,"cpmc":"兴证资管玉麒麟定制7号集合资产管理计划","cpbm":"SEB511","gljg":"兴证证券资产管理有限公司","slrq":"2018-06-12","slrqTimestamp":1528732800000,"dqr":"2021-06-11","dqrTimestamp":1623340800000,"tzlx":"混合类产品","sffj":"否","glfs":null,"clgm":3000,"clscyhs":"2","tgjg":"上海浦东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446107752","fedjjg":null},{"id":1806251446105993,"cpmc":"渤海汇金璞盈8号集合资产管理计划","cpbm":"SY9641","gljg":"渤海汇金证券资产管理有限公司","slrq":"2018-06-12","slrqTimestamp":1528732800000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":28900.83,"clscyhs":"194","tgjg":"上海浦东发展银行股份有限公司","url":"http://gs.amac.org
     * .cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446105993","fedjjg":null},{"id":1806251446105835,"cpmc":"德邦浦华优选18号集合资产管理计划","cpbm":"SEB004","gljg":"德邦证券股份有限公司","slrq":"2018-06-12","slrqTimestamp":1528732800000,"dqr":"2019-07-12","dqrTimestamp":1562860800000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":9950,"clscyhs":"64","tgjg":"上海浦东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446105835","fedjjg":null},{"id":1806211654104449,"cpmc":"东吴汇天益10号集合资产管理计划","cpbm":"SEB595","gljg":"东吴证券股份有限公司","slrq":"2018-06-12","slrqTimestamp":1528732800000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":8045,"clscyhs":"42","tgjg":"宁波银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654104449","fedjjg":null},{"id":1806211654103633,"cpmc":"东证融汇汇享25号集合资产管理计划","cpbm":"SCY653","gljg":"东证融汇证券资产管理有限公司","slrq":"2018-06-12","slrqTimestamp":1528732800000,
     * "dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":4417,"clscyhs":"10","tgjg":"广东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654103633","fedjjg":null},{"id":1806211654103395,"cpmc":"申万宏源证券稳赢34号集合资产管理计划","cpbm":"SEB872","gljg":"申万宏源证券有限公司","slrq":"2018-06-08","slrqTimestamp":1528387200000,"dqr":"2023-06-08","dqrTimestamp":1686153600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":13235.12,"clscyhs":"88","tgjg":"中国邮政储蓄银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654103395","fedjjg":null},{"id":1806211654102315,"cpmc":"兴证资管浦兴年年利4号集合资产管理计划","cpbm":"SEA975","gljg":"兴证证券资产管理有限公司","slrq":"2018-06-08","slrqTimestamp":1528387200000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":15157.21,"clscyhs":"111","tgjg":"上海浦东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail
     * .html?id=1806211654102315","fedjjg":null},{"id":1806211654102456,"cpmc":"申万宏源证券稳赢40号集合资产管理计划","cpbm":"SEB135","gljg":"申万宏源证券有限公司","slrq":"2018-06-07","slrqTimestamp":1528300800000,"dqr":"2021-06-07","dqrTimestamp":1622995200000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":12191.4,"clscyhs":"77","tgjg":"上海银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654102456","fedjjg":null},{"id":1806191720100562,"cpmc":"申万宏源证券稳赢46号集合资产管理计划","cpbm":"SEB818","gljg":"申万宏源证券有限公司","slrq":"2018-06-07","slrqTimestamp":1528300800000,"dqr":"2023-06-07","dqrTimestamp":1686067200000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":37188.6,"clscyhs":"194","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806191720100562","fedjjg":null},{"id":1806121407102422,"cpmc":"兴证资管年年鑫20号集合资产管理计划","cpbm":"SEB018","gljg":"兴证证券资产管理有限公司","slrq":"2018-06-07","slrqTimestamp":1528300800000,"dqr":"9999-12-31",
     * "dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":4330.34,"clscyhs":"9","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806121407102422","fedjjg":null},{"id":1806121407102622,"cpmc":"兴证资管年年鑫16号集合资产管理计划","cpbm":"SEA729","gljg":"兴证证券资产管理有限公司","slrq":"2018-06-06","slrqTimestamp":1528214400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":11606.29,"clscyhs":"88","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806121407102622","fedjjg":null},{"id":1806121407101824,"cpmc":"兴证资管年年鑫102号集合资产管理计划","cpbm":"SEA731","gljg":"兴证证券资产管理有限公司","slrq":"2018-06-06","slrqTimestamp":1528214400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":25112.06,"clscyhs":"199","tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail
     * .html?id=1806121407101824","fedjjg":null},{"id":1806211654103931,"cpmc":"海通年年旺100号集合资产管理计划","cpbm":"SEB118","gljg":"上海海通证券资产管理有限公司","slrq":"2018-06-05","slrqTimestamp":1528128000000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":4370.1,"clscyhs":"30","tgjg":"国泰君安证券股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654103931","fedjjg":null},{"id":1806111617106147,"cpmc":"山西证券恒利3号集合资产管理计划","cpbm":"SCZ794","gljg":"山西证券股份有限公司","slrq":"2018-06-05","slrqTimestamp":1528128000000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":4625,"clscyhs":"19","tgjg":"中国光大银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806111617106147","fedjjg":null}],"page":{"pageSize":50,"pageIndex":1,"totalPageCount":150,"totalCount":7482}},"aoinProducts":{"list":[{"id":188,"url":"http://gs.amac.org
     * .cn/amac-infodisc/res/aoin/product/188.html","name":"吉林省现代农业和新兴产业投资基金有限公司","code":"S32187","aoinName":"海通开元投资有限公司","managerName":"海通吉禾股权投资基金管理有限责任公司","createDate":1291420800000},{"id":189,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/189.html","name":"西安航天新能源产业基金投资有限公司","code":"S32088","aoinName":"海通开元投资有限公司","managerName":"海通创新资本管理有限公司","createDate":1294444800000},{"id":644,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/644.html","name":"吉林昊融股权投资基金有限责任公司","code":"S32333","aoinName":"东证融通投资管理有限公司","managerName":"吉林东证昊融股权投资基金管理有限公司","createDate":1299110400000},{"id":193,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/193.html","name":"中金佳泰（天津）股权投资基金合伙企业（有限合伙）","code":"S32087","aoinName":"中金佳成投资管理有限公司","managerName":"中金佳合（天津）股权投资基金管理有限公司","createDate":1301702400000},{"id":767,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/767.html","name":"招商湘江产业投资有限公司","code":"S32410","aoinName":"招商证券股份有限公司直投子公司",
     * "managerName":"青岛招商致远投资管理有限公司","createDate":1309392000000},{"id":191,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/191.html","name":"上海诚毅新能源创业投资有限公司","code":"S32086","aoinName":"上海东方证券资本投资有限公司","managerName":"上海诚毅投资管理有限公司","createDate":1310428800000},{"id":199,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/199.html","name":"湖北新能源创业投资基金有限公司","code":"S32085","aoinName":"长江成长资本投资有限公司","managerName":"湖北新能源投资管理有限公司","createDate":1327104000000},{"id":190,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/190.html","name":"上海文化产业股权投资基金合伙企业（有限合伙）","code":"S32084","aoinName":"海通开元投资有限公司","managerName":"海通创意资本管理有限公司","createDate":1346630400000},{"id":196,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/196.html","name":"中信并购投资基金（深圳）合伙企业（有限合伙）","code":"S32083","aoinName":"金石投资有限公司","managerName":"中信并购基金管理有限公司","createDate":1352937600000},{"id":200,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/200.html","name":"北京润信鼎泰投资中心
     * (有限合伙）","code":"S32100","aoinName":"中信建投资本管理有限公司","managerName":"中信建投资本管理有限公司","createDate":1353283200000},{"id":192,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/192.html","name":"甘肃生物医药产业创业投资基金有限公司","code":"S32078","aoinName":"金城资本管理有限公司","managerName":"金城资本管理有限公司","createDate":1354752000000},{"id":195,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/195.html","name":"青岛金石泓信投资中心（有限合伙）","code":"S32081","aoinName":"金石投资有限公司","managerName":"金石投资有限公司","createDate":1354752000000},{"id":198,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/198.html","name":"天津海通创新股权投资合伙企业（有限合伙）","code":"S32079","aoinName":"海通开元投资有限公司","managerName":"海通创新资本管理有限公司","createDate":1356307200000},{"id":202,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/202.html","name":"甘肃现代农业产业创业投资基金有限公司","code":"S32080","aoinName":"金城资本管理有限公司","managerName":"甘肃华龙金城投资管理有限公司","createDate":1356393600000},{"id":185,"url":"http://gs.amac.org
     * .cn/amac-infodisc/res/aoin/product/185.html","name":"深圳市远盛发展一期股权投资企业（有限合伙）","code":"S32077","aoinName":"招商致远资本投资有限公司","managerName":"深圳市远盛投资管理有限公司","createDate":1356480000000},{"id":194,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/194.html","name":"华泰紫金（江苏）股权投资基金（有限合伙）","code":"S32076","aoinName":"华泰紫金投资有限责任公司","managerName":"华泰瑞通投资管理有限公司","createDate":1357862400000},{"id":301,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/301.html","name":"武汉惠人生物创业投资基金中心（有限合伙）","code":"S32075","aoinName":"天风天睿投资有限公司","managerName":"武汉光谷创投基金管理有限公司","createDate":1360281600000},{"id":197,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/197.html","name":"新疆华融天泽鼎鑫投资合伙企业（有限合伙）","code":"S32105","aoinName":"华融天泽投资有限公司","managerName":"华融天泽投资有限公司","createDate":1363219200000},{"id":201,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/201.html","name":"新疆广发信德广电夹层投资有限合伙企业","code":"S32073","aoinName":"广发信德投资管理有限公司","managerName":"新疆广发信德稳胜投资管理有限公司",
     * "createDate":1364169600000},{"id":207,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/207.html","name":"成都金智百业源股权投资基金","code":"S32072","aoinName":"华西金智投资有限责任公司","managerName":"成都金智全胜股权投资基金管理有限公司","createDate":1366156800000},{"id":184,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/184.html","name":"厦门国海坚果创业投资合伙企业（有限合伙）","code":"S32071","aoinName":"国海创新资本投资管理有限公司","managerName":"厦门国海坚果投资管理有限公司","createDate":1367798400000},{"id":186,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/186.html","name":"上海远杉投资合伙企业（有限合伙）","code":"S32070","aoinName":"招商致远资本投资有限公司","managerName":"北京致远励新投资管理有限公司","createDate":1368057600000},{"id":225,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/225.html","name":"吉林省国家新材料产业创业投资有限责任公司","code":"S32001","aoinName":"第一创业投资管理有限公司","managerName":"北京一创吉星创业投资管理有限公司","createDate":1369353600000},{"id":187,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/187.html","name":"福建兴证战略创业投资企业（有限合伙）",
     * "code":"S32069","aoinName":"兴业创新资本管理有限公司","managerName":"福建兴证创富股权投资管理有限公司","createDate":1370736000000},{"id":339,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/339.html","name":"山西中小企业创业投资基金（有限合伙）","code":"S32140","aoinName":"龙华启富投资有限责任公司","managerName":"山证基金管理有限公司","createDate":1372377600000},{"id":220,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/220.html","name":"深圳市国信弘盛股权投资基金（有限合伙）","code":"S32068","aoinName":"国信弘盛创业投资有限公司","managerName":"深圳市国信弘盛股权投资基金管理有限公司","createDate":1372723200000},{"id":203,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/203.html","name":"赣州致发投资合伙企业（有限合伙）","code":"S32067","aoinName":"招商致远资本投资有限公司","managerName":"江西致远发展投资管理有限公司","createDate":1373328000000},{"id":206,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/206.html","name":"北京宏源循环能源投资中心（有限合伙）","code":"S32066","aoinName":"宏源汇富创业投资有限公司","managerName":"宏源循环能源投资管理（北京）有限公司","createDate":1374105600000},{"id":210,"url":"http://gs.amac.org
     * .cn/amac-infodisc/res/aoin/product/210.html","name":"赣州致汇投资合伙企业（有限合伙）","code":"S32065","aoinName":"招商致远资本投资有限公司","managerName":"江西致远发展投资管理有限公司","createDate":1374537600000},{"id":208,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/208.html","name":"赣州招联投资合伙企业（有限合伙）","code":"S32002","aoinName":"招商致远资本投资有限公司","managerName":"江西招联投资管理有限公司","createDate":1374624000000},{"id":222,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/222.html","name":"锦绣中原（洛阳）创业投资中心（有限合伙）","code":"S32064","aoinName":"海通开元投资有限公司","managerName":"海通创新资本管理有限公司","createDate":1374624000000},{"id":204,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/204.html","name":"辽宁海通新能源低碳产业股权投资基金有限公司","code":"S32063","aoinName":"海通开元投资有限公司","managerName":"海通新能源股权投资管理有限公司","createDate":1375920000000},{"id":647,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/647.html","name":"宁波达泰投资合伙企业（有限合伙）","code":"S32330","aoinName":"信达证券股份有限公司直投子公司","managerName":"信风投资管理有限公司",
     * "createDate":1376006400000},{"id":215,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/215.html","name":"赣州致结投资合伙企业（有限合伙）","code":"S32062","aoinName":"招商致远资本投资有限公司","managerName":"江西致远发展投资管理有限公司","createDate":1376524800000},{"id":205,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/205.html","name":"赣州励结投资合伙企业（有限合伙）","code":"S32061","aoinName":"招商致远资本投资有限公司","managerName":"北京致远励新投资管理有限公司","createDate":1376611200000},{"id":209,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/209.html","name":"福建兴杭战略创业投资企业（有限合伙）","code":"S32060","aoinName":"兴业创新资本管理有限公司","managerName":"福建兴证兴杭股权投资管理有限公司","createDate":1377129600000},{"id":218,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/218.html","name":"新疆华融天泽鼎丰投资合伙企业（有限合伙）","code":"S32059","aoinName":"华融天泽投资有限公司","managerName":"华融天泽投资有限公司","createDate":1377216000000},{"id":211,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/211.html","name":"中投长春国家光电信息创业投资基金（有限合伙）","code":"S32058",
     * "aoinName":"瑞石投资管理有限责任公司","managerName":"中投长春创业投资基金管理有限公司","createDate":1377820800000},{"id":212,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/212.html","name":"深圳市长城弘瑞商业并购基金合伙企业（有限合伙）","code":"S32057","aoinName":"深圳市长城长富投资管理有限公司","managerName":"北京长城弘瑞投资管理有限公司","createDate":1378080000000},{"id":213,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/213.html","name":"赣州招商致远壹号股权投资合伙企业（有限合伙）","code":"S32120","aoinName":"招商致远资本投资有限公司","managerName":"赣州招商致远壹号股权投资管理有限公司","createDate":1379030400000},{"id":214,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/214.html","name":"河南中证开元创业投资基金（有限合伙）","code":"S32055","aoinName":"中鼎开源创业投资管理有限公司","managerName":"河南中证开元创业投资基金管理有限公司","createDate":1379376000000},{"id":229,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/229.html","name":"珠海广发信德新湖夹层投资有限合伙企业","code":"S32054","aoinName":"广发信德投资管理有限公司","managerName":"新疆广发信德稳胜投资管理有限公司","createDate":1380153600000},{"id":217,"url":"http://gs.amac.org
     * .cn/amac-infodisc/res/aoin/product/217.html","name":"深圳一创中科垃圾焚烧发电基金企业（有限合伙）","code":"S32053","aoinName":"第一创业投资管理有限公司","managerName":"深圳一创创盈投资管理有限公司","createDate":1381968000000},{"id":231,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/231.html","name":"广发信德（珠海）医疗产业投资中心（有限合伙）","code":"S32052","aoinName":"广发信德投资管理有限公司","managerName":"广发信德医疗资本管理有限公司","createDate":1381968000000},{"id":243,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/243.html","name":"赣州远发投资合伙企业（有限合伙）","code":"S32051","aoinName":"招商致远资本投资有限公司","managerName":"赣州招远投资管理有限公司","createDate":1382054400000},{"id":216,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/216.html","name":"赣州瑞结投资合伙企业（有限合伙）","code":"S32050","aoinName":"招商致远资本投资有限公司","managerName":"赣州招远投资管理有限公司","createDate":1382918400000},{"id":843,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/843.html","name":"赣州壹申投资合伙企业 （有限合伙）","code":"S32452","aoinName":"招商证券股份有限公司直投子公司","managerName":"赣州招商致远壹号股权投资管理有限公司",
     * "createDate":1384905600000},{"id":687,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/687.html","name":"赣州壹泰投资合伙企业 （有限合伙）","code":"S32359","aoinName":"招商证券股份有限公司直投子公司","managerName":"赣州招商致远壹号股权投资管理有限公司","createDate":1385424000000},{"id":1356,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/1356.html","name":"宁波信诚喜兆投资合伙企业（有限合伙）","code":"S32595","aoinName":"信达证券股份有限公司直投子公司","managerName":"信风投资管理有限公司","createDate":1385596800000},{"id":287,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/287.html","name":"北京华融鼎智投资合伙企业（有限合伙）","code":"S32192","aoinName":"华融天泽投资有限公司","managerName":"华融天泽投资有限公司","createDate":1386201600000}],"page":{"pageSize":50,"pageIndex":1,"totalPageCount":13,"totalCount":609}}}
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
         * pofFutures : {"list":[{"id":831000088201,"url":"http://gs.amac.org.cn/amac-infodisc/res/pof/futures/detail.html?id=831000088201","mpiName":"和合资管-臻选5号资产管理计划","mpiProductCode":"SW2928","aoiName":"和合资产管理（上海）有限公司","mpiTrustee":"招商银行股份有限公司","mgrName":null,"mpiCreateDate":"2017-07-25","mpiCreateDateTimestamp":1500912000000,"tzlx":"混合类产品","castProduct":null,"mpiTotalMoney":15500,"sfjgh":"否","mpiParticipationUser":83},{"id":831000085652,"url":"http://gs.amac.org.cn/amac-infodisc/res/pof/futures/detail.html?id=831000085652","mpiName":"银河期货钢铁1号资产管理计划","mpiProductCode":"SW3299","aoiName":"银河期货有限公司","mpiTrustee":"招商证券股份有限公司","mgrName":null,"mpiCreateDate":"2017-07-25","mpiCreateDateTimestamp":1500912000000,"tzlx":"期货及其他衍生品类产品","castProduct":null,"mpiTotalMoney":200,"sfjgh":"否","mpiParticipationUser":2},{"id":831000085642,"url":"http://gs.amac.org.cn/amac-infodisc/res/pof/futures/detail.html?id=831000085642","mpiName":"和合资管-瀚亚安心保17号集合资产管理计划","mpiProductCode":"SW2929",
         * "aoiName":"和合资产管理（上海）有限公司","mpiTrustee":"招商银行股份有限公司","mgrName":null,"mpiCreateDate":"2017-07-25","mpiCreateDateTimestamp":1500912000000,"tzlx":"混合类产品","castProduct":null,"mpiTotalMoney":9010,"sfjgh":"否","mpiParticipationUser":64},{"id":831000085638,"url":"http://gs.amac.org.cn/amac-infodisc/res/pof/futures/detail.html?id=831000085638","mpiName":"国富期货天长29号资产管理计划","mpiProductCode":"SW5785","aoiName":"国富期货有限公司","mpiTrustee":"平安银行股份有限公司","mgrName":null,"mpiCreateDate":"2017-07-25","mpiCreateDateTimestamp":1500912000000,"tzlx":"混合类产品","castProduct":null,"mpiTotalMoney":200,"sfjgh":"否","mpiParticipationUser":2},{"id":831000085636,"url":"http://gs.amac.org.cn/amac-infodisc/res/pof/futures/detail.html?id=831000085636","mpiName":"中州星升聚融1号资产管理计划","mpiProductCode":"SW5282","aoiName":"中州星升资产管理有限责任公司","mpiTrustee":"中信建投证券股份有限公司","mgrName":null,"mpiCreateDate":"2017-07-25","mpiCreateDateTimestamp":1500912000000,"tzlx":"混合类产品","castProduct":null,"mpiTotalMoney":210,"sfjgh":"否",
         * "mpiParticipationUser":2},{"id":831000085633,"url":"http://gs.amac.org.cn/amac-infodisc/res/pof/futures/detail.html?id=831000085633","mpiName":"招金期货-融承量化劲龙1号资产管理计划","mpiProductCode":"SW5715","aoiName":"招金期货有限公司","mpiTrustee":"广发证券股份有限公司","mgrName":null,"mpiCreateDate":"2017-07-25","mpiCreateDateTimestamp":1500912000000,"tzlx":"期货及其他衍生品类产品","castProduct":null,"mpiTotalMoney":600,"sfjgh":"否","mpiParticipationUser":2},{"id":831000085627,"url":"http://gs.amac.org.cn/amac-infodisc/res/pof/futures/detail.html?id=831000085627","mpiName":"国投安信期货-鑫泰1号资产管理计划","mpiProductCode":"SW5496","aoiName":"国投安信期货有限公司","mpiTrustee":"恒泰证券股份有限公司","mgrName":null,"mpiCreateDate":"2017-07-25","mpiCreateDateTimestamp":1500912000000,"tzlx":"混合类产品","castProduct":null,"mpiTotalMoney":200,"sfjgh":"否","mpiParticipationUser":2}],"page":{"pageSize":50,"pageIndex":1,"totalPageCount":1,"totalCount":7}}
         * pofSecurities : {"list":[{"id":1807091718109844,"cpmc":"兴证资管年年鑫17号集合资产管理计划","cpbm":"SEE136","gljg":"兴证证券资产管理有限公司","slrq":"2018-07-04","slrqTimestamp":1530633600000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":63096,"clscyhs":"199","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718109844","fedjjg":null},{"id":1807091718109816,"cpmc":"太平洋证券红珊瑚春城1号集合资产管理计划","cpbm":"SEE239","gljg":"太平洋证券股份有限公司","slrq":"2018-07-04","slrqTimestamp":1530633600000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":45100,"clscyhs":"2","tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718109816","fedjjg":null},{"id":1807091718100219,"cpmc":"中金聚鑫二号集合资产管理计划","cpbm":"SEB574","gljg":"中国国际金融股份有限公司","slrq":"2018-06-29","slrqTimestamp":1530201600000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,
         * "tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":19750.24,"clscyhs":"43","tgjg":"中信建投证券股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718100219","fedjjg":null},{"id":1807091718100122,"cpmc":"首创证券致胜7号集合资产管理计划","cpbm":"SEC230","gljg":"首创证券有限责任公司","slrq":"2018-06-29","slrqTimestamp":1530201600000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":7912.11,"clscyhs":"55","tgjg":"上海浦东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718100122","fedjjg":null},{"id":1807091718104858,"cpmc":"中信建投稳健添益7号集合资产管理计划","cpbm":"SED021","gljg":"中信建投证券股份有限公司","slrq":"2018-06-27","slrqTimestamp":1530028800000,"dqr":"2028-06-27","dqrTimestamp":1845648000000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":5145.94,"clscyhs":"11","tgjg":"上海浦东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718104858","fedjjg":null},
         * {"id":1807091718104674,"cpmc":"太平洋证券金元宝8号集合资产管理计划","cpbm":"SED644","gljg":"太平洋证券股份有限公司","slrq":"2018-06-27","slrqTimestamp":1530028800000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":9945,"clscyhs":"20","tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718104674","fedjjg":null},{"id":1807090927109635,"cpmc":"兴证资管年年鑫106号集合资产管理计划","cpbm":"SED181","gljg":"兴证证券资产管理有限公司","slrq":"2018-06-27","slrqTimestamp":1530028800000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":26499,"clscyhs":"199","tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807090927109635","fedjjg":null},{"id":1807090927109269,"cpmc":"首创证券创享2号集合资产管理计划","cpbm":"SEC223","gljg":"首创证券有限责任公司","slrq":"2018-06-27","slrqTimestamp":1530028800000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否",
         * "glfs":null,"clgm":20961.29,"clscyhs":"142","tgjg":"中国光大银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807090927109269","fedjjg":null},{"id":1807091718105017,"cpmc":"申万宏源鑫丰臻选1号FOF集合资产管理计划","cpbm":"SED001","gljg":"申万宏源证券有限公司","slrq":"2018-06-26","slrqTimestamp":1529942400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"混合类产品","sffj":"否","glfs":null,"clgm":3291,"clscyhs":"27","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718105017","fedjjg":null},{"id":1807091718104900,"cpmc":"申万宏源鑫丰臻选2号FOF集合资产管理计划","cpbm":"SED002","gljg":"申万宏源证券有限公司","slrq":"2018-06-26","slrqTimestamp":1529942400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"混合类产品","sffj":"否","glfs":null,"clgm":10013,"clscyhs":"88","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718104900","fedjjg":null},{"id":1807091718104718,
         * "cpmc":"华泰紫金投融共赢6号集合资产管理计划","cpbm":"SED245","gljg":"华泰证券（上海）资产管理有限公司","slrq":"2018-06-26","slrqTimestamp":1529942400000,"dqr":"2019-07-01","dqrTimestamp":1561910400000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":15344,"clscyhs":"45","tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718104718","fedjjg":null},{"id":1807091718100342,"cpmc":"广发资管尊享利21号集合资产管理计划","cpbm":"SED353","gljg":"广发证券资产管理（广东）有限公司","slrq":"2018-06-26","slrqTimestamp":1529942400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":10100,"clscyhs":"61","tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718100342","fedjjg":null},{"id":1807021619101459,"cpmc":"财通证券资管年年赢108号集合资产管理计划","cpbm":"SED061","gljg":"财通证券资产管理有限公司","slrq":"2018-06-26","slrqTimestamp":1529942400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,
         * "clgm":23253.8,"clscyhs":"171","tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807021619101459","fedjjg":null},{"id":1807021619101093,"cpmc":"申万宏源证券稳赢30号集合资产管理计划","cpbm":"SED005","gljg":"申万宏源证券有限公司","slrq":"2018-06-22","slrqTimestamp":1529596800000,"dqr":"2023-06-22","dqrTimestamp":1687363200000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":35815.31,"clscyhs":"200","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807021619101093","fedjjg":null},{"id":1807021619100996,"cpmc":"申万宏源证券稳赢23集合资产管理计划","cpbm":"SED077","gljg":"申万宏源证券有限公司","slrq":"2018-06-22","slrqTimestamp":1529596800000,"dqr":"2021-06-21","dqrTimestamp":1624204800000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":10835.3,"clscyhs":"66","tgjg":"上海银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807021619100996","fedjjg":null},{"id":1807021619101324,"cpmc":"山西证券启明1号集合资产管理计划",
         * "cpbm":"SEA960","gljg":"山西证券股份有限公司","slrq":"2018-06-21","slrqTimestamp":1529510400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":14635.56,"clscyhs":"108","tgjg":"中国光大银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807021619101324","fedjjg":null},{"id":1807021619100805,"cpmc":"五矿证券五丰稳利1号集合资产管理计划","cpbm":"SEB983","gljg":"五矿证券有限公司","slrq":"2018-06-21","slrqTimestamp":1529510400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":22133,"clscyhs":"163","tgjg":"中国光大银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807021619100805","fedjjg":null},{"id":1807091718100435,"cpmc":"中投证券宁福364天5号集合资产管理计划","cpbm":"SEC382","gljg":"中国中投证券有限责任公司","slrq":"2018-06-20","slrqTimestamp":1529424000000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":3790.04,"clscyhs":"3",
         * "tgjg":"宁波银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718100435","fedjjg":null},{"id":1806251446107384,"cpmc":"中银证券中国红-黄山8号第22期固定收益类集合资产管理计划","cpbm":"SEC508","gljg":"中银国际证券股份有限公司","slrq":"2018-06-20","slrqTimestamp":1529424000000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":38470,"clscyhs":"160","tgjg":"中国银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446107384","fedjjg":null},{"id":1806251446107700,"cpmc":"东证融汇汇享26号集合资产管理计划","cpbm":"SEA161","gljg":"东证融汇证券资产管理有限公司","slrq":"2018-06-19","slrqTimestamp":1529337600000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":7706,"clscyhs":"9","tgjg":"广东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446107700","fedjjg":null},{"id":1806251446107194,"cpmc":"中银证券中国红-黄山8号第21期固定收益类集合资产管理计划",
         * "cpbm":"SEC459","gljg":"中银国际证券股份有限公司","slrq":"2018-06-19","slrqTimestamp":1529337600000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":29960,"clscyhs":"159","tgjg":"中国银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446107194","fedjjg":null},{"id":1806261720103897,"cpmc":"申万宏源证券稳赢49号集合资产管理计划","cpbm":"SEC574","gljg":"申万宏源证券有限公司","slrq":"2018-06-15","slrqTimestamp":1528992000000,"dqr":"2023-06-14","dqrTimestamp":1686672000000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":39772.9,"clscyhs":"197","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806261720103897","fedjjg":null},{"id":1806251446107009,"cpmc":"申万宏源证券稳赢35号集合资产管理计划","cpbm":"SEC125","gljg":"申万宏源证券有限公司","slrq":"2018-06-15","slrqTimestamp":1528992000000,"dqr":"2023-06-15","dqrTimestamp":1686758400000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":19657,"clscyhs":"127",
         * "tgjg":"中国邮政储蓄银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446107009","fedjjg":null},{"id":1806211654104790,"cpmc":"华泰紫金信用1号集合资产管理计划","cpbm":"SEC157","gljg":"华泰证券（上海）资产管理有限公司","slrq":"2018-06-15","slrqTimestamp":1528992000000,"dqr":"2023-06-15","dqrTimestamp":1686758400000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":10472.09,"clscyhs":"75","tgjg":"平安银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654104790","fedjjg":null},{"id":1806211654104601,"cpmc":"兴证资管年年鑫105号集合资产管理计划","cpbm":"SEC129","gljg":"兴证证券资产管理有限公司","slrq":"2018-06-15","slrqTimestamp":1528992000000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":20597.31,"clscyhs":"159","tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654104601","fedjjg":null},{"id":1806211654104306,"cpmc":"首创证券创享1号集合资产管理计划","cpbm":"SEB330",
         * "gljg":"首创证券有限责任公司","slrq":"2018-06-15","slrqTimestamp":1528992000000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":15649.15,"clscyhs":"116","tgjg":"中国光大银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654104306","fedjjg":null},{"id":1806211654103985,"cpmc":"广发资管尊享利19号集合资产管理计划","cpbm":"SEC259","gljg":"广发证券资产管理（广东）有限公司","slrq":"2018-06-14","slrqTimestamp":1528905600000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":12364,"clscyhs":"52","tgjg":"广东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654103985","fedjjg":null},{"id":1807091718100295,"cpmc":"国泰君安君越优享多策略1号集合资产管理计划","cpbm":"SEC027","gljg":"上海国泰君安证券资产管理有限公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":3100,"clscyhs":"13",
         * "tgjg":"招商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718100295","fedjjg":null},{"id":1807090927109477,"cpmc":"国金慧多利债券2号集合资产管理计划","cpbm":"SEB333","gljg":"国金证券股份有限公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":4160.04,"clscyhs":"17","tgjg":"招商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807090927109477","fedjjg":null},{"id":1806261720104125,"cpmc":"申万宏源证券稳赢31号集合资产管理计划","cpbm":"SEC517","gljg":"申万宏源证券有限公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"2023-06-13","dqrTimestamp":1686585600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":13545,"clscyhs":"83","tgjg":"中国邮政储蓄银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806261720104125","fedjjg":null},{"id":1806251446107669,"cpmc":"东证融汇汇享27号集合资产管理计划","cpbm":"SEB322",
         * "gljg":"东证融汇证券资产管理有限公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":20100,"clscyhs":"2","tgjg":"广东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446107669","fedjjg":null},{"id":1806251446106903,"cpmc":"申万宏源证券稳赢37号集合资产管理计划","cpbm":"SEB852","gljg":"申万宏源证券有限公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"2021-06-13","dqrTimestamp":1623513600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":16300,"clscyhs":"65","tgjg":"上海银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446106903","fedjjg":null},{"id":1806211654104518,"cpmc":"首创证券泽鑫3号集合资产管理计划","cpbm":"SEB296","gljg":"首创证券有限责任公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":7144,"clscyhs":"44","tgjg":"华夏银行股份有限公司",
         * "url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654104518","fedjjg":null},{"id":1806211654104158,"cpmc":"海通海蓝增益2号集合资产管理计划","cpbm":"SCX377","gljg":"上海海通证券资产管理有限公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"2020-06-12","dqrTimestamp":1591891200000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":21506,"clscyhs":"124","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654104158","fedjjg":null},{"id":1806211654103707,"cpmc":"招商智远全景多策略集合资产管理计划","cpbm":"SEB616","gljg":"招商证券资产管理有限公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"2028-06-12","dqrTimestamp":1844352000000,"tzlx":"混合类产品","sffj":"否","glfs":null,"clgm":5252.68,"clscyhs":"30","tgjg":"上海浦东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654103707","fedjjg":null},{"id":1806211654103672,"cpmc":"长城证券金徽酒增持1号集合资产管理计划","cpbm":"SEB516","gljg":"长城证券股份有限公司",
         * "slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"权益类产品","sffj":"否","glfs":null,"clgm":8500,"clscyhs":"13","tgjg":"平安银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654103672","fedjjg":null},{"id":1806251446107752,"cpmc":"兴证资管玉麒麟定制7号集合资产管理计划","cpbm":"SEB511","gljg":"兴证证券资产管理有限公司","slrq":"2018-06-12","slrqTimestamp":1528732800000,"dqr":"2021-06-11","dqrTimestamp":1623340800000,"tzlx":"混合类产品","sffj":"否","glfs":null,"clgm":3000,"clscyhs":"2","tgjg":"上海浦东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446107752","fedjjg":null},{"id":1806251446105993,"cpmc":"渤海汇金璞盈8号集合资产管理计划","cpbm":"SY9641","gljg":"渤海汇金证券资产管理有限公司","slrq":"2018-06-12","slrqTimestamp":1528732800000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":28900.83,"clscyhs":"194","tgjg":"上海浦东发展银行股份有限公司","url":"http://gs.amac
         * .org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446105993","fedjjg":null},{"id":1806251446105835,"cpmc":"德邦浦华优选18号集合资产管理计划","cpbm":"SEB004","gljg":"德邦证券股份有限公司","slrq":"2018-06-12","slrqTimestamp":1528732800000,"dqr":"2019-07-12","dqrTimestamp":1562860800000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":9950,"clscyhs":"64","tgjg":"上海浦东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446105835","fedjjg":null},{"id":1806211654104449,"cpmc":"东吴汇天益10号集合资产管理计划","cpbm":"SEB595","gljg":"东吴证券股份有限公司","slrq":"2018-06-12","slrqTimestamp":1528732800000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":8045,"clscyhs":"42","tgjg":"宁波银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654104449","fedjjg":null},{"id":1806211654103633,"cpmc":"东证融汇汇享25号集合资产管理计划","cpbm":"SCY653","gljg":"东证融汇证券资产管理有限公司","slrq":"2018-06-12",
         * "slrqTimestamp":1528732800000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":4417,"clscyhs":"10","tgjg":"广东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654103633","fedjjg":null},{"id":1806211654103395,"cpmc":"申万宏源证券稳赢34号集合资产管理计划","cpbm":"SEB872","gljg":"申万宏源证券有限公司","slrq":"2018-06-08","slrqTimestamp":1528387200000,"dqr":"2023-06-08","dqrTimestamp":1686153600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":13235.12,"clscyhs":"88","tgjg":"中国邮政储蓄银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654103395","fedjjg":null},{"id":1806211654102315,"cpmc":"兴证资管浦兴年年利4号集合资产管理计划","cpbm":"SEA975","gljg":"兴证证券资产管理有限公司","slrq":"2018-06-08","slrqTimestamp":1528387200000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":15157.21,"clscyhs":"111","tgjg":"上海浦东发展银行股份有限公司","url":"http://gs.amac.org
         * .cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654102315","fedjjg":null},{"id":1806211654102456,"cpmc":"申万宏源证券稳赢40号集合资产管理计划","cpbm":"SEB135","gljg":"申万宏源证券有限公司","slrq":"2018-06-07","slrqTimestamp":1528300800000,"dqr":"2021-06-07","dqrTimestamp":1622995200000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":12191.4,"clscyhs":"77","tgjg":"上海银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654102456","fedjjg":null},{"id":1806191720100562,"cpmc":"申万宏源证券稳赢46号集合资产管理计划","cpbm":"SEB818","gljg":"申万宏源证券有限公司","slrq":"2018-06-07","slrqTimestamp":1528300800000,"dqr":"2023-06-07","dqrTimestamp":1686067200000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":37188.6,"clscyhs":"194","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806191720100562","fedjjg":null},{"id":1806121407102422,"cpmc":"兴证资管年年鑫20号集合资产管理计划","cpbm":"SEB018","gljg":"兴证证券资产管理有限公司","slrq":"2018-06-07",
         * "slrqTimestamp":1528300800000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":4330.34,"clscyhs":"9","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806121407102422","fedjjg":null},{"id":1806121407102622,"cpmc":"兴证资管年年鑫16号集合资产管理计划","cpbm":"SEA729","gljg":"兴证证券资产管理有限公司","slrq":"2018-06-06","slrqTimestamp":1528214400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":11606.29,"clscyhs":"88","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806121407102622","fedjjg":null},{"id":1806121407101824,"cpmc":"兴证资管年年鑫102号集合资产管理计划","cpbm":"SEA731","gljg":"兴证证券资产管理有限公司","slrq":"2018-06-06","slrqTimestamp":1528214400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":25112.06,"clscyhs":"199","tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org
         * .cn/amac-infodisc/res/pof/securities/detail.html?id=1806121407101824","fedjjg":null},{"id":1806211654103931,"cpmc":"海通年年旺100号集合资产管理计划","cpbm":"SEB118","gljg":"上海海通证券资产管理有限公司","slrq":"2018-06-05","slrqTimestamp":1528128000000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":4370.1,"clscyhs":"30","tgjg":"国泰君安证券股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654103931","fedjjg":null},{"id":1806111617106147,"cpmc":"山西证券恒利3号集合资产管理计划","cpbm":"SCZ794","gljg":"山西证券股份有限公司","slrq":"2018-06-05","slrqTimestamp":1528128000000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":4625,"clscyhs":"19","tgjg":"中国光大银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806111617106147","fedjjg":null}],"page":{"pageSize":50,"pageIndex":1,"totalPageCount":150,"totalCount":7482}}
         * aoinProducts : {"list":[{"id":188,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/188.html","name":"吉林省现代农业和新兴产业投资基金有限公司","code":"S32187","aoinName":"海通开元投资有限公司","managerName":"海通吉禾股权投资基金管理有限责任公司","createDate":1291420800000},{"id":189,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/189.html","name":"西安航天新能源产业基金投资有限公司","code":"S32088","aoinName":"海通开元投资有限公司","managerName":"海通创新资本管理有限公司","createDate":1294444800000},{"id":644,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/644.html","name":"吉林昊融股权投资基金有限责任公司","code":"S32333","aoinName":"东证融通投资管理有限公司","managerName":"吉林东证昊融股权投资基金管理有限公司","createDate":1299110400000},{"id":193,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/193.html","name":"中金佳泰（天津）股权投资基金合伙企业（有限合伙）","code":"S32087","aoinName":"中金佳成投资管理有限公司","managerName":"中金佳合（天津）股权投资基金管理有限公司","createDate":1301702400000},{"id":767,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/767.html","name":"招商湘江产业投资有限公司",
         * "code":"S32410","aoinName":"招商证券股份有限公司直投子公司","managerName":"青岛招商致远投资管理有限公司","createDate":1309392000000},{"id":191,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/191.html","name":"上海诚毅新能源创业投资有限公司","code":"S32086","aoinName":"上海东方证券资本投资有限公司","managerName":"上海诚毅投资管理有限公司","createDate":1310428800000},{"id":199,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/199.html","name":"湖北新能源创业投资基金有限公司","code":"S32085","aoinName":"长江成长资本投资有限公司","managerName":"湖北新能源投资管理有限公司","createDate":1327104000000},{"id":190,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/190.html","name":"上海文化产业股权投资基金合伙企业（有限合伙）","code":"S32084","aoinName":"海通开元投资有限公司","managerName":"海通创意资本管理有限公司","createDate":1346630400000},{"id":196,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/196.html","name":"中信并购投资基金（深圳）合伙企业（有限合伙）","code":"S32083","aoinName":"金石投资有限公司","managerName":"中信并购基金管理有限公司","createDate":1352937600000},{"id":200,"url":"http://gs.amac.org
         * .cn/amac-infodisc/res/aoin/product/200.html","name":"北京润信鼎泰投资中心(有限合伙）","code":"S32100","aoinName":"中信建投资本管理有限公司","managerName":"中信建投资本管理有限公司","createDate":1353283200000},{"id":192,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/192.html","name":"甘肃生物医药产业创业投资基金有限公司","code":"S32078","aoinName":"金城资本管理有限公司","managerName":"金城资本管理有限公司","createDate":1354752000000},{"id":195,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/195.html","name":"青岛金石泓信投资中心（有限合伙）","code":"S32081","aoinName":"金石投资有限公司","managerName":"金石投资有限公司","createDate":1354752000000},{"id":198,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/198.html","name":"天津海通创新股权投资合伙企业（有限合伙）","code":"S32079","aoinName":"海通开元投资有限公司","managerName":"海通创新资本管理有限公司","createDate":1356307200000},{"id":202,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/202.html","name":"甘肃现代农业产业创业投资基金有限公司","code":"S32080","aoinName":"金城资本管理有限公司","managerName":"甘肃华龙金城投资管理有限公司","createDate":1356393600000},
         * {"id":185,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/185.html","name":"深圳市远盛发展一期股权投资企业（有限合伙）","code":"S32077","aoinName":"招商致远资本投资有限公司","managerName":"深圳市远盛投资管理有限公司","createDate":1356480000000},{"id":194,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/194.html","name":"华泰紫金（江苏）股权投资基金（有限合伙）","code":"S32076","aoinName":"华泰紫金投资有限责任公司","managerName":"华泰瑞通投资管理有限公司","createDate":1357862400000},{"id":301,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/301.html","name":"武汉惠人生物创业投资基金中心（有限合伙）","code":"S32075","aoinName":"天风天睿投资有限公司","managerName":"武汉光谷创投基金管理有限公司","createDate":1360281600000},{"id":197,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/197.html","name":"新疆华融天泽鼎鑫投资合伙企业（有限合伙）","code":"S32105","aoinName":"华融天泽投资有限公司","managerName":"华融天泽投资有限公司","createDate":1363219200000},{"id":201,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/201.html","name":"新疆广发信德广电夹层投资有限合伙企业","code":"S32073","aoinName":"广发信德投资管理有限公司",
         * "managerName":"新疆广发信德稳胜投资管理有限公司","createDate":1364169600000},{"id":207,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/207.html","name":"成都金智百业源股权投资基金","code":"S32072","aoinName":"华西金智投资有限责任公司","managerName":"成都金智全胜股权投资基金管理有限公司","createDate":1366156800000},{"id":184,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/184.html","name":"厦门国海坚果创业投资合伙企业（有限合伙）","code":"S32071","aoinName":"国海创新资本投资管理有限公司","managerName":"厦门国海坚果投资管理有限公司","createDate":1367798400000},{"id":186,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/186.html","name":"上海远杉投资合伙企业（有限合伙）","code":"S32070","aoinName":"招商致远资本投资有限公司","managerName":"北京致远励新投资管理有限公司","createDate":1368057600000},{"id":225,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/225.html","name":"吉林省国家新材料产业创业投资有限责任公司","code":"S32001","aoinName":"第一创业投资管理有限公司","managerName":"北京一创吉星创业投资管理有限公司","createDate":1369353600000},{"id":187,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/187.html",
         * "name":"福建兴证战略创业投资企业（有限合伙）","code":"S32069","aoinName":"兴业创新资本管理有限公司","managerName":"福建兴证创富股权投资管理有限公司","createDate":1370736000000},{"id":339,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/339.html","name":"山西中小企业创业投资基金（有限合伙）","code":"S32140","aoinName":"龙华启富投资有限责任公司","managerName":"山证基金管理有限公司","createDate":1372377600000},{"id":220,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/220.html","name":"深圳市国信弘盛股权投资基金（有限合伙）","code":"S32068","aoinName":"国信弘盛创业投资有限公司","managerName":"深圳市国信弘盛股权投资基金管理有限公司","createDate":1372723200000},{"id":203,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/203.html","name":"赣州致发投资合伙企业（有限合伙）","code":"S32067","aoinName":"招商致远资本投资有限公司","managerName":"江西致远发展投资管理有限公司","createDate":1373328000000},{"id":206,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/206.html","name":"北京宏源循环能源投资中心（有限合伙）","code":"S32066","aoinName":"宏源汇富创业投资有限公司","managerName":"宏源循环能源投资管理（北京）有限公司","createDate":1374105600000},{"id":210,
         * "url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/210.html","name":"赣州致汇投资合伙企业（有限合伙）","code":"S32065","aoinName":"招商致远资本投资有限公司","managerName":"江西致远发展投资管理有限公司","createDate":1374537600000},{"id":208,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/208.html","name":"赣州招联投资合伙企业（有限合伙）","code":"S32002","aoinName":"招商致远资本投资有限公司","managerName":"江西招联投资管理有限公司","createDate":1374624000000},{"id":222,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/222.html","name":"锦绣中原（洛阳）创业投资中心（有限合伙）","code":"S32064","aoinName":"海通开元投资有限公司","managerName":"海通创新资本管理有限公司","createDate":1374624000000},{"id":204,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/204.html","name":"辽宁海通新能源低碳产业股权投资基金有限公司","code":"S32063","aoinName":"海通开元投资有限公司","managerName":"海通新能源股权投资管理有限公司","createDate":1375920000000},{"id":647,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/647.html","name":"宁波达泰投资合伙企业（有限合伙）","code":"S32330","aoinName":"信达证券股份有限公司直投子公司",
         * "managerName":"信风投资管理有限公司","createDate":1376006400000},{"id":215,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/215.html","name":"赣州致结投资合伙企业（有限合伙）","code":"S32062","aoinName":"招商致远资本投资有限公司","managerName":"江西致远发展投资管理有限公司","createDate":1376524800000},{"id":205,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/205.html","name":"赣州励结投资合伙企业（有限合伙）","code":"S32061","aoinName":"招商致远资本投资有限公司","managerName":"北京致远励新投资管理有限公司","createDate":1376611200000},{"id":209,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/209.html","name":"福建兴杭战略创业投资企业（有限合伙）","code":"S32060","aoinName":"兴业创新资本管理有限公司","managerName":"福建兴证兴杭股权投资管理有限公司","createDate":1377129600000},{"id":218,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/218.html","name":"新疆华融天泽鼎丰投资合伙企业（有限合伙）","code":"S32059","aoinName":"华融天泽投资有限公司","managerName":"华融天泽投资有限公司","createDate":1377216000000},{"id":211,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/211.html",
         * "name":"中投长春国家光电信息创业投资基金（有限合伙）","code":"S32058","aoinName":"瑞石投资管理有限责任公司","managerName":"中投长春创业投资基金管理有限公司","createDate":1377820800000},{"id":212,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/212.html","name":"深圳市长城弘瑞商业并购基金合伙企业（有限合伙）","code":"S32057","aoinName":"深圳市长城长富投资管理有限公司","managerName":"北京长城弘瑞投资管理有限公司","createDate":1378080000000},{"id":213,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/213.html","name":"赣州招商致远壹号股权投资合伙企业（有限合伙）","code":"S32120","aoinName":"招商致远资本投资有限公司","managerName":"赣州招商致远壹号股权投资管理有限公司","createDate":1379030400000},{"id":214,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/214.html","name":"河南中证开元创业投资基金（有限合伙）","code":"S32055","aoinName":"中鼎开源创业投资管理有限公司","managerName":"河南中证开元创业投资基金管理有限公司","createDate":1379376000000},{"id":229,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/229.html","name":"珠海广发信德新湖夹层投资有限合伙企业","code":"S32054","aoinName":"广发信德投资管理有限公司","managerName":"新疆广发信德稳胜投资管理有限公司",
         * "createDate":1380153600000},{"id":217,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/217.html","name":"深圳一创中科垃圾焚烧发电基金企业（有限合伙）","code":"S32053","aoinName":"第一创业投资管理有限公司","managerName":"深圳一创创盈投资管理有限公司","createDate":1381968000000},{"id":231,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/231.html","name":"广发信德（珠海）医疗产业投资中心（有限合伙）","code":"S32052","aoinName":"广发信德投资管理有限公司","managerName":"广发信德医疗资本管理有限公司","createDate":1381968000000},{"id":243,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/243.html","name":"赣州远发投资合伙企业（有限合伙）","code":"S32051","aoinName":"招商致远资本投资有限公司","managerName":"赣州招远投资管理有限公司","createDate":1382054400000},{"id":216,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/216.html","name":"赣州瑞结投资合伙企业（有限合伙）","code":"S32050","aoinName":"招商致远资本投资有限公司","managerName":"赣州招远投资管理有限公司","createDate":1382918400000},{"id":843,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/843.html","name":"赣州壹申投资合伙企业 （有限合伙）",
         * "code":"S32452","aoinName":"招商证券股份有限公司直投子公司","managerName":"赣州招商致远壹号股权投资管理有限公司","createDate":1384905600000},{"id":687,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/687.html","name":"赣州壹泰投资合伙企业 （有限合伙）","code":"S32359","aoinName":"招商证券股份有限公司直投子公司","managerName":"赣州招商致远壹号股权投资管理有限公司","createDate":1385424000000},{"id":1356,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/1356.html","name":"宁波信诚喜兆投资合伙企业（有限合伙）","code":"S32595","aoinName":"信达证券股份有限公司直投子公司","managerName":"信风投资管理有限公司","createDate":1385596800000},{"id":287,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/287.html","name":"北京华融鼎智投资合伙企业（有限合伙）","code":"S32192","aoinName":"华融天泽投资有限公司","managerName":"华融天泽投资有限公司","createDate":1386201600000}],"page":{"pageSize":50,"pageIndex":1,"totalPageCount":13,"totalCount":609}}
         */

        private PofFuturesBean pofFutures;
        private PofSecuritiesBean pofSecurities;
        private AoinProductsBean aoinProducts;

        public PofFuturesBean getPofFutures() {
            return pofFutures;
        }

        public void setPofFutures(PofFuturesBean pofFutures) {
            this.pofFutures = pofFutures;
        }

        public PofSecuritiesBean getPofSecurities() {
            return pofSecurities;
        }

        public void setPofSecurities(PofSecuritiesBean pofSecurities) {
            this.pofSecurities = pofSecurities;
        }

        public AoinProductsBean getAoinProducts() {
            return aoinProducts;
        }

        public void setAoinProducts(AoinProductsBean aoinProducts) {
            this.aoinProducts = aoinProducts;
        }

        public static class PofFuturesBean {
            /**
             * list : [{"id":831000088201,"url":"http://gs.amac.org.cn/amac-infodisc/res/pof/futures/detail.html?id=831000088201","mpiName":"和合资管-臻选5号资产管理计划","mpiProductCode":"SW2928","aoiName":"和合资产管理（上海）有限公司","mpiTrustee":"招商银行股份有限公司","mgrName":null,"mpiCreateDate":"2017-07-25","mpiCreateDateTimestamp":1500912000000,"tzlx":"混合类产品","castProduct":null,"mpiTotalMoney":15500,"sfjgh":"否","mpiParticipationUser":83},{"id":831000085652,"url":"http://gs.amac.org.cn/amac-infodisc/res/pof/futures/detail.html?id=831000085652","mpiName":"银河期货钢铁1号资产管理计划","mpiProductCode":"SW3299","aoiName":"银河期货有限公司","mpiTrustee":"招商证券股份有限公司","mgrName":null,"mpiCreateDate":"2017-07-25","mpiCreateDateTimestamp":1500912000000,"tzlx":"期货及其他衍生品类产品","castProduct":null,"mpiTotalMoney":200,"sfjgh":"否","mpiParticipationUser":2},{"id":831000085642,"url":"http://gs.amac.org.cn/amac-infodisc/res/pof/futures/detail.html?id=831000085642","mpiName":"和合资管-瀚亚安心保17号集合资产管理计划","mpiProductCode":"SW2929","aoiName":"和合资产管理（上海）有限公司",
             * "mpiTrustee":"招商银行股份有限公司","mgrName":null,"mpiCreateDate":"2017-07-25","mpiCreateDateTimestamp":1500912000000,"tzlx":"混合类产品","castProduct":null,"mpiTotalMoney":9010,"sfjgh":"否","mpiParticipationUser":64},{"id":831000085638,"url":"http://gs.amac.org.cn/amac-infodisc/res/pof/futures/detail.html?id=831000085638","mpiName":"国富期货天长29号资产管理计划","mpiProductCode":"SW5785","aoiName":"国富期货有限公司","mpiTrustee":"平安银行股份有限公司","mgrName":null,"mpiCreateDate":"2017-07-25","mpiCreateDateTimestamp":1500912000000,"tzlx":"混合类产品","castProduct":null,"mpiTotalMoney":200,"sfjgh":"否","mpiParticipationUser":2},{"id":831000085636,"url":"http://gs.amac.org.cn/amac-infodisc/res/pof/futures/detail.html?id=831000085636","mpiName":"中州星升聚融1号资产管理计划","mpiProductCode":"SW5282","aoiName":"中州星升资产管理有限责任公司","mpiTrustee":"中信建投证券股份有限公司","mgrName":null,"mpiCreateDate":"2017-07-25","mpiCreateDateTimestamp":1500912000000,"tzlx":"混合类产品","castProduct":null,"mpiTotalMoney":210,"sfjgh":"否","mpiParticipationUser":2},
             * {"id":831000085633,"url":"http://gs.amac.org.cn/amac-infodisc/res/pof/futures/detail.html?id=831000085633","mpiName":"招金期货-融承量化劲龙1号资产管理计划","mpiProductCode":"SW5715","aoiName":"招金期货有限公司","mpiTrustee":"广发证券股份有限公司","mgrName":null,"mpiCreateDate":"2017-07-25","mpiCreateDateTimestamp":1500912000000,"tzlx":"期货及其他衍生品类产品","castProduct":null,"mpiTotalMoney":600,"sfjgh":"否","mpiParticipationUser":2},{"id":831000085627,"url":"http://gs.amac.org.cn/amac-infodisc/res/pof/futures/detail.html?id=831000085627","mpiName":"国投安信期货-鑫泰1号资产管理计划","mpiProductCode":"SW5496","aoiName":"国投安信期货有限公司","mpiTrustee":"恒泰证券股份有限公司","mgrName":null,"mpiCreateDate":"2017-07-25","mpiCreateDateTimestamp":1500912000000,"tzlx":"混合类产品","castProduct":null,"mpiTotalMoney":200,"sfjgh":"否","mpiParticipationUser":2}]
             * page : {"pageSize":50,"pageIndex":1,"totalPageCount":1,"totalCount":7}
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
                 * pageSize : 50
                 * pageIndex : 1
                 * totalPageCount : 1
                 * totalCount : 7
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
                 * id : 831000088201
                 * url : http://gs.amac.org.cn/amac-infodisc/res/pof/futures/detail.html?id=831000088201
                 * mpiName : 和合资管-臻选5号资产管理计划
                 * mpiProductCode : SW2928
                 * aoiName : 和合资产管理（上海）有限公司
                 * mpiTrustee : 招商银行股份有限公司
                 * mgrName : null
                 * mpiCreateDate : 2017-07-25
                 * mpiCreateDateTimestamp : 1500912000000
                 * tzlx : 混合类产品
                 * castProduct : null
                 * mpiTotalMoney : 15500
                 * sfjgh : 否
                 * mpiParticipationUser : 83
                 */

                private long id;
                private String url;
                private String mpiName;
                private String mpiProductCode;
                private String aoiName;
                private String mpiTrustee;
                private Object mgrName;
                private String mpiCreateDate;
                private long mpiCreateDateTimestamp;
                private String tzlx;
                private Object castProduct;
                private String mpiTotalMoney;
                private String sfjgh;
                private int mpiParticipationUser;

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getMpiName() {
                    return mpiName;
                }

                public void setMpiName(String mpiName) {
                    this.mpiName = mpiName;
                }

                public String getMpiProductCode() {
                    return mpiProductCode;
                }

                public void setMpiProductCode(String mpiProductCode) {
                    this.mpiProductCode = mpiProductCode;
                }

                public String getAoiName() {
                    return aoiName;
                }

                public void setAoiName(String aoiName) {
                    this.aoiName = aoiName;
                }

                public String getMpiTrustee() {
                    return mpiTrustee;
                }

                public void setMpiTrustee(String mpiTrustee) {
                    this.mpiTrustee = mpiTrustee;
                }

                public Object getMgrName() {
                    return mgrName;
                }

                public void setMgrName(Object mgrName) {
                    this.mgrName = mgrName;
                }

                public String getMpiCreateDate() {
                    return mpiCreateDate;
                }

                public void setMpiCreateDate(String mpiCreateDate) {
                    this.mpiCreateDate = mpiCreateDate;
                }

                public long getMpiCreateDateTimestamp() {
                    return mpiCreateDateTimestamp;
                }

                public void setMpiCreateDateTimestamp(long mpiCreateDateTimestamp) {
                    this.mpiCreateDateTimestamp = mpiCreateDateTimestamp;
                }

                public String getTzlx() {
                    return tzlx;
                }

                public void setTzlx(String tzlx) {
                    this.tzlx = tzlx;
                }

                public Object getCastProduct() {
                    return castProduct;
                }

                public void setCastProduct(Object castProduct) {
                    this.castProduct = castProduct;
                }

                public String getMpiTotalMoney() {
                    return mpiTotalMoney;
                }

                public void setMpiTotalMoney(String mpiTotalMoney) {
                    this.mpiTotalMoney = mpiTotalMoney;
                }

                public String getSfjgh() {
                    return sfjgh;
                }

                public void setSfjgh(String sfjgh) {
                    this.sfjgh = sfjgh;
                }

                public int getMpiParticipationUser() {
                    return mpiParticipationUser;
                }

                public void setMpiParticipationUser(int mpiParticipationUser) {
                    this.mpiParticipationUser = mpiParticipationUser;
                }
            }
        }

        public static class PofSecuritiesBean {
            /**
             * list : [{"id":1807091718109844,"cpmc":"兴证资管年年鑫17号集合资产管理计划","cpbm":"SEE136","gljg":"兴证证券资产管理有限公司","slrq":"2018-07-04","slrqTimestamp":1530633600000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":63096,"clscyhs":"199","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718109844","fedjjg":null},{"id":1807091718109816,"cpmc":"太平洋证券红珊瑚春城1号集合资产管理计划","cpbm":"SEE239","gljg":"太平洋证券股份有限公司","slrq":"2018-07-04","slrqTimestamp":1530633600000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":45100,"clscyhs":"2","tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718109816","fedjjg":null},{"id":1807091718100219,"cpmc":"中金聚鑫二号集合资产管理计划","cpbm":"SEB574","gljg":"中国国际金融股份有限公司","slrq":"2018-06-29","slrqTimestamp":1530201600000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品",
             * "sffj":"否","glfs":null,"clgm":19750.24,"clscyhs":"43","tgjg":"中信建投证券股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718100219","fedjjg":null},{"id":1807091718100122,"cpmc":"首创证券致胜7号集合资产管理计划","cpbm":"SEC230","gljg":"首创证券有限责任公司","slrq":"2018-06-29","slrqTimestamp":1530201600000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":7912.11,"clscyhs":"55","tgjg":"上海浦东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718100122","fedjjg":null},{"id":1807091718104858,"cpmc":"中信建投稳健添益7号集合资产管理计划","cpbm":"SED021","gljg":"中信建投证券股份有限公司","slrq":"2018-06-27","slrqTimestamp":1530028800000,"dqr":"2028-06-27","dqrTimestamp":1845648000000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":5145.94,"clscyhs":"11","tgjg":"上海浦东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718104858","fedjjg":null},
             * {"id":1807091718104674,"cpmc":"太平洋证券金元宝8号集合资产管理计划","cpbm":"SED644","gljg":"太平洋证券股份有限公司","slrq":"2018-06-27","slrqTimestamp":1530028800000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":9945,"clscyhs":"20","tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718104674","fedjjg":null},{"id":1807090927109635,"cpmc":"兴证资管年年鑫106号集合资产管理计划","cpbm":"SED181","gljg":"兴证证券资产管理有限公司","slrq":"2018-06-27","slrqTimestamp":1530028800000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":26499,"clscyhs":"199","tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807090927109635","fedjjg":null},{"id":1807090927109269,"cpmc":"首创证券创享2号集合资产管理计划","cpbm":"SEC223","gljg":"首创证券有限责任公司","slrq":"2018-06-27","slrqTimestamp":1530028800000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否",
             * "glfs":null,"clgm":20961.29,"clscyhs":"142","tgjg":"中国光大银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807090927109269","fedjjg":null},{"id":1807091718105017,"cpmc":"申万宏源鑫丰臻选1号FOF集合资产管理计划","cpbm":"SED001","gljg":"申万宏源证券有限公司","slrq":"2018-06-26","slrqTimestamp":1529942400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"混合类产品","sffj":"否","glfs":null,"clgm":3291,"clscyhs":"27","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718105017","fedjjg":null},{"id":1807091718104900,"cpmc":"申万宏源鑫丰臻选2号FOF集合资产管理计划","cpbm":"SED002","gljg":"申万宏源证券有限公司","slrq":"2018-06-26","slrqTimestamp":1529942400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"混合类产品","sffj":"否","glfs":null,"clgm":10013,"clscyhs":"88","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718104900","fedjjg":null},{"id":1807091718104718,
             * "cpmc":"华泰紫金投融共赢6号集合资产管理计划","cpbm":"SED245","gljg":"华泰证券（上海）资产管理有限公司","slrq":"2018-06-26","slrqTimestamp":1529942400000,"dqr":"2019-07-01","dqrTimestamp":1561910400000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":15344,"clscyhs":"45","tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718104718","fedjjg":null},{"id":1807091718100342,"cpmc":"广发资管尊享利21号集合资产管理计划","cpbm":"SED353","gljg":"广发证券资产管理（广东）有限公司","slrq":"2018-06-26","slrqTimestamp":1529942400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":10100,"clscyhs":"61","tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718100342","fedjjg":null},{"id":1807021619101459,"cpmc":"财通证券资管年年赢108号集合资产管理计划","cpbm":"SED061","gljg":"财通证券资产管理有限公司","slrq":"2018-06-26","slrqTimestamp":1529942400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否",
             * "glfs":null,"clgm":23253.8,"clscyhs":"171","tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807021619101459","fedjjg":null},{"id":1807021619101093,"cpmc":"申万宏源证券稳赢30号集合资产管理计划","cpbm":"SED005","gljg":"申万宏源证券有限公司","slrq":"2018-06-22","slrqTimestamp":1529596800000,"dqr":"2023-06-22","dqrTimestamp":1687363200000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":35815.31,"clscyhs":"200","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807021619101093","fedjjg":null},{"id":1807021619100996,"cpmc":"申万宏源证券稳赢23集合资产管理计划","cpbm":"SED077","gljg":"申万宏源证券有限公司","slrq":"2018-06-22","slrqTimestamp":1529596800000,"dqr":"2021-06-21","dqrTimestamp":1624204800000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":10835.3,"clscyhs":"66","tgjg":"上海银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807021619100996","fedjjg":null},{"id":1807021619101324,
             * "cpmc":"山西证券启明1号集合资产管理计划","cpbm":"SEA960","gljg":"山西证券股份有限公司","slrq":"2018-06-21","slrqTimestamp":1529510400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":14635.56,"clscyhs":"108","tgjg":"中国光大银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807021619101324","fedjjg":null},{"id":1807021619100805,"cpmc":"五矿证券五丰稳利1号集合资产管理计划","cpbm":"SEB983","gljg":"五矿证券有限公司","slrq":"2018-06-21","slrqTimestamp":1529510400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":22133,"clscyhs":"163","tgjg":"中国光大银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807021619100805","fedjjg":null},{"id":1807091718100435,"cpmc":"中投证券宁福364天5号集合资产管理计划","cpbm":"SEC382","gljg":"中国中投证券有限责任公司","slrq":"2018-06-20","slrqTimestamp":1529424000000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,
             * "clgm":3790.04,"clscyhs":"3","tgjg":"宁波银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718100435","fedjjg":null},{"id":1806251446107384,"cpmc":"中银证券中国红-黄山8号第22期固定收益类集合资产管理计划","cpbm":"SEC508","gljg":"中银国际证券股份有限公司","slrq":"2018-06-20","slrqTimestamp":1529424000000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":38470,"clscyhs":"160","tgjg":"中国银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446107384","fedjjg":null},{"id":1806251446107700,"cpmc":"东证融汇汇享26号集合资产管理计划","cpbm":"SEA161","gljg":"东证融汇证券资产管理有限公司","slrq":"2018-06-19","slrqTimestamp":1529337600000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":7706,"clscyhs":"9","tgjg":"广东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446107700","fedjjg":null},{"id":1806251446107194,
             * "cpmc":"中银证券中国红-黄山8号第21期固定收益类集合资产管理计划","cpbm":"SEC459","gljg":"中银国际证券股份有限公司","slrq":"2018-06-19","slrqTimestamp":1529337600000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":29960,"clscyhs":"159","tgjg":"中国银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446107194","fedjjg":null},{"id":1806261720103897,"cpmc":"申万宏源证券稳赢49号集合资产管理计划","cpbm":"SEC574","gljg":"申万宏源证券有限公司","slrq":"2018-06-15","slrqTimestamp":1528992000000,"dqr":"2023-06-14","dqrTimestamp":1686672000000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":39772.9,"clscyhs":"197","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806261720103897","fedjjg":null},{"id":1806251446107009,"cpmc":"申万宏源证券稳赢35号集合资产管理计划","cpbm":"SEC125","gljg":"申万宏源证券有限公司","slrq":"2018-06-15","slrqTimestamp":1528992000000,"dqr":"2023-06-15","dqrTimestamp":1686758400000,"tzlx":"固收类产品","sffj":"否",
             * "glfs":null,"clgm":19657,"clscyhs":"127","tgjg":"中国邮政储蓄银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446107009","fedjjg":null},{"id":1806211654104790,"cpmc":"华泰紫金信用1号集合资产管理计划","cpbm":"SEC157","gljg":"华泰证券（上海）资产管理有限公司","slrq":"2018-06-15","slrqTimestamp":1528992000000,"dqr":"2023-06-15","dqrTimestamp":1686758400000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":10472.09,"clscyhs":"75","tgjg":"平安银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654104790","fedjjg":null},{"id":1806211654104601,"cpmc":"兴证资管年年鑫105号集合资产管理计划","cpbm":"SEC129","gljg":"兴证证券资产管理有限公司","slrq":"2018-06-15","slrqTimestamp":1528992000000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":20597.31,"clscyhs":"159","tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654104601","fedjjg":null},{"id":1806211654104306,
             * "cpmc":"首创证券创享1号集合资产管理计划","cpbm":"SEB330","gljg":"首创证券有限责任公司","slrq":"2018-06-15","slrqTimestamp":1528992000000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":15649.15,"clscyhs":"116","tgjg":"中国光大银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654104306","fedjjg":null},{"id":1806211654103985,"cpmc":"广发资管尊享利19号集合资产管理计划","cpbm":"SEC259","gljg":"广发证券资产管理（广东）有限公司","slrq":"2018-06-14","slrqTimestamp":1528905600000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":12364,"clscyhs":"52","tgjg":"广东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654103985","fedjjg":null},{"id":1807091718100295,"cpmc":"国泰君安君越优享多策略1号集合资产管理计划","cpbm":"SEC027","gljg":"上海国泰君安证券资产管理有限公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否",
             * "glfs":null,"clgm":3100,"clscyhs":"13","tgjg":"招商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718100295","fedjjg":null},{"id":1807090927109477,"cpmc":"国金慧多利债券2号集合资产管理计划","cpbm":"SEB333","gljg":"国金证券股份有限公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":4160.04,"clscyhs":"17","tgjg":"招商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807090927109477","fedjjg":null},{"id":1806261720104125,"cpmc":"申万宏源证券稳赢31号集合资产管理计划","cpbm":"SEC517","gljg":"申万宏源证券有限公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"2023-06-13","dqrTimestamp":1686585600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":13545,"clscyhs":"83","tgjg":"中国邮政储蓄银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806261720104125","fedjjg":null},{"id":1806251446107669,
             * "cpmc":"东证融汇汇享27号集合资产管理计划","cpbm":"SEB322","gljg":"东证融汇证券资产管理有限公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":20100,"clscyhs":"2","tgjg":"广东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446107669","fedjjg":null},{"id":1806251446106903,"cpmc":"申万宏源证券稳赢37号集合资产管理计划","cpbm":"SEB852","gljg":"申万宏源证券有限公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"2021-06-13","dqrTimestamp":1623513600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":16300,"clscyhs":"65","tgjg":"上海银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446106903","fedjjg":null},{"id":1806211654104518,"cpmc":"首创证券泽鑫3号集合资产管理计划","cpbm":"SEB296","gljg":"首创证券有限责任公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":7144,
             * "clscyhs":"44","tgjg":"华夏银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654104518","fedjjg":null},{"id":1806211654104158,"cpmc":"海通海蓝增益2号集合资产管理计划","cpbm":"SCX377","gljg":"上海海通证券资产管理有限公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"2020-06-12","dqrTimestamp":1591891200000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":21506,"clscyhs":"124","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654104158","fedjjg":null},{"id":1806211654103707,"cpmc":"招商智远全景多策略集合资产管理计划","cpbm":"SEB616","gljg":"招商证券资产管理有限公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"2028-06-12","dqrTimestamp":1844352000000,"tzlx":"混合类产品","sffj":"否","glfs":null,"clgm":5252.68,"clscyhs":"30","tgjg":"上海浦东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654103707","fedjjg":null},{"id":1806211654103672,"cpmc":"长城证券金徽酒增持1号集合资产管理计划",
             * "cpbm":"SEB516","gljg":"长城证券股份有限公司","slrq":"2018-06-13","slrqTimestamp":1528819200000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"权益类产品","sffj":"否","glfs":null,"clgm":8500,"clscyhs":"13","tgjg":"平安银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654103672","fedjjg":null},{"id":1806251446107752,"cpmc":"兴证资管玉麒麟定制7号集合资产管理计划","cpbm":"SEB511","gljg":"兴证证券资产管理有限公司","slrq":"2018-06-12","slrqTimestamp":1528732800000,"dqr":"2021-06-11","dqrTimestamp":1623340800000,"tzlx":"混合类产品","sffj":"否","glfs":null,"clgm":3000,"clscyhs":"2","tgjg":"上海浦东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446107752","fedjjg":null},{"id":1806251446105993,"cpmc":"渤海汇金璞盈8号集合资产管理计划","cpbm":"SY9641","gljg":"渤海汇金证券资产管理有限公司","slrq":"2018-06-12","slrqTimestamp":1528732800000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":28900.83,"clscyhs":"194",
             * "tgjg":"上海浦东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446105993","fedjjg":null},{"id":1806251446105835,"cpmc":"德邦浦华优选18号集合资产管理计划","cpbm":"SEB004","gljg":"德邦证券股份有限公司","slrq":"2018-06-12","slrqTimestamp":1528732800000,"dqr":"2019-07-12","dqrTimestamp":1562860800000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":9950,"clscyhs":"64","tgjg":"上海浦东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806251446105835","fedjjg":null},{"id":1806211654104449,"cpmc":"东吴汇天益10号集合资产管理计划","cpbm":"SEB595","gljg":"东吴证券股份有限公司","slrq":"2018-06-12","slrqTimestamp":1528732800000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":8045,"clscyhs":"42","tgjg":"宁波银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654104449","fedjjg":null},{"id":1806211654103633,"cpmc":"东证融汇汇享25号集合资产管理计划","cpbm":"SCY653",
             * "gljg":"东证融汇证券资产管理有限公司","slrq":"2018-06-12","slrqTimestamp":1528732800000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":4417,"clscyhs":"10","tgjg":"广东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654103633","fedjjg":null},{"id":1806211654103395,"cpmc":"申万宏源证券稳赢34号集合资产管理计划","cpbm":"SEB872","gljg":"申万宏源证券有限公司","slrq":"2018-06-08","slrqTimestamp":1528387200000,"dqr":"2023-06-08","dqrTimestamp":1686153600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":13235.12,"clscyhs":"88","tgjg":"中国邮政储蓄银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654103395","fedjjg":null},{"id":1806211654102315,"cpmc":"兴证资管浦兴年年利4号集合资产管理计划","cpbm":"SEA975","gljg":"兴证证券资产管理有限公司","slrq":"2018-06-08","slrqTimestamp":1528387200000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":15157.21,"clscyhs":"111",
             * "tgjg":"上海浦东发展银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654102315","fedjjg":null},{"id":1806211654102456,"cpmc":"申万宏源证券稳赢40号集合资产管理计划","cpbm":"SEB135","gljg":"申万宏源证券有限公司","slrq":"2018-06-07","slrqTimestamp":1528300800000,"dqr":"2021-06-07","dqrTimestamp":1622995200000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":12191.4,"clscyhs":"77","tgjg":"上海银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654102456","fedjjg":null},{"id":1806191720100562,"cpmc":"申万宏源证券稳赢46号集合资产管理计划","cpbm":"SEB818","gljg":"申万宏源证券有限公司","slrq":"2018-06-07","slrqTimestamp":1528300800000,"dqr":"2023-06-07","dqrTimestamp":1686067200000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":37188.6,"clscyhs":"194","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806191720100562","fedjjg":null},{"id":1806121407102422,"cpmc":"兴证资管年年鑫20号集合资产管理计划","cpbm":"SEB018",
             * "gljg":"兴证证券资产管理有限公司","slrq":"2018-06-07","slrqTimestamp":1528300800000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":4330.34,"clscyhs":"9","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806121407102422","fedjjg":null},{"id":1806121407102622,"cpmc":"兴证资管年年鑫16号集合资产管理计划","cpbm":"SEA729","gljg":"兴证证券资产管理有限公司","slrq":"2018-06-06","slrqTimestamp":1528214400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":11606.29,"clscyhs":"88","tgjg":"中国工商银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806121407102622","fedjjg":null},{"id":1806121407101824,"cpmc":"兴证资管年年鑫102号集合资产管理计划","cpbm":"SEA731","gljg":"兴证证券资产管理有限公司","slrq":"2018-06-06","slrqTimestamp":1528214400000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":25112.06,"clscyhs":"199",
             * "tgjg":"兴业银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806121407101824","fedjjg":null},{"id":1806211654103931,"cpmc":"海通年年旺100号集合资产管理计划","cpbm":"SEB118","gljg":"上海海通证券资产管理有限公司","slrq":"2018-06-05","slrqTimestamp":1528128000000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":4370.1,"clscyhs":"30","tgjg":"国泰君安证券股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806211654103931","fedjjg":null},{"id":1806111617106147,"cpmc":"山西证券恒利3号集合资产管理计划","cpbm":"SCZ794","gljg":"山西证券股份有限公司","slrq":"2018-06-05","slrqTimestamp":1528128000000,"dqr":"9999-12-31","dqrTimestamp":253402185600000,"tzlx":"固收类产品","sffj":"否","glfs":null,"clgm":4625,"clscyhs":"19","tgjg":"中国光大银行股份有限公司","url":"http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1806111617106147","fedjjg":null}]
             * page : {"pageSize":50,"pageIndex":1,"totalPageCount":150,"totalCount":7482}
             */

            private PageBeanX page;
            private List<ListBeanX> list;

            public PageBeanX getPage() {
                return page;
            }

            public void setPage(PageBeanX page) {
                this.page = page;
            }

            public List<ListBeanX> getList() {
                return list;
            }

            public void setList(List<ListBeanX> list) {
                this.list = list;
            }

            public static class PageBeanX {
                /**
                 * pageSize : 50
                 * pageIndex : 1
                 * totalPageCount : 150
                 * totalCount : 7482
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

            public static class ListBeanX {
                /**
                 * id : 1807091718109844
                 * cpmc : 兴证资管年年鑫17号集合资产管理计划
                 * cpbm : SEE136
                 * gljg : 兴证证券资产管理有限公司
                 * slrq : 2018-07-04
                 * slrqTimestamp : 1530633600000
                 * dqr : 9999-12-31
                 * dqrTimestamp : 253402185600000
                 * tzlx : 固收类产品
                 * sffj : 否
                 * glfs : null
                 * clgm : 63096
                 * clscyhs : 199
                 * tgjg : 中国工商银行股份有限公司
                 * url : http://gs.amac.org.cn/amac-infodisc/res/pof/securities/detail.html?id=1807091718109844
                 * fedjjg : null
                 */

                private long id;
                private String cpmc;
                private String cpbm;
                private String gljg;
                private String slrq;
                private long slrqTimestamp;
                private String dqr;
                private long dqrTimestamp;
                private String tzlx;
                private String sffj;
                private Object glfs;
                private String clgm;
                private String clscyhs;
                private String tgjg;
                private String url;
                private Object fedjjg;

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public String getCpmc() {
                    return cpmc;
                }

                public void setCpmc(String cpmc) {
                    this.cpmc = cpmc;
                }

                public String getCpbm() {
                    return cpbm;
                }

                public void setCpbm(String cpbm) {
                    this.cpbm = cpbm;
                }

                public String getGljg() {
                    return gljg;
                }

                public void setGljg(String gljg) {
                    this.gljg = gljg;
                }

                public String getSlrq() {
                    return slrq;
                }

                public void setSlrq(String slrq) {
                    this.slrq = slrq;
                }

                public long getSlrqTimestamp() {
                    return slrqTimestamp;
                }

                public void setSlrqTimestamp(long slrqTimestamp) {
                    this.slrqTimestamp = slrqTimestamp;
                }

                public String getDqr() {
                    return dqr;
                }

                public void setDqr(String dqr) {
                    this.dqr = dqr;
                }

                public long getDqrTimestamp() {
                    return dqrTimestamp;
                }

                public void setDqrTimestamp(long dqrTimestamp) {
                    this.dqrTimestamp = dqrTimestamp;
                }

                public String getTzlx() {
                    return tzlx;
                }

                public void setTzlx(String tzlx) {
                    this.tzlx = tzlx;
                }

                public String getSffj() {
                    return sffj;
                }

                public void setSffj(String sffj) {
                    this.sffj = sffj;
                }

                public Object getGlfs() {
                    return glfs;
                }

                public void setGlfs(Object glfs) {
                    this.glfs = glfs;
                }

                public String getClgm() {
                    return clgm;
                }

                public void setClgm(String clgm) {
                    this.clgm = clgm;
                }

                public String getClscyhs() {
                    return clscyhs;
                }

                public void setClscyhs(String clscyhs) {
                    this.clscyhs = clscyhs;
                }

                public String getTgjg() {
                    return tgjg;
                }

                public void setTgjg(String tgjg) {
                    this.tgjg = tgjg;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public Object getFedjjg() {
                    return fedjjg;
                }

                public void setFedjjg(Object fedjjg) {
                    this.fedjjg = fedjjg;
                }
            }
        }

        public static class AoinProductsBean {
            /**
             * list : [{"id":188,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/188.html","name":"吉林省现代农业和新兴产业投资基金有限公司","code":"S32187","aoinName":"海通开元投资有限公司","managerName":"海通吉禾股权投资基金管理有限责任公司","createDate":1291420800000},{"id":189,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/189.html","name":"西安航天新能源产业基金投资有限公司","code":"S32088","aoinName":"海通开元投资有限公司","managerName":"海通创新资本管理有限公司","createDate":1294444800000},{"id":644,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/644.html","name":"吉林昊融股权投资基金有限责任公司","code":"S32333","aoinName":"东证融通投资管理有限公司","managerName":"吉林东证昊融股权投资基金管理有限公司","createDate":1299110400000},{"id":193,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/193.html","name":"中金佳泰（天津）股权投资基金合伙企业（有限合伙）","code":"S32087","aoinName":"中金佳成投资管理有限公司","managerName":"中金佳合（天津）股权投资基金管理有限公司","createDate":1301702400000},{"id":767,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/767.html","name":"招商湘江产业投资有限公司","code":"S32410",
             * "aoinName":"招商证券股份有限公司直投子公司","managerName":"青岛招商致远投资管理有限公司","createDate":1309392000000},{"id":191,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/191.html","name":"上海诚毅新能源创业投资有限公司","code":"S32086","aoinName":"上海东方证券资本投资有限公司","managerName":"上海诚毅投资管理有限公司","createDate":1310428800000},{"id":199,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/199.html","name":"湖北新能源创业投资基金有限公司","code":"S32085","aoinName":"长江成长资本投资有限公司","managerName":"湖北新能源投资管理有限公司","createDate":1327104000000},{"id":190,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/190.html","name":"上海文化产业股权投资基金合伙企业（有限合伙）","code":"S32084","aoinName":"海通开元投资有限公司","managerName":"海通创意资本管理有限公司","createDate":1346630400000},{"id":196,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/196.html","name":"中信并购投资基金（深圳）合伙企业（有限合伙）","code":"S32083","aoinName":"金石投资有限公司","managerName":"中信并购基金管理有限公司","createDate":1352937600000},{"id":200,"url":"http://gs.amac.org
             * .cn/amac-infodisc/res/aoin/product/200.html","name":"北京润信鼎泰投资中心(有限合伙）","code":"S32100","aoinName":"中信建投资本管理有限公司","managerName":"中信建投资本管理有限公司","createDate":1353283200000},{"id":192,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/192.html","name":"甘肃生物医药产业创业投资基金有限公司","code":"S32078","aoinName":"金城资本管理有限公司","managerName":"金城资本管理有限公司","createDate":1354752000000},{"id":195,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/195.html","name":"青岛金石泓信投资中心（有限合伙）","code":"S32081","aoinName":"金石投资有限公司","managerName":"金石投资有限公司","createDate":1354752000000},{"id":198,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/198.html","name":"天津海通创新股权投资合伙企业（有限合伙）","code":"S32079","aoinName":"海通开元投资有限公司","managerName":"海通创新资本管理有限公司","createDate":1356307200000},{"id":202,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/202.html","name":"甘肃现代农业产业创业投资基金有限公司","code":"S32080","aoinName":"金城资本管理有限公司","managerName":"甘肃华龙金城投资管理有限公司",
             * "createDate":1356393600000},{"id":185,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/185.html","name":"深圳市远盛发展一期股权投资企业（有限合伙）","code":"S32077","aoinName":"招商致远资本投资有限公司","managerName":"深圳市远盛投资管理有限公司","createDate":1356480000000},{"id":194,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/194.html","name":"华泰紫金（江苏）股权投资基金（有限合伙）","code":"S32076","aoinName":"华泰紫金投资有限责任公司","managerName":"华泰瑞通投资管理有限公司","createDate":1357862400000},{"id":301,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/301.html","name":"武汉惠人生物创业投资基金中心（有限合伙）","code":"S32075","aoinName":"天风天睿投资有限公司","managerName":"武汉光谷创投基金管理有限公司","createDate":1360281600000},{"id":197,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/197.html","name":"新疆华融天泽鼎鑫投资合伙企业（有限合伙）","code":"S32105","aoinName":"华融天泽投资有限公司","managerName":"华融天泽投资有限公司","createDate":1363219200000},{"id":201,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/201.html","name":"新疆广发信德广电夹层投资有限合伙企业",
             * "code":"S32073","aoinName":"广发信德投资管理有限公司","managerName":"新疆广发信德稳胜投资管理有限公司","createDate":1364169600000},{"id":207,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/207.html","name":"成都金智百业源股权投资基金","code":"S32072","aoinName":"华西金智投资有限责任公司","managerName":"成都金智全胜股权投资基金管理有限公司","createDate":1366156800000},{"id":184,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/184.html","name":"厦门国海坚果创业投资合伙企业（有限合伙）","code":"S32071","aoinName":"国海创新资本投资管理有限公司","managerName":"厦门国海坚果投资管理有限公司","createDate":1367798400000},{"id":186,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/186.html","name":"上海远杉投资合伙企业（有限合伙）","code":"S32070","aoinName":"招商致远资本投资有限公司","managerName":"北京致远励新投资管理有限公司","createDate":1368057600000},{"id":225,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/225.html","name":"吉林省国家新材料产业创业投资有限责任公司","code":"S32001","aoinName":"第一创业投资管理有限公司","managerName":"北京一创吉星创业投资管理有限公司","createDate":1369353600000},{"id":187,"url":"http://gs.amac.org
             * .cn/amac-infodisc/res/aoin/product/187.html","name":"福建兴证战略创业投资企业（有限合伙）","code":"S32069","aoinName":"兴业创新资本管理有限公司","managerName":"福建兴证创富股权投资管理有限公司","createDate":1370736000000},{"id":339,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/339.html","name":"山西中小企业创业投资基金（有限合伙）","code":"S32140","aoinName":"龙华启富投资有限责任公司","managerName":"山证基金管理有限公司","createDate":1372377600000},{"id":220,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/220.html","name":"深圳市国信弘盛股权投资基金（有限合伙）","code":"S32068","aoinName":"国信弘盛创业投资有限公司","managerName":"深圳市国信弘盛股权投资基金管理有限公司","createDate":1372723200000},{"id":203,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/203.html","name":"赣州致发投资合伙企业（有限合伙）","code":"S32067","aoinName":"招商致远资本投资有限公司","managerName":"江西致远发展投资管理有限公司","createDate":1373328000000},{"id":206,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/206.html","name":"北京宏源循环能源投资中心（有限合伙）","code":"S32066","aoinName":"宏源汇富创业投资有限公司",
             * "managerName":"宏源循环能源投资管理（北京）有限公司","createDate":1374105600000},{"id":210,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/210.html","name":"赣州致汇投资合伙企业（有限合伙）","code":"S32065","aoinName":"招商致远资本投资有限公司","managerName":"江西致远发展投资管理有限公司","createDate":1374537600000},{"id":208,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/208.html","name":"赣州招联投资合伙企业（有限合伙）","code":"S32002","aoinName":"招商致远资本投资有限公司","managerName":"江西招联投资管理有限公司","createDate":1374624000000},{"id":222,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/222.html","name":"锦绣中原（洛阳）创业投资中心（有限合伙）","code":"S32064","aoinName":"海通开元投资有限公司","managerName":"海通创新资本管理有限公司","createDate":1374624000000},{"id":204,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/204.html","name":"辽宁海通新能源低碳产业股权投资基金有限公司","code":"S32063","aoinName":"海通开元投资有限公司","managerName":"海通新能源股权投资管理有限公司","createDate":1375920000000},{"id":647,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/647.html","name":"宁波达泰投资合伙企业（有限合伙）","code":"S32330","aoinName":"信达证券股份有限公司直投子公司","managerName":"信风投资管理有限公司","createDate":1376006400000},{"id":215,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/215.html","name":"赣州致结投资合伙企业（有限合伙）","code":"S32062","aoinName":"招商致远资本投资有限公司","managerName":"江西致远发展投资管理有限公司","createDate":1376524800000},{"id":205,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/205.html","name":"赣州励结投资合伙企业（有限合伙）","code":"S32061","aoinName":"招商致远资本投资有限公司","managerName":"北京致远励新投资管理有限公司","createDate":1376611200000},{"id":209,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/209.html","name":"福建兴杭战略创业投资企业（有限合伙）","code":"S32060","aoinName":"兴业创新资本管理有限公司","managerName":"福建兴证兴杭股权投资管理有限公司","createDate":1377129600000},{"id":218,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/218.html","name":"新疆华融天泽鼎丰投资合伙企业（有限合伙）","code":"S32059","aoinName":"华融天泽投资有限公司","managerName":"华融天泽投资有限公司","createDate":1377216000000},{"id":211,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/211.html","name":"中投长春国家光电信息创业投资基金（有限合伙）","code":"S32058","aoinName":"瑞石投资管理有限责任公司","managerName":"中投长春创业投资基金管理有限公司","createDate":1377820800000},{"id":212,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/212.html","name":"深圳市长城弘瑞商业并购基金合伙企业（有限合伙）","code":"S32057","aoinName":"深圳市长城长富投资管理有限公司","managerName":"北京长城弘瑞投资管理有限公司","createDate":1378080000000},{"id":213,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/213.html","name":"赣州招商致远壹号股权投资合伙企业（有限合伙）","code":"S32120","aoinName":"招商致远资本投资有限公司","managerName":"赣州招商致远壹号股权投资管理有限公司","createDate":1379030400000},{"id":214,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/214.html","name":"河南中证开元创业投资基金（有限合伙）","code":"S32055","aoinName":"中鼎开源创业投资管理有限公司","managerName":"河南中证开元创业投资基金管理有限公司","createDate":1379376000000},{"id":229,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/229.html","name":"珠海广发信德新湖夹层投资有限合伙企业","code":"S32054","aoinName":"广发信德投资管理有限公司","managerName":"新疆广发信德稳胜投资管理有限公司","createDate":1380153600000},{"id":217,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/217.html","name":"深圳一创中科垃圾焚烧发电基金企业（有限合伙）","code":"S32053","aoinName":"第一创业投资管理有限公司","managerName":"深圳一创创盈投资管理有限公司","createDate":1381968000000},{"id":231,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/231.html","name":"广发信德（珠海）医疗产业投资中心（有限合伙）","code":"S32052","aoinName":"广发信德投资管理有限公司","managerName":"广发信德医疗资本管理有限公司","createDate":1381968000000},{"id":243,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/243.html","name":"赣州远发投资合伙企业（有限合伙）","code":"S32051","aoinName":"招商致远资本投资有限公司","managerName":"赣州招远投资管理有限公司","createDate":1382054400000},{"id":216,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/216.html","name":"赣州瑞结投资合伙企业（有限合伙）","code":"S32050","aoinName":"招商致远资本投资有限公司","managerName":"赣州招远投资管理有限公司","createDate":1382918400000},{"id":843,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/843.html","name":"赣州壹申投资合伙企业 （有限合伙）","code":"S32452","aoinName":"招商证券股份有限公司直投子公司","managerName":"赣州招商致远壹号股权投资管理有限公司","createDate":1384905600000},{"id":687,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/687.html","name":"赣州壹泰投资合伙企业 （有限合伙）","code":"S32359","aoinName":"招商证券股份有限公司直投子公司","managerName":"赣州招商致远壹号股权投资管理有限公司","createDate":1385424000000},{"id":1356,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/1356.html","name":"宁波信诚喜兆投资合伙企业（有限合伙）","code":"S32595","aoinName":"信达证券股份有限公司直投子公司","managerName":"信风投资管理有限公司","createDate":1385596800000},{"id":287,"url":"http://gs.amac.org.cn/amac-infodisc/res/aoin/product/287.html","name":"北京华融鼎智投资合伙企业（有限合伙）","code":"S32192","aoinName":"华融天泽投资有限公司","managerName":"华融天泽投资有限公司","createDate":1386201600000}]
             * page : {"pageSize":50,"pageIndex":1,"totalPageCount":13,"totalCount":609}
             */

            private PageBeanXX page;
            private List<ListBeanXX> list;

            public PageBeanXX getPage() {
                return page;
            }

            public void setPage(PageBeanXX page) {
                this.page = page;
            }

            public List<ListBeanXX> getList() {
                return list;
            }

            public void setList(List<ListBeanXX> list) {
                this.list = list;
            }

            public static class PageBeanXX {
                /**
                 * pageSize : 50
                 * pageIndex : 1
                 * totalPageCount : 13
                 * totalCount : 609
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

            public static class ListBeanXX {
                /**
                 * id : 188
                 * url : http://gs.amac.org.cn/amac-infodisc/res/aoin/product/188.html
                 * name : 吉林省现代农业和新兴产业投资基金有限公司
                 * code : S32187
                 * aoinName : 海通开元投资有限公司
                 * managerName : 海通吉禾股权投资基金管理有限责任公司
                 * createDate : 1291420800000
                 */

                private int id;
                private String url;
                private String name;
                private String code;
                private String aoinName;
                private String managerName;
                private long createDate;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getAoinName() {
                    return aoinName;
                }

                public void setAoinName(String aoinName) {
                    this.aoinName = aoinName;
                }

                public String getManagerName() {
                    return managerName;
                }

                public void setManagerName(String managerName) {
                    this.managerName = managerName;
                }

                public long getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(long createDate) {
                    this.createDate = createDate;
                }
            }
        }
    }
}