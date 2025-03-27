package com.intuitivecare.transformadados.services;

import java.util.List;

public class AbbreviationReplacer {
    public static void replaceAbbreviations(List<String[]> data) {
        for (String[] row : data) {
            row[1] = row[1].replace("OD", "Seg. Odontológica");
            row[2] = row[2].replace("AMB", "Seg. Ambulatorial");
        }
    }
}
