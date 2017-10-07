/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImageClass;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author 'Toine
 */
public class ColorImage{
    public BufferedImage bi;
    public int type; // 1 pour couleur      2 pour gris

    public BufferedImage getBi() {
        return bi;
    }

    public void setBi(BufferedImage tbi) {
        this.bi = new BufferedImage(tbi.getWidth(), tbi.getHeight(), tbi.getType());
        Graphics g = this.bi.getGraphics();
        g.drawImage(tbi, 0, 0, null);
        g.dispose();
        type = 1;
    }
    
    public ColorImage()
    {
        type = 1;
    }
    
    public ColorImage(BufferedImage tbi)
    {
        setBi(tbi);
        if(tbi.getType() == BufferedImage.TYPE_BYTE_GRAY)
        {
            type = 2;
        }
        else
        {
            type = 1;
        }
    }
    
    int getGreen(int i, int j)
    {
        Color tmpC = new Color(bi.getRGB(i, j));
        return tmpC.getGreen();
    }
    int getBlue(int i, int j)
    {
        Color tmpC = new Color(bi.getRGB(i, j));
        return tmpC.getBlue();
    }
    int getRed(int i, int j)
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
    
    public void palette(int x, int y,int red, int green, int blue)
    {
        Color replace = new Color(red, green, blue);
        Color tmpC = new Color(bi.getRGB(x, y));
        Color tmp;
        for(int i=0; i<bi.getWidth();i++)
        {
            for(int j=0; j<bi.getHeight(); j++)
            {
                tmp = new Color(bi.getRGB(i, j));
                if(tmp.equals(tmpC))
                {
                    bi.setRGB(i, j, replace.getRGB());
                }
            }
        }
    }
    
    public void expansion(double x, double y)
    {
        int i, j;
        BufferedImage tmpBi = new BufferedImage(bi.getWidth(), bi.getHeight(), bi.getType());
        Graphics g = tmpBi.getGraphics();
        g.drawImage(bi, 0, 0, null);
        g.dispose();
        setSize((int)(bi.getWidth()*x), (int)(bi.getHeight()*y));
        for(i=0; i<bi.getWidth(); i++)
        {
            for(j=0; j<bi.getHeight(); j++)
            {
                
            }
        }
    }
    
    public void extraction(double x, double y) // retrecir
    {
        int i, j;
        
        //copie
        BufferedImage tmpBi = new BufferedImage(bi.getWidth(), bi.getHeight(), bi.getType());
        Graphics g = tmpBi.getGraphics();
        g.drawImage(bi, 0, 0, null);
        g.dispose();
        
        //changement de la taille
        setSize((int)(bi.getWidth()/x), (int)(bi.getHeight()/y));
        
        int V1, V2, VTOT;
        int m, n;
        
        for(i=0; i<bi.getWidth(); i++)
        {
            for(j=0; j<bi.getHeight(); j++)
            {
                m = ColorImage.coord((int)(i*x), x);
                n = ColorImage.coord((int)(j*y), y);
                V1 = ColorImage.interpolation(i, m, tmpBi.getRGB(m, n), m+1, tmpBi.getRGB(m+1, n));
                V2 = ColorImage.interpolation(i, m, tmpBi.getRGB(m, n+1), m+1, tmpBi.getRGB(m+1, n+1));
                VTOT = ColorImage.interpolation(j, n, V1, n+1, V2);
                bi.setRGB(i, j, VTOT);
            }
        }
        
    }
    
    static int addColor(int a, int b)
    {
        int tmp;
        Color ca = new Color(a);
        Color cb = new Color(b);
        int red, green, blue;
        
        red = ca.getRed() + ca.getRed();
        if(red > 255)
            red = 255;
        
        green = ca.getGreen() + ca.getGreen();
        if(green > 255)
            green = 255;
        
        blue = ca.getBlue() + ca.getBlue();
        if(blue > 255)
            blue = 255;
        
        Color ret = new Color(red, green, blue);
        return ret.getRGB();
    }
    
    static int minusColor(int a, int b)
    {
        int tmp;
        Color ca = new Color(a);
        Color cb = new Color(b);
        int red, green, blue;
        
        red = ca.getRed() - ca.getRed();
        if(red < 0)
            red = 0;
        
        green = ca.getGreen() - ca.getGreen();
        if(green < 0)
            green =0;
        
        blue = ca.getBlue() - ca.getBlue();
        if(blue < 0)
            blue = 0;
        
        Color ret = new Color(red, green, blue);
        return ret.getRGB();
    }
    
    static int interpolation(int x, int x1, int f1, int x2, int f2)
    {
        int tmp;
        tmp = ColorImage.minusColor(f2, f1) / (x2 - x1);
        tmp = tmp*(x - x1);
        tmp = ColorImage.addColor(f1, tmp);
        return tmp;
    }
    
    static int coord(int x, double deltax)
    {
        int tmp;
        tmp = (int) Math.ceil((x - (deltax/2)));
        return tmp;
    }
}
