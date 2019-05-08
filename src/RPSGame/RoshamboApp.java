package RPSGame;

import java.util.Scanner;

public class RoshamboApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char comp;
		int playerWin = 0;
		int computerWin = 0;
		int games = 0;

		// Greet User
		System.out.println("Welcome to Rock Paper Scissors!");
		System.out.println("-------------------------------");

		// Name User Player
		String name = Validator.getLine(scan, "Enter your name: ");
		Player user = new UserPlayer(name);
		Player computer = null;

		// Choose Opponent
		while (true) {
			System.out.print("Would you like to play against Sharks or Jets (S/J): ");
			comp = scan.next().charAt(0);
			if (comp == 'S' || comp == 's') {
				computer = new TheSharks();
				break;
			} else if (comp == 'J' || comp == 'j') {
				computer = new TheJets();
				break;
			} else {
				continue;
			}
		}
		System.out.println();
		System.out.println("Ok, you're playing agianst " + computer.getName());

		while (true) {

			System.out.println();
			String choice = Validator.getString(scan, "Rock, Paper, or Scissors? Choose R, P, S (e to exit): ");
			System.out.println();
			choice = choice.substring(0, 1);
			if (choice.equalsIgnoreCase("e")) {

				System.out.println("Would you like to exit? (y/n)");
				String s = scan.nextLine();
				if (s.charAt(0) != 'n') {
					System.out.println(":*:(:*  Thanks for playing RPS!  :*:(:*");
					break;
				} else {
					continue;
				}
			} else {
				user.setHand(choice);

				Roshambo userThrows = user.generateRoshambo();
				Roshambo computerThrows = computer.generateRoshambo();

				if (userThrows == computerThrows) {
					System.out.println("Draw!");

				} else if (userThrows == Roshambo.SCISSORS && computerThrows == Roshambo.ROCK) {
					System.out.println(user.getName() + ": " + userThrows);
					System.out.println(computer.getName() + ": " + computerThrows);
					System.out.println();
					System.out.println(computer.getName() + " wins!");
					playerWin += 1;

				} else if (userThrows == Roshambo.PAPER && computerThrows == Roshambo.ROCK) {
					System.out.println(user.getName() + ": " + userThrows);
					System.out.println(computer.getName() + ": " + computerThrows);
					System.out.println();
					System.out.println("You win!");
					playerWin += 1;

				} else if (userThrows == Roshambo.SCISSORS && computerThrows == Roshambo.PAPER) {
					System.out.println(user.getName() + ": " + userThrows);
					System.out.println(computer.getName() + ": " + computerThrows);
					System.out.println();
					System.out.println("You win!");
					playerWin += 1;
				} else if (userThrows == Roshambo.ROCK && computerThrows == Roshambo.PAPER) {
					System.out.println(user.getName() + ": " + userThrows);
					System.out.println(computer.getName() + ": " + computerThrows);
					System.out.println();
					System.out.println(computer.getName() + " wins!");
					playerWin += 1;

				} else if (userThrows == Roshambo.PAPER && computerThrows == Roshambo.SCISSORS) {
					System.out.println(user.getName() + ": " + userThrows);
					System.out.println(computer.getName() + ": " + computerThrows);
					System.out.println();
					System.out.println(computer.getName() + " wins!");
					playerWin += 1;

				} else if (userThrows == Roshambo.ROCK && computerThrows == Roshambo.SCISSORS) {
					System.out.println(user.getName() + ": " + userThrows);
					System.out.println(computer.getName() + ": " + computerThrows);
					System.out.println();
					System.out.println("You win!");
					playerWin += 1;

				}
				games += 1;
			}
		}

		System.out.println();
		System.out.println("Score");
		System.out.println("`````");
		System.out.println(user.getName() + ": " + playerWin);
		System.out.println(computer.getName() + ": " + computerWin);
		System.out.println("Out of " + games + " games");
		System.out.println();

		System.out.println(":*:(:*  Thanks for playing RPS!  :*:(:*");
		scan.close();
	}

}
