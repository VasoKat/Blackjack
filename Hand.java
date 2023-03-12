//Vasiliki Katogianni 
import java.util.ArrayList;
class Hand{
	private ArrayList<Card> hand = new ArrayList<Card>();
	private int scor=0;		
	public void addCard(Card x){
		hand.add(x);
	}	
	public int score(){
		scor=0;
		for(Card el:hand){
			scor+=el.getValue();
		}	
		int c=0;
		for(Card el:hand){
			if(el.isAce()==true){
				c++;
			}
		}  
		if(c<1){           
			scor=scor;
		}else if(c>=1 && (scor+10)<=21){
			scor=scor+10;
		}	
		return scor;
	}
	public boolean canSplit(){          
		if(hand.size()==2){             
            if(hand.get(0).equals(hand.get(1))==true){
				return true;
            }
         }   
		return false;
	}
	public Hand[] split(){
		if(canSplit()==true){
			Hand hand1 = new Hand();   
			Hand hand2 = new Hand(); 
			for(Card el:hand){
				hand1.addCard(el);
				hand2.addCard(el);
				hand1.score();
				hand2.score();
				break;
			}			
			Hand[] array = new Hand[2];
			array[0] = hand1;
			array[1] = hand2;
			return array;
		}
		return null;
	}	
	public boolean isBlackjack(){                                                
		if(hand.size()==2 && scor==21){                      
			return true;
		}
		return false;
	}
	public boolean isBust(){
		if(scor>21){
			return true;
		}
		return false;
	}	
	public String toString(){
		String output="";
		for(Card el:hand){
			output+=el.toString()+" ";
		}
		return output;
	}	
	public static void main(String[] args){
		Hand handofplayer=new Hand();
		Card ace=new Card("A");
		handofplayer.addCard(ace);
		handofplayer.addCard(ace);
		System.out.println(handofplayer);
		System.out.println(handofplayer.score());
		System.out.println(handofplayer.canSplit());
		Hand n1=handofplayer.split()[0];
		Hand n2=handofplayer.split()[1];
		System.out.println(n1);
		System.out.println(n2);
		Card king=new Card("K");
		n1.addCard(king);
		System.out.println(n1);
		System.out.println(n1.score());
		System.out.println(n1.isBlackjack());
		n1.addCard(ace);
		System.out.println(n1);
		System.out.println(n1.score());
		Card ten=new Card("10");
		n1.addCard(ten);
		System.out.println(n1);
		System.out.println(n1.score());
		System.out.println(n1.isBust());
	}	
}					