package selfeval.codelab02.trees;

import selfeval.codelab02.Height;

public abstract class Tree {
    private int age;
    private Height height;

    public Tree(int age, Height height) {
        this.age = age;
        this.height = height;
    }

    public Height getHeight() {
        return height;
    }

    public void setHeight(Height height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public abstract void grow();

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("I am a tree of type ");
        sb.append(getClass().getSimpleName());
        sb.append(". I am ").append(age).append(" years old and am ");
        sb.append(height).append(" high.");
        return sb.toString();
    }
}
