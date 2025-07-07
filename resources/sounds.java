/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class sounds {

    public static void playUpgradeSound() {
        play("upgrade.wav");
    }

    public static void playShootSound() {
        play("shoot.wav");
    }

    private static void play(String fileName) {
        try {
            URL url = sounds.class.getResource("/resources/" + fileName);
            if (url == null) {
                System.err.println("Fișier audio inexistent: " + fileName);
                return;
            }

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Eroare redare sunet: " + e.getMessage());
        }
    }
}

