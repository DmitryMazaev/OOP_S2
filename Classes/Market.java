package Classes;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import Interfaces.iReturnBehavior;
import Interfaces.iMarketBehavior;
import Interfaces.iPromoBehavior;
import Interfaces.iQueueBehavior;

public class Market implements iMarketBehavior, iQueueBehavior, iReturnBehavior, iPromoBehavior{

    public Market ()
    {
        this.queue = new ArrayList <Client> ();
    }

    private List <Client> queue;
    
    private List<Client> satisfiedClients = new ArrayList<>();

    private List<Client> notSatisfiedClients = new ArrayList<>();

    private List<PromoClient> promoSet = new ArrayList<>();

    @Override
    public void acceptToMarket(Client client) 
    {
        System.out.println("Клиент " + client.getClient().getName().toString() +" пришел(а) в магазин");
        takeInQueue(client);
    }


    @Override
    public void takeInQueue(Client client) {
        this.queue.add(client);
        System.out.println("Клиент " + client.getClient().getName()+" добавлен(а) в очередь ");
        
    }


    @Override
    public void releaseFromQueue() {
        List<Client> releaseClients = new ArrayList<>();
        for(Client newClient:queue)
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
        for(Client newClient: queue)
        {
            if(newClient.isMakeOrder())
            {
                newClient.setTakeOrder(true);
                System.out.println("Клиент " + newClient.getClient().getName()+" получил(а) свой заказ ");
            }
        }
    }

    @Override
    public void takeOrder() {
        for(Client newClient:queue)
        {
            if(!newClient.isMakeOrder())
            {
                newClient.setMakeOrder(true);
                System.out.println("Клиент " + newClient.getClient().getName()+" сделал(а) заказ ");

            }
        }
    }


    @Override
    public void releaseFromMarket(List<Client> clients) {
        for(Client newClient:clients)
        {
            System.out.println("Клиент " + newClient.getName()+" ушел(а) из магазина ");
            queue.remove(newClient);
        }
        
    }

    

    @Override
    public void evaluateOrder() {
        for(Client newClient:queue)
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
        for(Client newClient: notSatisfiedClients)
        {
            System.out.println("Клиент " + newClient.getClient().getName()+" вернул(а) товар");
        }
    }   

    @Override
    public void update() 
    {
        takeOrder();     
        giveOrder();
        takeInPromoQueue(null); /// Вопрос!
        evaluateOrder();
        returnOrder();
        releaseFromQueue();
    }

    @Override
    public void takeInPromoQueue(PromoClient promoClient) //Вопрос!
    {
            if (this.promoSet.size() <= promoClient.promoVolume)
            {
                System.out.println("Участник акции " + promoClient + " предъявил купон на участие в акции");
                promoSet.add(promoClient);

            }
            else
            {
                System.out.println("Участнику акции " + promoClient + " отказано в участии, поскольку превышено число возможных участников");
            }
    }

    @Override
    public void participationPromo(List<PromoClient> promoSet) //Вопрос!
    {
        for(PromoClient newProClient: promoSet)
        {
            for(Client newClient: satisfiedClients)
            {
                System.out.println("Участник акции " + newClient + " получил подарок");
            }
        }
    }


    
    
}
