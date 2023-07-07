import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import Classes.Market;
import Classes.OrdinaryClient;
import Classes.PromoClient;
import Classes.SecretShopper;
import Classes.VIPClient;
import Interfaces.iClientBehavior;

public class Main {
    public static void main(String[] args) {


        //Logger logger = Logger.getLogger(Main.class.getName());
        //ConsoleHandler ch = new ConsoleHandler();
        //logger.addHandler(ch);
        //SimpleFormatter simpleFormatter = new SimpleFormatter();
        //ch.setFormatter(simpleFormatter);
        //logger.info("Работа магазина");

        Market market = new Market();
        iClientBehavior client1 = new OrdinaryClient("Иван", "мужской");
        iClientBehavior client2 = new OrdinaryClient("Анна", "женский");
        iClientBehavior vipClient1 = new VIPClient("Петр Иванович", 1);
        iClientBehavior promoClient1 = new PromoClient("ВАСЯ", 1);
        iClientBehavior promoClient2 = new PromoClient("ФЕДЯ", 2);
        iClientBehavior promoClient3 = new PromoClient("ЛЕША", 3);
        iClientBehavior promoClient4 = new PromoClient("ГАЛЯ", 4);

        iClientBehavior secretShopper1 = new SecretShopper("Тайный покупатель Виктор", 116);

        market.acceptToMarket(client1);
        market.acceptToMarket(client2);
        market.acceptToMarket(vipClient1);
        market.acceptToMarket(promoClient1);
        market.acceptToMarket(promoClient2);
        market.acceptToMarket(promoClient3);
        market.acceptToMarket(promoClient4);

        market.acceptToMarket(secretShopper1);


        market.update();
    }
}
