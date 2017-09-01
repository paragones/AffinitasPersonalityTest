package affinitas.com.affinitaspersonalitytest.config.modules

import affinitas.com.affinitaspersonalitytest.interactors.QuestionnaireInteractor
import affinitas.com.affinitaspersonalitytest.interactors.QuestionnaireInteractorImpl
import affinitas.com.affinitaspersonalitytest.mapper.DataMapper
import affinitas.com.affinitaspersonalitytest.mapper.PersonalityTestMapper
import affinitas.com.affinitaspersonalitytest.model.Category
import affinitas.com.affinitaspersonalitytest.model.QuestionItem
import affinitas.com.affinitaspersonalitytest.repositories.QuestionnaireRepository
import affinitas.com.affinitaspersonalitytest.repositories.QuestionnaireRepositoryImpl
import affinitas.com.affinitaspersonalitytest.rest.PersonalityTestWrapper
import affinitas.com.affinitaspersonalitytest.rest.QuestionnaireRest
import affinitas.com.affinitaspersonalitytest.services.DatabaseService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/30/2017.
 */

@Module
class ActivityModule {

    @Provides
    @Singleton
    fun providesDataMapper(): DataMapper<PersonalityTestWrapper, Pair<List<Category>, List<QuestionItem>>> = PersonalityTestMapper()

    @Provides
    @Singleton
    fun providesRepository(rest: QuestionnaireRest, databaseService: DatabaseService, mapper: DataMapper<PersonalityTestWrapper, Pair<List<Category>, List<QuestionItem>>>)
            : QuestionnaireRepository = QuestionnaireRepositoryImpl(rest, databaseService, mapper)

    @Provides
    @Singleton
    fun providesInteractor(repository: QuestionnaireRepository): QuestionnaireInteractor = QuestionnaireInteractorImpl(repository)
}