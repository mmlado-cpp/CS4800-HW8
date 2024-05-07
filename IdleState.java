public class IdleState implements VendingMachineState {

    public void selectSnack(VendingMachine vendingMachine, String snackName) {
        Snack snack = vendingMachine.getSnack(snackName);
        if (snack != null && snack.getQuantity() > 0) {
            System.out.println(snackName + " available. State change from idle to payment");
            vendingMachine.setState(new InsertMoney(snack));
        } else {
            System.out.println(snackName + " not available.");
        }
    }

    public void payment(VendingMachine vendingMachine, double amt) {
    }

    public Snack dispenseSnack(VendingMachine vendingMachine) {
        return null;
    }
}