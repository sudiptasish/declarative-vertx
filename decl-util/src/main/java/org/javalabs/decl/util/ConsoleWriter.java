package org.javalabs.decl.util;

import java.io.PrintStream;

/**
 * Console writer.
 * 
 * <p>
 * It leverages the underlying {@link PrintStream} attached to output device to print s line.
 * It is the most common and straightforward way to print output to the console.
 *
 * @author schan280
 */
public class ConsoleWriter {
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private static final PrintStream CONSOLE = System.out;
    private static final Long PAUSE = Long.valueOf(System.getProperty("pause.time", "1"));
    
    /**
     * Print a text on the console.
     * It will add a new line at the end of the paragraph/text.
     * 
     * @param text  Text to be printed 
     */
    public static void println(String text) {
        CONSOLE.println(text);
    }
    
    public static void timingPrintln(String text) {
        timingPrintln(text, null);
    }
    
    /**
     * See {@link #timingPrint(java.lang.String) .
     * 
     * <p>
     * It will add a newline at the end of the text/paragraph.
     * 
     * @param text  Text or paragraph to be printed.
     * @param color
     */
    public static void timingPrintln(String text, String color) {
        timingPrint(text);
        CONSOLE.println();
    }
    
    /**
     * It will time a print.
     * 
     * <p>
     * The time based printing happens in the same thread. It will cause the main thread to sleep,
     * which may not be ideal as it will cause your program to basically stop. Therefore it is recommended
     * you use this api with utmost caution.
     * 
     * @param text  Text to be printed
     * @throws RuntimeException 
     */
    public static void timingPrint(String text) {
        try {
            for (int i = 0; i < text.length(); i ++) {
                CONSOLE.print(text.charAt(i));
                Thread.sleep(PAUSE);
            }
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Add the openapi prompt.
     */
    public static void prompt() {
        CONSOLE.print("<openapi> ");
    }
}
