package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private TextArea txtOutput;

    @FXML
    void doReset(ActionEvent event) {
    	txtOutput.clear();
    	txtInput.clear();

    }
    AlienDictionary dic = new AlienDictionary();

    @FXML
    void doTranslate(ActionEvent event) {
    	String input= txtInput.getText();
    	String[] words= input.split(" ");
    	if(words.length==2) {
    		if(!words[1].matches("[a-zA-Z]") || !words[0].matches("[a-zA-Z]")) {
    			txtOutput.setText("Errore: non ci possono essere numeri o caratteri speciali");
    			txtInput.clear();
    			return;
    		}
    		dic.addWord(words[0],words[1]);
    		txtOutput.setText("Traduzione inserita nel database");
    		txtInput.clear();
    		
    	}else if(words.length==1) {
    		txtOutput.setText("La traduzione è: "+dic.translateWord(words[0]));
    		txtInput.clear();
  
    	}

    }

    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
