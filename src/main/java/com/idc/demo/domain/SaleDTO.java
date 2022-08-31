package com.idc.demo.domain;

import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;

/**
 * SaleDTO serializer
 *
 * Serialize Sale object from CSVToBeanBuilder
 */
public class SaleDTO implements Serializable {
    @CsvBindByName(column = "Country")
    private String country;
    @CsvBindByName(column = "TimeScale")
    private String timeScale;
    @CsvBindByName(column = "Vendor")
    private String vendor;
    @CsvBindByName(column = "Units")
    private String units;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTimeScale() {
        return timeScale;
    }

    public void setTimeScale(String timeScale) {
        this.timeScale = timeScale;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "BaseItem{" +
                "country='" + country + '\'' +
                ", timeScale='" + timeScale + '\'' +
                ", vendor='" + vendor + '\'' +
                ", units='" + units + '\'' +
                '}';
    }
}
