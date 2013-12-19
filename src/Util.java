import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import org.shadowbot.bot.api.methods.data.Skills;
import org.shadowbot.bot.api.methods.data.Skills.Skill;
import org.shadowbot.bot.api.methods.input.Mouse;
import org.shadowbot.bot.api.util.Filter;
import org.shadowbot.bot.api.wrapper.NPC;


public class Util {

	public static int getCombatExperience(){
		return (Skills.getExperience(Skill.ATTACK)
				+ Skills.getExperience(Skill.STRENGTH)
				+ Skills.getExperience(Skill.DEFENSE)
				+ Skills.getExperience(Skill.CONSTITUTION)
				+ Skills.getExperience(Skill.SLAYER)
				+ Skills.getExperience(Skill.MAGIC) + Skills.getExperience(Skill.RANGE));
	}
	
	public static int perHour(int i, long startTime) {
		return (int) ((i) * 3600000D / (System.currentTimeMillis() - startTime));
	}
	
	public static String monsterName = "Unknown";
	public static int foodID = -1;
	public static int[] loot = {};
	
	public static Filter<NPC> npcFilter = new Filter<NPC>(){

		@Override
		public boolean accept(NPC n) {
			return !n.isMoving() && n.getName().equals(Util.monsterName) && n.getLocation().canReach();
		}
		
	};
	
	
	
	public static void drawWave(Graphics g, Color color) {
		int waveSize = 0;
		Graphics2D g2 = (Graphics2D) g;
		Point MouseLoc = new Point(Mouse.getPressX(), Mouse.getPressY());
		long mpt = System.currentTimeMillis() - Mouse.getPressTime();
		g2.setRenderingHints(new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON));
		g2.setColor(color);
		if (mpt < 600) {
			waveSize = (int) (mpt / 7.5);
		} else {
			waveSize = 0;
		}
		g2.setStroke(new BasicStroke(1));
		g2.drawOval(MouseLoc.x - (waveSize / 2), MouseLoc.y
				- (waveSize / 2), waveSize, waveSize);
		g2.drawOval(MouseLoc.x - ((waveSize / 2) / 2), MouseLoc.y
				- ((waveSize / 2) / 2), waveSize / 2, waveSize / 2);
	}

	
	
	
	
}
