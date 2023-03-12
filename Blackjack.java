//Vasiliki Katogianni 
import java.util.Scanner;
class Blackjack{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Give the number of players:");
		int num=input.nextInt();
		BlackjackTable blackjacktable=new BlackjackTable(num);
		blackjacktable.play();
	}	
}