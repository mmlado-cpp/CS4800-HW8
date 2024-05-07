public class InsertMoney implements VendingMachineState{
    public Snack selectedSnack;

    public InsertMoney(Snack selectedSnack){
        this.selectedSnack = selectedSnack;
    }

    public void selectSnack(VendingMachine vendingMachine, String snackName) {
    }
  
    public void payment(VendingMachine vendingMachine, double amt ) {
        if(amt >=this.selectedSnack.getPrice()){
            vendingMachine.setState(new SnackDispenserState(this.selectedSnack));
            System.out.println("Going from insertMoney to dispense");
            return;
        }
        System.out.println("State still in insertMoney state");
    }

    
    public Snack dispenseSnack(VendingMachine vendingMachine) {
        return null;
    }
}