package com.vengea.modtool.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.vengea.modtool.Main;

public class PlayerInteract implements Listener {
	public Main main;
	public PlayerInteract(Main main){
		this.main = main;
	}

	
	@EventHandler
	public void playerInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();	
		if(p.hasPermission("modtool.access")){
			if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)){
				if(p.getItemInHand().getType().equals(Material.PAPER)){
				   main.openMenu(p);	
				}
			}
		}
		

	}
}
