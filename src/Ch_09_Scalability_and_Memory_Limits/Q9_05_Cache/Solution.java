package Ch_09_Scalability_and_Memory_Limits.Q9_05_Cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private Map<String, List<String>> cashQueries = new HashMap<>();

    public List<String> processSearch(String query) {
        return getSearchFromCash(query);
    }

    public void updateData(List<String> newData, String query) {
        //save
        if (cashQueries.containsKey(query)) {
            cashQueries.remove(query);
        }
    }

    public List<String> getSearchFromCash(String query) {
        if (cashQueries.containsKey(query)) {
            return cashQueries.get(query);
        } else {
            List<String> searchFromDb = getSearchFromDb(query);
            cashQueries.put(query, searchFromDb);
            return searchFromDb;
        }
    }

    private List<String> getSearchFromDb(String query) {

        return null;
    }
}
