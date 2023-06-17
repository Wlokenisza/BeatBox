package com.example.beatbox

import org.hamcrest.CoreMatchers.`is`
import org.junit.*
import org.junit.Assert.assertThat
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

internal class SoundViewModelTest {
    private lateinit var beatBox: BeatBox
    private lateinit var sound : Sound
    private lateinit var subject : SoundViewModel

    @Before
    fun setUp() {
        beatBox = mock(BeatBox::class.java)
        sound = Sound(assetPath = "assetPath")
        subject = SoundViewModel(beatBox)
        subject.sound = sound
    }

    @Test
    fun exposesSoundNameAsTitle() {
        assertThat(subject.title, `is`(sound.name))
    }

    @Test
    fun callsBeatBoxPlayOnButtonClicked() {
        subject.onButtonClicked()
        verify(beatBox).playSound(sound)
    }
}