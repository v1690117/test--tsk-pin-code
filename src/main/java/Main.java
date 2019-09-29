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
        Set<String> possibleCodes = getPossibleCodes(inputValue);
        System.out.print(String.join(",", possibleCodes));
        scanner.close();
    }

    static Set<String> getPossibleCodes(String inputValue) throws Exception {
        if (inputValue == null || inputValue.length() == 0)
            return new TreeSet<>();

        List<Node> nodes = new LinkedList<>();
        for (int i = 0; i < inputValue.length(); i++) {
            char c = inputValue.charAt(i);

            char[] variants = NEIGHBOURS[Integer.parseInt(String.valueOf(c))];
            if (nodes.size() == 0) {
                for (char variant : variants) {
                    Node node = new Node(variant, null);
                    nodes.add(node);
                }
            } else {
                List<Node> newNodes = new LinkedList<>();
                for (Node node : nodes) {
                    for (char variant : variants) {
                        Node newNode = new Node(variant, node);
                        newNodes.add(newNode);
                    }
                }
                nodes = newNodes;
            }
        }
        Set<String> possibleValues = new TreeSet<>();
        nodes.forEach(node -> possibleValues.add(node.getPath()));
        return possibleValues;
    }
}
