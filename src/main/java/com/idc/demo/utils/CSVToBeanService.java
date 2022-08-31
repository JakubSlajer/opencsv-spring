package com.idc.demo.utils;

import com.idc.demo.domain.SaleDTO;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class CSVToBeanService {

    public CSVToBeanService() throws IOException {
    }

    /**
     * Parses data from the csv file into beans / objects directly
     * if the object's field names are bind to csv header values with @CsvBindByName
     * or with @CsvBindByPosition accordingly to the header value positions.
     */
    public List<SaleDTO> saleDTOs = new CsvToBeanBuilder<SaleDTO>(
            Files.newBufferedReader(Paths.get("docs/data.csv")))
            .withType(SaleDTO.class)
            .build()
            .parse();


}
