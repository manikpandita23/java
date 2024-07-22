public class PatternMatchingSwitch {

    public static void main(String[] args) {
        Object obj1 = "Hello, World!";
        Object obj2 = 42;
        Object obj3 = 3.14;
        Object obj4 = new CustomClass("Custom Object");

        printObjectType(obj1);
        printObjectType(obj2);
        printObjectType(obj3);
        printObjectType(obj4);
    }

    static void printObjectType(Object obj) {
        switch (obj) {
            case String s -> System.out.println("This is a String: " + s);
            case Integer i -> System.out.println("This is an Integer: " + i);
            case Double d -> System.out.println("This is a Double: " + d);
            case CustomClass c -> System.out.println("This is a CustomClass: " + c.getName());
            default -> System.out.println("Unknown type: " + obj);
        }
    }

    static class CustomClass {
        private final String name;

        public CustomClass(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
