package generating.builder.builders

import generating.builder.cars.CarType
import generating.builder.components.Engine
import generating.builder.components.GPSNavigator
import generating.builder.components.Transmission
import generating.builder.components.TripComputer

/**
 * Интерфейс Строителя объявляет все возможные этапы и шаги конфигурации продукта.
 */
interface Builder {
    fun setCarType(type: CarType?)
    fun setSeats(seats: Int)
    fun setEngine(engine: Engine?)
    fun setTransmission(transmission: Transmission?)
    fun setTripComputer(tripComputer: TripComputer?)
    fun setGPSNavigator(gpsNavigator: GPSNavigator?)
}