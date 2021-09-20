package codelab09.peripherals;

public class Keyboard extends PeripheralDevice {
    private KeyboardLayout layout;

    public Keyboard(KeyboardLayout layout) {
        this.layout = layout;
    }

    @Override
    public void use() {
        System.out.println("Using a keyboard.");
    }
}
