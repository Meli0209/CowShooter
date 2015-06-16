import org.bukkit.World;
import org.bukkit.entity.Cow;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Meli on 16.06.2015.
 */

public class CowTask extends BukkitRunnable {

    private World w;
    private Cow c;

    public CowTask(World myWorld, Cow myCow){
        c = myCow;
        w = myWorld;

    }

    public void run(){
        //check if cow on ground
            //create explosion
        // w.getExplosion
            //call cancel();
        //else (not grounded)
            //set fire ticks
            // set the cows health to maximum

    }

}
