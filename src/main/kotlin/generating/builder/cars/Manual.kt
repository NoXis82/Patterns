package generating.builder.cars

import generating.builder.components.Engine
import generating.builder.components.GPSNavigator
import generating.builder.components.Transmission
import generating.builder.components.TripComputer

/**
 * Руководство автомобиля — это второй продукт. Заметьте, что руководство и сам
 * автомобиль не имеют общего родительского класса. По сути, они независимы.
 */
class Manual() {

    private var carType: CarType? = null
    private var seats = 0
    private var engine: Engine? = null
    private var transmission: Transmission? = null
    private var tripComputer: TripComputer? = null
    private var gpsNavigator: GPSNavigator? = null

    constructor(
        carType: CarType?, seats: Int, engine: Engine?, transmission: Transmission?,
        tripComputer: TripComputer?, gpsNavigator: GPSNavigator?
    ) : this() {
        this.carType = carType
        this.seats = seats
        this.engine = engine
        this.transmission = transmission
        this.tripComputer = tripComputer
        this.gpsNavigator = gpsNavigator
    }

    fun print(): String {
        val info = buildString {
            append("Type of car: $carType\n")
            append("Count of seats: $seats\n")
            append("Engine: volume - ${engine?.getVolume()}; mileage - ${engine?.getMileage()}\n")
            append("Transmission: $transmission\n")
            if (tripComputer != null) {
                append("Trip Computer: Functional\n")
            } else {
                append("Trip Computer: N/A\n")
            }
            if (gpsNavigator != null) {
                append("GPS Navigator: Functional\n")
            } else {
                append("GPS Navigator: N/A\n")
            }
        }
        return info
    }

}