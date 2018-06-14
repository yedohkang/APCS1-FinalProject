import java.util.ArrayList;

public class Player
{
    private String name;
    private int currentFunds;
    private int amtFame;
    private ArrayList<Animal> ownedAnimals;
    private ArrayList<Integer> trickVal; // ArrayList of trick values of ONLY the animals owned
    private ArrayList<Integer> appealVal; // ArrayList of appeal values of ONLY the animals owned

    public Player(String n)
    {
	ownedAnimals = new ArrayList<Animal>();
	trickVal = new ArrayList<Integer>();
	appealVal = new ArrayList<Integer>();
	currentFunds = 400;
	amtFame = 0;
	name = n;
    }

    // returns current status of player's funds
    public String toString()
    {
	String retStr = "";
	retStr += "Your current funds: $" + currentFunds + "\n";
	retStr += "Your fame: " + amtFame + " points";
	return retStr;
    }

    // returns updated status of player's funds
    public String newBalance(Circus c)
    {
	currentFunds += c.getAmtEarned();
	amtFame += c.getFameGained();
	String ret = "Updated Funds: $" + currentFunds;
	ret += "\nUpdated Fame: " + amtFame;
	return ret;
    }
	
    public boolean buyAnimal(Animal someAnimal)
    {
	if (currentFunds < someAnimal.getPrice()) {
	    System.out.println("You do not have enough money to complete the transaction.");
            return false;
	}
	else {
	    // add animal to the ArrayList ownedAnimals
	    ownedAnimals.add(someAnimal);
	    // update funds
	    currentFunds -= someAnimal.getPrice();
	    System.out.println("\nYou just bought a " + someAnimal.getName() + "!");
	    System.out.println("You currently have $" + currentFunds + " left.");
	    // add the animal's trick value and appeal value to each ArrayList
	    trickVal.add(someAnimal.getTrickVal());
	    appealVal.add(someAnimal.getAppealVal());
            return true;
	}
    }

    // returns owned animals
    public String listOwnedAnimals()
    {
	String retStr = "";
        
	for (int x = 0; x < ownedAnimals.size(); x += 1)
	    {
		if (ownedAnimals.get(x).isTrained) {
		    retStr += "\t" + (x + 1) + ") " + ownedAnimals.get(x).name + "\t#ALREADY TRAINED#" + "\n";

		}
		else {
		    retStr += "\t" + (x + 1) + ") " + ownedAnimals.get(x).name + "\n";
                   
		}

	    }
	return retStr.substring(0, retStr.length() - 1);
    }

    // attempts to train an animal
    public int trainAnimal(Animal someAnimal)
    {
	if (someAnimal.getIsTrained())
	    {
		System.out.println("This animal is already trained.");
		return 0;
	    }
	else
	    {
		someAnimal.train();
		return 1;
	    }
    }

    // get methods
    public ArrayList<Integer> getTrickVal()
    {
	return trickVal;
    }
    public ArrayList<Integer> getAppealVal()
    {
	return appealVal;
    }

    public ArrayList<Animal> getOwnedAnimals()
    {
	return ownedAnimals;
    }
	
    public String getName() {
	return name;
    }

}
