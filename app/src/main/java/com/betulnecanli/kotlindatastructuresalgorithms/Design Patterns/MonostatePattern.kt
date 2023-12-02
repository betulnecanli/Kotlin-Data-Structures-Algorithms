class SharedData {
    companion object {
        var commonData: String = "Default Data"
    }
}

class MonostateClient {
    var localData: String = SharedData.commonData

    fun updateCommonData(newData: String) {
        SharedData.commonData = newData
    }

    fun printData() {
        println("Local Data: $localData, Common Data: ${SharedData.commonData}")
    }
}

fun main() {
    val client1 = MonostateClient()
    val client2 = MonostateClient()

    // Both clients share the same data initially
    client1.printData()
    client2.printData()

    // Update common data through one client
    client1.updateCommonData("New Common Data")

    // Both clients reflect the change in common data
    client1.printData()
    client2.printData()
}
