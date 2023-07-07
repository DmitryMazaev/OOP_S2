package Interfaces;

import java.util.List;

public interface iMarketBehavior 
{
    /**
     * 
     * @return метод, воспроизводящий вход в магазин
     */
    void acceptToMarket(iClientBehavior client);

    /**
     * 
     * @return метод, воспроизводящий выход из магазина
     */
    void releaseFromMarket(List<iClientBehavior> client);

    /**
     * 
     * @return метод, воспроизводящий повторение ряда методов данного интерфейса и интерфейса iReturnBehavior
     */
    void update();
}
