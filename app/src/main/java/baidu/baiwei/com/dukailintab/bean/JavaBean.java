package baidu.baiwei.com.dukailintab.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/12 0012.
 */

public class JavaBean implements Serializable{
    private String title;
    private boolean check;
    private String images;

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public JavaBean(String title, boolean check, String images) {
        this.title = title;
        this.check = check;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
