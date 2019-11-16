package methods;

import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main_package.Strings;


public class MethodsGameAnimals implements IMethodsGame {

	
	public void thinkOfAnAnimalDone() {
		
        
	   //the living place(Water) of the animals Question. 
         int response= JOptionPane.showConfirmDialog(null,Strings.animalWaterQuestion, Strings.nameGame, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
         if(response == JOptionPane.CLOSED_OPTION)
        	 exitGame();
       
       // test on the output(Is the place is the water?)

		 animalWaterQuestion(response);
		 

		 
  }
	
	
	public void thinkOfAnAnimalFailed() 
	{
		
		String choosenAnimal= JOptionPane.showInputDialog(Strings.chosenAnimalQuestion);
		
		//but a whale does not : An implicit question to know the animal's voice.
		String voiceAnimal= JOptionPane.showInputDialog("a( | an) "+choosenAnimal+"_____ but a whale does not");
		
		
		if(voiceAnimal.isEmpty() && choosenAnimal.isEmpty() )
		{
			thinkOfAnAnimalFailed();
		}
			
		else {	//I want to use the HashMap collection to associate the animal with his voice.
			HashMap<String, String> animalVoice = new HashMap<>();
			
			//value==>choosenAnimal And key==>voiceAnimal.
			
			animalVoice.put(voiceAnimal,choosenAnimal);
			
			
	        int responseContinue = letScontinue();
			
	 	    if(responseContinue == JOptionPane.OK_OPTION)
	 	    {
	 		  
	 		  thinkOfAnAnimalWithsettings(animalVoice, voiceAnimal);

	 	    }
	 	   
	 	    else if(responseContinue  == JOptionPane.NO_OPTION) {
	 	    	 exitGame();
		   }
	 	    
	 	   if(responseContinue == JOptionPane.CLOSED_OPTION)
	 		  exitGame();
			
		
		}
		
		
	}
	
	
	public void thinkOfAnAnimalWithsettings(HashMap<String, String> animalVoice,String voiceAnimal) 
	{
		//Think of an animal message.
        JOptionPane.showMessageDialog(null, Strings.thinkOfAnimal, Strings.nameGame, JOptionPane.INFORMATION_MESSAGE);
        
        int confirmedAnimalVoice= JOptionPane.showConfirmDialog(null,"The animal you thought "+voiceAnimal+"?", Strings.nameGame, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if(confirmedAnimalVoice == JOptionPane.OK_OPTION) {
        	
        	String confirmedAnimalString = animalVoice.getOrDefault(voiceAnimal, null);
        	
        	JOptionPane.showConfirmDialog(null,"The animal is a ( | an ) "+confirmedAnimalString+"?", Strings.nameGame, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        	
        	JOptionPane.showMessageDialog(null, Strings.gotItRight,Strings.nameGame, JOptionPane.INFORMATION_MESSAGE);
        	
        	letScontinue();
        	thinkOfAnAnimalWithsettings(animalVoice,voiceAnimal);
        	
        }
        else if(confirmedAnimalVoice == JOptionPane.NO_OPTION) {
        	
        	int response= JOptionPane.showConfirmDialog(null,Strings.animalWaterQuestion, Strings.nameGame, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        	
        	animalWaterQuestion(response);
        	
        	if(response == JOptionPane.CLOSED_OPTION)
   	      	exitGame();
        	     
        
        
        }
        
        else if(confirmedAnimalVoice == JOptionPane.CLOSED_OPTION)
	      	 exitGame();
		
		
		
		
	}
	
	public void animalWaterQuestion(int response){
		
		if(response == JOptionPane.YES_OPTION) {
    		
            int responseShark=JOptionPane.showConfirmDialog(null,Strings.animalShark, Strings.nameGame, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    	
	    	if(responseShark == JOptionPane.YES_OPTION) 
	    	{
	    	   JOptionPane.showMessageDialog(null, Strings.gotItRight,Strings.nameGame, JOptionPane.INFORMATION_MESSAGE);

	    	   int responseContinue= JOptionPane.showConfirmDialog(null,Strings.letsContinue,Strings.nameGame, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    	  
	    	  
	    	   if(responseContinue == JOptionPane.YES_OPTION)
               //recursion
	    	   thinkOfAnAnimalDone();
	    	   else if(responseContinue  == JOptionPane.NO_OPTION) {
	    		   exitGame();
	    	   }
	    	   	   
	    	  
	    	}
    		
    	}
		
		 // test on the output(Is the place isn't the water?)
        else if(response == JOptionPane.NO_OPTION) thinkOfAnAnimalFailed();
		
        else if(response == JOptionPane.CLOSED_OPTION)
        	exitGame();
	}
	
	public int letScontinue(){
		
	    int responseContinue= JOptionPane.showConfirmDialog(null,Strings.letsContinue,Strings.nameGame, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		return responseContinue;
	}
	
	public void exitGame() {
		int quite =JOptionPane.showConfirmDialog(null,Strings.exitGame,Strings.nameGame, JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
		 
		  if (quite == JOptionPane.NO_OPTION) 
		  {
			  thinkOfAnAnimalDone();
		  }
		  else if(quite == JOptionPane.CLOSED_OPTION)
		      	 System.exit(1);
	}

}
