import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {

        ArrayList<Snack> snacks = new ArrayList<>();

        
        snacks.add(new Snack("Coke", 2, 2));
        snacks.add(new Snack("Pepsi", 2, 3));
        snacks.add(new Snack("Cheetos", 1, 5));
        snacks.add(new Snack("Doritos", 1, 5));
        snacks.add(new Snack("KitKat", 1.5, 5));
        
        int snickerQty = 2;
        snacks.add(new Snack("Snickers", 1.5, snickerQty));  // Snickers initially has a quantity of 3

        VendingMachine vendingMachine = new VendingMachine(snacks);

        vendingMachine.selectSnack("Cheetos");
        vendingMachine.insertMoney(1.5);
        vendingMachine.dispenseSnack();
        
        // buy Snickers until it runs out
        for (int i = 0; i < snickerQty; i++) {
            vendingMachine.selectSnack("Snickers");
            vendingMachine.insertMoney(2);  // Enough money to buy Snickers
            vendingMachine.dispenseSnack();
        }

        // Try buying Snickers one more time to confirm it's out
        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(2);
        vendingMachine.dispenseSnack();
    }
}
