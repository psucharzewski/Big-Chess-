package bigChess;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
//import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

public class Test extends ApplicationTest{
	

	@Override public void start(Stage stage) {
		ChessBoard chess = new ChessBoard(true);
        Scene scene = new Scene(chess, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

   // @Test public void should_contain_button() 
   // {  assertThat(label.getText(), is("123456789")) }

  //  @Test public void should_click_on_button() { }


	
	
}
	//@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
	//	Rook rock = new Rook(true);
//	}

	
//	  private final HelloWorld helloWorld = new HelloWorld();
//	  @Override
//	  public void start(Stage stage) throws Exception {		    
//	  stage.setScene(helloWorld.getScene());
//	  }
//		    stage.show();
//		    stage.toFront();
//	}
//		  
//		  @org.junit.Test
//		  public void hasHelloWorldButton() {
//		    StackPane rootNode = helloWorld.getScene().getRoot();
//		    Button button = from(rootNode).lookup(".button").query();
//		    assertEquals("Hello World", button.getText());
//		  }
	
//    @Override
//    public void start(Stage stage) {
//        Scene scene = new Scene(new DesktopPane(), 800, 600);
//        stage.setScene(scene);
//        stage.show();
//        
//        // ok teraz trzeba na tej scenie ustawic jakos twoja aplikacje tak jak w tym tutku na blogu
//       /// spróbujê to zrobiæ
//        
//    }

	 /*@Override
	    public void start(Stage stage) {
		 
	        Scene scene = new Scene(new ChessGUI(), 800, 600);
	        stage.setScene(scene);
	        stage.show();
	    }
	 
    @org.junit.Test
    public void should_drag_file_into_trashcan() {
    	// lol skroty mi sie pomieszaly xd zasrany eclipse, nie potrafi sam importowac
         //given:
        rightClickOn("#desktop").moveTo("New").clickOn("Text Document");
        write("myTextfile.txt").push(KeyCode.ENTER);

         //when:
        drag(".file").dropTo("#trash-can");

         //then:
        
       
    }*/

