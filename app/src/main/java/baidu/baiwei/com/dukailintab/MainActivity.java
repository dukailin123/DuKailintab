package baidu.baiwei.com.dukailintab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import baidu.baiwei.com.dukailintab.bean.Bean;
import baidu.baiwei.com.dukailintab.bean.JavaBean;
import baidu.baiwei.com.dukailintab.url.Urls;
import baidu.baiwei.com.dukailintab.utils.OkHttpUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView reclv;
    private List<JavaBean> list=new ArrayList<>();
    private Button quan;
    private Button fan;
    private Button queding;
    private ArrayList<JavaBean> list2=new ArrayList<>();
    private ReclvPage page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reclv = (RecyclerView) findViewById(R.id.reclv);
        quan = (Button) findViewById(R.id.quan);
        fan = (Button) findViewById(R.id.fan);
        queding = (Button) findViewById(R.id.queding);
        quan.setOnClickListener(this);
        fan.setOnClickListener(this);
        queding.setOnClickListener(this);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        //设置布局管理器
        reclv.setLayoutManager(manager);
        //设置adapter
        //reclv.setAdapter(adapter)
        //设置Item增加、移除动画
        reclv.setItemAnimator(new DefaultItemAnimator());
        //添加分割线
        reclv.addItemDecoration(new DividerItemDecoration(
                this, DividerItemDecoration.VERTICAL));
        qingqiu();
    }

    private void qingqiu() {
        OkHttpUtils.get(Urls.PATH, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson=new Gson();

                Bean bean = gson.fromJson(string, Bean.class);
                for (Bean.DataBean db:bean.getData()){
                    list.add(new JavaBean(db.getGoods_name(),false,db.getGoods_img()));
                }
                page = new ReclvPage(MainActivity.this);
                page.setList(list);
                reclv.setAdapter(page);



            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.quan:
                for (JavaBean jb:list){
                    jb.setCheck(true);
                }
                break;
            case R.id.fan:
               for (JavaBean jd:list){
                   if(jd.isCheck()){
                       jd.setCheck(false);
                   }else {
                       jd.setCheck(true);
                   }
               }
                break;
            case R.id.queding:
                for (JavaBean jb : list) {
                    if (jb.isCheck()) {
                        list2.add(jb);
                    }
                }
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("list2",list2);
                intent.putExtras(bundle);
                startActivity(intent);
                list2.clear();
                break;

        }
            page.notifyDataSetChanged();
    }
}
