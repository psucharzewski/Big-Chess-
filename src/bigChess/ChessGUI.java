package bigChess;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class ChessGUI extends Application 
{
    public static void main(String[] args) 
    {
        try
        {
            launch(args);
            System.exit(0);
        }
        catch (Exception error)
        {
            error.printStackTrace();
            System.exit(0);
        }
    }
    private ChessBoard board;
  
    private boolean playerIsWhite; // white player = server
    int timeWhite = 900;
    int timeBlack = 900;
   
    @Override
    public void start(Stage mainStage) 
    {
        mainStage.setTitle("Big Chess");
        mainStage.getIcons().add( new Image("assets/icons/app_icon.png") );

        BorderPane root = new BorderPane();
        Scene mainScene = new Scene(root);
        mainStage.setScene(mainScene);

        // add stylesheet
        mainScene.getStylesheets().add("assets/stylesheet.css");

        // prompt user to select team color
        choosePlayerColor();

        // draw chessboard
        board = new ChessBoard(playerIsWhite);
        root.setCenter(board); // sized 400x400

               
        StatusBar label = new StatusBar();
        label.whitePlayerTimer.setText(Integer.toString((this.timeWhite/60))+ " : " + Integer.toString((this.timeWhite%60)));
        label.blackPlayerTimer.setText(Integer.toString((this.timeBlack/60))+ " : " + Integer.toString((this.timeBlack%60)));
        Button start = new Button("Start");

        start.setOnAction(event -> {
            Task<Void> task = new Task<Void>() {
                @Override 
                public Void call() throws Exception {
                	while(true) {
                		
                		if(timeWhite<=0) {
                			updateMessage("White loose");
                			return null;
                		}
                        if(timeBlack<=0) {
                        	updateMessage("Black loose");
                        	return null;
                        }
                	if(board.player == true) {
                		updateMessage("White");}
                	else {
                		updateMessage("Black");
                	}
                        Thread.sleep(250);
                        

                        if(true==false) return null;}
                }
            };
            task.messageProperty().addListener((obs, oldMessage, newMessage) -> label.winner.setText(newMessage));
            //label.blackPlayerTimer.setText(Integer.toString(timeWhite));
            //label.whitePlayerTimer.setText(Integer.toString(timeBlack));
            new Thread(task).start();
        
        
        Task<Void> taskTimerWhite = new Task<Void>() {
            @Override 
            public Void call() throws Exception {
            	while(true) {
            	if(board.player == true) {
            		//endGame(true);
            		timeWhite--;}
        			updateMessage(Integer.toString((timeWhite/60))+ " : " + Integer.toString((timeWhite%60)));
        			if(timeWhite==0) return null;
        			Thread.sleep(1000);
                    
                    //if(true==false) return null;
        			}
            }
            
        };
        taskTimerWhite.messageProperty().addListener((obs, oldMessage, newMessage) -> label.whitePlayerTimer.setText(newMessage));
        new Thread(taskTimerWhite).start();
        
        Task<Void> taskTimerBlack = new Task<Void>() {
            @Override 
            public Void call() throws Exception {
            	while(true) {
            	if(board.player == false) {

            		timeBlack--;}
        			updateMessage(Integer.toString((timeBlack/60))+ " : " + Integer.toString((timeBlack%60)));
        			if(timeBlack==0) return null;
                    Thread.sleep(1000);
                    
                    //if(true==false) return null;
                    }
            }
            
        };
        taskTimerBlack.messageProperty().addListener((obs, oldMessage, newMessage) -> label.blackPlayerTimer.setText(newMessage));
        new Thread(taskTimerBlack).start();
        start.setVisible(false);
        });
        
        label.whitePlayerTimer.setText(Integer.toString((this.timeWhite/60))+ " : " + Integer.toString((this.timeWhite%60)));
        label.blackPlayerTimer.setText(Integer.toString((this.timeBlack/60))+ " : " + Integer.toString((this.timeBlack%60)));
        root.setTop(label);
        root.setBottom(start);

        mainStage.show();
    }

    
    @Override
    public void stop() {

    }

 
    public void choosePlayerColor()
    {

        // Choose amount of time for one player
        Alert newGameAlert = new Alert(AlertType.CONFIRMATION);
        newGameAlert.setTitle("Start new game");
        newGameAlert.setHeaderText(null);
        newGameAlert.setContentText("Choose amount of time for one player");

        ButtonType button15 = new ButtonType("15 min");
        ButtonType button10 = new ButtonType("10 min");
        ButtonType button5 = new ButtonType("5 min");
        ButtonType button2 = new ButtonType("2 min");
        ButtonType button01 = new ButtonType("10 s");

        newGameAlert.getButtonTypes().setAll(button15,button10, button5,button2,button01);
        Optional<ButtonType> result = newGameAlert.showAndWait();

        if (result.get() == button15)
        {
            this.timeWhite = 900;
            this.timeBlack = 900;
        }
        else if (result.get() == button10)
        {
            this.timeWhite = 600;
            this.timeBlack = 600;
        }
        else if(result.get() == button5) 
        {
            this.timeWhite = 300;
            this.timeBlack = 300;
        } else if(result.get() == button2)
        {
            this.timeWhite = 120;
            this.timeBlack = 120;
        }else
        {
            this.timeWhite = 10;
            this.timeBlack = 10;
        }
        this.playerIsWhite = true;
    }

    public void endGame(boolean looser)
    {
        // TODO: If a chess game is currently ongoing, warn that
        //         "Starting a new game while a match is in progress will count as a forfiet."
        //         "Do you still want to start a new game?"
        //            "Yes"   "No"
        //
        //       If no, just break/return and ignore the following code

        // Prompt user for new game
        Alert endGame = new Alert(AlertType.CONFIRMATION);
        endGame.setTitle("Game over");
        endGame.setHeaderText(null);
        if(looser) endGame.setContentText("Player II - Black Win");
        else endGame.setContentText("Player I - White Wine");
        

        ButtonType button15 = new ButtonType("15 min");
        ButtonType button10 = new ButtonType("10 min");
        ButtonType button5 = new ButtonType("5 min");
        ButtonType button2 = new ButtonType("2 min");

       endGame.getButtonTypes().setAll(button15,button10, button5,button2);
        Optional<ButtonType> result = endGame.showAndWait();

        if (result.get() == button15)
        {
            this.timeWhite = 900;
            this.timeBlack = 900;
        }
        else if (result.get() == button10)
        {
            this.timeWhite = 600;
            this.timeBlack = 600;
        }
        else if(result.get() == button5) 
        {
            this.timeWhite = 300;
            this.timeBlack = 300;
        } else
        {
            this.timeWhite = 120;
            this.timeBlack = 120;
        }
        this.playerIsWhite = true;
    }

    // Quits program
    public void onQuit()
    {
        Platform.exit();
        System.exit(0);
    }

    // Display 'about' menu
    
    
    public void cleanUp()
    {
    	
    }
    
    public class StatusBar extends HBox{

    	
    	public StatusBar(){
    		statusBarGp = new GridPane();
    		//resetButton = new Button("Reset");
    		whitePlayerAlert = new Label("Player I");
    		blackPlayerAlert = new Label("Player II ");
    		whitePlayerTimer = new Label("15");
    		blackPlayerTimer = new Label("14");
    		winner = new Label("Nobody");
    		game = new Label("Big Chess");

//    	    statusBarGp.setGridLinesVisible(true);
    		ColumnConstraints column = new ColumnConstraints();
    		column.setPercentWidth(30);
    		statusBarGp.getColumnConstraints().add(column);
    		column = new ColumnConstraints();
    		column.setPercentWidth(30);
    		statusBarGp.getColumnConstraints().add(column);
    		column = new ColumnConstraints();
    		column.setPercentWidth(30);
    		statusBarGp.getColumnConstraints().add(column);
    		statusBarGp.setPrefSize(400, 100);
    		statusBarGp.getRowConstraints().add(new RowConstraints(70/2));
    		statusBarGp.getRowConstraints().add(new RowConstraints(70/2));
    		statusBarGp.addRow(0, whitePlayerAlert,game, blackPlayerAlert);
    		statusBarGp.addRow(1, whitePlayerTimer, winner, blackPlayerTimer);
    		for (Node n: statusBarGp.getChildren()) {
    			GridPane.setHalignment(n, HPos.CENTER);
    			GridPane.setValignment(n, VPos.CENTER);
    			if (n instanceof Label) {
    				n.setStyle("-fx-font-size: 10pt; -fx-font-weight: bold; -fx-opacity: 1.0;");
    			}
    		}
    		statusBarGp.setVgap(10);
    		statusBarGp.setHgap(10);
    		statusBarGp.setPadding(new Insets(10, 10, 10, 10));
    		
    	
    		statusBarGp.setSnapToPixel(false);		
    		getChildren().add(statusBarGp);
            
    		/*Timer timer = new java.util.Timer();
    		final int time =900;
    		timer.schedule(new TimerTask() {
    		    public void run() {
    		         Platform.runLater(new Runnable() {
    		            public void run() {
    		            	int time = 1000;
    		            	time = decrease(time);
    		                whitePlayerTimer.setText(Integer.toString(time));;

    		            }
    		        });
    		    }
    		},1, 150);*/
    		
    	}
    	
    	public int decrease(int number)
    	{
    		return (number - 1);
    	}
    	public void resize(double width, double height){
    		super.resize(width, height); 
    		setWidth(width);
    		setHeight(height);
    	}
    	

    	public Label	whitePlayerAlert;
    	public Label	blackPlayerAlert;
    	public Label	whitePlayerTimer;
    	public Label	blackPlayerTimer;
    	public Label	winner;
    	public Label 	game;
    	private GridPane statusBarGp;


    }
}