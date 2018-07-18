package br.com.devhouse.protur.ui;

import java.applet.AppletStub;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.BasicStroke;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Paint;
import java.awt.geom.QuadCurve2D;
import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Kuldip Pabla
 */

/*
 * ProgressBar implements the progress indicators animation/UI
 */

@SuppressWarnings("serial")
public class GraphicsProgressBar extends JPanel {
    // Close Button
    private final int CLOSE_WIDTH=10;
    private final int CLOSE_X_FROM_RIGHT = 22;
    private final int CLOSE_Y = 8;
    private final Color CLOSE_BTN_CLR= new Color (0xb9b9b9);

    // default size for webstart window
    private final int DEFAULT_WIDTH = 400;
    private final int DEFAULT_HEIGHT = 200;

    // label properties
    private final Font LABEL_FONT = new Font("Arial Narrow", Font.PLAIN, 18);
    private final Color LABEL_COLOR = Color.WHITE; 

    // Background Gradient colors
    private final Color BG1 = new Color (0x1C3E7D);
    private final Color BG2 = new Color (0x0F2246);
    private final float [] FG_POS = new float[]{0.2f, 0.7f};
    private final Color [] FG_COLORS = new Color[]{BG1,BG2};

    // TV properties
    private final BasicStroke STROKE = new BasicStroke(1.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
    private final int TV_WIDTH = 180;
    private final int TV_HEIGHT = 100;

    // create new QuadCurve2D.Float
    private final QuadCurve2D Q = new QuadCurve2D.Float();

    private AppletStub stub = null;

    private boolean isApplet = true;
    private volatile int lastProgressPercentage = -1;

    private int width = DEFAULT_WIDTH;
    private int height = DEFAULT_HEIGHT;
    private int tvX = 0;
    private int tvY = 0;
    private int tvbaseX;
    private int tvbaseY;
    private int tvbaseWidth;

    private BufferedImage buffer = null;
   // private ProgressManager pm = null;
    private int alpha = 255;
    private int fadingFactor = -10;
    private final Timer timer = new Timer(true);
    private Paint bgGradient;
    
    private Graphics2D g = null;

    public GraphicsProgressBar(Graphics2D g) {
    	this.g = g;
        isApplet = false;
        setSize (width, height);
        initPB(null);
        paintComponent(g);
    }

   /* public graphicsProgressBar (AppletStub stub) {
        initPB(stub);
    }*/

    private void schedule(final Runnable runnable, long period) {
        // fading in/out bahvior
        timer.schedule(new TimerTask() {
            @Override
			public void run() {
                try {
                    EventQueue.invokeAndWait(runnable);
                } catch (Exception e) {
                    System.err.println("Timer error: " + e);
                }
            }
        }, period, period);
    }

    private void initPB (AppletStub stub) {
        //this.pm = pm;
        this.stub = stub;
        schedule(new Runnable () {
            @Override
			public void run() {
              alpha += fadingFactor;
              if (alpha <= 40)
                  fadingFactor = 10;
              if (alpha >250)
                  fadingFactor = -10;
              paintComponent(g);
            }
        },90);
      
        getParams (this.stub);
        
        bgGradient = new RadialGradientPaint(
                getWidth()/2.0f, getWidth()/2.0f,
                getWidth()*0.9f,
                FG_POS,
                FG_COLORS
        );
    }

    /*
     * Gets parameters defined in JNLP file or applet tag
     */
    private void getParams (AppletStub stub) {
        // app/applet dimensions
        width = getValue(stub, "width");
        height = getValue (stub, "height");

        if (width < 0) width = DEFAULT_WIDTH;
 
        if (height < 0) height = DEFAULT_HEIGHT; 

        tvX = ( width - TV_WIDTH) /2;
        tvY = ( height - TV_HEIGHT) /2;
        tvbaseX = tvX + TV_WIDTH/4;
        tvbaseY = tvY + TV_HEIGHT;
        tvbaseWidth = TV_WIDTH/2;
    }

  
    private int getValue (AppletStub stub, String param) {
        String value = null;

        if (stub != null) {
            value = stub.getParameter(param);

            //System.out.println("Parameter: " + param + " = " + value);

            if (value != null) {
                try {
                    return Integer.decode (value);
                } catch (NumberFormatException e) { System.err.println ("Error parsing " + value);}
            }
        }
        return -1;
    }
  

    public void progress (int value) {
        value -= value %10;
        //System.out.println ("Progress %: " + value);
        if (value > lastProgressPercentage) {
            lastProgressPercentage = value;
            paintComponent(g);
        }
        if (value >= 100) {
             // cancel animation timer and callback to hide frame/dialog
             timer.cancel();
            /* if (pm != null) 
                 pm.done();*/
        }
    }

    @Override
	public int getWidth () {
        return width;
    }

    @Override
	public int getHeight () {
        return height;
    }

    public void paintComponent(Graphics2D graphics2D) {
        if (buffer == null || buffer.getWidth() != width || buffer.getHeight() != height) {
            buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        }

       /* Graphics2D graphics2D = (Graphics2D) buffer.getGraphics();*/
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        graphics2D.setStroke(STROKE);

        if (lastProgressPercentage >=0 && lastProgressPercentage <100) {
            // background

            graphics2D.scale (1, 0.5d);
            graphics2D.setPaint (bgGradient);
            graphics2D.fillRect (0, 0, getWidth(), 2*getHeight());
            graphics2D.scale (1, 2.0);

            // draw TV
            graphics2D.setPaint (new Color (255,255,255, alpha));
            graphics2D.drawRect (tvX, tvY, TV_WIDTH, TV_HEIGHT);
            graphics2D.drawRect (tvX+10, tvY+10, TV_WIDTH-20, TV_HEIGHT-20);

            // draw TV base
            graphics2D.drawLine (tvbaseX, tvbaseY+21, tvbaseX, tvbaseY+26);
            graphics2D.drawLine (tvbaseX+tvbaseWidth, tvbaseY+21, tvbaseX+tvbaseWidth, tvbaseY+26);
            graphics2D.drawLine (tvbaseX+1, tvbaseY+26, tvbaseX+tvbaseWidth-1, tvbaseY+26);

            Q.setCurve(tvbaseX+16, tvbaseY+1, tvbaseX+14, tvbaseY+15, tvbaseX+1, tvbaseY+20);
            graphics2D.draw(Q);
            Q.setCurve(tvbaseX+tvbaseWidth-16, tvbaseY+1, tvbaseX+tvbaseWidth-14, tvbaseY+15, tvbaseX+tvbaseWidth-1, tvbaseY+20);
            graphics2D.draw(Q);

            // draw %
            String text = Integer.toString(lastProgressPercentage) + "%";
            //String text = new String ("Loading...");
            graphics2D.setFont(LABEL_FONT);
            FontMetrics fm = graphics2D.getFontMetrics();
            int textWidth = fm.stringWidth(text);
            int textHeight = fm.getHeight();

            graphics2D.setColor(LABEL_COLOR);
            graphics2D.drawString (text, (getWidth() - textWidth)/2 , (getHeight()+textHeight)/2);

            if (!isApplet) {
                // close button rendering
                graphics2D.setColor(CLOSE_BTN_CLR);

                BasicStroke stroke = new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
                graphics2D.setStroke(stroke);
                graphics2D.drawLine(getWidth()-CLOSE_X_FROM_RIGHT, CLOSE_Y, getWidth()-CLOSE_X_FROM_RIGHT+CLOSE_WIDTH,  CLOSE_Y+CLOSE_WIDTH);
                graphics2D.drawLine(getWidth()-CLOSE_X_FROM_RIGHT, CLOSE_Y+CLOSE_WIDTH, getWidth()-CLOSE_X_FROM_RIGHT+CLOSE_WIDTH, CLOSE_Y);
            }
        }

        paintChildren (graphics2D);
        g.drawImage(buffer, 0, 0, this);

        g.dispose();
    }


}
