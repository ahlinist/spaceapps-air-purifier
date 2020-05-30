package org.spaceappschallenge.purifyairsupply.audio.impl;

import lombok.SneakyThrows;
import org.spaceappschallenge.purifyairsupply.audio.AudioPlayer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

@Component
public class AudioPlayerImpl implements AudioPlayer {

    @Override
    @SneakyThrows
    public void play(String path) {
        URL url = new ClassPathResource("audio/alarm.wav").getURL();

        try(AudioInputStream audioInputStream =  AudioSystem.getAudioInputStream(url); Clip clip = AudioSystem.getClip()) {
            clip.open(audioInputStream);
            clip.start();
            Thread.sleep(5000);
        }
    }
}
