package baidu.baiwei.com.dukailintab;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import baidu.baiwei.com.dukailintab.bean.JavaBean;

/**
 * Created by Administrator on 2017/5/13 0013.
 */
public class ReclvPage extends RecyclerView.Adapter<ReclvPage.ViewHolder>{
      private List<JavaBean> list=new ArrayList<>();
    private Context context;
    public ReclvPage(Context context){
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item, null);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.cb.setChecked(list.get(position).isCheck());
        //.with(context).load(list.get(position).getImages()).placeholder(R.mipmap.ic_launcher).into(holder.images);
        Glide.with(context).load(list.get(position).getImages()).placeholder(R.mipmap.ic_launcher).into(holder.images);
        holder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(position).isCheck()){
                    list.get(position).setCheck(false);
                }else{
                    list.get(position).setCheck(true);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<JavaBean> list) {
        this.list = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView title;
        private final CheckBox cb;
        private final ImageView images;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            cb = (CheckBox) itemView.findViewById(R.id.cb);
            images = (ImageView) itemView.findViewById(R.id.images);
        }
    }
}
