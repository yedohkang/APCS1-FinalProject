public class Giraffe extends Animal{
    public Giraffe(){
	trickVal = 20;
	trick = "Skateboarding while Hula Hooping";
	price = 80;
	appealVal = 120;
	length = 5;
	width = 4;
	shape = new int[][] {{1, 1, 0, 0},
			     {0, 1, 0, 0},
			     {0, 1, 1, 1},
			     {0, 1, 1, 1},
			     {0, 1, 0, 1}};
	isTrained = false;
	isOnBoard = false;
        name = "Giraffe";
    }
    public String toString(){
	String retStr = "";
	retStr += "Giraffe: \n";
	retStr += "\tA tol friendly creature that has a purple sticky tongue.\n";
	retStr += "\tTrick: " + trick;
	retStr += "\n\tTrick Value: " + trickVal;
	retStr += "\n\tPrice: " + price;
	retStr += "\n\tAppeal Value: " + appealVal;
	return retStr;
    }
}
