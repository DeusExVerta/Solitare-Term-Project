/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitare;


import java.io.File;
import java.io.IOException;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;


/**
 *
 * @author S0335108
 */
public class Card
{
    private int rank,suit;
    private boolean faceUp=true;
    //private BufferedImage face;
    
    public Card(int rank,int suit)
    {
        this.suit=suit;
        this.rank=rank;
    }
    
    public String getFace() throws Exception
    {
       String faceName="";
       switch(rank)
       {
           case 1:
               faceName+="A";
               break;
           case 11:
               faceName+="J";
               break;
           case 12:
               faceName+="Q";
               break;
           case 13:
               faceName+="K";
               break;
           default:
               faceName+=rank;
               break;
       }
       switch(suit)
        {
            case 0:
                faceName+="S";
                break;
            case 1:
                faceName+="D";
                break;
            case 2:
                faceName+="C";
                break;
            case 3:
                faceName+="H";
                break;
            default:
                break;
                
        }
       return this.getClass().getResource("").getPath()+"\\CardPNG\\"+faceName+".png";
    }
    
    public int getSuit()
    {
        return suit;
    }
    
    public int getRank()
    {
        return rank;
    }
    
    public void flipUp()
    {
        this.faceUp=true;
    }
    
    @Override
    public String toString()
    {
        if(!faceUp)
        {
            return "[]";
        }
        String display="";
        switch(this.rank)
        {
            case 1:
                display+="A";
                break;
            case 11:
                display+="J";
                break;
            case 12:
                display+="Q";
                break;
            case 13:
                display+="K";
                break;
            default:
                display+=this.rank;
                break;
        }
        switch(suit)
        {
            case 0:
                display+="S";
                break;
            case 1:
                display+="D";
                break;
            case 2:
                display+="C";
                break;
            case 3:
                display+="H";
                break;
            default:
                display+="Bad Suit";//potentially throw exception here;
                break;
        }
        return display;
    }
    
}
