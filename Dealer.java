//Vasiliki Katogianni 
class Dealer{
	private River river;
	private Hand list=new Hand();
	public Dealer(River river){
		this.river=river;
	}
	public Hand getList(){
		return list;
	}
	public void draw(){
		list.addCard(river.nextCard());
		list.score();
	}
	public void playerscore(Player other){
		other.getHandpl().score();
	}	
	public void dealerscore(){
		list.score();
	}
	public void deal(Player other){
		other.getHandpl().addCard(river.nextCard());
		other.getHandpl().score();
	}
	public void play(){
		while(list.score()<17){
			draw();
		}
	}
	public void settle(Player another){
		if(list.isBust()==true){
			if(another.getHandpl().isBust()==false || another.getHandpl().isBlackjack()==false){
				another.wins();
			}
		}else if(another.getHandpl().isBust()==true){
			another.loses();
		}else if(list.score()<another.getHandpl().score()){ 	
			another.wins();
		}else if(list.score()>another.getHandpl().score()){ 	
			another.loses();
		}else{
			System.out.println("Tie with "+another.getCust()+". Nobody wins");
		}	
	}		
	public String toString(){
		return "Dealer: "+list;
	}	
	public static void main(String[] args){
		River trapoula=new River(1); 
		Dealer dl=new Dealer(trapoula);
		dl.play();
		System.out.println(dl);
		CasinoCustomer me1=new CasinoCustomer("vaso",100);
		Player me=new Player(me1);
		dl.deal(me);
		dl.deal(me);
		System.out.println(me);
		dl.settle(me);
	}
}	