package com.idc.demo.domain;

import org.jfree.data.time.Quarter;

public class Sale {
    private String country;
    private String vendor;
    private Integer units;
    private Quarter quarter;
    private Float marketSharePerQuarter;

    /**
     * Sale from SaleDTO constructor
     * not the best approach but you got the idea
     * @param saleDTO SaleDTO object
     */
    public Sale(SaleDTO saleDTO) {
        this.country = saleDTO.getCountry();
        this.vendor = saleDTO.getVendor();
        this.units = (int) Double.parseDouble(saleDTO.getUnits());
        this.quarter = Quarter.parseQuarter(saleDTO.getTimeScale());
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public Quarter getQuarter() {
        return quarter;
    }

    public void setQuarter(Quarter quarter) {
        this.quarter = quarter;
    }

    public Float getMarketSharePerQuarter() {
        return marketSharePerQuarter;
    }

    public void setMarketSharePerQuarter(Float marketSharePerQuarter) {
        this.marketSharePerQuarter = marketSharePerQuarter;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "country='" + country + '\'' +
                ", vendor='" + vendor + '\'' +
                ", units=" + units +
                ", quarter=" + quarter +
                ", marketSharePerQuarter=" + marketSharePerQuarter +
                '}';
    }
}
