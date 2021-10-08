package advanced.additionaltopic03;

public class User {
    private final int id;
    private final String userName;

    public User(int id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", userName='").append(userName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
