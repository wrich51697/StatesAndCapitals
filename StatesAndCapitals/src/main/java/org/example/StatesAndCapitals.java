package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class StatesAndCapitals {

    // Logger instance for logging messages
    private static final Logger logger = Logger.getLogger(StatesAndCapitals.class.getName());

    // HashMap to store states and their capitals
    private static final Map<String, String> statesAndCapitals = new HashMap<>();

    static {
        // Ensure the logs directory exists
        try {
            Files.createDirectories(Paths.get("logs"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Load the logging configuration from the logging.properties file
        try (InputStream configFile = StatesAndCapitals.class.getClassLoader().getResourceAsStream("logging.properties")) {
            if (configFile != null) {
                LogManager.getLogManager().readConfiguration(configFile);
            } else {
                // Log an error message if the logging.properties file is not found
                logger.severe("Could not find logging.properties file");
            }
        } catch (IOException e) {
            // Log a severe error message if an IOException occurs while loading the logging properties
            logger.log(Level.SEVERE, "Could not load logging properties", e);
        }

        // Initialize the states and capitals map
        logger.info("Initializing states and capitals map");
        statesAndCapitals.put("Alabama", "Montgomery");
        statesAndCapitals.put("Alaska", "Juneau");
        statesAndCapitals.put("Arizona", "Phoenix");
        statesAndCapitals.put("Arkansas", "Little Rock");
        statesAndCapitals.put("California", "Sacramento");
        statesAndCapitals.put("Colorado", "Denver");
        statesAndCapitals.put("Connecticut", "Hartford");
        statesAndCapitals.put("Delaware", "Dover");
        statesAndCapitals.put("Florida", "Tallahassee");
        statesAndCapitals.put("Georgia", "Atlanta");
        statesAndCapitals.put("Hawaii", "Honolulu");
        statesAndCapitals.put("Idaho", "Boise");
        statesAndCapitals.put("Illinois", "Springfield");
        statesAndCapitals.put("Indiana", "Indianapolis");
        statesAndCapitals.put("Iowa", "Des Moines");
        statesAndCapitals.put("Kansas", "Topeka");
        statesAndCapitals.put("Kentucky", "Frankfort");
        statesAndCapitals.put("Louisiana", "Baton Rouge");
        statesAndCapitals.put("Maine", "Augusta");
        statesAndCapitals.put("Maryland", "Annapolis");
        statesAndCapitals.put("Massachusetts", "Boston");
        statesAndCapitals.put("Michigan", "Lansing");
        statesAndCapitals.put("Minnesota", "Saint Paul");
        statesAndCapitals.put("Mississippi", "Jackson");
        statesAndCapitals.put("Missouri", "Jefferson City");
        statesAndCapitals.put("Montana", "Helena");
        statesAndCapitals.put("Nebraska", "Lincoln");
        statesAndCapitals.put("Nevada", "Carson City");
        statesAndCapitals.put("New Hampshire", "Concord");
        statesAndCapitals.put("New Jersey", "Trenton");
        statesAndCapitals.put("New York", "Albany");
        statesAndCapitals.put("New Mexico", "Santa Fe");
        statesAndCapitals.put("North Carolina", "Raleigh");
        statesAndCapitals.put("North Dakota", "Bismarck");
        statesAndCapitals.put("Ohio", "Columbus");
        statesAndCapitals.put("Oklahoma", "Oklahoma City");
        statesAndCapitals.put("Oregon", "Salem");
        statesAndCapitals.put("Pennsylvania", "Harrisburg");
        statesAndCapitals.put("Rhode Island", "Providence");
        statesAndCapitals.put("South Carolina", "Columbia");
        statesAndCapitals.put("South Dakota", "Pierre");
        statesAndCapitals.put("Tennessee", "Nashville");
        statesAndCapitals.put("Texas", "Austin");
        statesAndCapitals.put("Utah", "Salt Lake City");
        statesAndCapitals.put("Vermont", "Montpelier");
        statesAndCapitals.put("Virginia", "Richmond");
        statesAndCapitals.put("Washington", "Olympia");
        statesAndCapitals.put("West Virginia", "Charleston");
        statesAndCapitals.put("Wisconsin", "Madison");
        statesAndCapitals.put("Wyoming", "Cheyenne");
        logger.info("States and capitals map initialized successfully");
    }

    /**
     * Get the map of states and capitals.
     *
     * @return Map of states and their capitals.
     */
    public static Map<String, String> getStatesAndCapitals() {
        return statesAndCapitals;
    }

    /**
     * Get the capital of a state.
     *
     * @param state The name of the state.
     * @return The capital of the state or a message indicating the state was not found.
     */
    public static String getCapital(String state) {
        if (state == null || state.trim().isEmpty()) {
            logger.warning("Invalid input: state name is null or empty");
            return "Invalid input. Please enter a valid state name.";
        }
        state = state.trim().toLowerCase();
        String normalizedState = state.substring(0, 1).toUpperCase() + state.substring(1);
        logger.info("Fetching capital for state: " + normalizedState);
        String capital = statesAndCapitals.get(normalizedState);
        if (capital != null) {
            logger.info("Found capital for state " + normalizedState + ": " + capital);
            return "The capital of " + normalizedState + " is " + capital + ".";
        } else {
            logger.warning("No such state found: " + normalizedState);
            return "No such State.";
        }
    }

    /**
     * Print all states and their capitals.
     */
    public static void printAllStatesAndCapitals() {
        Set<String> stateNames = statesAndCapitals.keySet();
        logger.info("Printing all states and their capitals");
        System.out.println("\nAll states and their capitals:");
        for (String stateName : stateNames) {
            System.out.println(stateName + " - " + statesAndCapitals.get(stateName));
        }
    }

    /**
     * Main method to run the program. Prompts the user to enter a state name and
     * displays the capital or an error message.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a state name:");
            String state = scanner.nextLine();
            System.out.println(getCapital(state));
            printAllStatesAndCapitals();
        } catch (Exception e) {
            // Log a severe error message if an exception occurs
            logger.log(Level.SEVERE, "An error occurred while processing input", e);
            System.out.println("An error occurred while processing your input. Please try again.");
        }
    }
}
