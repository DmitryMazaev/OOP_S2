package Classes;

public class VIPClient extends Client {
    private int idVIP;
    private String sex;

    public VIPClient(String name, int idVIP) {
        super(name);
        this.idVIP = idVIP;

    }

    public String getSex() {
        return sex;
    }

    @Override
    public String getName() {
        return super.name;
    }

    public int getIdVIP() {
        return idVIP;
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
