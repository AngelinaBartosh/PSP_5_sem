package sweets;

public class Snickers extends AbstractSweet{
    private String filler;
    public int coefficient = 1;

    public Snickers(int weight, String name, int calories){
        this.weight = weight;
        this.name = name;
        this.calories = calories;
        this.type = SweetType.SNICKERS;
    }
    public Snickers(){
        this.type = SweetType.SNICKERS;
    }
    public String getFiller() {
        return filler;
    }
    public void setFiller(String filler) {
        this.filler = filler;
    }

    @Override
    public int getWeight(){
        return coefficient * weight;
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 79 * hash + this.weight;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (obj instanceof Snickers){
            Snickers temp = (Snickers) obj;
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
