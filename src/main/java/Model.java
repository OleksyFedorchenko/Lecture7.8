import java.util.ArrayList;
import java.util.List;

public class Model {
    private static Model instance = new Model();
    private List<User> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new ArrayList<>();
    }

    public void add(User user) {
        model.add(user);
    }

    public List<User> list() {
        return model;
    }
}
