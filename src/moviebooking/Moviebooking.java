package moviebooking;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.stage.Modality;
import javax.swing.JOptionPane;

public class Moviebooking extends Application {
      private Label MovieInfo = new Label();
   private Label GenreInfo = new Label();
    private Label AgeInfo = new Label();
     private Label TicketsInfo = new Label();
      private Label DirectorInfo = new Label();
       private Label TimeInfo = new Label();
       
            private Label MovieInfo1 = new Label();
   private Label GenreInfo1 = new Label();
    private Label AgeInfo1 = new Label();
     private Label TicketsInfo1 = new Label();
      private Label DirectorInfo1 = new Label();
       private Label TimeInfo1 = new Label();
       
    @Override
    public void start(Stage primaryStage) throws SQLException, ClassNotFoundException {
       //Database Connection
         String host = "jdbc:mysql://localhost/MamoonDB";
        String username = "root";
        String password = "";

        
          Connection con = DriverManager.getConnection(host, username, password);
        Class.forName("com.mysql.jdbc.Driver");
        Statement state1 = con.createStatement();
        Statement state2 = con.createStatement();

        //Button declare
        Button btn = new Button();
        Button btn1 = new Button();
        Button btn2 = new Button();
        Button btn3 = new Button();
        Button btn4 = new Button();
        Button btn5 = new Button();
        Button btn6 = new Button();
        Button btn7 = new Button();
        Button btn8 = new Button();

        
        btn.setText("Screen 1");
        btn1.setText("Screen 2");
        btn2.setText("Screen 3");
        
        //Screen 1
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    GridPane root1 = new GridPane();
                    
                    root1.setAlignment(Pos.TOP_CENTER);
                    root1.setHgap(12.5);
                    root1.setVgap(12.5);
                    Scene scene1 = new Scene(root1, 600, 600);
                    Stage screen1 = new Stage();
                    screen1.setTitle("Screen1");
                    screen1.setScene(scene1);
                    
                    screen1.initModality(Modality.WINDOW_MODAL);
                    screen1.initOwner(primaryStage);
                    screen1.show();
                    
                    btn3.setText("Movie 1");
                    root1.add(btn3, 6, 5);
                    btn4.setText("Movie 2");
                    root1.add(btn4, 6, 13);
                           
                    root1.add(new Label("Movie 1"), 0, 3);
                    root1.add(new Label("Movie Name:"), 0, 4);
           
                    root1.add(new Label("Age rating:"), 0, 5);
                    root1.add(new Label(" Available Tickets:"), 0, 9);
                    root1.add(new Label(" Director Name:"), 0, 6);
                    root1.add(new Label(" Screen Time:"), 0, 7);
                                 
                    
                    root1.add(new Label("Movie 2"), 0,11);
                    root1.add(new Label("Movie Name:"), 0, 12);

                    root1.add(new Label("Age rating:"), 0, 13);
                    root1.add(new Label("Available Tickets:"), 0, 16);
                    root1.add(new Label("Director Name:"), 0, 14);
                    root1.add(new Label("Screen Time:"), 0, 15);
                    
                    String movie = "SELECT*FROM Moviedata WHERE MovieId=1";
                    String screens;
                    String timings;
                    
                       
                    ResultSet resultset = state1.executeQuery(movie);
                    if (resultset.next()) {
              
                    MovieInfo.setText(resultset.getString("MovieName"));
                    DirectorInfo.setText(resultset.getString("DirectorName"));
                    AgeInfo.setText(resultset.getString("AgeRating"));
                    TimeInfo.setText(resultset.getString("ScreenTime"));
                    
                    
                     String movie1 = "SELECT*FROM Moviedata WHERE MovieId=2";
          
                    
                    ResultSet resultset1 = state1.executeQuery(movie1);
                while (resultset1.next()) {
              
                    MovieInfo1.setText(resultset1.getString("MovieName"));
                    DirectorInfo1.setText(resultset1.getString("DirectorName"));
                    AgeInfo1.setText(resultset1.getString("AgeRating"));
                    TimeInfo1.setText(resultset1.getString("ScreenTime"));
                    
}
                  //Select Movie 1 Button   
                      btn3.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            
                            try {
                                String ticket = "SELECT*FROM Screendata WHERE MovieName='Deadpool'";
                                int ts1 = 0;
                                ResultSet resultset10 = state2.executeQuery(ticket);
                                while (resultset10.next()) {
                                    
                                    try {
                                        ts1 = (resultset10.getInt("Seats"));
                                        TicketsInfo.setText(Integer.toString(ts1));
                                    } catch (SQLException ex) {
                                        Logger.getLogger(Moviebooking.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                              
                                
                                int ans = Integer.parseInt( JOptionPane.showInputDialog("how many tickets?"));
                                int dialogbutton = JOptionPane.YES_NO_OPTION;
                                int diagres = JOptionPane.showConfirmDialog(null, "Buy tickets for Selected Movie " + ans, "Confirmation", dialogbutton);
                                if(diagres == JOptionPane.YES_OPTION)
                                {
                                          ts1 = ts1 - ans;
                 TicketsInfo.setText(Integer.toString(ts1));
                                }
                                 root1.add(TicketsInfo, 1, 9);
                            } catch (SQLException ex) {
                                Logger.getLogger(Moviebooking.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        
                        }
                      
                    
                      
                      
                      });
                      //Select movie 2 Button
                        btn4.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            
                            try {
                                String ticket = "SELECT*FROM Screendata WHERE MovieName='Avengers'";
                                int ts1 = 0;
                                ResultSet resultset10 = state2.executeQuery(ticket);
                                while (resultset10.next()) {
                                    
                                    try {
                                        ts1 = (resultset10.getInt("Seats"));
                                        TicketsInfo1.setText(Integer.toString(ts1));
                                    } catch (SQLException ex) {
                                        Logger.getLogger(Moviebooking.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                             
                                
                                
                                int ans = Integer.parseInt( JOptionPane.showInputDialog("how many tickets?"));
                                int dialogbutton = JOptionPane.YES_NO_OPTION;
                                int diagres = JOptionPane.showConfirmDialog(null, "Buy tickets for Selected Movie " + ans, "Confirmation", dialogbutton);
                                if(diagres == JOptionPane.YES_OPTION)
                                {
                                   ts1 = ts1 - ans;
                 TicketsInfo1.setText(Integer.toString(ts1));
            
                
                                }
                                  root1.add(TicketsInfo1, 1, 16);
                            } catch (SQLException ex) {
                                Logger.getLogger(Moviebooking.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                      
                      });
                    root1.add(MovieInfo, 1, 4);
                    root1.add(AgeInfo, 1, 5);
                    root1.add(DirectorInfo, 1, 6);
                    root1.add(TimeInfo, 1, 7);
                    root1.add(MovieInfo1, 1, 12);
                    root1.add(AgeInfo1, 1, 13);
                    root1.add(DirectorInfo1, 1, 14);
                    root1.add(TimeInfo1, 1, 15);
                    
}
       
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Moviebooking.class.getName()).log(Level.SEVERE, null, ex);
                }
                  
                 
                 
            }
        });
        //Screen 2
        
           btn1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    GridPane root2 = new GridPane();
                    root2.setAlignment(Pos.TOP_CENTER);
                    root2.setHgap(12.5);
                    root2.setVgap(12.5);
                    Scene scene2 = new Scene(root2, 600, 600);
                    Stage screen2 = new Stage();
                    screen2.setTitle("Screen2");
                    screen2.setScene(scene2);
                    
                    screen2.initModality(Modality.WINDOW_MODAL);
                    screen2.initOwner(primaryStage);
                    screen2.show();
                    
                    
                    
                    btn5.setText("Movie 1");
                    root2.add(btn5, 6, 5);
                    btn6.setText("Movie 2");
                    root2.add(btn6, 6, 13);
                    
                    
                    root2.add(new Label("Movie 1"), 0, 3);
                    root2.add(new Label("Movie Name:"), 0, 5);
        
                    root2.add(new Label("Age rating:"), 0, 6);
                    root2.add(new Label(" Available Tickets:"), 0, 9);
                    root2.add(new Label(" Director Name:"), 0, 7);
                    root2.add(new Label(" Screen Time:"), 0, 8);
                    
                                  
                    root2.add(MovieInfo, 1, 5);
                    root2.add(AgeInfo, 1, 6);
                   
                    root2.add(DirectorInfo, 1, 7);
                    root2.add(TimeInfo, 1, 8);
          
                    
                    
                    root2.add(new Label("Movie 2"), 0,11);
                    root2.add(new Label("Movie Name:"), 0, 12);
    
                    root2.add(new Label("Age rating:"), 0, 13);
                    root2.add(new Label("Available Tickets:"), 0, 16);
                    root2.add(new Label("Director Name:"), 0, 14);
                    root2.add(new Label("Screen Time:"), 0, 15);
                    
          
                  
                    
                    root2.add(MovieInfo1, 1, 12);
                    root2.add(AgeInfo1, 1, 13);
                    root2.add(TicketsInfo1, 1, 16);
                    root2.add(DirectorInfo1, 1, 14);
                    root2.add(TimeInfo1, 1, 15);  
                    
                    
                    
                    
                    
                    
                    String movie = "SELECT*FROM Moviedata WHERE MovieId=3";
         
                       
                    ResultSet resultset = state1.executeQuery(movie);
                    if (resultset.next()) {
                        
                        MovieInfo.setText(resultset.getString("MovieName"));
                        DirectorInfo.setText(resultset.getString("DirectorName"));
                        AgeInfo.setText(resultset.getString("AgeRating"));
                        TimeInfo.setText(resultset.getString("ScreenTime"));
                        
                        
                        
                    String movie1 = "SELECT*FROM Moviedata WHERE MovieId=4";
            
                    ResultSet resultset1 = state1.executeQuery(movie1);
                    while (resultset1.next()) {
                        
                        MovieInfo1.setText(resultset1.getString("MovieName"));
                        DirectorInfo1.setText(resultset1.getString("DirectorName"));
                        AgeInfo1.setText(resultset1.getString("AgeRating"));
                        TimeInfo1.setText(resultset1.getString("ScreenTime"));
                        
                    }
                    }
                    //select Movie 1 Button
                   
                                          btn5.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            
                            try {
                                String ticket = "SELECT*FROM Screendata WHERE MovieName='Glass'";
                                int ts1 = 0;
                                ResultSet resultset10 = state2.executeQuery(ticket);
                                while (resultset10.next()) {
                                    
                                    try {
                                        ts1 = (resultset10.getInt("Seats"));
                                        TicketsInfo.setText(Integer.toString(ts1));
                                    } catch (SQLException ex) {
                                        Logger.getLogger(Moviebooking.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                              
                                
                                int ans = Integer.parseInt( JOptionPane.showInputDialog("how many tickets?"));
                                int dialogbutton = JOptionPane.YES_NO_OPTION;
                                int diagres = JOptionPane.showConfirmDialog(null, "Buy tickets for Selected Movie " + ans, "Confirmation", dialogbutton);
                                if(diagres == JOptionPane.YES_OPTION)
                                {
                                          ts1 = ts1 - ans;
                 TicketsInfo.setText(Integer.toString(ts1));
                                }
                                 root2.add(TicketsInfo, 1, 9);
                            } catch (SQLException ex) {
                                Logger.getLogger(Moviebooking.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        
                        }
                      
                      });
                    //Select Movie 2 Button
                    
                      btn6.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            
                            try {
                                String ticket = "SELECT*FROM Screendata WHERE MovieName='Spider-Man'";
                                int ts1 = 0;
                                ResultSet resultset10 = state2.executeQuery(ticket);
                                while (resultset10.next()) {
                                    
                                    try {
                                        ts1 = (resultset10.getInt("Seats"));
                                        TicketsInfo1.setText(Integer.toString(ts1));
                                    } catch (SQLException ex) {
                                        Logger.getLogger(Moviebooking.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                              
                                
                                int ans = Integer.parseInt( JOptionPane.showInputDialog("how many tickets?"));
                                int dialogbutton = JOptionPane.YES_NO_OPTION;
                                int diagres = JOptionPane.showConfirmDialog(null, "Buy tickets for Selected Movie " + ans, "Confirmation", dialogbutton);
                                if(diagres == JOptionPane.YES_OPTION)
                                {
                                          ts1 = ts1 - ans;
                 TicketsInfo1.setText(Integer.toString(ts1));
                                }
                                 root2.add(TicketsInfo1, 1, 16);
                            } catch (SQLException ex) {
                                Logger.getLogger(Moviebooking.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        
                        }
                      
                      });
                    
         
                } catch (SQLException ex) {
                    Logger.getLogger(Moviebooking.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        //Screen 3
           btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    GridPane root3 = new GridPane();
                    root3.setAlignment(Pos.TOP_CENTER);
                    root3.setHgap(12.5);
                    root3.setVgap(12.5);
                    
                    Scene scene3 = new Scene(root3, 600, 600);
                    Stage screen3 = new Stage();
                    screen3.setTitle("Screen3");
                    screen3.setScene(scene3);
                    
                    screen3.initModality(Modality.WINDOW_MODAL);
                    screen3.initOwner(primaryStage);
                    screen3.show();
                          
                    btn7.setText("Movie 1");
                    root3.add(btn7, 6, 5);
                    btn8.setText("Movie 2");
                    root3.add(btn8, 6, 13);
                    
                                        
                           root3.add(new Label("Movie 1"), 0, 3);
                           
                    root3.add(new Label("Movie Name:"), 0, 5);
                    
                    root3.add(new Label("Age rating:"), 0, 7);
                    root3.add(new Label(" Available Tickets:"), 0, 10);
                    root3.add(new Label(" Director Name:"), 0, 8);
                    root3.add(new Label(" Screen Time:"), 0, 9);
                    root3.add(MovieInfo, 1, 5);
                    root3.add(AgeInfo, 1, 7);
                 
                    root3.add(DirectorInfo, 1, 8);
                    root3.add(TimeInfo, 1, 9);
                    
                    
                    root3.add(new Label("Movie 2"), 0,11);
                    root3.add(new Label("Movie Name:"), 0, 13);
                    root3.add(new Label("Age rating:"), 0, 14);
                    root3.add(new Label("Available Tickets:"), 0, 17);
                    root3.add(new Label("Director Name:"), 0, 15);
                    root3.add(new Label("Screen Time:"), 0, 16);
                    
                     root3.add(MovieInfo1, 1, 13);
                    root3.add(AgeInfo1, 1, 14);
               
                    root3.add(DirectorInfo1, 1, 15);
                    root3.add(TimeInfo1, 1, 16);  
              
                    
                    
                    
                    String movie = "SELECT*FROM Moviedata WHERE MovieId=4";
           
                       
                    ResultSet resultset = state1.executeQuery(movie);
                    if (resultset.next()) {
                        
                     
                            MovieInfo.setText(resultset.getString("MovieName"));
                            DirectorInfo.setText(resultset.getString("DirectorName"));
                            AgeInfo.setText(resultset.getString("AgeRating"));
                            TimeInfo.setText(resultset.getString("ScreenTime"));
                            
                            
                            
                            String movie1 = "SELECT*FROM Moviedata WHERE MovieId=1";
                       
                            
                            ResultSet resultset1 = state1.executeQuery(movie1);
                            while (resultset1.next()) {
                                
                                MovieInfo1.setText(resultset1.getString("MovieName"));
                                DirectorInfo1.setText(resultset1.getString("DirectorName"));
                                AgeInfo1.setText(resultset1.getString("AgeRating"));
                                TimeInfo1.setText(resultset1.getString("ScreenTime"));
                                
                                
                            }
                        } 
                    
        btn7.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            
                            try {
                                String ticket = "SELECT*FROM Screendata WHERE MovieName='Spider-Man'";
                                int ts1 = 0;
                                ResultSet resultset10 = state2.executeQuery(ticket);
                                while (resultset10.next()) {
                                    
                                    try {
                                        ts1 = (resultset10.getInt("Seats"));
                                        TicketsInfo.setText(Integer.toString(ts1));
                                    } catch (SQLException ex) {
                                        Logger.getLogger(Moviebooking.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                              
                                
                                int ans = Integer.parseInt( JOptionPane.showInputDialog("how many tickets?"));
                                int dialogbutton = JOptionPane.YES_NO_OPTION;
                                int diagres = JOptionPane.showConfirmDialog(null, "Buy tickets for Selected Movie " + ans, "Confirmation", dialogbutton);
                                if(diagres == JOptionPane.YES_OPTION)
                                {
                                          ts1 = ts1 - ans;
                 TicketsInfo.setText(Integer.toString(ts1));
                                }
                                 root3.add(TicketsInfo, 1, 10);
                            } catch (SQLException ex) {
                                Logger.getLogger(Moviebooking.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        
                        }
                      
                    
                      
                      
                      });
         btn8.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            
                            try {
                                String ticket = "SELECT*FROM Screendata WHERE MovieName='Deadpool'";
                                int ts1 = 0;
                                ResultSet resultset10 = state2.executeQuery(ticket);
                                while (resultset10.next()) {
                                    
                                    try {
                                        ts1 = (resultset10.getInt("Seats"));
                                        TicketsInfo1.setText(Integer.toString(ts1));
                                    } catch (SQLException ex) {
                                        Logger.getLogger(Moviebooking.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                              
                                
                                int ans = Integer.parseInt( JOptionPane.showInputDialog("how many tickets?"));
                                int dialogbutton = JOptionPane.YES_NO_OPTION;
                                int diagres = JOptionPane.showConfirmDialog(null, "Buy tickets for Selected Movie " + ans, "Confirmation", dialogbutton);
                                if(diagres == JOptionPane.YES_OPTION)
                                {
                                          ts1 = ts1 - ans;
                 TicketsInfo1.setText(Integer.toString(ts1));
                                }
                                 root3.add(TicketsInfo1, 1, 17);
                            } catch (SQLException ex) {
                                Logger.getLogger(Moviebooking.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        
                        }
                      
                    
                      
                      
                      });
        
        
                } 
                
                
                
                
                
                
                
                
                catch (SQLException ex) {
                    Logger.getLogger(Moviebooking.class.getName()).log(Level.SEVERE, null, ex);
                }
                
               
               
            }
        });
        
        
        
               GridPane root = new GridPane();
                root.setAlignment(Pos.TOP_CENTER);
       root.add(new Label("Movie Booking"), 2, 5);
         root.setHgap(12.5);
         root.setVgap(12.5);
            
           root.add(btn, 2, 7);
            root.add(btn1, 2, 8);
             root.add(btn2, 2, 9);
           
           Scene scene = new Scene(root, 450, 450);
           root.setAlignment(Pos.TOP_CENTER);
     
     
        primaryStage.setTitle("Movie Booking Management");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
