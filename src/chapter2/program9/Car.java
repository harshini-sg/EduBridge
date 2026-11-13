package chapter2.program9;

public class Car extends Vehicle {
    String brand;   // hides Vehicle.brand (field hiding)

    Car(String vehicleBrand, String carBrand) {
        super(vehicleBrand);       // initializes Vehicle.brand
        this.brand = carBrand;     // initializes Car.brand
    }

    @Override
    void display() {
        super.display();           // prints the parent's information
        System.out.println("Car brand: " + brand);
        System.out.println("this.brand = " + this.brand + ", super.brand = " + super.brand);
    }

    public static void main(String[] args) {
        Car car = new Car("Tata Motors", "Nexon");
        car.display();
    }
}
