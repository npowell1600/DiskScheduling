import java.util.ArrayList;
import java.util.Collections;

public class SCANAlgorithm extends ScheduleAlgorithmBase{
	public SCANAlgorithm(int initPosition, int maxCylinders, int direction, ArrayList<Integer> q){
		super(initPosition, maxCylinders, direction, q);
	}
	public String getName() {
		return "SCAN";
	}

	public void calcSequence(){
		ArrayList<Integer> leftArray = new ArrayList<>();
		ArrayList<Integer> rightArray = new ArrayList<>();
		for(int j = 0; j < referenceQueue.size(); j++) {
			if(referenceQueue.get(j) < position &&  referenceQueue.get(j) != position){
			       leftArray.add(referenceQueue.get(j));//add values for the left array and the else is adding values to the right array
			}
			else {
				rightArray.add(referenceQueue.get(j));
			}
		}		
		Collections.sort(leftArray);
		Collections.sort(rightArray);
		if(direction == 1){ //used for left seek
			leftArray.add(0);
			Collections.sort(leftArray); //sort again for the zero
			for(int j = leftArray.size()-1; j >=0; j--){//print left in correct order with right
				seekToSector(leftArray.get(j));	
			}
			for(int j = 0; j <rightArray.size(); j++){
				seekToSector(rightArray.get(j));
			}
		}
		if(direction == 0){
			rightArray.add(numCylinders-1);
			Collections.sort(rightArray);//same thing again
			for(int j= 0; j <rightArray.size(); j++) {
				seekToSector(rightArray.get(j));
			}
			for(int j = leftArray.size()-1; j>=0;j--){
				seekToSector(leftArray.get(j));
			}
		}
	}
}
