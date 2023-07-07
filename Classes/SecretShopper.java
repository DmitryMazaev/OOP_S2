package Classes;

import Interfaces.iClientBehavior;

public class SecretShopper implements iClientBehavior 
{
    private String name;
    private int idSecretShopper;
    private boolean isTakeOrder;
    private boolean isMakeOrder;

    public SecretShopper (String name, Integer idSecretShopper)
    {
        this.name = name;
        this.idSecretShopper = idSecretShopper;
    }

    public String getName() {
        return name;
    }
    public int getIdSecretShopper() {
        return idSecretShopper;
    }

    @Override
    public String toString()
    {
        return getName();
    }

    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    public void setTakeOrder(boolean makeOder) {
        isMakeOrder = makeOder;
    }

    public void setMakeOrder(boolean pikUpOrder) {
        isTakeOrder = pikUpOrder;
    }

    public Client getClient() {
        return new OrdinaryClient(name, name);
    }
}
