package affinitas.com.affinitaspersonalitytest.services

import affinitas.com.affinitaspersonalitytest.model.AnswerKey
import android.content.Context

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 9/1/2017.
 */
interface DatabaseService {
    fun initializeDatabase(context: Context)
    fun retrieveAnswerKeys(): List<AnswerKey>?
    fun saveAnswer(answerKey: AnswerKey)
}