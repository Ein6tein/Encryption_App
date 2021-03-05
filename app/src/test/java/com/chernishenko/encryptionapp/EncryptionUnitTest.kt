package com.chernishenko.encryptionapp

import com.chernishenko.encryptionlib.encryptor.Encryptor
import junit.framework.TestCase.assertEquals
import org.junit.Test

@ExperimentalStdlibApi
class EncryptionUnitTest {

    @Test fun `Test digit encryption`() {
        val encryptor = Encryptor()
        val inputData = "1234"
        val inputPass = "1111"
        val expectedResult = "2345"

        assertEquals(expectedResult, encryptor.encryptDigitsOnly(inputData, inputPass))
    }

    @Test fun `Test digit encryption with different length data`() {
        val encryptor = Encryptor()
        val inputData = "123456"
        val inputPass = "1111"
        val expectedResult = "234567"

        assertEquals(expectedResult, encryptor.encryptDigitsOnly(inputData, inputPass))
    }

    @Test fun `Test symbol encryption`() {
        val encryptor = Encryptor()
        val inputData = "TEST"
        val inputPass = "AAAA"
        val expectedResult = "UFTU"

        assertEquals(expectedResult, encryptor.encryptText(inputData, inputPass))
    }

    @Test fun `Test symbol encryption with different length data and spaces`() {
        val encryptor = Encryptor()
        val inputData = "TEST TEXT 123"
        val inputPass = "AAA"
        val expectedResult = "UFTU UFYU 234"

        assertEquals(expectedResult, encryptor.encryptText(inputData, inputPass))
    }
}