package com.joseph.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

class Button extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon imageIcon;
	
	public static enum ButtonState { Released, Pressed, Entered, Exited, Clicked, Disabled };
	private ButtonState buttonState;	// 0: Released, 1: Pressed, 2: Entered, 3: Exited, 4: Clicked, 5: Disabled
	
	public static final String buttonsPath = "/com/whitejack/images/Buttons/";
	
	private URL resource = Button.class.getResource(buttonsPath);

	public Button( String text ) {
		super( text );
		setBorderPainted( false );

		if (resource == null)
			throw new IllegalArgumentException("Cannot find " + buttonsPath);
		
		String path = null;
		try {
			path = resource.toString() + text + "BtnUp.gif";
			//BufferedImage img = ImageIO.read( new File( path ).toURI().toURL() );
			imageIcon = new ImageIcon( new File( path ).toURI().toURL() );
			//originalImage = ImageIO.read( new File( path ) );
		} catch ( IOException ioe ) {
			System.err.println( "Couldn't find file: " + path );
		}
		

		//imageIcon = new ImageIcon( "./Buttons" + text + "BtnUp.jpg" );
		this.setPreferredSize( new Dimension( imageIcon.getIconWidth(), imageIcon.getIconHeight() ) );
		buttonState = isEnabled() ? ButtonState.Released : ButtonState.Disabled;	

		addMouseListener( new MouseAdapter() {
			@Override public void mouseClicked( MouseEvent me ) {
				//				String description = ((ImageIcon)getIcon()).getDescription();
				System.out.println( getText() );
			}

			@Override public void mousePressed( MouseEvent me ) {
				buttonState = isEnabled() ? 1 : 5;
				repaint();
			}

			@Override public void mouseReleased( MouseEvent me ) {
				buttonState = isEnabled() ? 0 : 5;
				buttonState = 0;
				if((me.getY()<0)||(me.getX()<0)||(me.getY()>imageIcon.getIconHeight())||(me.getX()>imageIcon.getIconWidth()))
					buttonState = 0;
				else
					buttonState=2;

				repaint();
			}
			@Override public void mouseEntered( MouseEvent me ) {
				buttonState = isEnabled() ? 2 : 5;
				repaint();
			}
			@Override public void mouseExited( MouseEvent me ) {
				buttonState = isEnabled() ? 3 : 5;
				repaint();
			}
		});
	}

	@Override 
	public void setEnabled( boolean isEnabled ) {
		super.setEnabled( isEnabled );
		buttonState = isEnabled ? 0: 5;
	}

	@Override 
	protected void paintComponent( Graphics g ) {

		super.paintComponent(g);
		// 0: Released, 1: Pressed, 2: Entered, 3: Exited, 4: Clicked

		ImageIcon imageIcon = this.imageIcon;
		String text = getText();
		switch ( buttonState ) {
		case 0:	// mouse up
			imageIcon = this.imageIcon;
			break;
		case 1:	// mouse down
			imageIcon = new ImageIcon( resource + text + "BtnDown.jpg" );
			break;
		case 2:	// mouse over/enter
			imageIcon = new ImageIcon( resource + text + "BtnUpOver.jpg" );
			break;
		case 3:	// mouse out/exit
			imageIcon = this.imageIcon;
			break;
			//		case 4:
		case 5:	// button disabled
			imageIcon = new ImageIcon( resource + text + "BtnDisabled.jpg" );
			break;
			//		default:
			//			break;
		}

		g.drawImage( imageIcon.getImage(), 0,0, null );
	}
}