/**
 * Created by E6410 on 15.11.2017.
 */
public class Runner {
    public static void main(String[] args) {
        MyList<Player> list = new MyList<>();
        Player player1 = new Player("Tom",10);
        Player player2 = new Player("Timo",12);
        Player player3 = new Player("Ralf",6);
        Player player4 = new Player("Robin",14);
        list.addAfterCurrent(player1);
        list.addAfterCurrent(player2);
        list.addAfterCurrent(player3);
        list.addAfterCurrent(player4);
        list.toFirst();
        list.sort(Player::compareTo, list.getFirst().getNext());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.getSize());
        System.out.println(getFastestPlayer(list));
    }
    private static Player getFastestPlayer(MyList<Player> list) {
        list.toFirst();
        Player fastest = list.getCurrent().getContent();
        for(int i = 0;i<list.getSize(); i++) {
            if(fastest.getTime()>list.get(i).getTime()) {
                fastest = list.get(i);
            }
        }
        return fastest;
    }
}
