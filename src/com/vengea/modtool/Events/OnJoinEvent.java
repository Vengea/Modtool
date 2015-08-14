package com.vengea.modtool.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.vengea.modtool.Main;


public class OnJoinEvent implements Listener {
	public Main main;
	public OnJoinEvent(Main main){
		this.main = main;
	}

		@EventHandler
		public void onJoinEvent(PlayerJoinEvent e){
		
			Player p = e.getPlayer();
			if(p.hasPermission("modtool.access")){
				
			   Bukkit.getScheduler().runTaskLater(main, new Runnable(){
				   public void run() {
					   ItemStack modtool = new ItemStack(Material.PAPER, 1);
					   ItemMeta modmeta = modtool.getItemMeta();
					   modmeta.setDisplayName(ChatColor.RED + "Moderator Tool");
					   modtool.setItemMeta(modmeta);
					   p.getInventory().setItem(7, modtool);
				   }
			   }, 35L);	
			}
	
		}
		 @EventHandler(priority=EventPriority.HIGHEST)
		  public void onLogin(PlayerLoginEvent event)
		  {
		    if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
		      if (event.getPlayer().hasPermission("fullserver.bypass")) {
		        event.allow();
		      } else {
		        event.setKickMessage(main.kickMessage);
		      }
		    }
		  }
		
}