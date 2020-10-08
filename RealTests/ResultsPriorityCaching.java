package test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



    /*
     * Complete the 'cacheContents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY callLogs as parameter.
     */

List<Integer> cacheContents(List<List<Integer>> callLogs) {
	// TODO Auto-generated method stub
	return null;
}

public class ResultsPriorityCaching {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int callLogsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int callLogsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> callLogs = new ArrayList<>();

        IntStream.range(0, callLogsRows).forEach(i -> {
            try {
                callLogs.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = cacheContents(callLogs);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }


}
