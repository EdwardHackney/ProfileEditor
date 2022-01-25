/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hackney.profileeditor;

import java.awt.Image;
import java.io.File;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author Edward Hackney
 */
public class UserProfile {
    private String username;
    private Image profilePicture;
    private String userBio;
    private int userGrade;
    private double gpa;
    private int classRank;
    private boolean perfectAttendance;
    
    
    public UserProfile(String name){
        username = name;
        profilePicture = null;
        userBio = "";
        userGrade = 10;
        gpa = 0.0;
        classRank = 999;
        perfectAttendance = false;
        
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getClassRank() {
        return classRank;
    }

    public void setClassRank(int classRank) {
        this.classRank = classRank;
    }

    public boolean isPerfectAttendance() {
        return perfectAttendance;
    }

    public void setPerfectAttendance(boolean perfectAttendance) {
        this.perfectAttendance = perfectAttendance;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String newName){
        username = newName;
    }

    public Image getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Image profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getUserBio() {
        return userBio;
    }

    public void setUserBio(String userBio) {
        this.userBio = userBio;
    }

    public int getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(int userGrade) {
        this.userGrade = userGrade;
    }
    
    public void loadProfile(String fileName){
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            username = scanner.nextLine();
            String pictureFileName = scanner.nextLine();
            userGrade = Integer.parseInt(scanner.nextLine());
            gpa = Double.parseDouble(scanner.nextLine());
            classRank = Integer.parseInt(scanner.nextLine());
            perfectAttendance = Boolean.parseBoolean(scanner.nextLine());
            while(scanner.hasNextLine()){
                userBio += scanner.nextLine() + "\n";
            }
            File imageFile = new File(pictureFileName);
            profilePicture = ImageIO.read(imageFile);
            
        } catch(Exception e){
            System.out.println("There was an error: " +e.getMessage());
        }
    }
    public String getAwards(){
        /**
         * to be implemented for assignment
         * 
         * A honor roll (at least 4.0 gpa)
         * AB honor roll (at least 3.0 gpa)
         * Valedictorian (Rank 1)
         * Salutatorian (Rank 2)
         * Perfect Attendance
         * 
         * each award on separate line
         * 
         */
        String award = "";
        if(gpa >= 4.0){
            award += "A honor roll\n";
        }
        else if(gpa >= 3.0){
            award += "AB honor roll\n";
        }
        if(classRank == 1){
            award += "Valedictorian\n";
        }
        else if(classRank == 2){
            award += "Salutatorian\n";
        }
        if(perfectAttendance){
            award += "Perfect Attendance\n";
        }
        if(award == ""){
            award = "none";
        }
        return award;
    }
}