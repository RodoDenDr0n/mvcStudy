package triangles;


public class Model {
    // Model class
    int size = 5;   // size of figure
    int shift;  // shift to right
    String symbol = ".";  // symbol built with
    String body = "";  // body

    Model(int size, int shift, String symbol) {
        // Editable constructor
        this.size = size;
        this.shift = shift;
        this.symbol = symbol;
    }

    Model(){}  // Default constructor

    void addRow(String row) {
        // Adds row
        body += row + "\n";
    }

    void extendWith(String otherBody) {
        // extends body with body of another model
        String[] dividedSelfBody = body.stripTrailing().split("\n");
        String[] dividedOtherBody = otherBody.stripTrailing().split("\n");

        // handles the case when other body's size is bigger
        if (dividedOtherBody.length > dividedSelfBody.length) {
            String[] extendedSelfBody = new String[dividedOtherBody.length];
            for (int i = 0; i < extendedSelfBody.length; i++) {
                extendedSelfBody[i] = i > dividedSelfBody.length - 1? "" : dividedSelfBody[i];
            }

            dividedSelfBody = extendedSelfBody;
        }

        for (int i = 0; i < dividedOtherBody.length; i++) {
            dividedSelfBody[i] += dividedOtherBody[i];
        }
        body = String.join("\n", dividedSelfBody);
    }

    String getBody() {
        // Gets body
        return body;
    }

    String getSymbol() {
        // Gets symbol built with
        return symbol;
    }

    int getSize() {
        // Gets size of shape
        return size;
    }

    int getShift() {
        // Gets shifts to right
        return shift;
    }

    void clear() {
        // Clears the shape
        body = "";
    }
}