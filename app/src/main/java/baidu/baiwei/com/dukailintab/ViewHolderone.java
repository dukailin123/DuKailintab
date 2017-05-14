package baidu.baiwei.com.dukailintab;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/5/14 0014.
 */
public class ViewHolderone extends MyPage.ViewHolder {

     final TextView title2;
     final ImageView images2;
     final ImageView imageview2;

    public ViewHolderone(View itemView) {
        super(itemView);
        title2 = (TextView) itemView.findViewById(R.id.title2);
        images2 = (ImageView) itemView.findViewById(R.id.images2);
        imageview2 = (ImageView) itemView.findViewById(R.id.imageview2);

    }
}
