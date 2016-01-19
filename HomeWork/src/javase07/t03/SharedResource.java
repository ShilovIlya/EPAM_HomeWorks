package javase07.t03;

import java.util.ArrayList;
import java.util.List;

public class SharedResource {

    private List<Integer> list;

<<<<<<< HEAD

=======
>>>>>>> d8c76c429f265dc122738f321477800df778ee98
    public SharedResource() {
        this.list = new ArrayList<>();
    }

    public void setElement(Integer element) {
        list.add(element);
    }

    public Integer getElement() {
        if (list.size() > 0) {
            return list.remove(0);
        }
        return null;
    }
}
