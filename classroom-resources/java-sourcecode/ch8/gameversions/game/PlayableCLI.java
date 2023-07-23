

public interface PlayableCLI {

    public void initCLI(KeyboardReader kr);
    public void displayCLI(KeyboardReader kr);
    public boolean moveCLI(KeyboardReader kr);
    public void finishCLI(KeyboardReader kr);

} ///PlayableCLI