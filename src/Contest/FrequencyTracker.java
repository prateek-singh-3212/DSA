package Contest;

import java.util.HashMap;
import java.util.Map;

class FrequencyTracker {
    Map<Integer, Integer> map;

    public FrequencyTracker() {
        map = new HashMap<>();
    }

    public void add(int number) {
        if (map.containsKey(number)) {
            int num = map.get(number);
            map.put(number, ++num);
        }else {
            map.put(number, 1);
        }
    }

    public void deleteOne(int number) {
        if (map.containsKey(number)) {
            int num = map.get(number);
            if (num == 1) {
                map.remove(number);
            }else {
                map.put(number, --num);
            }
        }
    }

    public boolean hasFrequency(int frequency) {
        return map.containsValue(frequency);
    }
}
