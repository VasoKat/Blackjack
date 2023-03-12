//Vasiliki Katogianni 
import java.util.Scanner;
class Player{
	private CasinoCustomer cust;
	private Hand handpl=new Hand();
	private double bet;
	public Player(CasinoCustomer cust){
		this.cust=cust;
	}
	public Player(CasinoCustomer cust,Hand handpl,double bet){
		this.cust=cust;
		this.handpl=handpl;
		this.bet=bet;
	}
	public CasinoCustomer getCust(){
		return cust;
	}
	public Hand getHandpl(){
		return handpl;
	}
	public double getBet(){
		return bet;
	}
	public void wins(){
		cust.collectBet(bet);
		System.out.println("Player "+cust+" won! Collect $"+getBet());
	}
	public void winsBlackJack(){
		double bet1=1.5*bet;
		cust.collectBet(bet1);
		System.out.println("Blackjack! Player "+cust+" collects $"+bet1);
	}	
	public void loses(){
		cust.payBet(this.bet);
		System.out.println("Player "+cust+" lost! Pay $ "+getBet());
	}
	public void placeBet(){
		cust.printState();
		System.out.print(cust+" place your bet: ");
		Scanner input = new Scanner(System.in);
		double x=input.nextDouble();
		while(cust.canCover(x)==false || x<1){ 
			System.out.print(cust+" place your bet: ");
			x=input.nextDouble();	
		}
		this.bet=x;	
	}	
	public void doubleBet(){
		this.bet=2*bet;
	}
	public boolean wantsToDouble(){
		double bet1=2*bet;
		if(cust.canCover(bet1)==true){
			Scanner reader = new Scanner(System.in);
			System.out.print("Do you want to double? (y/n): ");
			String answer=reader.next();
			if(answer.equals("y")){
				return true;
			}
		}
		return false;
	}
	public boolean wantsToSplit(){
		double bet2=bet*2;
		if(cust.canCover(bet2)==true && handpl.canSplit()==true){
			Scanner reader = new Scanner(System.in);
			System.out.print("Do you want to split? (y/n): ");
			String answer=reader.next();
			if(answer.equals("y")){
				doubleBet();
				return true;
			}
		}
		return false;
	}
	public String toString(){
		return cust.toString() +": "+ getHandpl();
	}
	public static void main(String[] args){
		CasinoCustomer person=new CasinoCustomer("vaso",50);
		Player player =new Player(person);   
		player.placeBet();
		player.wantsToSplit();
		player.getCust().printState();
		player.wantsToDouble();
		player.getCust().printState();
		player.wins();
		player.getCust().printState();
		player.winsBlackJack();
		person.printState();
		player.loses();
		player.getCust().printState();
	}	
}	
			