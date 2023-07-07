package Interfaces;

public interface iQueueBehavior 
{
    /**
     * 
     * @return метод, воспроизводящий включение клиента в очередь
     */
    void takeInQueue(iClientBehavior client);

    /**
     * 
     * @return метод, воспроизводящий выход клиента из очереди
     */
    void releaseFromQueue();

    /**
     * 
     * @return метод, воспроизводящий получение заказа
     */
    void takeOrder();

    /**
     * 
     * @return метод, воспроизводящий совершение заказа
     */
    void giveOrder();
}
