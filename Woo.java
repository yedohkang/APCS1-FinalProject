import cs1.Keyboard;

public class Woo
{
    private int countMoves;
    private boolean gameRunning;

    // list of animals that exist
    public static final String[] ANIMALS = {"Bear", "Elephant", "Giraffe", "Lion", "RedPanda"};

    public Woo()
    {
	countMoves = 4;
	gameRunning = true;
    }

    public static void printWelcome()
    {
	System.out.println("\nWelcome to the Animal Circus!\n");
	System.out.println("You are the owner of the circus.\nUse your time and money wisely to buy and train animals.\n" +
			   "Position your animals in the circus so that you can earn money and fame.\n\nHAVE FUN!!!\n");
    }                                       

    public void printMoves()
    {
	System.out.println("You have " + countMoves + " actions left.");
    }

    public static String listAnimals()
    {
	String retStr = "";
	for (int i = 0; i < ANIMALS.length; i += 1) 
	    {
		retStr += "\t" + (i + 1) + ") " + ANIMALS[i] + "\n";
	    }
	return retStr;
    }

    public static void attemptPurchase(Woo someGame, Player somePlayer, Animal someAnimal, GameBoard someBoard)
    {         
	System.out.println();
	System.out.println(someAnimal);
        
	System.out.println();
	System.out.println("Confirm purchase:");
	System.out.println("\t" + "1) Yes.");
	System.out.println("\t" + "2) No.");

	// user input
	System.out.print("Selection: ");
	int confirmation = Keyboard.readInt();

	// while invalid number is chosen
	while (confirmation != 1 && confirmation != 2) {
	    System.out.println ("Invalid number selected. Please enter a valid number for confirmation.");
	    System.out.print("Selection: ");
	    confirmation = Keyboard.readInt();
	}

	// if when user confirms purchase
	if (confirmation == 1)
	    {
		System.out.println(prettySpacing(100));
		// buy animal
                if (somePlayer.buyAnimal(someAnimal))
                {
                    // if purchase was successfully, decrement countMoves
                    someGame.countMoves -= 1;
                    // add animal and its shape to each ArrayList
                    someBoard.getRoster().add(someAnimal);
                    someBoard.getRosterShapes().add(someAnimal.getShape());
                }
	    }
	// if when user does not confirm purchase
	else
	    {
		System.out.println(prettySpacing(100));
		System.out.println("No purchase made.");
	    }
    }

