package methods;

import java.util.HashMap;

public interface IMethodsGame {

	public abstract void thinkOfAnAnimalDone();
	public abstract void thinkOfAnAnimalFailed();
    public abstract void thinkOfAnAnimalWithsettings(HashMap<String, String> animalVoice,String voiceAnimal);
	
}
