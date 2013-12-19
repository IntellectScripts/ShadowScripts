import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import org.shadowbot.bot.api.Manifest;
import org.shadowbot.bot.api.ShadowScript;
import org.shadowbot.bot.api.SkillCategory;
import org.shadowbot.bot.api.listeners.PaintListener;
import org.shadowbot.bot.api.methods.data.Calculations;
import org.shadowbot.bot.api.methods.data.Inventory;
import org.shadowbot.bot.api.methods.data.Skills;
import org.shadowbot.bot.api.methods.data.Skills.Skill;
import org.shadowbot.bot.api.methods.data.movement.Camera;
import org.shadowbot.bot.api.methods.data.movement.Walking;
import org.shadowbot.bot.api.methods.interactive.GroundItems;
import org.shadowbot.bot.api.methods.interactive.NPCs;
import org.shadowbot.bot.api.methods.interactive.Players;
import org.shadowbot.bot.api.util.Time;
import org.shadowbot.bot.api.util.Timer;
import org.shadowbot.bot.api.wrapper.GroundItem;
import org.shadowbot.bot.api.wrapper.Item;
import org.shadowbot.bot.api.wrapper.NPC;

@Manifest(author = "Intellect", category = SkillCategory.COMBAT, description = "Fights stuff", scriptName = "Intelligent Fighter")
public class Fighter extends ShadowScript implements PaintListener {

	private int startExp;
	private long startTime;
	private String status = "Starting Up...";
	IGUI g = new IGUI();
	private final Color color1 = new Color(255, 0, 0);
	private final Color color2 = new Color(153, 153, 153);
	private final Color color3 = new Color(0, 0, 0);

	private final Font font1 = new Font("Arial Black", 1, 32);
	private final Font font2 = new Font("Arial Black", 1, 14);

	@Override
	public void onStart() {
		startExp = Util.getCombatExperience();
		startTime = System.currentTimeMillis();
		g.setVisible(true);
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub

	}

	
	@Override
	public int operate() {
		if (Players.getLocal().getHealthPercent() <= 50) {
			Item food = Inventory.getItem(Util.foodID);
			if (food != null) {
				status = "Eating Food...";
				food.interact("Eat");
				Timer t = new Timer(1500);
				while (t.isRunning() && food != null)
					Time.sleep(50);
			}
		}else if(GroundItems.getNearest(Util.loot) != null && GroundItems.getNearest(Util.loot).getLocation().canReach() && !Inventory.isFull()){
			GroundItem gi = GroundItems.getNearest(Util.loot);
			if(gi != null ){
				if(Calculations.distanceTo(gi) < 10){
					if(gi.isOnScreen()){
						status = "Looting " + gi.getName() + "...";
						if(gi.interact("Take", gi.getName())){
							Timer l = new Timer(2500);
							while(gi != null && l.isRunning())
								Time.sleep(50);
						}
					}else{
						status = "Turning Camera...";
						Camera.turnTo(gi);
					}
				}else{
					status = "Walking To " + gi.getName() + "...";
					Walking.walkTo(gi);
				}
			}
		}else if (!Players.getLocal().isInCombat()) {
		
			NPC goblin = NPCs.getNearest(Util.npcFilter);
			if (goblin != null) {
				if (Calculations.distanceTo(goblin) < 10) {
					if (goblin.isOnScreen()) {
						status = "Attacking " + Util.monsterName  + "...";
						if (goblin.interact("Attack")) {
							Timer c = new Timer(2500);
							while (c.isRunning()
									&& !Players.getLocal().isInCombat())
								Time.sleep(50);
						}
					} else {
						status = "Turning Camera...";
						Camera.turnTo(goblin);
					}
				} else
					status = "Walking...";
				Walking.walkTo(goblin);
			} else
				status = "Waiting For Spawn...";
		} else
			status = "Fighting...";
		
		return 200;
	}

	@Override
	public void render(Graphics g1) {
		int expGained = (Util.getCombatExperience() - startExp);
		Graphics2D g = (Graphics2D) g1;
		g.setFont(font1);
		g.setColor(color1);
		g.drawString("Intelligent Fighter", 103, 334);
		g.setColor(color2);
		g.fillRoundRect(5, 341, 513, 137, 16, 16);
		g.setFont(font2);
		g.setColor(color3);
		g.drawString("Exp/Hour: " + Util.perHour(expGained, startTime), 14, 421);
		g.drawString("Status: " + status, 15, 456);
		g.drawString("Exp Gained: " + expGained, 14, 402);
		g.drawString(
				"Time Running: "
						+ Time.parse(System.currentTimeMillis() - startTime),
				14, 372);
		Util.drawWave(g, color1);

	}
}
