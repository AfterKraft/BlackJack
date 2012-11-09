package com.joseph.gui;


import java.awt.Dimension;

import javax.swing.JFrame;

// import java.awt.Rectangle;


public class BlackjackGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                displayBlackjackTable();
            }
        });
	}
	
	public static void displayBlackjackTable() {
		
		final BlackjackGUI frame = new BlackjackGUI();
		frame.setTitle( "Whitejack Project" );
		frame.setMinimumSize( new Dimension( 1005, 595 ) );
		//frame.setResizable( false );

		/* Set GameTableView to occupy the entire JFrame area */
		GameTableView gameTableView = new GameTableView();
		frame.setContentPane( gameTableView );
		
		frame.pack();
		frame.setLocationRelativeTo( null );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setVisible( true );
	}
	/*
	public static BufferedImage resize( BufferedImage img, int newW, int newH ) {  
        int w = img.getWidth();  
        int h = img.getHeight();  
        BufferedImage dimg = new BufferedImage( newW, newH, img.getType() );
        Graphics2D g = dimg.createGraphics();  
        g.setRenderingHint( RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR );  
        g.drawImage( img, 0, 0, newW, newH, 0, 0, w, h, null );  
        g.dispose();  
        return dimg;
	}
	*/
	
/*
	@Override public void paint( Graphics g ) {
        Dimension d = getSize();
        Dimension m = getMaximumSize();
        boolean resize = d.width > m.width || d.height > m.height;
        d.width = Math.min(m.width, d.width);
        d.height = Math.min(m.height, d.height);
        if (resize) {
            Point p = getLocation();
            setVisible(false);
            setSize(d);
            setLocation(p);
            setVisible(true);
        }
        super.paint( g );
    }
*/		
}

