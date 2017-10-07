/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImageClass;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author 'Toine
 */
public class GreyImage {
    public BufferedImage bi;

    public BufferedImage getBi() {
        return bi;
    }

    public void setBi(BufferedImage tbi) {
        this.bi = new BufferedImage(tbi.getWidth(), tbi.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = this.bi.getGraphics();
        g.drawImage(tbi, 0, 0, null);
        g.dispose();
    }
    
    public GreyImage()
    {
    }
    
    public GreyImage(BufferedImage tbi)
    {
        setBi(tbi);
    }
    
    public int getGreen(int i, int j)
    {
        Color tmpC = new Color(bi.getRGB(i, j));
        return tmpC.getGreen();
    }
    public int getBlue(int i, int j)
    {
        Color tmpC = new Color(bi.getRGB(i, j));
        return tmpC.getBlue();
    }
    public int getRed(int i, int j)
    {
        Color tmpC = new Color(bi.getRGB(i, j));
        return tmpC.getRed();
    }
    
    public void setGrey(int i, int j, int grey)
    {
        Color tmp = new Color(grey, grey, grey);
        bi.setRGB(i, j, tmp.getRGB());
    }
    
    public int getGrey(int i, int j)
    {
        Color tmpC = new Color(bi.getRGB(i, j));
        return tmpC.getRed();
    }
    
    public void setSize(int i, int j)
    {
        BufferedImage tmp = new BufferedImage(i, j, bi.getType());
        Graphics g = tmp.getGraphics();
        g.fillRect(0, 0, i, j);
        g.drawImage(bi, 0, 0, null);
        g.dispose();
        this.bi = tmp;
    }
    
    public void ROI(int x1, int y1, int x2, int y2)
    {
        for(int i =0; i < (x2-x1); i++)
        {
            for(int j =0; j < (y2-y1); j++)
            {
                bi.setRGB(i, j, bi.getRGB(x1+i, y1+j));
            }
        }
        setSize(x2-x1, y2-y1);
    }
}
