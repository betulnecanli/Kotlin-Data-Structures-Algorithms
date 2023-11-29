// Command interface
interface Command {
    fun execute()
}

// Concrete command for turning on the light
class LightOnCommand(private val light: Light) : Command {
    override fun execute() {
        light.turnOn()
    }
}

// Concrete command for turning off the light
class LightOffCommand(private val light: Light) : Command {
    override fun execute() {
        light.turnOff()
    }
}

// Receiver class (the device being controlled)
class Light {
    fun turnOn() {
        println("Light is ON")
    }

    fun turnOff() {
        println("Light is OFF")
    }
}

// Invoker class (the remote control)
class RemoteControl {
    private var command: Command? = null

    fun setCommand(command: Command) {
        this.command = command
    }

    fun pressButton() {
        command?.execute()
    }
}

fun main() {
    // Client code
    val light = Light()

    val lightOnCommand = LightOnCommand(light)
    val lightOffCommand = LightOffCommand(light)

    val remoteControl = RemoteControl()

    // Programming the remote control with commands
    remoteControl.setCommand(lightOnCommand)

    // Pressing the button to execute the command
    remoteControl.pressButton()

    // Programming the remote control with a different command
    remoteControl.setCommand(lightOffCommand)

    // Pressing the button to execute the new command
    remoteControl.pressButton()
}
