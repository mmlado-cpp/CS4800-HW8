public class SnackDispenserState implements VendingMachineState {
    Snack selectedSnack;

    public SnackDispenserState(Snack selectedSnack) {
        this.selectedSnack = selectedSnack;
    }

    public void selectSnack(VendingMachine vendingMachine, String snackName) {
    }

    public void payment(VendingMachine vendingMachine, double amt) {
    }

    public Snack dispenseSnack(VendingMachine vendingMachine) {
        Snack snack = vendingMachine.getDispenser().dispenseSnack(selectedSnack.getName(),
                vendingMachine.getUserPayment());
        System.out.println("Change back: " + (vendingMachine.getUserPayment() - this.selectedSnack.getPrice()));
        vendingMachine.adjustBalance(vendingMachine.getUserPayment());
        vendingMachine.setState(new IdleState());
        System.out.println("State changing from dispense to idle");
        return snack;
    }

}