package word;

import java.util.Deque;

public class PasteTransform implements TextTransform {

    private Deque<String> memory;

    public PasteTransform(Deque<String> memory) {
        this.memory = memory;
    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {

        text.replace(startIndex, endIndex, memory.peek());

    }
}
