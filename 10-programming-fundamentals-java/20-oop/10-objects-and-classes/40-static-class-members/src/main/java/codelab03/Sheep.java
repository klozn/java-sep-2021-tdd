package codelab03;

public class Sheep {
    private static int amountOfActiveSheep;

    private String nickname;
    private double price;
    private boolean white;

    public Sheep(String nickname, double price, boolean white) {
        setNickname(nickname);
        this.price = price;
        this.white = white;
        amountOfActiveSheep++;
    }

    public static int amountOfActiveSheep() {
        return amountOfActiveSheep;
    }

    public String getNickname() {
        return nickname;
    }

    public double getPrice() {
        return price;
    }

    public boolean isWhite() {
        return white;
    }

    private void setNickname(String nickname) {
        if (!nickname.strip().equalsIgnoreCase("dolly")) {
            this.nickname = nickname;
        }
    }

    @Override
    public String toString() {
        return String.format("I'm a sheep named %s (which is not Dolly) and I'm %s",
                nickname, white? "white": "not white");
    }
}
