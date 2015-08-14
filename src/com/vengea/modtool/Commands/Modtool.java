package com.vengea.modtool.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import com.vengea.modtool.Main;

public class Modtool implements CommandExecutor, Listener {
	public Main main;
	public Modtool(Main main){
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, 
			String[] args) {
		Player p = (Player) sender;
		if (p.hasPermission("modtool.access")){
			
			main.openMenu(p);
			
			return true;
		}
		 return false;

	}
	
	



}
