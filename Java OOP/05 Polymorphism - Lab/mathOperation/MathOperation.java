package mathOperation;

public class MathOperation {

    public int add(int n1, int n2) {
        return this.sumTwoNumbers(n1, n2);
    }

    public int add(int n1, int n2, int n3) {
        return this.sumTwoNumbers(this.sumTwoNumbers(n1, n2), n3);
    }

    public int add(int n1, int n2, int n3, int n4) {
        return this.sumTwoNumbers(n1, n2) + this.sumTwoNumbers(n3, n4);
    }

    private int sumTwoNumbers(int a, int b) {
        return a + b;
    }

}
