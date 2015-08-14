package com.vengea.modtool;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.vengea.modtool.Commands.Modtool;
import com.vengea.modtool.Commands.ToggleMute;
import com.vengea.modtool.Events.OnJoinEvent;
import com.vengea.modtool.Events.PlayerChat;
import com.vengea.modtool.Events.PlayerInteract;

public class Main extends JavaPlugin implements Listener {

	
	public boolean mute;
	public String kickMessage;
		
	
	  public void onEnable()
	  {
		  
		saveDefaultConfig();
		this.kickMessage = ChatColor.translateAlternateColorCodes('&', getConfig().getString("kickmsg", "&cServer full! &f:(")).replace("&&", "&");
	    getServer().getPluginManager().registerEvents(this, this);
	    registerCommands();
	    registerEvents();
	    
	    mute = false;
	    
	    
	    
	  }
	  
		public void openMenu(Player p){ 

			
		    IconMenu menu = new IconMenu("Modtool Messages", 9*5, new IconMenu.OptionClickEventHandler() {
		        @Override
		        public void onOptionClick(IconMenu.OptionClickEvent event) {
			        	if(event.getClickedItem().getType().equals(Material.PAPER)){
			        		p.chat(event.getClickedItem().getItemMeta().getLore().toString().replaceAll("\\[", "").replaceAll("\\]", ""));

					        } else if (event.getName() .equalsIgnoreCase("ToggleMute")){
					        	Bukkit.dispatchCommand(event.getPlayer(), "togglemute");
					        	
					        }

					        event.setWillDestroy(true);
		        }
		        	
		        	
		    }, this)
		    .setOption(0, new ItemStack(Material.PAPER, 1), "Applications", "You can apply for staff here: http://pvpheroes.no/staffapp")
		    .setOption(1, new ItemStack(Material.PAPER, 1), "Spam", "Please dont spam in the chat, it may results in mute.")
		    .setOption(36, new ItemStack(Material.BARRIER, 1), "ToggleMute", "Set the chat in premium mode!");
			
		    
		    
		    
			
			menu.open(p);
		}
	
	
	public void registerCommands(){
		getCommand("modtool").setExecutor(new Modtool(this));
		getCommand("togglemute").setExecutor(new ToggleMute(this));
	}
	
	public void registerEvents(){
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(new OnJoinEvent(this), this);
		pm.registerEvents(new Modtool(this), this);
		pm.registerEvents(new PlayerInteract(this), this);
		pm.registerEvents(new PlayerChat(this), this);
	}
}
