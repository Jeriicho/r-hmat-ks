package Rühmatöö;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import org.jsoup.select.*;

import static javafx.scene.input.DataFormat.URL;


public class TestBussid{

    public static void main(String[] args) throws Exception {
        LuxExpress buss = new LuxExpress("Tallinn", "Tartu", "15", "10");
        URL url = new URL(buss.genereeriMaandumisLeht());
        URLConnection connect = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader((connect.getInputStream())));
        String inputLine;
        String html = "";
        while ((inputLine = in.readLine()) != null)
            html += inputLine;
        in.close();

        Document doc = Jsoup.parse(html);
        Elements elemendid = doc.select(".inactiveHeader");
        System.out.println(elemendid);


    }
}
