import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/*
 * Created by JFormDesigner on Thu Dec 19 00:16:04 EST 2013
 */

/**
 * @author dad scripts
 */
public class IGUI extends JFrame {
	public IGUI() {
		initComponents();
	}

	private void itemBoxActionPerformed(ActionEvent e) {
		if (itemBox.isSelected())
			itemField.setEnabled(true);
		else
			itemField.setEnabled(false);

	}

	private void startButtonActionPerformed(ActionEvent e) {
		Util.monsterName = npcField.getText().toString();
		Util.foodID = Integer.parseInt(foodField.getText().toString());
		if (itemBox.isSelected()) {
			String loots = itemField.getText().toString().trim();
			String[] split = loots.split(",");
			Util.loot = new int[split.length];
			for (int i = 0; i < split.length; i++) {
				Util.loot[i] = Integer.parseInt(split[i]);
			}
		}

		this.dispose();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - dad scripts
		label1 = new JLabel();
		label2 = new JLabel();
		npcField = new JTextField();
		label3 = new JLabel();
		foodField = new JTextField();
		label4 = new JLabel();
		label5 = new JLabel();
		itemBox = new JCheckBox();
		itemField = new JTextField();
		label6 = new JLabel();
		startButton = new JButton();

		// ======== this ========
		Container contentPane = getContentPane();

		// ---- label1 ----
		label1.setText("Intelligent Fighter");
		label1.setFont(label1.getFont().deriveFont(
				label1.getFont().getStyle() | Font.BOLD,
				label1.getFont().getSize() + 20f));
		label1.setForeground(Color.red);

		// ---- label2 ----
		label2.setText("NPC to attack:");
		label2.setFont(label2.getFont().deriveFont(
				label2.getFont().getStyle() | Font.BOLD,
				label2.getFont().getSize() + 2f));

		// ---- label3 ----
		label3.setText("Food ID:");
		label3.setFont(label3.getFont().deriveFont(
				label3.getFont().getStyle() | Font.BOLD,
				label3.getFont().getSize() + 2f));

		// ---- label4 ----
		label4.setText("(Debug>>Inventory)");

		// ---- label5 ----
		label5.setText("ie. Goblin");

		// ---- itemBox ----
		itemBox.setText("Loot Items");
		itemBox.setFont(itemBox.getFont().deriveFont(
				itemBox.getFont().getStyle() | Font.BOLD,
				itemBox.getFont().getSize() + 2f));
		itemBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				itemBoxActionPerformed(e);
			}
		});

		// ---- itemField ----
		itemField.setEnabled(false);

		// ---- label6 ----
		label6.setText("(sperate by commas ie. 324,4325,7632)");

		// ---- startButton ----
		startButton.setText("Start");
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startButtonActionPerformed(e);
			}
		});

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout
				.setHorizontalGroup(contentPaneLayout
						.createParallelGroup()
						.addGroup(
								contentPaneLayout
										.createSequentialGroup()
										.addGroup(
												contentPaneLayout
														.createParallelGroup()
														.addGroup(
																contentPaneLayout
																		.createSequentialGroup()
																		.addGap(20,
																				20,
																				20)
																		.addComponent(
																				label1,
																				GroupLayout.PREFERRED_SIZE,
																				308,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																contentPaneLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				contentPaneLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(
																								label3,
																								GroupLayout.Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								103,
																								Short.MAX_VALUE)
																						.addComponent(
																								label2,
																								GroupLayout.Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								103,
																								Short.MAX_VALUE)
																						.addComponent(
																								itemBox,
																								GroupLayout.DEFAULT_SIZE,
																								103,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				contentPaneLayout
																						.createParallelGroup()
																						.addGroup(
																								contentPaneLayout
																										.createSequentialGroup()
																										.addGroup(
																												contentPaneLayout
																														.createParallelGroup(
																																GroupLayout.Alignment.LEADING,
																																false)
																														.addComponent(
																																npcField,
																																GroupLayout.DEFAULT_SIZE,
																																104,
																																Short.MAX_VALUE)
																														.addComponent(
																																foodField,
																																GroupLayout.DEFAULT_SIZE,
																																104,
																																Short.MAX_VALUE))
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.RELATED)
																										.addGroup(
																												contentPaneLayout
																														.createParallelGroup()
																														.addComponent(
																																label4,
																																GroupLayout.PREFERRED_SIZE,
																																127,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																label5,
																																GroupLayout.PREFERRED_SIZE,
																																49,
																																GroupLayout.PREFERRED_SIZE)))
																						.addGroup(
																								contentPaneLayout
																										.createParallelGroup(
																												GroupLayout.Alignment.TRAILING,
																												false)
																										.addComponent(
																												label6,
																												GroupLayout.Alignment.LEADING,
																												GroupLayout.DEFAULT_SIZE,
																												161,
																												Short.MAX_VALUE)
																										.addComponent(
																												itemField,
																												GroupLayout.Alignment.LEADING,
																												GroupLayout.DEFAULT_SIZE,
																												161,
																												Short.MAX_VALUE))))
														.addGroup(
																contentPaneLayout
																		.createSequentialGroup()
																		.addGap(141,
																				141,
																				141)
																		.addComponent(
																				startButton)))
										.addContainerGap(30, Short.MAX_VALUE)));
		contentPaneLayout
				.setVerticalGroup(contentPaneLayout
						.createParallelGroup()
						.addGroup(
								contentPaneLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(label1)
										.addGap(25, 25, 25)
										.addGroup(
												contentPaneLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(label2)
														.addComponent(
																npcField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label5))
										.addGap(32, 32, 32)
										.addGroup(
												contentPaneLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(label3)
														.addComponent(
																foodField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label4))
										.addGap(26, 26, 26)
										.addGroup(
												contentPaneLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(itemBox)
														.addComponent(
																itemField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(label6)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED,
												45, Short.MAX_VALUE)
										.addComponent(startButton)
										.addGap(41, 41, 41)));
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - dad scripts
	private JLabel label1;
	private JLabel label2;
	private JTextField npcField;
	private JLabel label3;
	private JTextField foodField;
	private JLabel label4;
	private JLabel label5;
	private JCheckBox itemBox;
	private JTextField itemField;
	private JLabel label6;
	private JButton startButton;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
