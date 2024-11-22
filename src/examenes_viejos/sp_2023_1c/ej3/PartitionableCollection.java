package examenes_viejos.sp_2023_1c.ej3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PartitionableCollection<T> extends ArrayList<T> {
    public PartitionableCollection<T> getSelected(Predicate<T> pred) {
        PartitionableCollection<T> ans = new PartitionableCollection<>();
        for(T elem : this) {
            if(pred.test(elem)) {
                ans.add(elem);
            }
        }
        return ans;
    }

    public PartitionableCollection<T> getRejected(Predicate<T> pred) {
        return getSelected(pred.negate());
    }
}
