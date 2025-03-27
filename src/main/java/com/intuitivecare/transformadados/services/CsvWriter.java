
package com.intuitivecare.transformadados.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

public class CsvWriter {
    public static void saveToCsv(List<String[]> data, String filePath) throws IOException {

        try (Writer writer = new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8")) {
            for (String[] row : data) {
                String csvRow = String.join(",", row); // Usa vírgula como delimitador
                writer.write(csvRow + "\n");
            }
        }
    }
}




