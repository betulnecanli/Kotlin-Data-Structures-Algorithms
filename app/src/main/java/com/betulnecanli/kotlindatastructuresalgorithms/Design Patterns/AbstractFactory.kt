// Abstract Factory interface
interface GUIFactory {
    fun createButton(): Button
    fun createCheckbox(): Checkbox
}

// Concrete product interfaces
interface Button {
    fun paint()
}

interface Checkbox {
    fun paint()
}

// Concrete factory for Windows
class WindowsFactory : GUIFactory {
    override fun createButton(): Button {
        return WindowsButton()
    }

    override fun createCheckbox(): Checkbox {
        return WindowsCheckbox()
    }
}

// Concrete factory for MacOS
class MacOSFactory : GUIFactory {
    override fun createButton(): Button {
        return MacOSButton()
    }

    override fun createCheckbox(): Checkbox {
        return MacOSCheckbox()
    }
}

// Concrete product for Windows
class WindowsButton : Button {
    override fun paint() {
        println("Rendering Windows button")
    }
}

class WindowsCheckbox : Checkbox {
    override fun paint() {
        println("Rendering Windows checkbox")
    }
}

// Concrete product for MacOS
class MacOSButton : Button {
    override fun paint() {
        println("Rendering MacOS button")
    }
}

class MacOSCheckbox : Checkbox {
    override fun paint() {
        println("Rendering MacOS checkbox")
    }
}

// Client code
class Application(private val factory: GUIFactory) {
    private val button: Button = factory.createButton()
    private val checkbox: Checkbox = factory.createCheckbox()

    fun paint() {
        button.paint()
        checkbox.paint()
    }
}

fun main() {
    val windowsApp = Application(WindowsFactory())
    windowsApp.paint()

    val macOsApp = Application(MacOSFactory())
    macOsApp.paint()
}
