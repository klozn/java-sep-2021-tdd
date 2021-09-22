package code_examples.code_example04_inner_class.v1_private;

public class Head {

    private Brain brain;
    private boolean hasHeadache;

    public Head() {
        brain = new Brain();
        hasHeadache = false;
    }

    public boolean hasHeadache() {
        return hasHeadache;
    }

    public void acquireSunburn() {
        brain.reactToSunburn();
    }

    private class Brain {

        private void reactToSunburn() {
            hasHeadache = true;
        }
    }
}
