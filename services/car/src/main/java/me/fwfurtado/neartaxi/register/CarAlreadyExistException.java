package me.fwfurtado.neartaxi.register;

class CarAlreadyExistException extends IllegalArgumentException {

    CarAlreadyExistException(String licensePlate) {
        super("Already exist a car with license plate " + licensePlate);
    }
}
