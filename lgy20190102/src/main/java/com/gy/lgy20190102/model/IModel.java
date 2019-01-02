package com.gy.lgy20190102.model;

public interface IModel {
    void getModelData(String url,Modelinterface modelinterface);
    //定义接口
    public interface Modelinterface{
        //接口方法
        void getSussecData(String s);
    }
}
