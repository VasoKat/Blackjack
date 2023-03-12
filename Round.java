//Vasiliki Katogianni 
import java.util.ArrayList;
import java.util.Scanner;
class Round{
	private Dealer dealer;
	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Player> plsettle = new ArrayList<Player>();
	public Round(River var){
		dealer=new Dealer(var);
	}
	public void addPlayer(CasinoCustomer pl){
		Player pl1=new Player(pl);
		players.add(pl1);
	}	
	private void playNormalHand(Player paixtis){
		Scanner question = new Scanner(System.in);
		System.out.print("Hit?: ");
		String an=question.next();
		while(an.equals("y") && paixtis.getHandpl().isBust()==false){
			dealer.deal(paixtis);
			System.out.println(paixtis);
			if(paixtis.getHandpl().isBust()==false){
				System.out.print("Hit?: ");
				an=question.next();
			}	
		}
		if(paixtis.getHandpl().isBust()==true){
			paixtis.loses();
			System.out.println();
		}else{
			plsettle.add(paixtis);
			System.out.println();
		}
	}
	private void playDoubledHand(Player paixtis){
		paixtis.doubleBet();
		dealer.deal(paixtis);
		System.out.println(paixtis);
		if(paixtis.getHandpl().isBust()==true){
			paixtis.loses();
		}else{
			plsettle.add(paixtis);
		}	
		System.out.println();
	}
	private void playSplitHand(Player paixtis){
		Hand h1=paixtis.getHandpl().split()[0];
		Hand h2=paixtis.getHandpl().split()[1];
		Player pl1=new Player(paixtis.getCust(),h1,paixtis.getBet());
		Player pl2=new Player(paixtis.getCust(),h2,paixtis.getBet());
		System.out.println(pl1);
		playNormalHand(pl1);
		System.out.println(pl2);
		playNormalHand(pl2);
	}
	public void playPlayer(Player paixtis){
		if(paixtis.wantsToSplit()==true){
			playSplitHand(paixtis);
		}else if(paixtis.wantsToDouble()==true){
			playDoubledHand(paixtis);
		}else{
			playNormalHand(paixtis);
		}
	}	
	public void playRound(){
		for(Player p:players){
			p.placeBet();
			System.out.println();
		}
		for(Player p:players){
			dealer.deal(p);
		}
		dealer.draw();
		System.out.println(dealer);
		for(Player p:players){
			dealer.deal(p);
		}
		dealer.draw();
		for(Player p:players){
			System.out.println(p);
		}
		System.out.println();
		if(dealer.getList().isBlackjack()==true){
			System.out.println(dealer);
			for(Player p:players){
				dealer.settle(p);
			}	
		}else{
			for(Player p:players){
				if(p.getHandpl().isBlackjack()==true){
					p.winsBlackJack();
					System.out.println();
				}else{
					System.out.println("Player "+p);
					playPlayer(p);
				}
			}
			if(plsettle.size()!=0){
				dealer.play();
				System.out.println(dealer);
				for(Player p:plsettle){
					dealer.settle(p);
				}
			}	
		}		
	}
	public static void main(String[] args){
		River riv=new River(6);
		Round round=new Round(riv);
		CasinoCustomer cascust=new CasinoCustomer("vaso",100);
		round.addPlayer(cascust);
		round.playRound();
	}	
}	