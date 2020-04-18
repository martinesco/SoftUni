package RandomArrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    private static final Random random;

    static {
        random = new Random();
    }

    public Object getRandomElement(){
        int index = random.nextInt(super.size());
        return super.remove(index);
    }



}

