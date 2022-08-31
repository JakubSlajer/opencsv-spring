package com.idc.demo.web;

import com.idc.demo.dao.SaleSearchCriteria;
import com.idc.demo.domain.Sale;
import com.idc.demo.utils.PercentageCalculator;
import com.idc.demo.utils.QuarterValidator;
import com.idc.demo.utils.SaleService;
import org.jfree.data.time.Quarter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

@Controller
public class WebController {
    private final SaleService saleService;
    private final PercentageCalculator percentageCalculator;

    public WebController(SaleService saleService, PercentageCalculator percentageCalculator) {
        this.saleService = saleService;
        this.percentageCalculator = percentageCalculator;
    }

    /**
     * Index page
     * @param model markdown model
     * @return index template
     */
    @GetMapping("/")
    String showIndexPage(Model model) {
        model.addAttribute("sales", saleService.getSalesUnsorted());
        return "index";
    }

    /**
     * Sales overview page
     * @param country country request parameter
     * @param quarter quarter request parameter (YYYY-QQ)
     * @param model markdown model
     * @return sales template
     */
    @GetMapping("/sales")
    String showByConditions(
            @RequestParam(value = "country", required = false) String country,
            @RequestParam(value = "quarter", required = false) String quarter,
            Model model) {

        // map request parameter country to format that match Sale.country field values
        String finalParamCountry = switch (country == null ? "" : country.toUpperCase()) {
            case ("CZ") -> "Czech Republic";
            case ("SK") -> "Slovakia";
            default -> null;
        };

        // create search criteria from request parameters
        QuarterValidator quarterValidator = new QuarterValidator();
        SaleSearchCriteria.Builder saleSearchCriteriaBuilder = new SaleSearchCriteria.Builder()
                .country(finalParamCountry)
                .quarter(quarter == null ? null :
                        !quarterValidator.isValid(quarter) ? null :
                                Quarter.parseQuarter(quarter));

        // filtering sales with search criteria class
        List<Sale> sales = saleService.findBySearchCriteria(saleSearchCriteriaBuilder.build());

        // calculating market sales
        List<Integer> unitsSold = new ArrayList<>();
        sales.forEach(sale -> unitsSold.add(sale.getUnits()));
        int sum = unitsSold.stream().mapToInt(Integer::intValue).sum();

        // calculating market share
        // move market share field from sale class to e.g. SaleVO and calculate it before each http request
        sales.forEach(sale -> {
            var units = sale.getUnits();
            var percentage = percentageCalculator.calculatePercentage(units, sum);
            sale.setMarketSharePerQuarter(round(percentage * 100.0) / 100.0f);
        });

        // markdown attributes
        model.addAttribute("sales", sales);
        model.addAttribute("total_sales", sum);

        return "sales";
    }
}
