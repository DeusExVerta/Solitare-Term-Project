/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitare;


import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

//TODO:Move Score and discard to PlayArea assign them special indicies
//Modify MakeMove to handle to Score index and from discard index  
/**
 *
 * @author S0335108
 */
public class PlayArea
{
    SingleDeck deck;
    private final ArrayList<Stack<Card>> area = new ArrayList<>();

    public final ArrayList<LinkedPositionalList<Card>> areaUp = new ArrayList<>();

    //index 8
    private ScoreArea score = new ScoreArea();

    //index 7
    private Stack<Card> discard = new Stack<>();

    public PlayArea()
    {
        this.deck = new SingleDeck();
        for ( int i = 0; i < 7; i++ )
        {
            area.add(new Stack<>());
            areaUp.add(new LinkedPositionalList<>());
            for ( int j = 0; j <= i; j++ )
            {
                if ( areaUp.get(i).isEmpty() )
                {
                    areaUp.get(i).addFirst(deck.draw());
                }
                else
                {
                    area.get(i).add(deck.draw());
                }
            }
        }
        discard.add(deck.draw());
    }

    public PlayArea( SingleDeck S, Stack<Card> discard, ScoreArea score )
    {
        this.deck = S;
        this.discard = discard;
        this.score = score;
        for ( int i = 0; i < 7; i++ )
        {
            area.add(new Stack<>());
            areaUp.add(new LinkedPositionalList<>());
            for ( int j = 0; j <= i; j++ )
            {
                if ( areaUp.get(i).isEmpty() )
                {
                    areaUp.get(i).addFirst(deck.draw());
                }
                else
                {
                    area.get(i).add(deck.draw());
                }
            }
        }
        discard.add(deck.draw());
    }
    
    public boolean isStackEmpty(int index)
    {
        return area.get(index).isEmpty();
    }
    
    //adds the card c to the top of the face up list at specified index 
    public boolean moveTo( int index, Card c )
    {
        if ( index == 8 )
        {
            return score.Score(c);
        }
        LinkedPositionalList<Card> areaUpTo = areaUp.get(index);
        if ( areaUpTo.isEmpty() && c.getRank() == 13 )
        {
            areaUp.get(index).addLast(c);
            return true;
        }
        if ( !areaUpTo.isEmpty() )
        {
            Card top = areaUpTo.last().getElement();
            if ( top.getRank() == c.getRank() + 1 && c.getSuit() % 2 != top.getSuit() % 2 )
            {
                areaUpTo.addLast(c);
                return true;
            }
        }
        return false;
    }

    //adds the specified list to the top of the face up list at the specified index  
    public boolean moveTo( int index, LinkedPositionalList<Card> list )
    {
        //Move to Score area.
        if ( index == 8 )
        {
            if ( list.size() == 1 )
            {
                return score.Score(list.first().getElement());
            }
            return false;
        }
        LinkedPositionalList<Card> areaUpTo = areaUp.get(index);
        Card c = list.first().getElement();
        if ( areaUpTo.isEmpty() && c.getRank() == 13 )
        {
            areaUp.get(index).addLast(list);
            return true;
        }
        if ( !areaUpTo.isEmpty() )
        {
            Card top = areaUpTo.last().getElement();
            if ( top.getRank() == c.getRank() + 1 && c.getSuit() % 2 != top.getSuit() % 2 )
            {
                areaUpTo.addLast(list);
                return true;
            }
        }
        return false;
    }

    //TODO move from discard and to score area
    //BUG move to empty, invalid move crashes the program
    //BUG to Score From Empty causes crash
    public void makeMove( int to, int from, int depth )
    {

        if ( from == to )
        {
            System.out.println("Illegal Move..");
            return;
        }
        //FROM Discard
        if ( from == 7 )
        {
            if ( ( !discard.isEmpty() ) && this.moveTo(to, discard.peek()) )
            {
                discard.pop();
                if ( discard.isEmpty() && !deck.isEmpty() )
                {
                    discard.add(deck.draw());
                }
            }
        }
        else
        {
            LinkedPositionalList<Card> areaUpFrom = areaUp.get(from);
            if ( depth >= 1 && !areaUpFrom.isEmpty() )
            {
                LinkedPositionalList<Card> list = areaUpFrom.subList(depth);
                if ( !moveTo(to, list) )
                {
                    System.out.println("Illegal Move..");
                    areaUpFrom.addLast(list);

                }
                if ( areaUpFrom.isEmpty() && !area.get(from).isEmpty() )
                {
                    areaUpFrom.addFirst(area.get(from).pop());
                }
            }
            else
            {
                System.out.println("IllegalMove...");
            }
        }
    }

    //returns but does not remove the top card of the stack at specified index
    private Card peekTop( int index )
    {
        return area.get(index).peek();
    }

    //removes and returns the top card of the stack at specified index
    public Card popTop( int index ) throws EmptyStackException
    {
        LinkedPositionalList<Card> areaUpFrom = areaUp.get(index);
        if ( areaUpFrom.isEmpty() )
        {
            throw new EmptyStackException();
        }
        Card c = areaUpFrom.remove(areaUpFrom.last());
        if ( areaUpFrom.isEmpty() && !area.get(index).isEmpty() )
        {
            areaUpFrom.addFirst(area.get(index).pop());
        }
        return c;
    }

    public Card peekDiscard()
    {
        return discard.peek();
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(discard.peek().toString());
        sb.append("\n");
        int index = 0;
        for ( Stack<Card> facedown : area )
        {
            sb.append(index);
            sb.append("[");

            sb.append("[");
            sb.append(facedown.size());
            sb.append("]");
            if ( areaUp.get(index).isEmpty() != true )
            {
                sb.append(areaUp.get(index));
            }
            sb.append("]\n");
            index++;
        }
        sb.append(score.toString());
        return sb.toString();
    }
}
