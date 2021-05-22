
import java.util.Scanner;


public class Main {
    
    private static Card[][] kartlar=new Card[4][4];
    
    public static void main(String[] args) {
        
        //İki boyutlu Array'larla hafıza oyunu
        
        kartlar[0][0]=new Card('E');
        kartlar[0][1]=new Card('A');
        kartlar[0][2]=new Card('B');
        kartlar[0][3]=new Card('F');
        kartlar[1][0]=new Card('G');
        kartlar[1][1]=new Card('A');
        kartlar[1][2]=new Card('D');
        kartlar[1][3]=new Card('H');
        kartlar[2][0]=new Card('F');
        kartlar[2][1]=new Card('C');
        kartlar[2][2]=new Card('D');
        kartlar[2][3]=new Card('H');
        kartlar[3][0]=new Card('E');
        kartlar[3][1]=new Card('G');
        kartlar[3][2]=new Card('B');
        kartlar[3][3]=new Card('C');
        //oyunThatasi();
        
        while (oyunBittiMi()==false) {            
            
            oyunThatasi();
            tahminEt();
        }
        
    }
    
    public static void oyunThatasi(){
        
        for (int i = 0; i < 4; i++) {
            System.out.println("______________________");
            
            for (int j = 0; j < 4; j++) {
                if (kartlar[i][j].isTahmin()) {//Eğer karın değeri true ise ekranda gözükücek
                    System.out.print(" |"+kartlar[i][j].getDeger()+"| ");
                }
                
                else{
                    System.out.print(" | | ");//Değilse | | gözükücek
                }
            }
            System.out.println("");
        }
        System.out.println("______________________");
        
        
        
    }
    
    public static void tahminEt(){
        
        Scanner scanner=new Scanner(System.in); 
        
        System.out.print("Birinci Tahmin (i ve j değerlerini bir boşluklu girin...) : ");
        int i1=scanner.nextInt();
        int j1=scanner.nextInt();
        
        kartlar[i1][j1].setTahmin(true);//Geçici süreliğine kartımızı ekranda gösteriyoruz
        oyunThatasi();
        
        System.out.print("İkinci Tahmin (i ve j değerlerini bir boşluklu girin...) : ");
        int i2=scanner.nextInt();
        int j2=scanner.nextInt();
        
        if (kartlar[i1][j1].getDeger()==kartlar[i2][j2].getDeger()) {//Eğer tahmin doğru ise ikinci kartımıza true yapıyoruz yani ekranda gösteriyoruz.
            
            System.out.println("Doğru Tahmin.Tebrikler!");
            kartlar[i2][j2].setTahmin(true);
        }
        else{
            System.out.println("Yanlış Tahmin...");
            kartlar[i1][j1].setTahmin(false);//Eğer tahminler uyuşmuyorsa tekrardan kartımızı false yapıyoruz yani gizliyoruz.
        }
    }
    
    public static boolean oyunBittiMi(){
        
        for (int i = 0; i < 4; i++) {
            
            for (int j = 0; j < 4; j++) {
                
                if (kartlar[i][j].isTahmin()==false) {
                    return false;//False kart var mı? tahmin edilmemiş kart var mı?
                }
            }
        }
        return true;
    }
    
}
