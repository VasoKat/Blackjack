//Vasiliki Katogianni 
import java.util.Scanner;
class BlackjackTable{
	private River pot=new River(6);
	private CasinoCustomer[] pinakas;
	private int numberofplayers;
	public BlackjackTable(int numberofplayers){
		this.numberofplayers=numberofplayers;
		pinakas=new CasinoCustomer[numberofplayers];
		for(int i=0;i<pinakas.length;i++){
			pinakas[i]=createCasinoCustomer();
		}	
	}                                                                      
	private CasinoCustomer createCasinoCustomer(){                         
		Scanner input = new Scanner(System.in);                           
		System.out.print("Give customer name and available money:");     
		String ans=input.next();                                         
		double y=input.nextDouble();
		CasinoCustomer pel=new CasinoCustomer(ans,y);
		return pel;
	}	
	public void play(){
		for(int i=0;i<pinakas.length;i++){
			while(pinakas[i].isBroke()==false){
				Round giros =new Round(pot);
				for(int o=0;o<pinakas.length;o++){
					if(pinakas[o].isBroke()==false){
						giros.addPlayer(pinakas[o]);
					}
				}
				if(pot.shouldRestart()==true){
					pot.restart();
				}
				System.out.println();
				System.out.println("---- New Round! ---");
				System.out.println();
				giros.playRound();	
			}
		}	
	}
}