package com.idc.demo.utils;

import org.springframework.stereotype.Service;

@Service
public class PercentageCalculator {

    public Float calculatePercentage(Integer obtained, Integer total){
        return (obtained*100)/total.floatValue();
    }
}
