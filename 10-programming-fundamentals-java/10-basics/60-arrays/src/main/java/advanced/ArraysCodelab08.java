package advanced;

public class ArraysCodelab08 {

    /**
     * This time we're going to write an app for a businessman that rents apartments.
     * Because he's renting so many apartments he can no longer keep track of everything and asks you to help him.
     *
     * The first feature he wants you to implement is that given the number from an apartment, you'll print out if the tenant has paid his/her rent.
     *
     * 1. Implement the method so that it prints out the tenants name and if he/she has paid the rent or not.
     *      - printOutTenantStatus(1, {'Marc', 'Jef'}, {true, false}) --> Will print out: "Marc has paid his/her rent.".
     *      - printOutTenantStatus(1, {'Marc','Jef'}, {true, false}) --> Will print out: "Jef has not paid his/her rent.".
     * 2. As always think of the edge cases
     *      - In case of an edge case you can print out "Apartment <number> does not exist."
     */
    public static void main(String[] args) {
        String[] tenantNames = {"Marc", "Jef", "Sophie", "Laure", "Karen", "John"};
        boolean[] hasPaidRent = {true, false, false, true, true, false};

        printOutTenantStatus(3, tenantNames, hasPaidRent);
    }

    public static void printOutTenantStatus(int apartmentNumber, String[] tenantNames, boolean[] hasPaidRent) {

    }


}
