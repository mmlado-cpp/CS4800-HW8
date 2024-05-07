import java.util.ArrayList;

public class VendingMachine {

    private VendingMachineState state;
    private ArrayList<Snack> snacks;
    private SnackDispenserHandler dispenser;
    private double userPayment;

    public VendingMachine(ArrayList<Snack> snacks){
        state = new IdleState();
        this.snacks = snacks;
        userPayment = 0;

        SnackDispenserHandler handler = null;
        for ( int i = snacks.size() -1; i >= 0; i--){
            handler = new SnackDispenserHandler(snacks.get(i), handler);
        }
        dispenser = handler;
    }


    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public void selectSnack(String snackName){
        state.selectSnack(this, snackName);
    }

    public void insertMoney(double amt){
        userPayment += amt;
        state.payment(this, userPayment);
    }

    public void dispenseSnack(){
        state.dispenseSnack(this);
    }


    public void adjustBalance(double amt){
        userPayment -= amt;
    }


    public SnackDispenserHandler getDispenser() {
        return dispenser;
    }


    public double getUserPayment() {
        return userPayment;
    }

    public Snack getSnack(String name) {
        for (Snack snack : snacks) {
            if (snack.getName().equals(name)){
                return snack;
            }
        }
        return null;
    }
}