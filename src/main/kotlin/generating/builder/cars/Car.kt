package generating.builder.cars

import generating.builder.components.Engine
import generating.builder.components.GPSNavigator
import generating.builder.components.Transmission
import generating.builder.components.TripComputer

/**
 * Автомобиль — это класс продукта.
 */
class Car() {

    private var carType: CarType? = null
    private var seats = 0
    private var engine: Engine? = null
    private var transmission: Transmission? = null
    private var tripComputer: TripComputer? = null
    private var gpsNavigator: GPSNavigator? = null
    private var fuel = 0.0

    constructor(
        carType: CarType?, seats: Int, engine: Engine?, transmission: Transmission?,
        tripComputer: TripComputer?, gpsNavigator: GPSNavigator?
    ) : this() {
        this.carType = carType
        this.seats = seats
        this.engine = engine
        this.transmission = transmission
        this.tripComputer = tripComputer
        this.tripComputer?.setCar(this)
        this.gpsNavigator = gpsNavigator
    }

    fun getCarType(): CarType? {
        return carType
    }

    fun getFuel(): Double {
        return fuel
    }

    fun setFuel(fuel: Double) {
        this.fuel = fuel
    }

    fun getSeats(): Int {
        return seats
    }

    fun getEngine(): Engine? {
        return engine
    }

    fun getTransmission(): Transmission? {
        return transmission
    }

    fun getTripComputer(): TripComputer? {
        return tripComputer
    }

    fun getGpsNavigator(): GPSNavigator? {
        return gpsNavigator
    }

}