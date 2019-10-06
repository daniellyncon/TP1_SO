public enum Priority {
    D(1), C(2), P(3);

    public int printPriority;

    Priority(int priority) {
        printPriority = priority;
    }

    public int getPrintPriority() {
        return printPriority;
    }


}
