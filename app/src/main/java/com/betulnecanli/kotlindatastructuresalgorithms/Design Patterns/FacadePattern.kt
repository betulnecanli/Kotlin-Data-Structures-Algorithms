// Subsystem components
class CPU {
    fun processData() {
        println("Processing data...")
    }
}

class Memory {
    fun load() {
        println("Loading data into memory...")
    }
}

class HardDrive {
    fun readData() {
        println("Reading data from the hard drive...")
    }
}

// Facade class
class ComputerFacade(private val cpu: CPU, private val memory: Memory, private val hardDrive: HardDrive) {
    fun start() {
        cpu.processData()
        memory.load()
        hardDrive.readData()
        println("Computer started successfully.")
    }
}

fun main() {
    // Client code can use the simplified interface provided by the ComputerFacade
    val computerFacade = ComputerFacade(CPU(), Memory(), HardDrive())
    computerFacade.start()
}
