//Vasiliki Katogianni 
class CasinoCustomer{
	private String name;
	private double money;
	public CasinoCustomer(String name,double money){
		this.name=name;                                               
		this.money=money;      										                                                       
	}																
	public void payBet(double bet){
		this.money-=bet;
	}                        								
	public void collectBet(double bet){									
		this.money+=bet;								
	}													
	public boolean canCover(double bet){					
		if(money>=bet){
			return true;
		}
		return false;
	}
	public boolean isBroke(){
		if(money<1){
			return true;
		}
		return false;
	}
	public String toString(){
		return name;
	}
	public void printState(){
		System.out.println(name+" has "+money+" left");
	}
}	