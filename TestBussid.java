package Rühmatöö;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import org.jsoup.select.*;

import static javafx.scene.input.DataFormat.URL;


public class TestBussid{

    public static void main(String[] args) throws Exception {
        LuxExpress buss = new LuxExpress("Tartu", "Tallinn", "19", "10");
        URL url = new URL(buss.genereeriMaandumisLeht());
        URLConnection connect = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader((connect.getInputStream())));
        String inputLine;
        String html = "";
        while ((inputLine = in.readLine()) != null)
            html += inputLine;
        in.close();

        Document doc = Jsoup.parse(html);
        Elements elemendid = doc.select(".regular-fullPrice");
        for (Element element : elemendid) {
            Elements div = element.children().tagName("div");
            if (!div.hasClass("sold-out-text")) {
                System.out.println("Väljumisaeg: ");
                System.out.println(element.parent().parent().parent().parent().parent().parent().child(0).child(0).child(0).child(0).html()); // 6 parentNode'i, millele järgneb 4 child(0) node'i
                System.out.println("Piletihind: ");
                System.out.println(element.child(0).html());
                System.out.println(" --- ");
            }

        }
        
    }
}
