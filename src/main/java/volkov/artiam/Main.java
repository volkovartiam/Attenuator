package volkov.artiam;

public class Main {

	public static void main ( String[] args ) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Frame frame = new Frame();
				frame.setVisible(true);
			}
		});
	}
}
