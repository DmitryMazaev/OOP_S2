package Interfaces;

import java.util.List;

import Classes.Client;
import Classes.PromoClient;

public interface iPromoBehavior {

    void takeInPromoQueue(PromoClient promoClient); //Вопрос!
    
    void participationPromo(List<PromoClient> promoSet); //Вопрос!
}
