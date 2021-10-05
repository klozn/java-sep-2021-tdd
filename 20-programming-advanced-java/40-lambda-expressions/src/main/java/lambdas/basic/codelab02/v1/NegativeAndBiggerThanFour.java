package lambdas.basic.codelab02.v1;

public class NegativeAndBiggerThanFour implements OperatorValidator {
    @Override
    public boolean isValid(int operator) {
        return operator < 0 && operator > - 4;
    }
}
