package RPSGame;

import java.util.Random;

public class TheSharks extends Player {
	
	public TheSharks() {
		this.name = "The Sharks";
	}

	@Override
	public Roshambo generateRoshambo() {
		Random random = new Random();
		int roshbo = random.nextInt(3);
		if (roshbo == 0) {
			return Roshambo.ROCK;
		} else if (roshbo == 1) {
			return Roshambo.PAPER;
		} else {
			return Roshambo.SCISSORS;
		}
	}


}
