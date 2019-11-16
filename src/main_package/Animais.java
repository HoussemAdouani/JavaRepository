package main_package;

import javax.swing.JOptionPane;

import methods.MethodsGameAnimals;

public class Animais {
  
  
  
  public static void main(String[] args) {
	  
	   //instantiation to avoid static visibility.
       MethodsGameAnimals methods = new MethodsGameAnimals();		
	
	   //Welcome messgae.
	   JOptionPane.showMessageDialog(null, Strings.messageWelcome,Strings.nameGame, JOptionPane.INFORMATION_MESSAGE);
	    
	   //Think of an animal message.
       JOptionPane.showMessageDialog(null, Strings.thinkOfAnimal, Strings.nameGame, JOptionPane.INFORMATION_MESSAGE);
	    
	    
	   methods.thinkOfAnAnimalDone();
	   
	  
	  
  
  
}
}