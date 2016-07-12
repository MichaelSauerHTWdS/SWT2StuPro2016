package hanse.kontor2016.kaufmann;


/**
  * Class Konto
  * 
  * @author Zilch Daniel
  * @author Marx Armin
  */
  

public class Konto
{
    private double betrag;
    
    public Konto()
    {
        betrag = 0.0;
    }
    
    
    public double kontostand () { return betrag; }
    
    public boolean einzahlen ( double z )
    {
        boolean isDone = false;
        
        if ( z >= 0 )
        {
            betrag += z;
            isDone = true;
        }
        
        return isDone;
    }
    
    public boolean auszahlen ( double z )
    {
        boolean isDone = false;
        
        if ( betrag > 0 )
        {
            if ( betrag > z )
            {
                if ( z >= 0 )
                {
                    betrag -= z;
                    isDone = true;
                }
            }
        }
        
        return isDone;
    }
    
}

