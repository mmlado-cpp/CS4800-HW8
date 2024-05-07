public interface  VendingMachineState {
    public void selectSnack(VendingMachine vendingMachine, String snackName);
    public void payment(VendingMachine vendingMachine, double money);
    public Snack dispenseSnack(VendingMachine vendingMachine);
}