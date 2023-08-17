package Ch_09_Scalability_and_Memory_Limits.Q9_08_Pastebin;

public class Solution {
    public static void main(String[] args) {
        /*
        * 1)A user type text and click submit
        * 2)App generate Url associated with this text
        * 3)Url can be generated like sequence of 10 chars/numbers
        * 4)Before Url save we should check if it's already exists in DB
        * 5)We are saving a pair of Url - Associated server in separate database.
        * This will allows you to implement sharding to many servers.
        * This means, that when user interact with Url we checking associated info with this url
        * From this info we're getting server name, partition and file name.
        * 6)We're saving a text as file on a server under partition using date as partition key.
        * After success saving we now have value for url, that we can put in our URL database
        * 7)We're tracking url accessing. Each time, when url was accessed we're saving click and date
        * 8)We can aggregate this info then, so user can see how many clicks he get for needed date
        * 9)Clicks also rely on TTL. If link wasn't in use for a long time we're removing the file and the link from databases
        * We can use daily job for it.
        * 10)We're storing most accessible files in cache
        * */
    }
}
