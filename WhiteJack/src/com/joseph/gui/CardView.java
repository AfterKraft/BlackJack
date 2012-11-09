package com.joseph.gui;

import java.io.*;
import java.awt.*;
import java.awt.image.*;

import javax.imageio.ImageIO;
import javax.swing.*;


import java.net.URL;

public class CardView extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private URL resource = CardView.class.getResource("/com/whitejack/images/Cards/");
	public static int DEFAULT_WIDTH = 60;
	private Card card;

	private BufferedImage originalImage = null;
	private BufferedImage resizedImage;

	private int defaultWidth;

	public CardView( Card card ) {
		this.card = card;
		defaultWidth = DEFAULT_WIDTH;


		String path = null;
		try {
			path = CardView.class.getResource("/com/whitejack/images/Cards/").toString() + card + ".jpg";
			URL pathURL = new URL(path);
			originalImage = ImageIO.read( pathURL );
		} catch ( IOException ioe ) {
			System.err.println( "Couldn't find file: " + resource + path );
		}

		if ( originalImage != null ) {
			float aspectRatio = (float)originalImage.getWidth() / originalImage.getHeight();
			resizedImage = resize( originalImage, defaultWidth, (int)(defaultWidth/aspectRatio) );

			setPreferredSize( new Dimension( resizedImage.getWidth(), resizedImage.getHeight() ) );
			setMinimumSize( new Dimension( resizedImage.getWidth(), resizedImage.getHeight() ) );
			//System.out.println( "CardView width=" + resizedImage.getWidth() + " height=" + resizedImage.getHeight() );
		}
	}

	public Card getCard() {	
		return this.card; 

	}

	protected void paintComponent( Graphics g )  {
		super.paintComponent(g);
		g.drawImage( resizedImage, 0, 0, null );
	}

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
}

/*
 *  Resources:
 *  1) http://docs.oracle.com/javase/tutorial/2d/images/index.html
 *  2) http://www.javalobby.org/articles/ultimate-image/
 *  
 */
