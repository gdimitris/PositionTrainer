package com.example.dimitris.chesspositiontrainer;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dimitris on 3/26/15.
 */
public class PGNReader {

    public void readFile(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        Pattern info_pattern = Pattern.compile("\\[[^\\]]*\\]");
        Pattern whitespace_pattern = Pattern.compile("^\\s*$");
        Pattern move_number_pattern = Pattern.compile("^\\d{1,2}\\.");
        ArrayList<String> movesList = new ArrayList<>();

        try {
            while ((line = reader.readLine()) != null) {

                Matcher info_matcher = info_pattern.matcher(line);
                Matcher whitespace_matcher = whitespace_pattern.matcher(line);
                if (info_matcher.find()) {
                    Log.e("PGN Reading", "I got info line : " + line);
                } else if (whitespace_matcher.find()) {
                    Log.e("PGN Reading", "I got whitespace");
                } else {
                    StringTokenizer tokenizer = new StringTokenizer(line);
                    while (tokenizer.hasMoreTokens()) {
                        String token = tokenizer.nextToken();
                        Matcher move_number_matcher = move_number_pattern.matcher(token);
                        if (!move_number_matcher.matches()) {
                            movesList.add(token);
                        }
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.e("PGN Reading", "The whole list is: " + movesList.toString());
    }
}
