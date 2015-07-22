import javax.swing.*;
import java.awt.*;
import java.awt.Image;

/**
 * Created by davidgudeman on 7/21/15.

public class ImagePanel extends JPanel
{
    private Image img;
   int DEFAULT_WIDTH = 1600;
    int DEFAULT_HEIGHT = 800;

    public ImagePanel(Image img)
    {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));

        getSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setLayout(null);

    }
    public void paintComponent(Graphics g)
    {
        g.drawImage(img, 0, 0, null);
    }
    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
*/
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/*
 * ScalingMethods.java
 *
 * Created on May 1, 2007, 4:36 PM
 *
 * Copyright (c) 2007, Sun Microsystems, Inc
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   * Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above
 *     copyright notice, this list of conditions and the following
 *     disclaimer in the documentation and/or other materials provided
 *     with the distribution.
 *   * Neither the name of the TimingFramework project nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/**
 *
 * @author Chet
 */
public class ImagePanel extends JComponent {

    private static BufferedImage picture = null;
    private static final int PADDING = 10;
    private static final double SCALE_FACTOR = 1.5;
    private int scaleW, scaleH;

    /** Creates a new instance of ScalingMethods */
    public ImagePanel() {
        try {
            String imageName= "MAP.jpg";
            File input = new File(imageName);
            picture = ImageIO.read(input);

            scaleW = (int)(SCALE_FACTOR * picture.getWidth());
            scaleH = (int)(SCALE_FACTOR * picture.getHeight());
            setPreferredSize(new Dimension(PADDING + (1 * (scaleW + PADDING)),
                    scaleH + (2 * PADDING)));
        } catch (Exception e) {
            System.out.println("Problem reading image file: " + e);
            System.exit(0);
        }
    }

    /**
     * Draws the picture five times, using the five different scaling
     * approaches described in the book. All five look the same, since
     * all are using default (nearest neighbor) filtering during the
     * scale operation.
     */
    public void paintComponent(Graphics g) {
        int x = PADDING;
        int y = PADDING;

        // Simplest approach
        g.drawImage(picture, x, y, scaleW, scaleH, null);

        // Subregion approach
        x += scaleW + PADDING;
        g.drawImage(picture, x, y, x + scaleW, y + scaleH,
                0, 0, picture.getWidth(), picture.getHeight(), null);

        // Graphics2D.scale approach
        x += scaleW + PADDING;
        Graphics2D g2d = (Graphics2D)g.create();
        g2d.translate(x, y);
        g2d.scale(SCALE_FACTOR, SCALE_FACTOR);
        g2d.drawImage(picture, 0, 0, null);
        g2d.dispose();

        // AffineTransform.scale approach
        x += scaleW + PADDING;
        g2d = (Graphics2D)g.create();
        AffineTransform at = new AffineTransform();
        at.translate(x, y);
        at.scale(SCALE_FACTOR,SCALE_FACTOR);

        g2d.drawImage(picture, at, null);
        g2d.dispose();

        // getScaledInstance() approach
        x += scaleW + PADDING;
        Image scaledImg = picture.getScaledInstance(scaleW, scaleH,
                Image.SCALE_DEFAULT);
        g.drawImage(scaledImg, x, y, null);
    }

   /* private static void createAndShowGUI() {
        JFrame f = new JFrame("ScalingMethods");
        f.setLayout(new BorderLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImagePanel test = new ImagePanel();
        f.add(test);
        f.validate();
        f.pack();
        f.setVisible(true);
    }

    public static void main(String args[]) {
        Runnable doCreateAndShowGUI = new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        };
        SwingUtilities.invokeLater(doCreateAndShowGUI);
    }
*/
}
