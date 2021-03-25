package practice.list;

public class Main {

    public static void main(String[] args) {

        CustomList<String> list  = new CustomList<>();
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");

        System.out.println(list.get(1));
        System.out.println(list.size());
        System.out.println(list.first());
        System.out.println(list.last());
        list.addFirst("OOO");
        System.out.println(list.first());
        System.out.println(list.size());
        list.delete(2);
        System.out.println(list.size());

        for (String element : list) {
            System.out.println(element);
        }
    }
}
