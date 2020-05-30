package org.spaceappschallenge.purifyairsupply.audio.impl;

import lombok.SneakyThrows;
import org.spaceappschallenge.purifyairsupply.audio.AudioPlayer;
import org.springframework.stereotype.Component;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.InputStream;

@Component
public class AudioPlayerImpl implements AudioPlayer {

    private static final ClassLoader CLASS_LOADER = AudioPlayerImpl.class.getClassLoader();

    @Override
    @SneakyThrows
    public void play(String path) {
        try (InputStream inputStream = CLASS_LOADER.getResourceAsStream(path)) {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
    }
}
