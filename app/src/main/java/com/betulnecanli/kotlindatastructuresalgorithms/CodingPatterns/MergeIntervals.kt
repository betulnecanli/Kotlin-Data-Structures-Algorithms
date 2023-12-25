/*
 The "Merge Intervals" pattern is often used for problems involving intervals, time scheduling, 
 or conflicting schedules. Let's tackle two problems: "Conflicting Appointments" and "Minimum Meeting Rooms."

 Usage: This technique is used to deal with overlapping intervals.
*/

//1. Conflicting Appointments
data class Interval(val start: Int, val end: Int)

fun canAttendAppointments(intervals: List<Interval>): Boolean {
    if (intervals.isEmpty()) {
        return true
    }

    intervals.sortedBy { it.start }

    for (i in 1 until intervals.size) {
        if (intervals[i].start < intervals[i - 1].end) {
            return false // Conflicting appointments
        }
    }

    return true
}

fun main() {
    val appointments = listOf(
        Interval(1, 4),
        Interval(2, 5),
        Interval(7, 9)
    )

    val result = canAttendAppointments(appointments)
    println("Can attend all appointments: $result")
}

//2. Minimum Meeting Rooms
data class Meeting(val start: Int, val end: Int)

fun minMeetingRooms(meetings: List<Meeting>): Int {
    if (meetings.isEmpty()) {
        return 0
    }

    val startTimes = meetings.map { it.start }.sorted()
    val endTimes = meetings.map { it.end }.sorted()

    var roomsNeeded = 0
    var endIndex = 0

    for (startTime in startTimes) {
        if (startTime < endTimes[endIndex]) {
            roomsNeeded++
        } else {
            endIndex++
        }
    }

    return roomsNeeded
}

fun main() {
    val meetings = listOf(
        Meeting(0, 30),
        Meeting(5, 10),
        Meeting(15, 20)
    )

    val result = minMeetingRooms(meetings)
    println("Minimum Meeting Rooms Required: $result")
}

/*
Conflicting Appointments:
We use a data class Interval to represent the start and end times of intervals.
The canAttendAppointments function checks if there are any conflicting appointments 
in the given list of intervals. We sort the intervals based on their start times and then iterate through them to check
for conflicts.
Minimum Meeting Rooms:
We use a data class Meeting to represent the start and end times of meetings.
The minMeetingRooms function calculates the minimum number of meeting rooms required to schedule all the given meetings. 
We sort the start and end times separately and use two pointers to track the ongoing meetings.
*/
