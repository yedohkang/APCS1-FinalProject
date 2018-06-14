public abstract class Animal
{
    protected int trickVal; // trick value
    protected String trick;
    protected int price;
    protected int appealVal; // appeal value
    protected int length;
    protected int width;
    protected int[][] shape; // 2D array shape of animal
    protected boolean isTrained; // keeps track of training
    protected String name;
    protected boolean isOnBoard; // keeps track of being on gameBoard

    // get methods
    public int getTrickVal()
    {
	return trickVal;
    }
    public String getTrick()
    {
	return trick;
    }
    public int getPrice()
    {
	return price;
    }
    public int getAppealVal()
    {
	return appealVal;
    }
    public int getLength()
    {
	return length;
    }
    public int getWidth()
    {
	return width;
    }
    public int[][] getShape()
    {
	return shape;
    }
    public boolean getIsTrained()
    {
        return isTrained;
    }
    public boolean getIsOnBoard(){
	return isOnBoard;
    }

    // set methods
    public boolean train(){
	isTrained = true;
	return isTrained;
    }

    public String getName() {
	return name;
    }
    public boolean putOnBoard(){
	isOnBoard = true;
	return isOnBoard;
    }
    public boolean removeOffBoard(){
	isOnBoard = false;
	return isOnBoard;
    }

    // returns info about the animal, different for each
    public abstract String toString();

}
