package sweets;

public class Spartak extends AbstractSweet{
    public String filler;
    public int coefficient = 1;

    public Spartak(int weight, String name, int calories){
        this.weight = weight;
        this.name = name;
        this.calories = calories;
        this.type = SweetType.SPARTAK;
    }
    public Spartak(){
        this.type = SweetType.SPARTAK;
    }

    @Override
    public int getWeight(){
        return  coefficient * weight;
    }

    @Override
    public int hashCode(){
        int hash = 9;
        hash = 79 * hash + this.weight;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (obj instanceof Spartak){
            Spartak temp = (Spartak) obj;
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