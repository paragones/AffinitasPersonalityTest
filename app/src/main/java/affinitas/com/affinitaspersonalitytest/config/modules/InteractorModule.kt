package affinitas.com.affinitaspersonalitytest.config.modules

import affinitas.com.affinitaspersonalitytest.config.components.PerActivity
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
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/30/2017.
 */

@Module
class InteractorModule {

    @Provides
    @Singleton
    fun providesInteractor(repository: QuestionnaireRepository): QuestionnaireInteractor = QuestionnaireInteractorImpl(repository)
}