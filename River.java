//Vasiliki Katogianni 
import java.util.Random;
class River{
	private Card[] ar;
	private String[] arfig={"2","3","4","5","6","7","8","9","10","A","J","Q","K"};
	private int packofCards;
	private int numberOfCards;
	private int cardsLeft;
	public River(int packofCards){
		this.packofCards=packofCards;
		this.numberOfCards=packofCards*52;
		this.cardsLeft=numberOfCards;            
		ar=new Card[4*arfig.length*packofCards];
		int count=0; 
		for(int i=0;i<ar.length*4;i++){
			if(i==numberOfCards){
				break;
            }
			for(int t=0;t<4*packofCards;t++){
				ar[t+i]=new Card(arfig[i-count]);
			} 
			i+=4*packofCards-1;
			count+=4*packofCards-1;  
        }    		
	}
	public Card nextCard(){
		if(cardsLeft<1){
			return null;
		}
		Random rnd=new Random(); 
		int random=rnd.nextInt(cardsLeft);
		Card old=ar[random];
		ar[random]=ar[cardsLeft-1];
		ar[cardsLeft-1]=old;
		cardsLeft--;
		return old;
	}
	public boolean shouldRestart(){
		if(cardsLeft<numberOfCards/4){
			return true;
		}
		return false;
	}
	public void restart(){
		cardsLeft=numberOfCards;
	}
	public int getCardsLeft(){
		return cardsLeft;
	}	
	public static void main(String[] args){
		River rivercard=new River(1);
		while(rivercard.shouldRestart()==false){
			System.out.println(rivercard.nextCard());
		}
		rivercard.restart();
		while(rivercard.getCardsLeft()!=0){
			System.out.println(rivercard.nextCard());
		}
	}	
}
	