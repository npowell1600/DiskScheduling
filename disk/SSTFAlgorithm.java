import java.util.ArrayList;

public class SSTFAlgorithm extends ScheduleAlgorithmBase{
	public SSTFAlgorithm(int initPosition, int maxCylinders, int direction, ArrayList<Integer> q){
		super(initPosition, maxCylinders, direction, q);
	}
	public String getName() {
		return "SSFT";
	}

	public void calcSequence(){
		ArrayList<Integer> newArray = new ArrayList<>(referenceQueue);
		while(newArray.size() >0){
			//Check current positon and compare
			//to the rest of the list.
			//then finding closest number, then move the head
			//repeat the process until done.
			int firstVal = newArray.get(0);
	        	int sekTim = Math.abs(position - firstVal);
			int id=0;
			for(int j = 1; j < newArray.size(); j++) {
				int  newValue= newArray.get(j);
				if(Math.abs(newValue-position)<sekTim) {
					sekTim= Math.abs(newValue - position);
					id = j;
					firstVal = newValue;
				}
			}
			seekToSector(firstVal);
			newArray.remove(id);
		}
         }
}
