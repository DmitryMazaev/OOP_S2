package Interfaces;

import Classes.Client;

public interface iReturnBehavior 
{
    /**
     * @param метод, воспроизводящий оценку клиентом товара
     */
    void evaluateOrder();

    /**
     * @param метод, воспроизводящий возврат клиентом, оставшимся недовльным, товара
     */
    void returnOrder();
}
