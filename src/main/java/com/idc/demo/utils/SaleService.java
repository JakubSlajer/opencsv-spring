package com.idc.demo.utils;

import com.idc.demo.dao.SaleDAO;
import com.idc.demo.dao.SaleSearchCriteria;
import com.idc.demo.domain.Sale;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class SaleService {

    private final SaleDAO saleDAO;

    public SaleService(SaleDAO saleDAO) {
        this.saleDAO = saleDAO;
    }

    public List<Sale> getSalesUnsorted() {
        return saleDAO.getListSales();
    }

    /**
     * Find sales by search criteria attributes created by {@code SaleSearchCriteria.Builder}
     *
     * @param searchCriteria criteria to filter by
     * @return list of filtered sales
     */
    public List<Sale> findBySearchCriteria(SaleSearchCriteria searchCriteria) {
        Stream<Sale> stream = saleDAO.getListSales().stream();
        stream = stream.filter(sale -> searchCriteria.quarter == null || sale.getQuarter().equals(searchCriteria.quarter))
                .filter(sale -> searchCriteria.country == null || sale.getCountry().equals(searchCriteria.country));
        return stream.toList();
    }


}
