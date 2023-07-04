package Classes;

import Interfaces.iPromoBehavior;

public class PromoClient extends Client
{
    public static int promoVolume = 3;

    private int idPromo;

    public int getIdPromo() {
        return idPromo;
    }

    public void setIdPromo(int idPromo) {
        this.idPromo = idPromo;
    }

    public PromoClient(String name, int idPromo) {
        super(name);
        this.idPromo = idPromo;

    }

    @Override
    public String getName() {
        return super.name;
    }

    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }

    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    public void setTakeOrder(boolean makeOder) {
        super.isMakeOrder = makeOder;
    }

    public void setMakeOrder(boolean pikUpOrder) {
        super.isTakeOrder = pikUpOrder;
    }

    public Client getClient() {
        return this;
    }

    
}
