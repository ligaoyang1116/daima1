package com.gy.lgy20190102;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.gy.lgy20190102.adapter.ShouYeAdapter;
import com.gy.lgy20190102.bean.LgyBean;
import com.gy.lgy20190102.presenter.Presenterimpl;
import com.gy.lgy20190102.view.IView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {

    private GridView t1;
    private ShouYeAdapter shouYeAdapter;
    private List<LgyBean.DataBean.TuijianBean.ListBeanX> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.t1);
        //初始化presenter
        Presenterimpl presenterimpl = new Presenterimpl(this);
        presenterimpl.getPreDta();
    }

    @Override
    public void getMviewData(final LgyBean lgyBean) {
        new Thread(){
            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    private Intent intent;
                    private String detailUrl;

                    @Override
                    public void run() {
                        //初始化适配器
                        list = lgyBean.getData().getTuijian().getList();
                        shouYeAdapter = new ShouYeAdapter(MainActivity.this, list);
                        t1.setAdapter(shouYeAdapter);
                        t1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                            @Override
                            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                                list.remove(position);
                                shouYeAdapter.notifyDataSetChanged();
                                Toast.makeText(MainActivity.this,"删除成功",Toast.LENGTH_LONG).show();
                                return true;
                            }
                        });
                        for (int i=0;i<list.size();i++){
                            detailUrl = list.get(i).getDetailUrl();
                            intent = new Intent(MainActivity.this, XiangQingActivity.class);
                            intent.putExtra("gy",detailUrl);
                        }
                        //点击跳转详情页面
                        t1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                startActivity(intent);
                            }
                        });
                    }
                });
            }
        }.start();
    }
}
