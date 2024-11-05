package examenes_viejos.sp_2023_2c.ej2;

import java.util.*;

public class ScoreBoard<T extends Comparable<? super T>> extends TreeSet<PlayerScore<T>> {
    public List<PlayerScore<T>> getTopScores(int n) {
        Iterator<PlayerScore<T>> it = this.iterator();
        List<PlayerScore<T>> ans = new ArrayList<>();
        for(int i = 0; i < n && it.hasNext(); i++) {
            ans.add(it.next());
        }
        return ans;
    }
}
