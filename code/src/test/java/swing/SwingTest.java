package swing;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import freeseawind.ninepatch.swing.SwingNinePatch;

public class SwingTest
{

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                	InputStream input = SwingTest.class.getResourceAsStream("/bg_bubble@2x.9.png");
                	
                    final BufferedImage img = ImageIO.read(input);

                    JFrame frame = new JFrame();
                    
                    frame.setTitle("NinePatch Test");

                    final SwingNinePatch np = new SwingNinePatch(img);

                    frame.setContentPane(new JPanel()
                    {
						private static final long serialVersionUID = 4553891044949357197L;

						@Override
                        protected void paintComponent(Graphics g)
                        {
                            super.paintComponent(g);

                            Graphics2D g2d = (Graphics2D)g;

                            np.drawNinePatch(img, g2d, 28, 28, 100, 100);
                        }
                    });

                    frame.setSize(480, 360);

                    frame.setVisible(true);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

}
