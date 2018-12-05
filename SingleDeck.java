/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitare;


import java.util.Arrays;
import java.util.Random;
import java.util.Stack;


/**
 *
 * @author S0335108
 */
public class SingleDeck
{
    private Stack<Card> Deck=new Stack<>();
    
    
    public SingleDeck()
    {
        Random r=new Random();
        Card[] preShuffle=new Card[52];
        int index=0;
        for(int rank=1;rank<=13;rank++)
        {
            for(int suit=0;suit<4;suit++)
            {
                preShuffle[index]=new Card(rank,suit);
                index++;
            }
        }
        for(int n=1000;n>0;n--)
        {
            int index_1=Math.abs(r.nextInt()%preShuffle.length),index_2=Math.abs(r.nextInt()%preShuffle.length);
            Card temp=preShuffle[index_1];
            preShuffle[index_1]=preShuffle[index_2];
            preShuffle[index_2]=temp;
        }
        Deck.addAll(Arrays.asList(preShuffle));        
    }
    
    public Card draw()
    {
        return Deck.pop();
    }
    
    public boolean isEmpty()
    {
        return Deck.isEmpty();
    }
    
    public void push(Card c)
    {
        Deck.push(c);
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
       
        for(Card c:this.Deck)
        {
            sb.append(c.toString());
            sb.append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
