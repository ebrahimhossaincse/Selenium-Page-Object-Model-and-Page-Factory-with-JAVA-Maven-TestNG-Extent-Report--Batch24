package com.ebrahim.hossain;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Get OS name
        String osName = System.getProperty("os.name");
        // Get OS version
        String osVersion = System.getProperty("os.version");
        // Get OS architecture
        String osArch = System.getProperty("os.arch");

        // Display the OS information
        System.out.println("Operating System Name: " + osName);
        System.out.println("Operating System Version: " + osVersion);
        System.out.println("Operating System Architecture: " + osArch);
    }
}
