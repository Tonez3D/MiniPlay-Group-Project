package MiniPlay.Utilities;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tools {
    public static void playClip(String path){
        //"MiniPlay/src/main/resources/Audio/mixkit-casino-bling-achievement-2067.wav"
        try {
            File soundFile = new File(Tools.class.getResource(path).toURI());
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(soundFile));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> getWords(int wordCount) {
        List<String> words = new ArrayList<>();
        try {
            //List<String> data = Files.readAllLines(Paths.get("MiniPlay/src/main/resources/word_database.txt"));
            List<String> data = Files.readAllLines(Paths.get(Tools.class.getResource("/Databases/word_database.txt").getPath()));
            while (wordCount > words.size()) {
                Random rand = new Random();

                String i = data.get(rand.nextInt(data.size()));
                if (!words.contains(i)) {
                    words.add(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return words;
    }
}
