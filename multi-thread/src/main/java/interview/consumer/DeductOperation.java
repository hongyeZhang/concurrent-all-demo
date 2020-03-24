package interview.consumer;

/**
 * @author : ZHQ
 * @date : 2020/3/16
 */
public class DeductOperation implements Runnable {
    private AddAndReductGame game;

    public DeductOperation(AddAndReductGame game) {
        this.game = game;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; ++i) {
            game.decrement();
        }

    }
}
