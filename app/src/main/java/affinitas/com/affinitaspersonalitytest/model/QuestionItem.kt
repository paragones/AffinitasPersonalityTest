package affinitas.com.affinitaspersonalitytest.model

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/31/2017.
 */
class QuestionItem(val id: Int,
                   val question: String,
                   val category: Category,
                   val questionType: QuestionType,
                   val options: List<String>)