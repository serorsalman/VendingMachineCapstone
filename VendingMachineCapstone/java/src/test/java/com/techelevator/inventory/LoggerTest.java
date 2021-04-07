package com.techelevator.inventory;

import junit.framework.TestCase;
import org.junit.Assert;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LoggerTest extends TestCase {
    BigDecimal userBalance = new BigDecimal("0.00");
    BigDecimal vendorBalance = new BigDecimal("0.00");
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
    Date date = new Date();
    Calendar calendar = Calendar.getInstance();


    public void testLogToFile() {
        Logger logger = new Logger();
//        try {
//            assertNotNull(logger.logToFile("FEED MONEY", new BigDecimal("0.00"),new BigDecimal("0.00")));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}