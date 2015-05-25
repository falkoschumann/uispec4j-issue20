package de.muspellheim.uispec4j;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory("UISpec4J");
			EntityManager em = factory.createEntityManager();
			final JFrame frame = new JFrame("UISpec4J");
			em.createQuery("from Contact", Contact.class).getResultList();
			em.close();
			frame.addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosed(WindowEvent e) {
					// XXX set break point to this method to trigger race condition
					System.out.println("windowClosed");
					em.close();
					factory.close();
				}

			});
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(640, 480);
			frame.setVisible(true);
		});
	}

}
