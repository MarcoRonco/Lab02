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
   		
    	 String i[] = txtWord.getText().split(" ");
    	 if(i.length==2){
    		 
    	   String pAliena = i[0].toLowerCase().trim();
    	   String pUmana = i[1].toLowerCase().trim();
    	 
    	   if(pAliena.matches("[a-z]*")==true && pUmana.matches("[a-z]*")==true){ //matches("[a-z]+o*") * = 0 volte, + = 1 o piu volte
    		   Word j = new Word(pAliena, pUmana);
    		   boolean h = true;
    		   for(Word g :a){
     	    	  if(g.getAlienWord().compareTo(pAliena)==0){
     	    		 g.setTranslation(pUmana);
     	    		 h=false;
     	    	  }
    		   }
    		   if(h==true)
    		      a.add(j);
    		   
    	      }else{
    		   txtResult.setText("Le parole non possono contenere simboli o numeri");
    		   txtWord.clear();
    		   return;
    		  }
    	 }
    	 else if(i.length==1){
    		
    		 String parola = i[0].toLowerCase().trim();
//    		if(parola.matches("[a-z]*")==false && parola.contains("?")==false){
//    		   txtResult.setText("La parola aliena non può contenere simboli o numeri");
//    		   txtWord.clear();
//    		   return;
//    		}
//    		boolean h = true;
//    	      for(Word g :a){
//    	    	  if(g.compare(parola)!=null){
//    	    		  txtResult.setText(g.getTranslation());
//    	    		  h = false;
//    	    	  }
//    	      }
//    	      if(h == true){
//    	    	  txtResult.setText("Parola aliena sconosciuta"); 
//    	      }
    		 if(parola.contains("?")==true){
    			 String t[] = parola.split("?");
    			 String x = null;
    			 String y = null;
    			 if(t.length==1){
    				 x= t[0];
    				  for(Word g :a){
   	    	    	   if(g.getAlienWord().contains(x)==true){
   	    	    		   txtResult.setText(g.getTranslation());
        	    	  }
    		     }
    			 }
    			 if(t.length==2){
    				 x= t[0];
    				 y= t[1];
    			 }
    		 }
    		 
    		
    		 }
    	
    	txtWord.clear();
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	a.clear();
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
