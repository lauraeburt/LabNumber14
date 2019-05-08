package RPSGame;

public class TheJets extends Player {

	public TheJets (){
		this.name = "The Jets";
	}
	
	@Override
	public Roshambo generateRoshambo() {
		return Roshambo.ROCK;
	}

}