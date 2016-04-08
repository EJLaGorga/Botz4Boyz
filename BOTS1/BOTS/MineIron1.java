
import org.powerbot.script.rt4.*;

public class MineIron1 extends Task<ClientContext>
{
    private int[] ironIds = {11954,11955,11956,2092,2093,14900,14901,14913,14914};
    
    public MineIron1(ClientContext ctx)
    {
        super(ctx);
    }
    
    @Override
    public boolean activate() 
    {
        return ctx.backpack.select().count() < 28
                && !ctx.objects.select().id(ironIds).isEmpty()
                && ctx.players.local().animation() == -1;
    }
    
    @Override
    public void execute()
    {
        GameObject iron = ctx.objects.id(ironIds).nearest().poll();
        if(iron.inViewport())
        {
            iron.interact("Mine");
        }
        else
        {
            ctx.movement.step(iron);
            ctx.camera.turnTo(iron);
        }
    }
}
