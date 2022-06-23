import java.util.ArrayList;
import java.util.Collections;

public class LOOKAlgorithm extends ScheduleAlgorithmBase{
	public LOOKAlgorithm(int initPosition, int maxCylinders, int direction, ArrayList<Integer> q){
		super(initPosition, maxCylinders, direction, q);
	}
	public String getName() {
		return "LOOK";
	}

	public void calcSequence(){
		ArrayList<Integer> leftArray = new ArrayList<>();
		ArrayList<Integer> rightArray = new ArrayList<>();
		for(int j = 0; j < referenceQueue.size(); j++) {
			if(referenceQueue.get(j) < position &&  referenceQueue.get(j) != position){
			       leftArray.add(referenceQueue.get(j));
			}
			else {
				rightArray.add(referenceQueue.get(j));
			}
		}		
		Collections.sort(leftArray);
		Collections.sort(rightArray);
		if(direction == 1){
			for(int j = leftArray.size()-1; j >=0; j--){
				seekToSector(leftArray.get(j));	
			}
			for(int j = 0; j <rightArray.size(); j++){
				seekToSector(rightArray.get(j));
			}
		}
		if(direction == 0){
			for(int j= 0; j <rightArray.size(); j++) {
				seekToSector(rightArray.get(j));
			}
			for(int j = leftArray.size()-1; j>=0;j--){
				seekToSector(leftArray.get(j));
			}
		}
	}
}
