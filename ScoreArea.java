/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitare;


import java.util.ArrayList;
import java.util.Stack;


/**
 *
 * @author S0335108
 */
public class ScoreArea
{
    ArrayList<Stack<Card>> area= new ArrayList<Stack<Card>>();
    
    public ScoreArea()
    {
        //Hearts,Spades,Clubs,Diamonds
        for(int i=0;i<4;i++)
        {
            area.add(new Stack<Card>());
            area.get(i).add(new Card(0,i));
        }
    }
    
    public boolean Score(Card c)
    {
        if(area.get(c.getSuit()).peek().getRank()==c.getRank()-1)
        {
            area.get(c.getSuit()).add(c);
            return true;
        }
        return false;
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(Stack<Card> scoreStack:area)
        {
            sb.append("[");
            sb.append(scoreStack.peek());
            sb.append("]");
        }
        sb.append("}\n");
        return sb.toString();
    }
}
