package sweets;

public class Mars extends AbstractSweet{
    private String filler;
    private int coefficient = 1;

    public Mars(int weight, String name, int calories){
        super();
        this.weight = weight;
        this.name = name;
        this.calories = calories;
        this.type = SweetType.MARS;
    }
    public Mars(){
        this.type = SweetType.MARS;
    }
    public String getFiller() {
        return filler;
    }
    public void setFiller(String filler) {
        this.filler = filler;
    }

    @Override
    public int getWeight(){
        return  coefficient * weight;
    }

    @Override
    public int hashCode(){
        int hash = 3;
        hash = 79 * hash + this.weight;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (obj instanceof Mars){
            Mars temp = (Mars) obj;
            return this.weight == temp.weight &&
                    this.name == temp.name &&
                    this.calories == temp.calories &&
                    this.filler == temp.filler;
        }
        else {
            return false;
        }
    }
}