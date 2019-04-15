import java.util.ArrayList;

public class creationCraft {
	
	ArrayList tableCraft = new ArrayList();
	Integer resultat;
	
	ArrayList liste;
	Integer lid;
	
	public creationCraft(ArrayList arrayList,int res) {
		
		this.tableCraft=arrayList;
		this.resultat=res;
		
		this.liste = new ArrayList();
		this.liste.addAll(arrayList);
		this.lid=res;

	}

}
