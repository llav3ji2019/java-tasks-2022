package code.homework4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * Задание оценивается в 2 тугрика.
 * Одна из самых популярных задач.
 * Реализовать метод, который проверяет правильность написания скобок в строке.
 * В строке помимо скобок могут содержаться и другие символы.
 * Скобки могут быть: [],{},<>,()
 * Примеры:
 * "(-b + (x)^2)/(2+4)" - true
 * "Понедельники меня угнетают ((" - false
 * <p>
 * Отрабатывать метод должен за О(n)
 */
public class ValidatorForParentheses {
    private static final HashMap<Character, Character> pairsOfBrackets = new HashMap<>();

    static {
        pairsOfBrackets.put('{','}');
        pairsOfBrackets.put('[',']');
        pairsOfBrackets.put('(',')');
        pairsOfBrackets.put('<','>');
    }

    private static boolean isLeftParenthesis(char symbol) {
        return symbol == '{' || symbol == '[' || symbol == '(' || symbol == '<';
    }

    private static boolean isRightParenthesis(char symbol) {
        return symbol == '}' || symbol == ']' || symbol == ')' || symbol == '>';
    }

    private static boolean areEqual(char leftParenthesis, char rightParenthesis) {
        return pairsOfBrackets.get(leftParenthesis).equals(rightParenthesis);
    }

    public static boolean validate(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        boolean hasBrackets = false;
        Deque<Character> myStack = new ArrayDeque<>();
        char[] charsOfValue = value.toCharArray();
        for (char symbol : charsOfValue) {
            if (isLeftParenthesis(symbol)) {
                myStack.addLast(symbol);
                hasBrackets = true;
            } else if (isRightParenthesis(symbol)) {
                hasBrackets = true;
                if (myStack.isEmpty()) {
                    return false;
                }
                char leftParenthesis = myStack.pollLast();
                if (!areEqual(leftParenthesis, symbol)) {
                    return false;
                }
            }
        }
        return myStack.isEmpty() && hasBrackets;
    }
}