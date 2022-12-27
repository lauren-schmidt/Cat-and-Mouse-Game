import java.util.List;
import java.util.Random;

public class Mouse extends Creature
{
    int mouseMoves;
    //Constructor for the Mouse class. Sets color to blue.
    public Mouse(int x, int y, City cty, Random rnd)
    {
        super(x, y, cty, rnd);
        this.lab = LAB_BLUE;
    }


    public void takeAction()
    {
        //Create a new baby mouse at the same location after 20 rounds of simulation time. 
        if(this.mouseMoves % 20 == 0)
        {
            this.city.addMouse(); 
        }
        //Die after 30 rounds of simulation time. 
        if(this.mouseMoves % 30 == 0)
        {
            this.dead = true; 
        }

        //Make a random turn, step in that direction, and increment mouseMoves once per round. 
        this.randomTurn();
        this.step(this.getDir()); 
        this.mouseMoves++; 
        

        /* If a mouse gets eaten by a Cat, it will die. */
        int x1 = this.getX();
        int y1 = this.getY();


        //get a list of all of the creatures 
        List<Creature> creatures = city.getCreatureList();
        
        //Parse through and see if any share the location of the Cat, ZombieCat, or KillerRabbit. 
        //If they share a location, set equal to true 
        for(Creature c : creatures)
        {
            if((c.getX() == x1) && (c.getY() == y1))
            {
                if(c instanceof Cat || c instanceof ZombieCat || c instanceof KillerRabbit)
                {
                    dead = true; 
                }
            }
        }
        
    }

    //Method for the Creature to step based on its stepLen
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

    //Create a 20% chance that the mouse will turn in a random direction. 
    public void randomTurn()
    {
        if(rand.nextInt(5) == 0)
        {
            this.setDir(rand.nextInt(4)); 
        }
    }
}
