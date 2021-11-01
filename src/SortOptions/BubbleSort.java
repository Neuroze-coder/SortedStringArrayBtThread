package SortOptions;

class BubbleSort extends Thread {

    private String[] arrayOfStrings;
    private Thread linkToTheCurrentStream;
    double startTime;
    double endTime;

    public BubbleSort(String[] ArrStr, String threadName) {
        this.arrayOfStrings = ArrStr;
        linkToTheCurrentStream = new Thread(this, threadName);
    }

    public void start() {
        linkToTheCurrentStream.start();
        startTime = System.nanoTime();
    }

    public void run() {
        int i, j;
        String s;
        for (i=0; i< arrayOfStrings.length; i++) {
            for (j= arrayOfStrings.length-1; j>i; j--) {
                if (arrayOfStrings[j-1].compareTo(arrayOfStrings[j])<0) {
                    s = arrayOfStrings[j];
                    arrayOfStrings[j] = arrayOfStrings[j-1];
                    arrayOfStrings[j-1] = s;
                }
            }
        }
        endTime = System.nanoTime();
    }

    public String[] get() { return arrayOfStrings; }

    public Thread getThread() { return linkToTheCurrentStream; }

    public void outputOfResults() {
        System.out.println("Время сортировки методом пузырька: " + (endTime - startTime) + " наносекунд");
    }
}
