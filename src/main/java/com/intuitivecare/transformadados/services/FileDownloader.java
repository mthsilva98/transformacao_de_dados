package com.intuitivecare.transformadados.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileDownloader {
    public static void downloadFile(String fileURL, String saveDir) throws IOException {

        File directory = new File(saveDir);
        if (!directory.exists()) {
            if (!directory.mkdirs()) {
                throw new IOException("Erro ao criar o diretório: " + saveDir);
            }
        }

        URL url = new URL(fileURL);
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        int responseCode = httpConnection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "Anexo_I.pdf";
            try (InputStream inputStream = httpConnection.getInputStream();
                 FileOutputStream outputStream = new FileOutputStream(saveDir + "/" + fileName)) {

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                System.out.println("Arquivo baixado: " + saveDir + "/" + fileName);
            }
        } else {
            throw new IOException("Erro ao baixar arquivo: Código HTTP " + responseCode);
        }
        httpConnection.disconnect();
    }
}

