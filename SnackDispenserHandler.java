public class SnackDispenserHandler {
    private Snack snack;
    private SnackDispenserHandler nextSnackHandler;

    public SnackDispenserHandler(Snack snack, SnackDispenserHandler nextSnackHandler)
    {
        this.snack = snack;
        this.nextSnackHandler = nextSnackHandler;
    }

    public Snack dispenseSnack(String snackName, double payment){
        if (snack.getName().equals(snackName)) {
            System.out.println("Attempting to dispense: " + snackName);
            if (payment >= snack.getPrice() && snack.getQuantity() > 0) {
                System.out.println("Dispensing: " + snackName);
                snack.dispense();
                return snack;
            } else {
                System.out.println("Not enough payment or out of stock for: " + snackName);
                return null;
            }
        } else if (nextSnackHandler != null) {
            return nextSnackHandler.dispenseSnack(snackName, payment);
        } else {
            System.out.println("No handler for " + snackName);
            return null;
        }
    }
    

}