package Lab2;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the QueryString class
        QueryString queryString = new QueryString();

        // Add parameters to the query string
        queryString.add("name", "John Doe");
        queryString.add("age", "30");
        queryString.add("age", "30");

        
        // Get the final query string and print it
        String finalQuery = queryString.getQuery();
        System.out.println("Final Query String: " + finalQuery);
    }
}
