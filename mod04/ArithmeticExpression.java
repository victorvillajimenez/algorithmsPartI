/**
 * List interface. java.util.List is API for an sequence of items.
 * Implementations:
 *      java.util.ArrayList uses resizing array.
 *      java.util.LinkedList uses linked list.
 * Java collections library
 *      java.util.Stack
 *      java.util.Queue
 * Stack applications:
 *      Parsing in a compiler
 *      Java virtual machine
 *      Undo in a word processor
 *      Back button in a Web browser
 *      PostScript language for printers
 *      Implementing function calls in a compiler
 * Function calls: how a compiler implements a function
 *      Function call: push local environment and return address
 *      return: pop return address and local environment
 * Arithmetic expression evaluation
 *      Two-stack algorithm (E.W. Dijkstra)
 *      Context. An interpreter!
 */

public class ArithmeticExpression {

    public static double evaluate (String[] infixExpression) {
        LinkedStack<String> ops = new LinkedStack<String>();
        LinkedStack<Double> vals = new LinkedStack<Double>();
        for (String token : infixExpression) {
            if (token.equals("("));
            else if (token.equals("+")) ops.push(token);
            else if (token.equals("*")) ops.push(token);
            else if (token.equals(")")) {
                String op = ops.pop();
                if (op.equals("+")) vals.push(vals.pop() + vals.pop());
                else if (op.equals("*")) vals.push(vals.pop() * vals.pop());
            } else vals.push(Double.parseDouble(token));
        }
        return vals.pop();
    }

    public static void main (String[] args) {
        String[] expression = new String[] {
            "(", "1", "+", "(", "(", "2", "+", "3", ")", "*", "(", "4", "*", "5", ")", ")", ")"
        };
        Double result = ArithmeticExpression.evaluate(expression);
        System.out.println("result: " + result);
    }
}