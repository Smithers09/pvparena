package net.slipcor.pvparena.api;

import java.util.HashSet;
import java.util.Set;

import net.slipcor.pvparena.arena.Arena;
import net.slipcor.pvparena.arena.ArenaPlayer;
import net.slipcor.pvparena.classes.PABlockLocation;
import net.slipcor.pvparena.core.Debug;
import net.slipcor.pvparena.managers.ArenaManager;

import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * <pre>
 * API class
 * </pre>
 * 
 * provides import lightweight access to PVP Arena methods
 * 
 * @author slipcor
 * 
 * @version v0.10.2
 */

public final class PVPArenaAPI {
	private final static Debug DEBUG = new Debug(2);
	
	private PVPArenaAPI() {
	}

	/**
	 * get the arena a player is in (fighting or spectating)
	 * 
	 * @param player
	 *            the player to check
	 * @return the arena name if part of an arena, "" otherwise
	 */
	public static String getArenaName(final Player player) {
		if (!Debug.override) {
			DEBUG.i("API: get arena of player: " + player.getName(), player);
		}
		final Arena arena = ArenaPlayer.parsePlayer(player.getName()).getArena();
		return (arena == null) ? "" : arena.getName();
	}

	/**
	 * get the arena a location is in
	 * 
	 * @param location
	 *            the location to check
	 * @return the arena name if part of an arena, "" otherwise
	 */
	public static String getArenaNameByLocation(final Location location) {
		if (!Debug.override) {
			DEBUG.i("API: get arena of location: " + location.toString());
		}
		final Arena arena = ArenaManager.getArenaByRegionLocation(new PABlockLocation(location));
		return (arena == null) ? "" : arena.getName();
	}

	/**
	 * get the arenas a location is in
	 * 
	 * @param location
	 *            the location to check
	 * @return the arena name if part of an arena, "" otherwise
	 */
	public static Set<String> getArenaNamesByLocation(final Location location) {
		if (!Debug.override) {
			DEBUG.i("API: get arena of location: " + location.toString());
		}
		final Set<Arena> arenas = ArenaManager
				.getArenasByRegionLocation(new PABlockLocation(location));

		final Set<String> result = new HashSet<String>();

		for (Arena a : arenas) {
			result.add(a.getName());
		}

		return result;
	}
}
