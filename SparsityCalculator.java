/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sparsity.calculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author chrj
 */
public class SparsityCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
       int ratings_10=0;
       int ratings_20=0;
       int ratings_50=0;
       int ratings_50plus=0;
       int ratingsPerUser=0;
       int users_10=0;
       int users_20=0;
       int users_50=0;
       int users_50plus=0;
       int averatingsperuser=0;
       
       File folder = new File("C:\\Users\\chrj\\Desktop\\libimseti\\data\\ratings_given");
           File[] listOfFiles = folder.listFiles();
           for(File file : listOfFiles){
               ratingsPerUser=0;
               if(file.isFile()){
                   String fileName = file.getName();
                   int rater = Integer.parseInt(fileName.substring(0, fileName.lastIndexOf('.')));
                   System.out.println(rater);
                   if(rater<=10250){
                           users_10++;
                           
                       }
                       if(rater>10250 && rater<=20250){
                           users_20++;
                           
                       }
                       if(rater>20250 && rater<=50250){
                           users_50++;
                                                     
                       }
                       if(rater>50250){
                           users_50plus++;
                                                     
                       }
                   BufferedReader br = new BufferedReader(new FileReader(file));
                   String line = null;
                   while((line = br.readLine()) != null){
                       Scanner s = new Scanner(line).useDelimiter(",");
                       int ratee = s.nextInt();
                       int rating = s.nextInt(); 
                       if(rater<=10250){
                           if(ratee<=10250){
                           ratings_10++;
                           ratingsPerUser++;
                       }
                       }
                       if(rater<=20250){
                           if(ratee<=20250){
                           ratings_20++;
                           ratingsPerUser++;
                           }
                       }
                       if(rater<=50250){
                           if(ratee<=50250){
                           ratings_50++;
                           ratingsPerUser++; 
                           }
                       }
                       if(rater>50250){
                           ratings_50plus++;
                           ratingsPerUser++;                           
                       }
                       
           }
                   
               }
               
    }
         System.out.println("ratings_10: " + ratings_10);  
         System.out.println("ratings_20: " + ratings_20);
         System.out.println("ratings_50: " + ratings_50);  
         System.out.println("ratings_50plus: " + ratings_50plus);
         System.out.println("ratingsPerUser" + ratingsPerUser);
         
         System.out.println("users_10: " + users_10);  
         System.out.println("users_20: " + users_20);
         System.out.println("users_50: " + users_50);  
         System.out.println("users_50plus: " + users_50plus);

    }
    
}
