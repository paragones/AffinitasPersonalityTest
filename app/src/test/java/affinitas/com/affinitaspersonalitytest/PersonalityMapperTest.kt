package affinitas.com.affinitaspersonalitytest

import affinitas.com.affinitaspersonalitytest.mapper.DataMapper
import affinitas.com.affinitaspersonalitytest.mapper.PersonalityTestMapper
import affinitas.com.affinitaspersonalitytest.model.Category
import affinitas.com.affinitaspersonalitytest.model.QuestionItem
import affinitas.com.affinitaspersonalitytest.rest.JsonQuestion
import affinitas.com.affinitaspersonalitytest.rest.JsonQuestionType
import affinitas.com.affinitaspersonalitytest.rest.PersonalityTestWrapper
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 9/2/2017.
 */
class PersonalityMapperTest {
    lateinit var personalityTestMapper: DataMapper<PersonalityTestWrapper, Pair<List<Category>, List<QuestionItem>>>
    lateinit var personalityTestWrapper: PersonalityTestWrapper
    lateinit var expectedResult: Pair<List<Category>, List<QuestionItem>>
    lateinit var pairObject: Pair<List<Category>, List<QuestionItem>>

    @Before
    fun setup() {
        personalityTestMapper = PersonalityTestMapper()
        personalityTestWrapper = PersonalityTestWrapper(arrayListOf("hard_fact", "lifestyle"),
                arrayListOf(JsonQuestion("First Question", "lifestyle",
                        JsonQuestionType("single_choice", arrayListOf("1", "2", "3")))))
        expectedResult = TestUtil.pojoResults()
    }

    @Test
    fun shouldHaveMappedWrapperToPOJO() {
        pairObject = personalityTestMapper.transform(personalityTestWrapper)
        assertEquals(pairObject.first, expectedResult.first)
        assertEquals(pairObject.second[0].id, expectedResult.second[0].id)
        assertEquals(pairObject.second[0].question, expectedResult.second[0].question)
        assertEquals(pairObject.second[0].category, expectedResult.second[0].category)
        assertEquals(pairObject.second[0].questionType, expectedResult.second[0].questionType)
        assertEquals(pairObject.second[0].options, expectedResult.second[0].options)
    }
}