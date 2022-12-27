import java.util.*;

public class Cat extends Creature
{
    int catMoves;
    int movesSinceEaten; 

    //Constructor for the Cat class.
    public Cat(int x, int y, City cty, Random rnd)
    {
        super(x, y, cty, rnd);
        this.lab = LAB_YELLOW; 
        this.stepLen = 2; 
    }

    public void takeAction()
    {
        //If the cat has not eaten in 50 moves, it should turn into a ZombieCat. 
        if(movesSinceEaten == 50)
        {
            this.city.addZombieCat();
        }
        
        //Check for creatures that are in the same location as the cat. 
        //if the location of the cat + the creature match, AND the creature is a mouse, eat the mouse. 
        int x1 = this.getX();
        int y1 = this.getY();

        //get a list of all of the creatures 
        List<Creature> creatures = city.getCreatureList();
        
        //parse through and see if any share the location of the Cat. If they share location AND they are a mouse, eat the mouse. 
        for(Creature c : creatures)
        {
            if((c.getX() == x1) && (c.getY() == y1))
            {
                if(c instanceof Mouse)
                {
                    movesSinceEaten = 0; 
                }
                
                //If sharing location with a ZombieCat or KillerRabbit, die. 
                if(c instanceof ZombieCat || c instanceof KillerRabbit)
                {
                    dead = true; 
                }
            }
        }

        //Find the closest mouse within 20 points and chase it 
        Creature closest = this.search(); 
        if(closest != null && closest instanceof Mouse)
        {
            this.setDir(closest.getDir()); 
            this.step(this.getDir());
            this.catMoves++; 
            movesSinceEaten++; 
        }
        else
        {
            this.randomTurn();
            this.step(this.getDir());
            this.catMoves++; 
            movesSinceEaten++; 
        }



        
    }

    public Creature search()
    {
        //If mouse is 20 points north, south, east, or west, return true

        //get a list of all of the creatures 
        List<Creature> creatures = city.getCreatureList();
        Creature closest = null; 
        int closestDist = 20;
        //parse through and see if any are within 20 points of the cat 
        for(Creature c : creatures)
        {
            //We have found a mouse and should turn Cyan so we can search for it. 
            if(c instanceof Mouse && this.point.dist(c.point) <= 20 && this.point.dist(c.point) <= closestDist)
            {
                this.lab = LAB_CYAN;
                closest = c; 
            }
    }

    return closest; 
}

    public void step(int dir)
    {
    this.setX(this.getX() + (dirX[dir] * this.stepLen));   
    if(this.getX() >= 80)
    {
        this.setX(this.getX() % 80); 
    }

    this.setY(this.getY() + (dirY[dir] * this.stepLen)); 
    if(this.getY() >= 80)
    {
        this.setY(this.getY() % 80); 
    }
    }

    public void randomTurn()
    {
        if(rand.nextInt(20) == 1)
        {
            this.setDir(rand.nextInt(4));
        }
    }

}
