/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitare;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * TODO: WINNING THE GAME.
 * TODO: handle null pointer exception when moving all cards from pile to itself
 * Restart Button.
 *
 * @author S0335108
 */
public class Solitare
{
    public static void main(String args[])//void solitare
    {       
        boolean gamelive=true;
        Scanner sc = new Scanner(System.in);        
        SingleDeck singleDeck=new SingleDeck();
        ScoreArea score=new ScoreArea();
        Stack<Card> discard=new Stack<>();
        
        PlayArea p = new PlayArea(singleDeck,discard,score);
        
        
        
        //System.out.print("["+discard.peek()+"]\n");
        System.out.print(p);
        //System.out.print(score);
        
        System.out.println("input move (To,From,Depth)\n -type EXIT to quit\n-type SCORE as \"to\" to score a card\n-type DISCARD as \"from\" to take the card from the discard ");
        String move=sc.next().toUpperCase();
            if(move.equals("EXIT"))
            {
                gamelive=false;
            }
            
        while(gamelive)
        {
            //this should all be redone using GUI rather than strings
            int to,from,depth;
            String movearray[]=move.split("\\(|\\)|,");//loop through this array for to get the first second and third integer values
            System.out.print(Arrays.toString(movearray)+"\n");
            try{     
                if(movearray[0].equals("EXIT"))
                    {
                        gamelive=false;
                        break;
                    }else if(movearray[0].equals("SCORE"))//instead of shortcut give score and discard their own indecies
                    {
                        if(movearray[1].equals("DISCARD"))
                        {
                            if(score.Score(discard.peek()))
                            {
                                discard.pop();
                            }
                        }
                        else
                        {
                            from=Integer.parseInt(movearray[1]);
                            score.Score(p.popTop(from));    
                        }
                    }else if(movearray[0].equals("DRAW"))
                    {
                        if(singleDeck.isEmpty())
                        {
                            while(!discard.isEmpty())
                            {
                                singleDeck.push(discard.pop());
                            }
                        }
                        discard.push(singleDeck.draw());
                    }else if(movearray[1].equals("DISCARD"))
                    {
                        to=Integer.parseInt(movearray[0]);
                        if(!discard.isEmpty())
                        {
                            Card c=discard.peek();
                            if(p.moveTo(to, c))
                            {
                                discard.pop();
                            }else
                            {
                                System.out.println("Illegal Move...");
                            }
                        }
                        else
                        {
                            System.out.println("Illegal Move...\n Discard Empty!");
                        }
                    }else if((to=Integer.parseInt(movearray[0]))>=0&&to<=8)
                    {
                        from=Integer.parseInt(movearray[1]);
                        depth=Integer.parseInt(movearray[2]);
                        p.makeMove(to,from,depth);
                    }
            }catch(IndexOutOfBoundsException ex)
            {
                System.out.println("Invalid Input: To few arguments provided");
                System.out.println(ex);
            }
            catch(NumberFormatException ex)
            {
                System.out.println("Invalid Input");
                System.out.println(ex);
            }
            
//            System.out.print("[");
//            if(!discard.isEmpty()) {
//                System.out.print(discard.peek());
//            }
//            System.out.println("]");
            System.out.print(p);
            //System.out.print(score);
            
            System.out.println("input move (To,From,Depth) type EXIT to quit:");
            move=sc.next().toUpperCase();
            
        }

    }

}
