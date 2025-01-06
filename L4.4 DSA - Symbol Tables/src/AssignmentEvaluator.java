import java.util.HashMap;
import java.util.Stack;

public class AssignmentEvaluator {

    private final HashMap<String, Double> symbolTable;

    public AssignmentEvaluator() {
        symbolTable = new HashMap<>();
    }

    private void assignVariable(String line) {
        String[] parts = line.split("=");
        String varName = parts[0].trim();
        String expression = parts[1].trim();
        double value = evaluateExpression(expression);
        symbolTable.put(varName, value);
    }

    private double evaluateExpression(String expression) {
        Stack<Double> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == ' ') {
                continue;
            }

            if (ch == '(') {
                ops.push(ch);
            } else if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                values.push(Double.parseDouble(sb.toString()));
                i--;
            } else if (Character.isLetter(ch)) {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && Character.isLetter(expression.charAt(i))) {
                    sb.append(expression.charAt(i++));
                }
                values.push(symbolTable.get(sb.toString()));
                i--;
            } else if (ch == ')') {
                while (ops.peek() != '(') {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!ops.isEmpty() && hasPrecedence(ch, ops.peek())) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(ch);
            }
        }

        while (!ops.isEmpty()) {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    private boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

    private double applyOp(char op, double b, double a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
        }
        return 0;
    }

    private void printVariable(String varName) {
        Double value = symbolTable.get(varName);
        if (value != null) {
            StdOut.println(value);
        } else {
            StdOut.println("Variable not defined: " + varName);
        }
    }

    public static void main(String[] args) {
        AssignmentEvaluator evaluator = new AssignmentEvaluator();

        StdOut.println("Enter your statements:");
        while (!StdIn.isEmpty()) {
            String line = StdIn.readLine();

            if (line.startsWith("print(") && line.endsWith(")")) {
                String varName = line.substring(6, line.length() - 1);
                evaluator.printVariable(varName);
            } else {
                evaluator.assignVariable(line);
            }
        }
    }
}
