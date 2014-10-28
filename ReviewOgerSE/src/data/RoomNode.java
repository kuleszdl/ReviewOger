/**
 * This class represents a node in a tree if the node is a room. Always a leaf
 */
package data;

import javax.swing.tree.DefaultMutableTreeNode;

public class RoomNode extends DefaultMutableTreeNode {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5242086827394327638L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.tree.DefaultMutableTreeNode#isLeaf()
	 */
	public boolean isLeaf() {
		// rooms must be leafes
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.tree.DefaultMutableTreeNode#toString()
	 */
	public String toString() {
		return ((Room) this.getUserObject()).getFormatedDate();

	}

}
