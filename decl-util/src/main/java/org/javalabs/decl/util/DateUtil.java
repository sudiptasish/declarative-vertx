package org.javalabs.decl.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Pattern;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Utility class to handle date related operation.
 *
 * @author Sudiptasish Chanda
 */
public final class DateUtil {
    
    private static final TimeZone UTC = TimeZone.getTimeZone("UTC");
    private static final TimeZone MST = TimeZone.getTimeZone("MST");

    private static class FormatDef {

        private final String format;
        private final Pattern pattern;
        private final int len;
        private final ThreadLocal<DateFormat> dateFormatHolder;
        private final ThreadLocal<Calendar> calendarHolder;

        public FormatDef(final String format, String pattern, int len) {
            this.format = format;
            this.pattern = Pattern.compile(pattern);
            this.len = len;

            dateFormatHolder = new ThreadLocal() {
                @Override
                protected synchronized Object initialValue() {
                    DateFormat df = new SimpleDateFormat(format);
                    df.setTimeZone(UTC);
                    return df;
                }
            };
            
            calendarHolder = new ThreadLocal() {
                @Override
                protected synchronized Object initialValue() {
                    Calendar cal = Calendar.getInstance(TimeZone.getDefault());
                    return cal;
                }
            };
        }

        public DateFormat getDateFormat() {
            return dateFormatHolder.get();
        }

        public Calendar getCalendar() {
            return calendarHolder.get();
        }
    }

    // Full OPC/W3C format: 2012-01-31T23:59:58.123Z
    // We should always use this format when converting dates into strings.
    private static final FormatDef isoFormatDef1 = new FormatDef(
        "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
        "\\d\\d\\d\\d-\\d\\d-\\d\\dT\\d\\d:\\d\\d:\\d\\d\\.\\d*Z",
        24
    );
    // Omits milliseconds: 2012-01-31T23:59:58Z
    // Clients are allowed to send times in this format to us.
    private static final FormatDef isoFormatDef2 = new FormatDef(
        "yyyy-MM-dd'T'HH:mm:ss'Z'",
        "\\d\\d\\d\\d-\\d\\d-\\d\\dT\\d\\d:\\d\\d:\\d\\dZ",
        20
    );
    // Omits entire time component: 2012-01-31Z
    // Clients are allowed to send times in this format to us.
    private static final FormatDef isoFormatDef3 = new FormatDef(
        "yyyy-MM-dd'Z'",
        "\\d\\d\\d\\d-\\d\\d-\\d\\dZ",
        11
    );

    /**
     * Get current time in UTC
     *
     * @return {@link Timestamp}
     */
    public static Date currentUTCDate() {
        return new Date(System.currentTimeMillis());
    }

    public static String adjustedMSTDate(int days, int hours, int minutes) {
        DateFormat df = new SimpleDateFormat(isoFormatDef1.format);
        df.setTimeZone(MST);
        Date utcDate = new Date(System.currentTimeMillis() + days * 86400 * 1000 + hours * 3600 * 1000 + minutes * 60 * 1000);
        return df.format(utcDate);
    }

    public static String adjustedMSTDate(int days, int hours, int minutes, int seconds) {
        DateFormat df = new SimpleDateFormat(isoFormatDef1.format);
        df.setTimeZone(MST);
        Date utcDate = new Date(System.currentTimeMillis() + days * 86400 * 1000 + hours * 3600 * 1000 + minutes * 60 * 1000 + seconds * 1000);
        return df.format(utcDate);
    }

    /**
     * Get future time in UTC
     *
     * @param days
     * @return {@link Timestamp}
     */
    public static Date futureUTCDate(int days) {
        return new Date(System.currentTimeMillis() + days * 86400 * 1000);
    }

    /**
     * Get current time in UTC
     *
     * @return {@link String}
     */
    public static String currentDate() {
        return isoFormatDef1
            .getDateFormat()
            .format(new java.util.Date());
    }

    /**
     * Convert the date in ISO format to a timestamp object
     * Masks (and logs) parsing exception
     * @param ts
     * @return Date
     */
    public static Date format(String ts) {
        try {
            return new Date(getFormatDef(ts)
                .getDateFormat()
                .parse(ts)
                .getTime());
        }
        catch (ParseException ex) {
            throw new IllegalArgumentException("Invalid date format " + ts + " specified");
        }
    }

    /**
     * Format a date object
     * @param date
     * @return
     */
    public static String format(java.util.Date date) {
        return format(date, false);
    }

    /**
     * Format a date object
     * @param date
     * @param dateOnly
     * @return
     */
    public static String format(java.util.Date date, boolean dateOnly) {
        if (dateOnly) {
            return isoFormatDef3.getDateFormat().format(date);
        }
        else {
            return isoFormatDef1.getDateFormat().format(date);
        }
    }
    
    public static Timestamp parse(String ts) {
        try {
            FormatDef def = getFormatDef(ts);
            java.util.Date dt = def.getDateFormat().parse(ts);
            
            Calendar cal = def.getCalendar();
            cal.setTime(dt);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);

            return new Timestamp(cal.getTimeInMillis());
        }
        catch (ParseException ex) {
            throw new IllegalArgumentException("Invalid date format " + ts + " specified."
                    + " Supported formats: ["
                    + isoFormatDef1.format + ", " + isoFormatDef2.format + ", " + isoFormatDef3.format
                    + "]");
        }
    }

    /**
     * Returns the appropriate FormatDef object, based on comparing
     * the length of the timestamp string to the len value defined in
     * the FormatDef.
     *
     * @param ts
     * @return
     */
    private static FormatDef getFormatDef(String ts) {
        if (ts != null) {
            if (ts.length() == isoFormatDef1.len) {
                return isoFormatDef1;
            }
            else if (ts.length() == isoFormatDef2.len) {
                return isoFormatDef2;
            }
            else if (ts.length() == isoFormatDef3.len) {
                return isoFormatDef3;
            }
        }
        return isoFormatDef1;
    }
    
    /**
     * Convert the date to a gregorian calendar object.
     * @param d
     * @return XMLGregorianCalendar
     */
    public static XMLGregorianCalendar toXMLGregorianCalendar(java.util.Date d) {
		XMLGregorianCalendar result = null;
		GregorianCalendar gregorianCalendar;
        
		try {
			gregorianCalendar = (GregorianCalendar) GregorianCalendar.getInstance();
			gregorianCalendar.setTime(d);
			result = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
		}
        catch (DatatypeConfigurationException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
}
