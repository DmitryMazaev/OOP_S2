package Classes;

public class OrdinaryClient extends Client
{
    private String sex;

    public OrdinaryClient(String name, String sex) {
        super(name);
        this.sex = sex;
    }

    public String getSex() {
        return sex;
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