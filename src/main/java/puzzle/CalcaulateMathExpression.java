package puzzle;

import java.security.InvalidParameterException;
import java.util.Stack;

/**
 * Created by Zhong on 2014/7/14.
 */
public class CalcaulateMathExpression {

    public static enum Operator {
        MINUS('-', 0),
        PLUS('+', 0),
        MULTI('*', 1),
        DIV('/', 1),
        LEFT_BRACE('(', Integer.MIN_VALUE),
        RIGHT_BRACE(')', Integer.MAX_VALUE),
        INVALID('n', Integer.MIN_VALUE);

        private char op;

        private int priority;

        Operator(char sym, int p) {
            op = sym;
            priority = p;
        }

        public char get() {
            return op;
        }

        public int getPriority() {
            return priority;
        }

        public static Operator valueFrom(char in) {
            for (Operator op : Operator.values())
                if (in == op.get())
                    return op;
            return Operator.INVALID;
        }

        @Override
        public String toString() {
            return String.valueOf(op);
        }
    }

    public static String remove(String input) {
        if (input == null || input.trim().equals(""))
            return input;
        Stack<String> resultStack = new Stack<>();
        Stack<Operator> operatorStack = new Stack<>();

        Operator last = Operator.INVALID;

        for (char c : input.trim().toCharArray()) {
            String value = "";
            boolean isOp = true;
            switch (Operator.valueFrom(c)) {
                case MINUS:
                    identifyResult(Operator.MINUS, resultStack, operatorStack);
                    break;
                case PLUS:
                    identifyResult(Operator.PLUS, resultStack, operatorStack);
                    break;
                case MULTI:
                    identifyResult(Operator.MULTI, resultStack, operatorStack);
                    break;
                case DIV:
                    identifyResult(Operator.DIV, resultStack, operatorStack);
                    break;
                case LEFT_BRACE:
                    operatorStack.push(Operator.LEFT_BRACE);
                    break;
                case RIGHT_BRACE:
                    calculate(resultStack, operatorStack);
                    operatorStack.pop();
                    break;
                default:
                    isOp = false;
                    value += c;
            }
            if (!isOp)
                resultStack.push(value);
        }


        while (resultStack.size() > 1)
            calculate(resultStack, operatorStack);
        return resultStack.pop();
    }

    private static void calculate(Stack<String> resultStack, Stack<Operator> operatorStack) {
        String r = "";
        if (resultStack.size() == 1)
            r = resultStack.pop();
        else {
            Operator op = operatorStack.pop();
            if (op.equals(Operator.DIV) || op.equals(Operator.MINUS)) {
                r = resultStack.pop() + r;
                r = op + r;
                r = resultStack.pop() + r;
            } else {
                r += resultStack.pop();
                r += op;
                r += resultStack.pop();
            }
        }
        resultStack.push(r);
    }

    private static void identifyResult(
            Operator operator,
            Stack<String> resultStack, Stack<Operator> operatorStack) {
        if (!operatorStack.isEmpty()) {
            Operator last = operatorStack.peek();
            if (operator.getPriority() > last.getPriority())
                operatorStack.push(operator);
            else if (!resultStack.isEmpty()) {
                calculate(resultStack, operatorStack);
            }
        } else
            operatorStack.push(operator);
    }
}
