package ca.crystalshard.ruby.common.domain;

public interface DateTime {
    int getDayOfWeek();

    int getDayOfMonth();

    int getDayOfYear();

    int getWeekOfWeekyear();

    int getWeekyear();

    int getMonthOfYear();

    int getYear();

    int getYearOfEra();

    int getYearOfCentury();

    int getCenturyOfEra();

    int getEra();

    int getMillisOfSecond();

    int getMillisOfDay();

    int getSecondOfMinute();

    int getSecondOfDay();

    int getMinuteOfHour();

    int getMinuteOfDay();

    int getHourOfDay();

    long getMillis();

    boolean isEqual(DateTimeUtc dateTimeUtc);

    boolean isAfter(DateTimeUtc dateTimeUtc);

    boolean isBefore(DateTimeUtc dateTimeUtc);

    int compareTo(DateTimeUtc dateTimeUtc);
}
