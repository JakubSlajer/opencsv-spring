package com.idc.demo.dao;

import com.idc.demo.domain.Sale;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaleDAO {

    private List<Sale> listSales;

    public List<Sale> getListSales() {
        return listSales;
    }

    public void setListSales(List<Sale> listSales) {
        this.listSales = listSales;
    }
}
