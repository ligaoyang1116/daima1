package com.gy.lgy20190102.model;

import com.gy.lgy20190102.utils.OkHttp3;

public class Modelimpl implements IModel{
    @Override
    public void getModelData(String url, final Modelinterface modelinterface) {
        //网络请求数据
        OkHttp3.getHttp(url, new OkHttp3.Httpinterface() {
            @Override
            public void ruslt(String t) {
                modelinterface.getSussecData(t);
            }
        });
    }
}
