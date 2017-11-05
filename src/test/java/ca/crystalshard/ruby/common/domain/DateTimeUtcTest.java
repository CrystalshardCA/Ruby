package ca.crystalshard.ruby.common.domain;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DateTimeUtcTest {

    private DateTimeUtc dateTimeUtc;

    @Before
    public void setUp() {
        DateTime dateTime = new DateTime(2017,10,27,15,19,15,15, DateTimeZone.UTC);
        dateTimeUtc = new DateTimeUtc(dateTime);
    }

    @Test
    public void getDayOfWeek_shouldReturnDayOfWeek() {

        int result = dateTimeUtc.getDayOfWeek();

        Assert.assertEquals(5, result);
    }

    @Test
    public void getDayOfMonth_shouldReturnDayOfMonth() {

        int result = dateTimeUtc.getDayOfMonth();

        Assert.assertEquals(27, result);
    }

    @Test
    public void getDayOfYear_shouldReturnDayOfYear() {

        int result = dateTimeUtc.getDayOfYear();

        Assert.assertEquals(300, result);
    }

    @Test
    public void getWeekOfWeekyear_shouldReturnWeekOfWeekyear() {

        int result = dateTimeUtc.getWeekOfWeekyear();

        Assert.assertEquals(43, result);
    }

    @Test
    public void getWeekyear_shouldReturnWeekyear() {

        int result = dateTimeUtc.getWeekyear();

        Assert.assertEquals(2017, result);
    }

    @Test
    public void getMonthOfYear_shouldReturnlMonthOfYear() {

        int result = dateTimeUtc.getMonthOfYear();

        Assert.assertEquals(10, result);
    }

    @Test
    public void getYear_shouldReturnYear() {

        int result = dateTimeUtc.getYear();

        Assert.assertEquals(2017, result);
    }

    @Test
    public void getYearOfEra_shouldReturnYear() {

        int result = dateTimeUtc.getYearOfEra();

        Assert.assertEquals(2017, result);
    }

    @Test
    public void getYearOfCentury_shouldReturnYear() {

        int result = dateTimeUtc.getYearOfCentury();

        Assert.assertEquals(17, result);
    }

    @Test
    public void getCenturyOfEra_shouldReturnCenturyOfEra() {

        int result = dateTimeUtc.getCenturyOfEra();

        Assert.assertEquals(20, result);
    }

    @Test
    public void getEra_shouldReturnEra() {

        int result = dateTimeUtc.getEra();

        Assert.assertEquals(1, result);
    }

    @Test
    public void getMillisOfSecond() {

        int result = dateTimeUtc.getMillisOfSecond();

        Assert.assertEquals(15, result);
    }

    @Test
    public void getMillisOfDay() {

        int result = dateTimeUtc.getMillisOfDay();

        Assert.assertEquals(55155015, result);
    }

    @Test
    public void getSecondOfMinute() {

        int result = dateTimeUtc.getSecondOfMinute();

        Assert.assertEquals(15, result);
    }

    @Test
    public void getSecondOfDay() {

        int result = dateTimeUtc.getSecondOfDay();

        Assert.assertEquals(55155, result);
    }

    @Test
    public void getMinuteOfHour() {

        int result = dateTimeUtc.getMinuteOfHour();

        Assert.assertEquals(19, result);
    }

    @Test
    public void getMinuteOfDay() {

        int result = dateTimeUtc.getMinuteOfDay();

        Assert.assertEquals(919, result);
    }

    @Test
    public void getHourOfDay() {

        int result = dateTimeUtc.getHourOfDay();

        Assert.assertEquals(15, result);
    }

    @Test
    public void toString_shouldReturnISO8601() {

        String result = dateTimeUtc.toString();

        Assert.assertEquals("2017-10-27T15:19:15.015Z", result);
    }

    @Test
    public void getMillis() {

        long result = dateTimeUtc.getMillis();

        Assert.assertEquals(1509117555015L, result);
    }

    @Test
    public void isEqual_shouldReturnTrue_whenEqual() {
        DateTimeUtc dateTimeUtc1 = new DateTimeUtc(new DateTime(2017,10,27,15,19,15,15, DateTimeZone.UTC));
        DateTimeUtc dateTimeUtc2 = new DateTimeUtc(new DateTime(2017,10,27,15,19,15,15, DateTimeZone.UTC));

        boolean result = dateTimeUtc1.isEqual(dateTimeUtc2);

        Assert.assertTrue(result);
    }

    @Test
    public void isEqual_shouldReturnFalse_whenNotEqual() {
        DateTimeUtc dateTimeUtc1 = new DateTimeUtc(new DateTime(2017,10,27,16,19,15,15, DateTimeZone.UTC));
        DateTimeUtc dateTimeUtc2 = new DateTimeUtc(new DateTime(2017,10,27,15,19,15,15, DateTimeZone.UTC));

        boolean result = dateTimeUtc1.isEqual(dateTimeUtc2);

        Assert.assertFalse(result);
    }

    @Test
    public void isAfter_shouldReturnTrue_whenAfter() {
        DateTimeUtc dateTimeUtc1 = new DateTimeUtc(new DateTime(2017,10,27,16,19,15,15, DateTimeZone.UTC));
        DateTimeUtc dateTimeUtc2 = new DateTimeUtc(new DateTime(2017,10,27,15,19,15,15, DateTimeZone.UTC));

        boolean result = dateTimeUtc1.isAfter(dateTimeUtc2);

        Assert.assertTrue(result);
    }

    @Test
    public void isAfter_shouldReturnFalse_whenBefore() {
        DateTimeUtc dateTimeUtc1 = new DateTimeUtc(new DateTime(2017,10,27,14,19,15,15, DateTimeZone.UTC));
        DateTimeUtc dateTimeUtc2 = new DateTimeUtc(new DateTime(2017,10,27,15,19,15,15, DateTimeZone.UTC));

        boolean result = dateTimeUtc1.isAfter(dateTimeUtc2);

        Assert.assertFalse(result);
    }

    @Test
    public void isAfter_shouldReturnFalse_whenEqual() {
        DateTimeUtc dateTimeUtc1 = new DateTimeUtc(new DateTime(2017,10,27,15,19,15,15, DateTimeZone.UTC));
        DateTimeUtc dateTimeUtc2 = new DateTimeUtc(new DateTime(2017,10,27,15,19,15,15, DateTimeZone.UTC));

        boolean result = dateTimeUtc1.isAfter(dateTimeUtc2);

        Assert.assertFalse(result);
    }

    @Test
    public void isBefore_shouldReturnTrue_whenBefore() {
        DateTimeUtc dateTimeUtc1 = new DateTimeUtc(new DateTime(2017,10,27,15,19,15,15, DateTimeZone.UTC));
        DateTimeUtc dateTimeUtc2 = new DateTimeUtc(new DateTime(2017,10,27,16,19,15,15, DateTimeZone.UTC));

        boolean result = dateTimeUtc1.isBefore(dateTimeUtc2);

        Assert.assertTrue(result);
    }

    @Test
    public void isBefore_shouldReturnFalse_whenAfter() {
        DateTimeUtc dateTimeUtc1 = new DateTimeUtc(new DateTime(2017,10,27,15,19,15,15, DateTimeZone.UTC));
        DateTimeUtc dateTimeUtc2 = new DateTimeUtc(new DateTime(2017,10,27,14,19,15,15, DateTimeZone.UTC));

        boolean result = dateTimeUtc1.isBefore(dateTimeUtc2);

        Assert.assertFalse(result);
    }

    @Test
    public void isBefore_shouldReturnFalse_whenEqual() {
        DateTimeUtc dateTimeUtc1 = new DateTimeUtc(new DateTime(2017,10,27,15,19,15,15, DateTimeZone.UTC));
        DateTimeUtc dateTimeUtc2 = new DateTimeUtc(new DateTime(2017,10,27,15,19,15,15, DateTimeZone.UTC));

        boolean result = dateTimeUtc1.isBefore(dateTimeUtc2);

        Assert.assertFalse(result);
    }

    @Test
    public void compareTo_shouldReturn0_whenEqual() {
        DateTimeUtc dateTimeUtc1 = new DateTimeUtc(new DateTime(2017,10,27,15,19,15,15, DateTimeZone.UTC));
        DateTimeUtc dateTimeUtc2 = new DateTimeUtc(new DateTime(2017,10,27,15,19,15,15, DateTimeZone.UTC));

        int result = dateTimeUtc1.compareTo(dateTimeUtc2);

        Assert.assertEquals(0, result);
    }

    @Test
    public void compareTo_shouldReturn1_whenAfter() {
        DateTimeUtc dateTimeUtc1 = new DateTimeUtc(new DateTime(2017,10,27,16,19,15,15, DateTimeZone.UTC));
        DateTimeUtc dateTimeUtc2 = new DateTimeUtc(new DateTime(2017,10,27,15,19,15,15, DateTimeZone.UTC));

        int result = dateTimeUtc1.compareTo(dateTimeUtc2);

        Assert.assertEquals(1, result);
    }

    @Test
    public void compareTo_shouldReturnNeg1_whenBefore() {
        DateTimeUtc dateTimeUtc1 = new DateTimeUtc(new DateTime(2017,10,27,14,19,15,15, DateTimeZone.UTC));
        DateTimeUtc dateTimeUtc2 = new DateTimeUtc(new DateTime(2017,10,27,15,19,15,15, DateTimeZone.UTC));

        int result = dateTimeUtc1.compareTo(dateTimeUtc2);

        Assert.assertEquals(-1, result);
    }

}