package StructuralPattern;

import java.util.HashMap;
import java.util.Map;

// Flyweight
interface Image {
    void showImage();
}

// ConcreteFlyweight
class FlightImage implements Image {
    private String imageType;

    @Override
    public void showImage() {
        System.out.println("showing " + imageType + " image");
    }

    public FlightImage(String imageType) {
        this.imageType = imageType;
    }

}

// ConcreteFlyweight
class TankImage implements Image {
    private String imageType;

    @Override
    public void showImage() {
        System.out.println("showing " + imageType + " image");
    }

    public TankImage(String imageType) {
        this.imageType = imageType;
    }

}

// Flyweight Factory
class ImageFactory {
    private Map<String, Image> ImageMap;

    public ImageFactory() {
        ImageMap =  new HashMap<>();
    }

    public Image getImage(String imageType){
        if(ImageMap.containsKey(imageType)){
            return ImageMap.get(imageType);
        }
        else {
            Image image;
            if(imageType.contains("flight")){
                image = new FlightImage(imageType);
            }
            else {
                image = new TankImage(imageType);
            }
            ImageMap.put(imageType, image);
            return image;
        }
    }
}


public class FlyweightPattern {
    public static void main(String[] args) {
        System.out.println("Flyweight Pattern!");

        ImageFactory imageFactory = new ImageFactory();
        Image flightImage = imageFactory.getImage("flight");
        flightImage.showImage();

        Image tank = imageFactory.getImage("tank");
        tank.showImage();

        Image image = imageFactory.getImage("flight");
        image.showImage();

        image = imageFactory.getImage("tank");
        image.showImage();
    }
}
