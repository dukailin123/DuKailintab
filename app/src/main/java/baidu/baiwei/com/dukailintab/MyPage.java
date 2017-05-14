package baidu.baiwei.com.dukailintab;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import baidu.baiwei.com.dukailintab.bean.JavaBean;

/**
 * Created by Administrator on 2017/5/13 0013.
 */
public class MyPage extends RecyclerView.Adapter<MyPage.ViewHolder>{
         private static int TYPE_1=0;
         private static int TYPE_2=1;
         private static int TYPE_3=2;
    private Context context;
    private ArrayList<JavaBean> list=new ArrayList<>();
    public MyPage(Context context){
        this.context=context;
    }

    @Override
    public int getItemViewType(int position) {
     
        
        if(position==0){
            return TYPE_1;
        }else if(position==1){
            return TYPE_2;
        }else {
            return TYPE_3;
        }
          

    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
        ViewHolder holder=null;
        switch (viewType){
            case 0:
                 view = View.inflate(context, R.layout.item1, null);
                holder=new ViewHolder(view);
                break;
            case 1:
                view=View.inflate(context,R.layout.item2,null);
                holder=new ViewHolderone(view);
                break;
            case 2:
                view=View.inflate(context,R.layout.item3,null);
                holder=new ViewHoldertwo(view);
                break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
     switch (getItemViewType(position)){
         case 0:
             ViewHolder holder1 = holder;
             holder1.title1.setText(list.get(position).getTitle());
             Glide.with(context).load(list.get(position).getImages()).placeholder(R.mipmap.ic_launcher).into(holder1.image1);

             break;
         case 1:
             ViewHolderone holder2 = (ViewHolderone) holder;
             holder2.title2.setText(list.get(position).getTitle());
             Glide.with(context).load(list.get(position).getImages()).into(holder2.images2);
             Glide.with(context).load(list.get(position).getImages()).into(holder2.imageview2);
             break;
         case 2:
             ViewHoldertwo holder3 = (ViewHoldertwo) holder;
             holder3.title3.setText(list.get(position).getTitle());
             Glide.with(context).load(list.get(position).getImages()).into(holder3.image3);
             break;
     }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(ArrayList<JavaBean> list) {
        this.list = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView title1;
       // private final TextView title2;
      //  private final TextView title3;
        private final ImageView image1;
      /*  private final ImageView image2;
        private final ImageView image3;
        private final ImageView imageview;*/

        public ViewHolder(View itemView) {
            super(itemView);
            title1 = (TextView) itemView.findViewById(R.id.title1);
//            title2 = (TextView) itemView.findViewById(R.id.title2);
//            title3 = (TextView) itemView.findViewById(R.id.title3);
            image1 = (ImageView) itemView.findViewById(R.id.images1);
         /*   image2 = (ImageView) itemView.findViewById(R.id.images2);
            image3 = (ImageView) itemView.findViewById(R.id.images3);
            imageview = (ImageView) itemView.findViewById(R.id.imageview2);
*/
        }
    }
 }
