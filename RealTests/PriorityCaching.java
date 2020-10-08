package test;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.IntStream;

/*
 * Complete the 'cacheContents' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts 2D_INTEGER_ARRAY callLogs as parameter.
 */

public static List<Integer> cacheContents(List<List<Integer>> callLogs) {
// Write your code here

}

public class PriorityCaching {

	
	
	
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

        List<Integer> result = Result.cacheContents(callLogs);

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
