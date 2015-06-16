import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

/**
 * Created by Student on 16.06.2015.
 */
public class CowShooterListener implements Listener {

    private JavaPlugin plugin;

    public CowShooterListener(JavaPlugin myPlugin){
        plugin = myPlugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        //if air or block clicked
        if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {

            // get interacting player from event
            Player p = event.getPlayer();

            //leather in hand
            if (p.getItemInHand().getType() == Material.LEATHER) {

                // get players location, get direction vector
                // multiply direction with factor
                Location loc = p.getLocation();
                Vector v = loc.getDirection().multiply(3);


                // spawn cow
                Cow c = p.getWorld().spawn(loc,Cow.class);

                // set the cows velocity to our calculated direction
                c.setVelocity(v);

                //let the cow burn for 20 seconds
                c.setFireTicks(100);

                // check if cow lands on ground and explode
                // create and start cow task
                BukkitRunnable task = new CowTask(p.getWorld(),c);

                task.runTaskTimer(plugin,0L,0L);

            }
        }
    }


}
