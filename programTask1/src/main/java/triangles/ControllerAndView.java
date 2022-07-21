package triangles;

public class ControllerAndView {
    // Combined Controller and Viewer class

    // Task 1.1
    static String getSymbolsRow(int amount, String symbol) {
        // Gets row of symbols
        return symbol.repeat(amount);
    }

    static String getSymbolsRow(int amount) {
        // Gets row of symbols with '.' set as default
        return getSymbolsRow(amount, ".");
    }

    static String getSpacesRow(int amount) {
        // Gets row of spaces
        return " ".repeat(amount);
    }

    static void display(Model model) {
        // Displays Model object
        System.out.println(model.getBody().stripTrailing());
    }

    static void display(String string) {
        // Displays String object
        System.out.println(string);
    }


    // Task 1.2
    static void buildFirstTriangle(Model model) {
        // Builds first triangle
        for (int i = 0; i < model.getSize(); i++) {
            String row = ControllerAndView.getSymbolsRow(i + 1, model.getSymbol());
            String shift = getSpacesRow(model.getShift());
            model.addRow(shift + row);
        }
    }

    static void buildSecondTriangle(Model model) {
        // Builds second triangle
        for (int i = 0; i < model.getSize(); i++) {
            String row = ControllerAndView.getSymbolsRow(model.getSize() - i, model.getSymbol());
            String shift = getSpacesRow(model.getShift());
            model.addRow(shift + row);
        }
    }

    static void buildThirdTriangle(Model model) {
        // Builds third triangle
        for (int i = 0; i < model.getSize(); i++) {
            String spacesRow = ControllerAndView.getSpacesRow(i);
            String symbolsRow = ControllerAndView.getSymbolsRow(model.getSize() - i, model.getSymbol());
            String shift = getSpacesRow(model.getShift());
            model.addRow(shift + spacesRow + symbolsRow);
        }
    }

    static void buildFourthTriangle(Model model) {
        // Builds fourth triangle
        for (int i = 0; i < model.getSize(); i++) {
            String spacesRow = ControllerAndView.getSpacesRow(model.getSize() - 1 - i);
            String symbolsRow = ControllerAndView.getSymbolsRow(i + 1, model.getSymbol());
            String shift = getSpacesRow(model.getShift());
            model.addRow(shift + spacesRow + symbolsRow);
        }
    }

    static void buildRectangle(Model model) {
        // Builds rectangle
        for (int i = 0; i < model.getSize(); i++) {
            String shift = getSpacesRow(model.getShift());
            String symbolsRow = ControllerAndView.getSymbolsRow(model.getSize(), model.getSymbol());
            model.addRow(shift + symbolsRow);
        }
    }


    // Task 1.3
    static Model verticalShapeCombiner(Model... shapes) {
        // Combines any shapes vertically
        Model model = new Model();
        for (Model shape : shapes) {
            model.addRow(shape.getBody().stripTrailing());
        }
        return model;
    }

    // Triangles
    static void buildFirstShape(Model model) {
        buildFirstTriangle(model);
        buildSecondTriangle(model);
    }

    static void buildSecondShape(Model model) {
        buildFirstTriangle(model);
        buildThirdTriangle(model);
    }

    static void buildThirdShape(Model model) {
        buildFourthTriangle(model);
        buildThirdTriangle(model);
    }

    static void buildFourthShape(Model model) {
        buildFourthTriangle(model);
        buildSecondTriangle(model);
    }

    // Trapezium
    static void buildFifthShape(Model model) {
        buildFirstTriangle(model);
        buildRectangle(model);
        buildSecondTriangle(model);
    }

    static void buildSixthShape(Model model) {
        buildFirstTriangle(model);
        buildRectangle(model);
        buildThirdTriangle(model);
    }

    static void buildSeventhShape(Model model) {
        buildFourthTriangle(model);
        buildRectangle(model);
        buildThirdTriangle(model);
    }

    static void buildEighthShape(Model model) {
        buildFourthTriangle(model);
        buildRectangle(model);
        buildSecondTriangle(model);
    }


    // Task 1.4
    static Model horizontalShapeCombiner(Model... shapes) {
        // Combines any shapes horizontally
        Model model = new Model();
        for (Model shape : shapes) {
            model.extendWith(shape.getBody());
        }
        return model;
    }

    static void buildHorizontalTriangle(Model model) {
        buildFourthTriangle(model);
        Model shape = new Model(model.getSize(), 0, model.getSymbol());
        buildFirstTriangle(shape);
        model.extendWith(shape.getBody());
    }

    static void buildHorizontalTrapeze(Model model) {
        buildFourthTriangle(model);
        Model shape = new Model(model.getSize(), 0, model.getSymbol());
        buildRectangle(shape);
        model.extendWith(shape.getBody()); shape.clear();
        buildFirstTriangle(shape);
        model.extendWith(shape.getBody());
    }


    // Task 1.5
    static void buildChristmasTree(Model model, int branchesNumber) {
        // Builds Christmas tree
        for (int i = branchesNumber - 1; i > -1; i--) {
            Model shape = new Model(
                    model.getSize() - i,
                    model.getShift() + i,
                    model.getSymbol()
            );
            buildHorizontalTriangle(shape);
            model.addRow(shape.getBody());
        }
        Model stem = new Model(
                model.getSize() - 2,
                model.getShift() + model.getSize() / 2 + 1,
                model.getSymbol()
        );
        buildRectangle(stem);
        model.addRow(stem.getBody());
    }

    static void buildChristmasTree(Model model) {
        // Builds default Christmas tree
        buildChristmasTree(model, 3);
    }

    static void buildRocket(Model model, int cellNumber) {
        // Builds rocket
        Model shape = new Model(
                model.getSize(),
                model.getShift() + model.getSize() * 2 - 3,
                model.getSymbol()
        );
        buildHorizontalTriangle(shape); model.addRow(shape.getBody()); shape.clear();

        for (int i = 0; i < cellNumber; i++) {
            shape = new Model(
                    model.getSize() * 2,
                    model.getShift() + model.getSize() * 2 - 3,
                    model.getSymbol()
            );
            buildRectangle(shape); model.addRow(shape.getBody().stripTrailing()); shape.clear();

            shape = new Model(
                    model.getSize() * 2 - 2,
                    model.getShift(),
                    model.getSymbol()
            );
            buildHorizontalTrapeze(shape); model.addRow(shape.getBody().stripTrailing()); shape.clear();
        }
    }

    static void buildRocket(Model model) {
        // Builds default rocket
        buildRocket(model, 2);
    }
}