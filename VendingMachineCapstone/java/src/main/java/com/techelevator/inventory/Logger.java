package com.techelevator.inventory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Logger {
    File logFile = new File("log.txt");
    String item;
    BigDecimal userBalance = new BigDecimal("0.00");
    BigDecimal vendorBalance = new BigDecimal("0.00");
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
    Date date = new Date();
    Calendar calendar = Calendar.getInstance();

    public void logToFile(String operation, BigDecimal userBalance, BigDecimal vendorBalance) throws IOException {
        logFile.createNewFile();
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFile))) {
            writer.println(dateFormat.format(calendar.getTime()) + " " + operation + " " + userBalance + " " + vendorBalance + "\n");
            writer.flush();
            writer.close();
        }
    }
}
