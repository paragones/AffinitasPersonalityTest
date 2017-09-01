package affinitas.com.affinitaspersonalitytest.config.modules

import affinitas.com.affinitaspersonalitytest.mapper.DataMapper
import affinitas.com.affinitaspersonalitytest.mapper.PersonalityTestMapper
import affinitas.com.affinitaspersonalitytest.model.Category
import affinitas.com.affinitaspersonalitytest.model.QuestionItem
import affinitas.com.affinitaspersonalitytest.rest.PersonalityTestWrapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/30/2017.
 */

@Module
class MapperModule {

    @Provides
    @Singleton
    fun providesDataMapper(): DataMapper<PersonalityTestWrapper, Pair<List<Category>, List<QuestionItem>>> = PersonalityTestMapper()

}