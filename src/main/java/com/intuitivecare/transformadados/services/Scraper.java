package com.intuitivecare.transformadados.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Scraper {
    private static final String URL_BASE = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";

    public static String getAnexo1Link() throws IOException {
        Document doc = Jsoup.connect(URL_BASE).timeout(15000).get();
        Elements links = doc.select("a[href]");

        for (Element link : links) {
            String fileUrl = link.absUrl("href");
            String linkText = link.text();


            if (fileUrl.toLowerCase().endsWith(".pdf") && linkText.toLowerCase().contains("anexo i")) {
                return fileUrl;
            }
        }


        throw new IOException("O PDF do Anexo I não foi encontrado na página.");
    }
}
