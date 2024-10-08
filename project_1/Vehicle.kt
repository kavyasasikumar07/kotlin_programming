// Sealed class hierarchy for vehicles
sealed class Vehicle {
    // Abstract property for the number of wheels
    abstract val wheels: Int

    // Data class for Car
    data class Car(
        val make: String,
        val model: String,
        val seatingCapacity: Int
    ) : Vehicle() {
        override val wheels = 4
    }

    // Data class for Bike
    data class Bike(
        val make: String,
        val model: String,
        val isElectric: Boolean
    ) : Vehicle() {
        override val wheels = 2
    }

    // Data class for Truck
    data class Truck(
        val make: String,
        val model: String,
        val loadCapacity: Int // Load capacity in tons
    ) : Vehicle() {
        override val wheels = 6
    }
}

// Function to print details of each vehicle
fun printVehicleDetails(vehicle: Vehicle) {
    when (vehicle) {
        is Vehicle.Car -> {
            println("Vehicle Type: Car")
            println("Make: ${vehicle.make}")
            println("Model: ${vehicle.model}")
            println("Seating Capacity: ${vehicle.seatingCapacity}")
            println("Number of Wheels: ${vehicle.wheels}")
        }
        is Vehicle.Bike -> {
            println("Vehicle Type: Bike")
            println("Make: ${vehicle.make}")
            println("Model: ${vehicle.model}")
            println("Is Electric: ${vehicle.isElectric}")
            println("Number of Wheels: ${vehicle.wheels}")
        }
        is Vehicle.Truck -> {
            println("Vehicle Type: Truck")
            println("Make: ${vehicle.make}")
            println("Model: ${vehicle.model}")
            println("Load Capacity: ${vehicle.loadCapacity} tons")
            println("Number of Wheels: ${vehicle.wheels}")
        }
    }
}

// Main function to test the sealed class hierarchy
fun main() {
    val car = Vehicle.Car("Toyota", "Camry", 5)
    val bike = Vehicle.Bike("Yamaha", "YZF-R3", false)
    val truck = Vehicle.Truck("Ford", "F-150", 3)

    // Print details of each vehicle
    printVehicleDetails(car)
    printVehicleDetails(bike)
    printVehicleDetails(truck)
}
