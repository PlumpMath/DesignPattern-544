package StructuralPattern;

interface DrawAPI
{
    void draw();
}

class DrawRedAPI implements DrawAPI
{
    @Override
    public void draw() {
        System.out.println("Draw Red!");
    }
}

class DrawGreenAPI implements DrawAPI
{
    @Override
    public void draw() {
        System.out.println("Draw Green!");
    }
}

interface Shape
{
    void drawShape();
}

class Square implements Shape{

    private DrawAPI drawAPI;

    public Square(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    @Override
    public void drawShape() {
        drawAPI.draw();
    }
}

class Circle implements Shape{

    private DrawAPI drawAPI;

    public Circle(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    @Override
    public void drawShape() {
        drawAPI.draw();
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        System.out.println("Bridge Pattern!");

        DrawAPI drawRedAPI = new DrawRedAPI();
        DrawAPI drawGreenAPI = new DrawGreenAPI();

        Shape squre = new Square(drawRedAPI);
        System.out.println(squre.getClass().getName());
        squre.drawShape();
        squre = new Square(drawGreenAPI);
        squre.drawShape();

        Shape circle = new Circle(drawGreenAPI);
        System.out.println(circle.getClass().getName());
        circle.drawShape();
        circle = new Circle(drawRedAPI);
        circle.drawShape();
    }
}
