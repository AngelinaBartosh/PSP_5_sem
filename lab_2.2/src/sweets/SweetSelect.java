package sweets;

public class SweetSelect {
    public static AbstractSweet getInstance(SweetType type) {
        if (type == SweetType.SNICKERS){
            return new Snickers();
        }
        else if (type ==  SweetType.MARS){
            return new Mars();
        }
        else if (type ==  SweetType.SPARTAK){
            return new Spartak();
        }
        else if (type ==  SweetType.ROSHEN){
            return new Roshen();
        }
        else{
            return null;
        }
    }

    public static AbstractSweet getInstance(SweetType type, int calories, String name, int weight, int coefficient){
        if (type == SweetType.SNICKERS){
            return new Snickers(weight * coefficient, name, calories * coefficient);
        }
        else if (type ==  SweetType.MARS){
            return new Snickers(weight * coefficient, name, calories * coefficient);
        }
        else if (type ==  SweetType.SPARTAK){
            return new Snickers(weight * coefficient, name, calories * coefficient);
        }
        else if (type ==  SweetType.ROSHEN){
            return new Snickers(weight * coefficient, name, calories * coefficient);
        }
        else{
            return null;
        }

    }
}
