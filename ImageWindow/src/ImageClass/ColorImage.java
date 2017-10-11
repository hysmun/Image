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
    //<editor-fold defaultstate="collapsed" desc="Variable">
    public BufferedImage bi;
    public int type; // 1 pour couleur      2 pour gris
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructeur">
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
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getteur">
    int getGreen(int i, int j){
        Color tmpC = new Color(bi.getRGB(i, j));
        return tmpC.getGreen();
    }
    
    int getBlue(int i, int j){
        Color tmpC = new Color(bi.getRGB(i, j));
        return tmpC.getBlue();
    }
    
    int getRed(int i, int j){
        Color tmpC = new Color(bi.getRGB(i, j));
        return tmpC.getRed();
    }
    
    public int getGrey(int i, int j){
        Color tmpC = new Color(bi.getRGB(i, j));
        return tmpC.getRed();
    }
    
    public BufferedImage getBi() {
        return bi;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Setteur">
    public void setSize(int i, int j){
        BufferedImage tmp = new BufferedImage(i, j, bi.getType());
        Graphics g = tmp.getGraphics();
        g.fillRect(0, 0, i, j);
        g.drawImage(bi, 0, 0, null);
        g.dispose();
        this.bi = tmp;
    }
    
    public void setGrey(int i, int j, int grey){
        Color tmp = new Color(grey, grey, grey);
        bi.setRGB(i, j, tmp.getRGB());
    }
    
    public void setBi(BufferedImage tbi) {
        this.bi = new BufferedImage(tbi.getWidth(), tbi.getHeight(), tbi.getType());
        Graphics g = this.bi.getGraphics();
        g.drawImage(tbi, 0, 0, null);
        g.dispose();
        if(tbi.getType() == BufferedImage.TYPE_BYTE_GRAY)
        {
            type = 2;
        }
        else
        {
            type = 1;
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ROI">
    public void ROI(int x1, int y1, int x2, int y2){
        for(int i =0; i < (x2-x1); i++)
        {
            for(int j =0; j < (y2-y1); j++)
            {
                bi.setRGB(i, j, bi.getRGB(x1+i, y1+j));
            }
        }
        setSize(x2-x1, y2-y1);
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="palette">
    public void palette(int x, int y,int red, int green, int blue){
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
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Extraction - expansion">
    public void expansion(double x, double y){
        int i=0, j=0;
        BufferedImage tmpBi = new BufferedImage(bi.getWidth(), bi.getHeight(), bi.getType());
        Graphics g = tmpBi.getGraphics();
        g.drawImage(bi, 0, 0, null);
        g.dispose();
        
        setSize((int)(bi.getWidth()*x), (int)(bi.getHeight()*y));
        
        int V1, V2, VTOT;
        int m=0, n=0;
        try
        {
            System.out.println("Width : "+bi.getWidth()+" height : "+bi.getHeight());
            for(i=0; i<bi.getWidth(); i++)
            {
                for(j=0; j<bi.getHeight(); j++)
                {
                    try
                    {
                        m = ColorImage.coord((int)(i), x);
                        n = ColorImage.coord((int)(j), y);
                        V1 = ColorImage.interpolation(i/x, m, tmpBi.getRGB(m, n), m+1, tmpBi.getRGB(m+1, n));
                        V2 = ColorImage.interpolation(i/x, m, tmpBi.getRGB(m, n+1), m+1, tmpBi.getRGB(m+1, n+1));
                        VTOT = ColorImage.interpolation(j/y, n, V1, n+1, V2);
                        bi.setRGB(i, j, VTOT);
                    }
                    catch(ArrayIndexOutOfBoundsException e)
                    {
                        //
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Erreur : "+e.getMessage());
            System.out.println("i : "+i+"\tj : "+j+"\tm : "+m+"\tn : "+n);
        }
    }
    
    public void extraction(double x, double y){
        int i=0, j=0;
        int V1, V2, VTOT;
        int m=0, n=0;
        try
        {
            //copie
            BufferedImage tmpBi = new BufferedImage(bi.getWidth(), bi.getHeight(), bi.getType());
            Graphics g = tmpBi.getGraphics();
            g.drawImage(bi, 0, 0, null);
            g.dispose();
            
            //changement de la taille
            setSize((int)(bi.getWidth()/x), (int)(bi.getHeight()/y));
            
            
            System.out.println("Width : "+bi.getWidth()+" height : "+bi.getHeight());
            for(i=0; i<bi.getWidth(); i++)
            {
                for(j=0; j<bi.getHeight(); j++)
                {
                    m = ColorImage.coord((int) (i), 1/x);
                    n = ColorImage.coord((int) (j), 1/y);
                    V1 = ColorImage.interpolation((i*x), m, tmpBi.getRGB(m, n), m+1, tmpBi.getRGB(m+1, n));
                    V2 = ColorImage.interpolation((i*x), m, tmpBi.getRGB(m, n+1), m+1, tmpBi.getRGB(m+1, n+1));
                    VTOT = ColorImage.interpolation((j*y), n, V1, n+1, V2);
                    bi.setRGB(i, j, VTOT);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Erreur : "+e.getMessage());
            System.out.println("i : "+i+"\tj : "+j+"\tm : "+m+"\tn : "+n);
        }
        
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="toGrey">
    public void toGrey(){
        int i, j;
        int tmp;
        for(i=0; i<bi.getWidth(); i++)
        {
            for(j=0; j<bi.getHeight(); j++)
            {
                Color tmpC = new Color(bi.getRGB(i, j));
                tmp = (int)(0.2989*tmpC.getRed() + 0.5870*tmpC.getGreen() + 0.1140*tmpC.getBlue());
                setGrey(i, j, tmp);
            }
        }
        type = 2;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Seuillage">
    public void Seuillage(int seuil){
        int i, j;
        
        for(i=0; i<bi.getWidth(); i++)
        {
            for(j=0; j<bi.getHeight(); j++)
            {
                if(getGrey(i, j) > seuil)
                    setGrey(i, j, 255);
                else
                    setGrey(i, j, 0);
            }
        }
    }
    
    public void MultiSeuillage(int[] seuil){
        int i, j, k;
        
        for(i=0; i<bi.getWidth(); i++)
        {
            for(j=0; j<bi.getHeight(); j++)
            {
                if(getGrey(i,j) < seuil[0])
                    setGrey(i,j, 0);
                else if(getGrey(i,j)>= seuil[0] && getGrey(i, j) < seuil[1])
                    setGrey(i,j, 130);
                else if(getGrey(i,j) >= seuil[1] && getGrey(i,j) < seuil[2])
                    setGrey(i, j, 200);
                else
                    setGrey(i, j, 255);
                
            }
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Histogramme">
    public BufferedImage Histogramme(){
        int v = 700, h = 300, border = 20;
        BufferedImage ret = new BufferedImage(v, h, BufferedImage.TYPE_BYTE_GRAY);
        int i, j;
        int[] freq = new int[256];
        int max, facteur;
        
        for(i=0; i<bi.getWidth(); i++)
        {
            for(j=0; j<bi.getHeight(); j++)
            {
                freq[getGrey(i, j)]++;
            }
        }
        Graphics g = ret.getGraphics();
        g.fillRect(0, 0, v, h);
        g.setColor(Color.BLACK);
        g.drawLine(border, 0, border, h);
        g.drawLine(0, h-border, v, h-border);
        max = freq[0];
        for(i=1; i < freq.length; i++)
        {
            if(freq[i] > max)
                max = freq[i];
        }
        facteur = max / (h - border - 20);
        for(i=0; i < freq.length; i++)
        {
            g.drawLine(i*2+border+1, h-border, i*2+border+1, h-border-(freq[i] / facteur));
            g.drawLine(i*2+border, h-border, i*2+border, h-border-(freq[i] / facteur));
        }
        g.drawString(""+max, 0, h-border-(max / facteur));
        
        g.dispose();
        
        
        return ret;
    }
    
    public BufferedImage HistogrammeColor(){
        int v = 700, h = 300, border = 20;
        BufferedImage ret = new BufferedImage(v, h, BufferedImage.TYPE_INT_RGB);
        int i, j;
        int[] freqR = new int[256];
        int[] freqG = new int[256];
        int[] freqB = new int[256];
        int max, facteur;
        
        for(i=0; i<bi.getWidth(); i++)
        {
            for(j=0; j<bi.getHeight(); j++)
            {
                Color tmp = new Color(bi.getRGB(i, j));
                freqR[tmp.getRed()]++;
                freqB[tmp.getBlue()]++;
                freqG[tmp.getGreen()]++;
            }
        }
        Graphics g = ret.getGraphics();
        g.fillRect(0, 0, v, h);
        g.setColor(Color.BLACK);
        g.drawLine(border, 0, border, h);
        g.drawLine(0, h-border, v, h-border);
        max = freqR[0];
        for(i=1; i < freqR.length; i++)
        {
            if(freqR[i] > max)
                max = freqR[i];
            if(freqG[i] > max)
                max = freqG[i];
            if(freqB[i] > max)
                max = freqB[i];
        }
        int etatR =0;
        facteur = max / (h - border - 20);
        Color tmp;
        for(i=0; i < freqR.length; i++)
        {
            //red
            tmp = new Color(255, 0, 0, 255/2);
            g.setColor(tmp);
            g.drawLine(i*2+border+1, h-border, i*2+border+1, h-border-(freqR[i] / facteur));
            g.drawLine(i*2+border, h-border, i*2+border, h-border-(freqR[i] / facteur));
            
            //green
            tmp = new Color(0, 255, 0, 255/2);
            g.setColor(tmp);
            g.drawLine(i*2+border+1, h-border, i*2+border+1, h-border-(freqG[i] / facteur));
            g.drawLine(i*2+border, h-border, i*2+border, h-border-(freqG[i] / facteur));
            
            //blue
            tmp = new Color(0, 0, 255, 255/2);
            g.setColor(tmp);
            g.drawLine(i*2+border+1, h-border, i*2+border+1, h-border-(freqB[i] / facteur));
            g.drawLine(i*2+border, h-border, i*2+border, h-border-(freqB[i] / facteur));
        }
        g.setColor(Color.BLACK);
        g.drawString(""+max, 0, h-border-(max / facteur));
        
        g.dispose();
        
        
        return ret;
    }
    
    public void Egalisation(){
        int i, j, k;
        int[] freq = new int[256];
        int wid = bi.getWidth(), hei = bi.getHeight();
        double ratio = 255.0 / (wid * hei);
        
        for(i=0; i< wid; i++)
        {
            for(j=0; j<hei; j++)
            {
                freq[getGrey(i, j)]++;
            }
        }
        for(i=0; i<freq.length-1; i++)
        {
            freq[i+1] += freq[i];
        }
        freq[freq.length-1] = (wid * hei);
        
        for(i=0; i<wid; i++)
        {
            for(j=0; j<hei; j++)
            {
                setGrey(i, j, (int)(freq[getGrey(i, j)]*ratio));
            }
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Autre">
    static int interpolation(double x, int x1, int f1, int x2, int f2){
        Color c1 = new Color(f1);
        Color c2 = new Color(f2);
        int red1 = c1.getRed(), red2 = c2.getRed();
        int green1 = c1.getGreen(), green2 = c2.getGreen();
        int blue1 = c1.getBlue(), blue2 = c2.getBlue();
        double tmpR, tmpG, tmpB;
        
        tmpR = (red2- red1) / (x2 - x1);
        tmpR = tmpR*(x - x1);
        tmpR = red1+ tmpR;
        
        tmpB = (blue2- blue1) / (x2 - x1);
        tmpB = tmpB*(x - x1);
        tmpB = blue1+ tmpB;
        
        tmpG = (green2- green1) / (x2 - x1);
        tmpG = tmpG*(x - x1);
        tmpG = green1+ tmpG;
        
        
        Color tmp = new Color((int)tmpR, (int)tmpG, (int)tmpB);
        return tmp.getRGB();
    }
    
    static int coord(int x, double deltax){
        int tmp;
        tmp = (int) Math.floor(x / deltax);
        return tmp;
    }
    //</editor-fold>
}
