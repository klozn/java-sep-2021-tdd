package codelab07;

public enum ChihuahuaColor {
    BROWN("Brown"), BLACK("Black"), WHITE("White");

    private final String printName;

    ChihuahuaColor(String printName) {
        this.printName = printName;
    }

    public String getPrintName() {
        return printName;
    }
}
