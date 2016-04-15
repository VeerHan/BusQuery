package com.john.busquery.bean;

import java.util.List;

public class LineEntity {
    /**
     * status : 0
     * msg : ok
     * result : [{"transitno":"86路","startstation":"淮海广场","endstation":"公安监督中心","starttime":"06:20","endtime":"18:40","price":"0","maxprice":"1.00","list":[{"sequenceno":"1","station":"淮海广场","lat":"33.60258","lng":"119.02809"},{"sequenceno":"2","station":"利苑新村","lat":"33.60234","lng":"119.02493"},{"sequenceno":"3","station":"勤政路","lat":"33.60205","lng":"119.02173"},{"sequenceno":"4","station":"清河路","lat":"33.60183","lng":"119.01941"},{"sequenceno":"5","station":"中经路","lat":"33.60489","lng":"119.01885"},{"sequenceno":"6","station":"北京新村","lat":"33.60716","lng":"119.01924"},{"sequenceno":"7","station":"繁荣路","lat":"33.60977","lng":"119.01976"},{"sequenceno":"8","station":"大治路","lat":"33.61281","lng":"119.02064"},{"sequenceno":"9","station":"市政府","lat":"33.61658","lng":"119.02115"},{"sequenceno":"10","station":"健康西路","lat":"33.61693","lng":"119.01639"},{"sequenceno":"11","station":"中天花园","lat":"33.61663","lng":"119.01343"},{"sequenceno":"12","station":"师院西区","lat":"33.61598","lng":"119.01079"},{"sequenceno":"13","station":"富丽花园东大门","lat":"33.61701","lng":"119.00786"},{"sequenceno":"14","station":"桃花岛","lat":"33.61956","lng":"119.00712"},{"sequenceno":"15","station":"西坝","lat":"33.62398","lng":"119.00314"},{"sequenceno":"16","station":"星光村","lat":"33.62943","lng":"119.00219"},{"sequenceno":"17","station":"桥北","lat":"33.63886","lng":"119.00097"},{"sequenceno":"18","station":"盐北村","lat":"33.64516","lng":"119.00009"},{"sequenceno":"19","station":"公安监督中心","lat":"33.64504","lng":"118.99620"}]},{"transitno":"86路","startstation":"公安监管中心","endstation":"淮海广场","starttime":"06:20","endtime":"18:40","price":"0","maxprice":"1.00","list":[{"sequenceno":"1","station":"公安监管中心","lat":"33.64511","lng":"118.99737"},{"sequenceno":"2","station":"盐北村","lat":"33.64309","lng":"119.00023"},{"sequenceno":"3","station":"桥北","lat":"33.63865","lng":"119.00092"},{"sequenceno":"4","station":"星光村","lat":"33.62911","lng":"119.00225"},{"sequenceno":"5","station":"西坝","lat":"33.62427","lng":"119.00304"},{"sequenceno":"6","station":"桃花岛","lat":"33.62006","lng":"119.00654"},{"sequenceno":"7","station":"富丽花园东北门","lat":"33.61565","lng":"119.00777"},{"sequenceno":"8","station":"师院西区","lat":"33.61571","lng":"119.01039"},{"sequenceno":"9","station":"中天花园","lat":"33.61636","lng":"119.01255"},{"sequenceno":"10","station":"健康西路","lat":"33.61678","lng":"119.01767"},{"sequenceno":"11","station":"市政府","lat":"33.61659","lng":"119.02065"},{"sequenceno":"12","station":"大治路","lat":"33.61144","lng":"119.02022"},{"sequenceno":"13","station":"繁荣路","lat":"33.60949","lng":"119.01969"},{"sequenceno":"14","station":"北京新村","lat":"33.60719","lng":"119.01924"},{"sequenceno":"15","station":"中经路","lat":"33.60489","lng":"119.01885"},{"sequenceno":"16","station":"清河路","lat":"33.60228","lng":"119.01866"},{"sequenceno":"17","station":"勤政路","lat":"33.60201","lng":"119.02284"},{"sequenceno":"18","station":"利苑新村","lat":"33.60225","lng":"119.02534"},{"sequenceno":"19","station":"淮海广场","lat":"33.60254","lng":"119.02882"}]}]
     */

