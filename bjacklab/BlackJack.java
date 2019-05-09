//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack
{
	//add in Player instance variable
	//add in Dealer instance variable
	private Player player;
	private Dealer dealer;

	private boolean hit;

  public BlackJack()
  {
  	player = new Player();
  	dealer = new Dealer();
  	hit = true;
  }

  public void playGame()
  {
    Scanner keyboard = new Scanner(System.in);
    char choice = 0;

    dealer.shuffle();
    player.resetHand();
    dealer.resetHand();

    player.addCardToHand(dealer.deal());
    player.addCardToHand(dealer.deal());

    dealer.addCardToHand(dealer.deal());
    dealer.addCardToHand(dealer.deal());

    System.out.println("Player Hand:\n" + player);
    //we don't know dealer's hand until after player finishes

    while(player.getHandValue() <= 21 && hit) {
    	System.out.print("hit? y/n :: ");
    	if(hit = (keyboard.next().charAt(0) == 'y')) {
    		player.addCardToHand(dealer.deal());
    	} else {
    		hit = false;
    	}
    	System.out.println("Player Hand:\n" + player);
    }
    if(player.getHandValue() > 21) {
    	System.out.println("Shucks! You busted!");
    	return;
    }
    //else dealer's turn
    System.out.println("Dealer's Hand:\n" + dealer);
    Card temp = null;
    while(dealer.getHandValue() < 17) { // later implement dealer hit on "soft" 17 (A + 6)
    	dealer.addCardToHand(temp = dealer.deal());
    	System.out.println("dealer hits: " + temp);
    	System.out.println("Dealer Hand Value: " + dealer.getHandValue());
    }
    if(dealer.getHandValue() > 21) {
    	System.out.println("Dealer busted! You win!");
    } else {
    	if(player.getHandValue() > dealer.getHandValue()) {
    		System.out.println("You win! Your hand (" + player.getHandValue() + ") is larger than the dealer's hand (" + dealer.getHandValue() + ")!");
    	} else if(player.getHandValue() == dealer.getHandValue()) {
    		System.out.println("It's a tie! Your hand (" + player.getHandValue() + ") is the same as the dealer's hand (" + dealer.getHandValue() + ")!");
    	} else {
    		System.out.println("Dealer wins! Your hand (" + player.getHandValue() + ") is smaller than the dealer's hand (" + dealer.getHandValue() + ")!");
    	}
    }
  }
        
  public static void main(String[] args)
  {
    BlackJack game = new BlackJack();
    game.playGame();
  }
}