    // used to make terminal display nicer
    public static String prettySpacing(int x)
    { 
	String retStr = "";
	for (int i = 0; i < x; i += 1)
            {
                retStr += "\n";
            }                
	return retStr;
    }
    
    
    public static void main(String[] args)
    {
	String spacing = prettySpacing(100);
	System.out.println(spacing);
	printWelcome();

	// creates new instances of each class, and takes user input for name
	Woo newGame = new Woo();
	System.out.print("What is your name?" + "\n\t> ");
	Player newPlayer = new Player(Keyboard.readString());
	Circus newCircus = new Circus();
	GameBoard newBoard = new GameBoard();

	System.out.println(spacing);
	System.out.println("Hello " + newPlayer.getName() + "!\n");
	System.out.println(newPlayer);

	while (newGame.gameRunning)
	    {
                
		while (newGame.countMoves > 0)
		    {
			System.out.println();
			newGame.printMoves();
                        System.out.println();
			System.out.println("What would you like to do?");
			System.out.println("\t" + "1) Buy and train animals.");
			System.out.println("\t" + "2) Skip preparation and start the Animal Circus!");

			// user input
			System.out.print("Selection: ");
			int prepOrCircus = Keyboard.readInt();

			// while invalid input is chosen
			while (prepOrCircus != 1 && prepOrCircus != 2) {
			    System.out.println ("Invalid input. Please enter a valid number for selection.");
			    System.out.print("Selection: ");
			    prepOrCircus = Keyboard.readInt();
			}

			// if when user wants to buy or train animals
			if (prepOrCircus == 1)
			    {
				System.out.println(spacing);
				System.out.println("Would you like to buy or train an animal?");
				System.out.println("\t" + "1) Buy!");
				System.out.println("\t" + "2) Train!");

				// user input
				System.out.print("Selection: ");
				int buyOrTrain = Keyboard.readInt();

				// while invalid input is chosen
				while (buyOrTrain != 1 && buyOrTrain != 2) {
				    System.out.println ("Invalid input. Please enter a valid number for selection.");
				    System.out.print("Selection: ");
				    buyOrTrain = Keyboard.readInt();
				}

				// if when user wants to buy an animal
				if (buyOrTrain == 1)
				    {
					System.out.println(spacing);
					System.out.println("Which animal would you like to buy?");
                                        System.out.print(listAnimals());

					// user input
					System.out.print("Selection: ");
					int animalNum = Keyboard.readInt();

					// while invalid input is chosen
					while (animalNum != 1 && animalNum != 2 && animalNum != 3 && animalNum != 4 && animalNum != 5) {
					    System.out.println ("Invalid input. Please enter a valid number for selection.");
					    System.out.print("Selection: ");
					    animalNum = Keyboard.readInt();
					}
					
                                        System.out.println(spacing);

					// when specific animal is chosen, attempts purchase
					if (animalNum == 1)
					    {
						attemptPurchase(newGame, newPlayer, new Bear(), newBoard);
					    }
					else if (animalNum == 2)
					    {
						attemptPurchase(newGame, newPlayer, new Elephant(), newBoard);
					    }
					else if (animalNum == 3)
					    {
						attemptPurchase(newGame, newPlayer, new Giraffe(), newBoard);
					    }
					else if (animalNum == 4)
					    {
						attemptPurchase(newGame, newPlayer, new Lion(), newBoard);
					    }
					else
					    {
						attemptPurchase(newGame, newPlayer, new RedPanda(), newBoard);
					    }                    
				    }
				// if when user wants to train the animals
				else
				    {
					// if the user owns 1+ animals
					if (newPlayer.getOwnedAnimals().size() > 0)
					    {
						System.out.println(spacing);
						System.out.println("Which animal would you like to train?");
						System.out.println(newPlayer.listOwnedAnimals());

						// user input
						System.out.print("Selection: ");
						int trainNum = Keyboard.readInt();

						// while invalid input is chosen
						while (trainNum > newPlayer.getOwnedAnimals().size() || trainNum < 1) {
						    System.out.println ("Invalid input. Please enter a valid number for selection.");
						    System.out.print("Selection: ");
						    trainNum = Keyboard.readInt();
						}

						if (newPlayer.getOwnedAnimals().size() >= trainNum)
						    {
							int isTrained =  newPlayer.trainAnimal(newPlayer.getOwnedAnimals().get(trainNum - 1));
							if (isTrained == 1)
							    {
								// update countMove
								newGame.countMoves -= 1;
								System.out.println(spacing);
								System.out.println("\nSuccessfully trained!");
							    }
							else
							    {
								System.out.println(spacing);
								System.out.println("\nThis animal was already trained!");
								System.out.println("\nNo actions deducted.");
							    }
                                                       
						    }
						else
						    {
							System.out.println();
							System.out.println("Invalid input. Please enter a valid number for selection.");
						    }
					    }
					// if the user owns 0 animals
					else
					    {
						System.out.println(spacing);
						System.out.println("You do not own any animals!");
					    }
				    }
			    }
			// if when user wants to go to the animal circus
			else if (prepOrCircus == 2)
			    {
				// if user owns more than 1 animal, go to the circus
				if (newPlayer.getOwnedAnimals().size() > 0)
				    {
					break;       
				    }
				// if user owns no animals
				else
				    {
					System.out.println(spacing);
					System.out.println("Please buy an animal before starting the circus.");
				    }
			    }
			else
			    {
				System.out.println();
				System.out.println("Invalid input. Please enter a valid number for selection.");
			    }
		    } // end while

                System.out.println(spacing);

		// if user has no more moves left to buy/train animals
		if (newGame.countMoves == 0)
		    {
			System.out.println("You are out of actions.\nIt's time to go to the circus!");
		    }
                
		System.out.println();
		System.out.println("This is your circus, try to fit as many animals as possible:\n");
                
                int i = 0;
		while (i < newBoard.getRoster().size()){
		    
		    System.out.println(newBoard.boardState(i));
		    System.out.println("What would you like to do?");
		    System.out.println("\t1) Place this animal");
		    System.out.println("\t2) Skip to next animal");
		    System.out.println("\t3) End the circus right now");

		    // user input
		    System.out.print("Selection: ");
		    int placeAnimal = Keyboard.readInt();

		    // while invalid input is chosen
		    while (placeAnimal != 1 && placeAnimal != 2 && placeAnimal != 3)
                        {
                            System.out.println ("Invalid input. Please enter a valid number for selection.");
                            System.out.print("Selection: ");
                            placeAnimal = Keyboard.readInt();
                        }

		    // if when user wants to place the animal on the board
		    if (placeAnimal == 1)
                        {
                            System.out.println(spacing);
                            System.out.println("The top left corner is considered (0, 0)\n");
                            System.out.println(newBoard.boardState(i));

			    // user input
                            System.out.println("Please input the X and Y coordinates of where to place");
                            System.out.print("X coordinate: ");
                            int x = Keyboard.readInt();
                            System.out.print("Y coordinate: ");
                            int y = Keyboard.readInt();

			    // if when the animal is successfully placed on the board
                            if (newBoard.addAnimal(newBoard.getRoster().get(i), y, x)){
                                System.out.println(spacing);
                                System.out.println(newBoard.getRoster().get(i).getName() + " successfully placed at (" + x + ", " + y + ").\n");
				i += 1;
                            }
			    // if when the animal does not fit
                            else{
                                System.out.println(spacing);
				System.out.println("It doesn't fit. Try again.\n");
                            }
                            
                        }
		    // if when user wants to skip animal
		    else if (placeAnimal == 2)
                        {
                            System.out.println(spacing);
                            System.out.println(newBoard.getRoster().get(i).getName() + " has been skipped.\n");
                            i += 1;
                        }
		    // if when user wants to end the circus
		    else
                        {
                            System.out.println(spacing);
                            System.out.println("Circus has been ended.");
                            break;
                        }
                }
		// if when there are no more animals to place on the board
                if (i == newBoard.getRoster().size())
		    {
			System.out.println(spacing);
			System.out.println("\nNo more animals left to place. Printing circus results...");
		    }

		// prints out results of the circus
                System.out.println("\nHow your circus looked:\n" + newBoard);
		newCircus.results(newPlayer);
		newCircus.setAmtEarned();
		System.out.println(newPlayer.newBalance(newCircus));

                System.out.println("\nWould you like to prepare for the next circus?");
                System.out.println("\t1) Yes");
                System.out.println("\t2) No, show me the final results");

		// user input
		System.out.print("Selection: ");
                int keepPlaying = Keyboard.readInt();
		System.out.println(spacing);

		// while invalid input is chosen
                while (keepPlaying != 1 && keepPlaying != 2)
		    {
			System.out.println ("Invalid input. Please enter a valid number for selection.");
			System.out.print("Selection: ");
			keepPlaying = Keyboard.readInt();
		    }
		// if when user wants to continue the game
                if (keepPlaying == 1)
		    {
			newGame.countMoves = 4;
			newBoard.expandBoard(1);
			newBoard.reset();
			System.out.println(spacing);
		    }
                // if when user wants to stop playing
                if (keepPlaying == 2)
		    {
			newGame.gameRunning = false;
		    }
	    } // end while

	// end of game message + updates
	System.out.println("Thanks for playing!\n");
	String owned = "|";
	for (Animal someAnimal : newPlayer.getOwnedAnimals())
	    {
		owned += someAnimal.getName() + "|";
	    }
	System.out.println("Animals you owned: " + owned);
	System.out.println(newPlayer);
	System.out.println("\n");
                
                
    } // end main
} // end class
