package baidu.baiwei.com.dukailintab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import baidu.baiwei.com.dukailintab.bean.JavaBean;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView reclv2;
    private Intent intent;
    private ArrayList<JavaBean> list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        reclv2 = (RecyclerView) findViewById(R.id.reclv2);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        //设置布局管理器
        reclv2.setLayoutManager(manager);
        //设置adapter
        //reclv.setAdapter(adapter)
        //设置Item增加、移除动画
        reclv2.setItemAnimator(new DefaultItemAnimator());
        //添加分割线
        reclv2.addItemDecoration(new DividerItemDecoration(
                this, DividerItemDecoration.VERTICAL));
        Intent intent = getIntent();
        list2 = (ArrayList<JavaBean>) intent.getSerializableExtra("list2");
        MyPage page=new MyPage(this);
        page.setList(list2);
        reclv2.setAdapter(page);

    }

}
