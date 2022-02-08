class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>();
        if (p.length() > s.length()) {
			return answer;
		}
        Map<String, Integer> targetMap = new HashMap<String, Integer>();
        for (int i = 0; i < p.length() ; i++) {
            String character = p.charAt(i) + "";
            if (targetMap.get(character) == null) {
                targetMap.put(character, 0);
            }
            targetMap.put(character, targetMap.get(character) + 1);
        }
        
        HashMap<Integer,  Map<String, Integer>> targetMapByStartIndex = new HashMap<Integer, Map<String, Integer>>();
        for (int i = 0; i < s.length()-p.length()+1; i++) {
            //Init map
            targetMapByStartIndex.put(i, new HashMap<String, Integer>());
            String character = s.charAt(i) + "";
            int currentEnd = Math.min(s.length(), j + p.length());
            //Iterate through each map up to this point
            for (int j = i; j < currentEnd; j++) {
                if (targetMapByStartIndex.get(j).get(character) = null) {
                    targetMapByStartIndex.get(j).put(character, 0);
                }
                targetMapByStartIndex.get(j).put(character, targetMapByStartIndex.get(j).get(character) + 1);
            }
        }
        
                if (targetMapByStartIndex.get(j).keySet().size() == 0) {
                    answer.add(j);
                    targetMapByStartIndex.remove(j);
                }
        return answer;
    }
}


class Solution {
public List<Integer> findAnagrams(String s, String p) {
		//list to hold answer
		List<Integer> list = new ArrayList<>();
		//if length of p is more than entire s. answer is not possible
		if (p.length() > s.length()) {
			return list;
		}
		//map to hold freq of window length
        int[] freq = new int[26];
		//preparefreq map by adding p character count and subtracting s character count
		for (int i = 0; i < p.length(); i++) {
			freq[p.charAt(i) - 'a'] += 1;
			freq[s.charAt(i) - 'a'] -= 1;
		}
		int i = 0;
		for (; i < s.length() - p.length(); i++) {
		//if freq map has all zero it means it is an anagaram
			if (checkAnagram(freq)) {
				list.add(i);
			}
			//now for next index comparison remove ith char and add i +p.length() char to freq map
			freq[s.charAt(i) - 'a'] += 1;
			freq[s.charAt(i + p.length()) - 'a'] -= 1;
		}
       //since last comparison left. check it also
	   if (checkAnagram(freq)) {
			list.add(i);
		}
		//return list
		return list;
	}
	
	private boolean checkAnagram(int[] freq) {
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] != 0) {
				return false;
			}
		}
		return true;
	}    
}