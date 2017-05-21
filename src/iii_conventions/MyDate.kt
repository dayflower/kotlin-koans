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