import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * Created by Meli on 16.06.2015.
 */
public class CowShooter extends JavaPlugin{
    public static Logger log = Logger.getLogger("Minecraft");

    public void onEnable() {
        log.info("[CowShooter] enabling ...");
        getServer().getPluginManager().registerEvents(new CowShooterListener(),this);
    }
}