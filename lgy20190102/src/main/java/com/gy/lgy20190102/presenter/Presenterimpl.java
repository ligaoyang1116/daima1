package com.gy.lgy20190102.presenter;

import com.google.gson.Gson;
import com.gy.lgy20190102.MainActivity;
import com.gy.lgy20190102.api.Api;
import com.gy.lgy20190102.bean.LgyBean;
import com.gy.lgy20190102.model.IModel;
import com.gy.lgy20190102.model.Modelimpl;

public class Presenterimpl implements IPresenter {
    MainActivity mview;
    private final Modelimpl modelimpl;

    public Presenterimpl(MainActivity mview) {
        //初始化model、
        modelimpl = new Modelimpl();
        //初始化view
        this.mview=mview;
    }

    @Override
    public void getPreDta() {
        //model方法
        modelimpl.getModelData(Api.SYURL, new IModel.Modelinterface() {
            @Override
            public void getSussecData(String s) {
                //解析
                Gson gson = new Gson();
                LgyBean lgyBean = gson.fromJson(s, LgyBean.class);
                mview.getMviewData(lgyBean);
            }
        });
    }
}
