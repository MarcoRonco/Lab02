package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	private List<Word> a = new LinkedList<Word>();
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
   
    	if(txtWord.getText().contains(" ")){
    		
    	 String i[] = txtWord.getText().split(" ");
    	 String pAliena = i[0].toLowerCase();
    	 String pUmana = i[1].toLowerCase();
    	 
    	 if(pAliena!=null && pUmana!=null){
    		 Word j = new Word(pAliena, pUmana);
    		 a.add(j);
    	 }
    	}
    	
    	else
    	{
    		String parola;
    		boolean h = true;
    		if(txtWord.getText()!=null){
    	      parola = txtWord.getText();
    	      for(Word g :a){
    	    	  if(g.compare(parola)!=null){
    	    		  txtResult.setText(g.getTranslation());
    	    		  h = false;
    	    	  }
    	      }
    	      if(h == true)
    	    	  txtResult.setText("Parola aliena sconosciuta"); 
    		}
    	}
    	
    	txtWord.clear();
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	a.clear();
    }
    
    @FXML
    void doPulisci(ActionEvent event) {
    	txtResult.clear();
    }
    
    @FXML
    void doDictionary(ActionEvent event) {
    	String u = "";
    	
    	for(Word t : a)
    		u += "Parola: " + t.getAlienWord() + " Traduzione: " + t.getTranslation() + '\n';
    	
    	if(a.size()==0)
    		u = "Dizionario vuoto";
    	
    		txtResult.setText(u);
    }
}
