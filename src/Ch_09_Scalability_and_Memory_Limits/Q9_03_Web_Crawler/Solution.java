package Ch_09_Scalability_and_Memory_Limits.Q9_03_Web_Crawler;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        /*
         * Signature = content+ page url
         *
         * Algorithm:
         * 1) Open up the page and create a signature of the page based on specific subsections and it's content
         * 2) Query the database to see whether anything with this signature has been crawled recently
         * 3) If something with this signature has been recently crawled, insert this page back into the database at a low priority
         * 4) If not, crawl the page and insert its link into the database
         *
         *
         *
         *
         *
         * */
        Database database = new Database();
        List<Page> itemsToCrawl = database.getItemstoCrawl();
        for (Page page : itemsToCrawl) {
            Signature signature = Crawler.createSignature(page);
            List<Page> itemsCrawledBySignature = database.getItemsCrawledBySignature(signature);
            if (!itemsCrawledBySignature.isEmpty()){
                database.updatePriority(page,"LOW");
            }
            else {
                Crawler.crawl(page, database);
            }
        }

    }
}

class Page {
    String sections;
    String url;
    String content;
    List<String> links;

    public String getSections() {
        return sections;
    }

    public String getUrl() {
        return url;
    }

    public String getContent() {
        return content;
    }

    public List<String> getLinks() {
        return links;
    }
}

class Database {

    public List<Page> getItemstoCrawl() {
        return new ArrayList<>();
    }

    public List<Page>  getItemsCrawledBySignature(Signature signature) {
        return new ArrayList<>();
    }

    public void updatePriority(Page page, String low) {
        /*
        * update
        * */
    }

    public void insertPage(List<String> page) {

    }
}
class Crawler {
    public static Signature createSignature(Page page){
        return new Signature(page);
    }

    public static void crawl(Page page, Database database) {
        //crawl
        database.insertPage(page.getLinks());
    }
}
class Signature {
    String info;
    public Signature(Page page) {
        /*
        * create sign
        * */
    }
}
