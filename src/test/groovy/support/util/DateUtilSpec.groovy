package support.util

import org.joda.time.LocalDate
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class DateUtilSpec extends Specification {

    void 'get number of days - date1: #date1, date2: #date2, expected: 45 days'() {
        when:
            Integer days = DateUtil.getNumberOfDays(date1, date2)

        then:
            days == 45

        where:
            dateStr << [
                    '2019-02-11',
                    '2019-02-12',
                    '2019-02-13',
                    '2019-02-14',
                    '2019-02-15',
                    '2019-02-16',
                    '2019-02-17',
                    '2019-02-18'
            ]

            date1 = LocalDate.parse(dateStr)
            date2 = date1.plusDays(45)
    }

    void 'get issue info - DateTimeZone'() {
        when:
            String dateTimeZone = DateUtil.getIssueInfoDateTimeZone()

        then:
            dateTimeZone == 'DateTimeZone.getDefault()=Europe/Copenhagen'
    }

    void 'get issue info - TimeZone'() {
        when:
            String dateTimeZone = DateUtil.getIssueInfoTimeZone()

        then:
            dateTimeZone == 'TimeZone.getDefault()=sun.util.calendar.ZoneInfo[id="Europe/Copenhagen",offset=3600000,dstSavings=3600000,useDaylight=true,transitions=133,lastRule=java.util.SimpleTimeZone[id=Europe/Copenhagen,offset=3600000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=2,startMonth=2,startDay=-1,startDayOfWeek=1,startTime=3600000,startTimeMode=2,endMode=2,endMonth=9,endDay=-1,endDayOfWeek=1,endTime=3600000,endTimeMode=2]]'
    }

}