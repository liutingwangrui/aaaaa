package net.com.myapplication;

/**
 * Created by Administrator on 2018/6/14 0014.
 */

public class Bean {
    /**
     * CityId : 18
     * CityName : 西安
     * ProvinceId : 27
     * CityOrder : 1
     */

    private int CityId;
    private String CityName;
    private int ProvinceId;
    private int CityOrder;

    public int getCityId() {
        return CityId;
    }

    public void setCityId(int CityId) {
        this.CityId = CityId;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    public int getProvinceId() {
        return ProvinceId;
    }

    public void setProvinceId(int ProvinceId) {
        this.ProvinceId = ProvinceId;
    }

    public int getCityOrder() {
        return CityOrder;
    }

    public void setCityOrder(int CityOrder) {
        this.CityOrder = CityOrder;
    }
}
