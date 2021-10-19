package sweets;

public abstract class AbstractSweet implements WeightInterface{
    protected int weight;
    protected String name;
    protected int calories;
    public SweetType type;

    public AbstractSweet() {}

    public int getCalories() {
        return calories;
    }
    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString()
    {
        String str = new String();
        str = type + " " + calories + " " + name + " " + weight + " ";
        return str;
    }
}
