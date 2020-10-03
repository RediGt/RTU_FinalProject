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
import javax.swing.plaf.ColorUIResource;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class picaHome {

	private JFrame frmPiccaHut;
	LinkedList<Picas> picas = new LinkedList<Picas>();
	LinkedList<Orders> orders = new LinkedList<Orders>();
	private LinkedList<Order> clientOrder = new LinkedList<Order>();
	Connections con = new Connections();
	Picas currentOrder = null;
	private JTextField tFieldAddress;
	private JTextField tFieldDateTime;
	private JTextField tFieldPhone;
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
		
		//Variables		
		JPanel pnlPicas = new JPanel();
		JPanel pnlOrders = new JPanel();
		JPanel pnlBucket = new JPanel();
		
		JLabel lblVegPrice = new JLabel("lblVegPrice");
		JLabel lblDarPrice = new JLabel("lblDarPrice");
		JLabel lblSalPrice = new JLabel("lblSalPrice");
		JButton btnVeg20 = new JButton("20");
		JButton btnVeg30 = new JButton("30");
		JButton btnVeg50 = new JButton("50");
		JButton btnDar20 = new JButton("20");
		JButton btnDar30 = new JButton("30");
		JButton btnDar50 = new JButton("50");
		JButton btnSal20 = new JButton("20");
		JButton btnSal30 = new JButton("30");
		JButton btnSal50 = new JButton("50");
		
		JLabel lblGrozsOrder = new JLabel("Jūsu gozs ir tukšs!");
		
		//Connections
		picas = con.LoadSqlPicas();
		
		//
		//Main Panel Elements
		//
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

		//Logo Method
		initializeLogo(pnlMain);
		
		//
		//Picas Panel Elements
		//
		//pnlPicas
		pnlPicas.setName("Picas");
		tabbedPane.addTab("Picas", null, pnlPicas, null);
		pnlPicas.setLayout(null);
		
		//btnPicaBack
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
		
		JLabel lblVegDescription = new JLabel("<html>picas mīkla, siers, marinēti<br> \r\nšampinjoni, sīpoli, paprika, <br> \r\nolīvas, tomātu mērce, ķiploks, <br> \r\ngaršvielas");
		lblVegDescription.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblVegDescription.setToolTipText("");
		lblVegDescription.setBounds(21, 200, 177, 69);
		pnlPicas.add(lblVegDescription);
		
		JLabel lblDarDescription = new JLabel("<html>picas mīkla, šampinjoni, tomāti, <br>\r\ncukini, pesto, tomātu mērce, puravs, kapāti zaļumi");
		lblDarDescription.setToolTipText("");
		lblDarDescription.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblDarDescription.setBounds(238, 192, 177, 69);
		pnlPicas.add(lblDarDescription);
		
		JLabel lblSalDescription = new JLabel("<html>picas mīkla, siers, salami, mozzarella siers, tomātu mērce, garšvielas");
		lblSalDescription.setToolTipText("");
		lblSalDescription.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblSalDescription.setBounds(461, 192, 177, 69);
		pnlPicas.add(lblSalDescription);
		
		//JButton btnVeg20
		btnVeg20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentOrder = picas.get(0);
				String price = picas.get(0).getPicaPrice();
				resetPicasPriceButtonsAndLabels(lblVegPrice, lblDarPrice, lblSalPrice,
						 btnVeg20, btnVeg30, btnVeg50, btnDar20, btnDar30, btnDar50, btnSal20, btnSal30, btnSal50);
				lblVegPrice.setText(price + " eur");
				btnVeg20.setBackground(Color.orange);
			}
		});
		btnVeg20.setBounds(21, 273, 50, 30);
		pnlPicas.add(btnVeg20);
		
		//JButton btnVeg30
		btnVeg30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentOrder = picas.get(1);
				String price = picas.get(1).getPicaPrice();
				resetPicasPriceButtonsAndLabels(lblVegPrice, lblDarPrice, lblSalPrice,
						 btnVeg20, btnVeg30, btnVeg50, btnDar20, btnDar30, btnDar50, btnSal20, btnSal30, btnSal50);
				lblVegPrice.setText(price + " eur");
				btnVeg30.setBackground(Color.orange);
			}
		});
		btnVeg30.setBounds(76, 273, 50, 30);
		pnlPicas.add(btnVeg30);
		
		//JButton btnVeg50
		btnVeg50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentOrder = picas.get(2);
				String price = picas.get(2).getPicaPrice();
				resetPicasPriceButtonsAndLabels(lblVegPrice, lblDarPrice, lblSalPrice,
						 btnVeg20, btnVeg30, btnVeg50, btnDar20, btnDar30, btnDar50, btnSal20, btnSal30, btnSal50);
				lblVegPrice.setText(price + " eur");
				btnVeg50.setBackground(Color.orange);
			}
		});
		btnVeg50.setBounds(131, 273, 50, 30);
		pnlPicas.add(btnVeg50);
		
		//JButton btnDar20
		btnDar20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentOrder = picas.get(3);
				String price = picas.get(3).getPicaPrice();
				resetPicasPriceButtonsAndLabels(lblVegPrice, lblDarPrice, lblSalPrice,
						 btnVeg20, btnVeg30, btnVeg50, btnDar20, btnDar30, btnDar50, btnSal20, btnSal30, btnSal50);
				lblDarPrice.setText(price + " eur");
				btnDar20.setBackground(Color.orange);
			}
		});
		btnDar20.setBounds(241, 273, 50, 30);
		pnlPicas.add(btnDar20);
		
		//JButton btnDar30	
		btnDar30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentOrder = picas.get(4);
				String price = picas.get(4).getPicaPrice();
				resetPicasPriceButtonsAndLabels(lblVegPrice, lblDarPrice, lblSalPrice,
						 btnVeg20, btnVeg30, btnVeg50, btnDar20, btnDar30, btnDar50, btnSal20, btnSal30, btnSal50);
				lblDarPrice.setText(price + " eur");
				btnDar30.setBackground(Color.orange);
			}
		});
		btnDar30.setBounds(296, 273, 50, 30);
		pnlPicas.add(btnDar30);
		
		//JButton btnDar50
		btnDar50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentOrder = picas.get(5);
				String price = picas.get(5).getPicaPrice();
				resetPicasPriceButtonsAndLabels(lblVegPrice, lblDarPrice, lblSalPrice,
						 btnVeg20, btnVeg30, btnVeg50, btnDar20, btnDar30, btnDar50, btnSal20, btnSal30, btnSal50);
				lblDarPrice.setText(price + " eur");
				btnDar50.setBackground(Color.orange);
			}
		});
		btnDar50.setBounds(351, 273, 50, 30);
		pnlPicas.add(btnDar50);
		
		//JButton btnSal20
		btnSal20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentOrder = picas.get(6);
				String price = picas.get(6).getPicaPrice();
				resetPicasPriceButtonsAndLabels(lblVegPrice, lblDarPrice, lblSalPrice,
						 btnVeg20, btnVeg30, btnVeg50, btnDar20, btnDar30, btnDar50, btnSal20, btnSal30, btnSal50);
				lblSalPrice.setText(price + " eur");
				btnSal20.setBackground(Color.orange);
			}
		});
		btnSal20.setBounds(461, 273, 50, 30);
		pnlPicas.add(btnSal20);
		
		//JButton btnSal30
		btnSal30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentOrder = picas.get(7);
				String price = picas.get(7).getPicaPrice();
				resetPicasPriceButtonsAndLabels(lblVegPrice, lblDarPrice, lblSalPrice,
						 btnVeg20, btnVeg30, btnVeg50, btnDar20, btnDar30, btnDar50, btnSal20, btnSal30, btnSal50);
				lblSalPrice.setText(price + " eur");
				btnSal30.setBackground(Color.orange);
			}
		});
		btnSal30.setBounds(516, 273, 50, 30);
		pnlPicas.add(btnSal30);
		
		//JButton btnSal50
		btnSal50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentOrder = picas.get(8);
				String price = picas.get(8).getPicaPrice();
				resetPicasPriceButtonsAndLabels(lblVegPrice, lblDarPrice, lblSalPrice,
						 btnVeg20, btnVeg30, btnVeg50, btnDar20, btnDar30, btnDar50, btnSal20, btnSal30, btnSal50);
				lblSalPrice.setText(price + " eur");
				btnSal50.setBackground(Color.orange);
			}
		});
		btnSal50.setBounds(571, 273, 50, 30);
		pnlPicas.add(btnSal50);
		
		JButton btnPicaBucket = new JButton((Icon) null);
		btnPicaBucket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.add(pnlBucket);
				tabbedPane.remove(pnlPicas);
				resetPicasPriceButtonsAndLabels(lblVegPrice, lblDarPrice, lblSalPrice,
						 btnVeg20, btnVeg30, btnVeg50, btnDar20, btnDar30, btnDar50, btnSal20, btnSal30, btnSal50);
				Order.printClientOrder(clientOrder);
				String orderString = Order.clientOrderToString(clientOrder);
				if (clientOrder.size() != 0)
				{
					lblGrozsOrder.setBounds(377, 94, 280, (30 * (clientOrder.size() + 2)));
					lblGrozsOrder.setText(orderString);
				}
				else {
					lblGrozsOrder.setBounds(377, 94, 280, 30);
					lblGrozsOrder.setText("Jūsu gozs ir tukšs!");
				}
			}
		});
		btnPicaBucket.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPicaBucket.setText("Grozs");
		btnPicaBucket.setLocation(new Point(635, 11));
		btnPicaBucket.setBounds(500, 11, 127, 40);		
		pnlPicas.add(btnPicaBucket);
		
		JButton btnPicaAddToBucket = new JButton((Icon) null);
		btnPicaAddToBucket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentOrder != null)
				{
					clientOrder.add(new Order(String.valueOf(clientOrder.size() + 1), currentOrder.getPicaName(), 
										currentOrder.getPicaSize(), currentOrder.getPicaPrice()));
					btnPicaBucket.setText("Grozs (" + String.valueOf(clientOrder.size()) + ")");
				}
			}
		});
		btnPicaAddToBucket.setText("Pievienot grozam");
		btnPicaAddToBucket.setLocation(new Point(635, 11));
		btnPicaAddToBucket.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPicaAddToBucket.setBounds(355, 330, 266, 40);		
		pnlPicas.add(btnPicaAddToBucket);
		
		JButton btnClearBucket = new JButton((Icon) null);
		btnClearBucket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetPicasPriceButtonsAndLabels(lblVegPrice, lblDarPrice, lblSalPrice,
						 btnVeg20, btnVeg30, btnVeg50, btnDar20, btnDar30, btnDar50, btnSal20, btnSal30, btnSal50);
				btnPicaBucket.setText("Grozs");
				currentOrder = null;
				clientOrder.removeAll(clientOrder);
			}
		});
		btnClearBucket.setText("Iztukšot");
		btnClearBucket.setLocation(new Point(635, 11));
		btnClearBucket.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClearBucket.setBounds(377, 11, 113, 40);
		pnlPicas.add(btnClearBucket);
		
		//JLabel lblVegPrice
		lblVegPrice.setToolTipText("");
		lblVegPrice.setText("");
		lblVegPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVegPrice.setBounds(131, 137, 100, 40);
		pnlPicas.add(lblVegPrice);
		
		//JLabel lblDarPrice
		lblDarPrice.setToolTipText("");
		lblDarPrice.setText("");
		lblDarPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDarPrice.setBounds(351, 137, 100, 40);
		pnlPicas.add(lblDarPrice);
		
		//JLabel lblSalPrice
		lblSalPrice.setToolTipText("");
		lblSalPrice.setText("");
		lblSalPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalPrice.setBounds(571, 137, 100, 40);
		pnlPicas.add(lblSalPrice);
		
		
		//
		//Orders Panel Elements
		//
		//JPanel pnlOrders
		pnlOrders.setName("Pasūtījumi");
		tabbedPane.addTab("Pasūtījumi", null, pnlOrders, null);
		pnlOrders.setLayout(null);
		
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
		
		//
		//Methods
		//
		initializePicas(pnlPicas);
		
		//
		//Bucket Panel Elements
		//
		//JPanel pnlBucket
		pnlBucket.setName("Grozs");
		tabbedPane.addTab("Grozs", null, pnlBucket, null);		
		
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
		pnlBucket.setLayout(null);
		onStart(tabbedPane, pnlPicas, pnlOrders, pnlBucket);		
		
		JLabel lblGrozsOrderPlacement = new JLabel("Pasūtījuma noformēšana");
		lblGrozsOrderPlacement.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblGrozsOrderPlacement.setBounds(10, 11, 324, 32);
		pnlBucket.add(lblGrozsOrderPlacement);
		
		JLabel lblGrozsCustomerInfo = new JLabel("Pasūtītāja informācija :");
		lblGrozsCustomerInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGrozsCustomerInfo.setBounds(10, 54, 324, 32);
		pnlBucket.add(lblGrozsCustomerInfo);
		
		JLabel lblGrozsOrderHeader = new JLabel("Pasūtījums :");
		lblGrozsOrderHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGrozsOrderHeader.setBounds(377, 54, 136, 32);
		pnlBucket.add(lblGrozsOrderHeader);
		
		//JLabel lblGrozsOrder = new JLabel("Jūsu gozs ir tukšs!");
		lblGrozsOrder.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGrozsOrder.setBounds(377, 94, 281, 32);
		pnlBucket.add(lblGrozsOrder);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 81, 300, 12);
		pnlBucket.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(377, 81, 233, 12);
		pnlBucket.add(separator_1);
		
		JTextField tFieldName = new JTextField("Vārds");
		tFieldName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				if (tFieldName.getText().equals("")) {
					tFieldName.setText("Vārds");
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tFieldName.getText().equals("Vārds")) {
					tFieldName.setText("");
				}
			}
		});
		tFieldName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tFieldName.setColumns(10);
		tFieldName.setBounds(10, 97, 313, 31);
		pnlBucket.add(tFieldName);
		
		tFieldAddress = new JTextField();
		tFieldAddress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tFieldAddress.getText().equals("Piegādes adrese")) {
					tFieldAddress.setText("");
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (tFieldAddress.getText().equals("")) {
					tFieldAddress.setText("Piegādes adrese");
				}
			}
		});
		tFieldAddress.setText("Piegādes adrese");
		tFieldAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tFieldAddress.setColumns(10);
		tFieldAddress.setBounds(10, 181, 313, 31);
		pnlBucket.add(tFieldAddress);
		
		tFieldDateTime = new JTextField();
		tFieldDateTime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tFieldDateTime.getText().equals("Vēlamais datums un laiks (dd.mm ss:mm)")) {
					tFieldDateTime.setText("");
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (tFieldPhone.getText().equals("")) {
					tFieldPhone.setText("Vēlamais datums un laiks (dd.mm ss:mm)");
				}
			}
		});
		tFieldDateTime.setText("Vēlamais datums un laiks (dd.mm ss:mm)");
		tFieldDateTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tFieldDateTime.setColumns(10);
		tFieldDateTime.setBounds(10, 223, 313, 31);
		pnlBucket.add(tFieldDateTime);
		
		tFieldPhone = new JTextField();
		tFieldPhone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tFieldPhone.getText().equals("Kontakttālrunis (xx xxx xxx)")) {
					tFieldPhone.setText("");
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (tFieldPhone.getText().equals("")) {
					tFieldPhone.setText("Kontakttālrunis (xx xxx xxx)");
				}
			}
		});
		tFieldPhone.setText("Kontakttālrunis (xx xxx xxx)");
		tFieldPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tFieldPhone.setColumns(10);
		tFieldPhone.setBounds(10, 139, 313, 31);
		pnlBucket.add(tFieldPhone);
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
	
	private void resetPicasPriceButtonsAndLabels(JLabel lblVegPrice, JLabel lblDarPrice, JLabel lblSalPrice,
												 JButton btnVeg20, JButton btnVeg30, JButton btnVeg50,
												 JButton btnDar20, JButton btnDar30, JButton btnDar50,
												 JButton btnSal20, JButton btnSal30, JButton btnSal50) {
		lblVegPrice.setText("");
		lblDarPrice.setText("");
		lblSalPrice.setText("");
		btnVeg20.setBackground(new ColorUIResource(238, 238, 238));
		btnVeg30.setBackground(new ColorUIResource(238, 238, 238));
		btnVeg50.setBackground(new ColorUIResource(238, 238, 238));
		btnDar20.setBackground(new ColorUIResource(238, 238, 238));
		btnDar30.setBackground(new ColorUIResource(238, 238, 238));
		btnDar50.setBackground(new ColorUIResource(238, 238, 238));
		btnSal20.setBackground(new ColorUIResource(238, 238, 238));
		btnSal30.setBackground(new ColorUIResource(238, 238, 238));
		btnSal50.setBackground(new ColorUIResource(238, 238, 238));
	}
}

class CloseListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        //DO SOMETHING
        System.exit(0);
    }
}