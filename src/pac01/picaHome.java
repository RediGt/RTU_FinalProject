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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Point;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		LinkedList<Picas> picas = new LinkedList<Picas>();
		Connections con = new Connections();
		picas = con.LoadSqlPicas();
		printArr(picas);
	}

	private static void printArr(LinkedList<Picas> arr)
	{
		for(Picas i:arr)
		     i.printPica();  
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
		
		JPanel pnlPicas = new JPanel();
		JPanel pnlOrders = new JPanel();
		JPanel pnlBucket = new JPanel();
		
		JPanel pnlMain = new JPanel();
		pnlMain.setName("Welcome!");
		tabbedPane.addTab("Welcome!", null, pnlMain, null);		
		pnlMain.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Labākas picas Latvijā");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(185, 11, 264, 45);
		pnlMain.add(lblNewLabel_1);
		
		JButton btnMainPicas = new JButton("Picas");
		btnMainPicas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(pnlMain);
				tabbedPane.add(pnlPicas);
			}
		});
		btnMainPicas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMainPicas.setBounds(500, 105, 143, 37);
		pnlMain.add(btnMainPicas);
		
		JButton btnMainStuff = new JButton("Personālam");
		btnMainStuff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(pnlMain);
				tabbedPane.add(pnlOrders);
			}			
		});
		btnMainStuff.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMainStuff.setBounds(500, 307, 143, 37);
		pnlMain.add(btnMainStuff);
		
		JButton btnExit = new JButton("Iziet");
		btnExit.addActionListener(new CloseListener());
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExit.setBounds(500, 153, 143, 37);
		pnlMain.add(btnExit);
				
		//JPanel pnlOrders = new JPanel();
		pnlOrders.setName("Pasūtījumi");
		tabbedPane.addTab("Pasūtījumi", null, pnlOrders, null);
		pnlOrders.setLayout(null);
		
		//JPanel panel_3 = new JPanel();
		pnlBucket.setName("Grozs");
		tabbedPane.addTab("Grozs", null, pnlBucket, null);
		
		initializeLogo(pnlMain);
		
		//pnlPicas = new JPanel();
		pnlPicas.setName("Picas");
		tabbedPane.addTab("Picas", null, pnlPicas, null);
		pnlPicas.setLayout(null);
		
		JButton btnPicaBack = new JButton(new ImageIcon(((new ImageIcon(
	            "back01.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)))));
		btnPicaBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.add(pnlMain);
				tabbedPane.remove(pnlPicas);
			}
		});
		btnPicaBack.setSize(40, 40);
		btnPicaBack.setLocation(new Point(635, 11));
		pnlPicas.add(btnPicaBack);
		
		JLabel lblPicaTitle = new JLabel("Picas");
		lblPicaTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPicaTitle.setBounds(21, 11, 89, 29);
		pnlPicas.add(lblPicaTitle);
		
		JLabel lblVegetara = new JLabel("VEĢETĀRĀ");
		lblVegetara.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVegetara.setBounds(21, 82, 127, 29);
		pnlPicas.add(lblVegetara);
		
		JLabel lblArDrzeiem = new JLabel("AR DĀRZEŅIEM");
		lblArDrzeiem.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblArDrzeiem.setBounds(241, 82, 152, 29);
		pnlPicas.add(lblArDrzeiem);
		
		JLabel lblSalami = new JLabel("SALAMI");
		lblSalami.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSalami.setBounds(461, 82, 127, 29);
		pnlPicas.add(lblSalami);
		
		JLabel lblNewLabel = new JLabel("<html>picas mīkla, siers, marinēti<br> \r\nšampinjoni, sīpoli, paprika, <br> \r\nolīvas, tomātu mērce, ķiploks, <br> \r\ngaršvielas");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(21, 200, 177, 69);
		pnlPicas.add(lblNewLabel);
		
		JLabel lblpicasMklaampinjoni = new JLabel("<html>picas mīkla, šampinjoni, tomāti, <br>\r\ncukini, pesto, tomātu mērce, puravs, kapāti zaļumi");
		lblpicasMklaampinjoni.setToolTipText("");
		lblpicasMklaampinjoni.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblpicasMklaampinjoni.setBounds(238, 192, 177, 69);
		pnlPicas.add(lblpicasMklaampinjoni);
		
		JLabel lblpicasMklaSiers = new JLabel("<html>picas mīkla, siers, salami, mozzarella siers, tomātu mērce, garšvielas");
		lblpicasMklaSiers.setToolTipText("");
		lblpicasMklaSiers.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblpicasMklaSiers.setBounds(461, 192, 177, 69);
		pnlPicas.add(lblpicasMklaSiers);
		
		JButton btnVeg20 = new JButton("20");
		btnVeg20.setBounds(21, 273, 50, 30);
		pnlPicas.add(btnVeg20);
		
		JButton btnVeg30 = new JButton("30");
		btnVeg30.setBounds(76, 273, 50, 30);
		pnlPicas.add(btnVeg30);
		
		JButton btnVeg50 = new JButton("50");
		btnVeg50.setBounds(131, 273, 50, 30);
		pnlPicas.add(btnVeg50);
		
		JButton btnDar50 = new JButton("50");
		btnDar50.setBounds(351, 273, 50, 30);
		pnlPicas.add(btnDar50);
		
		JButton btnDar30 = new JButton("30");
		btnDar30.setBounds(296, 273, 50, 30);
		pnlPicas.add(btnDar30);
		
		JButton btnDar20 = new JButton("20");
		btnDar20.setBounds(241, 273, 50, 30);
		pnlPicas.add(btnDar20);
		
		JButton btnSal20 = new JButton("20");
		btnSal20.setBounds(461, 273, 50, 30);
		pnlPicas.add(btnSal20);
		
		JButton btnSal30 = new JButton("30");
		btnSal30.setBounds(516, 273, 50, 30);
		pnlPicas.add(btnSal30);
		
		JButton btnSal50 = new JButton("50");
		btnSal50.setBounds(571, 273, 50, 30);
		pnlPicas.add(btnSal50);
		
		JButton btnPicaBucket = new JButton((Icon) null);
		btnPicaBucket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.add(pnlBucket);
				tabbedPane.remove(pnlPicas);
			}
		});
		btnPicaBucket.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPicaBucket.setText("Grozs");
		btnPicaBucket.setLocation(new Point(635, 11));
		btnPicaBucket.setBounds(500, 11, 127, 40);		
		pnlPicas.add(btnPicaBucket);
		
		JButton btnPicaAddToBucket = new JButton((Icon) null);
		btnPicaAddToBucket.setText("Pievienot grozam");
		btnPicaAddToBucket.setLocation(new Point(635, 11));
		btnPicaAddToBucket.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPicaAddToBucket.setBounds(355, 330, 266, 40);
		
		pnlPicas.add(btnPicaAddToBucket);
		
		JLabel lblVegPrice = new JLabel("lblVegPrice");
		lblVegPrice.setToolTipText("");
		lblVegPrice.setText("");
		lblVegPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVegPrice.setBounds(131, 137, 100, 40);
		pnlPicas.add(lblVegPrice);
		
		JLabel lblDarPrice = new JLabel("lblDarPrice");
		lblDarPrice.setToolTipText("");
		lblDarPrice.setText("");
		lblDarPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDarPrice.setBounds(351, 137, 100, 40);
		pnlPicas.add(lblDarPrice);
		
		JLabel lblSalPrice = new JLabel("lblSalPrice");
		lblSalPrice.setToolTipText("");
		lblSalPrice.setText("");
		lblSalPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalPrice.setBounds(571, 137, 100, 40);
		pnlPicas.add(lblSalPrice);
		
		initializePicas(pnlPicas);
		onStart(tabbedPane, pnlPicas, pnlOrders, pnlBucket);
		
		JButton btnOrdersBack = new JButton(new ImageIcon(((new ImageIcon(
	            "back01.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)))));
		btnOrdersBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.add(pnlMain);
				tabbedPane.remove(pnlOrders);
			}
		});
		btnOrdersBack.setLocation(new Point(635, 11));
		btnOrdersBack.setBounds(635, 11, 40, 40);
		pnlOrders.add(btnOrdersBack);
		pnlBucket.setLayout(null);
		
		JButton btnBucketBack = new JButton(new ImageIcon(((new ImageIcon(
	            "back01.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)))));
		btnBucketBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.add(pnlPicas);
				tabbedPane.remove(pnlBucket);
			}
		});
		btnBucketBack.setLocation(new Point(635, 11));
		btnBucketBack.setBounds(635, 11, 40, 40);
		pnlBucket.add(btnBucketBack);
	}
	
	private void initializeLogo(JPanel pnlMain) {
		ImageImplement pnlMainPizzaLogo = new ImageImplement(new ImageIcon("PizzaLogo01.png").getImage(), 300, 300);	
		pnlMainPizzaLogo.setLocation(10, 44);
		pnlMain.add(pnlMainPizzaLogo);
		pnlMainPizzaLogo.setVisible(true);
		pnlMainPizzaLogo.setSize(300, 300);
	}
	
	private void initializePicas(JPanel pnlPicas) {
		ImageImplement pnlPicaVegetara = new ImageImplement(new ImageIcon("Veģetārā.png").getImage(), 100, 100);
		pnlPicas.add(pnlPicaVegetara);
		pnlPicaVegetara.setBounds(21, 99, 100, 100);
		pnlPicaVegetara.setVisible(true);
		
		ImageImplement pnlPicaDarzenu = new ImageImplement(new ImageIcon("Ar-dārzeņiem-bez-siera.png").getImage(), 100, 100);
		pnlPicaDarzenu.setBounds(241, 99, 100, 100);
		pnlPicas.add(pnlPicaDarzenu);
		pnlPicaDarzenu.setVisible(true);
		
		ImageImplement pnlPicaSalami = new ImageImplement(new ImageIcon("Ar-salami.png").getImage(), 100, 100);
		pnlPicaSalami.setBounds(463, 99, 100, 100);
		pnlPicas.add(pnlPicaSalami);
		pnlPicaSalami.setVisible(true);
	}
	
	private void onStart(JTabbedPane tabbedPane, JPanel pnlPicas, JPanel pnlOrders, JPanel pnlBucket) {
		tabbedPane.remove(pnlPicas);
		tabbedPane.remove(pnlOrders);
		tabbedPane.remove(pnlBucket);
	}
}

class CloseListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        //DO SOMETHING
        System.exit(0);
    }
}