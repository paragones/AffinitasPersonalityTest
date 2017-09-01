package affinitas.com.affinitaspersonalitytest.mapper

import affinitas.com.affinitaspersonalitytest.model.Category
import affinitas.com.affinitaspersonalitytest.model.QuestionItem
import affinitas.com.affinitaspersonalitytest.model.QuestionType
import affinitas.com.affinitaspersonalitytest.rest.JsonQuestion
import affinitas.com.affinitaspersonalitytest.rest.PersonalityTestWrapper

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/31/2017.
 */
class PersonalityTestMapper : DataMapper<PersonalityTestWrapper, Pair<List<Category>, List<QuestionItem>>> {

    override fun transform(input: PersonalityTestWrapper): Pair<List<Category>, List<QuestionItem>> {
        return Pair(parseCategories(input.categories),
                parseQuestionItems(input.questions))
    }

    private fun parseCategories(categories: List<String>): List<Category> = categories.map { Category.getCategory(it) }

    private fun parseQuestionItems(questions: List<JsonQuestion>): List<QuestionItem> {
        return questions.mapIndexed { index, it ->
            QuestionItem(index,
                    it.question,
                    Category.getCategory(it.category),
                    QuestionType.getType(it.questionType.type),
                    it.questionType.options)
        }
    }
}
