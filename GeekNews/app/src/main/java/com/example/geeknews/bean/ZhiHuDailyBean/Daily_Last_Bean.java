package com.example.geeknews.bean.ZhiHuDailyBean;

import java.util.List;

/**
 * Created by 张十八 on 2019/4/18.
 */

public class Daily_Last_Bean {

    /**
     * date : 20190401
     * stories : [{"images":["https://pic2.zhimg.com/v2-3d62e0e52549e6696c376f188716fcd1.jpg"],"type":0,"id":9709698,"ga_prefix":"040122","title":"小事 · 有些事我已忘记，有些事我还记得"},{"title":"《都挺好》的苏州评弹 BGM，读完这篇你才懂","ga_prefix":"040121","images":["https://pic4.zhimg.com/v2-2db23fa1adf431ee7560c0bfc0466d93.jpg"],"multipic":true,"type":0,"id":9709678},{"title":"打通「京圈」「沪圈」和「港圈」，在那个年代，只有他能做到","ga_prefix":"040119","images":["https://pic4.zhimg.com/v2-5fae2211d29e11d7a2d0b66f1e45f41b.jpg"],"multipic":true,"type":0,"id":9709668},{"images":["https://pic4.zhimg.com/v2-63003ff56e34d0eeefca4964ceb598d3.jpg"],"type":0,"id":9709664,"ga_prefix":"040117","title":"年入百万的 NBA 球员，却因为抠门被罚禁赛"},{"title":"今天，《霸王别姬》特别值得重新怀恋","ga_prefix":"040110","images":["https://pic4.zhimg.com/v2-8b83b9cb67b630b03f6dd6fb946e7c5b.jpg"],"multipic":true,"type":0,"id":9708721},{"images":["https://pic3.zhimg.com/v2-8af91d8defc643d0945b414a3603070a.jpg"],"type":0,"id":9709645,"ga_prefix":"040108","title":"肾虚，一种与中国文化有关的精神障碍，世界卫生组织说的"},{"images":["https://pic3.zhimg.com/v2-4754c826f61f3e5cfb2662d2f3cff726.jpg"],"type":0,"id":9709655,"ga_prefix":"040107","title":"《复联 4》能够在中国优先安排，其实暗藏玄机"},{"images":["https://pic3.zhimg.com/v2-06a97a7323381f429ac29508cb577eca.jpg"],"type":0,"id":9709553,"ga_prefix":"040106","title":"瞎扯 · 如何正确地吐槽"}]
     */

    private String date;
    private List<StoriesBean> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic2.zhimg.com/v2-3d62e0e52549e6696c376f188716fcd1.jpg"]
         * type : 0
         * id : 9709698
         * ga_prefix : 040122
         * title : 小事 · 有些事我已忘记，有些事我还记得
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
