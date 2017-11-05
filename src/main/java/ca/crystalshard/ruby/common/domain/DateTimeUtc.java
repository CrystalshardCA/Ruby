package ca.crystalshard.ruby.common.domain;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.ISODateTimeFormat;

public class DateTimeUtc implements ca.crystalshard.ruby.common.domain.DateTime {

    private DateTime dateTime;

    public DateTimeUtc(DateTime dateTime) {
        this.dateTime = dateTime.withZone(DateTimeZone.UTC);
    }

    @Override
    public int getDayOfWeek() {
        return dateTime.getDayOfWeek();
    }

    @Override
    public int getDayOfMonth() {
        return dateTime.getDayOfMonth();
    }

    @Override
    public int getDayOfYear() {
        return dateTime.getDayOfYear();
    }

    @Override
    public int getWeekOfWeekyear() {
        return dateTime.getWeekOfWeekyear();
    }

    @Override
    public int getWeekyear() {
        return dateTime.getWeekyear();
    }

    @Override
    public int getMonthOfYear() {
        return dateTime.getMonthOfYear();
    }

    @Override
    public int getYear() {
        return dateTime.getYear();
    }

    @Override
    public int getYearOfEra() {
        return dateTime.getYearOfEra();
    }

    @Override
    public int getYearOfCentury() {
        return dateTime.getYearOfCentury();
    }

    @Override
    public int getCenturyOfEra() {
        return dateTime.getCenturyOfEra();
    }

    @Override
    public int getEra() {
        return dateTime.getEra();
    }

    @Override
    public int getMillisOfSecond() {
        return dateTime.getMillisOfSecond();
    }

    @Override
    public int getMillisOfDay() {
        return dateTime.getMillisOfDay();
    }

    @Override
    public int getSecondOfMinute() {
        return dateTime.getSecondOfMinute();
    }

    @Override
    public int getSecondOfDay() {
        return dateTime.getSecondOfDay();
    }

    @Override
    public int getMinuteOfHour() {
        return dateTime.getMinuteOfHour();
    }

    @Override
    public int getMinuteOfDay() {
        return dateTime.getMinuteOfDay();
    }

    @Override
    public int getHourOfDay() {
        return dateTime.getHourOfDay();
    }

    @Override
    public String toString() {
        return ISODateTimeFormat.dateTime().print(dateTime);
    }

    @Override
    public long getMillis() {
        return dateTime.getMillis();
    }

    @Override
    public boolean isEqual(DateTimeUtc dateTimeUtc) {
        return dateTime.isEqual(dateTimeUtc.dateTime);
    }

    @Override
    public boolean isAfter(DateTimeUtc dateTimeUtc) {
        return dateTime.isAfter(dateTimeUtc.dateTime);
    }

    @Override
    public boolean isBefore(DateTimeUtc dateTimeUtc) {
        return dateTime.isBefore(dateTimeUtc.dateTime);
    }

    @Override
    public int compareTo(DateTimeUtc dateTimeUtc) {
        return dateTime.compareTo(dateTimeUtc.dateTime);
    }
}
