package Classes;

import Interfaces.iClientBehavior;

/**
 * Абстрактный класс Client
 * 
 * @param используемые поля: name, isTakeOrder, isMakeOrder
 */
public abstract class Client implements iClientBehavior{

    protected String name;

    /**
     * булевое значение забранного заказа (true или false)
     */
    protected boolean isTakeOrder;

    /**
     * булевое значение сделанного заказа (true или false)
     */
    protected boolean isMakeOrder;

    public Client(String name) {
        this.name = name;
    }

    /**
     * абстрактный метод, возвращает имя клиента
     */
    abstract public String getName();
}