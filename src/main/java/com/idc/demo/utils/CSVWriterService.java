package com.idc.demo.utils;

import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.nio.file.Path;
import java.util.List;


/**
 * Example of CSVWriterService
 *
 * Can be possibly used for converting string arrays into a csv file.
 */
@Service
public class CSVWriterService {

    public void writeLineByLine(List<String[]> lines, Path path) throws Exception {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path.toString()))) {
            for (String[] line : lines) {
                writer.writeNext(line);
            }
        }
    }

    public void writeAllLines(List<String[]> lines, Path path) throws Exception {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path.toString()))) {
            writer.writeAll(lines);
        }
    }
}
