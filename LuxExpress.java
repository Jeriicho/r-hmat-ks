package Rühmatöö;

import org.jsoup.*;
import org.jsoup.nodes.Document;

public class LuxExpress extends Bussid {

    LuxExpress(String lähtekoht, String sihtkoht, String päev, String kuu) {
        super(lähtekoht, sihtkoht, päev, kuu);
    }

    public boolean onVabuKohti(){
        return false;
    }

    public String genereeriMaandumisLeht() {
        String algus = "https://ticket.luxexpress.eu/reiside-soiduplaan/";
        String kuu = "?Date=";
        String lõpp = "-2016&ReturnDate=&MultiHopSearchSortOrder=StartTimeAndDuration&CampaignCode=&Currency=CURRENCY.EUR";
        String koguURL = algus + getLähtekoht() + "/" + getSihtkoht() + kuu + getKuu() + "-" + getPäev() + lõpp;
        return koguURL;
    }



    //https://ticket.luxexpress.eu/reiside-soiduplaan/tallinn/tartu?Date=10-14-2016&ReturnDate=&MultiHopSearchSortOrder=StartTimeAndDuration&CampaignCode=&Currency=CURRENCY.EUR

}
