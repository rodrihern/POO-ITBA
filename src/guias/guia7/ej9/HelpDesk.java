package guias.guia7.ej9;

import java.util.*;

public class HelpDesk {

    private Map<ClientType, Queue<HelpTicket>> tickets = new EnumMap<>(ClientType.class);

    public HelpDesk openTicket(ClientType clientType, String name, String question) {
        tickets.putIfAbsent(clientType, new LinkedList<>());
        tickets.get(clientType).offer(new HelpTicket(name, question));
        return this;
    }

    public boolean hasTickets() {
        for(Queue<HelpTicket> q : tickets.values()) {
            if(!q.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public HelpTicket getNextTicket() {
        for(Queue<HelpTicket> q : tickets.values()) {
            if(!q.isEmpty()) {
                return q.poll();
            }
        }

        throw new NoSuchElementException();
    }

    public HelpTicket getNextTicket(ClientType clientType) {
        return tickets.getOrDefault(clientType, new LinkedList<>()).remove();
    }

    public static class HelpTicket {
        private final String name, question;


        public HelpTicket(String name, String question) {
            this.name = name;
            this.question = question;
        }

        @Override
        public String toString() {
            return "HelpTicket for %s asking %s".formatted(name, question);
        }
    }
}
