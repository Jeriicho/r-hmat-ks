package Rühmatöö;
import java.util.Scanner;

public class TestBussid {

    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);
        while (true) {
            System.out.println("Sisestage lähtekoht või vajutage enterit, et lõpetada: ");
            String algus=scan.nextLine();
            System.out.println(algus);
            if (!algus.equals("")){
                System.out.println("Sisestage sihtkoht: ");
                String lõpp=scan.nextLine();
                System.out.println("Sisestage kuupäev: ");
                String päev=scan.nextLine();
                System.out.println("Sisestage kuu: ");
                String kuu=scan.nextLine();
                PiletiLeidja piletileidja = new PiletiLeidja(algus, lõpp, päev, kuu);
                piletileidja.prindiPiletid();
            }
            else break;
        }
        System.out.println("Järgmise korrani!");
        System.out.printf("Jõudu!");
    }
}
    
