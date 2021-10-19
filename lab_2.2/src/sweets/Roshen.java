package sweets;

public class Roshen extends AbstractSweet{
    private String texture;
    private int coefficient = 1;

    public Roshen(int weight, String name, int calories){
        this.weight = weight;
        this.name = name;
        this.calories = calories;
        this.type = SweetType.ROSHEN;
    }
    public Roshen(){
        this.type = SweetType.ROSHEN;

    }
    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    @Override
    public int getWeight(){
        return  coefficient * weight;
    }

    @Override
    public int hashCode(){
        int hash = 5;
        hash = 79 * hash + this.weight;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (obj instanceof Roshen){
            Roshen temp = (Roshen) obj;
            return this.weight == temp.weight &&
                    this.name == temp.name &&
                    this.calories == temp.calories &&
                    this.texture == temp.texture;
        }
        else {
            return false;
        }
    }
}
