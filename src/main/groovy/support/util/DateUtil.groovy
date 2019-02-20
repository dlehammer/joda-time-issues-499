package support.util

import groovy.transform.CompileStatic
import org.joda.time.DateTimeZone
import org.joda.time.Days
import org.joda.time.Interval
import org.joda.time.LocalDate

@CompileStatic
class DateUtil {

    @Deprecated
    static Integer getNumberOfDays(LocalDate date1, LocalDate date2) {
        Integer days = null
        if (date1 && date2) {
            Interval interval
            if (date1.isBefore(date2)) {
                interval = new Interval(date1.toDate().time, date2.toDate().time)
            } else {
                interval = new Interval(date2.toDate().time, date1.toDate().time)
            }
            days = interval.toDuration().toStandardDays().days
        }

        return days
    }

    static Integer getLogicalNumberOfDays(LocalDate date1, LocalDate date2) {
        return Days.daysBetween(date1, date2).getDays()
    }

    /**
     * @return info required when creating a joda-time issue
     * @see https://github.com/JodaOrg/joda-time/issues/new
     */
    static String getIssueInfoDateTimeZone() {
        return "DateTimeZone.getDefault()=${DateTimeZone.getDefault()}"
    }

    /**
     * @return info required when creating a joda-time issue
     * @see https://github.com/JodaOrg/joda-time/issues/new
     */
    static String getIssueInfoTimeZone() {
        return "TimeZone.getDefault()=${TimeZone.getDefault()}"
    }

}
