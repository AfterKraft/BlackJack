package com.joseph.gui;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


//-----------------------------------------------------------------------------
class TableCenterPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage originalImage = null;
	private URL path = TableCenterPanel.class.getResource("/com/whitejack/images/GameTable/");


	DealerView dealerView;
	JPanel whiteJackPanel;
	PlayerView playerView;

	public TableCenterPanel() {
		String pathStr = null;
		try {
			pathStr = path + "TableCenter1.gif";
			URL pathURL = new URL(pathStr);
			originalImage = ImageIO.read( pathURL );
		} catch ( IOException ioe ) {
			System.err.println( "Couldn't find file: " + pathStr );
		}

		setOpaque( false );
		setLayout( new GridLayout( 3, 1, 0, 0 ) );
		// setBorder( BorderFactory.createLineBorder( Color.CYAN ) );

		dealerView = new DealerView();
		whiteJackPanel = new JPanel();
		whiteJackPanel.setOpaque( false );
		playerView = new PlayerView();

		add( dealerView );
		add( whiteJackPanel );
		add( playerView );

		addComponentListener( new ComponentAdapter() {
			@Override
			public void componentResized( ComponentEvent e ) {
				// System.out.println( "component width=" + getSize().width + " component height=" + getSize().height );
			}
		});
	}

	@Override
	protected void paintComponent( Graphics g )  {
		super.paintComponent(g);

		int w = originalImage.getWidth();  
		int h = originalImage.getHeight();  

		g.drawImage( originalImage, 0, 0, getWidth(), getHeight(), 0, 0, w, h, null );  

	}
}