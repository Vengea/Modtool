package com.vengea.modtool.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.vengea.modtool.Main;

public class PlayerChat implements Listener {
	public Main main;
	public PlayerChat(Main main){
		this.main = main;
	}
	@EventHandler
	public void Chat(AsyncPlayerChatEvent e) {
		Player p = (Player) e.getPlayer();
		
		if(main.mute == true) {
			if(p.hasPermission("chat.premiummode") == false){
				p.sendMessage(ChatColor.RED + "The chat is in premium mode!" + ChatColor.AQUA + " http://shop.pvpheroes.no");
				e.setCancelled(true);
			}
		}
		
		
	}

}
