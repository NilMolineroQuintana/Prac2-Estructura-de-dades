// Codi fet per Guillem Alcoverro i Nil Molinero

public class MyDate{
    public int month;

    public MyDate(int m){
        this.month = m;
    }

    @Override
    public boolean equals (Object dt){
        if (dt == null || !(dt instanceof MyDate)) // Es necesari comprovar si es tracta del mateix objecte o algún descendent seu per poder-ho comparar o que no sigui null
        {
            return false;
        }
        return (((MyDate) dt).month == this.month);
    }
}

// Codi fet per Guillem Alcoverro i Nil Molinero