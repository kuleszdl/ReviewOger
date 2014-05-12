/**
 * This class shows a dialog in which the user can enter the date and time for a slot
 */

package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;

import data.ReviewPlan;
import data.RoomTreeModel;
import data.Slot;

public class NewSlotGui {

	/**
	 * This method shows a dialog for the slot data and generates a new slot.
	 */
	public static void addSlot() {

		final JFrame slotFrame = new JFrame();

		final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
		final DateFormat timeFormat = new SimpleDateFormat("HH:mm");

		slotFrame.setLayout(new GridLayout(4, 2));
		slotFrame.setTitle("Neuer Slot");
		Dimension minimumSize = new Dimension(250, 200);
		slotFrame.setMinimumSize(minimumSize);

		JLabel dateLabel = new JLabel("Datum:");
		slotFrame.add(dateLabel);

		final JTextField dateField = new JTextField();
		slotFrame.add(dateField);

		JLabel beginLabel = new JLabel("Beginn:");
		slotFrame.add(beginLabel);

		final JTextField beginField = new JTextField();
		slotFrame.add(beginField);

		JLabel endLabel = new JLabel("Ende:");
		slotFrame.add(endLabel);

		final JTextField endField = new JTextField();
		slotFrame.add(endField);

		JButton doneButton = new JButton("OK");
		doneButton.addActionListener(new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				boolean parseFailed = false;

				Date date = null;
				Date beginTime = null;
				Date endTime = null;

				try {
					date = dateFormat.parse(dateField.getText());
				} catch (ParseException e) {
					JOptionPane.showMessageDialog(null,
							"Das Datum muss die Form tt.mm.jj haben",
							"Datum nicht erkannt", JOptionPane.ERROR_MESSAGE);
					parseFailed = true;
				}

				try {
					beginTime = timeFormat.parse(beginField.getText());
				} catch (ParseException e) {
					JOptionPane.showMessageDialog(null,
							"Angfangszeit muss die Form HH:mm haben",
							"Anfangszeit nicht erkannt",
							JOptionPane.ERROR_MESSAGE);
					parseFailed = true;
				}

				try {
					endTime = timeFormat.parse(endField.getText());
				} catch (ParseException e) {
					JOptionPane.showMessageDialog(null,
							"Endzeit muss die Form HH:mm haben",
							"Endzeit nicht erkannt", JOptionPane.ERROR_MESSAGE);
					parseFailed = true;
				}

				if (!parseFailed) {
					Slot slot = new Slot(date, beginTime, endTime);
					((DefaultMutableTreeNode) RoomTreeModel.getModel()
							.getRoot()).add(new DefaultMutableTreeNode(slot
							.getFormatedDate()));
					Gui.getRoomTree().updateUI();
					ReviewPlan.slots.add(slot);
					slotFrame.dispose();
				}
			}

		});
		slotFrame.add(doneButton);

		slotFrame.setVisible(true);
		slotFrame.pack();

	}

}