    private String status;
    private String msg;
    /**
     * transitno : 86路
     * startstation : 淮海广场
     * endstation : 公安监督中心
     * starttime : 06:20
     * endtime : 18:40
     * price : 0
     * maxprice : 1.00
     * list : [{"sequenceno":"1","station":"淮海广场","lat":"33.60258","lng":"119.02809"},{"sequenceno":"2","station":"利苑新村","lat":"33.60234","lng":"119.02493"},{"sequenceno":"3","station":"勤政路","lat":"33.60205","lng":"119.02173"},{"sequenceno":"4","station":"清河路","lat":"33.60183","lng":"119.01941"},{"sequenceno":"5","station":"中经路","lat":"33.60489","lng":"119.01885"},{"sequenceno":"6","station":"北京新村","lat":"33.60716","lng":"119.01924"},{"sequenceno":"7","station":"繁荣路","lat":"33.60977","lng":"119.01976"},{"sequenceno":"8","station":"大治路","lat":"33.61281","lng":"119.02064"},{"sequenceno":"9","station":"市政府","lat":"33.61658","lng":"119.02115"},{"sequenceno":"10","station":"健康西路","lat":"33.61693","lng":"119.01639"},{"sequenceno":"11","station":"中天花园","lat":"33.61663","lng":"119.01343"},{"sequenceno":"12","station":"师院西区","lat":"33.61598","lng":"119.01079"},{"sequenceno":"13","station":"富丽花园东大门","lat":"33.61701","lng":"119.00786"},{"sequenceno":"14","station":"桃花岛","lat":"33.61956","lng":"119.00712"},{"sequenceno":"15","station":"西坝","lat":"33.62398","lng":"119.00314"},{"sequenceno":"16","station":"星光村","lat":"33.62943","lng":"119.00219"},{"sequenceno":"17","station":"桥北","lat":"33.63886","lng":"119.00097"},{"sequenceno":"18","station":"盐北村","lat":"33.64516","lng":"119.00009"},{"sequenceno":"19","station":"公安监督中心","lat":"33.64504","lng":"118.99620"}]
     */

    private List<ResultEntity> result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public static class ResultEntity {
        private String transitno;
        private String startstation;
        private String endstation;
        private String starttime;
        private String endtime;
        private String price;
        private String maxprice;
        /**
         * sequenceno : 1
         * station : 淮海广场
         * lat : 33.60258
         * lng : 119.02809
         */

        private List<ListEntity> list;

        public String getTransitno() {
            return transitno;
        }

        public void setTransitno(String transitno) {
            this.transitno = transitno;
        }

        public String getStartstation() {
            return startstation;
        }

        public void setStartstation(String startstation) {
            this.startstation = startstation;
        }

        public String getEndstation() {
            return endstation;
        }

        public void setEndstation(String endstation) {
            this.endstation = endstation;
        }

        public String getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getMaxprice() {
            return maxprice;
        }

        public void setMaxprice(String maxprice) {
            this.maxprice = maxprice;
        }

        public List<ListEntity> getList() {
            return list;
        }

        public void setList(List<ListEntity> list) {
            this.list = list;
        }

        public static class ListEntity {
            private String sequenceno;
            private String station;
            private String lat;
            private String lng;

            public String getSequenceno() {
                return sequenceno;
            }

            public void setSequenceno(String sequenceno) {
                this.sequenceno = sequenceno;
            }

            public String getStation() {
                return station;
            }

            public void setStation(String station) {
                this.station = station;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLng() {
                return lng;
            }

            public void setLng(String lng) {
                this.lng = lng;
            }
        }
    }
}
