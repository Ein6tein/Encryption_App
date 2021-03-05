package com.chernishenko.encryptionapp

import com.chernishenko.encryptionlib.decryptor.Decryptor
import junit.framework.TestCase
import org.junit.Test

@ExperimentalStdlibApi
class DecryptionUnitTest {

    @Test fun `Test digit decryption`() {
        val decryptor = Decryptor()
        val inputData = "2345"
        val inputPass = "1111"
        val expectedResult = "1234"

        TestCase.assertEquals(expectedResult, decryptor.decryptDigitsOnly(inputData, inputPass))
    }

    @Test fun `Test digit decryption with different length data`() {
        val decryptor = Decryptor()
        val inputData = "234567"
        val inputPass = "1111"
        val expectedResult = "123456"

        TestCase.assertEquals(expectedResult, decryptor.decryptDigitsOnly(inputData, inputPass))
    }

    @Test fun `Test symbol decryption`() {
        val decryptor = Decryptor()
        val inputData = "UFTU"
        val inputPass = "AAAA"
        val expectedResult = "TEST"

        TestCase.assertEquals(expectedResult, decryptor.decryptText(inputData, inputPass))
    }

    @Test fun `Test symbol decryption with different length data and spaces`() {
        val decryptor = Decryptor()
        val inputData = "UFTU UFYU 234"
        val inputPass = "AAA"
        val expectedResult = "TEST TEXT 123"

        TestCase.assertEquals(expectedResult, decryptor.decryptText(inputData, inputPass))
    }
}