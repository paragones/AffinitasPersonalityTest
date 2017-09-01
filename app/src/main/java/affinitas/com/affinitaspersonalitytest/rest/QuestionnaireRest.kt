package affinitas.com.affinitaspersonalitytest.rest

import affinitas.com.affinitaspersonalitytest.rest.PersonalityTestWrapper
import retrofit2.http.GET
import rx.Observable

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/31/2017.
 */
interface QuestionnaireRest {
    @GET("database/personality_test.json")
    fun personalityTest(): Observable<PersonalityTestWrapper>
}

