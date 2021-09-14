package codelab02;

public class MyRectangle {
    public static int nrOfRektAngles;
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private String label;

    private MyRectangle(int xPos, int yPos, int width, int height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        nrOfRektAngles++;
    }

    private static MyRectangle createRectangle() {
        return new MyRectangle(0,0,0,0);
    }

    public static MyRectangle createRectangleWithCoordinates(int xPos, int yPos) {
        return new MyRectangle(xPos, yPos, 50, 100);
    }

    public static MyRectangle createRectangleWithDimensions(int width, int height) {
        return new MyRectangle(5, 10, width, height);
    }

    public static MyRectangle createRectangle(int xPos, int yPos, int width, int height) {
        return new MyRectangle(xPos, yPos, width, height);
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setDimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int calcArea() {
        return getHeight() * getWidth();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public static MyRectangle duplicate(MyRectangle rectangle) {
        return new MyRectangle(rectangle.getXPos(), rectangle.getYPos(),
                rectangle.getWidth(), rectangle.getHeight());
    }
}
