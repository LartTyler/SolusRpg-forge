package me.dbstudios.solusrpg;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

@Mod(modid = SolusRpgMod.MOD_ID, name = SolusRpgMod.MOD_NAME, version = SolusRpgMod.MOD_VERSION)
public class SolusRpgMod {
	public static final String MOD_ID = "me.dbstudios.solusrpg";
	public static final String MOD_NAME = "SolusRpg";
	public static final String MOD_VERSION = "0.1.0";
	public static final String MOD_CLIENT_PROXY = "me.dbstudios.solusrpg.client.ClientProxy";
	public static final String MOD_SERVER_PROXY = "me.dbstudios.solusrpg.CommonProxy";

	private static File configDir;

	@Instance(value = SolusRpgMod.MOD_ID)
	public static SolusRpgMod instance;

	@SidedProxy(clientSide = SolusRpgMod.MOD_CLIENT_PROXY, serverSide = SolusRpgMod.MOD_SERVER_PROXY)
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		configDir = new File(event.getModConfigurationDirectory(), "SolusRpg");

		configDir.mkdirs();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	public static File getConfigDir() {
		return configDir;
	}
}