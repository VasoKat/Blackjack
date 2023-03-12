//Vasiliki Katogianni 
class Card{
	private String figure;
	private Integer value;
	public Card(String figure){
		this.figure=figure;
	}
	public Integer getValue(){
		if(figure.equals("2")){
			value=2;
		}else if(figure.equals("3")){
			value=3;
		}else if(figure.equals("4")){
			value=4;
		}else if(figure.equals("5")){
			value=5;
		}else if(figure.equals("6")){
			value=6;
		}else if(figure.equals("7")){
			value=7;
		}else if(figure.equals("8")){
			value=8;	
		}else if(figure.equals("9")){
			value=9;	
		}else if(figure.equals("10")){
			value=10;	
		}else if(figure.equals("A")){
			value=1;	
		}else{
			value=10;
		}	
		return value;
	}	
	public boolean isAce(){
		if(figure.equals("A")){
			return true;
		}
		return false;
	}
	public boolean equals(Card other){
		if(this.figure.equals(other.figure)){
			return true;
		}
		return false;
	}
	public String toString(){
		return figure;
	}
}	