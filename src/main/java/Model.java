import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final Model instance = new Model();
    private final List<User> userList;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        userList = new ArrayList<>();
        userList.add(new User("alex", "Alexei", "123"));
        userList.add(new User("oleg", "Oleg", "1234"));
        userList.add(new User("sasha", "Alexander", "1234"));
    }

    public List<User> getUserList() {
        return userList;
    }
}
