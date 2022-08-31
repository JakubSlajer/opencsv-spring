package com.idc.demo.utils;

import com.idc.demo.dao.SaleDAO;
import com.idc.demo.domain.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
    @Autowired
    CSVToBeanService csvToBeanService;
    @Autowired
    SaleDAO saleDAO;

    @Bean
    public void csvDataLoader() {
        // fetch SaleDAO#listSales with data from csv file
        if (saleDAO.getListSales() == null) {
            List<Sale> sales = new ArrayList<>();
            csvToBeanService.saleDTOs.forEach(saleDTO -> sales.add(new Sale(saleDTO)));
            saleDAO.setListSales(sales);
        }
    }
}
