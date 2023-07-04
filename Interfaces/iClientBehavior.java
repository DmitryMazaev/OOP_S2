package Interfaces;

import Classes.Client;

public interface iClientBehavior 
{
    /**
     * 
     * @return метод "Заказ получен"
     */
    public boolean isTakeOrder() ;

    /**
     * 
     * @return метод "Заказ сделан"
     */
    public boolean isMakeOrder() ;

    /**
     * 
     * @return метод изменения статуса полученного заказа
     */
    public void setTakeOrder(boolean takeOrder);

    /**
     * 
     * @return метод изменения статуса сделанного заказа
     */
    public void setMakeOrder(boolean makeOrder);

    /**
     * 
     * @return метод отображения клиента
     */
    Client getClient();
}
