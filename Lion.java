public class Lion extends Animal{
    public Lion(){
	trickVal = 30;
	trick = "Jumping through a Fiery Ring";
	price = 120;
	appealVal = 180;
	length = 6;
	width = 4;
	shape = new int[][] {{1, 1, 0, 0},
			     {1, 1, 0, 0},
			     {1, 1, 1, 1},
			     {1, 1, 1, 1},
			     {1, 0, 1, 0},
			     {1, 0, 1, 0}};
	isTrained = false;
	isOnBoard = false;
        name = "Lion";
    }
    public String toString(){
	String retStr = "";
	retStr += "Lion: \n";
	retStr += "\tA hooge furry creature that likes to lick people.\n";
	retStr += "\tTrick: " + trick;
	retStr += "\n\tTrick Value: " + trickVal;
	retStr += "\n\tPrice: " + price;
	retStr += "\n\tAppeal Value: " + appealVal;
	return retStr;
    }

}
