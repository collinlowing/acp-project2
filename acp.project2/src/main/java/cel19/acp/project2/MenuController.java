package cel19.acp.project2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class MenuController {

	@FXML
	TextArea textArea;
	@FXML
	MenuItem openMenuItem;
	@FXML
	MenuItem saveMenuItem;
	@FXML
	MenuItem exitMenuItem;
	@FXML
	MenuItem spellCheckMenuItem;

	@FXML
	private void openMenuItemHandler() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Text File");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"),
				new ExtensionFilter("All Files", "*.*"));
		Stage fileChooserStage = new Stage();
		File selectedFile = fileChooser.showOpenDialog(fileChooserStage);
		if (selectedFile != null) {
			System.out.println(selectedFile.getName());
			insertText(selectedFile.getName());
		} else
			System.out.println("File was not opened");
	}

	@FXML
	private void saveMenuItemHandler() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save To File");
		Stage fileChooserStage = new Stage();
		File file = fileChooser.showSaveDialog(fileChooserStage);
		if (file != null) {
			try {
				PrintWriter out = new PrintWriter(file.getCanonicalPath());
				out.print(textArea.getText());
				out.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@FXML
	private void exitMenuItemHandler() {
		System.exit(0);
	}

	@FXML
	private void spellCheckMenuItemHandler() {

	}

	private void insertText(String fileName) {
		LinkedHashSet<String> wordSet;
		wordSet = App.readFile(fileName);

		String text = "";

		for (String word : wordSet) {
			text += word + " ";
		}
		System.out.println(text);

		textArea.setText(text);
	}
}
