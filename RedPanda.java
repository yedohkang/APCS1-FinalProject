public class RedPanda extends Animal{
    public RedPanda(){
	trickVal = 5;
	trick = "Swing and Slide";
	price = 20;
	appealVal = 30;
	length = 3;
	width = 4;
	shape = new int[][] {{1, 0, 0, 0},
			     {1, 1, 1, 1},
			     {0, 1, 0, 1}};
	isTrained = false;
	isOnBoard = false;
        name = "Red Panda";
    }
    public String toString(){
	String retStr = "";
	retStr += "Red Panda: \n";
	retStr += "\tA smol furry creature that likes to swing on tree branches.\n";
	retStr += "\tTrick: " + trick;
	retStr += "\n\tTrick Value: " + trickVal;
	retStr += "\n\tPrice: " + price;
	retStr += "\n\tAppeal Value: " + appealVal;
	return retStr;
    }
}
