package Ch_09_Scalability_and_Memory_Limits.Q9_07_Personal_Financial_Manager;

public class Solution {
    public static void main(String[] args) {
        /*
        * Bank sync -> Raw transaction data -> Categorizer
        *                                           |
        *                                           \/
        *
        *          Frontend <-> Categorized transactions
        *             ^
        *             |                |
        *             \/               \/
        *        budget data   <- budget analyzer
        *
        * 1)Bank transactions regularly getting pull from bank acc.
        * 2)Each trans. getting categorized depends on transaction type and company
        * 3)Categorized transactions then coming to front end and budget service(async using message broker)
        * 4)Budget service listening message broker with transaction and analyze the data.
        * 5)Analyzed data might be used to create budget analyze, charts and suggestions
        * 6)Front end also can interact with category of transactions and update it
        * 7)For each of such things we need to create an update event in message broker, to notify all system components, that category was updated.
        *
        * For transaction categorization we can group them by seller, then check type for particular seller
        * and update all of them instead of joining all at once.
        *
        * */
    }
}
