import java.util.*; 
public class KillerRabbit extends Cat{
    int rabbitMoves;
    int movesSinceEaten; 

    //Constructor for the Rabbit Class
    public KillerRabbit(int x, int y, City cty, Random rnd)
    {
        super(x, y, cty, rnd);
        this.lab = LAB_MAGENTA;
        this.stepLen = 4;
    }

    public void takeAction()
    {
        //Die after 40 rounds of simulation time, or after 20 moves without having eaten. 
        if(this.rabbitMoves % 40 == 0 || this.movesSinceEaten == 20) 
        {
            this.dead = true; 
        }

        /*If a rabbit lands on the same grid point as any other creature, it will eat it.*/
        int x1 = this.getX();
        int y1 = this.getY();

        //Get a list of all the creatures 
        List<Creature> creatures = city.getCreatureList(); 

        //Parse through and see if any share location 
        for(Creature c : creatures)
        {
            if((c.getX() == x1) && (c.getY() == y1))
            {
                if(c instanceof Mouse || c instanceof Cat || c instanceof ZombieCat)
                {
                    movesSinceEaten = 0; 
                    city.addKillerRabbit();
                    city.addKillerRabbit();
                    city.addKillerRabbit();
                }
            }   

        }
        Creature closest = this.search(); 
        if(closest != null && (closest instanceof Mouse || closest instanceof Cat || closest instanceof ZombieCat))
        {
            this.setDir(closest.getDir()); 
            this.step(this.getDir());
            this.rabbitMoves++; 
            movesSinceEaten++; 
        }
        else
        {
            this.randomTurn();
            this.step(this.getDir());
            this.rabbitMoves++; 
            movesSinceEaten++; 
        }
    
    }

    public Creature search()
    {
        //If creature is 20 points north, south, east, or west, return true

        //get a list of all of the creatures 
        List<Creature> creatures = city.getCreatureList();
        Creature closest = null; 
        int closestDist = 20;
        //parse through and see if any are within 20 points of the cat 
        for(Creature c : creatures)
        {
            if (this.point.dist(c.point) <= 20 && this.point.dist(c.point) <= closestDist)
            {
                this.lab = LAB_ORANGE;
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

    //Create a 10% chance that the rabbit will turn in a random direction. 
    public void randomTurn()
    {
        if(rand.nextInt(10) == 1)
        {
            this.setDir(rand.nextInt(4)); 
        }
    }

}
