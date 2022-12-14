import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final Model instance = new Model();
    private final List<User> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new ArrayList<>();
        model.add(new User("alex", "Alexei", "123"));
        model.add(new User("oleg", "Oleg", "1234"));
        model.add(new User("sasha", "Alexander", "1234"));
    }


    public List<User> list() {
        return model;
    }
}
