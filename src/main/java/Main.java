import java.util.*;

public class Main {
    static private final char[][] NEIGHBOURS = new char[][]{
            new char[]{'0', '8'},
            new char[]{'1', '2', '4'},
            new char[]{'2', '1', '3', '5'},
            new char[]{'3', '2', '6'},
            new char[]{'4', '1', '5', '7'},
            new char[]{'5', '2', '4', '6', '8'},
            new char[]{'6', '3', '5', '9'},
            new char[]{'7', '4', '8'},
            new char[]{'8', '5', '7', '9', '0'},
            new char[]{'9', '6', '8'}
    };

    static class Node {
        char value;
        Node parent;

        Node(char value, Node parent) {
            this.value = value;
            this.parent = parent;
        }

        String getPath() {
            return (parent == null ? "" : parent.getPath()) + value;
        }

        @Override
        public String toString() {
            return getPath();
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.next();
        List<String> possibleCodes = getPossibleCodes(inputValue);
        System.out.print(String.join(",", possibleCodes));
        scanner.close();
    }

    static List<String> getPossibleCodes(String inputValue) throws Exception {
        if (inputValue == null || inputValue.length() == 0)
            return new LinkedList<>();

        Set<Node> set = new TreeSet<>(getNodeComparator());
        for (int i = 0; i < inputValue.length(); i++) {
            char c = inputValue.charAt(i);

            char[] variants = NEIGHBOURS[Integer.parseInt(String.valueOf(c))];
            if (set.size() == 0) {
                for (char variant : variants) {
                    Node node = new Node(variant, null);
                    set.add(node);
                }
            } else {
                Set<Node> newSet = new TreeSet<>(getNodeComparator());
                for (Node node : set) {
                    for (char variant : variants) {
                        Node newNode = new Node(variant, node);
                        newSet.add(newNode);
                    }
                }
                set = newSet;
            }
        }
        List<String> possibleCodes = new LinkedList<>();
        set.forEach(node -> possibleCodes.add(node.getPath()));
        return possibleCodes;
    }

    private static Comparator<Node> getNodeComparator() {
        return (o1, o2) -> o1.getPath().compareTo(o2.getPath());
    }

}
