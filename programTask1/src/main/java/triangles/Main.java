package triangles;

public class Main {
    // Main class
    public static void main(String[] args) {

        // Task 1.1
        int amount = 5;
        String symbolsRow = ControllerAndView.getSymbolsRow(amount);
        ControllerAndView.display(symbolsRow);

        String spacesRow = ControllerAndView.getSpacesRow(amount);
        ControllerAndView.display(spacesRow);

        System.out.println();  // makes space


        // Task 1.2
        int size = 3, shift = 5; String symbol = ".";     // values for Model initializing
        Model template = new Model(size, shift, symbol);  // template for testing all features

        ControllerAndView.buildFirstTriangle(template);   // builds shape
        ControllerAndView.display(template);              // displays shape
        template.clear();      // clears template
        System.out.println();  // makes space

        ControllerAndView.buildSecondTriangle(template);
        ControllerAndView.display(template);
        template.clear();
        System.out.println();  // makes space

        ControllerAndView.buildThirdTriangle(template);
        ControllerAndView.display(template);
        template.clear();
        System.out.println();  // makes space

        ControllerAndView.buildFourthTriangle(template);
        ControllerAndView.display(template);
        template.clear();
        System.out.println();  // makes space

        ControllerAndView.buildRectangle(template);
        ControllerAndView.display(template);
        template.clear();
        System.out.println();  // makes space


        // Task 1.3
        // Vertical shape combiner - one code for all possible cases
        Model shape1 = new Model(), shape2 = new Model(), shape3 = new Model();  // shapes for testing Shape Combiners
        ControllerAndView.buildFirstTriangle(shape1);
        ControllerAndView.buildRectangle(shape2);
        ControllerAndView.buildSecondTriangle(shape3);
        Model combinedShape = ControllerAndView.verticalShapeCombiner(  // combines shapes in the method
                shape1,
                shape2,
                shape3
        );
        ControllerAndView.display(combinedShape);
        System.out.println();  // makes space

        // Triangles
        ControllerAndView.buildFirstShape(template);
        ControllerAndView.display(template);
        template.clear();
        System.out.println();  // makes space

        ControllerAndView.buildSecondShape(template);
        ControllerAndView.display(template);
        template.clear();
        System.out.println();  // makes space

        ControllerAndView.buildThirdShape(template);
        ControllerAndView.display(template);
        template.clear();
        System.out.println();  // makes space

        ControllerAndView.buildFourthShape(template);
        ControllerAndView.display(template);
        template.clear();
        System.out.println();  // makes space

        // Trapezium
        ControllerAndView.buildFifthShape(template);
        ControllerAndView.display(template);
        template.clear();
        System.out.println();  // makes space

        ControllerAndView.buildSixthShape(template);
        ControllerAndView.display(template);
        template.clear();
        System.out.println();  // makes space

        ControllerAndView.buildSeventhShape(template);
        ControllerAndView.display(template);
        template.clear();
        System.out.println();  // makes space

        ControllerAndView.buildEighthShape(template);
        ControllerAndView.display(template);
        template.clear();
        System.out.println();  // makes space


        // Task 1.4
        // Horizontal shape combiner - one code for all possible cases
        shape1.clear(); shape2.clear(); shape3.clear(); combinedShape.clear();  // clears all shapes
        ControllerAndView.buildFirstTriangle(shape1);
        ControllerAndView.buildRectangle(shape2);
        ControllerAndView.buildFourthTriangle(shape3);
        combinedShape = ControllerAndView.horizontalShapeCombiner(
                shape3,
                shape2,
                shape1
        );
        ControllerAndView.display(combinedShape);
        System.out.println();  // makes space

        ControllerAndView.buildHorizontalTriangle(template);
        ControllerAndView.display(template);
        template.clear();
        System.out.println();  // makes space

        ControllerAndView.buildHorizontalTrapeze(template);
        ControllerAndView.display(template);
        template.clear();
        System.out.println();  // makes space


        // Task 1.5
        Model christmasTree = new Model(6, 5, ".");
        ControllerAndView.buildChristmasTree(christmasTree);
        ControllerAndView.display(christmasTree);
        System.out.println();  // makes space

        Model rocket = new Model(4, 5, ".");
        ControllerAndView.buildRocket(rocket);
        ControllerAndView.display(rocket);
    }
}
