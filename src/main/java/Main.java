import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;

public class Main {

    private static final String NASA_KEY = "t8fhRAYhYfCSLKnaw8EWnWOzW5DwYfQIlVEiGVdL";
    public static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000) // максимальное время ожидания подключения к серверу
                        .setSocketTimeout(30000) // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();

        HttpGet request = new HttpGet("https://api.nasa.gov/planetary/apod?api_key=" + NASA_KEY);
        CloseableHttpResponse response = httpClient.execute(request);

        NasaData nasaData = mapper.readValue(response.getEntity().getContent(), new TypeReference<> (){});

        String urlContent = nasaData.getUrl();
        HttpGet requestContent = new HttpGet(urlContent);
        CloseableHttpResponse responseContent = httpClient.execute(requestContent);
        
        String fileName = urlContent.substring(urlContent.lastIndexOf("/") + 1);
        byte[] content = responseContent.getEntity().getContent().readAllBytes();

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName))) {
            bos.write(content);
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("Сохранен файл " + fileName);
        }
    }
}
