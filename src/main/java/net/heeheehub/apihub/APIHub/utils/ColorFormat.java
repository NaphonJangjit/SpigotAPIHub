package net.heeheehub.apihub.APIHub.utils;

import org.bukkit.ChatColor;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

public class ColorFormat {

	private static final MiniMessage MINI_MESSAGE = MiniMessage.miniMessage();
    private static final LegacyComponentSerializer LEGACY_AMP = LegacyComponentSerializer.legacyAmpersand();
	
    public static String format(String input) {
    	Component component = LegacyComponentSerializer.legacyAmpersand().deserialize(input);
        return LegacyComponentSerializer.legacySection().serialize(component);
    }
    
    public static Component format2(String str){
        Component component = LEGACY_AMP.deserialize(str);
        
        String miniMsgFormat = MINI_MESSAGE.serialize(component);
        
        Component c2 = MINI_MESSAGE.deserialize(miniMsgFormat);
        
        return c2;
        
    }
}
