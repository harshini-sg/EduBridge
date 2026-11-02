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

    /*
     * PREDICTED OUTPUT:
     *   Vehicle brand: Tata Motors
     *   Car brand: Nexon
     *   this.brand = Nexon, super.brand = Tata Motors
     *
     * CHALLENGE
     * brand       -> the field declared in Car (the child's own copy; it hides the parent's).
     * super.brand -> the field inherited from Vehicle, accessed explicitly.
     * Both exist in the object at the same time and hold different values.
     */
}
