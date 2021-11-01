package SortOptions;

class SelectionSort extends Thread {

    private String[] arrayOfStrings;
    private Thread linkToTheCurrentStream;
    double startTime;
    double endTime;

    public SelectionSort(String[] ArrStr, String threadName) {
        this.arrayOfStrings = ArrStr;
        linkToTheCurrentStream = new Thread(this, threadName);
    }

    public void start() {
        linkToTheCurrentStream.start();
        startTime = System.nanoTime();
    }

    public void run() {
        int i, j, k;
        String s;
        for (i = 0; i < arrayOfStrings.length; i++) {
            k = i;
            s = arrayOfStrings[i];
            for (j = i + 1; j < arrayOfStrings.length; j++)
                if (arrayOfStrings[j].compareTo(s) > 0) {
                    k = j;
                    s = arrayOfStrings[j];
                }
            arrayOfStrings[k] = arrayOfStrings[i];
            arrayOfStrings[i] = s;
        }
        endTime = System.nanoTime();
    }

    public String[] get() {
        return arrayOfStrings;
    }

    public Thread getThread() {
        return linkToTheCurrentStream;
    }

    public void outputOfResults() {
        System.out.println("Время сортировки методом выбора: " + (endTime - startTime) + " наносекунд");
    }
}
