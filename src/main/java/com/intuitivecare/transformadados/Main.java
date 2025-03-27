package com.intuitivecare.transformadados;

import com.intuitivecare.transformadados.services.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String saveDir = "downloads";
        String csvPath = "Teste_dados.csv";
        String zipPath = "Teste_dados.zip";

        try {

            String pdfURL = Scraper.getAnexo1Link();
            System.out.println("Link do Anexo I encontrado: " + pdfURL);


            FileDownloader.downloadFile(pdfURL, saveDir);
            String pdfPath = saveDir + "/Anexo_I.pdf";


            try (FileInputStream pdfStream = new FileInputStream(pdfPath)) {
                String extractedText = PdfExtractor.extractTextFromPDF(pdfStream);


                List<String[]> structuredData = processExtractedText(extractedText);


                AbbreviationReplacer.replaceAbbreviations(structuredData);


                CsvWriter.saveToCsv(structuredData, csvPath);


                ZipCompressor.zipFile(csvPath, zipPath);
            }

            System.out.println("Processo concluído com sucesso! Arquivo gerado: " + zipPath);
        } catch (IOException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    private static List<String[]> processExtractedText(String extractedText) {
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"Código", "OD", "AMB", "Descrição"}); // Cabeçalho da tabela


        String[] linhas = extractedText.split("\n");
        for (String linha : linhas) {
            String[] colunas = linha.split("\\s+"); // Divide por espaços
            if (colunas.length >= 4) { // Garante que tenha pelo menos 4 colunas
                data.add(new String[]{colunas[0], colunas[1], colunas[2], colunas[3]});
            }
        }
        return data;
    }
}
