package SortOptions;

class InsertionSort extends Thread {

    private String[] arrayOfStrings;
    private Thread linkToTheCurrentStream;
    double startTime;
    double endTime;

    public InsertionSort(String[] ArrStr, String threadName) {
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
            s = arrayOfStrings[i];
            for (j=i-1; j>=0 && arrayOfStrings[j].compareTo(s)<0; j--) {
                arrayOfStrings[j+1] = arrayOfStrings[j];
            }
            arrayOfStrings[j+1] = s;
        }
        endTime = System.nanoTime();
    }

    public String[] get() { return arrayOfStrings; }

    public Thread getThread() { return linkToTheCurrentStream; }

    public void outputOfResults() {
        System.out.println("Время сортировки методом вставки: " + (endTime - startTime) + " наносекунд");
    }
}
