import java.util.*; 

public class ZombieCat extends Cat
{
    int zombieCatMoves; 
    int movesSinceEaten; 
    public ZombieCat(int x, int y, City cty, Random rnd)
    {
        super(x, y, cty, rnd);
        this.lab = LAB_RED;
        this.stepLen = 3;
    }

    public void takeAction()
    {
        //If 100 moves have gone by and the ZombieCat has not eaten, set dead = true
        if(movesSinceEaten == 100)
        {
            dead = true; 
        }
        
        //check for creatures that are in the same location as the zombie cat. 
        //if the location of the zombie cat + the creature match, eat the creature. 
        int x1 = this.getX();
        int y1 = this.getY();

        //get a list of all of the creatures 
        List<Creature> creatures = city.getCreatureList();
        
        //parse through and see if any share the location of the ZombieCat. 
        for(Creature c : creatures)
        {
            if((c.getX() == x1) && (c.getY() == y1))
            {
                //Eat the creatures if they share a location
                if(c instanceof Mouse || c instanceof Cat)
                {
                    movesSinceEaten = 0; 
                }

                if(c instanceof KillerRabbit)
                {
                    dead = true; 
                }
                
                //If the ZombieCat eats a Cat, the Cat should turn into a ZombieCat 
                if(c instanceof Cat)
                {
                    this.city.addZombieCat(); 
                }
            }
        }

    

        //Find the closest Creature within 20 points and chase it 
        Creature closest = this.search(); 
        if(closest != null)
        {
            this.setDir(closest.getDir()); 
            this.step(this.getDir());
            this.zombieCatMoves++; 
            movesSinceEaten++; 
        }
        else
        {
            this.randomTurn();
            this.step(this.getDir());
            this.zombieCatMoves++; 
            movesSinceEaten++; 
        }
    }

    public Creature search()
    {
        //If creature is 40 points north, south, east, or west, return true

        //get a list of all of the creatures 
        List<Creature> creatures = city.getCreatureList();
        Creature closest = null; 
        int closestDist = 40;
        //parse through and see if any are within 20 points of the cat 
        for(Creature c : creatures)
        {
            if(c instanceof Mouse && this.point.dist(c.point) <= 40 && this.point.dist(c.point) <= closestDist)
            {
                this.lab = LAB_BLACK;
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
