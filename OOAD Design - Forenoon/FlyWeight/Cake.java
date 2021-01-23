public class Cake implements CakeInterface{
    private String cakeType;
    private int size;

    public Cake(){}
    public Cake(String cakeType){ this.cakeType= cakeType; }
    public String getCakeType() { return cakeType; }
    public void setCakeType(String cakeType) { this.cakeType = cakeType; }
    public int getSize() { return size; }
    public void setSize(int size) { this.size = size; }

    @Override
    public void bake(){
        System.out.println(this.getCakeType()+":"+this.getSize()+" is baking...");
    }
}
