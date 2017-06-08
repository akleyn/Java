/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibrary.dto;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author softwareguild
 */
public class DVD {

    final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private String title;
    private LocalDate releaseDate;
    private String mpaaRating;
    private String directorName;
    private String studio;
    private ArrayList<String> userRating;

    public DVD(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public ArrayList<String> getUserRating() {
        return userRating;
    }

    public void setUserRating(ArrayList<String> userRating) {
        this.userRating = userRating;
    }

    public long getDVDAge() {
        Period p = releaseDate.until(LocalDate.now());
        return p.getYears();
    }

    public String toString() {

        StringBuffer buffer = new StringBuffer();
        buffer.append("DVD Title: ");
        buffer.append(title);
        buffer.append("\n Release Date: ");
        buffer.append(releaseDate);
        buffer.append("\n MPAA Rating: ");
        buffer.append(mpaaRating);
        buffer.append("\n Director's Name: ");
        buffer.append(directorName);
        buffer.append("\n Studio Name: ");
        buffer.append(studio);
        buffer.append("\n User Comments: ");
        buffer.append(userRating);
        buffer.append("\n \n");

        return buffer.toString();
    }

}
