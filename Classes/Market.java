package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import Interfaces.iReturnBehavior;
import Interfaces.iClientBehavior;
import Interfaces.iMarketBehavior;
import Interfaces.iPromoBehavior;
import Interfaces.iQueueBehavior;

public class Market implements iMarketBehavior, iQueueBehavior, iReturnBehavior, iPromoBehavior{

    public Market ()
    {
        this.queue = new ArrayList <iClientBehavior> ();
    }

    private List<iClientBehavior> queue;
    
    private List<iClientBehavior> satisfiedClients = new ArrayList<>();

    private List<iClientBehavior> notSatisfiedClients = new ArrayList<>();

    private List<PromoClient> promoSet = new ArrayList<>();

    @Override
    public void acceptToMarket(iClientBehavior client) 
    {
        System.out.println("Клиент " + client.getClient().getName().toString() +" пришел(а) в магазин");
        takeInQueue(client);
    }


    @Override
    public void takeInQueue(iClientBehavior client) {
        this.queue.add(client);
        System.out.println("Клиент " + client.getClient().getName()+" добавлен(а) в очередь ");
        
    }


    @Override
    public void releaseFromQueue() {
        List<iClientBehavior> releaseClients = new ArrayList<>();
        for(iClientBehavior newClient:queue)
        {
            if(newClient.isTakeOrder())
            {
                releaseClients.add(newClient.getClient());
                System.out.println("Клиент " + newClient.getClient().getName()+" ушел(а) из очереди ");
            }

       }
    releaseFromMarket(releaseClients);
    }


@Override
    public void giveOrder() {
        for(iClientBehavior newClient: queue)
        {
            if(!newClient.isMakeOrder())
            {
                newClient.setTakeOrder(true);
                System.out.println("Клиент " + newClient.getClient().getName()+" получил(а) свой заказ ");
            }
        }
    }

    @Override
    public void takeOrder() {
        for(iClientBehavior newClient:queue)
        {
            if(!newClient.isMakeOrder())
            {
                newClient.setMakeOrder(true);
                System.out.println("Клиент " + newClient.getClient().getName()+" сделал(а) заказ ");
                if (newClient.getClass().getName().equals("Classes.PromoClient"))
                {
                    takeInPromoQueue((PromoClient)newClient);
                }
            }
        }
    }


    @Override
    public void releaseFromMarket(List<iClientBehavior> clients) {
        for(iClientBehavior newClient:clients)
        {
            System.out.println("Клиент " + newClient.getName()+" ушел(а) из магазина ");
            queue.remove(newClient);
        }
        
    }

    

    @Override
    public void evaluateOrder() {
        for(iClientBehavior newClient:queue)
        {
            Random rnd = new Random();
            int a = rnd.nextInt(0, 2);
            if(a == 1)
            {
                System.out.println("Клиент " + newClient.getClient().getName()+" остался ДОВОЛЕН(А) заказом");
                this.satisfiedClients.add(newClient);
            }
            else
            {
                System.out.println("Клиент " + newClient.getClient().getName()+" остался НЕДОВОЛЕН(А) заказом");
                this.notSatisfiedClients.add(newClient);
            }
        }

    }

    @Override
    public void returnOrder() {
        for(iClientBehavior newClient: notSatisfiedClients)
        {
            System.out.println("Клиент " + newClient.getClient().getName()+" вернул(а) товар");
        }
    }   

    @Override
    public void update() 
    {
        takeOrder();     
        giveOrder();
        evaluateOrder();
        returnOrder();
        releaseFromQueue();
    }

    @Override
    public void takeInPromoQueue(PromoClient promoClient) //Вопрос!
    {
            if (this.promoSet.size() < promoClient.promoVolume)
            {
                System.out.println("Участник акции " + promoClient + " предъявил купон на участие в акции");
                System.out.println("Участник акции " + promoClient + " получил подарок");
                promoSet.add(promoClient);

            }
            else
            {
                System.out.println("Участнику акции " + promoClient + " отказано в участии, поскольку превышено число возможных участников");
            }
    }
}
