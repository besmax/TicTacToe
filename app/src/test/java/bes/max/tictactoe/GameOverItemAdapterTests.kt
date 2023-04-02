package bes.max.tictactoe

import android.content.Context
import bes.max.tictactoe.ui.GameOverItemAdapter
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock

class GameOverItemAdapterTests {

    private val context = mock(Context::class.java)

    @Test
    fun adapter_size() {
        val data = listOf<Char>(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ')
        val adapter = GameOverItemAdapter(context, data)
        assertEquals("ItemAdapter is not the correct size", data.size, adapter.itemCount)
    }

}