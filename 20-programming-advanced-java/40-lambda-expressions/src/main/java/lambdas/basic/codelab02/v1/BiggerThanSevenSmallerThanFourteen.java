package lambdas.basic.codelab02.v1;

public class BiggerThanSevenSmallerThanFourteen implements OperatorValidator {
    @Override
    public boolean isValid(int operator) {
        return operator > 7 && operator < 14;
    }
}
