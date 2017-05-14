package baidu.baiwei.com.dukailintab;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/5/14 0014.
 */
public class ViewHoldertwo extends MyPage.ViewHolder {
     final TextView title3;
     final ImageView image3;

    public ViewHoldertwo(View itemView) {
        super(itemView);
        title3=  (TextView) itemView.findViewById(R.id.title3);
        image3 = (ImageView) itemView.findViewById(R.id.images3);
    }

}
