public class MyDate{
    public int month;

    @Override
    public boolean equals (Object dt){
        if (dt == null || !(dt instanceof MyDate))
        {
            return false;
        }
        MyDate other = (MyDate) dt;
        return (other.month == this.month);
    }
}