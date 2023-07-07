package Interfaces;

import Classes.PromoClient;

public interface iPromoBehavior 
{
    /**
     * 
     * @return метод, воспроизводящий добавление в очередь акционных клиентов и выдачу подарка
     */
    void takeInPromoQueue(PromoClient promoClient);

}
