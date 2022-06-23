import java.util.ArrayList;
import java.util.Collections;
//This is just a copy of SCAN and LOOK is also a copy of SCAN while CLOOK is copied from CSCAN
public class CSCANAlgorithm extends ScheduleAlgorithmBase{
	public CSCANAlgorithm(int initPosition, int maxCylinders, int direction, ArrayList<Integer> q){
		super(initPosition, maxCylinders, direction, q);
	}
	public String getName() {
		return "CSCAN";
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
		leftArray.add(0);
		rightArray.add(numCylinders-1);
		Collections.sort(leftArray);
		Collections.sort(rightArray);
		if(direction == 1){
			Collections.sort(leftArray);
			Collections.sort(rightArray);

			for(int j = leftArray.size()-1;j>=0;  j--){
				seekToSector(leftArray.get(j));	
			}
			for(int j =rightArray.size()-1;j>=0; j--){
				seekToSector(rightArray.get(j));
			}
		}
		if(direction == 0){
			Collections.sort(rightArray);
			Collections.sort(leftArray);
			for(int j=0;j<rightArray.size(); j++) {
				seekToSector(rightArray.get(j));
			}
			for(int j = 0; j<leftArray.size();j++){
				seekToSector(leftArray.get(j));
			}
		}
	}
}
