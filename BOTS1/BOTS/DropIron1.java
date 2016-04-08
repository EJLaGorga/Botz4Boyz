
import org.powerbot.script.rt4.*;

public class DropIron1 extends Task<ClientContext>
{
    private int ironId = 440;
    
    public DropIron1(ClientContext ctx)
    {
        super(ctx);
    }
    
    @Override
    public boolean activate() 
    {
        return ctx.backpack.select().count() == 28;
    }
    
    @Override
    public void execute()
    {
        for (Item i : ctx.backpack.id(ironId))
        {
            i.interact("Drop");
        }
    }
}