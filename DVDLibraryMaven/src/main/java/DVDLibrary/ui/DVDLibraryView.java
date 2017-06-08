/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibrary.ui;

import DVDLibrary.dto.DVD;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author softwareguild
 */
public class DVDLibraryView {

    private UserIO io;
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List DVD Titles");
        io.print("2. Create a DVD");
        io.print("3. View a DVD");
        io.print("4. Edit a DVD");
        io.print("5. Remove a DVD");
        io.print("6. Add Additional User Rating");
        io.print("7. Get Newest DVD");
        io.print("8. Get Oldest DVD");
        io.print("9. Get DVDs within Last N Years");
        io.print("10. Get Average DVD Age");
        io.print("11. Get DVDs by Studio");
        io.print("12. Get DVD By Director (sorted by Mpaa Rating)");
        io.print("13. Get All DVDs (Grouped by Mpaa Rating)");
        io.print("14. Get Average Number of Notes for DVDs");
        io.print("15. Load Library");
        io.print("16. Save Library");
        io.print("17. Exit");
        return io.readInt("Please select from the above choices.", 1, 17);
    }

    public DVD getNewDVDInfo() {

        String title = io.readString("Please enter DVD title");
        String releaseDate = io.readString("Please enter Release Date (mm-DD-yyyy)");
        LocalDate ld = LocalDate.parse(releaseDate, DateTimeFormatter.ofPattern("mm-DD-yyyy"));
        String mpaaRating = io.readString("Please enter MPAA Rating");
        String directorName = io.readString("Please enter Director's Name");
        String studio = io.readString("Please enter Studio");
        
        ArrayList<String> userRating = new ArrayList<>();
        String userRatingString = io.readString("Please enter User Rating");

        userRating.add(userRatingString);
        DVD currentDVD = new DVD(title);
        currentDVD.setReleaseDate(ld);
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setDirectorName(directorName);
        currentDVD.setStudio(studio);
        currentDVD.setUserRating(userRating);

        return currentDVD;
    }

    public DVD editNewDVDInfo() {
       
        String title = io.readString("Please enter DVD title");
        String releaseDate = io.readString("Please enter Release Date (mm-DD-yyyy)");
        LocalDate ld = LocalDate.parse(releaseDate, DateTimeFormatter.ofPattern("mm-DD-yyyy"));
        String mpaaRating = io.readString("Please enter MPAA Rating");
        String directorName = io.readString("Please enter Director's Name");
        String studio = io.readString("Please enter Studio");
        
        ArrayList<String> userRating = new ArrayList<>();
        String userRatingString = io.readString("Please enter User Rating");

        userRating.add(userRatingString);
        DVD currentDVD = new DVD(title);
        currentDVD.setReleaseDate(ld);
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setDirectorName(directorName);
        currentDVD.setStudio(studio);
        currentDVD.setUserRating(userRating);

        return currentDVD;
    }
    

    public String getTitleChoice() {
        return io.readString("Please enter the Title.");
    }

    public void printTitle(String title) {
        io.print(title);
    }
    
    public String addNote(){
        return io.readString("Please enter new user rating: ");
    }

    public String getDirectorName() {
        return io.readString("Please enter director's name: ");
    }

    public String getStudio() {
        return io.readString("Please enter name of studio: ");
    }

    public int getNumberOfYears() {
        return io.readInt("Please enter number of years: ");
    }

    public void printNumberOfYears(int number) {
        io.print("The following DVDs are within the last " + number + " years: ");
    }

    public void printAverageNumberOfNotes(double number) {
        io.print("The average number of notes for the DVDs is " + number + ".");
    }

    public void printDVDsFromStudio(String studio) {
        io.print("The following DVDs are from " + studio + " studio: ");
    }

    public void getAverageDVDAge(double num) {
        io.print("The average age of the DVDs is " + Double.toString(num) + " years.");
    }

    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate().toString());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getDirectorName() + " " + dvd.getStudio());
            ArrayList<String> userRating = dvd.getUserRating();
            for (int i = 0; i < userRating.size(); i++) {
                io.print(userRating.get(i));
            }

        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDVDBanner() {
        io.print("=== Display DVD ===");
    }

    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");

    }

    public void displayCreateSuccessBanner() {
        io.readString("DVD successfully created. Please hit enter to continue.");
    }

    public void displayEditSuccessBanner() {
        io.readString("DVD successfully edited. Please hit enter to continue.");
    }

    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            io.print("DVD Title: " + currentDVD.getTitle() + " \n Release date: "
                    + currentDVD.getReleaseDate() + " \n MPAA Rating: "
                    + currentDVD.getMpaaRating() + " \n Director's Name: "
                    + currentDVD.getDirectorName() + " \n Studio: "
                    + currentDVD.getStudio() + " \n User Rating: "
                    + currentDVD.getUserRating() + "\n");

        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDVDsByDirectorsSortedByMpaaRating(String directors) {
        io.print("The following films were directed by " + directors + ": ");
    }

    public void displayDVDsGroupedByMpaaRating(String mpaaRating) {
        io.print("The following films are rated " + mpaaRating + ": ");
    }

    public void displayAllBanner() {
        io.print("=== Display All DVDs ===");
    }

    public void displayRemoveDVDBanner() {
        io.print("=== Remove DVD ===");
    }

    public void displayEditDVDBanner() {
        io.print("=== Edit DVD ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("DVD successfully removed. Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void goodbye() {
        io.print("Goodbye!");
    }

    public void exception() {
        io.print("Exception!");
    }
}
