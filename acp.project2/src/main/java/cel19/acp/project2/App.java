package cel19.acp.project2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    public static String fileName = "Words.txt";
    public static Set<String> wordSet = new HashSet<String>();

    @Override
    public void start(Stage stage) throws IOException {
    	readFile(fileName);
    	System.out.println(wordSet);
        scene = new Scene(loadFXML("menu"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public void readFile(String fileName)
    {
    	File file = new File(fileName);
    	try {
			Scanner fileReader = new Scanner(file);
			while(fileReader.hasNextLine())
			{
				wordSet.add(fileReader.nextLine());
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    public void insertText()
    {
    	
    }

    public static void main(String[] args) {
        launch();
    }

}