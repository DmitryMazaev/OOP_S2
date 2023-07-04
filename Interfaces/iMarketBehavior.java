package Interfaces;

import java.util.List;

import Classes.Client;

public interface iMarketBehavior 
{
    /**
     * 
     * @return метод, воспроизводящий вход в магазин
     */
    void acceptToMarket(Client client);

    /**
     * 
     * @return метод, воспроизводящий выход из магазина
     */
    void releaseFromMarket(List<Client> client);

    /**
     * 
     * @return метод, воспроизводящий повторение ряда методов данного интерфейса и интерфейса iReturnBehavior
     */
    void update();
}
