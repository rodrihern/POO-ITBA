package examenes_viejos.sp_2024_1c.ej2;

import java.sql.Array;
import java.time.YearMonth;
import java.util.*;

public class ReimbursementTracker {
    // cliente, <mesaño, reintegro>
    private final Map<String, Map<YearMonth, Integer>> monthlyReibursements = new HashMap<>();
    // cliente, tope de reintegro
    private final Map<String, Integer> clients = new HashMap<>();

    public void registerClient(String client, int maxR) {
        if(clients.containsKey(client)) {
            throw new RuntimeException("Client Already Registered");
        }
        clients.put(client, maxR);
        monthlyReibursements.put(client, new TreeMap<>());
    }

    public void addReimbursement(String client, YearMonth ym, int amount) {
        checkClient(client);
        int reimbursement = monthlyReibursements.get(client).getOrDefault(ym, 0);
        if((reimbursement += amount) > clients.get(client)) {
            throw new RuntimeException("Reimbursement surpasses month cap");
        }
        monthlyReibursements.get(client).put(ym, reimbursement);
    }

    public int getRemainingReimbursement(String client, YearMonth ym) {
        checkClient(client);
        int current = monthlyReibursements.get(client).getOrDefault(ym, 0);
        return clients.get(client) - current;
    }

    public Collection<Reimbursement> getReimbursements(String client, YearMonth from, YearMonth to) {
        checkClient(client);
        Collection<Reimbursement> ans = new ArrayList<>();
        for(YearMonth ym : monthlyReibursements.get(client).keySet()) {
            if(ym.compareTo(from) >= 0 && ym.isBefore(to)) {
                ans.add(new Reimbursement(ym, monthlyReibursements.get(client).getOrDefault(ym, 0)));
            }
        }
        return ans;
    }

    private void checkClient(String client) {
        if(!clients.containsKey(client)) {
            throw new RuntimeException("Client is not registered");
        }
    }



}
