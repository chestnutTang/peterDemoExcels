package demo.third.com.exceldemo.app.events;

/**
 * 跳转到主页中的哪一个页面
 */
public class GoToSortEvent {


    private int tab;

    public GoToSortEvent(int tab) {
        this.tab = tab;
    }

    public int getTab() {
        return this.tab;
    }
}
