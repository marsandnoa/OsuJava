import components.statement.Statement;
import components.statement.StatementKernel.Condition;

/**
 * Utility class with method to count the number of calls to primitive
 * instructions (move, turnleft, turnright, infect, skip) in a given
 * {@code Statement}.
 *
 * @author Put your name here
 *
 */
public final class CountPrimitiveCalls {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CountPrimitiveCalls() {
    }

    /**
     * Reports the number of calls to primitive instructions (move, turnleft,
     * turnright, infect, skip) in a given {@code Statement}.
     *
     * @param s
     *            the {@code Statement}
     * @return the number of calls to primitive instructions in {@code s}
     * @ensures <pre>
     * countOfPrimitiveCalls =
     *  [number of calls to primitive instructions in s]
     * </pre>
     */
    public static int countOfPrimitiveCalls(Statement s) {
        int count = 0;
        switch (s.kind()) {
            case BLOCK: {
                /*
                 * Add up the number of calls to primitive instructions in each
                 * nested statement in the BLOCK.
                 */
                // TODO - fill in case
                int i = 0;
                while (i < s.lengthOfBlock()) {
                    Statement current = s.removeFromBlock(i);
                    count = count + countOfPrimitiveCalls(current);
                    s.addToBlock(i, current);
                    i++;
                }
                break;
            }
            case IF: {
                /*
                 * Find the number of calls to primitive instructions in the
                 * body of the IF.
                 */
                // TODO - fill in case
                Statement s1 = s.newInstance();
                Condition condition = s.disassembleIf(s1);
                count = countOfPrimitiveCalls(s1);
                s.assembleIf(condition, s1);

                break;
            }
            case IF_ELSE: {
                /*
                 * Add up the number of calls to primitive instructions in the
                 * "then" and "else" bodies of the IF_ELSE.
                 */
                // TODO - fill in case

                Statement s1 = s.newInstance();
                Statement s2 = s.newInstance();

                Condition condition = s.disassembleIfElse(s1, s2);
                count = count + countOfPrimitiveCalls(s1);
                count = count + countOfPrimitiveCalls(s2);
                s.assembleIfElse(condition, s1, s2);
                break;
            }
            case WHILE: {
                /*
                 * Find the number of calls to primitive instructions in the
                 * body of the WHILE.
                 */

                // TODO - fill in case
                Statement s1 = s.newInstance();
                Condition condition = s.disassembleWhile(s1);
                count = countOfPrimitiveCalls(s1);
                s.assembleWhile(condition, s1);
                break;
            }
            case CALL: {
                /*
                 * This is a leaf: the count can only be 1 or 0. Determine
                 * whether this is a call to a primitive instruction or not.
                 */
                String call = s.disassembleCall();
                String primitive = "moveturnleftturnrightinfectskip";
                if (primitive.contains(call)) {
                    count = 1;
                }
                s.assembleCall(call);

                break;
            }
            default: {
                // this will never happen...can you explain why?
                break;
            }
        }
        return count;
    }

}
