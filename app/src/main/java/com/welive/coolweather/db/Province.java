package com.welive.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by welive on 2017/2/10.
 *
 * 创建数据库相关数据名称
 *
 * 使用框架  LitePal   https://github.com/LitePalFramework/LitePal
 */

public class Province extends DataSupport{

    private int id;
    private String provinceName;
    private int provinceCode;

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}
