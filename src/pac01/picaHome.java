package pac01;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Point;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class picaHome {

	private JFrame frmPiccaHut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					picaHome window = new picaHome();
					window.frmPiccaHut.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public picaHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPiccaHut = new JFrame();
		frmPiccaHut.setTitle("Picca Hut");
		frmPiccaHut.setBounds(100, 100, 706, 483);
		frmPiccaHut.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPiccaHut.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmPiccaHut.getContentPane().add(tabbedPane);
		
		JPanel pnlMain = new JPanel();
		tabbedPane.addTab("Welcome!", null, pnlMain, null);
		pnlMain.setLayout(null);
				
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
		
		initializeLogo(pnlMain);
		
		JPanel pnlPicas = new JPanel();
		tabbedPane.addTab("Picas", null, pnlPicas, null);
		pnlPicas.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setSize(89, 23);
		btnNewButton.setLocation(new Point(586, 20));
		pnlPicas.add(btnNewButton);
		
		JLabel lblPicaTitle = new JLabel("Picas");
		lblPicaTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPicaTitle.setBounds(21, 11, 89, 29);
		pnlPicas.add(lblPicaTitle);
		
		JLabel lblVegetara = new JLabel("VEĢETĀRĀ");
		lblVegetara.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVegetara.setBounds(21, 64, 127, 29);
		pnlPicas.add(lblVegetara);
		
		JLabel lblArDrzeiem = new JLabel("AR DĀRZEŅIEM");
		lblArDrzeiem.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblArDrzeiem.setBounds(241, 64, 152, 29);
		pnlPicas.add(lblArDrzeiem);
		
		JLabel lblSalami = new JLabel("SALAMI");
		lblSalami.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSalami.setBounds(461, 64, 127, 29);
		pnlPicas.add(lblSalami);
		initializePicas(pnlPicas);
		
		JLabel lblNewLabel = new JLabel("<html>picas mīkla, siers, marinēti<br> \r\nšampinjoni, sīpoli, paprika, <br> \r\nolīvas, tomātu mērce, ķiploks, <br> \r\ngaršvielas");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(21, 182, 177, 69);
		pnlPicas.add(lblNewLabel);
		
		JLabel lblpicasMklaampinjoni = new JLabel("<html>picas mīkla, šampinjoni, tomāti, <br>\r\ncukini, pesto, tomātu mērce, puravs, kapāti zaļumi");
		lblpicasMklaampinjoni.setToolTipText("");
		lblpicasMklaampinjoni.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblpicasMklaampinjoni.setBounds(238, 174, 177, 69);
		pnlPicas.add(lblpicasMklaampinjoni);
		
		JLabel lblpicasMklaSiers = new JLabel("<html>picas mīkla, siers, salami, mozzarella siers, tomātu mērce, garšvielas");
		lblpicasMklaSiers.setToolTipText("");
		lblpicasMklaSiers.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblpicasMklaSiers.setBounds(461, 174, 177, 69);
		pnlPicas.add(lblpicasMklaSiers);
		ImageImplement pnlPicaVegetara = new ImageImplement(new ImageIcon("G:\\Java2020\\RTU_FinalProj\\Veģetārā.png").getImage(), 100, 100);
		//ImageImplement pnlMainPizzaLogo = new ImageImplement(new ImageIcon("PizzaLogo01.png").getImage());
		pnlPicas.add(pnlPicaVegetara);
		pnlPicaVegetara.setBounds(21, 81, 100, 100);
		pnlPicaVegetara.setVisible(true);
		
		ImageImplement pnlPicaDarzenu = new ImageImplement(new ImageIcon("G:\\Java2020\\RTU_FinalProj\\Ar-dārzeņiem-bez-siera.png").getImage(), 100, 100);
		//ImageImplement pnlMainPizzaLogo = new ImageImplement(new ImageIcon("PizzaLogo01.png").getImage());
		pnlPicaDarzenu.setBounds(241, 81, 100, 100);
		pnlPicas.add(pnlPicaDarzenu);
		pnlPicaDarzenu.setVisible(true);
		
		ImageImplement pnlPicaSalami = new ImageImplement(new ImageIcon("G:\\Java2020\\RTU_FinalProj\\Ar-salami.png").getImage(), 100, 100);
		//ImageImplement pnlMainPizzaLogo = new ImageImplement(new ImageIcon("PizzaLogo01.png").getImage());
		pnlPicaSalami.setBounds(463, 81, 100, 100);
		pnlPicas.add(pnlPicaSalami);
		
		JButton btnVeg20 = new JButton("20");
		btnVeg20.setBounds(21, 255, 50, 30);
		pnlPicas.add(btnVeg20);
		
		JButton btnVeg30 = new JButton("30");
		btnVeg30.setBounds(76, 255, 50, 30);
		pnlPicas.add(btnVeg30);
		
		JButton btnVeg50 = new JButton("50");
		btnVeg50.setBounds(131, 255, 50, 30);
		pnlPicas.add(btnVeg50);
		
		JButton btnDar50 = new JButton("50");
		btnDar50.setBounds(341, 255, 45, 30);
		pnlPicas.add(btnDar50);
		
		JButton btnDar30 = new JButton("30");
		btnDar30.setBounds(291, 255, 45, 30);
		pnlPicas.add(btnDar30);
		
		JButton btnDar20 = new JButton("20");
		btnDar20.setBounds(241, 255, 45, 30);
		pnlPicas.add(btnDar20);
		
		JButton btnSal20 = new JButton("20");
		btnSal20.setBounds(461, 255, 45, 30);
		pnlPicas.add(btnSal20);
		
		JButton btnSal30 = new JButton("30");
		btnSal30.setBounds(511, 255, 45, 30);
		pnlPicas.add(btnSal30);
		
		JButton btnSal50 = new JButton("50");
		btnSal50.setBounds(561, 255, 45, 30);
		pnlPicas.add(btnSal50);
		pnlPicaSalami.setVisible(true);
	}
	
	private void initializeLogo(JPanel pnlMain) {
		ImageImplement pnlMainPizzaLogo = new ImageImplement(new ImageIcon("G:\\Java2020\\RTU_FinalProj\\PizzaLogo01.png").getImage(), 300, 300);
		//Im1ge81ple00nt 00lMainPizzaLogo = new ImageImplement(newLabel label1 = new JLabel("VEĢETĀRĀ");		
		pnlMain.add(pnlMainPizzaLogo);
		pnlMainPizzaLogo.setVisible(true);
		pnlMainPizzaLogo.setSize(300, 300);
	}
	
	private void initializePicas(JPanel pnlPicas) {
	}
}