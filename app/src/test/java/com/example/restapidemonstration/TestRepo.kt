package com.example.restapidemonstration

import com.example.restapidemonstration.repository.MainRepository
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test

class TestRepo {
    val repo = MainRepository()


    @Test
    fun `check repo get destination`() =
        runBlocking {
            val response = repo.getDestinations()
            assertNotNull(response)
        }
}