package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate)

operator fun MyDate.compareTo(other: MyDate): Int = compareValuesBy(this, other, { it.year }, { it.month }, { it.dayOfMonth })

operator fun DateRange.contains(d: MyDate): Boolean {
    return this.start <= d && d <= this.endInclusive
}

operator fun MyDate.rangeTo(other: MyDate): DateRange {
    return DateRange(this, other)
}

operator fun DateRange.iterator(): Iterator<MyDate> {
    var cursor = this.start

    return object : Iterator<MyDate> {
        override fun hasNext(): Boolean {
            return cursor <= endInclusive
        }

        override fun next(): MyDate {
            val next = cursor
            cursor = cursor.nextDay()
            return next
        }
    }
}

operator fun MyDate.plus(ti: TimeInterval): MyDate = addTimeIntervals(ti, 1)

class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int)

operator fun TimeInterval.times(n: Int): RepeatedTimeInterval = RepeatedTimeInterval(this, n)

operator fun MyDate.plus(rti: RepeatedTimeInterval): MyDate = addTimeIntervals(rti.timeInterval, rti.number)
