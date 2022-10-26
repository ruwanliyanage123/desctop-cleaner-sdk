import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
    }

    public int migratoryBirds(List<Integer> arr) {
        Set<Integer> ids = new HashSet();
        for(int i=0; i< arr.size(); i++){
            ids.add(arr.get(i));
        }
        Map<Integer, Integer> idMap = new HashMap<>();
        for(Integer id: ids){
            int count =0;
            for(int i=0; i< arr.size(); i++){
                if(id == arr.get(i)){
                    count++;
                }
            }
            idMap.put(id, count);
        }

        List<Integer> counts = new ArrayList();

        for(Map.Entry<Integer,Integer> map: idMap.entrySet()){
            counts.add(map.getValue());
        }

        for(int i=0; i<counts.size()-1; i++){
            for(int j=0; j<counts.size()-1 -i; j++){
                if(counts.get(j)<counts.get(j+1)){
                    int temp = counts.get(j);
                    counts.set(j,counts.get(j+1));
                    counts.set(j+1,temp);
                }
            }
        }

        int maxCount = counts.get(0);
        List<Integer> unsortedIds = new ArrayList();
        for(Map.Entry<Integer,Integer> map: idMap.entrySet()){
            if(map.getValue() == maxCount){
                unsortedIds.add(map.getKey());
            }
        }

        for(int i=0; i<unsortedIds.size()-1; i++){
            for(int j=0; j<unsortedIds.size()-1 -i; j++){
                if(unsortedIds.get(j)>unsortedIds.get(j+1)){
                    int temp = unsortedIds.get(j);
                    unsortedIds.set(j,unsortedIds.get(j+1));
                    unsortedIds.set(j+1,temp);
                }
            }
        }
        return unsortedIds.get(0);
    }
}
