import Classes.Client;
import Classes.Market;
import Classes.OrdinaryClient;
import Classes.PromoClient;
import Classes.VIPClient;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        Client client1 = new OrdinaryClient("Иван", "мужской");
        Client client2 = new OrdinaryClient("Анна", "женский");
        Client vipClient1 = new VIPClient("Петр Иванович", 1);
        Client promoClient1 = new PromoClient("ВАСЯ", 1);
        Client promoClient2 = new PromoClient("ФЕДЯ", 2);

        market.acceptToMarket(client1);
        market.acceptToMarket(client2);
        market.acceptToMarket(vipClient1);
        market.acceptToMarket(promoClient1);
        market.acceptToMarket(promoClient2);


        market.update();
    }
}
