package com.endless.projects.stock.checker.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsoupTest extends BestBuyTest {

    @Test
    public void extractFile() throws IOException, ParseException {
        Document doc = Jsoup.connect(BESTBUY_GPU_URL).get();
        File file = new File(BESTBUY_DOC_NAME);
        if (file.exists()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String date = sdf.format(new Date());
            file.renameTo(new File("bestbuy." + date + ".html"));
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(doc.toString());
        Assert.assertEquals(doc.title(), BESTBUY_EXPECTED_TITLE);
    }

    @Test
    public void loadDocumentFromFile() throws IOException {
        File file = new File(BESTBUY_DOC_NAME);
        Document doc = Jsoup.parse(file, "UTF-8", BESTBUY_GPU_URL);
        Assert.assertEquals(doc.title(), BESTBUY_EXPECTED_TITLE);
    }

    @Test
    public void evaluateXpath() throws IOException {
        File file = new File(BESTBUY_DOC_NAME);
        Document doc = Jsoup.parse(file, "UTF-8", BESTBUY_GPU_URL);
        Assert.assertEquals(doc.title(), BESTBUY_EXPECTED_TITLE);

        String xpath3090 = "/html/body/div/div/div[2]/div/div/main/div[1]/div[3]/div[2]/div[2]/ul/div/div[1]/div/a/div/div/div[2]/div[1]";
        Elements elements = doc.selectXpath(xpath3090);
        Assert.assertEquals("NVIDIA GeForce RTX 3080 10GB GDDR6X Video Card", elements.text());
    }

    @Test
    public void findXpathByText() throws IOException {
        File file = new File(BESTBUY_DOC_NAME);
        Document doc = Jsoup.parse(file, "UTF-8", BESTBUY_GPU_URL);
        Assert.assertEquals(doc.title(), BESTBUY_EXPECTED_TITLE);

        String elementText = "NVIDIA GeForce RTX 3080 10GB GDDR6X Video Card";
        Elements elements = doc.select(elementText);

        System.out.println(elements);
    }

    @Test
    public void findAllElementsByText() throws IOException {

        File file = new File(BESTBUY_DOC_NAME);
        Document doc = Jsoup.parse(file, "UTF-8", BESTBUY_GPU_URL);
        Assert.assertEquals(doc.title(), BESTBUY_EXPECTED_TITLE);

        for (Element element : doc.getAllElements()) {
            if(element.className().equals("productItemName_3IZ3c")){
                System.out.println("stop");
            }
        }
    }
}
